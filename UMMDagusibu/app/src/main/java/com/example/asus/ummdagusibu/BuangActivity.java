package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class BuangActivity extends AppCompatActivity {
DataBuang dataBuang;
TextView dataBuang1;
TextView dataBuang2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buang);
        Gson gson = new Gson();
        Intent dataKiriman = getIntent();
        String dta = dataKiriman.getStringExtra("caraBuang");

        dataBuang = gson.fromJson(dta, DataBuang.class);

        dataBuang1 = findViewById(R.id.caraBuang);
        dataBuang1.setText(dataBuang.getObatKapsul());

        dataBuang2 =  findViewById(R.id.caraBuang2);
        dataBuang2.setText(dataBuang.getObatSirup());


    }
}
