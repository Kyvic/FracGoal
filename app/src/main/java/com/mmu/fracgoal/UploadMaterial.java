package com.mmu.fracgoal;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firestore.admin.v1beta1.Progress;

import java.net.URI;

public class UploadMaterial extends AppCompatActivity {
    Button selectFile, upload;
    TextView notification;
    Uri pdfUri; // uri are actually URLs that are meant for local storage

    FirebaseStorage storage; // used for uploadinginf files..Ex : pdf
    FirebaseDatabase database; // used to store URLs of uploaded files
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadvideo);

        storage = FirebaseStorage.getInstance(); //return an object of Firebase Storage
        database = FirebaseDatabase.getInstance(); //return an object of Firebase Database

        selectFile = findViewById(R.id.selectFile);
        upload = findViewById(R.id.upload);
        notification = findViewById(R.id.notification);

        selectFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(UploadMaterial.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectPdf();
                } else
                    ActivityCompat.requestPermissions(UploadMaterial.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
            }

        });

        upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(pdfUri!=null) // the user has selected the file
                    uploadFile(pdfUri);
                else
                    Toast.makeText(UploadMaterial.this,"Select a File", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void uploadFile(Uri pdfUri) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading file");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName = System.currentTimeMillis()+"" ;
        StorageReference storageReference = storage.getReference(); // returns root path

        storageReference.child("Uploads").child(fileName).putFile(pdfUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                String url = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();// return the url of your uploaded file
                // store the url in realtime database..
                DatabaseReference reference = database.getReference();

                reference.child(fileName).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                            Toast.makeText(UploadMaterial.this, "File successfully uploaded", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(UploadMaterial.this, "File not successfully uploaded", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                // track the progress of our upload
                int currentProgress = (int) (100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectPdf();
        }
        else
            Toast.makeText(UploadMaterial.this,"please provide permission..", Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==86 && resultCode==RESULT_OK && data!=null){
            pdfUri=data.getData(); // return the uri of selected file
            notification.setText("A file is selected: "+ data.getData().getLastPathSegment());
        }
        else{
            Toast.makeText(UploadMaterial.this,"Please select a file",Toast.LENGTH_SHORT).show();
        }
    }
    private void selectPdf() {
        // to offer user to select a file using file manager

        // we will be using an Intent

        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT); // to fetch files
        startActivityForResult(intent, 86);
    }


}
