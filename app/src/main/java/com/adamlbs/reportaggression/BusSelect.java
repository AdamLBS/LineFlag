/*
 * *
 *  * Created by Adam Elaoumari on 20/11/20 18:20
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 20/11/20 16:04
 *
 */

package com.adamlbs.reportaggression;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        final FloatingActionButton fab = findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Application) getApplication()).getShaky().startFeedbackFlow();

                }
            });
        }
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "1";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }


                                  public void newActivity(View v) {
                                  }
                              }

        );


        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "2";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }


                                  public void newActivity(View v) {
                                  }
                              }


        );
        b1jet.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "1Jet";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }


                                  public void newActivity(View v) {
                                  }
                              }


        );
        b1s.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "1S";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "2";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b3b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "B3B";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        bb3a.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "B3A";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        bb1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "B1";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        bb2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "B2";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        bb3.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "3";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b4.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "4";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b4b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "4B";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b5.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "5";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b6.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "6";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b7.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        text = "7";
                                                        Bundle bundle = new Bundle();
                                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                                        bundle.putString("text", text);
                                                        bottomSheet.setArguments(bundle);
                                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                                    }



                                                    public void newActivity(View v) {
                                                    }
                                                }

        );
        b7b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      text = "7B";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b7t.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "7T";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b9.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "9";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b10.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {

                                      text = "10";
                                      Bundle bundle = new Bundle();
                                      BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                      bundle.putString("text", text);
                                      bottomSheet.setArguments(bundle);
                                      bottomSheet.show(getSupportFragmentManager(),"text");
                                  }



                                  public void newActivity(View v) {
                                  }
                              }

        );
        b11.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "11";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       text = "12";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12a.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       text = "12A";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b12b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "12S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b15.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "15";

                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b15s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "15S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b16.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "16";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b16s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "16S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b16t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "16T";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b17.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "17";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b18.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "18";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b19.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       text = "19";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b20.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "20";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b21jet.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          text = "21Jet";
                                          Bundle bundle = new Bundle();
                                          BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                          bundle.putString("text", text);
                                          bottomSheet.setArguments(bundle);
                                          bottomSheet.show(getSupportFragmentManager(),"text");
                                      }



                                      public void newActivity(View v) {
                                      }
                                  }

        );
        b22.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "22";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b22s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "22S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b23.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "23";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b24.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "24";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b24b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "24B";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b24t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "24T";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b25.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "25";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b27.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "27";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b28.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "28";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b28b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "28B";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b30.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "30";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b31.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "31";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b32.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "32";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b33.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "33";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b33s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "33s";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b34.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "34";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b35.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "35";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b35s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "35s";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b35t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "35t";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b36.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "36";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b36b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "36B";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b37.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "37";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b37a.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "37A";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b37s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "37S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b38.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "38";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b39.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "39";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b40.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       text = "40";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b41.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "41";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b42.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "42";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b42t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) { ;
                                        text = "42T";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b44.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "44";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b45.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "45";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b46.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "46";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b46s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "46S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b47.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       text = "47";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b48.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "48";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b48t.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "48T";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b49.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "49";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b50.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "50";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b51.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "51";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b52.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "52";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b53.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "53";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b54.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "54";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b55.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "55";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b56.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "56";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b60.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "60";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b61.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "61";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b67.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "67";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b70.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "70";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b72.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "72";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b73.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "73";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b74.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "74";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b80.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "80";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b81.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "81";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b82.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "82";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b82s.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "82S";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b83.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "83";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b84.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "84";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b86.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "86";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b88.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "88";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b89.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "89";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b91.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "91";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b96.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "96";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b97.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "97";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b98.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       text = "98";
                                       Bundle bundle = new Bundle();
                                       BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                       bundle.putString("text", text);
                                       bottomSheet.setArguments(bundle);
                                       bottomSheet.show(getSupportFragmentManager(),"text");
                                   }



                                   public void newActivity(View v) {
                                   }
                               }

        );
        b121.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "121";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b122.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "122";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b142.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "142";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b142s.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "142S";
                                         Bundle bundle = new Bundle();
                                         BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                         bundle.putString("text", text);
                                         bottomSheet.setArguments(bundle);
                                         bottomSheet.show(getSupportFragmentManager(),"text");
                                     }



                                     public void newActivity(View v) {
                                     }
                                 }

        );
        b143.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "143";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b144.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        text = "144";
                                        Bundle bundle = new Bundle();
                                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                        bundle.putString("text", text);
                                        bottomSheet.setArguments(bundle);
                                        bottomSheet.show(getSupportFragmentManager(),"text");
                                    }



                                    public void newActivity(View v) {
                                    }
                                }

        );
        b144s.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         text = "144s";
                                         Bundle bundle = new Bundle();
                                         BottomSheetDialog bottomSheet = new BottomSheetDialog();
                                         bundle.putString("text", text);
                                         bottomSheet.setArguments(bundle);
                                         bottomSheet.show(getSupportFragmentManager(),"text");
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

