package com.adamlbs.reportaggression;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class DashboardActivity extends AppCompatActivity {
    private SessionHandler session;
    public Spinner spinner1, spinner2;
    public Button btnSubmit;
    public ImageButton btnMetro, btnTram, btnBus, btnNightBus;
    private String  SITE_KEY = "6LeXlQEVAAAAAPK43M8C4Q1yvRtGIJGbagyYZFx1";

    private SharedPreferences sharedPreference;
    private String text;

    private int city;
    private TextView welcomeText;
    Activity context = this;
    Activity Context = this;

    //TODO Lignes favorites permettant d'avoir sur le dashboard les statistiques de la ligne avec la plus récente aggression
    //TODO Lignes de nuit
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        AndroidNetworking.initialize(context);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();;
        
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                // send it to server
                Log.d("Firebase", "token "+ token);

            }
        });
        if (firstrun) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("AR Marseille");
            builder.setMessage("L'application est toujours en développement. Il est possible que des bugs surviennent, n'hésitez pas à les signaler !"+
                    "\n"+
                    "\nVous pouvez aussi faire part de vos suggestions via le Play Store." +
                    "\n" +
                    "\nVous pouvez pour le moment signaler 3 types d'agression : Verbale, physique et sexuelle." +
                    "\n" +
                    "\nN'oubliez pas de suivre notre twitter @AggrReport pour suivre le développement de l'application"
            +"\n"
            + "\nD'autres villes (Paris, Lyon etc...) seront suportées au fil du temps.")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
// setup the alert builder
                    //        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                      //      builder.setTitle("Choisissez une ville");

// add a radio button list
                        //    String[] cities = {"Marseille", "Lyon", "Paris"};
                          //  final int checkedItem = city; // Lyon
                            //builder.setSingleChoiceItems(cities, checkedItem, new DialogInterface.OnClickListener() {
                              //  @Override
                                //public void onClick(DialogInterface dialog2, int which) {
                                    // user checked an item
                             //   }
                            //});

// add OK and Cancel buttons
                            //builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                              //  @Override
                                // public void onClick(DialogInterface dialog2, int which) {
                                    // user clicked OK
                                   // Toast toast=Toast.makeText(getApplicationContext(),"Done ! Thanks."+ city,Toast.LENGTH_SHORT);
                                    // toast.show();
                             //   }
                           // });

// create and show the alert dialog
                           // AlertDialog dialog2 = builder.create();
                           // dialog2.setCancelable(false);
                            //dialog2.setCanceledOnTouchOutside(false);

                            // dialog2.show();
                        }
                    });


            AlertDialog alert = builder.create();
            alert.show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstrun", false)
                    .commit();
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
        //      btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //  btnSubmit.setOnClickListener(new OnClickListener() {
        //                      @Override
        //                    public void onClick(View v) {
        //                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        //                    SharedPreferences.Editor editor = sp.edit();
        //                  String text = spinner1.getSelectedItem().toString();
        //                text = String.valueOf(spinner1.getSelectedItem());
        //               // Save the text in SharedPreference
        //             SharedPreference.save(context, text);

        // Toast.makeText(DashboardActivity.this,
        //       "OnClickListener : " +
        //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
        //   Toast.LENGTH_SHORT).show();
        //           Intent i = new Intent(DashboardActivity.this, /Repo  ctivy.class);
        //         i.putExtra("key", String.valueOf(spinner1.getSelectedItem())); //Optional parameters
        //       startActivity(i);

        //    }

        // public void newActivity(View v) {
        //  }
        // }

        // );
        btnBus.setOnClickListener(new OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          //    SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                          //   SharedPreferences.Editor editor = sp.edit();
                                          //   String text = spinner1.getSelectedItem().toString();
                                          // text = String.valueOf(spinner1.getSelectedItem());
                                          // Save the text in SharedPreference
                                          //  SharedPreference.save(context, text);

                                          // Toast.makeText(DashboardActivity.this,
                                          //       "OnClickListener : " +
                                          //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                                          //   Toast.LENGTH_SHORT).show();
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
                                            //    SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                            //   SharedPreferences.Editor editor = sp.edit();
                                            //   String text = spinner1.getSelectedItem().toString();
                                            // text = String.valueOf(spinner1.getSelectedItem());
                                            // Save the text in SharedPreference
                                            //  SharedPreference.save(context, text);

                                            // Toast.makeText(DashboardActivity.this,
                                            //       "OnClickListener : " +
                                            //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                                            //   Toast.LENGTH_SHORT).show();
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
                                               //    SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                               //   SharedPreferences.Editor editor = sp.edit();
                                               //   String text = spinner1.getSelectedItem().toString();
                                               // text = String.valueOf(spinner1.getSelectedItem());
                                               // Save the text in SharedPreference
                                               //  SharedPreference.save(context, text);

                                               // Toast.makeText(DashboardActivity.this,
                                               //       "OnClickListener : " +
                                               //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                                               //   Toast.LENGTH_SHORT).show();
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
                                           //    SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                           //   SharedPreferences.Editor editor = sp.edit();
                                           //   String text = spinner1.getSelectedItem().toString();
                                           // text = String.valueOf(spinner1.getSelectedItem());
                                           // Save the text in SharedPreference
                                           //  SharedPreference.save(context, text);

                                           // Toast.makeText(DashboardActivity.this,
                                           //       "OnClickListener : " +
                                           //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                                           //   Toast.LENGTH_SHORT).show();
                                           Intent i = new Intent(DashboardActivity.this, TramSelect.class);
                                           startActivity(i);

                                       }

                                       public void newActivity(View v) {
                                       }
                                   }

        );
    }
}
