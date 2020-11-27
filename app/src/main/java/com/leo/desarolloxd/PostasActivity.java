package com.leo.desarolloxd;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PostasActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        LatLng regional = new LatLng(-13.521881218078365, -71.97048290834525);
        mMap.addMarker(new MarkerOptions().position(regional).title("Clas Wanchaq"));

        LatLng adolfo = new LatLng(-13.525193937454052, -71.97863205716895);
        mMap.addMarker(new MarkerOptions().position(adolfo).title("Centro de Salud Belenpampa"));

        LatLng soli = new LatLng(-13.531666362725273, -71.95992420577745);
        mMap.addMarker(new MarkerOptions().position(soli).title("Posta de Ttio"));

        float zoomLevel =14;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(regional, zoomLevel));}
}