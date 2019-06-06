package com.example.deltatask2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.deltatask2.application.deltatask2.EXTRA_TEXT";
    public static final String EXTRA_TEXT2="com.deltatask2.application.deltatask2.EXTRA_TEXT2";

    TextView t1;
    EditText et1,et2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_start);

        t1=(TextView)findViewById(R.id.t1);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
    }

    public void START(View v)
    {
        String s1="",s2="";

        if(!et1.toString().equals(""))
        s1=(et1).toString();
        if(!et2.toString().equals(""))
        s2=(et2).toString();

        if(et1.getText().toString().matches(""))
            t1.setText("INVALID INPUT. Modify and hit PLAY GAME");
        else if(et2.getText().toString().matches(""))
            t1.setText("INVALID INPUT. Modify and hit PLAY GAME");
        else if(!(et1.getText().toString().matches("")||et2.getText().toString().matches("")))
        {
            s1=et1.getText().toString();
            s2=et2.getText().toString();

            Intent intent1 = new Intent(this,MainActivity.class);
            intent1.putExtra(EXTRA_TEXT,s1);
            intent1.putExtra(EXTRA_TEXT2,s2);
            startActivity(intent1);
        }
    }
    public void RULE(View view)
    {
        Intent intent2 = new Intent(this,RuleActivity.class);
        startActivity(intent2);
    }
}
