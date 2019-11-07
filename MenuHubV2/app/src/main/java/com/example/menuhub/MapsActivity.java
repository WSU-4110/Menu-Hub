package com.example.menuhub;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    private static MapsActivity single_instance;

    public static MapsActivity getInstance() {
        if (single_instance == null) {
            single_instance = new MapsActivity();
        }
        return single_instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //Add a marker in Detroit and move the camera
        LatLng detroit = new LatLng(42.3314, -83.0485);
        mMap.addMarker(new MarkerOptions().position(detroit).title("Marker in Detroit"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(detroit));

    }
}
