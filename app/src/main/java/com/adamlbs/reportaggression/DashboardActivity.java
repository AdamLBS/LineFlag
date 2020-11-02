/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:03
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 00:43
 *
 */

package com.adamlbs.reportaggression;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.perf.metrics.AddTrace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    private static final int HIGH_PRIORITY_UPDATE = 5;
    private SessionHandler session;
    public Spinner spinner1, spinner2;
    public Button btnSubmit;
    public ImageButton btnMetro, btnTram, btnBus, btnNightBus;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    private SharedPreferences sharedPreference;
    private String text;
    private FusedLocationProviderClient fusedLocationClient;
    private String location;
    private int city;
    private String maintenance;
    private TextView welcomeText;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private int firebaseMinimumCode;
    Location gps_loc;
    Location network_loc;
    Location final_loc;
    private static final int MY_REQUEST_CODE = 1;
    double longitude;
    double latitude;
    String userCountry, userAddress;
    Activity context = this;
    Activity Context = this;

    //TODO Lignes favorites permettant d'avoir sur le dashboard l es statistiques de la ligne avec la plus récente aggression
    //TODO Lignes de nuit
    @Override
    @AddTrace(name = "onCreateTrace_Marseille", enabled = true /* optional */)
    public void onCreate(Bundle savedInstanceState) {
        enable_update();
        Log.d("Updater", "592029");

        setTheme(R.style.AppTheme);
        AndroidNetworking.initialize(context);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                // send it to server
                Log.d("Firebase", "token " + token);

            }
        });
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
                userAddress = addresses.get(0).getAddressLine(0);
                Log.d("LOCATION DEV", "token " + userCountry);
                startupMessage();

            } else {
                userCountry = "oeoe";
                Log.d("LOCATION DEV", "IDK " + userCountry);
                startupMessage();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String requiredPermission = Manifest.permission.ACCESS_FINE_LOCATION;
        int checkVal = DashboardActivity.this.checkCallingOrSelfPermission(requiredPermission);
        if (checkVal == PackageManager.PERMISSION_GRANTED) {
            Log.d("permission granted", "IDK " + userCountry);
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("city", userCountry).apply();
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
                        .setPositiveButton("Mettre à jour l'application", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                checkforupdate_high_priority();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    public void enable_update () {
        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .build();
        mFirebaseRemoteConfig.fetch(0);

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<Boolean> task) {
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
                            Toast.makeText(DashboardActivity.this, "Impossible de vérifier les mises à jour de l'application.",
                                    Toast.LENGTH_SHORT).show();
                        }
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

    //get the selected dropdown list value
    public void addListenerOnButton() {

        ImageButton btnTram = findViewById(R.id.btnTram);
        ImageButton btnMetro = findViewById(R.id.btnMetro);
        ImageButton btnBus = findViewById(R.id.btnBus);
        ImageButton btnNightBus = findViewById(R.id.btnNightBus);

        btnBus.setOnClickListener(new OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Intent i = new Intent(DashboardActivity.this, BusSelect.class);
                                          startActivity(i);

                                      }

                                      public void newActivity(View v) {
                                      }
                                  }

        );

        btnMetro.setOnClickListener(new OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Intent i = new Intent(DashboardActivity.this, MetroSelect.class);
                                            startActivity(i);

                                        }

                                        public void newActivity(View v) {
                                        }
                                       }

        );

        btnNightBus.setOnClickListener(new OnClickListener() {
                                           @Override
                                           public void onClick(View v) {

                                               Intent i = new Intent(DashboardActivity.this, NightBusSelect.class);
                                               startActivity(i);

                                           }

                                           public void newActivity(View v) {
                                           }
                                       }

        );
        btnTram.setOnClickListener(new OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           Intent i = new Intent(DashboardActivity.this, TramSelect.class);
                                           startActivity(i);

                                       }

                                       public void newActivity(View v) {
                                       }
                                   }

        );
    }
    private void startupMessage() {
        boolean firstrun3 = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun3", true);

        if (firstrun3) {

            if (userCountry.equals("Marseille")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("LineFlag");
                builder.setMessage("Bienvenue sur LineFlag !" +
                        "\n" +
                        "\nNous avons détecté que vous êtes actuellement à Marseille." +
                        "\n" +
                        "\nCette application vous permet de signaler des agressions sur le réseau de la RTM." +
                        "\n" +
                        "\nVous pouvez aussi voir les statistiques de chaque lignes."
                        + "\n"
                        + "\nVous pouvez suggérer de nouvelles villes en cliquant sur le bouton ci-dessous.")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.setNegativeButton("Suggérer une ville", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent i = new Intent(DashboardActivity.this, com.adamlbs.reportaggression.WebView.class);
                        startActivity(i);
                    }
                });


                AlertDialog alert = builder.create();
                alert.show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("LineFlag");
                builder.setMessage("Bienvenue sur LineFlag !" +
                        "\n" +
                        "\nNous avons détecté que vous n'êtes pas localisé à Marseille." +
                        "\n" +
                        "\nLineFlag est pour l'instant seulement compatible avec la ville de Marseille." +
                        "\n" +
                        "\nVous pouvez cependant utiliser l'application afin d'étudier son fonctionnement."
                        + "\n"
                        + "\nSi vous souhaitez ajouter votre ville, cliquez sur le bouton ci-dessous."
                        + "\n"
                        + "\nN'hésitez pas à suivre l'évolution de l'application sur notre page Twitter @LineFlagApp.")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.setNegativeButton("Suggérer une ville", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent i = new Intent(DashboardActivity.this, com.adamlbs.reportaggression.WebView.class);
                        startActivity(i);
                    }
                });


                AlertDialog alert = builder.create();
                alert.show();
                //Retrieve the data entered ilogin2();n the edit texts
            }

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstrun3", false)
                    .apply();
        }    }

}
