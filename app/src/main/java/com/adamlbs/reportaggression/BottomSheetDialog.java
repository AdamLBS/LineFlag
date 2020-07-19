package com.adamlbs.reportaggression;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import java.util.Map;
import java.util.Objects;


public class BottomSheetDialog extends BottomSheetDialogFragment {
    private RequestQueue mRequestQueue;
    private static Context mCtx;
    private String report_url = "https://api.lineflag.com/report.php";
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private static final String AGGRESSION3 = "aggression2";
    private String location;
    private String agression;
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
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        ImageButton sexual = (ImageButton) v.findViewById(R.id.sexual);
        ImageButton verbal = (ImageButton) v.findViewById(R.id.verbal);
        ImageButton physical = (ImageButton) v.findViewById(R.id.physical);
        ImageButton stats = (ImageButton) v.findViewById(R.id.stats);
        sexual.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        agression = "Agression sexuelle";
                        userRegister();
                        getActivity().onBackPressed();
                    }
                }

        );
        verbal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        agression = "Agression verbale";
                        userRegister();
                        getActivity().onBackPressed();
                    }
                }
        );
        physical.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        agression = "Agression physique";
                        userRegister();
                        getActivity().onBackPressed();
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

    private void userRegister() {

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

