/*
 * *
 *  * Created by Adam Elaoumari on 09/08/20 00:46
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 09/08/20 00:46
 *
 */

package com.adamlbs.reportaggression;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;


public class BottomSheetDialog extends BottomSheetDialogFragment {
    private RequestQueue mRequestQueue;
    private static Context mCtx;
    private String report_url = "https://api.lineflag.com/report.php";
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private static final String AGGRESSION3 = "aggression2";
    private String location;
    Location gps_loc;
    Location network_loc;
    Location final_loc;
    double longitude;
    double latitude;
    private String agression;
    private String city2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.SheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        String text = getArguments().getString("text");
        location = text;
        String city = PreferenceManager.getDefaultSharedPreferences(this.getActivity()).getString("city", "null");

        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        ImageButton sexual = (ImageButton) v.findViewById(R.id.sexual);
        ImageButton verbal = (ImageButton) v.findViewById(R.id.verbal);
        ImageButton physical = (ImageButton) v.findViewById(R.id.physical);
        ImageButton stats = (ImageButton) v.findViewById(R.id.stats);
        sexual.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (city.equals("Marseille")) {
                            agression = "Agression sexuelle";
                            report();
                            getActivity().onBackPressed();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Marseille." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous n'habitez pas à Marseille vous pouvez demander à ce que votre ville soit ajoutée en cliquant sur le bouton ci-dessous."+
                                    "\n" +
                                            "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    });
                            builder.setNegativeButton("Suggérer une ville", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent i1 = new Intent(getActivity(),WebView.class);
                                    startActivity(i1);
                                }
                            });


                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    }
                }

        );
        verbal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (city == "Marseille") {
                            agression = "Agression verbale";
                            report();
                            getActivity().onBackPressed();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Marseille." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous n'habitez pas à Marseille vous pouvez demander à ce que votre ville soit ajoutée en cliquant sur le bouton ci-dessous."+
                                    "\n" +
                                    "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    });
                            builder.setNegativeButton("Suggérer une ville", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent i1 = new Intent(getActivity(),WebView.class);
                                    startActivity(i1);
                                }
                            });


                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    }
                }
        );
        physical.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (city == "Marseille") {
                            agression = "Agression physique";
                            report();
                            getActivity().onBackPressed();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Marseille." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous n'habitez pas à Marseille vous pouvez demander à ce que votre ville soit ajoutée en cliquant sur le bouton ci-dessous."+
                                    "\n" +
                                    "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                        }
                                    });
                            builder.setNegativeButton("Suggérer une ville", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent i1 = new Intent(getActivity(),WebView.class);
                                    startActivity(i1);
                                }
                            });


                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    }
                }
        );
        stats.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
loadStatistics();

                    }
                }
        );
        return v;

    }

    private void report() {

                JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(LOCATION, location);
            request.put(AGGRESSION,agression);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, report_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //Display error message whenever an error occurs
                    }
                });

        jsArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsArrayRequest);
        Toast.makeText(getActivity(), agression + " signalée sur la ligne "+location, Toast.LENGTH_SHORT).show();


    }
    public void loadStatistics() {
        Intent i1 = new Intent(getActivity(),Stats.class);
        i1.putExtra("key", location); //Optional parameters
        startActivity(i1);

    }

}

