package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView listView = findViewById(R.id.listView);

        Gson gson = new Gson();
        String data = ambilData();
        final DataObat dataobat = gson.fromJson(data, DataObat.class);

        String nama[]= new String[dataobat.getData().size()];
        for (int counter=0; counter<dataobat.getData().size();counter++)
        {
            nama[counter]=dataobat.getData().get(counter).getNama();

        }
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, nama);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Gson gson = new Gson();

                Obat listobat = dataobat.getData().get(position);
                String obat = gson.toJson(listobat);
                Intent data = new Intent();
                data.putExtra("hasil", obat);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

    private String ambilData(){
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        try {
            is = getAssets().open("data.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
