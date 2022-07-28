package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.regex.Pattern;

public class new_account_1 extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText Firstname,lastname,email,uname;
    ImageButton inbutton;
    // ProgressBar spinner;
    ImageView backbtn;
    TextView skip;
    RadioGroup radioGroup;
    String u;

    RadioButton selectedRadioButton;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account_1);
        Objects.requireNonNull(getSupportActionBar()).hide();

        myDb=new DatabaseHelper(this);

        Firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        uname = findViewById(R.id.uname);
        inbutton = findViewById(R.id.inbutton);

        radioGroup =findViewById(R.id.radioGroup);

        skip = findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homepage = new Intent(new_account_1.this,home_screen.class);
                startActivity(homepage);
            }
        });

//        spinner=(ProgressBar)findViewById(R.id.progressBar);
//        spinner.setVisibility(View.GONE);

        backbtn = findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(new_account_1.this,MainActivity.class);
             startActivity(intent);
             /*    Bundle extras = getIntent().getExtras();
               if (extras != null) {
                    hello = extras.getString("nam");
                }
                Toast.makeText(new_account_1.this, hello, Toast.LENGTH_SHORT).show();
               */ }
        });



        inbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String f1 = Firstname.getText().toString().trim();
                String l1 = lastname.getText().toString().trim();
                String e = email.getText().toString().trim();
                String un = uname.getText().toString().trim();
                if (f1.isEmpty())
                {
                    Firstname.setError("Enter First Name");
                }
                else if (l1.isEmpty())
                {
                    lastname.setError("Enter Last Name");
                }
                else if (e.isEmpty())
                {
                    email.setError("Enter E-mail");
                }
                else if (un.isEmpty())
                {
                    uname.setError("Enter Username");
                  }
                else
                {
                    Boolean b = isValid(e);

                    if(b)
                    {
                        selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                        String m = selectedRadioButton.getText().toString();
                        if(m==null)
                        {
                            Toast.makeText(new_account_1.this, "Select Gender", Toast.LENGTH_SHORT).show();
                        }



                        myDb.insertData(f1,l1,e,un,m);
                        Toast.makeText(new_account_1.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();





                        // Intent j = new Intent(getApplicationContext(),new_account_2.class);
                       // j.putExtra("un",un);
                       // startActivity(j);


                        //the intent i will send the username to second page account_2
                        Intent i = new Intent(getApplicationContext(),new_account_2.class);
                        i.putExtra("un",un);
                        i.putExtra("message", f1);
                        i.putExtra("gender",m);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(new_account_1.this, "enter valid email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }





                  /*  if(isValid(e))
                    {
                        //if the firstname,lastname,email,username has value then it is come in this part

                        String m="";
                        if (male.isChecked())
                        {
                            m = "male";
                        }
                        else if (female.isChecked())
                        {
                            m = "female";
                        }
                        if (m =="")
                        {
                            Toast.makeText(new_account_1.this, "Select Gender", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //insert data method is called by this method
                            myDb.insertData(f1,l1,e,un,m);

                            //spinner.setVisibility(View.VISIBLE);
                            Toast.makeText(new_account_1.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();

                            //the intent i will send the username to second page account_2
                          //  Intent i = new Intent(getApplicationContext(), new_account_2.class);
                          //  i.putExtra("un",un);
                          //  startActivity(i);

                            //the intent j will send the firstname to second page account_2 it will show the name on screen
                           // Intent j = new Intent(getApplicationContext(),new_account_2.class);
                           // j.putExtra("first",f1);
                           // startActivity(j);
                    */
                           // Toast.makeText(new_account_1.this, un, Toast.LENGTH_SHORT).show();

/*
                        }
                    }
                    else
                        {
                            Toast.makeText(new_account_1.this, "enter valid email", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        }



    }

 */
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }



}


