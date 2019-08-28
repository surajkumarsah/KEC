package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Semester_Mech_Activity extends AppCompatActivity {

    private ImageView Semester1, Semester2,Semester3,Semester4,Semester5,Semester6,Semester7,Semester8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester__mech_);

        Semester1 = (ImageView) findViewById(R.id.sem1);
        Semester2 = (ImageView) findViewById(R.id.sem2);
        Semester3 = (ImageView) findViewById(R.id.sem3);
        Semester4 = (ImageView) findViewById(R.id.sem4);
        Semester5 = (ImageView) findViewById(R.id.sem1);
        Semester6 = (ImageView) findViewById(R.id.sem1);
        Semester7 = (ImageView) findViewById(R.id.sem1);
        Semester8 = (ImageView) findViewById(R.id.sem1);

        Semester1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem1_Mech_Activity.class);
                startActivity(intent);
            }
        });


        Semester2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem2_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem3_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem4_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem5_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem6_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem7_Mech_Activity.class);
                startActivity(intent);
            }
        });

        Semester8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Mech_Activity.this,Syll_Sem8_Mech_Activity.class);
                startActivity(intent);
            }
        });



    }
}
