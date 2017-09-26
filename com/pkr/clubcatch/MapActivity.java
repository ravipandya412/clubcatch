package com.pkr.clubcatch;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements LocationListener {
    GoogleMap googleMap;
    String lat;
    private EditText lati;
    String lon;
    private EditText longi;
    String whom;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        this.whom = bundle.getString("whom");
        this.lat = bundle.getString("lat");
        this.lon = bundle.getString("lon");
        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        setContentView(C0519R.layout.activity_map);
        this.googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.map)).getMap();
        this.googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService("location");
        String bestProvider = locationManager.getBestProvider(new Criteria(), true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0.0f, this);
    }

    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(Double.valueOf(this.lat).doubleValue(), Double.valueOf(this.lon).doubleValue());
        this.googleMap.addMarker(new MarkerOptions().position(latLng));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (status == 0) {
            return true;
        }
        GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
        return false;
    }
}
