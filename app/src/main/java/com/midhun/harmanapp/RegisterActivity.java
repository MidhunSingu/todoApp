package com.midhun.harmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button l_intent_btn;
    private Button h_intent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        l_intent_btn = findViewById(R.id.rloginintentbtn);
        h_intent_btn = findViewById(R.id.rhomeintentbtn);

        l_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(loginintent);
            }
        });

        h_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hintent = new Intent(RegisterActivity.this,HomeActivity.class);
                startActivity(hintent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Register","start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Register","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Register","restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Register","pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Register","destroy");
    }
}