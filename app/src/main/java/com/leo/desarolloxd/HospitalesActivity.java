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

public class HospitalesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales);
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

        LatLng regional = new LatLng(-13.523789680750538, -71.95476800254491);
        mMap.addMarker(new MarkerOptions().position(regional).title("Hospital Regional Cusco")
                .snippet("Actualmente el Hospital Regional del Cusco es un establecimiento de salud de referencia regional de categoría III-1; cuenta con 312 camas operativas, 745 trabajadores, entre médicos, profesionales de la salud no médicos, administrativos y técnicos, que laboran en las diferentes áreas especializadas."));

        LatLng adolfo = new LatLng(-13.52513648428922, -71.95974548055447);
        mMap.addMarker(new MarkerOptions().position(adolfo).title("Hospital Adolfo Guevara")
                .snippet("el Hospital Nacional Adolfo Guevara Velasco de la Red Asistencial Cusco de EsSalud, conmemora el sábado 6 de julio su 33° aniversario de creación al servicio de más de 350 mil asegurados de la región."));

        LatLng soli = new LatLng(-13.532052771406523, -71.92597518646247);
        mMap.addMarker(new MarkerOptions().position(soli).title("Hospital Solidaridad"));

        float zoomLevel =14;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(regional, zoomLevel));

    }
}