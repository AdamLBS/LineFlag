/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:03
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 00:43
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