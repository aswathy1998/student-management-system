package com.example.aswathy.studentmanagementsystem;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class notificationActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView t1,t2;
    Button b1;
    String s1,s2,s3,o,p;
    Dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        e1=(EditText)findViewById(R.id.exdt);
        e2=(EditText)findViewById(R.id.exrs);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        e3=(EditText)findViewById(R.id.branch);
        b1=(Button) findViewById(R.id.up);

        db=new Dbhelper(this);
        db.getWritableDatabase();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();

//search

                Cursor cur=db.searchdata1("mba");
                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no code found",Toast.LENGTH_LONG).show();
                }
                else {
                    while (cur.moveToNext()) {
                        b1.setVisibility(view.VISIBLE);

                        p = cur.getString(1);
                        o = cur.getString(2);
                        t1.setVisibility(view.VISIBLE);
                        e1.setVisibility(view.VISIBLE);
                        e1.setText(p);
                        // Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                        t2.setVisibility(view.VISIBLE);
                        e2.setVisibility(view.VISIBLE);
                        e2.setText(o);


//                        s3 = cur.getString(3);
                        // Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();


                    }
                }
                    }
        });


    }

        }