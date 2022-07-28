package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class home_screen extends AppCompatActivity {
    ImageView add_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();

        add_book = findViewById(R.id.add_book);

        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ok = new Intent(home_screen.this,Add_book_1.class);
                startActivity(ok);
            }
        });
    }


}