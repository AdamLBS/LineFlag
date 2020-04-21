package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import android.app.ProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;


public class ReportActivy extends AppCompatActivity {
    private String report_url = "https://api.aggressionreport.fr/report.php";
    private TextView welcomeText;
    public ImageButton btnSubmit2;
    public Spinner spinner3;
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private static final String AGGRESSION3 = "aggression2";

    private ProgressDialog pDialog;

//TODO Faire en sorte qu'à la fin du report on arrive sur la page de statistiques de la ligne en question
    private SharedPreference sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_report);
        sharedPreference = new SharedPreference();
        addListenerOnButton();

        findViewsById();

        //Retrieve a value from SharedPreference
        location = sharedPreference.getValue(context);
        welcomeText.setText("Vous avez choisi la ligne " + location +
                "\nVeuillez maintenant sélectionner un type d'agression");
    }

    private String location;
    Activity context = this;
    public void addListenerOnSpinnerItemSelection() {
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        spinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener() {
        });
    }
    //get the selected dropdown list value
    public void addListenerOnButton() {

        spinner3 = (Spinner) findViewById(R.id.spinner3);
        String text = spinner3.getSelectedItem().toString();;
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        btnSubmit2 = (ImageButton) findViewById(R.id.btnSubmit2);
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aggression = spinner3.getSelectedItem().toString();
                aggression = String.valueOf(spinner3.getSelectedItem());
                System.out.println(AGGRESSION);
                System.out.println(location = sharedPreference.getValue(context));
                registerUser();
            }

                    });


    }

    private void findViewsById() {
        welcomeText = (TextView) findViewById(R.id.welcomeText2);
    }
    private void displayLoader() {
        pDialog = new ProgressDialog(ReportActivy.this);
        pDialog.setMessage("Reporting.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }
    private void registerUser() {
        displayLoader();
        JSONObject request = new JSONObject();
        try {
            //Populate the request parameters
            request.put(LOCATION, location);
            request.put(AGGRESSION, String.valueOf(spinner3.getSelectedItem()));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.POST, report_url, request, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        pDialog.dismiss();

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();

                        //Display error message whenever an error occurs
                        loadStatistics();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsArrayRequest);
    }
    private void loadDashboard() {
        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(i);
        finish();

    }

    public void loadStatistics() {
        Intent i = new Intent(ReportActivy.this, Stats.class);
        i.putExtra("key", String.valueOf(spinner3.getSelectedItem())); //Optional parameters
        startActivity(i);

    }
}
