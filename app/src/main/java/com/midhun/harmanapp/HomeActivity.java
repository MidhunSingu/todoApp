package com.midhun.harmanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Button l_intetn_btn;
    private Button r_intent_btn;


    private EditText task_name;
    private Button add_task_btn;
    private ListView tasklist;

    private ArrayList<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        l_intetn_btn = findViewById(R.id.hloginintentbtn);
        r_intent_btn = findViewById(R.id.hregintentbtn);
        task_name = findViewById(R.id.taskname);
        add_task_btn = findViewById(R.id.addtsk_btn);
        tasklist = findViewById(R.id.item_list_view);

        tasks = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tasks);
        tasklist.setAdapter(adapter);

        l_intetn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(loginintent);
            }
        });

        r_intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regintent = new Intent(HomeActivity.this,RegisterActivity.class);
                startActivity(regintent);
            }
        });

        add_task_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = task_name.getText().toString();
                tasks.add(task);
                tasklist.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                Intent i = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.menu_profile:
                Intent profileintent = new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(profileintent);
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Home","start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Home","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Home","restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Home","pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Home","destroy");
    }
}