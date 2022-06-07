package com.midhun.harmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    private Button call_btn;
    private Button sms_btn;
    private Button browser_btn;
    private Button mail_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        call_btn = findViewById(R.id.callbtn);
        sms_btn = findViewById(R.id.smsbtn);
        browser_btn = findViewById(R.id.browserbtn);
        mail_btn = findViewById(R.id.mailbtn);

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:" + "6309090770"));
                startActivity(call);
            }
        });

        browser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(browser);
            }
        });

        mail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.setType("html/text");
                mail.putExtra(Intent.EXTRA_EMAIL,"test@gmail.com");
                startActivity(mail);
            }
        });

        sms_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sms = new Intent(Intent.ACTION_SEND);
                sms.setData(Uri.parse("smsto:"+"6309090770"));
                startActivity(sms);

            }
        });

    }
}