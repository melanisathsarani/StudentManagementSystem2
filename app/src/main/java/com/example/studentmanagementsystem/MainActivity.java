
package com.example.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AddStudentActivity.class
            );
            startActivity(intent);
        });

        btnView.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ViewStudentActivity.class
            );
            startActivity(intent);
        });
    }
}