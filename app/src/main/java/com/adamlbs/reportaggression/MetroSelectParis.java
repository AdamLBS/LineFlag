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

public class MetroSelectParis extends AppCompatActivity {

    private SessionHandler session;
    public ImageButton m1, m2, m3, m3bis, m4, m5, m6, m7, m7bis, m8, m9, m10, m11, m12, m13, m14, orlyval;
    private SharedPreferences sharedPreference;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_metro_select_paris);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        m1 = (ImageButton) findViewById(R.id.m1);
        ImageButton m2 = findViewById(R.id.m2);
        ImageButton m3 = findViewById(R.id.m3);
        ImageButton m3bis = findViewById(R.id.m3bis);
        ImageButton m4 = findViewById(R.id.m4);
        ImageButton m5 = findViewById(R.id.m5);
        ImageButton m6 = findViewById(R.id.m6);
        ImageButton m7 = findViewById(R.id.m7);
        ImageButton m7bis = findViewById(R.id.m7bis);
        ImageButton m8 = findViewById(R.id.m8);
        ImageButton m9 = findViewById(R.id.m9);
        ImageButton m10 = findViewById(R.id.m10);
        ImageButton m11 = findViewById(R.id.m11);
        ImageButton m12 = findViewById(R.id.m12);
        ImageButton m13 = findViewById(R.id.m13);
        ImageButton m14 = findViewById(R.id.m14);
        ImageButton orlyval = findViewById(R.id.orlyval);



        m1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "1";
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


        m2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "2";
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
        m3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "3";
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
        m3bis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "3bis";
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
        m4.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "4";
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
        m5.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "5";
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
        m6.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "6";
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
        m7.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "7";
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
        m7bis.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "7bis";
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
        m8.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "8";
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
        m9.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "9";
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
        m10.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "10";
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
        m11.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "11";
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
        m12.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "12";
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
        m13.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "13";
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
        m14.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "14";
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
        orlyval.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "Orlyval";
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