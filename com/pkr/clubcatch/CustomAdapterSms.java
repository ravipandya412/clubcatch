package com.pkr.clubcatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bean.UserBean;
import java.util.ArrayList;

public class CustomAdapterSms extends BaseAdapter {
    private ArrayList<UserBean> arrayList;
    UserBean bean;
    private Context context;
    private LayoutInflater layoutInflater;
    private TextView sms_display_left;
    private TextView sms_display_right;

    public CustomAdapterSms(Context context, ArrayList<UserBean> arrayList) {
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
        return (long) this.arrayList.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.bean == null) {
            return convertView;
        }
        this.bean = (UserBean) this.arrayList.get(position);
        String login_user = MainActivity.user;
        String to = this.bean.getTO();
        String login = this.bean.getLOGIN();
        String sms = this.bean.getSMS();
        System.out.println(new StringBuilder(String.valueOf(login)).append(" ").append(login_user).toString());
        if (login_user.equals(login)) {
            convertView = inflater.inflate(C0519R.layout.right_sms, null);
            this.sms_display_right = (TextView) convertView.findViewById(C0519R.id.right_textview);
            this.sms_display_right.setText(sms);
            return convertView;
        }
        convertView = inflater.inflate(C0519R.layout.left_sms, null);
        this.sms_display_left = (TextView) convertView.findViewById(C0519R.id.left_textview);
        this.sms_display_left.setText(sms);
        return convertView;
    }
}
