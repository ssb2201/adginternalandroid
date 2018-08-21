package com.sarveshsbibhuty.internaladg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class work extends AppCompatActivity {
    TextView workone;
    TextView worktwo;
    TextView workthree;
  //
  public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        final String s= getIntent().getStringExtra("reg");
        workone=(TextView) findViewById(R.id.workone);
        worktwo=(TextView)findViewById(R.id.worktwo);
        workthree=(TextView)findViewById(R.id.workthree);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        SharedPreferences myref= getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final String username=myref.getString("reg","NOTHING");

        DatabaseReference worktitletwo=database.getReference("Users").child(username);
        DatabaseReference workonef = worktitletwo.child("workone");
        DatabaseReference worktwof= worktitletwo.child("worktwo");
        DatabaseReference workthreef = worktitletwo.child("workthree");



        workonef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String data=dataSnapshot.getValue(String.class);
                 workone.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();
            }
        });


        worktwof.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String data=dataSnapshot.getValue(String.class);
               worktwo.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();
            }
        });
        workthreef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String data=dataSnapshot.getValue(String.class);
                workthree.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();
            }
        });



        ImageButton back =(ImageButton) findViewById(R.id.backid);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(work.this,mainpage.class).putExtra("reg",username);

                startActivity(i);
            }
        });



    }
}
