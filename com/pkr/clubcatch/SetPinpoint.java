package com.pkr.clubcatch;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import com.DB.DBConnect;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SetPinpoint extends FragmentActivity {
    private GoogleMap googleMap;
    GPSTracker gps;

    /* renamed from: com.pkr.clubcatch.SetPinpoint.1 */
    class C08751 implements OnMapClickListener {

        /* renamed from: com.pkr.clubcatch.SetPinpoint.1.1 */
        class C05231 implements OnClickListener {
            C05231() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        /* renamed from: com.pkr.clubcatch.SetPinpoint.1.2 */
        class C05242 implements OnClickListener {
            private final /* synthetic */ EditText val$edittext;
            private final /* synthetic */ double val$lat;
            private final /* synthetic */ double val$lon;

            C05242(double d, double d2, EditText editText) {
                this.val$lat = d;
                this.val$lon = d2;
                this.val$edittext = editText;
            }

            public void onClick(DialogInterface dialog, int which) {
                DBConnect.set_pinpoint(this.val$lat, this.val$lon, GroupSms.grpName, this.val$edittext.getText().toString());
                SetPinpoint.this.finish();
                SetPinpoint.this.startActivity(new Intent(SetPinpoint.this, GroupSms.class));
            }
        }

        C08751() {
        }

        public void onMapClick(LatLng latLng) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            double lat = latLng.latitude;
            double lon = latLng.longitude;
            SetPinpoint.this.googleMap.clear();
            SetPinpoint.this.googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            SetPinpoint.this.googleMap.addMarker(markerOptions);
            Builder builder = new Builder(SetPinpoint.this);
            EditText edittext = new EditText(SetPinpoint.this);
            builder.setTitle("Set Pinpoint: ");
            builder.setMessage("Name of Pinpoint");
            builder.setView(edittext);
            builder.setPositiveButton("NO", new C05231());
            builder.setNegativeButton("YES", new C05242(lat, lon, edittext));
            builder.show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_set_pinpoint);
        this.googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.set_pinpoint)).getMap();
        centerMapOnMyLocation();
        this.googleMap.setOnMapClickListener(new C08751());
    }

    private void centerMapOnMyLocation() {
        this.gps = new GPSTracker(this);
        double latitude = this.gps.getLatitude();
        double longitude = this.gps.getLongitude();
        GoogleMap googleMap2 = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0519R.id.set_pinpoint)).getMap();
        LocationManager locationManager = (LocationManager) getSystemService("location");
        locationManager.getBestProvider(new Criteria(), true);
        locationManager.getLastKnownLocation("gps");
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap2.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap2.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        googleMap2.addMarker(new MarkerOptions().position(latLng).title("Your Location " + MainActivity.user)).showInfoWindow();
    }
}
