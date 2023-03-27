package com.example.soil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.soil.databinding.ActivityFetchDataBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FetchData extends AppCompatActivity {
    ActivityFetchDataBinding binding;
    String state,district,soilType;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFetchDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FetchData.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        binding.findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state=binding.stateField.getText().toString();
                district=binding.districtField.getText().toString();
                if(!district.isEmpty()){
                    readData(district);
                }
                else{
                    Toast.makeText(FetchData.this,"Please Enter the details",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void readData(String district) {
        reference=FirebaseDatabase.getInstance().getReference("soilData");
        reference.child(district).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        Toast.makeText(FetchData.this,"Successfull!",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot= task.getResult();
                        soilType=String.valueOf(dataSnapshot.child("soilType").getValue());
                        binding.soilTypeField.setText(soilType);
                    }
                    else{
                        Toast.makeText(FetchData.this,"The details of the district doesn't exist in the database",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(FetchData.this,"Failed to fetch data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}