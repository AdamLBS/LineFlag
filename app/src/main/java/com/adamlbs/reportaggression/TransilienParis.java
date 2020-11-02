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

public class TransilienParis extends AppCompatActivity {

    private SessionHandler session;
    public ImageButton h,j,k,l,n,p,r,u;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transilien_paris);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        h = (ImageButton) findViewById(R.id.transH);
        ImageButton j = findViewById(R.id.transJ);
        k = (ImageButton) findViewById(R.id.transK);
        l = (ImageButton) findViewById(R.id.transL);
        n = (ImageButton) findViewById(R.id.transN);
        p = (ImageButton) findViewById(R.id.transP);
        r = (ImageButton) findViewById(R.id.transR);
        u = (ImageButton) findViewById(R.id.transU);
        h.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "H";
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


        j.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "J";
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
        k.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "K";
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
        l.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "L";
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
        n.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "N";
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
        p.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "P";
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
        r.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "R";
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
        u.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     text = "U";
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