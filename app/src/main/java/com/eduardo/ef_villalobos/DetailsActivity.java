package com.eduardo.ef_villalobos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eduardo.ef_villalobos.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }




}