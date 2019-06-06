package com.example.deltatask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
    }
    public void BACK (View v)
    {
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
    }
}
