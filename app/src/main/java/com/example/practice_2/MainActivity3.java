package com.example.practice_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.practice_2.DatabaseHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {

    EditText record;
    Button delButton;
    Button saveButton;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase db;

    Cursor userCursor;
    long userId = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Найдем компоненты в XML разметке
        record = findViewById(R.id.record);
        delButton = findViewById(R.id.deleteButton);
        saveButton = findViewById(R.id.saveButton);

        mDBHelper = new DatabaseHelper(this);

        db = mDBHelper.getWritableDatabase();



        System.out.println(userId);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
            System.out.println(userId);
        }
        // если 0, то добавление
        if (userId > 0) {
            System.out.println(userId);
            // получаем элемент по id из бд
            Cursor cursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                    DatabaseHelper.COLUMN_ID + "='" + userId + "'", null);
            if(cursor != null && cursor.moveToFirst()){
                cursor.moveToFirst();
                record.setText(cursor.getString(1));
                cursor.close();
            }
        } else {
            // скрываем кнопку удаления
            //delButton.setVisibility(View.GONE);
        }
    }

    public void save(View view){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_record, record.getText().toString());

        if (userId > 0) {
            db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + '=' + userId, null);
        } else {
            db.insert(DatabaseHelper.TABLE, null, cv);
        }
        goHome();
    }
    public void delete(View view){
        System.out.println("удалено");
        System.out.println(userId);
        db.rawQuery(
                "DELETE FROM " +DatabaseHelper.TABLE +
                        " where " +
                        DatabaseHelper.COLUMN_ID + "='" + userId + "'", null);
        db.delete(
                DatabaseHelper.TABLE, DatabaseHelper.COLUMN_ID +" = ?",
                new String[] {String.valueOf(userId)});
        goHome();
    }

    public void deleteItem(View view) {

        db.delete(DatabaseHelper.TABLE, DatabaseHelper.COLUMN_ID + "=" + userId, null);
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
    private void goHome(){
        // закрываем подключение
        db.close();
        // переход к главной activity
        Intent intent = new Intent(this, MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

}
