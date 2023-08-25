package com.eduardo.ef_villalobos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
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
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE, MODE_PRIVATE);

        binding.btnIngresar.setOnClickListener(v -> {
            //Toast.makeText(this, "Login press", Toast.LENGTH_SHORT).show();

            sharedPreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.EMAIL, binding.tlEmail.getEditText().getText().toString());
            startActivity(intent);
            finish();
        });

        binding.tlEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValidate(s.toString(), binding.tlPassword.getEditText().getText().toString());
                binding.btnIngresar.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //--------------------------------------------------------------------------------

        binding.tlPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Boolean isOk = isCredentialsValidate(binding.tlEmail.getEditText().getText().toString(), s.toString());
                binding.btnIngresar.setEnabled(isOk);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private Boolean isCredentialsValidate(String email, String password){
        Boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Boolean isPasswordOk = password.length() >= 8;
        return isEmailOk && isPasswordOk;
    }
}
