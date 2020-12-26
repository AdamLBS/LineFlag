/*
 * *
 *  * Created by Adam Elaoumari on 26/12/20 00:59
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 19/12/20 21:42
 *
 */

package com.adamlbs.reportaggression;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TransilienParis extends AppCompatActivity {

    public ImageButton h,k,l,n,p,r,u;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transilien_paris);
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
        h = (ImageButton) findViewById(R.id.transH);
        ImageButton j = findViewById(R.id.transJ);
        k = (ImageButton) findViewById(R.id.transK);
        l = (ImageButton) findViewById(R.id.transL);
        n = (ImageButton) findViewById(R.id.transN);
        p = (ImageButton) findViewById(R.id.transP);
        r = (ImageButton) findViewById(R.id.transR);
        u = (ImageButton) findViewById(R.id.transU);
        h.setOnClickListener(v -> {
            text = "H";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );


        j.setOnClickListener(v -> {
            text = "J";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        k.setOnClickListener(v -> {
            text = "K";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        l.setOnClickListener(v -> {
            text = "L";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        n.setOnClickListener(v -> {
            text = "N";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        p.setOnClickListener(v -> {
            text = "P";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        r.setOnClickListener(v -> {
            text = "R";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        u.setOnClickListener(v -> {
            text = "U";
            Bundle bundle = new Bundle();
            BottomSheetDialogParis bottomSheet = new BottomSheetDialogParis();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
    }


}