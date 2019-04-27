package com.example.aswathy.studentmanagementsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText a1,a2;
    Button b1,b2,b3;
    String s1,s2,dbname,dbpass;
    Dbhelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        a1=(EditText)findViewById(R.id.uname);
        a2=(EditText)findViewById(R.id.pass);
        b1=(Button) findViewById(R.id.login);
        b2=(Button) findViewById(R.id.register);
        b3=(Button) findViewById(R.id.admin);

        db=new Dbhelper(this);
        db.getWritableDatabase();


        SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
        String getname=preferences.getString("uname",null);
        if(getname!=null)
        {
            Intent i=new Intent(getApplicationContext(),StudentActivity.class);
            startActivity(i);
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=a1.getText().toString();
                s2=a2.getText().toString();


                s1=a1.getText().toString();
                Log.d("uname",s1);
                s2=a2.getText().toString();
                Log.d("password",s2);




                Cursor cur=db.searchdata(s1);

                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"username is invalid",Toast.LENGTH_LONG).show();
                }
                else {
                    while (cur.moveToNext())
                    {


                         dbname=cur.getString(1);
                         dbpass=cur.getString(5);

                        if(dbpass.equals(s2))
                        {

                            SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                            editor.putString("uname",dbname);
                            editor.apply();

                            Intent i=new Intent(getApplicationContext(),StudentActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"wrong password",Toast.LENGTH_LONG).show();
                        }

                        s2=cur.getString(2);
                        a2.setText(s2);
                    }
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),registerActivity.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),AdminActivity.class);
                startActivity(i);
            }
        });

    }
    }

