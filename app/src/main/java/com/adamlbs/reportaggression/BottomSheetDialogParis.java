/*
 * *
 *  * Created by Adam Elaoumari on 02/11/20 02:45
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 02/11/20 02:30
 *
 */

package com.adamlbs.reportaggression;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;


public class BottomSheetDialogParis extends BottomSheetDialogFragment {
    private RequestQueue mRequestQueue;
    private static Context mCtx;
    private String report_url = "https://api.lineflag.com/paris/report.php";
    private static final String LOCATION = "location";
    private static final String AGGRESSION = "aggression";
    private static final String AGGRESSION3 = "aggression2";
    private String location;
    Location gps_loc;
    Location network_loc;
    Location final_loc;
    double longitude;
    private String number = "31177";
    double latitude;
    private String agression;
    private String city2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.SheetDialog);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        String text = getArguments().getString("text");
        location = text;
        SharedPreferences pref = this.getActivity().getSharedPreferences("LocationSheet", MODE_PRIVATE);
        String city=pref.getString("region", null);         // getting String
        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
        int minutes = rightNow.get(Calendar.MINUTE);
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        ImageButton sexual = (ImageButton) v.findViewById(R.id.sexual);
        ImageButton verbal = (ImageButton) v.findViewById(R.id.verbal);
        ImageButton physical = (ImageButton) v.findViewById(R.id.physical);
        ImageButton stats = (ImageButton) v.findViewById(R.id.stats);
        sexual.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Objects.equals(city, "Île-de-France")) {
                            agression = "Agression sexuelle";
                            report();
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Voulez vous signaler cet agression à la RATP ?");
                            builder.setMessage("Votre signalement a bien été pris en compte."
                                    +"\n"
                                    +"\n"
                                    +"LineFlag peut aussi envoyer votre signalement par SMS à la RATP." +
                                    "\n" +
                                    "\nPour ce faire, cliquez sur le bouton ci-dessous." +
                                    "\n"+
                                    "\nL'application ouvrira votre application d'SMS avec un message pré-composé au 31177. "+
                                    "\n" +
                                    "\nVous pouvez aussi choisir de ne pas faire remonter le signalement à la RATP.")
                                    .setCancelable(false)
                                    .setPositiveButton("Signaler à la RATP", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Uri uri = Uri.parse("smsto:31177");
                                            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                                            intent.putExtra("sms_body", "Bonjour, j'aimerai signaler une " + agression+" sur votre réseau sur la ligne " + text + " à " + currentHourIn24Format +"h" +minutes);
                                            startActivity(intent);
                                            getActivity().onBackPressed();


                                        }
                                    });
                            builder.setNeutralButton("Ne pas signaler à la RATP", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    getActivity().onBackPressed();

                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille et de Paris" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Paris." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous le souhaitez vous pouvez changer de ville en cliquant sur le bouton ci dessous, vous pouvez aussi suggérer une ville à ajouter."+
                                    "\n" +
                                    "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("Changer de ville", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent i1 = new Intent(getActivity(),DashboardActivity.class);
                                            i1.putExtra("key", location); //Optional parameters
                                            startActivity(i1);
                                        }
                                    });
                            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

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
                        if (Objects.equals(city, "Île-de-France")) {
                            agression = "Agression verbale";
                             report();
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Voulez vous signaler cet agression à la RATP ?");
                            builder.setMessage("Votre signalement a bien été pris en compte."
                                    +"\n"
                                    +"\n"
                                    +"LineFlag peut aussi envoyer votre signalement par SMS à la RATP." +
                                    "\n" +
                                    "\nPour ce faire, cliquez sur le bouton ci-dessous." +
                                    "\n"+
                                    "\nL'application ouvrira votre application d'SMS avec un message pré-composé au 31177. "+
                                    "\n" +
                                    "\nVous pouvez aussi choisir de ne pas faire remonter le signalement à la RATP.")
                                    .setCancelable(false)
                                    .setPositiveButton("Signaler à la RATP", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Uri uri = Uri.parse("smsto:31177");
                                            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                                            intent.putExtra("sms_body", "Bonjour, j'aimerai signaler une " + agression+" sur votre réseau sur la ligne " + text + " à " + currentHourIn24Format +"h" +minutes);
                                            startActivity(intent);
                                            getActivity().onBackPressed();


                                        }
                                    });
                            builder.setNeutralButton("Ne pas signaler à la RATP", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    getActivity().onBackPressed();

                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille et de Paris" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Paris." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous le souhaitez vous pouvez changer de ville en cliquant sur le bouton ci dessous, vous pouvez aussi suggérer une ville à ajouter."+
                                    "\n" +
                                    "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("Changer de ville", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent i1 = new Intent(getActivity(),DashboardActivity.class);
                                            i1.putExtra("key", location); //Optional parameters
                                            startActivity(i1);
                                        }
                                    });
                            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

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
                        if (Objects.equals(city, "Île-de-France")) {
                            agression = "Agression physique";
                            report();
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Voulez vous signaler cet agression à la RATP ?");
                            builder.setMessage("Votre signalement a bien été pris en compte."
                                    +"\n"
                                    +"\n"
                                    +"LineFlag peut aussi envoyer votre signalement par SMS à la RATP." +
                                    "\n" +
                                    "\nPour ce faire, cliquez sur le bouton ci-dessous." +
                                    "\n"+
                                    "\nL'application ouvrira votre application d'SMS avec un message pré-composé au 31177. "+
                                    "\n" +
                                    "\nVous pouvez aussi choisir de ne pas faire remonter le signalement à la RATP.")
                                    .setCancelable(false)
                                    .setPositiveButton("Signaler à la RATP", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Uri uri = Uri.parse("smsto:31177");
                                            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                                            intent.putExtra("sms_body", "Bonjour, j'aimerai signaler une " + agression+" sur votre réseau sur la ligne " + text + " à " + currentHourIn24Format +"h" +minutes);
                                            startActivity(intent);
                                            getActivity().onBackPressed();


                                        }
                                    });
                            builder.setNeutralButton("Ne pas signaler à la RATP", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    getActivity().onBackPressed();

                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Votre ville n'est pas compatible");
                            builder.setMessage("LineFlag est pour l'instant seulement compatible avec la ville de Marseille et de Paris" +
                                    "\n" +
                                    "\nNous n'avons pas pu vous localiser à Paris." +
                                    "\n" +
                                    "\nIl se peut que votre GPS soit désactivé, si c'est le cas veuillez l'activer et redémarrer l'application." +
                                    "\n" +
                                    "\nSi vous le souhaitez vous pouvez changer de ville en cliquant sur le bouton ci dessous, vous pouvez aussi suggérer une ville à ajouter."+
                                    "\n" +
                                    "\nVous pouvez aussi visualiser les statistiques des lignes mais vous ne pouvez pas signaler d'agression.")
                                    .setCancelable(false)
                                    .setPositiveButton("Changer de ville", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent i1 = new Intent(getActivity(),DashboardActivity.class);
                                            i1.putExtra("key", location); //Optional parameters
                                            startActivity(i1);
                                        }
                                    });
                            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

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
private void paris_dashboard() {
    Intent i1 = new Intent(getActivity(),DashboardParis.class);
    startActivity(i1);
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
    private void sendSMS() {
        
    }

    public void loadStatistics() {
        Intent i1 = new Intent(getActivity(),StatsParis.class);
        i1.putExtra("key", location); //Optional parameters
        startActivity(i1);

    }

}

