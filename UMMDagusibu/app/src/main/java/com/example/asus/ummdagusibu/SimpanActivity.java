package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SimpanActivity extends AppCompatActivity {
    TextView dataSimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpan);

        Intent dataKiriman=getIntent();


        dataSimpan = findViewById(R.id.caraSimpan);

        dataSimpan.setText(dataKiriman.getStringExtra("caraSimpan"));

    }
}
