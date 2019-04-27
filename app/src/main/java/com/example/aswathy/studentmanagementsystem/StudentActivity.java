package com.example.aswathy.studentmanagementsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10;
    Button b1,b2,b3;
    String r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    Dbhelper db;


    String sname;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        ed1=(EditText)findViewById(R.id.sname);
        ed2=(EditText)findViewById(R.id.adr);
        ed3=(EditText)findViewById(R.id.sex);
        ed4=(EditText)findViewById(R.id.college);
        ed5=(EditText)findViewById(R.id.dob);
        ed6=(EditText)findViewById(R.id.email);
        ed7=(EditText)findViewById(R.id.mob);
        ed8=(EditText)findViewById(R.id.place);
        ed9=(EditText)findViewById(R.id.dist);
        ed10=(EditText)findViewById(R.id.state);

        b1=(Button)findViewById(R.id.aply);
        b2=(Button)findViewById(R.id.prvs);


        db=new Dbhelper(this);
        db.getWritableDatabase();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                r1=ed1.getText().toString();
                r2=ed2.getText().toString();
                r3=ed3.getText().toString();
                r4=ed4.getText().toString();
                r5=ed5.getText().toString();
                r6=ed6.getText().toString();
                r7=ed7.getText().toString();
                r8=ed8.getText().toString();
                r9=ed9.getText().toString();
                r10=ed10.getText().toString();



                if (r1.equals(sname))
                {
                    Intent a=new Intent(getApplicationContext(),welcomeActivity.class);
                    startActivity(a);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"incorrect name",Toast.LENGTH_LONG).show();
                }

                boolean status=db.insertdata1(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }


                Intent i=new Intent(getApplicationContext(),welcomeActivity.class);
                startActivity(i);

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
