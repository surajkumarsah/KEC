package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile_Activity extends AppCompatActivity {

    private Button studadd,SemesterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        studadd = (Button) findViewById(R.id.addstud);
        SemesterBtn = (Button) findViewById(R.id.sem_btn);

        studadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this,Add_Stud_Activity.class);
                startActivity(intent);
            }
        });

        SemesterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile_Activity.this,Semester_Activity.class);
                startActivity(intent);
            }
        });
    }
}
