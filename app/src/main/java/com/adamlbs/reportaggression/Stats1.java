package com.adamlbs.reportaggression;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import android.app.ProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class Stats1 extends AppCompatActivity {
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
        welcomeText.setText("Vous avez choisi la ligne " + location +
                "\nVoici le nombre d'aggressions signalées : ");
        showStats();
    }

    private void findViewsById() {
        welcomeText = (TextView) findViewById(R.id.Stats);
        welcomeText2 = (TextView) findViewById(R.id.Stats2);
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(Stats1.this);
        pDialog.setMessage("Loading.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

        private void showStats () {
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
                            Toast toast = Toast.makeText(getApplicationContext(), "Done ! Thanks.", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    });


            // Access the RequestQueue through your singleton class.
            MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
        }

    private void checkStatus(){
        welcomeText2.setTypeface(welcomeText2.getTypeface(), Typeface.BOLD);
        welcomeText2.setText("Here's the number of aggression reported since the application was launched on the line " + location +
                "\nAggressions sexuelles :" + sexualAggression +
                "\nAggressions verbales :" + verbalAggression +
                "\nAggressions morales :" + moralAggression +
                "\nAggressions physiques :" + physicalAggression +
                "\n" +
                "\nVoici le total des aggressions rencensées sur la ligne " + location + " : " + totalAggression);
}
}