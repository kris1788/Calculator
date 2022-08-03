package com.krisambali.kriscalculator;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import android.util.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String in1,vv1;
    int int1 = 0,brac = 0;
    TextView edittext1,distext1,distext2;
    boolean deci;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder,button_Rais,button_Root,button_Back,button_bstart,button_bclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0 = findViewById(R.id.b0);
        button_1 = findViewById(R.id.b1);
        button_2 = findViewById(R.id.b2);
        button_3 = findViewById(R.id.b3);
        button_4 = findViewById(R.id.b4);
        button_5 = findViewById(R.id.b5);
        button_6 = findViewById(R.id.b6);
        button_7 = findViewById(R.id.b7);
        button_8 = findViewById(R.id.b8);
        button_9 = findViewById(R.id.b9);
        button_Dot = findViewById(R.id.bDot);
        button_Add = findViewById(R.id.badd);
        button_Sub = findViewById(R.id.bsub);
        button_Mul = findViewById(R.id.bmul);
        button_Div = findViewById(R.id.biv);
        button_Remainder = findViewById(R.id.BRemain);
        button_Del = findViewById(R.id.buttonDel);
        button_Equ = findViewById(R.id.buttoneql);
        button_Rais = findViewById(R.id.buttonRais);
        button_Root = findViewById(R.id.buttonRoot);
        button_Back = findViewById(R.id.bBack);
        button_bstart = findViewById(R.id.bOpen);
        button_bclose = findViewById(R.id.bClose);
        edittext1 = findViewById(R.id.display);
        distext1 = findViewById(R.id.display1);
        distext2 = findViewById(R.id.display2);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "1");
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "2");
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "3");
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "4");
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "5");
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "6");
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "7");
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "8");
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "9");
            }
        });
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText(edittext1.getText() + "0");
            }
        });
        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edittext1.getText() + "";
                if (data.length() > 0) {
                    data = data.substring(0, data.length() - 1);
                    edittext1.setText(data);
                }
            }
        });
        button_bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    edittext1.setText(edittext1.getText() + "(");
                    brac = brac + 1;
            }
        });
        button_bclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brac = brac - 1;
                if (brac < 0) {brac = 0;} else {
                    edittext1.setText(edittext1.getText() + ")");
                }
            }
        });
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "+");
                    deci = false;
                    edittext1.setText(null);
                    int1=1;
                } else {
                    if (int1>0) {
                        vv1 = distext1.getText() + "";
                        vv1 = vv1.substring(0, vv1.length() - 1) + "+";
                        distext1.setText(vv1);
                        int1 = 1;
                    } else if (distext2.getText().length()>0) {
                        vv1 = distext2.getText() + "+";
                        distext1.setText(vv1);
                        int1 = 1;
                    }
                }
            }
        });
        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {
                        if (vv1.substring(vv1.length() - 1, vv1.length()).equals("=")) {
                            vv1 = "";
                        }
                    }
                    distext1.setText(vv1 + edittext1.getText());
                    in1 = distext1.getText() + "";
                    vv1 = myMethod(in1, brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "-");
                    int1 = 2;
                    deci = false;
                    edittext1.setText(null);
                } else {
                    if (int1 > 0) {
                        vv1 = distext1.getText() + "";
                        vv1 = vv1.substring(0, vv1.length() - 1) + "-";
                        distext1.setText(vv1);
                        int1 = 2;
                    } else if (distext2.getText().length() > 0) {
                        vv1 = distext2.getText() + "-";
                        distext1.setText(vv1);
                        int1 = 2;
                    }
                }
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "*");
                    int1=3;
                    deci = false;
                    edittext1.setText(null);
                }  else {
                    if (int1 > 0) {
                        vv1 = distext1.getText() + "";
                        vv1 = vv1.substring(0,vv1.length()-1) + "*";
                        distext1.setText(vv1);
                        int1 = 3;
                    }  else if (distext2.getText().length()>0) {
                        vv1 = distext2.getText() + "*";
                        distext1.setText(vv1);
                        int1 = 3;
                    }
                    }
                }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "/");
                    int1=4;
                    deci = false;
                    edittext1.setText(null);
                }  else {
                    if (int1 > 0) {
                        vv1 = distext1.getText() + "";
                        vv1 = vv1.substring(0,vv1.length()-1) + "/";
                        distext1.setText(vv1);
                        int1 = 4;
                    }  else if (distext2.getText().length()>0) {
                        vv1 = distext2.getText() + "/";
                        distext1.setText(vv1);
                        int1 = 4;
                    }
                }
            }
        });

        button_Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(String.format("%s", vv1));
                    distext1.setText(distext1.getText() + "" + "%");
                    int1=5;
                    deci = false;
                    edittext1.setText(null);
                }   else {
                if (int1 > 0) {
                    vv1 = distext1.getText() + "";
                    vv1 = vv1.substring(0,vv1.length()-1) + "%";
                    distext1.setText(vv1);
                    int1 = 5;
                }  else if (distext2.getText().length()>0) {
                    vv1 = distext2.getText() + "%";
                    distext1.setText(vv1);
                    int1 = 5;
                }
            }
            }
        });

        button_Rais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "^");
                    int1=6;
                    deci = false;
                    edittext1.setText(null);
                }  else {
                if (int1 > 0) {
                    vv1 = distext1.getText() + "";
                    vv1 = vv1.substring(0,vv1.length()-1) + "^";
                    distext1.setText(vv1);
                    int1 = 6;
                }  else if (distext2.getText().length()>0) {
                    vv1 = distext2.getText() + "^";
                    distext1.setText(vv1);
                    int1 = 6;
                }
            }
            }
        });

        button_Root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    vv1 = distext1.getText() + "";
                    if (vv1.length() > 0) {if (vv1.substring(vv1.length()-1,vv1.length()).equals("=")) {vv1="";}}
                    distext1.setText( vv1  + edittext1.getText());
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    distext2.setText(vv1 + "");
                    distext1.setText(distext1.getText() + "" + "√");
                    int1=7;
                    deci = false;
                    edittext1.setText(null);
                }  else {
                if (int1 > 0) {
                    vv1 = distext1.getText() + "";
                    vv1 = vv1.substring(0,vv1.length()-1) + "√";
                    distext1.setText(vv1);
                    int1 = 7;
                }  else if (distext2.getText().length()>0) {
                    vv1 = distext2.getText() + "√";
                    distext1.setText(vv1);
                    int1 = 7;
                }
            }
            }
        });

        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittext1.getText().length() != 0) {
                    distext1.setText(distext1.getText() + "" + edittext1.getText() );
                    vv1 = edittext1.getText() + "";
                    in1=distext1.getText() + "";
                    vv1 = myMethod(in1,brac);
                    edittext1.setText("");
                    distext2.setText(vv1 + "");
                    int1 = 0;
                    deci = false;
                    distext1.setText(distext1.getText() + ""  + "=");
                }
            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext1.setText("");
                distext1.setText("");
                distext2.setText("");
                int1 = 0;
                in1 = "";
                deci=false;
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!deci) {
                        edittext1.setText(edittext1.getText() + ".");
                        deci = true;
                }
            }
        });
    }
    static String myMethod(String x,int b) {
        String mstring="";
        String nstring="";
        //Closing unclosed branckets if any
        if (b > 0) {
            for (int i=0;i < b;i++) {
                x = x + ")";
            }
        }
        //Converting rais and root into javascript supported format
        if (x.contains("^")||x.contains("√")) {
            String m = x.replaceAll("[0-9.]", "");
            String n = x;
            n = n.replaceAll("\\+", "#");
            n = n.replaceAll("-", "#");
            n = n.replaceAll("\\*", "#");
            n = n.replaceAll("/", "#");
            n = n.replaceAll("\\^", "#");
            n = n.replaceAll("√", "#");
            n = n.replaceAll("%", "#");
            String[] n1 = n.split("#");
            nstring=x;
            mstring = n1[0];
            for (int i = 0; i < m.length(); i++) {
                if (m.substring(i, i + 1).equals("^")) {
                    nstring=nstring.replace(mstring + "^" + n1[i + 1],"Math.pow(" + mstring + "," + n1[i + 1] + ")");
                    mstring = "Math.pow(" + mstring + "," + n1[i + 1] + ")";
                } else if (m.substring(i, i + 1).equals("√")) {
                    nstring=nstring.replace(mstring + "√" + n1[i + 1],"Math.pow(" + mstring + ",1.0/" + n1[i + 1] + ")");
                    mstring = "Math.pow(" + mstring + ",1.0/" + n1[i + 1] + ")";
                } else   mstring=n1[i + 1];

            }
            x = nstring;
        }

        //You have to download rhino1_7R2.jar file from mozhilla and place at android studio lib folder
            Context context = Context.enter(); //
            context.setOptimizationLevel(-1); // this is required[2]
            Scriptable scope = context.initStandardObjects();
            Object result1 = context.evaluateString(scope, x, "<cmd>", 2, null);
            x = result1.toString();
            Double d = new Double(x);
            //Rounded to 10 decimals to avoid invalid decimal results since javascript calculations are 2 based
            x = String.format("%.10f", d);
            BigDecimal bb = new BigDecimal(x);
            //To remove unnecessary zeros after decimal
            x = bb.stripTrailingZeros().toPlainString();


            return x;
    }
}