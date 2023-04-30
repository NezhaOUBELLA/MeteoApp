package com.example.meteoapp;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.meteoapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
// Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        double longi = getIntent().getDoubleExtra("longi",0.0);
        double lati = getIntent().getDoubleExtra("lati",0.0);
        String place = getIntent().getStringExtra("place");
        mMap = googleMap;
        LatLng localisation = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(localisation).title(place));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localisation));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localisation,10));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(localisation);
        circleOptions.radius(700);
        circleOptions.fillColor(Color.TRANSPARENT);
        circleOptions.strokeWidth(6);
        mMap.addCircle(circleOptions);
    }
}
