package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Semester_Activity extends AppCompatActivity {

    private ImageView Semester1, Semester2,Semester3,Semester4,Semester5,Semester6,Semester7,Semester8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_);

        Semester1 = (ImageView) findViewById(R.id.sem1);
        Semester3 = (ImageView) findViewById(R.id.sem3);
        Semester4 = (ImageView) findViewById(R.id.sem4);
        Semester5 = (ImageView) findViewById(R.id.sem5);
        Semester6 = (ImageView) findViewById(R.id.sem6);
        Semester7 = (ImageView) findViewById(R.id.sem7);
        Semester8 = (ImageView) findViewById(R.id.sem8);

        Semester1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syllabus_Sem1_Activity.class);
                startActivity(intent);
            }
        });

        Semester2 = (ImageView) findViewById(R.id.sem2);

        Semester2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem2_Activity.class);
                startActivity(intent);
            }
        });

        Semester3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem3_Activity.class);
                startActivity(intent);
            }
        });

        Semester4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem4_Activity.class);
                startActivity(intent);
            }
        });

        Semester5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem5_Activity.class);
                startActivity(intent);
            }
        });

        Semester6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem6_Activity.class);
                startActivity(intent);
            }
        });

        Semester7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem7_Activity.class);
                startActivity(intent);
            }
        });

        Semester8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Semester_Activity.this,Syll_Sem7_Activity.class);
                startActivity(intent);
            }
        });

    }
}
