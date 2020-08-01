package com.adamlbs.reportaggression;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import butterknife.BindView;
import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {
    private SessionHandler session;
    public Spinner spinner1, spinner2;
    public Button btnSubmit;
    public ImageButton btnMetro, btnTram, btnBus, btnNightBus;
    private String SITE_KEY = "6LeXlQEVAAAAAPK43M8C4Q1yvRtGIJGbagyYZFx1";
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    private SharedPreferences sharedPreference;
    private String text;
    private FusedLocationProviderClient fusedLocationClient;
    private String location;
    private int city;
    private TextView welcomeText;
    Location gps_loc;
    Location network_loc;
    Location final_loc;
    double longitude;
    double latitude;
    String userCountry, userAddress;
    Activity context = this;
    Activity Context = this;

    //TODO Lignes favorites permettant d'avoir sur le dashboard l es statistiques de la ligne avec la plus récente aggression
    //TODO Lignes de nuit
    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
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
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_NETWORK_STATE}, 1);
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                userCountry = addresses.get(0).getLocality();
                userAddress = addresses.get(0).getAddressLine(0);
                Log.d("LOCATION DEV", "token " + userCountry);
                startupMessage();

            } else {
                userCountry = "Unknown";
                Log.d("LOCATION DEV", "IDK " + userCountry);
                startupMessage();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String requiredPermission = Manifest.permission.ACCESS_FINE_LOCATION;
        int checkVal = DashboardActivity.this.checkCallingOrSelfPermission(requiredPermission);
        if (checkVal==PackageManager.PERMISSION_GRANTED){                Log.d("GRANTEEEDDDDDDDDDDDDDDD", "IDK " + userCountry);
        }

        AppRate.with(this)
                .setInstallDays(0) // default 10, 0 means install day.
                .setLaunchTimes(3) // default 10
                .setRemindInterval(2) // default 1
                .setShowLaterButton(true) // default true
                .setDebug(false) // default false
                .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
                    @Override
                    public void onClickButton(int which) {
                        Log.d(DashboardActivity.class.getName(), Integer.toString(which));
                    }
                })
                .monitor();

        // Show a dialog if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this);
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
        boolean firstrun2 = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun2", true);

        if (firstrun2) {

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
                    .putBoolean("firstrun2", false)
                    .apply();
        }    }
}
