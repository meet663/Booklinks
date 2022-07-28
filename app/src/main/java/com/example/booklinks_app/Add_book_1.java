package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Add_book_1 extends AppCompatActivity  {
    DatabaseHelper my;
    ImageView back_button,arrow_up;
    Spinner spinner;
    ImageButton round_button;
    String random_number;
    TextView textView20;
    EditText bname,authorname,pname,pyear;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_1);
        getSupportActionBar().hide();

        //edittext use
        bname = findViewById(R.id.bname);
        authorname = findViewById(R.id.authorname);
        pname = findViewById(R.id.pname);
        pyear = findViewById(R.id.pyear);

        //back button id find
        back_button = findViewById(R.id.back_button);

        round_button = findViewById(R.id.round_button);
        spinner = findViewById(R.id.spinner);

        //call the random method here
        random_number = getRandomNumberString();

        //drop down menu code
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(Add_book_1.this,
                android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.names));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        if(myadapter.equals("Choose Category"))
        {
            Toast.makeText(this, "Select", Toast.LENGTH_SHORT).show();
        }


        //check the data is enter or not by the user
        round_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String book_name = bname.getText().toString().trim();
                String author_name = authorname.getText().toString().trim();
                String publish_name = pname.getText().toString().trim();
                String publish_year = pyear.getText().toString().trim();
                String spinner_value = spinner.getSelectedItem().toString();
                String r = random_number.trim();

                if(book_name.isEmpty())
                {
                    bname.setError("Enter Book Name");
                }
                else if(author_name.isEmpty())
                {
                    authorname.setError("Enter Author Name");
                }
                else if(publish_name.isEmpty())
                {
                    pname.setError("Enter Publisher Name");
                }
                else if(publish_year.isEmpty())
                {
                    pyear.setError("Enter Publisher Year");
                }
                if(r==null)
                {
                    Toast.makeText(Add_book_1.this, "random number is not generated", Toast.LENGTH_SHORT).show();
                }
                String answer_fun;
                answer_fun = checktheyear(publish_year);

                if(answer_fun.equals("n"))
                {
                    Toast.makeText(Add_book_1.this, "Enter Valid Year", Toast.LENGTH_SHORT).show();
                }
                else
                {

                  //  my.insert_data_into_book_table (r, book_name, author_name, publish_name, publish_year, spinner_value);

                    Intent gotosecondpage = new Intent(Add_book_1.this,add_book_2.class);
                    startActivity(gotosecondpage);
                    Toast.makeText(Add_book_1.this, "Data Save Successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });







        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodhomepage = new Intent(Add_book_1.this,home_screen.class);
                startActivity(gotodhomepage);
            }
        });


    }



    private String checktheyear(String pubyear)
    {
        int i=1900;
        int j;
        String ans;
         j= Integer.valueOf(pubyear);
        if(j>i)
        {
            ans= "y";
        }
        else
        {
            ans = "n";
        }

        return ans;
    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }



}