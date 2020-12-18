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

import java.util.Objects;

public class MetroSelectParis extends AppCompatActivity {

    private SessionHandler session;
    public ImageButton m1;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        Objects.requireNonNull(getSupportActionBar()).hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_metro_select_paris);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
        addListenerOnButton();
        final FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(view -> ((Application) getApplication()).getShaky().startFeedbackFlow());
        }
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


                                  public void newActivity() {
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


                                  public void newActivity() {
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


                                  public void newActivity() {
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


            public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
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


                                     public void newActivity() {
                                     }
                                 }
        );
    }
}