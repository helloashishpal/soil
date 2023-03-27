package com.example.soil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.soil.databinding.ActivityFetchDataBinding;

public class FetchData extends AppCompatActivity {
    ActivityFetchDataBinding binding;
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
    }
}