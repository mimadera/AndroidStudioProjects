package com.example.wroclawguide;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.example.wroclawguide.Database.EventRepository;
import com.example.wroclawguide.Database.MonumentsRepository;
import com.example.wroclawguide.DatabaseTables.Event;
import com.example.wroclawguide.DatabaseTables.Monuments;
import com.google.android.gms.location.FusedLocationProviderClient;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements  OnMapReadyCallback{

    private GoogleMap gMap;
    private static final int PERMISSION_LOCATION_REQUEST_CODE = 100;
    private long markerId;
    private int repositoryUsed;
    private int startNavigate;
    private LatLng destination;
    private LatLng currentPosition;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        markerId = intent.getLongExtra( "parameterId", -1);
        repositoryUsed = intent.getIntExtra("repositoryUsed" , -1);
        startNavigate = intent.getIntExtra( "startNavigate", -1);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    private void loadObject(){

        destination = null;

        if (repositoryUsed == 1) {
            Event event = EventRepository.findById(this, markerId);
            destination = new LatLng(event.getLatitude(), event.getLongitude());
            String name = event.getName();
            drawMarker(destination, name);
        }
        if (repositoryUsed == 3) {
            Monuments monuments = MonumentsRepository.findById(this, markerId);
            destination = new LatLng(monuments.getLatitude(), monuments.getLongitude());
            String name = monuments.getName();
            drawMarker(destination, name);
        }
    }
    private boolean checkLocationPermission() {
        return ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.gMap = googleMap;

        gMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Intent intent = new Intent(getApplicationContext(), PlaceDiscription.class);
                intent.putExtra("parameterId" , markerId);
                intent.putExtra("repositoryUsed", repositoryUsed);
                startActivity(intent);
                return true;
            }
        });

        if(checkLocationPermission()){
            this.gMap.setMyLocationEnabled(true);
            this.gMap.getUiSettings().setZoomControlsEnabled(true);
            this.gMap.getUiSettings().setMyLocationButtonEnabled(true);
            this.gMap.getUiSettings().setCompassEnabled(true);
            this.gMap.getUiSettings().setRotateGesturesEnabled(true);
            this.gMap.getUiSettings().setZoomGesturesEnabled(true);

        } else {
            requestPermissionsFromUser();
            onMapReady(gMap);
        }
        loadObject();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    private void requestPermissionsFromUser(){
        ActivityCompat.requestPermissions(MapsActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION_REQUEST_CODE);
    }

    private synchronized void drawMarker(LatLng position, String name){

        MarkerOptions markerOptions = new MarkerOptions().position(position).snippet(name);
        gMap.addMarker(markerOptions);

        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,15));
        // Zoom in, animating the camera.
        gMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        gMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

    }
}