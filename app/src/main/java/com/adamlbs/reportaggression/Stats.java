package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.app.ProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Stats extends AppCompatActivity {
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
    private String report_url = "https://api.aggressionreport.fr/getStatistics.php";
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private ProgressDialog pDialog;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreference = new SharedPreference();
        setContentView(R.layout.activity_stats);
        findViewsById();
        location = sharedPreference.getValue(context);
        String aggression;
        aggression = "sexual";
        welcomeText.setTypeface(welcomeText.getTypeface(), Typeface.BOLD);
        showStats();
    }

    private void findViewsById() {
        welcomeText = (TextView) findViewById(R.id.Stats);
        welcomeText2 = (TextView) findViewById(R.id.Stats2);

    }

    private void displayLoader() {
        pDialog = new ProgressDialog(Stats.this);
        pDialog.setMessage("Loading.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    public void onBackPressed() {
        loadDashboard();
    }
    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }
    private void showStats() {
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
                                welcomeText.setText("Vous avez choisi la ligne " + location +
                                        "\n Aucune agression n'a été signalé sur cette ligne. " +
                                        "\n Veuillez revenir plus tard où signalez une agression.");
                            } else {
                                welcomeText.setText("Vous avez choisi la ligne " + location +
                                        "\n Le nombre total d'agressions signalées sur cette ligne est " + totalAggression +
                                        "\nVoici le nombre d'agressions signalées depuis le lancement de l'application : ");
                            }
                            checkStatus();
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
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        Description description = pieChart.getDescription();
        description.setEnabled(false);
        pieData.setValueTextSize(13f);
        pieChart.setDrawHoleEnabled(false);
        pieData.setValueTextColor(Color.DKGRAY);
        pieChart.setData(pieData);
        pieChart.animateXY(2000, 2000);

    }
    private ArrayList getData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(verbalAggression, "Verbale"));
        entries.add(new PieEntry(physicalAggression, "Physique"));
        entries.add(new PieEntry(sexualAggression, "Sexuelle"));
        return entries;
    }
}
