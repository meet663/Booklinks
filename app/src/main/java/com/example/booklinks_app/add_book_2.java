package com.example.booklinks_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add_book_2 extends AppCompatActivity {
    ImageView add_book_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_2);
        getSupportActionBar().hide();

        add_book_click = findViewById(R.id.add_book_click);

        add_book_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(add_book_2.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}