package br.ufrn.movimentum;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

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

//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//
//            }
//        });

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
        List<LatLng> points = new ArrayList<>();
        points.add(new LatLng(-5.836023, -35.201365));
        points.add(new LatLng(-5.835428, -35.201373));
        points.add(new LatLng(-5.835153, -35.201145));
        points.add(new LatLng(-5.835180, -35.200799));
        points.add(new LatLng(-5.835385, -35.200641));
        points.add(new LatLng(-5.836354, -35.200607));
        points.add(new LatLng(-5.836568, -35.200744));
        points.add(new LatLng(-5.836653, -35.201012));
        points.add(new LatLng(-5.836472, -35.201345));
        points.add(new LatLng(-5.836023, -35.201365));
        LatLng center = new LatLng(-5.835925, -35.201004);

        Polyline line = mMap.addPolyline(new PolylineOptions().addAll(points)
//                .add(new LatLng(51.5, -0.1), new LatLng(40.7, -74.0))
                .width(5)
                .color(Color.RED));
        mMap.addMarker(new MarkerOptions().position(center).title("Marker in Pista de Atletismo UFRN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center));
    }
}
