/*
 * *
 *  * Created by Adam Elaoumari on 20/11/20 18:20
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/11/20 16:04
 *
 */

package com.adamlbs.reportaggression;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MetroSelect extends AppCompatActivity {
    public ImageButton m1;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        Objects.requireNonNull(getSupportActionBar()).hide();

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_metroselect);
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
        m1.setOnClickListener(v -> {
            text = "M1";
            Bundle bundle = new Bundle();

            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");

        }

        );


        m2.setOnClickListener(v -> {
            text = "M2";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
    }
}