package com.adamlbs.reportaggression;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.content.SharedPreferences;

public class DashboardActivity extends AppCompatActivity {
    private SessionHandler session;
    public Spinner spinner1, spinner2;
    public Button btnSubmit, btnMetro, btnTram, btnBus, btnNightBus;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

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
