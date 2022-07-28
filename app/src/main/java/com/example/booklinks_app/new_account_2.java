package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class new_account_2 extends MainActivity {

    DatabaseHelper myDb;
    EditText password,phone;

    ImageButton inbutton2;
    ImageView imageView6;
    TextView gender,uname;




    String firstname,username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account_2);
        Objects.requireNonNull(getSupportActionBar()).hide();



        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);



        inbutton2 = findViewById(R.id.for_btn);
        imageView6 = findViewById(R.id.imageView6);
        myDb=new DatabaseHelper(this);

        gender = findViewById(R.id.gender);
        uname = findViewById(R.id.uname);




        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ins =  new Intent(new_account_2.this,new_account_1.class);
                startActivity(ins);
            }
        });

        Intent i = getIntent();
        firstname = i.getStringExtra("gender");
        username = i.getStringExtra("message");

        if(firstname.equals("Male"))
        {
            firstname = "Mr.";
        }
        else if(firstname.equals("Female"))
        {
            firstname = "Mrs.";
        }


        gender.setText(firstname);
        uname.setText(username);
        if(firstname==null)
        {
            Toast.makeText(new_account_2.this, "no text is set", Toast.LENGTH_SHORT).show();
        }


        inbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = password.getText().toString().trim();
                String p = phone.getText().toString().trim();


                if(p.isEmpty())
                {
                    phone.setError("Enter Phone number");
                }
                else if (pass.isEmpty())
                {
                    password.setError("Enter Password");
                }
                else
                {
                    //if the password has value then it is come in this part
                    //if the phone has value then it is come in this part

                    //now check the phone number it is Valid or not
                 if(checkphone(p))
                 {
                     //this is blank because the phone is valid so nothing do only data pass to database
                 }
                 else
                 {

                 }




                    //insert the data, where username= username;
                     myDb.insertData2(username,pass,p);

                     Toast.makeText(new_account_2.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(new_account_2.this,otp_page.class);
                    startActivity(intent);
                }
            }
        });



    }



    private static boolean checkphone(String p) {
        Pattern s = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = s.matcher(p);
        return(m.find() && m.group().equals(p));

    }




}


