package com.example.notedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnLogin;
    SQLiteDatabase db;
    private static final String DB_NOTED = "note.db";
    private static final String TABLE_USER = "user";
    private static final String TABLE_BOOK = "book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable();
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, BerandaActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void createTable(){
        db = openOrCreateDatabase(DB_NOTED, Context.MODE_PRIVATE, null);

        String query = "CREATE TABLE IF NOT EXISTS "
                + TABLE_USER
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT);";
        Log.d(TAG, "onCreate: " + query);
        db.execSQL(query);

        query = "CREATE TABLE IF NOT EXISTS "
                + TABLE_BOOK
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, WAKTU DATE, NOMINAL INTEGER, KETERANGAN TEXT, STATUS TEXT);";
        Log.d(TAG, "onCreate: " + query);
        db.execSQL(query);
        db.close();
    }
}