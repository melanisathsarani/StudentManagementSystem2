
package com.example.studentmanagementsystem;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateStudentActivity extends AppCompatActivity {

    EditText edtName, edtStudentId, edtEmail, edtCourse;
    Button btnUpdate;

    DBHelper dbHelper;
    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        edtName = findViewById(R.id.edtName);
        edtStudentId = findViewById(R.id.edtStudentId);
        edtEmail = findViewById(R.id.edtEmail);
        edtCourse = findViewById(R.id.edtCourse);

        btnUpdate = findViewById(R.id.btnUpdate);

        dbHelper = new DBHelper(this);

        studentId = getIntent().getIntExtra("id", -1);

        edtName.setText(getIntent().getStringExtra("name"));
        edtStudentId.setText(getIntent().getStringExtra("student_id"));
        edtEmail.setText(getIntent().getStringExtra("email"));
        edtCourse.setText(getIntent().getStringExtra("course"));

        btnUpdate.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();
            String studentID = edtStudentId.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String course = edtCourse.getText().toString().trim();

            if (name.isEmpty() || studentID.isEmpty()
                    || email.isEmpty() || course.isEmpty()) {

                Toast.makeText(this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();
            }
            else {

                int result = dbHelper.updateData(
                        studentId, name, studentID, email, course
                );

                if (result > 0) {
                    Toast.makeText(this,
                            "Student Updated Successfully",
                            Toast.LENGTH_SHORT).show();

                    finish();
                }
                else {
                    Toast.makeText(this,
                            "Update Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}