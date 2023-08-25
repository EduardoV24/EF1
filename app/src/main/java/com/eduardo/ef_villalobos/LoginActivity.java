package com.eduardo.ef_villalobos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eduardo.ef_villalobos.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;

    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";
    public static String SESSION_ACTIVATED= "SESSION_ACTIVATED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE, MODE_PRIVATE);
        boolean isSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
        if (isSessionActivated) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        binding.btnIngresar.setEnabled(false);
        binding.btnIngresar.setOnClickListener(v -> {
            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();

            String email = binding.tlEmail.getEditText().getText().toString();
            String password = binding.tlPassword.getEditText().getText().toString();

            if (email.equals("ejemplo@idat.com.pe") && password.equals("Peru123.")) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(MainActivity.EMAIL, binding.tlEmail.getEditText().getText().toString());
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        });


        binding.tlEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateCredentials();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.tlPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateCredentials();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void validateCredentials() {
        String email = binding.tlEmail.getEditText().getText().toString();
        String password = binding.tlPassword.getEditText().getText().toString();
        Boolean isOk = isCredentialsValid(email, password);
        binding.btnIngresar.setEnabled(isOk);
    }

    private Boolean isCredentialsValid(String email, String password) {
        Boolean isEmailValid = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Boolean isPasswordValid = password.equals("Peru123.");
        return isEmailValid && isPasswordValid;
    }










}

