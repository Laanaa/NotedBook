package com.example.notedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PemasukanActivity extends AppCompatActivity {
    private static final String TAG = "PemasukanActivity";
    Button btnSimpan;
    EditText waktu, nominal, keterangan;
    SQLiteDatabase db;
    private static final String DB_NOTED = "note.db";
    private static final String TABLE_USER = "user";
    private static final String TABLE_BOOK = "book";
    String status = "masuk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);
        btnSimpan = findViewById(R.id.simpan);
        waktu = (EditText) findViewById(R.id.tanggal);
        nominal = (EditText) findViewById(R.id.nominal);
        keterangan = (EditText) findViewById(R.id.keterangan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openOrCreateDatabase(DB_NOTED, Context.MODE_PRIVATE, null);
                try {
                    String query = "INSERT INTO " + TABLE_BOOK + "(WAKTU, NOMINAL, KETERANGAN, STATUS) VALUES('"
                            + waktu.getText()
                            + "', '" + nominal.getText()
                            + "', '" + keterangan.getText()
                            + "', '" + status + "');";
                    Log.d(TAG, "onClick: " + query);
                    db.execSQL(query);
                    db.close();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Add Menu Success",
                            Toast.LENGTH_SHORT);
                    toast.show();
                } catch(Throwable e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Data Kosong!! \nData harus lengkap",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                waktu.getText().clear();
                nominal.getText().clear();
                keterangan.getText().clear();
                finish();
            }
        });
    }
}