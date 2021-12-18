package com.ksh3023.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // 텍스트뷰에 날짜를 입력함
        TextView textViewDate = findViewById(R.id.textViewDate);

        Date date = new Date();
        String strDate = "오늘의 날짜는 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일입니다";
        textViewDate.setText(strDate);
    }
}