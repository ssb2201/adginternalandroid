package com.sarveshsbibhuty.internaladg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class mainpage extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String reg = "regKey";

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
       // final String sa= getIntent().getStringExtra("reg");
        ImageButton attendance=(ImageButton)findViewById(R.id.att);
        ImageButton meetings=(ImageButton)findViewById(R.id.meet);
        ImageButton work=(ImageButton)findViewById(R.id.work);
        ImageButton btnlogout =(ImageButton)findViewById(R.id.btnout);
        final String s= getIntent().getStringExtra("reg");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref1 =ref.child("Users");
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();



        SharedPreferences myref= getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myref.edit();
        editor.putString("reg", s);
        editor.commit();



        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,attendance.class).putExtra("reg",s);
                startActivity(intent);
            }
        });

        meetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mainpage.this,meetings.class).putExtra("reg",s);
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i=new Intent(mainpage.this,work.class).putExtra("reg",s);
                 startActivity(i);

            }
        });


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainpage.this,login.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
