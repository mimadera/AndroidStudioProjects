package com.example.michal.breslau;

import com.example.michal.breslau.Distance;
import com.example.michal.breslau.Duration;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Michal on 15.11.2017.
 */

public class Route {

    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;
    public List<LatLng> points;

}
