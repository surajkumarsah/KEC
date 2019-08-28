package com.example.KEC;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.HashMap;

public class Add_Stud_Activity extends AppCompatActivity {

    private EditText name;
    private EditText reg;
    private EditText branch;
    private EditText session;
    private EditText category;
    private EditText dob;
    private EditText mobile;
    private EditText address;

    private Button AddStudent;
    private ImageView Photo;
    private String saveCurrentDate, saveCurrentTime;
    private String productRandomKey;
    private String downloadImageUrl;
    private String inputName,inputReg,inputBranch,inputSession,inputAddress,inputDOB,inputMobile,inputCategory;
    private StorageReference StudentImagesRef;
    private DatabaseReference StudentRef;

    private static final int GalleryPick = 1;
    private Uri ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__stud_);



        name = (EditText) findViewById(R.id.name);
        reg = (EditText) findViewById(R.id.reg);
        branch = (EditText) findViewById(R.id.branch);
        session = (EditText) findViewById(R.id.session);
        category = (EditText) findViewById(R.id.catg);
        dob = (EditText) findViewById(R.id.DOB);
        mobile = (EditText) findViewById(R.id.mobile);
        address = (EditText) findViewById(R.id.add);

        AddStudent = (Button) findViewById(R.id.add_stud);
        Photo = (ImageView) findViewById(R.id.photo);

        StudentImagesRef = FirebaseStorage.getInstance().getReference().child("Students");
        //StudentRef = FirebaseDatabase.getInstance().getReference().child("Students");

        Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openGallery();
            }
        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                validateStudentAccount();

            }
        });

    }

    private void openGallery()
    {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GalleryPick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GalleryPick && resultCode == RESULT_OK && data!=null)
        {
            ImageUri = data.getData();
            Photo.setImageURI(ImageUri);
        }
    }




    private void validateStudentAccount()
    {
         inputName = name.getText().toString();
         inputReg = reg.getText().toString();
         inputBranch = branch.getText().toString();
         inputSession = session.getText().toString();
         inputAddress = address.getText().toString();
         inputDOB = dob.getText().toString();
         inputMobile = mobile.getText().toString();
         inputCategory = category.getText().toString();

        if(ImageUri == null)
        {
            Toast.makeText(this,"Product Image is mandatory.",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(inputName))
        {
            Toast.makeText(this,"Please Enter Name of Student.",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(inputReg))
        {
            Toast.makeText(this,"Please Enter Registration no. of Student.",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(inputBranch))
        {
            Toast.makeText(this,"Please Enter Branch of Student.",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(inputDOB))
        {
            Toast.makeText(this,"Please Enter DOB of Student.",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(inputMobile))
        {
            Toast.makeText(this,"Please Enter Mobile no. of Student.",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(inputCategory))
        {
            Toast.makeText(this,"Please Enter Category of Student.",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(inputSession))
        {
            Toast.makeText(this,"Please Enter Session of Student.",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(inputAddress))
        {
            Toast.makeText(this,"Please Enter Address of Student.",Toast.LENGTH_SHORT).show();
        }
        else
        {
            StoreStudentInformation();
        }

    }

   private void StoreStudentInformation()
    {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,YYYY");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

       productRandomKey = saveCurrentDate + saveCurrentTime;

        final StorageReference filePath = StudentImagesRef.child(ImageUri.getLastPathSegment() + productRandomKey + ".jpg");
        final UploadTask uploadTask = filePath.putFile(ImageUri);


        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                String message = e.toString();
                Toast.makeText(Add_Stud_Activity.this,"Error : "+ message,Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
            {
                Toast.makeText(Add_Stud_Activity.this,"Image Uploaded Successfully.",Toast.LENGTH_SHORT).show();

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
                    {
                        if(!task.isSuccessful())
                        {
                            throw task.getException();
                        }

                        downloadImageUrl = filePath.getDownloadUrl().toString();
                        return filePath.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task)
                    {
                        if(task.isSuccessful())
                        {
                            downloadImageUrl = task.getResult().toString();

                            Toast.makeText(Add_Stud_Activity.this,"got the Photo image URL Successfully.",Toast.LENGTH_SHORT).show();

                            saveStudentInfoToDatabase();
                        }
                    }
                });
            }
        });


    }

    private void saveStudentInfoToDatabase()
    {

        //StudentRef = FirebaseDatabase.getInstance().getReference().child("Students");

        StudentRef = FirebaseDatabase.getInstance().getReference();

        StudentRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(!(dataSnapshot.child("Students").child(inputReg).exists()))
                {
                    HashMap<String, Object> StudDetails = new HashMap<>();
                    StudDetails.put("registration", inputReg);
                    StudDetails.put("date",saveCurrentDate);
                    StudDetails.put("time",saveCurrentTime);
                    StudDetails.put("name", inputName);
                    StudDetails.put("dob", inputDOB);
                    StudDetails.put("category", inputCategory);
                    StudDetails.put("session", inputSession);
                    StudDetails.put("mobile", inputMobile);
                    StudDetails.put("branch", inputBranch);
                    StudDetails.put("address", inputAddress);
                    StudDetails.put("Image", downloadImageUrl);

                    StudentRef.child("Students").child(inputReg).updateChildren(StudDetails)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Add_Stud_Activity.this,"Congratulation, Student Details has been created Successfully.",Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Add_Stud_Activity.this,Home_Activity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(Add_Stud_Activity.this,"Network Error, Please try again after Sometime.",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }
                else{
                    Toast.makeText(Add_Stud_Activity.this,"This "+inputReg+" already Exists.",Toast.LENGTH_SHORT).show();

                    Toast.makeText(Add_Stud_Activity.this, "Registration number is already exist try again from another registration number.",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Add_Stud_Activity.this,MainActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

}
