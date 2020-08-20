/*
 * *
 *  * Created by Adam Elaoumari on 20/08/20 23:15
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/08/20 23:14
 *  
 */

package com.adamlbs.reportaggression;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.nio.channels.spi.AsynchronousChannelProvider.provider;
import static javax.crypto.Cipher.SECRET_KEY;

public class LoginActivity extends AppCompatActivity {
    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";
    private EditText etUsername;
    public String maintenance;
    private EditText etPassword;
    private String username;
    private String password;
    String SITE_KEY = "6LeXlQEVAAAAAPK43M8C4Q1yvRtGIJGbagyYZFx1\n";

    String SECRET_KEY = "6LeXlQEVAAAAAGp4tqerbY0zUNCUf4mYT8vi_pkG";
    private GoogleSignInClient googleSignInClient;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private static final int RC_SIGN_IN = 49404;
    private static final String TAG = LoginActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;
    private String login_url = "https://api.lineflag.com/login.php";
    private SessionHandler session;
    private int currentUser;
    Activity context = this;

//TODO Tout fini ici

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        session = new SessionHandler(getApplicationContext());
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Build a GoogleSignInClient with the options specified by gso.
        if (session.isLoggedIn()) {
            loadDashboard();
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");
        provider.addCustomParameter("lang", "fr");

        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);
        ImageButton signInButton = findViewById(R.id.sign_in_button);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        ImageButton login = findViewById(R.id.btnLogin);
        ImageButton twitter = findViewById(R.id.twitter);
        ImageButton googleButton = findViewById(R.id.sign_in_button);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sign_in_button:

                        googleconfig();
                        break;

                }
            }
        });

        //Launch Registration screen when Register Button is clicked


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                config();

            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                twitterconfig();
            }
        });

    }

    /**
     * Launch Dashboard Activity on Successful Login
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // Take user to log in screen
            Log.d("Firebase", "NOT LOGGED IN");

        } else {
            // User already logged in
            loadDashboard();
        }
        ;
    }

    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }

    private boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(context) != null;
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            loadDashboard();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }

                        // ...
                    }
                });
    }

    /**
     * Display Progress bar while Logging in
     */

    private void login2() {
        username = etUsername.getText().toString().toLowerCase().trim();
        password = etPassword.getText().toString().trim();
        Log.w(TAG, "1");
        if (validateInputs()) {
            login();
        }
    }
    private void config() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .build();
        mFirebaseRemoteConfig.fetch(0);

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.d(TAG, "Config params updated: " + updated);
                            //  Toast.makeText(LoginActivity.this, "Fetch and activate succeeded",
                            //        Toast.LENGTH_SHORT).show();
                            // Toast.makeText(LoginActivity.this, mFirebaseRemoteConfig.getString("maintenance"),
                            //       Toast.LENGTH_SHORT).show();
                            maintenance = mFirebaseRemoteConfig.getString("maintenance");
                            if (maintenance.equals("0")) {
                                Log.w(TAG, "0");
                                Toast.makeText(LoginActivity.this, "La connexion via mail/mot de passe a été désactivée.",
                                        Toast.LENGTH_SHORT).show();
                            } else
                                login2();
                            //Retrieve the data entered in the edit texts
                            }


                         else {
                            Toast.makeText(LoginActivity.this, "Fetch failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void googleconfig() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .build();
        mFirebaseRemoteConfig.fetch(0);

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.d(TAG, "Config params updated: " + updated);
                            //  Toast.makeText(LoginActivity.this, "Fetch and activate succeeded",
                            //        Toast.LENGTH_SHORT).show();
                            // Toast.makeText(LoginActivity.this, mFirebaseRemoteConfig.getString("maintenance"),
                            //       Toast.LENGTH_SHORT).show();
                            maintenance = mFirebaseRemoteConfig.getString("maintenance");
                            if (maintenance.equals("0")) {
                                Log.w(TAG, "0");
                                Toast.makeText(LoginActivity.this, "La connexion via Google a été désactivée.",
                                        Toast.LENGTH_SHORT).show();
                            } else

                                signIn();
                            //Retrieve the data entered in the edit texts
                        }


                        else {
                            Toast.makeText(LoginActivity.this, "Fetch failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void twitterconfig() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .build();
        mFirebaseRemoteConfig.fetch(0);

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.d(TAG, "Config params updated: " + updated);
                            //  Toast.makeText(LoginActivity.this, "Fetch and activate succeeded",
                            //        Toast.LENGTH_SHORT).show();
                            // Toast.makeText(LoginActivity.this, mFirebaseRemoteConfig.getString("maintenance"),
                            //       Toast.LENGTH_SHORT).show();
                            maintenance = mFirebaseRemoteConfig.getString("maintenance");
                            if (maintenance.equals("0")) {
                                Log.w(TAG, "0");
                                Toast.makeText(LoginActivity.this, "La connexion via Twitter a été désactivée.",
                                        Toast.LENGTH_SHORT).show();
                            } else
                                twitterLogin();
                            //Retrieve the data entered in the edit texts
                        }


                        else {
                            Toast.makeText(LoginActivity.this, "Fetch failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

private void twitterLogin() {
    OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");
    provider.addCustomParameter("lang", "fr");
    mAuth
            .startActivityForSignInWithProvider(/* activity= */ this, provider.build())
            .addOnSuccessListener(
                    new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            // User is signed in.
                            // IdP data available in
                            // authResult.getAdditionalUserInfo().getProfile().
                            // The OAuth access token can also be retrieved:
                            // authResult.getCredential().getAccessToken().
                            // The OAuth secret can be retrieved by calling:
                            // authResult.getCredential().getSecret().
                            Log.d(TAG, "signInWithCredential:success");
                            loadDashboard();
                        }
                    })
            .addOnFailureListener(
                    new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Twitter sign in failed", e);
                        }
                    });

}
    private void displayLoader() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Logging In.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    private void login() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_USERNAME, username);
            request.put(KEY_PASSWORD, password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, login_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {
                            //Check if user got logged in successfully

                            if (response.getInt(KEY_STATUS) == 0) {
                                session.loginUser(username,response.getString(KEY_FULL_NAME));
                                loadDashboard();

                            }else{
                                Toast.makeText(getApplicationContext(),
                                        response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if(KEY_EMPTY.equals(username)){
            etUsername.setError("Username cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        if(KEY_EMPTY.equals(password)){
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }
    private void signIn() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

        @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }
}
