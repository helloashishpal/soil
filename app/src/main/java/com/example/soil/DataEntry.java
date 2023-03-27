package com.example.soil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.soil.databinding.ActivityDataEntryBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataEntry extends AppCompatActivity {
    ActivityDataEntryBinding binding;
    String state,district,soilType;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataEntryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state=binding.stateEntry.getText().toString();
                district=binding.districtEntry.getText().toString();
                soilType=binding.soilTypeEntry.getText().toString();

                if(!state.isEmpty() && !district.isEmpty() && !soilType.isEmpty()){
                    soilData soil=new soilData(state,district,soilType);
                    db=FirebaseDatabase.getInstance();
                    reference=db.getReference("soilData");
                    reference.child(district).setValue(soil).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.stateEntry.setText("");
                            binding.districtEntry.setText("");
                            binding.soilTypeEntry.setText("");
                            Toast.makeText(DataEntry.this,"Successfully Data Recorded",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DataEntry.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}