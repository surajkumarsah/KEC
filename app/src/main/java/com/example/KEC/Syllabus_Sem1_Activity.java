package com.example.KEC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Syllabus_Sem1_Activity extends AppCompatActivity {

    private Button Button1,Button2;
    private TextView Text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus__sem1_);
        Button1 = (Button) findViewById(R.id.btn1);
        Button2 = (Button) findViewById(R.id.btn2);
        Text1 = (TextView) findViewById(R.id.text1);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button2.setVisibility(View.INVISIBLE);
                Text1.setVisibility(View.VISIBLE);
            }
        });

    }
}
