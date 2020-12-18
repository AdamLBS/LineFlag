/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:03
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 00:43
 *
 */

package com.adamlbs.reportaggression;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private static final String KEY_STATUS = "status";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMPTY = "";
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etFullName;
    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private ProgressDialog pDialog;
    private String register_url = "https://api.aggressionreport.fr/register.php";
    private SessionHandler session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        session = new SessionHandler(getApplicationContext());
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);

        ImageButton login = findViewById(R.id.btnRegisterLogin);
        ImageButton register = findViewById(R.id.btnRegister);

        //Launch Login screen when Login Button is clicked
        login.setOnClickListener(v -> {
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });

        register.setOnClickListener(v -> {
            //Retrieve the data entered in the edit texts
            username = etUsername.getText().toString().toLowerCase().trim();
            password = etPassword.getText().toString().trim();
            confirmPassword = etConfirmPassword.getText().toString().trim();
            fullName = etFullName.getText().toString().trim();
            if (validateInputs()) {
                registerUser();
            }

        });

    }

    /**
     * Display Progress bar while registering
     */
    private void displayLoader() {
        pDialog = new ProgressDialog(RegisterActivity.this);
        pDialog.setMessage("Signing Up.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    /**
     * Launch Dashboard Activity on Successful Sign Up
     */
    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }

    private void registerUser() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(KEY_USERNAME, username);
            request.put(KEY_PASSWORD, password);
            request.put(KEY_FULL_NAME, fullName);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, register_url, request, response -> {
                    pDialog.dismiss();
                    try {
                        //Check if user got registered successfully
                        if (response.getInt(KEY_STATUS) == 0) {
                            //Set the user session
                            session.loginUser(username,fullName);
                            loadDashboard();

                        }else if(response.getInt(KEY_STATUS) == 1){
                            //Display error message if username is already existsing
                            etUsername.setError("Username already taken!");
                            etUsername.requestFocus();

                        }else{
                            Toast.makeText(getApplicationContext(),
                                    response.getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    pDialog.dismiss();

                    //Display error message whenever an error occurs
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_SHORT).show();

                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private boolean validateInputs() {
        if (KEY_EMPTY.equals(fullName)) {
            etFullName.setError("Full Name cannot be empty");
            etFullName.requestFocus();
            return false;

        }
        if (KEY_EMPTY.equals(username)) {
            etUsername.setError("Username cannot be empty");
            etUsername.requestFocus();
            return false;
        }
        if (KEY_EMPTY.equals(password)) {
            etPassword.setError("Password cannot be empty");
            etPassword.requestFocus();
            return false;
        }

        if (KEY_EMPTY.equals(confirmPassword)) {
            etConfirmPassword.setError("Confirm Password cannot be empty");
            etConfirmPassword.requestFocus();
            return false;
        }
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Password and Confirm Password does not match");
            etConfirmPassword.requestFocus();
            return false;
        }

        return true;
    }
}
