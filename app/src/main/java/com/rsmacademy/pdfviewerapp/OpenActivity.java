package com.rsmacademy.pdfviewerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Method;

public class OpenActivity extends AppCompatActivity {
Button button, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck1.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//==============================================================
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck2.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck3.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pdfUrl = "ck4.pdf";
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
//        ========================================


    }
}