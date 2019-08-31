package com.example.KEC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.KEC.Model.Admins;
import com.example.KEC.Model.Faculties;
import com.example.KEC.Model.Users;
import com.example.KEC.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class Login_Activity extends AppCompatActivity {

    private Button LoginButton;
    private EditText LoginID;
    private EditText Password;
    private TextView AdminLink, FacultyLink, NotAdminPanel;
    private String parentDbName = "Users";
    private com.rey.material.widget.CheckBox chkBoxRememberMe;
    ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        LoginButton = (Button) findViewById(R.id.login_btn);
        LoginID = (EditText) findViewById(R.id.login_id);
        Password = (EditText) findViewById(R.id.password);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        FacultyLink = (TextView) findViewById(R.id.faculty_panel_link);
        NotAdminPanel = (TextView) findViewById(R.id.not_admin_panel_link);
        loadingBar = new ProgressDialog(this);

        //Using Android Memory ...
        chkBoxRememberMe = (com.rey.material.widget.CheckBox) findViewById(R.id.remember_me_chkb);
        Paper.init(this);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                   LoginButton.setText("Admin Login");
                   NotAdminPanel.setVisibility(View.VISIBLE);
                   FacultyLink.setVisibility(View.INVISIBLE);
                   AdminLink.setVisibility(View.INVISIBLE);
                   parentDbName = "Admins";

            }
        });

        FacultyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Faculty Login");
                NotAdminPanel.setVisibility(View.VISIBLE);
                FacultyLink.setVisibility(View.INVISIBLE);
                AdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Faculties";
            }
        });

        NotAdminPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                NotAdminPanel.setVisibility(View.INVISIBLE);
                FacultyLink.setVisibility(View.VISIBLE);
                AdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Users";

            }
        });






    }

    private void LoginUser()
    {
        String login_id = LoginID.getText().toString();
        String password = Password.getText().toString();

        if(TextUtils.isEmpty(login_id))
        {
            Toast.makeText(Login_Activity.this,"Please, Enter login ID.",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(Login_Activity.this,"Please, Enter Password.",Toast.LENGTH_SHORT).show();
        }
        else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking your credentials.");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                AllowAccessToAccount(login_id,password);
        }

    }

    private void AllowAccessToAccount(final String login_id,final String password)
    {

        //Remember me to save data in android...
        if(chkBoxRememberMe.isChecked())
        {
            Paper.book().write(Prevalent.UserPhoneKey, login_id);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }

        //DB connectivity...
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(dataSnapshot.child(parentDbName).child(login_id).exists())
                {
                    Users userData = dataSnapshot.child(parentDbName).child(login_id).getValue(Users.class);
                    Admins adminData = dataSnapshot.child(parentDbName).child(login_id).getValue(Admins.class);
                    Faculties facultyData = dataSnapshot.child(parentDbName).child(login_id).getValue(Faculties.class);

                    if(userData.getPhone().equals(login_id))
                    {
                        if(userData.getPassword().equals(password))
                        {
                            if(parentDbName.equals("Users"))
                            {
                                Toast.makeText(Login_Activity.this,"User logged in Successfully.",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login_Activity.this,Profile_Activity.class);
                                Prevalent.currentOnlineUser = userData;
                                startActivity(intent);
                            }
                            else if(parentDbName.equals("Admins"))
                            {
                                Toast.makeText(Login_Activity.this,"Admin logged in Successfully.",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login_Activity.this,Profile_Activity.class);
                                startActivity(intent);
                            }
                            else if(parentDbName.equals("Faculties"))
                            {
                                Toast.makeText(Login_Activity.this,"Faculties logged in Successfully.",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login_Activity.this,Profile_Activity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Login_Activity.this,"Error in Logged in",Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login_Activity.this,Login_Activity.class);
                                startActivity(intent);
                            }

                        }
                    }
                }

                else
                {
                    Toast.makeText(Login_Activity.this,"Account with this "+login_id+" is not Exist.",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(Login_Activity.this,"You have to create a new Account.,",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
