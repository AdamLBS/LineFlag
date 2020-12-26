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

public class NightBusSelect extends AppCompatActivity {
    public ImageButton b3, b145, b509,b518, b521,b526,b530,b533,b535,b540,b582,b583;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nightbusselect);
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
        b3 = (ImageButton) findViewById(R.id.b3);
        b145 = (ImageButton) findViewById(R.id.b145);
        b509 = (ImageButton) findViewById(R.id.b509);
        b518 = (ImageButton) findViewById(R.id.b518);
        b521 = (ImageButton) findViewById(R.id.b521);
        b526 = (ImageButton) findViewById(R.id.b526);
        b530 = (ImageButton) findViewById(R.id.b530);
        b533 = (ImageButton) findViewById(R.id.b533);
        b535 = (ImageButton) findViewById(R.id.b535);
        b540 = (ImageButton) findViewById(R.id.b540);
        b582 = (ImageButton) findViewById(R.id.b582);
        b583 = (ImageButton) findViewById(R.id.b583);

        b3.setOnClickListener(v -> {
            text = "B3";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );


        b145.setOnClickListener(v -> {
            text = "145";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b509.setOnClickListener(v -> {
            text = "509";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b518.setOnClickListener(v -> {
            text = "518";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b521.setOnClickListener(v -> {
                    text = "521";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b526.setOnClickListener(v -> {
            text = "526";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b530.setOnClickListener(v -> {
            text = "530";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b533.setOnClickListener(v -> {
            text = "533";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b535.setOnClickListener(v -> {
            text = "535";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b540.setOnClickListener(v -> {
            text = "540";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b582.setOnClickListener(v -> {
            text = "582";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b583.setOnClickListener(v -> {
            text = "583";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
    }


}
