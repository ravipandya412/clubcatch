package com.pkr.clubcatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bean.UserBean2;
import java.util.ArrayList;

public class CustomAdapterGetPinpoint extends BaseAdapter {
    ArrayList arrayList;
    UserBean2 bean;
    Context context;
    private ListView listview_get_pinpoint;
    private TextView textview_la;
    private TextView textview_lon;
    private TextView textview_n;
    private TextView textview_w;

    public CustomAdapterGetPinpoint(Context context, ArrayList arrayList) {
        this.arrayList = new ArrayList();
        this.bean = new UserBean2();
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
            convertView = inflater.inflate(C0519R.layout.custom_get_pinpoint, null);
        }
        this.textview_n = (TextView) convertView.findViewById(C0519R.id.textView_pinpoint_name);
        this.textview_w = (TextView) convertView.findViewById(C0519R.id.textView_pinpoint_who);
        this.textview_la = (TextView) convertView.findViewById(C0519R.id.textView_pinpoint_latitude);
        this.textview_lon = (TextView) convertView.findViewById(C0519R.id.textView_pinpoint_longitude);
        if (this.bean != null) {
            this.bean = (UserBean2) this.arrayList.get(position);
            String n = this.bean.getNamePin();
            String w = this.bean.getWho();
            String la = this.bean.getLat();
            String lon = this.bean.getLon();
            this.textview_n.setText(n);
            this.textview_w.setText(w);
            this.textview_la.setText(la);
            this.textview_lon.setText(lon);
        }
        return convertView;
    }
}
