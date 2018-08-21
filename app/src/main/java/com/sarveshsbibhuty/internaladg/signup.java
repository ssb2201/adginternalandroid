package com.sarveshsbibhuty.internaladg;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {


    EditText reg,name,password;
    ImageButton btnsignup;
    TextView login;


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        name=(EditText)findViewById(R.id.name);
        reg = (EditText)findViewById(R.id.reg);
        password =(EditText)findViewById(R.id.password);
        btnsignup =(ImageButton)findViewById(R.id.btnup);
        login = (TextView)findViewById(R.id.signin);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String na =  name.getText().toString();
                final String re = reg.getText().toString().toUpperCase();
                final String pas = password.getText().toString();

                if(TextUtils.isEmpty(na))
                {
                    Toast.makeText(getApplicationContext(),"Enter name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(re))
                {
                    Toast.makeText(getApplicationContext(),"Enter registration number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(pas))
                {
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                FirebaseDatabase database = FirebaseDatabase.getInstance();
               final DatabaseReference myRef = database.getReference("Users").child(re);

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {


                            Toast.makeText(getApplicationContext(), "Account Exists",Toast.LENGTH_SHORT).show();

                          }
                        else
                        {
                            user User = new user(re,na,pas,true,"","","");

                            myRef.setValue(User);
                            Toast.makeText(getApplicationContext(), "Account successfully made",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(signup.this,login.class);
                            startActivity(i);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });






            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
