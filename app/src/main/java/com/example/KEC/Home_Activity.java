package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home_Activity extends AppCompatActivity {

    private ImageView studentLogin;
    private ImageView adminLogin;
    private ImageView facultyLogin;
    private Button SemBtn,AdminPage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        studentLogin = (ImageView) findViewById(R.id.student_Login);
        adminLogin = (ImageView) findViewById(R.id.admin_Login);
        facultyLogin = (ImageView) findViewById(R.id.faculty_Login);





        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });

        facultyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });

        SemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this,Semester_Activity.class);
                startActivity(intent);
            }
        });

        AdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this,Admin_Activity.class);
                startActivity(intent);
            }
        });


    }
}
