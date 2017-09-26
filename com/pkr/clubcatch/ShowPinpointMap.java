package com.pkr.clubcatch;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class ShowPinpointMap extends FragmentActivity implements LocationListener {
    GPSTracker gps;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_show_pinpoint_map);
        Bundle bundle = getIntent().getExtras();
        String n = bundle.getString("n");
        String la = bundle.getString("lat");
        String lon = bundle.getString("lon");
        GoogleMap googleMap2 = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.show_pinpoint_location)).getMap();
        ((LocationManager) getSystemService("location")).getBestProvider(new Criteria(), true);
        LatLng latLng = new LatLng(Double.valueOf(la).doubleValue(), Double.valueOf(lon).doubleValue());
        googleMap2.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap2.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        googleMap2.addMarker(new MarkerOptions().position(latLng).title(n)).showInfoWindow();
        show_marker_of_friends();
    }

    public void show_marker_of_friends() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost get2 = new HttpPost(SplashActivity.server_Url + "/get_pinpoint_friends.php?gName=" + GroupSms.grpName);
        ArrayList arrayList = new ArrayList();
        String who = null;
        String l = null;
        String lo = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpClient.execute(get2).getEntity().getContent(), "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
            }
            System.out.println(builder);
            JSONArray jsonArray = new JSONObject(builder.toString()).optJSONArray("getF");
            int count = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                if (count == 0) {
                    who = jsonObject2.optString("who").toString();
                    count++;
                } else if (count == 1) {
                    l = jsonObject2.optString("lat").toString();
                    count++;
                } else {
                    lo = jsonObject2.optString("lon").toString();
                    count++;
                }
                if (count == 3) {
                    set_location_marker(who, l, lo);
                    count = 0;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void set_location_marker(String who, String l, String lo) {
        GoogleMap googleMap3 = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.show_pinpoint_location)).getMap();
        ((LocationManager) getSystemService("location")).getBestProvider(new Criteria(), true);
        LatLng latLng = new LatLng(Double.valueOf(l).doubleValue(), Double.valueOf(lo).doubleValue());
        googleMap3.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap3.animateCamera(CameraUpdateFactory.zoomTo(10.0f));
        googleMap3.addMarker(new MarkerOptions().position(latLng).title(who).icon(BitmapDescriptorFactory.fromResource(C0519R.drawable.walk))).showInfoWindow();
    }

    public void onLocationChanged(Location location) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onProviderDisabled(String provider) {
    }
}
