package com.example.sharagem_;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Garageiros extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garageiros);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        GarageiroDAO garageiros = new GarageiroDAO(getApplicationContext());
       for (GarageiroObj g: garageiros.listaGarageiros()){
           mMap.addMarker(new MarkerOptions().position(new LatLng(g.getLat(), g.getLon())).title(g.getNome()));
           mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(g.getLat(), g.getLon())));
           mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
       }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent it = new Intent(Garageiros.this, Garageiro.class);
                //if (!marker.getPosition().toString().equals(grg1.toString())) {
                    it.putExtra("Garageiro", marker.getTitle());
                    Log.d("Garageiro", marker.getTitle());
                    startActivity(it);
                //}
                return false;
            }
        });
    }
}
