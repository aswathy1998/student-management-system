package com.example.aswathy.studentmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminupdateActivity extends AppCompatActivity {

    EditText a1,a2,a3,a4,a5;
    TextView t1,t2;
    Button b,b1;
    String s1,s2,getid,s3,s4,branch;
    Dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminupdate);

        a1=(EditText)findViewById(R.id.exdt);
        a2=(EditText)findViewById(R.id.exdt1);
        a3=(EditText)findViewById(R.id.exrs);
        a4=(EditText)findViewById(R.id.exrs1);
        a5=(EditText)findViewById(R.id.branch);
        t1=(TextView)findViewById(R.id.ex1);
        t2=(TextView)findViewById(R.id.ex2);

        b=(Button) findViewById(R.id.up);

        b1=(Button) findViewById(R.id.bk);
        db=new Dbhelper(this);
        db.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),AdminActivity.class);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                t1.setVisibility(view.VISIBLE);
                t2.setVisibility(view.VISIBLE);

                s1=a1.getText().toString();



                boolean status=db.insertdata2(s1,s2,branch);
                if(status==true){
                    Toast.makeText(getApplicationContext(),"successfully inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }

//update date
                s2=a1.getText().toString();

                boolean status1=db.updateData(getid,s2);
                if(status1==true){
                    Toast.makeText(getApplicationContext(),"UPDATED SUCESSFULLY",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR IN UPDATION",Toast.LENGTH_LONG).show();
                }
                a2.setText(s2);
                a2.setVisibility(view.VISIBLE);

                //            update exam results

                s4=a3.getText().toString();

                boolean status2=db.updateData(getid,s4);
                if(status2==true){
                    Toast.makeText(getApplicationContext(),"UPDATED SUCESSFULLY",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR IN UPDATION",Toast.LENGTH_LONG).show();
                }
                a4.setText(s4);
                a4.setVisibility(view.VISIBLE);

//                update branch

                branch=a5.getText().toString();

                boolean status3=db.updateData(getid,branch);
                if(status3==true){
                    Toast.makeText(getApplicationContext(),"BRANCH UPDATED SUCESSFULLY",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR IN UPDATION",Toast.LENGTH_LONG).show();
                }
                a5.setText(branch);

            }




        });


    }

}
