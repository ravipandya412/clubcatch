package com.pkr.clubcatch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.bean.UserBean;
import java.util.ArrayList;

public class CustomAdapterLocation extends BaseAdapter {
    private ArrayList<UserBean> arrayList;
    UserBean bean;
    private Button button_accept;
    private Context context;
    String from_request;
    private LayoutInflater layoutInflater;
    String status;
    private TextView textview;
    private TextView textview_display;
    private TextView textview_latitude;
    private TextView textview_longitude;
    private TextView textview_notification;
    private TextView textview_whom;
    String to_request;
    String who;

    /* renamed from: com.pkr.clubcatch.CustomAdapterLocation.1 */
    class C04971 implements OnClickListener {
        C04971() {
        }

        public void onClick(View v) {
            String whom = CustomAdapterLocation.this.textview_whom.getText().toString();
            String lat = CustomAdapterLocation.this.textview_latitude.getText().toString();
            String lon = CustomAdapterLocation.this.textview_longitude.getText().toString();
            Intent intent = new Intent(CustomAdapterLocation.this.context, MapActivity.class);
            intent.putExtra("whom", whom);
            intent.putExtra("lat", lat);
            intent.putExtra("lon", lon);
            CustomAdapterLocation.this.context.startActivity(intent);
        }
    }

    public CustomAdapterLocation(Context context, ArrayList<UserBean> arrayList) {
        this.bean = new UserBean();
        this.who = "";
        this.from_request = "";
        this.to_request = "";
        this.status = "";
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
            convertView = inflater.inflate(C0519R.layout.custom_location, null);
        }
        this.textview_whom = (TextView) convertView.findViewById(C0519R.id.textView1_location);
        this.textview_latitude = (TextView) convertView.findViewById(C0519R.id.textView2_latitude);
        this.textview_longitude = (TextView) convertView.findViewById(C0519R.id.textView3_longitude);
        if (this.bean != null) {
            this.bean = (UserBean) this.arrayList.get(position);
            String whom = this.bean.getWHOM_LOCATION();
            String latitude = this.bean.getLATITUDE();
            String longitude = this.bean.getLONGITUDE();
            this.textview_whom.setText("Click here to see the location of " + whom);
            this.textview_latitude.setText(latitude);
            this.textview_longitude.setText(longitude);
        }
        this.textview_whom.setOnClickListener(new C04971());
        return convertView;
    }
}
