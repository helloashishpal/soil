package com.example.soil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.soil.databinding.ActivityDataEntryBinding;

public class DataEntry extends AppCompatActivity {
    ActivityDataEntryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataEntryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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