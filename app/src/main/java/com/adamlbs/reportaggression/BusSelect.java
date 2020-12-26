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

public class BusSelect  extends AppCompatActivity {
    private ImageButton b1,b1jet,b1s,b2,b3b,b4,b4b,b5,b6,b7,b7b,b7t,b9,b10,b11,b12,b12a,b12b,b12s,b15,b15s,b16,b16s,b16t,b17,b18,b19,b20,b21jet,b22,b22s,b23,b24,b24b,b24t,b25,b27,b28,b28b,b30,b31,b32,b33,b33s,b34,b35,b35s,b35t,b36,b36b,b37,b37a,b37s,b38,b39,b40,b41,b42,b42t,b44,b45,b46,b46s,b47,b48,b48t,b49,b50,b51,b52,b53,b54,b55,b56,b60,b61,b67,b70,b72,b73,b74,b80,b81,b82,b82s,b83,b84,b86,b88,b89,b91,b96,b97,b98,b121,b122,b142,b142s,b143,b144,b144s,bb1,bb2,bb3,bb3a;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busselect);
        b1 = (ImageButton) findViewById(R.id.b1);
        b1jet = (ImageButton) findViewById(R.id.b1jet);
        b1s = (ImageButton) findViewById(R.id.b1s);
        b2 = (ImageButton) findViewById(R.id.b2);
        b3b = (ImageButton) findViewById(R.id.bb3b);
        b4 = (ImageButton) findViewById(R.id.b4);
        b4b = (ImageButton) findViewById(R.id.b4b);
        b5 = (ImageButton) findViewById(R.id.b5);
        b6 = (ImageButton) findViewById(R.id.b6);
        b7 = (ImageButton) findViewById(R.id.b7);
        b7b = (ImageButton) findViewById(R.id.b7b);
        b7t = (ImageButton) findViewById(R.id.b7t);
        b9 = (ImageButton) findViewById(R.id.b9);
        b10 = (ImageButton) findViewById(R.id.b10);
        b11 = (ImageButton) findViewById(R.id.b11);
        b12 = (ImageButton) findViewById(R.id.b12);
        b12a = (ImageButton) findViewById(R.id.b12a);
        b12b = (ImageButton) findViewById(R.id.b12b);
        b12s = (ImageButton) findViewById(R.id.b12s);
        b15 = (ImageButton) findViewById(R.id.b15);
        b15s = (ImageButton) findViewById(R.id.b15s);
        b16 = (ImageButton) findViewById(R.id.b16);
        b16s = (ImageButton) findViewById(R.id.b16s);
        b16t = (ImageButton) findViewById(R.id.b16t);
        b17 = (ImageButton) findViewById(R.id.b17);
        b18 = (ImageButton) findViewById(R.id.b18);
        b19 = (ImageButton) findViewById(R.id.b19);
        b20 = (ImageButton) findViewById(R.id.b20);
        b21jet = (ImageButton) findViewById(R.id.b21jet);
        b22 = (ImageButton) findViewById(R.id.b22);
        b22s = (ImageButton) findViewById(R.id.b22s);
        b23 = (ImageButton) findViewById(R.id.b23);
        b24 = (ImageButton) findViewById(R.id.b24);
        b24b = (ImageButton) findViewById(R.id.b24b);
        b24t = (ImageButton) findViewById(R.id.b24t);
        b25 = (ImageButton) findViewById(R.id.b25);
        b27 = (ImageButton) findViewById(R.id.b27);
        b28 = (ImageButton) findViewById(R.id.b28);
        b28b = (ImageButton) findViewById(R.id.b28b);
        b30 = (ImageButton) findViewById(R.id.b30);
        b31 = (ImageButton) findViewById(R.id.b31);
        b32 = (ImageButton) findViewById(R.id.b32);
        b33 = (ImageButton) findViewById(R.id.b33);
        b33s = (ImageButton) findViewById(R.id.b33s);
        b34 = (ImageButton) findViewById(R.id.b34);
        b35 = (ImageButton) findViewById(R.id.b35);
        b35s = (ImageButton) findViewById(R.id.b35s);
        b35t = (ImageButton) findViewById(R.id.b35t);
        b36 = (ImageButton) findViewById(R.id.b36);
        b36b = (ImageButton) findViewById(R.id.b36b);
        b37 = (ImageButton) findViewById(R.id.b37);
        b37a = (ImageButton) findViewById(R.id.b37a);
        b37s = (ImageButton) findViewById(R.id.b37s);
        b38 = (ImageButton) findViewById(R.id.b38);
        b39 = (ImageButton) findViewById(R.id.b39);
        b40 = (ImageButton) findViewById(R.id.b40);
        b41 = (ImageButton) findViewById(R.id.b41);
        b42 = (ImageButton) findViewById(R.id.b42);
        b44 = (ImageButton) findViewById(R.id.b44);
        b42t = (ImageButton) findViewById(R.id.b42t);
        b45 = (ImageButton) findViewById(R.id.b45);
        b46 = (ImageButton) findViewById(R.id.b46);
        b46s = (ImageButton) findViewById(R.id.b46s);
        b47 = (ImageButton) findViewById(R.id.b47);
        b48 = (ImageButton) findViewById(R.id.b48);
        b48t = (ImageButton) findViewById(R.id.b48t);
        b49 = (ImageButton) findViewById(R.id.b49);
        b50 = (ImageButton) findViewById(R.id.b50);
        b51 = (ImageButton) findViewById(R.id.b51);
        b52 = (ImageButton) findViewById(R.id.b52);
        b53 = (ImageButton) findViewById(R.id.b53);
        b54 = (ImageButton) findViewById(R.id.b54);
        b55 = (ImageButton) findViewById(R.id.b55);
        b56 = (ImageButton) findViewById(R.id.b56);
        b60 = (ImageButton) findViewById(R.id.b60);
        b61 = (ImageButton) findViewById(R.id.b61);
        b67 = (ImageButton) findViewById(R.id.b67);
        b70 = (ImageButton) findViewById(R.id.b70);
        b72 = (ImageButton) findViewById(R.id.b72);
        b73 = (ImageButton) findViewById(R.id.b73);
        b74 = (ImageButton) findViewById(R.id.b74);
        b80 = (ImageButton) findViewById(R.id.b80);
        b81 = (ImageButton) findViewById(R.id.b81);
        b82 = (ImageButton) findViewById(R.id.b82);
        b82s = (ImageButton) findViewById(R.id.b82s);
        b83 = (ImageButton) findViewById(R.id.b83);
        b84 = (ImageButton) findViewById(R.id.b84);
        b86 = (ImageButton) findViewById(R.id.b86);
        b88 = (ImageButton) findViewById(R.id.b88);
        b89 = (ImageButton) findViewById(R.id.b89);
        b91 = (ImageButton) findViewById(R.id.b91);
        b96 = (ImageButton) findViewById(R.id.b96);
        b97 = (ImageButton) findViewById(R.id.b97);
        b98 = (ImageButton) findViewById(R.id.b98);
        b121 = (ImageButton) findViewById(R.id.b121);
        b122 = (ImageButton) findViewById(R.id.b122);
        b142 = (ImageButton) findViewById(R.id.b142);
        b142s = (ImageButton) findViewById(R.id.b142s);
        b143 = (ImageButton) findViewById(R.id.b143);
        b144 = (ImageButton) findViewById(R.id.b144);
        b144s = (ImageButton) findViewById(R.id.b144s);
        bb1 = (ImageButton) findViewById(R.id.bb1);
        bb2 = (ImageButton) findViewById(R.id.bb2);
        bb3 = (ImageButton) findViewById(R.id.bb3);
        bb3a = (ImageButton) findViewById(R.id.bb3a);
        addListenerOnButton();
        final FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(view -> ((Application) getApplication()).getShaky().startFeedbackFlow());
        }
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        b1.setOnClickListener(v -> {
            text = "1";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );


        b2.setOnClickListener(v -> {
            text = "2";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }


        );
        b1jet.setOnClickListener(v -> {
            text = "1Jet";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }


        );
        b1s.setOnClickListener(v -> {
            text = "1S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b2.setOnClickListener(v -> {
            text = "2";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b3b.setOnClickListener(v -> {
            text = "B3B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        bb3a.setOnClickListener(v -> {
            text = "B3A";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        bb1.setOnClickListener(v -> {
            text = "B1";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        bb2.setOnClickListener(v -> {
            text = "B2";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        bb3.setOnClickListener(v -> {
            text = "3";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b4.setOnClickListener(v -> {
            text = "4";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b4b.setOnClickListener(v -> {
            text = "4B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b5.setOnClickListener(v -> {
            text = "5";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b6.setOnClickListener(v -> {
            text = "6";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b7.setOnClickListener(v -> {
            text = "7";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b7b.setOnClickListener(v -> {
            text = "7B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b7t.setOnClickListener(v -> {
            text = "7T";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b9.setOnClickListener(v -> {
            text = "9";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b10.setOnClickListener(v -> {

            text = "10";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b11.setOnClickListener(v -> {
            text = "11";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b12.setOnClickListener(v -> {

            text = "12";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b12a.setOnClickListener(v -> {

            text = "12A";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b12b.setOnClickListener(v -> {
            text = "12S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b12s.setOnClickListener(v -> {
            text = "12S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(), "text");
        });
        b15.setOnClickListener(v -> {
            text = "15";

            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b15s.setOnClickListener(v -> {
            text = "15S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b16.setOnClickListener(v -> {
            text = "16";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b16s.setOnClickListener(v -> {
            text = "16S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b16t.setOnClickListener(v -> {
            text = "16T";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b17.setOnClickListener(v -> {
            text = "17";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b18.setOnClickListener(v -> {
            text = "18";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b19.setOnClickListener(v -> {

            text = "19";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b20.setOnClickListener(v -> {
            text = "20";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b21jet.setOnClickListener(v -> {
            text = "21Jet";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b22.setOnClickListener(v -> {
            text = "22";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b22s.setOnClickListener(v -> {
            text = "22S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b23.setOnClickListener(v -> {
            text = "23";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b24.setOnClickListener(v -> {
            text = "24";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b24b.setOnClickListener(v -> {
            text = "24B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b24t.setOnClickListener(v -> {
            text = "24T";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b25.setOnClickListener(v -> {
            text = "25";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b27.setOnClickListener(v -> {
            text = "27";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b28.setOnClickListener(v -> {
            text = "28";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b28b.setOnClickListener(v -> {
            text = "28B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b30.setOnClickListener(v -> {
            text = "30";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b31.setOnClickListener(v -> {
            text = "31";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b32.setOnClickListener(v -> {
            text = "32";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b33.setOnClickListener(v -> {
            text = "33";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b33s.setOnClickListener(v -> {
            text = "33s";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b34.setOnClickListener(v -> {
            text = "34";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b35.setOnClickListener(v -> {
            text = "35";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b35s.setOnClickListener(v -> {
            text = "35s";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b35t.setOnClickListener(v -> {
            text = "35t";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b36.setOnClickListener(v -> {
            text = "36";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b36b.setOnClickListener(v -> {
            text = "36B";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b37.setOnClickListener(v -> {
            text = "37";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b37a.setOnClickListener(v -> {
            text = "37A";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b37s.setOnClickListener(v -> {
            text = "37S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b38.setOnClickListener(v -> {
            text = "38";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b39.setOnClickListener(v -> {
            text = "39";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b40.setOnClickListener(v -> {

            text = "40";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b41.setOnClickListener(v -> {
            text = "41";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b42.setOnClickListener(v -> {
            text = "42";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b42t.setOnClickListener(v -> {
            text = "42T";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b44.setOnClickListener(v -> {
            text = "44";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b45.setOnClickListener(v -> {
            text = "45";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b46.setOnClickListener(v -> {
            text = "46";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b46s.setOnClickListener(v -> {
            text = "46S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b47.setOnClickListener(v -> {

            text = "47";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b48.setOnClickListener(v -> {
            text = "48";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b48t.setOnClickListener(v -> {
            text = "48T";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b49.setOnClickListener(v -> {
            text = "49";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b50.setOnClickListener(v -> {
            text = "50";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b51.setOnClickListener(v -> {
            text = "51";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b52.setOnClickListener(v -> {
            text = "52";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b53.setOnClickListener(v -> {
            text = "53";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b54.setOnClickListener(v -> {
            text = "54";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b55.setOnClickListener(v -> {
            text = "55";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b56.setOnClickListener(v -> {
            text = "56";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b60.setOnClickListener(v -> {
            text = "60";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b61.setOnClickListener(v -> {
            text = "61";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b67.setOnClickListener(v -> {
            text = "67";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b70.setOnClickListener(v -> {
            text = "70";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b72.setOnClickListener(v -> {
            text = "72";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b73.setOnClickListener(v -> {
            text = "73";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b74.setOnClickListener(v -> {
            text = "74";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b80.setOnClickListener(v -> {
            text = "80";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b81.setOnClickListener(v -> {
            text = "81";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b82.setOnClickListener(v -> {
            text = "82";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b82s.setOnClickListener(v -> {
            text = "82S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b83.setOnClickListener(v -> {
            text = "83";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b84.setOnClickListener(v -> {
            text = "84";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b86.setOnClickListener(v -> {
            text = "86";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b88.setOnClickListener(v -> {
            text = "88";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b89.setOnClickListener(v -> {
            text = "89";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b91.setOnClickListener(v -> {
            text = "91";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b96.setOnClickListener(v -> {
            text = "96";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b97.setOnClickListener(v -> {
            text = "97";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b98.setOnClickListener(v -> {
            text = "98";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b121.setOnClickListener(v -> {
            text = "121";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b122.setOnClickListener(v -> {
            text = "122";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b142.setOnClickListener(v -> {
            text = "142";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b142s.setOnClickListener(v -> {
            text = "142S";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b143.setOnClickListener(v -> {
            text = "143";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b144.setOnClickListener(v -> {
            text = "144";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
        b144s.setOnClickListener(v -> {
            text = "144s";
            Bundle bundle = new Bundle();
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bundle.putString("text", text);
            bottomSheet.setArguments(bundle);
            bottomSheet.show(getSupportFragmentManager(),"text");
        }

        );
    }


}

