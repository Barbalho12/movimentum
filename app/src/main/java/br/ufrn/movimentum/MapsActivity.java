package br.ufrn.movimentum;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Local");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
//        points.add(new LatLng(-5.836023, -35.201365));
//        points.add(new LatLng(-5.835428, -35.201373));
//        points.add(new LatLng(-5.835153, -35.201145));
//        points.add(new LatLng(-5.835180, -35.200799));
//        points.add(new LatLng(-5.835385, -35.200641));
//        points.add(new LatLng(-5.836354, -35.200607));
//        points.add(new LatLng(-5.836568, -35.200744));
//        points.add(new LatLng(-5.836653, -35.201012));
//        points.add(new LatLng(-5.836472, -35.201345));
//        points.add(new LatLng(-5.836023, -35.201365));

        points.add(new LatLng(-5.832816, -35.202946));
        points.add(new LatLng(-5.837005, -35.197561));
        points.add(new LatLng(-5.839940, -35.195490));
        points.add(new LatLng(-5.840687, -35.195211));
        points.add(new LatLng(-5.841530, -35.195200));
        points.add(new LatLng(-5.842544, -35.195307));
        points.add(new LatLng(-5.843451, -35.195919));
        points.add(new LatLng(-5.843867, -35.196906));
        points.add(new LatLng(-5.843867, -35.197292));
        points.add(new LatLng(-5.843515, -35.200575));
        points.add(new LatLng(-5.841890, -35.200548));
        points.add(new LatLng(-5.841570, -35.200977));
        points.add(new LatLng(-5.841346, -35.201138));
        points.add(new LatLng(-5.840417, -35.201095));
        points.add(new LatLng(-5.840342, -35.200902));
        points.add(new LatLng(-5.837628, -35.200959));
        points.add(new LatLng(-5.835198, -35.203053));
        points.add(new LatLng(-5.832816, -35.202946));
        LatLng center = new LatLng(-5.835925, -35.201004);

//        Polyline line = mMap.addPolyline(new PolylineOptions().addAll(points)
//                .width(5)
//                .color(Color.RED));
//        mMap.addMarker(new MarkerOptions().position(center).title("Marker in Pista de Atletismo UFRN"));

        //        LatLngBounds.Builder builder = new LatLngBounds.Builder();
//        builder.include(center);
//        LatLngBounds bounds = builder.build();
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(center));

        final LatLngBounds.Builder builder = new LatLngBounds.Builder();
        final PolylineOptions polylineOptions = new PolylineOptions();
        for (int i = 0; i < points.size(); i++) {
            polylineOptions.add(points.get(i));
            builder.include(points.get(i));
        }
        Polyline polyline = mMap.addPolyline(polylineOptions.color(Color.RED));
        final LatLngBounds bounds = builder.build();

        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 40));

//                mMap.addMarker(new MarkerOptions().position(bounds.getCenter())..title("Em torno da UFRN"));
            }
        });



    }



}
