package com.sarveshsbibhuty.internaladg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class meetings extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
     //   Intent intent = getIntent();
      //  final Bundle extras = intent.getExtras();
       // assert extras != null;
       // final String tmp = extras.getString("re");
        final TextView agendaone;
        final TextView agendatwo;
        final TextView agendathree;
        final String s= getIntent().getStringExtra("reg");


        final TextView dateone ;
        final TextView datetwo;
        final TextView datethree ;


        //tv refers to time and venue text view attribute
        final TextView tvone;
        final TextView tvtwo;
        final TextView tvthree;

        agendaone=(TextView)findViewById(R.id.agendaone);
        agendatwo=(TextView)findViewById(R.id.agendatwo);
        agendathree=(TextView)findViewById(R.id.agendathree);


        dateone =(TextView)findViewById(R.id.dateone);
        datetwo =(TextView)findViewById(R.id.datetwo);
        datethree =(TextView)findViewById(R.id.datethree);


        //tv refers to time and venue textview attribute
        tvone=(TextView)findViewById(R.id.timevenueone);
        tvtwo=(TextView)findViewById(R.id.timevenuetwo);
        tvthree=(TextView)findViewById(R.id.timevenuethree);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference agenda1=myref.child("meetings").child("meetingone").child("agenda");

        DatabaseReference agenda2=myref.child("meetings").child("meetingtwo").child("agenda");
        DatabaseReference agenda3=myref.child("meetings").child("meetingthree").child("agenda");



        DatabaseReference date1=myref.child("meetings").child("meetingone").child("date");
        DatabaseReference date2=myref.child("meetings").child("meetingtwo").child("date");
        DatabaseReference date3=myref.child("meetings").child("meetingthree").child("date");

        DatabaseReference tv1=myref.child("meetings").child("meetingone").child("timeandvenue");
        DatabaseReference tv2=myref.child("meetings").child("meetingtwo").child("timeandvenue");
        DatabaseReference tv3=myref.child("meetings").child("meetingthree").child("timeandvenue");


        agenda1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String agendayo=dataSnapshot.getValue(String.class);
                agendaone.setText(agendayo);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(", Toast.LENGTH_SHORT);

            }
        });

        agenda2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String agenda=dataSnapshot.getValue(String.class);
                agendatwo.setText(agenda);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT);

            }
        });

        agenda3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String agenda=dataSnapshot.getValue(String.class);
                agendathree.setText(agenda);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT);

            }
        });

        date1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String date=dataSnapshot.getValue(String.class);
                dateone.setText(date);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT);

            }
        });

        date2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String date=dataSnapshot.getValue(String.class);
                datetwo.setText(date);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();

            }
        });

        date3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String date=dataSnapshot.getValue(String.class);
                datethree.setText(date);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();

            }
        });

        tv1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String timevenue=dataSnapshot.getValue(String.class);
                tvone.setText(timevenue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();

            }
        });

        tv2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String timevenue=dataSnapshot.getValue(String.class);
                tvtwo.setText(timevenue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();

            }
        });


        tv3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String timevenue=dataSnapshot.getValue(String.class);
                tvthree.setText(timevenue);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"DATABASE ERROR :(",Toast.LENGTH_SHORT).show();

            }
        });


        ImageButton back=(ImageButton)findViewById(R.id.backid);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(meetings.this,mainpage.class).putExtra("reg",s);
             //  Bundle b = new Bundle();
        //        b.putString("re", tmp);
         //       intent.putExtras(b);
                startActivity(intent);

            }
        });



    }
}
