package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class forgot_password extends AppCompatActivity {
    ImageView backbutton;
    Button sendotp;
    EditText Phonetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        backbutton = findViewById(R.id.backbutton);
        sendotp = findViewById(R.id.sendotp);
        Phonetext = findViewById(R.id.Phonetext);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(forgot_password.this,login_page.class);
                startActivity(back);
            }
        });

        //now the click on send otp button and where is go is switch
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = Phonetext.getText().toString().trim();
                if(phone.isEmpty())
                {
                    Toast.makeText(forgot_password.this, "Enter Phone No.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //if the phone hase value then it is come in this part


                    checkphone(phone);
                    //now check the phone number it is Valid or not

                    Intent otp = new Intent(forgot_password.this,MainActivity.class);
                    startActivity(otp);
                }


            }
        });


    }

    private boolean checkphone(String phone)
    {
        Pattern s = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = s.matcher(phone);
        return(m.find() && m.group().equals(phone));
    }
}