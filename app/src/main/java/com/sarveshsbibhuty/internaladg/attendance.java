package com.sarveshsbibhuty.internaladg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class attendance extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
      //  Intent intent = getIntent();
       // final Bundle extras = intent.getExtras();
        //assert extras != null;
       // final String tmp = extras.getString("re");
        final String s= getIntent().getStringExtra("reg");
        ImageButton back =(ImageButton) findViewById(R.id.backid);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(attendance.this,mainpage.class).putExtra("reg",s);
            //    Bundle b = new Bundle();
             //   b.putString("re", tmp);
              //  intent.putExtras(b);
                startActivity(intent);
            }
        });
    }


}
