
package com.example.studentmanagementsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<Student> studentList;
    DBHelper dbHelper;

    public StudentAdapter(Context context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
        dbHelper = new DBHelper(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.item_student, parent, false
        );

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,
                                 int position) {

        Student student = studentList.get(position);

        holder.txtName.setText(student.getName());
        holder.txtStudentId.setText("ID: " + student.getStudent_id());
        holder.txtEmail.setText("Email: " + student.getEmail());
        holder.txtCourse.setText("Course: " + student.getCourse());

        // Update Button
        holder.btnUpdate.setOnClickListener(v -> {

            Intent intent = new Intent(context, UpdateStudentActivity.class);

            intent.putExtra("id", student.getId());
            intent.putExtra("name", student.getName());
            intent.putExtra("student_id", student.getStudent_id());
            intent.putExtra("email", student.getEmail());
            intent.putExtra("course", student.getCourse());

            context.startActivity(intent);
        });

        // Delete Button
        holder.btnDelete.setOnClickListener(v -> {

            new AlertDialog.Builder(context)
                    .setTitle("Delete Student")
                    .setMessage("Are you sure you want to delete this student?")
                    .setPositiveButton("Yes", (dialog, which) -> {

                        int result = dbHelper.deleteData(student.getId());

                        if (result > 0) {

                            int currentPosition = holder.getAdapterPosition();

                            if (currentPosition != RecyclerView.NO_POSITION) {
                                studentList.remove(currentPosition);
                                notifyItemRemoved(currentPosition);
                            }

                            Toast.makeText(context,
                                    "Student Deleted Successfully",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context,
                                    "Delete Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}