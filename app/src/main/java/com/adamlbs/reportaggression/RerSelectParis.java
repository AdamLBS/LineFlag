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

public class RerSelectParis extends AppCompatActivity {

    public ImageButton a, b, c, d, e;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_rer_select_paris);
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
        a = (ImageButton) findViewById(R.id.A);
        b = (ImageButton) findViewById(R.id.B);
        c = (ImageButton) findViewById(R.id.C);
        d = (ImageButton) findViewById(R.id.D);
        e = (ImageButton) findViewById(R.id.E);
        a.setOnClickListener(v -> {
            text = "A";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );


        b.setOnClickListener(v -> {
            text = "B";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );
        c.setOnClickListener(v -> {
            text = "C";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );
        d.setOnClickListener(v -> {
            text = "D";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );
        e.setOnClickListener(v -> {
            text = "E";
            Bundle bundle = new Bundle();

            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );
    }
}