package com.example.antonio.lab5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FloatingActionButton mapMode;
    private int mapType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapMode = (FloatingActionButton) findViewById(R.id.mapMode);

        mapMode.setOnClickListener(new changeMapMode());
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

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        LatLng tatung = new LatLng(25.067367, 121.521277);
        CameraUpdate zoom = CameraUpdateFactory.zoomIn();

        mMap.addMarker(new MarkerOptions().position(tatung).title("大同電鍋"));
        // Method 1
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tatung, 16f));
        // Method 2 With animation
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(tatung));
        // mMap.animateCamera(CameraUpdateFactory.zoomTo(18f));
    }

    public class changeMapMode implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (mapType) {
                case 0:
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    mapType++;
                    break;
                case 1:
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    mapType++;
                    break;
                case 2:
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    mapType++;
                    break;
                default:
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    mapType = 0;
            }
        }
    }
}
