package com.pkr.clubcatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bean.UserBean;
import java.util.ArrayList;

public class CustomAdapterGroupSms extends BaseAdapter {
    ArrayList arrayList;
    UserBean bean;
    Context context;
    private TextView sms_display_grp_left;
    private TextView sms_display_right;
    private TextView sms_display_who;

    public CustomAdapterGroupSms(Context context, ArrayList arrayList) {
        this.arrayList = new ArrayList();
        this.bean = new UserBean();
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
        if (this.bean == null) {
            return convertView;
        }
        this.bean = (UserBean) this.arrayList.get(position);
        String login_user = MainActivity.user;
        String sms_who = this.bean.getSMS_WHO();
        String grp_Sms = this.bean.getGRP_SMS();
        System.out.println("Position = " + position + "   " + this.bean.getGRP_SMS());
        System.out.println(new StringBuilder(String.valueOf(grp_Sms)).append("       ").append(sms_who).toString());
        if (login_user.equals(sms_who)) {
            convertView = inflater.inflate(C0519R.layout.right_sms, null);
            this.sms_display_right = (TextView) convertView.findViewById(C0519R.id.right_textview);
            this.sms_display_right.setText(grp_Sms);
            return convertView;
        }
        convertView = inflater.inflate(C0519R.layout.custom_grp_sms_left, null);
        this.sms_display_grp_left = (TextView) convertView.findViewById(C0519R.id.textview_left_grp_Sms);
        this.sms_display_who = (TextView) convertView.findViewById(C0519R.id.textView_grp_sms_who);
        this.sms_display_grp_left.setText(grp_Sms);
        this.sms_display_who.setText(sms_who);
        return convertView;
    }
}
