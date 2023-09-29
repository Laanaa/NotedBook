package com.example.notedbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class BerandaActivity extends AppCompatActivity {

    ImageButton btnPemasukan, btnPengeluaran, btnPengaturan, btnDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        btnPemasukan = findViewById(R.id.btnPemasukan);
        btnPengeluaran = findViewById(R.id.btnPengeluaran);
        btnPengaturan = findViewById(R.id.btnPengaturan);
        btnDetail = findViewById(R.id.btnDetail);

        btnPemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BerandaActivity.this, PemasukanActivity.class);
                startActivity(myIntent);
            }
        });
        btnPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BerandaActivity.this, PengeluaranActivity.class);
                startActivity(myIntent);
            }
        });
        btnPengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BerandaActivity.this, PengaturanActivity.class);
                startActivity(myIntent);
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(BerandaActivity.this, DetailActivity.class);
                startActivity(myIntent);
            }
        });
    }
}