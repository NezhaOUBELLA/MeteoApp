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
        int longi = Integer.parseInt(getIntent().getStringExtra("longitude"));
        int lati = Integer.parseInt(getIntent().getStringExtra("latitude"));
        String place = getIntent().getStringExtra("place");
        mMap = googleMap;
        LatLng twincenter = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(twincenter).title(place));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(twincenter));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(twincenter,10));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(twincenter);
        circleOptions.radius(700);
        circleOptions.fillColor(Color.TRANSPARENT);
        circleOptions.strokeWidth(6);
        mMap.addCircle(circleOptions);
    }
}
