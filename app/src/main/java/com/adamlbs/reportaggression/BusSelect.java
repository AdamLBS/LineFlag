package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BusSelect  extends AppCompatActivity {
    private SessionHandler session;public ImageButton lineselect, logoutBtn;
    private SharedPreferences sharedPreference;
    private ImageButton b1,b1jet,b1s,b2,b3b,b4,b4b,b5,b6,b7,b7b,b7t,b9,b10,b11,b12,b12a,b12b,b12s,b15,b15s,b16,b16s,b16t,b17,b18,b19,b20,b21jet,b22,b22s,b23,b24,b24b,b24t,b25,b27,b28,b28b,b30,b31,b32,b33,b33s,b34,b35,b35s,b35t,b36,b36b,b37,b37a,b37s,b38,b39,b40,b41,b42,b42t,b44,b45,b46,b46s,b47,b48,b48t,b49,b50,b51,b52,b53,b54,b55,b56,b60,b61,b67,b70,b72,b73,b74,b80,b81,b82,b82s,b83,b84,b86,b88,b89,b91,b96,b97,b98,b121,b122,b142,b142s,b143,b144,b144s,bb1,bb2,bb3,bb3a;
    private String text;
    Activity context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busselect);
        session = new SessionHandler(getApplicationContext());
        User user = session.getUserDetails();
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

    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "1";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text); //Optional parameters
                                      startActivity(i);
                                  }


                                  public void newActivity(View v) {
                                  }
                              }

        );


        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "2";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text); //Optional parameters
                                      startActivity(i);
                                  }


                                  public void newActivity(View v) {
                                  }
                              }


        );
        b1jet.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "1Jet";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text); //Optional parameters
                                      startActivity(i);
                                  }


                                  public void newActivity(View v) {
                                  }
                              }


        );
        b1s.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "1S";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "2";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b3b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "B3B";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        bb3a.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "B3A";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        bb1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "B1";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        bb2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "B2";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        bb3.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "3";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b4.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "4";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b4b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "4B";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b5.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "5";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b6.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "6";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b7.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                                        SharedPreferences.Editor editor = sp.edit();
                                                        text = "7";
                                                        SharedPreference.save(context, text);

                                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                                        i.putExtra("key", text ); //Optional parameters
                                                        startActivity(i);
                                                    }



                                                    public void newActivity(View v) {
                                                    }
                                                }

        );
        b7b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "7B";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b7t.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "7T";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b9.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "9";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b10.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                      SharedPreferences.Editor editor = sp.edit();
                                      text = "10";
                                      SharedPreference.save(context, text);

                                      Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                      i.putExtra("key", text ); //Optional parameters
                                      startActivity(i);
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b11.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "11";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "12";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12a.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "12A";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "12S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b15.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "15";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b15s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "15S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b16.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "16";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b16s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "16S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b16t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "16T";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b17.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "17";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b18.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "18";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b19.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "19";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b20.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "20";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b21jet.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                          SharedPreferences.Editor editor = sp.edit();
                                          text = "21Jet";
                                          SharedPreference.save(context, text);

                                          Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                          i.putExtra("key", text ); //Optional parameters
                                          startActivity(i);
                                      }



                                      public void newActivity(View v) {
                                      }
                                  }

        );
        b22.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "22";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b22s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "22S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b23.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "23";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b24.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "24";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b24b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "24B";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b24t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "24T";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b25.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "25";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b27.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "27";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b28.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "28";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b28b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "28B";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b30.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "30";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b31.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "31";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b32.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "32";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b33.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "33";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b33s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "33s";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b34.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "34";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b35.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "35";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b35s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "35s";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b35t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "35t";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b36.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "36";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b36b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "36B";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b37.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "37";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b37a.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "37A";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b37s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "37S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b38.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "38";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b39.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "39";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b40.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "40";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b41.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "41";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b42.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "42";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b42t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "42T";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b44.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "44";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b45.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "45";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b46.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "46";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b46s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "46S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b47.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "47";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b48.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "48";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b48t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "48T";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b49.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "49";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b50.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "50";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b51.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "51";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b52.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "52";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b53.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "53";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b54.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "54";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b55.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "55";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b56.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "56";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b60.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "60";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b61.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "61";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b67.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "67";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b70.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "70";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b72.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "72";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b73.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "73";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b74.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "74";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b80.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "80";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b81.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "81";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b82.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "82";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b82s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "82S";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b83.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "83";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b84.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "84";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b86.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "86";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b88.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "88";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b89.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "89";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b91.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "91";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b96.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "96";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b97.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "97";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b98.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                       SharedPreferences.Editor editor = sp.edit();
                                       text = "98";
                                       SharedPreference.save(context, text);

                                       Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                       i.putExtra("key", text ); //Optional parameters
                                       startActivity(i);
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b121.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "121";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b122.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "122";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b142.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "142";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b142s.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                         SharedPreferences.Editor editor = sp.edit();
                                         text = "142S";
                                         SharedPreference.save(context, text);

                                         Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                         i.putExtra("key", text ); //Optional parameters
                                         startActivity(i);
                                     }



                                     public void newActivity(View v) {
                                     }
                                 }

        );
        b143.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "143";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b144.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        text = "144";
                                        SharedPreference.save(context, text);

                                        Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                        i.putExtra("key", text ); //Optional parameters
                                        startActivity(i);
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b144s.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                                         SharedPreferences.Editor editor = sp.edit();
                                         text = "144s";
                                         SharedPreference.save(context, text);

                                         Intent i = new Intent(BusSelect.this, ReportActivy.class);
                                         i.putExtra("key", text ); //Optional parameters
                                         startActivity(i);
                                     }



                                     public void newActivity(View v) {
                                     }
                                 }

        );
    }


    public void loadStatistics() {
        Intent i = new Intent(BusSelect.this, Stats.class);
        startActivity(i);

    }
}

