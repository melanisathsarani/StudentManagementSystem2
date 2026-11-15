
package com.example.studentmanagementsystem;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtStudentId, txtEmail, txtCourse;
    android.widget.Button btnUpdate, btnDelete;

    public MyViewHolder(View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txtName);
        txtStudentId = itemView.findViewById(R.id.txtStudentId);
        txtEmail = itemView.findViewById(R.id.txtEmail);
        txtCourse = itemView.findViewById(R.id.txtCourse);

        btnUpdate = itemView.findViewById(R.id.btnUpdate);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
}