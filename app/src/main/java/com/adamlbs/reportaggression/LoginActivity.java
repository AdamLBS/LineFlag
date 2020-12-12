/*
 * *
 *  * Created by Adam Elaoumari on 13/12/20 00:23
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 13/12/20 00:23
 *  
 */

package com.adamlbs.reportaggression;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    private String number;
    private static final int MY_REQUEST_CODE = 1;

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
    Location gps_loc;
    Location network_loc;
    Location final_loc;
    double longitude;
    double latitude;
    String userCountry, userAddress;
//TODO Tout fini ici

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Location", MODE_PRIVATE);
        String city = pref.getString("city", null);         // getting String
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        try {

            gps_loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            network_loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (gps_loc != null) {
            final_loc = gps_loc;
            latitude = final_loc.getLatitude();
            longitude = final_loc.getLongitude();
        } else if (network_loc != null) {
            final_loc = network_loc;
            latitude = final_loc.getLatitude();
            longitude = final_loc.getLongitude();
        } else {
            latitude = 0.0;
            longitude = 0.0;
        }
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                userCountry = addresses.get(0).getLocality();
                userAddress = addresses.get(0).getAdminArea();
                Log.d("LOCATION DEV", "token " + userCountry);

            } else {
                userCountry = "oeoe";
                Log.d("LOCATION DEV", "IDK " + userCountry);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String requiredPermission = Manifest.permission.ACCESS_FINE_LOCATION;
        int checkVal = LoginActivity.this.checkCallingOrSelfPermission(requiredPermission);
        if (checkVal == PackageManager.PERMISSION_GRANTED) {
            Log.d("permission granted", "IDK " + userCountry);
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("city", userCountry).apply();


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
        ImageButton phoneButton = findViewById(R.id.phone);

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

        //Launch SMS screen when Register Button is clicked
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config_phone();
            }
        });

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
        final FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Application) getApplication()).getShaky().startFeedbackFlow();

                }
            });
        }
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

    private void checkforupdate() {
// Creates instance of the manager.


        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);

// Returns an intent object that you use to check for an update.
        com.google.android.play.core.tasks.Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    // For a flexible update, use AppUpdateType.FLEXIBLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                // Request the update.
            }

            try {
                appUpdateManager.startUpdateFlowForResult(
                        // Pass the intent that is returned by 'getAppUpdateInfo()'.
                        appUpdateInfo,
                        // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
                        AppUpdateType.IMMEDIATE,
                        // The current activity making the update request.
                        this,
                        // Include a request code to later monitor this update request.
                        MY_REQUEST_CODE);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }

        });


    }

    private void loadDashboard() {
        if (Objects.equals(userCountry, "Marseille")) {
            Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(i);
            finish();
        } else {
            loadDashboardParis();
        }

    }

    private boolean isSignedIn() {
        return GoogleSignIn.getLastSignedInAccount(context) != null;
    }
    private void loadDashboardParis() {
        Intent i = new Intent(getApplicationContext(), DashboardParis.class);
        startActivity(i);
        finish();
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

    private void phonelogin() {
        Log.w(TAG, "1");
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Se connecter par SMS");
        alert.setMessage("Veuillez entrer votre numéro de téléphone."+
                "\n" +
                "\nDes frais standard peuvent s'appliquer lors de la réception du SMS." );

// Set an EditText view to get user input
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        alert.setView(input);
        final String prefix = "+33";
        input.setText(prefix);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                number = input.getText().toString().toLowerCase().trim();;

                phone();


            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    private void phone() {
        ProgressDialog dialog = ProgressDialog.show(LoginActivity.this, "En attente du SMS de vérification",
                "Veuillez patienter...", true);
        PhoneAuthProvider.OnVerificationStateChangedCallbacks     mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            private PhoneAuthProvider.ForceResendingToken mResendToken;
            String mVerificationId;
            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:" + credential);

                signInWithPhoneAuthCredential(credential);
            }
            @Override
            public void onVerificationFailed(FirebaseException e) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {

                    dialog.dismiss();
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    Toast.makeText(LoginActivity.this, "Veuillez contacter @LineFlagApp sur Twitter où secouer votre téléphone.. ",
                            Toast.LENGTH_SHORT).show();
                    dialog.dismiss();

                }

                Toast.makeText(LoginActivity.this, "Impossible de vous connecter par téléphone. Veuillez secouer votre téléphone pour signaler un bug. ",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
            }
        };;        // OnVerificationStateChangedCallbacks

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);

    }

    private void login2() {
        username = etUsername.getText().toString().toLowerCase().trim();
        password = etPassword.getText().toString().trim();
        Log.w(TAG, "1");
        if (validateInputs()) {
            login();
        }

  }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            loadDashboard();
                        } else {
                            Toast.makeText(LoginActivity.this, "Impossible de vous connecter par téléphone. Veuillez secouer votre téléphone pour signaler ce problème.",
                                    Toast.LENGTH_SHORT).show();

                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }
    private void config_phone() {
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
                            maintenance = mFirebaseRemoteConfig.getString("maintenance_phone");
                            if (maintenance.equals("0")) {
                                Log.w(TAG, "0");
                                Toast.makeText(LoginActivity.this, "La connexion via SMS a été désactivée pour une maintenance.",
                                        Toast.LENGTH_SHORT).show();
                            } else
                                phonelogin();
                            //Retrieve the data entered in the edit texts
                        }


                        else {
                            Toast.makeText(LoginActivity.this, "Erreur. Veuillez secouer votre téléphone pour signaler cette erreur.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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
                            Toast.makeText(LoginActivity.this, "Erreur. Veuillez réessayer ultérieurement..",
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
                            Toast.makeText(LoginActivity.this, "Erreur. Veuillez secouer votre téléphone pour signaler cette erreur.",
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
                            Toast.makeText(LoginActivity.this, "Erreur. Veuillez secouer votre téléphone pour signaler cette erreur.",
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
                        Toast.makeText(LoginActivity.this, "Impossible de contacter le serveur d'authentification... Veuillez réssayer ultérieurement. ",
                                Toast.LENGTH_SHORT).show();
                    }
                    }) {

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("User-Agent", "LineFlag-App");
                        params.put("language", "fr");

                        return params;
                    }
                };

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
            if (requestCode == MY_REQUEST_CODE) {
                if (resultCode != RESULT_OK) {
                    Log.d("1", "Update flow failed! Result code: " + resultCode);
                    // If the update is cancelled or fails,
                    // you can request to start the update again.
                }
            }
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
