
package com.example.studentmanagementsystem;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewStudentActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    DBHelper dbHelper;
    ArrayList<Student> studentList;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DBHelper(this);

        loadData();
    }

    private void loadData() {

        studentList = new ArrayList<>();

        Cursor cursor = dbHelper.getAllData();

        if (cursor != null) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(
                        cursor.getColumnIndexOrThrow("id"));

                String name = cursor.getString(
                        cursor.getColumnIndexOrThrow("name"));

                String studentId = cursor.getString(
                        cursor.getColumnIndexOrThrow("student_id"));

                String email = cursor.getString(
                        cursor.getColumnIndexOrThrow("email"));

                String course = cursor.getString(
                        cursor.getColumnIndexOrThrow("course"));

                studentList.add(new Student(
                        id, name, studentId, email, course
                ));
            }

            cursor.close();
        }

        adapter = new StudentAdapter(this, studentList);

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}