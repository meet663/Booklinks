package com.example.booklinks_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   // DatabaseHelper myDb;
  //  EditText editname, editvalue, editdata;
    Button insertdata,newAcc,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        newAcc = findViewById(R.id.newAcc);
        button = findViewById(R.id.button);
//        myDb=new DatabaseHelper(this);

//        editname = findViewById(R.id.editname);
//        editvalue = findViewById(R.id.editvalue);
//        editdata = findViewById(R.id.editdata);
        //      insertdata = findViewById(R.id.insertdata);
        //newAcc = findViewById(R.id.newAcc);
        // button = findViewById(R.id.button);


      //insertdata.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
         //       String nam = editname.getText().toString().trim();
         //       String email = editvalue.getText().toString().trim();
               // String pass = editdata.getText().toString().trim();

             //   Toast.makeText(MainActivity.this, editdata.getText().toString(), Toast.LENGTH_LONG).show();

            //    Intent i = new Intent(getApplicationContext(), new_account_1.class);
          //      i.putExtra("nam",nam);
               // startActivity(i);
                  //myDb.insertData002(nam, email, pass);
            //}
        //});

        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,new_account_1.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,login_page.class);
                startActivity(i);
            }
        });

    }
}
//        adddata();
//


   // }

//   // private void adddata() {
//
//        insertdata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String nam=editdata.getText().toString().trim();
//                String email=editdata.getText().toString().trim();
//                String pass=editdata.getText().toString().trim();
//
//                Toast.makeText(MainActivity.this, editdata.getText().toString(), Toast.LENGTH_LONG).show();
//                 myDb.insertData(nam,email,pass);
////                if(isInserted == true)
////                {
////                    Toast.makeText(MainActivity.this, "data is inserted", Toast.LENGTH_LONG).show();
////                }
////                else {
////                    Toast.makeText(MainActivity.this, "data is not insert", Toast.LENGTH_SHORT).show();
////                }
//            }
//
//        });
//    //}


//}


