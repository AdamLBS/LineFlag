/*
 * *
 *  * Created by Adam Elaoumari on 26/12/20 00:59
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 19/12/20 21:38
 *
 */

package com.adamlbs.reportaggression;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MetroSelectParis extends AppCompatActivity {

    public ImageButton m1;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        Objects.requireNonNull(getSupportActionBar()).hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_metro_select_paris);
        SessionHandler session = new SessionHandler(getApplicationContext());
        session.getUserDetails();
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



        m1.setOnClickListener(v -> {
            text = "1";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );


        m2.setOnClickListener(v -> {
            text = "2";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        m3.setOnClickListener(v -> {
            text = "3";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }


        );
        m3bis.setOnClickListener(v -> {
            text = "3bis";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m4.setOnClickListener(v -> {
            text = "4";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m5.setOnClickListener(v -> {
            text = "5";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m6.setOnClickListener(v -> {
            text = "6";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m7.setOnClickListener(v -> {
            text = "7";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m7bis.setOnClickListener(v -> {
            text = "7bis";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m8.setOnClickListener(v -> {
            text = "8";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m9.setOnClickListener(v -> {
            text = "9";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m10.setOnClickListener(v -> {
            text = "10";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m11.setOnClickListener(v -> {
            text = "11";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m12.setOnClickListener(v -> {
            text = "12";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m13.setOnClickListener(v -> {
            text = "13";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        m14.setOnClickListener(v -> {
            text = "14";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
        orlyval.setOnClickListener(v -> {
            text = "Orlyval";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }
        );
    }
}