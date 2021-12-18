package com.ksh3023.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 에딧 텍스트 획득
        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        // 회원가입 진행
        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(v -> {
            String id = editTextId.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterActivity.this,
                        "모두 입력해주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            // 아이디 등록
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            pref.edit()
                    .putString("id", id)
                    .putString("password", password)
                    .apply();
            finish();
        });

    }
}