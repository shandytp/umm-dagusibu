package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;



public class MainActivity extends AppCompatActivity {
    TextView namaobat;
    Obat dataobat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.cari);
        imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,SearchActivity.class);
                        startActivityForResult(i,2);
                    }
                });

        namaobat = findViewById(R.id.cariobat);


        ImageView imageView2 = findViewById(R.id.dapatkan);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataobat==null){
                    Toast.makeText(MainActivity.this,"Silahkan pilih obat terlebih dahulu",Toast.LENGTH_SHORT).show();
                }
                else {
                    Gson gson = new Gson();

                    String dtaapo = gson.toJson(dataobat);
                    Intent a = new Intent(MainActivity.this, ApotekActivity.class);
                    a.putExtra("caraDapat", dtaapo);
                    startActivity(a);
                }
            }
        });

        ImageView imageView3 = findViewById(R.id.simpan);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataobat==null){
                    Toast.makeText(MainActivity.this,"Silahkan pilih obat terlebih dahulu",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent b = new Intent(MainActivity.this, SimpanActivity.class);
                    b.putExtra("caraSimpan", dataobat.getCaraSimpan());
                    startActivity(b);
                }
            }
        });


        ImageView imageView4 = findViewById(R.id.gunakan);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataobat==null){
                    Toast.makeText(MainActivity.this,"Silahkan pilih obat terlebih dahulu",Toast.LENGTH_SHORT).show();
                }
                else {
                    Gson gson = new Gson();
                    DataPenggunaan dataPenggunaan = dataobat.getCaraPenggunaan();
                    String dtaguna = gson.toJson(dataPenggunaan);
                    Intent c = new Intent(MainActivity.this, GunakanActivity.class);
                    c.putExtra("caraGunakan", dtaguna);
                    startActivity(c);
                }
            }
        });

        ImageView imageView5 = findViewById(R.id.buang);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataobat==null){
                    Toast.makeText(MainActivity.this,"Silahkan pilih obat terlebih dahulu",Toast.LENGTH_SHORT).show();
                }
                else {
                    Gson gson = new Gson();
                    DataBuang dataBuang = dataobat.getCaraBuang();
                    String dtabuang = gson.toJson(dataBuang);
                    Intent d = new Intent(MainActivity.this, BuangActivity.class);
                    d.putExtra("caraBuang", dtabuang);
                    startActivity(d);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 2){
            if (resultCode == RESULT_OK){

                Gson gson = new Gson();
                String dta = data.getStringExtra("hasil") ;
                dataobat = gson.fromJson(dta, Obat.class);
                namaobat.setText(dataobat.getNama());
            }
        }
    }


}
