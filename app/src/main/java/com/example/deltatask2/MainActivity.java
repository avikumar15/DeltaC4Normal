package com.example.deltatask2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity {

    private int getColorWithAlpha(int color, float ratio) {
        int newColor = 0;
        int alpha = Math.round(Color.alpha(color) * ratio);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        newColor = Color.argb(alpha, r, g, b);
        return newColor;
    }


    LinearLayout LL,Outermost,Arrows;           //Layout Declaration
    TextView[] b;
    TextView t,terror;
    TextView[][] v;
    int[] z = {0,0,0,0,0,0,0};
    int[][] ans = {{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0}};
    int f=0;
    String playa1="",playa2="";
    Button undo;
    int p=0,q=0;
    int ka=0;
    int r=0,s=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        int i = 0, j = 0;                       //Iterarion variables

        Intent intent1=getIntent();
        playa1=intent1.getStringExtra(StartActivity.EXTRA_TEXT);            //Getting names
        playa2=intent1.getStringExtra(StartActivity.EXTRA_TEXT2);

        LL = new LinearLayout(this);            //Initialisation of Layouts
        Outermost = new LinearLayout(this);
        Arrows = new LinearLayout(this);
        t = new TextView(this);
        terror = new TextView(this);
        undo = new Button (this);
        final TextView result = new TextView(this);

        final LinearLayout.LayoutParams paramres = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);    //Params
        LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams param4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams param5 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams param6 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        param2.gravity=Gravity.CENTER;
        param3.gravity=Gravity.CENTER;
        param5.gravity=Gravity.CENTER;
        param4.gravity=Gravity.CENTER;
        param.gravity=Gravity.CENTER;
        param6.gravity=Gravity.END;

        param6.setMargins(0,0,40,80);
        paramres.setMargins(0,-150,0,0);
        param4.setMargins(5,5,5,5);
        param5.setMargins(0,50,0,50);
        LL.setLayoutParams(param);                                  //Param set
        Arrows.setLayoutParams(param3);
        paramres.gravity=Gravity.CENTER;
        Outermost.setLayoutParams(param2);
        LL.setPadding(20,10,20,10);
        Arrows.setGravity(Gravity.CENTER);                              //Gravity set
        Outermost.setGravity(Gravity.CENTER);
        t.setGravity(Gravity.CENTER);
        t.setBackgroundColor(Color.rgb(255,255,255));
        Outermost.setBackgroundColor(Color.parseColor("#F60000"));
        t.setLayoutParams(param5);
        undo.setLayoutParams(param6);
        LL.setBackgroundColor(Color.parseColor("#0046ff"));             //BLUE COLOR

        undo.setText("UNDO");
        terror.setTextColor(Color.rgb(166,50,50));
        t.setTextColor(Color.rgb(0,0,256));


        t.setTextSize(30);
        t.setText(playa1+"'s Turn");
        t.setPadding(20,10,20,10);
        terror.setPadding(20,10,20,10);
        terror.setTextSize(20);
        terror.setLayoutParams(param5);
        terror.setGravity(Gravity.CENTER);

        Outermost.addView(undo);
        Outermost.addView(t);
        Outermost.addView(result);
        Outermost.addView(terror);
        Outermost.addView(Arrows);
        Outermost.addView(LL);

        Arrows.setOrientation(Arrows.HORIZONTAL);       //layout orientation
        Outermost.setOrientation(Outermost.VERTICAL);

        b = new TextView[7];
        for(i=0;i<7;i++)
        {
            b[i] = new TextView(this);              //Button initialisation
            b[i].setWidth(135);
            b[i].setHeight(130);
            b[i].setBackgroundResource(R.drawable.arrow);
            b[i].setLayoutParams(param4);
            Arrows.addView(b[i]);                           //Button added to arrow horizontally
        }

        v = new TextView[7][6];
        for(i=0;i<7;i++)
            for(j=0;j<6;j++)
            {
                v[i][j]=new TextView(this);         //TextView initialised
            }

        LinearLayout[] l = new LinearLayout[7];
        for(i=0;i<7;i++)
        {
            l[i] = new LinearLayout(this);          //Vertical LinearLayouts initialised
        }

        for (i = 0; i < 7; i++)
        {
            l[i].setOrientation(LinearLayout.VERTICAL);
            for (j = 0; j < 6; j++)
            {
                v[i][j].setWidth(130);
                v[i][j].setHeight(130);
                v[i][j].setLayoutParams(param4);
                v[i][j].setBackgroundResource(R.drawable.border);
                l[i].addView(v[i][j]);                                          //TextView added to Vertical LinLayouots.
            }
            LL.setOrientation(LinearLayout.HORIZONTAL);
            LL.addView(l[i]);                                                   //LinLayouts added to horizontal LL.
        }



        //LOGIC STARTS


            b[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v0) {
                    undo.setVisibility(VISIBLE);
                    terror.setVisibility(INVISIBLE);
                    if(z[0]>5) {
                        terror.setPadding(20,10,20,10);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),1.0f));
                        terror.setVisibility(VISIBLE);
                        terror.setText("INVALID.");
                    }
                    else {
                        if(f%2==0)

                        {

                            t.setPadding(20,10,20,10);
                            Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                            v[0][5 - z[0]].setBackgroundResource(R.drawable.circle_red);
                            ans[8-z[0]][3]=1;
                            t.setText(playa2 + "'s Turn");
                        }
                         else
                             {
                                 t.setPadding(20,10,20,10);
                                v[0][5 - z[0]].setBackgroundResource(R.drawable.circle_yellow);
                                Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                                t.setText(playa1 + "'s Turn");
                            ans[8-z[0]][3]=2;
                            }
                            p=8-z[0];
                            q=3;

                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setLayoutParams(paramres);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setPadding(30,0,30,0);
                            result.setLayoutParams(paramres);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[0]++;
                        f++;
                        r=0;
                        s=5-z[0];
                    }
                    }
            });
            b[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v1) {
                    undo.setVisibility(VISIBLE);
                    terror.setText("");
                    terror.setVisibility(INVISIBLE);
                    if(z[1]>5)
                    {
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setVisibility(VISIBLE);
                        terror.setText("INVALID.");
                    }
                    else
                    {
                    if(f%2==0)
                    {
                        t.setText(playa2+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                        v[1][5 - z[1]].setBackgroundResource(R.drawable.circle_red);
                        ans[8-z[1]][4]=1;
                    }
                    else
                    {
                        t.setText(playa1+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                        ans[8-z[1]][4]=2;
                        v[1][5 - z[1]].setBackgroundResource(R.drawable.circle_yellow);
                    }
                        p=8-z[1];
                        q=4;
                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setPadding(30,0,30,0);
                            result.setLayoutParams(paramres);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[1]++;
                        f++;
                        r=1;
                        s=5-z[1];
                }
                }
            });
            b[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v2) {
                    undo.setVisibility(VISIBLE);
                    terror.setText("");
                    terror.setVisibility(INVISIBLE);
                    if(z[2]>5)
                    {
                        terror.setVisibility(VISIBLE);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setText("INVALID.");
                    }
                    else
                    {
                    if(f%2==0)
                    {
                        t.setText(playa2+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                        v[2][5 - z[2]].setBackgroundResource(R.drawable.circle_red);
                        ans[8-z[2]][5]=1;
                    }
                    else
                    {
                        t.setText(playa1+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                        v[2][5 - z[2]].setBackgroundResource(R.drawable.circle_yellow);
                        ans[8-z[2]][5]=2;
                    }
                        p=8-z[2];
                        q=5;
                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setLayoutParams(paramres);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setPadding(30,0,30,0);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[2]++;
                        f++;
                        r=2;
                        s=5-z[2];
                }
                }
            });
            b[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v3) {
                    undo.setVisibility(VISIBLE);
                    terror.setText("");
                    terror.setVisibility(INVISIBLE);
                    if(z[3]>5)
                    {

                        terror.setVisibility(VISIBLE);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setText("INVALID.");
                    }
                    else
                    {
                    if(f%2==0)
                    {
                        t.setText(playa2+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                        v[3][5 - z[3]].setBackgroundResource(R.drawable.circle_red);
                        ans[8-z[3]][6]=1;
                    }
                    else
                    {
                        ans[8-z[3]][6]=2;
                        t.setText(playa1+"'s Turn");
                        Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                        v[3][5 - z[3]].setBackgroundResource(R.drawable.circle_yellow);
                    }
                        p=8-z[3];
                        q=6;
                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setLayoutParams(paramres);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setLayoutParams(paramres);
                            result.setPadding(30,0,30,0);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[3]++;
                        f++;
                        r=3;
                        s=5-z[3];
                    }
                }
            });
            b[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v4) {
                    undo.setVisibility(VISIBLE);
                    terror.setVisibility(INVISIBLE);
                    terror.setText("");
                    if(z[4]>5)
                    {

                        terror.setVisibility(VISIBLE);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setText("INVALID.");
                    }
                    else {
                        if (f % 2 == 0) {
                            t.setText(playa2 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                            v[4][5 - z[4]].setBackgroundResource(R.drawable.circle_red);
                            ans[8-z[4]][7]=1;
                        }
                        else {
                            t.setText(playa1 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                            v[4][5 - z[4]].setBackgroundResource(R.drawable.circle_yellow);
                            ans[8-z[4]][7]=2;
                        }
                        p=8-z[4];
                        q=7;

                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setLayoutParams(paramres);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setLayoutParams(paramres);
                            result.setPadding(30,0,30,0);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[4]++;
                        f++;
                        r=4;
                        s=5-z[4];
                    }
                }
            });
            b[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v5) {
                    undo.setVisibility(VISIBLE);
                    terror.setVisibility(INVISIBLE);
                    terror.setText("");
                    if (z[5] > 5)
                    {

                        terror.setVisibility(VISIBLE);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setText("INVALID.");
                    }
                    else {
                        if (f % 2 == 0) {
                            ans[8-z[5]][8]=1;
                            t.setText(playa2 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                            v[5][5 - z[5]].setBackgroundResource(R.drawable.circle_red);
                        } else {
                            ans[8-z[5]][8]=2;
                            t.setText(playa1 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                            v[5][5 - z[5]].setBackgroundResource(R.drawable.circle_yellow);
                        }
                        p=8-z[5];
                        q=8;

                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setLayoutParams(paramres);
                                result.setGravity(Gravity.CENTER);
                                result.setTextSize(40);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setTextSize(40);
                            result.setLayoutParams(paramres);
                            result.setPadding(30,0,30,0);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[5]++;
                        f++;
                        r=5;
                        s=5-z[5];
                    }
                }
            });
            b[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v6) {
                    undo.setVisibility(VISIBLE);
                    terror.setText("");
                    terror.setVisibility(INVISIBLE);
                    if (z[6] > 5)
                    {

                        terror.setVisibility(VISIBLE);
                        terror.setBackgroundColor(getColorWithAlpha(Color.parseColor("#dce9ff"),0.95f));
                        terror.setText("INVALID.");
                    }
                    else {
                        if (f % 2 == 0) {
                            ans[8-z[6]][9] = 1;
                            t.setText(playa2 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                            v[6][5 - z[6]].setBackgroundResource(R.drawable.circle_red);
                        } else {
                            ans[8-z[6]][9] = 2;
                            t.setText(playa1 + "'s Turn");
                            Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                            v[6][5 - z[6]].setBackgroundResource(R.drawable.circle_yellow);
                        }
                        p = 8-z[6];
                        q = 9;

                        if(((ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p+2][q]&&ans[p][q]==ans[p+3][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-1][q]&&ans[p][q]==ans[p+2][q]) || (ans[p][q]==ans[p+1][q]&&ans[p][q]==ans[p-2][q]&&ans[p][q]==ans[p-1][q]) || (ans[p][q]==ans[p-1][q]&&ans[p-1][q]==ans[p-2][q]&&ans[p-2][q]==ans[p-3][q]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q+3]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q+2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q+1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-1]) || (ans[p][q]==ans[p][q-1] && ans[p][q]==ans[p][q-2] && ans[p][q]==ans[p][q-3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p+3][q+3]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p+2][q+2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p+1][q+1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-1][q-1]) || (ans[p][q]==ans[p-1][q-1] && ans[p][q]==ans[p-2][q-2] && ans[p][q]==ans[p-3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && (ans[p][q]==ans[p+2][q-2]) && (ans[p][q]==ans[p+3][q-3]) || (ans[p][q]==ans[p+1][q-1]) && ans[p][q]==ans[p+2][q-2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p+1][q-1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-1][q+1]) || (ans[p][q]==ans[p-1][q+1] && ans[p][q]==ans[p-2][q+2] && ans[p][q]==ans[p-3][q+3]) && ((ans[p][q]==2)||(ans[p][q]==1)))
                        {
                            ka = ans[p][q];
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            if(ka==2)
                            {
                                result.setAllCaps(true);
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setTextSize(40);
                                result.setPadding(30,0,30,0);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setText(playa2+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                            else
                            {
                                result.setGravity(Gravity.CENTER);
                                result.setLayoutParams(paramres);
                                result.setPadding(30,0,30,0);
                                result.setAllCaps(true);
                                result.setTextColor(Color.rgb(75,181,67));
                                Outermost.setBackgroundResource(R.drawable.finalbackground);
                                result.setTextSize(40);
                                result.setText(playa1+" WINS");
                                result.setBackgroundColor(Color.parseColor("#8090EE90"));
                            }
                        }

                        else if ((ans[3][3]!=0 && ans[3][4]!=0 && ans[3][5]!=0 && ans[3][6]!=0 && ans[3][7]!=0 && ans[3][8]!=0 && ans[3][9]!=0))
                        {
                            terror.setVisibility(INVISIBLE);
                            t.setVisibility(INVISIBLE);
                            Arrows.setVisibility(INVISIBLE);
                            undo.setVisibility(INVISIBLE);
                            result.setAllCaps(true);
                            result.setGravity(Gravity.CENTER);
                            result.setLayoutParams(paramres);
                            result.setTextSize(40);
                            result.setPadding(30,0,30,0);
                            result.setTextColor(Color.parseColor("#8b0000"));
                            result.setTextColor(Color.rgb(75,181,67));
                            result.setBackgroundColor(Color.parseColor("#80F8585A"));
                            Outermost.setBackgroundResource(R.drawable.finalbackground);
                            result.setText("DRAW");
                        }
                        z[6]++;
                        f++;
                        r=6;
                        s=5-z[6];
                    }
                }
            });
            undo.setOnClickListener(new View.OnClickListener()
                                    {
                                      @Override
                                      public void onClick(View vv)
                                      {
                                          if(f%2==0)
                                          {
                                              t.setText(playa2 + "'s Turn");
                                              Outermost.setBackgroundColor(Color.parseColor("#FFCC00"));
                                          }
                                          else
                                              {
                                              Outermost.setBackgroundColor(Color.parseColor("#F60000"));
                                              t.setText(playa1 + "'s Turn");
                                          }
                                          v[r][6-z[r]].setBackgroundResource(R.drawable.border);
                                          z[r]--;
                                          f--;
                                          ans[p][q]=0;
                                          undo.setVisibility(INVISIBLE);
                                      }
                                    });

        setContentView(Outermost);                                       //Final Screen
    }


}