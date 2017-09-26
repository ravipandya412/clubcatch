package com.pkr.clubcatch;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.bean.UserBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class CustomAdapterNotification extends BaseAdapter {
    private ArrayList<UserBean> arrayList;
    UserBean bean;
    private Button button_accept;
    private Context context;
    GPSTracker gps;
    HttpClient httpClient;
    private LayoutInflater layoutInflater;
    private TextView textview;
    private TextView textview_display;
    private TextView textview_notification;
    String who;

    /* renamed from: com.pkr.clubcatch.CustomAdapterNotification.1 */
    class C05001 implements OnClickListener {

        /* renamed from: com.pkr.clubcatch.CustomAdapterNotification.1.1 */
        class C04981 implements DialogInterface.OnClickListener {
            C04981() {
            }

            public void onClick(DialogInterface dialog, int which) {
                CustomAdapterNotification.this.getLatLong(CustomAdapterNotification.this.context, CustomAdapterNotification.this.who);
            }
        }

        /* renamed from: com.pkr.clubcatch.CustomAdapterNotification.1.2 */
        class C04992 implements DialogInterface.OnClickListener {
            C04992() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        C05001() {
        }

        public void onClick(View v) {
            Builder builder = new Builder(CustomAdapterNotification.this.context);
            builder.setTitle("Send location to " + CustomAdapterNotification.this.who + " ?");
            builder.setPositiveButton("Yes", new C04981());
            builder.setNegativeButton("No", new C04992());
            builder.show();
        }
    }

    public CustomAdapterNotification(Context context, ArrayList<UserBean> arrayList) {
        this.bean = new UserBean();
        this.who = "";
        this.httpClient = new DefaultHttpClient();
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.context = context;
        this.arrayList = arrayList;
    }

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(this.arrayList.size());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (convertView == null) {
            convertView = inflater.inflate(C0519R.layout.custom_notification, null);
        }
        this.button_accept = (Button) convertView.findViewById(C0519R.id.button_yes_notification);
        if (this.bean != null) {
            this.bean = (UserBean) this.arrayList.get(position);
            this.who = this.bean.getWHO();
            String whom = this.bean.getWHOM();
            this.textview_display = (TextView) convertView.findViewById(C0519R.id.textview_notification);
            this.textview_display.setText(this.who + " sent you the request of location track.");
            this.textview_display.getText().toString();
        }
        this.button_accept.setOnClickListener(new C05001());
        return convertView;
    }

    public void getLatLong(Context context, String who) {
        this.gps = new GPSTracker(context);
        if (this.gps.canGetLocation()) {
            System.out.println("GPS On");
            double latitude = this.gps.getLatitude();
            double longitude = this.gps.getLongitude();
            try {
                List<Address> addresses = new Geocoder(context, Locale.ENGLISH).getFromLocation(latitude, longitude, 1);
                if (addresses != null) {
                    Address returnedAddress = (Address) addresses.get(0);
                    StringBuilder stringBuilder = new StringBuilder("Address:\n");
                    for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                        stringBuilder.append(returnedAddress.getAddressLine(i)).append("\n");
                        sendLatLong(context, who, latitude, longitude);
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("GPS off 1");
        Toast.makeText(context, "Switch on your GPS", 1).show();
    }

    void sendLatLong(Context context, String who, double lat, double lon) throws UnsupportedEncodingException {
        String lat2 = String.valueOf(lat);
        String lon2 = String.valueOf(lon);
        lat2 = URLEncoder.encode(lat2, "UTF-8");
        lon2 = URLEncoder.encode(lon2, "UTF-8");
        if (lat2.equals("0") || lon2.equals("0")) {
            Toast.makeText(context, "Check your GPS Connection !!", 1).show();
            return;
        }
        try {
            this.httpClient.execute(new HttpGet(SplashActivity.server_Url + "/send_Lat_Long.php?login_user=" + MainActivity.user + "&who=" + who + "&lat=" + lat2 + "&long=" + lon2));
            context.startActivity(new Intent(context, MainActivity.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
