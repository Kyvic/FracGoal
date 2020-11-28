package com.mmu.fracgoal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class SearchVideo extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Videos> list;
    SearchView searchView;
    RecyclerView recyclerView;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchvideo);

        ref = FirebaseDatabase.getInstance().getReference().child("Videos");
        searchView = findViewById(R.id.searchViewVideo);
        recyclerView = findViewById(R.id.result_listVideo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    protected void onStart() {
        super.onStart();
        if (ref != null) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            list.add(ds.getValue(Videos.class));
                        }
                        VideoAdapterClass adapterClass = new VideoAdapterClass(SearchVideo.this,list);
                        recyclerView.setAdapter(adapterClass);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(SearchVideo.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }


        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;

                }

            });
        }

    }
    private void search(String str)
    {
        ArrayList<Videos> myList = new ArrayList<>();
        for (Videos object : list)
        {
            if(object.getVideoName().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }
        }
        VideoAdapterClass adapterClass = new VideoAdapterClass(SearchVideo.this,myList);
        recyclerView.setAdapter(adapterClass);
    }

}
