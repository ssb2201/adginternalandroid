package com.sarveshsbibhuty.internaladg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

import java.io.Serializable;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class login extends AppCompatActivity {


    EditText reg;
    EditText pass;
    ImageButton btnin;
    TextView create;
    String value;






    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        reg=(EditText)findViewById(R.id.reg);
        pass=(EditText)findViewById(R.id.password);
        btnin = (ImageButton) findViewById(R.id.btnlogin);
        create = (TextView) findViewById(R.id.create);

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String re= reg.getText().toString().toUpperCase();
                 final String pas = pass.getText().toString();








                if (TextUtils.isEmpty(re)) {
                    Toast.makeText(getApplicationContext(), "Enter registration number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pas)) {
                    Toast.makeText(getApplicationContext(), "Enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }


                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref1 =ref.child("Users");
                DatabaseReference ref2 =ref1.child(re);
                DatabaseReference ref3=ref2.child("password");

                ref3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            value=dataSnapshot.getValue(String.class);




                        if(value.equals(pas)) {




                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(login.this,mainpage.class).putExtra("reg",re);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Incorrect Input",Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });








            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
