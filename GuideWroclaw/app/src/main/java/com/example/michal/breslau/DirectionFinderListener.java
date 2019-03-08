package com.example.michal.breslau;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Michal on 15.11.2017.
 */

public interface DirectionFinderListener {
    void onDirectionFinderSuccess(List<Route> route);
}
