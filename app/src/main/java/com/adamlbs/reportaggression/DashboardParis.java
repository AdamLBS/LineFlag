/*
 * *
 *  * Created by Adam Elaoumari on 20/11/20 18:20
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/11/20 15:01
 *
 */

package com.adamlbs.reportaggression;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.androidnetworking.AndroidNetworking;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.perf.metrics.AddTrace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DashboardParis extends AppCompatActivity {

    private int firebaseMinimumCode;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    Location gps_loc;
    private static final int MY_REQUEST_CODE = 1;
    Location network_loc;
    Location final_loc;
    double longitude;
    double latitude;
    String userCountry;
    String userAddress;
    Activity context = this;
    AppUpdateManager appUpdateManager;

    //TODO Lignes favorites permettant d'avoir sur le dashboard l es statistiques de la ligne avec la plus récente aggression
    //TODO Lignes de nuit
    @Override
    @AddTrace(name = "onCreateTrace_Paris")
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        appUpdateManager = AppUpdateManagerFactory.create(context);
        Log.d("Updater", "592029");
        enable_update();
        AndroidNetworking.initialize(context);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_paris);
        addListenerOnButton();
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
                userCountry = addresses.get(0).getAdminArea();
                userAddress = addresses.get(0).getAddressLine(0);
                Log.d("LOCATION DEV", "token " + userCountry);

            } else {
                userCountry = "oeoe";
                Log.d("LOCATION DEV", "IDK " + userCountry);

            }
            startupMessage();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String requiredPermission = Manifest.permission.ACCESS_FINE_LOCATION;
        int checkVal = DashboardParis.this.checkCallingOrSelfPermission(requiredPermission);
        if (checkVal == PackageManager.PERMISSION_GRANTED) {
            Log.d("permission granted", "IDK " + userCountry);
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("city", userCountry).apply();
        final FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(view -> ((Application) getApplication()).getShaky().startFeedbackFlow());
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Log.d("1", "Update flow failed! Result code: " + resultCode);
                // If the update is cancelled or fails,
                // you can request to start the update again.
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Mise à jour de l'application");
                builder.setMessage(
                                "\nL'application doit être mise à jour pour être utilisée." +
                                "\n" +
                                "\nCette mise à jour est importante car elle résout des bugs majeurs présents dans votre version de l'application." +
                                "\n"+
                        "\nLa mise à jour sera rapide et vous n'aurez pas besoin de quitter l'application pendant la mise à jour.")
                        .setCancelable(false)
                        .setPositiveButton("Mettre à jour l'application", (dialog, id) -> checkforupdate_high_priority());
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    public void enable_update () {
        int versionCode = BuildConfig.VERSION_CODE;
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .build();
        mFirebaseRemoteConfig.fetch(0);

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            mFirebaseRemoteConfig.getString("maintenance_phone");
                            Log.d("TAG", "Config params updated: " + updated);
                            Log.d("TAG", "Config params A: " + updated);

                            firebaseMinimumCode = (int) mFirebaseRemoteConfig.getLong("MinimumVersionCode");
                            if (firebaseMinimumCode == versionCode) {
                                Log.w("TAG", "no update");
                                Log.w("UpdaterService","No major update has been found, the user should check google play for minor updates");
                            } else {
                                //Retrieve the data entered in the edit texts
                                    checkforupdate_high_priority();
                                Log.w("UpdaterService","Major update found (< MinimumVersion code) starting update flow");

                            }
                        }

                        else {
                            Toast.makeText(DashboardParis.this, "Impossible de vérifier les mises à jour de l'application.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

        }

    private void checkforupdate_high_priority() {
// Creates instance of the manager.


        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(this);

// Returns an intent object that you use to check for an update.
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

// Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE);
            }// For a flexible update, use AppUpdateType.FLEXIBLE
// Request the update.

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
    //get the selected dropdown list value
    public void addListenerOnButton() {

        ImageButton btnTram = findViewById(R.id.btnTram);
        ImageButton btnMetro = findViewById(R.id.btnMetro);
        ImageButton btnTransilien = findViewById(R.id.btnTransilien);
        ImageButton btnRER = findViewById(R.id.btnRER);

        btnRER.setOnClickListener(v -> {

            Intent i = new Intent(DashboardParis.this, RerSelectParis.class);
            startActivity(i);

        }

        );
        btnTransilien.setOnClickListener(v -> {

            Intent i = new Intent(DashboardParis.this, TransilienParis.class);
            startActivity(i);

        }

        );
        btnMetro.setOnClickListener(v -> {

            Intent i = new Intent(DashboardParis.this, MetroSelectParis.class);
            startActivity(i);

        }

        );

        btnTram.setOnClickListener(v -> {

            Intent i = new Intent(DashboardParis.this, TramSelectParis.class);
            startActivity(i);

        }

        );
    }

    private void startupMessage() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("LocationSheet", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("city", userCountry);  // Saving string
        editor.putString("region", userCountry);  // Saving string

        editor.apply();

        boolean firstrun2 = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun2", true);

        if (firstrun2) {

            if (userCountry.equals("Île-de-France")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("LineFlag");
                builder.setMessage("Bienvenue sur LineFlag !" +
                        "\n" +
                        "\nNous avons détecté que vous êtes actuellement à Paris." +
                        "\n" +
                        "\nCette application vous permet de signaler des agressions sur le réseau de la RATP." +
                        "\n" +
                        "\nVous pouvez aussi voir les statistiques de chaque lignes."
                        + "\n"
                        + "\nVous pouvez suggérer de nouvelles villes en cliquant sur le bouton ci-dessous.")
                        .setCancelable(false)
                        .setPositiveButton("OK", (dialog, id) -> {
                        });
                builder.setNegativeButton("Suggérer une ville", (dialog, whichButton) -> {
                    Intent i = new Intent(DashboardParis.this, WebView.class);
                    startActivity(i);
                });


                AlertDialog alert = builder.create();
                alert.show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("LineFlag");
                builder.setMessage("Bienvenue sur LineFlag !" +
                        "\n" +
                        "\nNous avons détecté que vous n'êtes pas localisé à Paris où Marseille." +
                        "\n" +
                        "\nLineFlag est pour l'instant seulement compatible avec les villes de Paris & Marseille." +
                        "\n" +
                        "\nVous pouvez cependant utiliser l'application afin d'étudier son fonctionnement."
                        + "\n"
                        + "\nSi vous souhaitez ajouter votre ville, cliquez sur le bouton ci-dessous."
                        + "\n"
                        + "\nN'hésitez pas à suivre l'évolution de l'application sur notre page Twitter @LineFlagApp.")
                        .setCancelable(false)
                        .setPositiveButton("OK", (dialog, id) -> {
                        });
                builder.setNegativeButton("Suggérer une ville", (dialog, whichButton) -> {
                    Intent i = new Intent(DashboardParis.this, WebView.class);
                    startActivity(i);
                });


                AlertDialog alert = builder.create();
                alert.show();
                //Retrieve the data entered ilogin2();n the edit texts
            }

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstrun2", false)
                    .apply();
        }
    }

}


