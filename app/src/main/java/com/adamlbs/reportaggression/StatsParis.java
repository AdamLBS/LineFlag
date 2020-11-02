/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:03
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 00:43
 *
 */

package com.adamlbs.reportaggression;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StatsParis extends AppCompatActivity {
    private int sexualAggression;
    private int moralAggression;
    private int physicalAggression;
    private int verbalAggression;
    private int totalAggression;
    private String description;
    private TextView welcomeText;
    private TextView welcomeText2;
    private String location;
    private String aggression;
    private SharedPreference sharedPreference;
    Activity context = this;
    private String report_url = "https://api.lineflag.com/paris/getStatistics.php";
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private ProgressDialog pDialog;
    int count;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();

        sharedPreference = new SharedPreference();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_stats);
        findViewsById();
        String aggression;
        Intent intent = getIntent();
        location = intent.getStringExtra("key");

        aggression = "sexual";
        showStats();

    }

    private void findViewsById() {
        welcomeText = (TextView) findViewById(R.id.Stats);

    }

    private void displayLoader() {
        pDialog = new ProgressDialog(StatsParis.this);
        pDialog.setMessage("Loading.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    private void getFromPreference() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        count = prefs.getInt("Count", -1);
    }

    private void saveInPreference() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Count", count);
        editor.commit();
    }
    public void onBackPressed() {
        getFromPreference();
        count++;
        int ratecount = 3;
        if (count == ratecount){
            count = 0;
            ReviewManager manager = ReviewManagerFactory.create(this);
            Task<ReviewInfo> request = manager.requestReviewFlow();
            request.addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    // We can get the ReviewInfo object
                    ReviewInfo reviewInfo = task.getResult();
                    Task<Void> flow = manager.launchReviewFlow(this, reviewInfo);
                    flow.addOnCompleteListener(task2 -> {
                        loadDashboard();

                    });

                } else {
                    loadDashboard();
                }
            });
        } else {
            loadDashboard();
        }
        saveInPreference();

    }
    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardParis.class);
        startActivity(i);
        finish();

    }
    private void showStats() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(LOCATION, location);
            request.put(AGGRESSION, aggression);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, report_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();
                        try {
                            sexualAggression = response.getInt("sexualAggression");// ** STATUS IS 1 HERE **
                            verbalAggression = response.getInt("verbalAggression");
                            moralAggression = response.getInt("moralAggression");
                            physicalAggression = response.getInt("physicalAggression");
                            totalAggression = response.getInt("totalAggression");
                            if(totalAggression == 0) {
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                    builder.setMessage(Html.fromHtml("Il n'y a "+"<b>"+"pas "+"</b>"+"d'agressions signalées sur la ligne "+location, Html.FROM_HTML_MODE_LEGACY));

                                } else {
                                    builder.setMessage(Html.fromHtml("Il n'y a "+"<b>"+"pas "+"</b>"+"d'agressions signalées sur la ligne "+location));
                                }
                                AlertDialog alert = builder.create();
                                alert.show();
                            } else {
                                if(totalAggression == 1) {
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                        builder.setMessage(Html.fromHtml("Il y a actuellement " + "<b>" + totalAggression + " agression " + "</b>" + "signalée sur la ligne " + location, Html.FROM_HTML_MODE_LEGACY));

                                    } else {
                                        builder.setMessage(Html.fromHtml("Il y a actuellement "+"<b>"+totalAggression+"</b>"+" agression signalée sur la ligne "+location));
                                    }
                                    AlertDialog alert = builder.create();
                                    alert.show();
                                    checkStatus();
                                    {
                                    }
                                } else {
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                        builder.setMessage(Html.fromHtml("Il y a actuellement " + "<b>" + totalAggression + " agressions " + "</b>" + "signalées sur la ligne " + location, Html.FROM_HTML_MODE_LEGACY));

                                    } else {
                                        builder.setMessage(Html.fromHtml("Il y a actuellement "+"<b>"+totalAggression+"</b>"+" agressions signalées sur la ligne "+location));
                                    }
                                    AlertDialog alert = builder.create();
                                    alert.show();
                                    checkStatus();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        Toast toast = Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                });


        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }

    private void checkStatus() {
        PieChart pieChart = (PieChart) findViewById(R.id.chart);
        PieDataSet pieDataSet = new PieDataSet(getData(),"Détail des agressions");
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);
        pieDataSet.setColors(Color.rgb(255, 102, 0), Color.rgb(193, 37, 82), Color.rgb(245, 199, 0));
        PieData pieData = new PieData(pieDataSet);
        Description description = pieChart.getDescription();
        description.setEnabled(false);
        pieData.setValueTextSize(13f);
        pieChart.setDrawHoleEnabled(false);
        pieData.setValueTextColor(Color.WHITE);
        pieChart.setData(pieData);
        pieChart.animateXY(2000, 2000);

    }
    private ArrayList<PieEntry> getData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(sexualAggression));
        entries.add(new PieEntry(physicalAggression));
        entries.add(new PieEntry(verbalAggression));
        return entries;
    }
}
