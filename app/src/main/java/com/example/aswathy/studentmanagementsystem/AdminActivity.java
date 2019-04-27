package com.example.aswathy.studentmanagementsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends AppCompatActivity {

    EditText a1,a2;
    Button b1,b2;
    String getusername,getpassword,checkusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        a1=(EditText)findViewById(R.id.uname);
        a2=(EditText)findViewById(R.id.pass);
        b1=(Button) findViewById(R.id.Adlogin);
        b2=(Button) findViewById(R.id.logout);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getusername=a1.getText().toString();
                getpassword=a2.getText().toString();
                if(getusername.equals("admin")&&getpassword.equals("admin123"))
                {
                    SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                    editor.putString("username",getusername);
                    editor.putString("password",getpassword);
                    editor.apply();

                    Intent i=new Intent(getApplicationContext(),adminupdateActivity.class);

                    i.putExtra("username",getusername);
                    i.putExtra("password",getpassword);

                    startActivity(i);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
