package com.adamlbs.reportaggression;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import butterknife.BindView;

public class DashboardActivity extends AppCompatActivity {
    private SessionHandler session;
    public Spinner spinner1, spinner2;
    public Button btnSubmit, btnMetro, btnTram, btnBus, btnNightBus;
    private SharedPreferences sharedPreference;
    private String text;
    private TextView welcomeText;
    Activity context = this;
    Activity Context = this;

    //TODO Lignes favorites permettant d'avoir sur le dashboard les statistiques de la ligne avec la plus récente aggression
    //TODO Lignes de nuit
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
        findViewsById();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_landscape:
                        Toast.makeText(DashboardActivity.this, "Recents", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_logo:
                        Toast.makeText(DashboardActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        welcomeText.setText("Veuillez sélectionner un type de ligne ");
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                // send it to server
                Log.d("Firebase", "token "+ token);

            }
        });

    }



    private void findViewsById() {
        welcomeText = (TextView) findViewById(R.id.welcomeText2);
    }


    //get the selected dropdown list value
    public void addListenerOnButton() {

        Button btnTram = findViewById(R.id.btnTram);
        Button btnMetro = findViewById(R.id.btnMetro);
        Button btnBus = findViewById(R.id.btnBus);
        Button btnNightBus = findViewById(R.id.btnNightBus);
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
        //           Intent i = new Intent(DashboardActivity.this, ReportActivy.class);
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
