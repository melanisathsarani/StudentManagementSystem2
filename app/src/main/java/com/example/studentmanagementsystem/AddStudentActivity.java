
package com.example.studentmanagementsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    EditText edtName, edtStudentId, edtEmail, edtCourse;
    Button btnSave;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtName = findViewById(R.id.edtName);
        edtStudentId = findViewById(R.id.edtStudentId);
        edtEmail = findViewById(R.id.edtEmail);
        edtCourse = findViewById(R.id.edtCourse);

        btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();
            String studentId = edtStudentId.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String course = edtCourse.getText().toString().trim();

            if (name.isEmpty() || studentId.isEmpty()
                    || email.isEmpty() || course.isEmpty()) {

                Toast.makeText(this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();
            }
            else {

                long result = dbHelper.insertData(
                        name, studentId, email, course
                );

                if (result != -1) {
                    Toast.makeText(this,
                            "Student Added Successfully",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(this,
                            "Student Adding Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}