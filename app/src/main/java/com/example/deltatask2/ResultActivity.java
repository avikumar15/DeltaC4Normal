package com.example.deltatask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class ResultActivity extends AppCompatActivity {

    TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    }

    public void RESTART (View v)
    {
        Intent i = new Intent(this,StartActivity.class);
        startActivity(i);
    }
}
