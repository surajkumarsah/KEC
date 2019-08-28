package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Activity extends AppCompatActivity {

    private Button AddStudents, SemesterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_);

        AddStudents = (Button) findViewById(R.id.add_students);


        AddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Admin_Activity.this,Add_Stud_Activity.class);
                startActivity(intent);
            }
        });


    }
}
