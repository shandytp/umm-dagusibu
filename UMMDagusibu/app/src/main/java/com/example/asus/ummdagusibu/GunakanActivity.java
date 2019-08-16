package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class GunakanActivity extends AppCompatActivity {
    DataPenggunaan dataGuna;
    TextView dataGunakan;
    TextView dataGunakan2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunakan);

        Gson gson = new Gson();
        Intent dataKiriman = getIntent();
        String dta = dataKiriman.getStringExtra("caraGunakan");

        dataGuna = gson.fromJson(dta, DataPenggunaan.class);

        dataGunakan = findViewById(R.id.caraGunakan);
        dataGunakan.setText(dataGuna.getDewasa());

        dataGunakan2 = findViewById(R.id.caraGunakan2);
        dataGunakan2.setText(dataGuna.getAnak());




    }

}
