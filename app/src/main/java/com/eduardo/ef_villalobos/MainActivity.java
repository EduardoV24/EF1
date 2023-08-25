package com.eduardo.ef_villalobos;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import com.eduardo.ef_villalobos.databinding.ActivityMainBinding;
import com.eduardo.ef_villalobos.fragments.HomeFragment;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public static String EMAIL = "EMAIL";
    private String email;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.tbEf);
        addHomeFragment();
    }



    private void addHomeFragment() {
        getSupportFragmentManager().
                beginTransaction()
                .add(binding.fcvApp.getId(), new HomeFragment()).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.favorites){
            Snackbar.make(binding.getRoot(), "favorites", Snackbar.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.logout) {
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }



}


