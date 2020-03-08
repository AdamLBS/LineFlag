package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TramSelect extends AppCompatActivity {
    private SessionHandler session;
    public Spinner spinner3, spinner2;
    public Button lineselect, logoutBtn;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busselect);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        String text = spinner3.getSelectedItem().toString();
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapter, View view,
                                       int position, long id) {
                String text = spinner3.getSelectedItem().toString();

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        lineselect = (Button) findViewById(R.id.lineselect);
        Button logoutBtn = findViewById(R.id.btnLogout);

        lineselect.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                              SharedPreferences.Editor editor = sp.edit();
                                              String text = spinner3.getSelectedItem().toString();
                                              text = String.valueOf(spinner3.getSelectedItem());
                                              // Save the text in SharedPreference
                                              SharedPreference.save(context, text);

                                              // Toast.makeText(DashboardActivity.this,
                                              //       "OnClickListener : " +
                                              //             "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()),
                                              //   Toast.LENGTH_SHORT).show();
                                              Intent i = new Intent(TramSelect.this, ReportActivy.class);
                                              i.putExtra("key", String.valueOf(spinner3.getSelectedItem())); //Optional parameters
                                              startActivity(i);

                                          }

                                          public void newActivity(View v) {
                                          }
                                      }

        );


        logoutBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                             SharedPreferences.Editor editor = sp.edit();
                                             String text = spinner3.getSelectedItem().toString();
                                             text = String.valueOf(spinner3.getSelectedItem());
                                             // Save the text in SharedPreference
                                             SharedPreference.save(context, text);
                                             loadStatistics();

                                         }

                                         public void newActivity(View v) {
                                         }
                                     }

        );
    }


    public void loadStatistics() {
        Intent i = new Intent(TramSelect.this, Stats.class);
        i.putExtra("key", String.valueOf(spinner3.getSelectedItem())); //Optional parameters
        startActivity(i);

    }
}
