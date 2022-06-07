package com.midhun.harmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginbtn;
    private Button registerbtn;
    private Button view_pass_btn;

    private EditText loginidtxt;
    private EditText loginpass;

    private Button l_intent_btn;
    private Button h_intent_btn;
    private Button r_intent_btn;
    private Button profile_btn;

    private SharedPreferences sharedPreferences;
    private static  final String SharedPref = "MySharedPref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbtn = findViewById(R.id.loginbtn);
        registerbtn = findViewById(R.id.registerbtn);
        loginidtxt = findViewById(R.id.loginid);
        loginpass = findViewById(R.id.loginpass);
        l_intent_btn = findViewById(R.id.lloginintentbtn);
        h_intent_btn = findViewById(R.id.lhomeintentbtn);
        r_intent_btn = findViewById(R.id.lregintentbtn);
        profile_btn = findViewById(R.id.profilebtn);
        view_pass_btn = findViewById(R.id.shared_pass);


        sharedPreferences = getSharedPreferences(SharedPref,MODE_PRIVATE);

        //welcome message
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = loginidtxt.getText().toString();
                String pass = loginpass.getText().toString();

                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("username",id);
                edit.putString("userpass",pass);
                edit.commit();

                if(id.equals("Harman") && pass.equals("Harman")){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, id + " "+pass, Toast.LENGTH_SHORT).show();
                }


            }
        });

        //register message
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Register to the app", Toast.LENGTH_SHORT).show();
            }
        });


        h_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hintent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(hintent);
            }
        });

        r_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rintent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(rintent);
            }
        });

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pintent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(pintent);
            }
        });

        view_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sh  = getSharedPreferences(SharedPref,MODE_PRIVATE);
                String data = sh.getString("username","");
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Login","on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Login","resume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Login","restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Login","pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Login","destroy");
    }
}