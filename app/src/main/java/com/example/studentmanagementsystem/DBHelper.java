
package com.example.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "Student.db";

    public DBHelper(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "student_id TEXT, " +
                "email TEXT, " +
                "course TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Students");
        onCreate(db);
    }

    // Insert Student
    public long insertData(String name, String student_id,
                           String email, String course) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("student_id", student_id);
        cv.put("email", email);
        cv.put("course", course);

        return db.insert("Students", null, cv);
    }

    // Get All Students
    public Cursor getAllData() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM Students", null);
    }

    // Update Student
    public int updateData(int id, String name,
                          String student_id, String email,
                          String course) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("student_id", student_id);
        cv.put("email", email);
        cv.put("course", course);

        return db.update("Students", cv, "id = ?",
                new String[]{String.valueOf(id)});
    }

    // Delete Student
    public int deleteData(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("Students", "id = ?",
                new String[]{String.valueOf(id)});
    }
}
