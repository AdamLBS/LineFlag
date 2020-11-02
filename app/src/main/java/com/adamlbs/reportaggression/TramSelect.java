/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:03
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 00:42
 *
 */

package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TramSelect extends AppCompatActivity {
    private SessionHandler session;
    public ImageButton t1, t2,t3;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramselect);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        t1 = (ImageButton) findViewById(R.id.t1);
        ImageButton t2 = findViewById(R.id.t2);
        t3 = (ImageButton) findViewById(R.id.t3);
        t1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "T1";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );


        t2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "T2";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        t3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "T3";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
    }


    public void loadStatistics() {
        Intent i = new Intent(TramSelect.this, Stats.class);
        i.putExtra("key", text); //Optional parameters
        startActivity(i);

    }
}
