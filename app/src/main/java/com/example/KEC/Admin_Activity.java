package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Activity extends AppCompatActivity {

    private Button studadd,SemesterBtn,UploadNotice,AddAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        studadd = (Button) findViewById(R.id.addstud);
        SemesterBtn = (Button) findViewById(R.id.sem_btn);
        UploadNotice = (Button) findViewById(R.id.upload_notice);
        AddAdmin = (Button) findViewById(R.id.add_admin);

        studadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Activity.this,Add_Stud_Activity.class);
                startActivity(intent);
            }
        });

        SemesterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Activity.this,Semester_Activity.class);
                startActivity(intent);
            }
        });

        UploadNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Activity.this,Upload_Notice_Activity.class);
                startActivity(intent);
            }
        });

        AddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Activity.this,Add_Admin_Activity.class);
                startActivity(intent);
            }
        });
    }
}
