package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class otp_page extends AppCompatActivity {
    ImageButton inbutton2;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_page);
        getSupportActionBar().hide();

        inbutton2 = findViewById(R.id.for_btn);
        back_btn = findViewById(R.id.back_btn);

        inbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(otp_page.this,Success_after_otp.class);
                startActivity(i);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(otp_page.this,new_account_2.class);
                startActivity(b);
            }
        });
    }
}