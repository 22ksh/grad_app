package com.ksh3023.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 에딧 텍스트 획득
        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        // 로그인 진행
        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(v -> {
            String id = editTextId.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "모두 입력해주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            // 아이디 , 비밀번호 체크
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            String realId = pref.getString("id", null);
            String realPassword = pref.getString("password", null);
            if (realId == null || realPassword == null) {
                Toast.makeText(MainActivity.this,
                        "가입된 아이디가 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }

            if (realId.equals(id) && realPassword.equals(password)) {
                // 로그인 성공. QuestionActivity 로 이동
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(intent);
            } else {
                // 로그인 실패
                Toast.makeText(MainActivity.this,
                        "회원정보가 불일치합니다", Toast.LENGTH_SHORT).show();
            }
        });

        // 회원가입 진행
        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
        
        Button buttonName = findViewById(R.id.buttonName);
        buttonName.setOnClickListener(v -> Toast.makeText(this,
                "20273023", Toast.LENGTH_SHORT).show());
    }
}