package com.example.aswathy.studentmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button b1,b2;
    String s1,s2,s3,s4,s5;
    Dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1=(EditText)findViewById(R.id.sname);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.mobile);
        e4=(EditText)findViewById(R.id.usn);
        e5=(EditText)findViewById(R.id.pswd);
        b1=(Button)findViewById(R.id.reg);
        b2=(Button)findViewById(R.id.alreg);

        db=new Dbhelper(this);
        db.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();

               // Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();

                boolean status=db.insertdata(s1,s2,s3,s4,s5);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
