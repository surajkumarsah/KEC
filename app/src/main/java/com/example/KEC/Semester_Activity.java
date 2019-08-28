package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Semester_Activity extends AppCompatActivity {

    private ImageView Semester1, Semester2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_);

        Semester1 = (ImageView) findViewById(R.id.sem1);

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
                Intent intent = new Intent(Semester_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
