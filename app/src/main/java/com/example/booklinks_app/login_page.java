package com.example.booklinks_app;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login_page extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText username, password;
    ImageButton for_btn;
    ImageView back;
    TextView cna_text, forgot;
    int i=0;
    String b,password_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        for_btn = findViewById(R.id.for_btn);
        cna_text = findViewById(R.id.cna_text);
        forgot = findViewById(R.id.forgot);
        back = findViewById(R.id.back);



        //back button is get back to the main activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(login_page.this, MainActivity.class);
                startActivity(b);
            }
        });

        //on cna means create new account on click it go to the new_account page
        cna_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(login_page.this, new_account_1.class);
                startActivity(u);
            }
        });

        //on forgot click it goto the forgot page
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(login_page.this, forgot_password.class);
                startActivity(f);
            }
        });

        //in for_btn click it check the data it is present in the database or not ,if present then login successfull, else error show
        for_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String query = "Select * From testing where name = '" + username + "'";

                if (uname.isEmpty())
                {
                    username.setError("Enter Username");
                }
                else if (pass.isEmpty())
                {
                    password.setError("Enter Password");
                }
                else
                    {

                    SQLiteDatabase simple = getApplication().openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
                    Cursor c = simple.rawQuery("Select * from testing", null);
                    if (c.getCount() == 0) {
                        //if no record then print the Toast
                        Toast.makeText(login_page.this, "no data is found", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext())
                    {
                        buffer.append("Username =" + c.getString(4) + "\n");
                        buffer.append("Password =" + c.getString(5) + "\n");

                        if(c.getString(4).equals(uname))
                        {
                          b = c.getString(4);
                          password_check = c.getString(5);

                          if(password_check.equals(pass))
                          {
                                i = 1;
                          }
                        }


                    }

                    if(b == null)
                    {
                        Toast.makeText(login_page.this, "Enter Valid Username", Toast.LENGTH_SHORT).show();
                    }
                    if(i == 1)
                    {
                        Intent confirm = new Intent(login_page.this,home_screen.class);
                        startActivity(confirm);
                    }
                    else
                    {
                        Toast.makeText(login_page.this, "enter valid Password", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}