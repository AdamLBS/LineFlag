/*
 * *
 *  * Created by Adam Elaoumari on 20/11/20 18:20
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/11/20 16:04
 *
 */

package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RerSelectParis extends AppCompatActivity {

    private SessionHandler session;
    public ImageButton a, b, c, d, e;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_rer_select_paris);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
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

    //get the selected dropdown list value
    public void addListenerOnButton() {
        a = (ImageButton) findViewById(R.id.A);
        b = (ImageButton) findViewById(R.id.B);
        c = (ImageButton) findViewById(R.id.C);
        d = (ImageButton) findViewById(R.id.D);
        e = (ImageButton) findViewById(R.id.E);
        a.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "A";
                                      Bundle bundle = new Bundle();

                                      BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");

                                  }


                                  public void newActivity(View v) {
                                  }
                              }

        );


        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "B";
                                     Bundle bundle = new Bundle();

                                     BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
                                     bundle.putString("text", text);
                                     bottomSheet.setArguments(bundle);
                                     bottomSheet.show(getSupportFragmentManager(),"text");

                                 }


                                 public void newActivity(View v) {
                                 }
                             }

        );
        c.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "C";
                                     Bundle bundle = new Bundle();

                                     BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
                                     bundle.putString("text", text);
                                     bottomSheet.setArguments(bundle);
                                     bottomSheet.show(getSupportFragmentManager(),"text");

                                 }


                                 public void newActivity(View v) {
                                 }
                             }

        );
        d.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "D";
                                     Bundle bundle = new Bundle();

                                     BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
                                     bundle.putString("text", text);
                                     bottomSheet.setArguments(bundle);
                                     bottomSheet.show(getSupportFragmentManager(),"text");

                                 }


                                 public void newActivity(View v) {
                                 }
                             }

        );
        e.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "E";
                                     Bundle bundle = new Bundle();

                                     BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
                                     bundle.putString("text", text);
                                     bottomSheet.setArguments(bundle);
                                     bottomSheet.show(getSupportFragmentManager(),"text");

                                 }


                                 public void newActivity(View v) {
                                 }
                             }

        );
    }
}