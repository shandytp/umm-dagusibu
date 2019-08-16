package com.example.asus.ummdagusibu;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class ApotekActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Obat dataObat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apotek);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Gson gson = new Gson();
        Intent dataKiriman = getIntent();
        String dta = dataKiriman.getStringExtra("caraDapat");

        dataObat = gson.fromJson(dta, Obat.class);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (int counter=0; counter<dataObat.getApotek().length; counter++){
            LatLng marker = new LatLng(dataObat.getApotek()[counter].getLatitude(), dataObat.getApotek()[counter].getLongitude());
            mMap.addMarker(new MarkerOptions().position(marker).title(dataObat.getApotek()[counter].getNama()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,15));
        }
        // Add a marker in Sydney and move the camera

    }
}
