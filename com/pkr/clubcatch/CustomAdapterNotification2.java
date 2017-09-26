package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class CustomAdapterNotification2 extends BaseAdapter {
    private ArrayList<UserBean> arrayList;
    UserBean bean;
    private Button button_accept;
    private Context context;
    String from_request;
    private LayoutInflater layoutInflater;
    String status;
    private TextView textview_display;
    String to_request;
    String who;

    /* renamed from: com.pkr.clubcatch.CustomAdapterNotification2.1 */
    class C05031 implements OnClickListener {

        /* renamed from: com.pkr.clubcatch.CustomAdapterNotification2.1.1 */
        class C05011 implements DialogInterface.OnClickListener {
            C05011() {
            }

            public void onClick(DialogInterface dialog, int which) {
                CustomAdapterNotification2.this.accept_friend_request_method(CustomAdapterNotification2.this.from_request, CustomAdapterNotification2.this.to_request);
            }
        }

        /* renamed from: com.pkr.clubcatch.CustomAdapterNotification2.1.2 */
        class C05022 implements DialogInterface.OnClickListener {
            C05022() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        C05031() {
        }

        public void onClick(View v) {
            Builder builder = new Builder(CustomAdapterNotification2.this.context);
            builder.setTitle("Accept the request from " + CustomAdapterNotification2.this.from_request + " ?");
            builder.setPositiveButton("Yes", new C05011());
            builder.setNegativeButton("No", new C05022());
            builder.show();
        }
    }

    public CustomAdapterNotification2(Context context, ArrayList<UserBean> arrayList) {
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
            convertView = inflater.inflate(C0519R.layout.custom_notification, null);
        }
        this.button_accept = (Button) convertView.findViewById(C0519R.id.button_yes_notification);
        if (this.bean != null) {
            this.bean = (UserBean) this.arrayList.get(position);
            this.from_request = this.bean.getFROM_REQUEST();
            this.to_request = this.bean.getTO_REQUEST();
            this.textview_display = (TextView) convertView.findViewById(C0519R.id.textview_notification);
            this.textview_display.setText(this.from_request + " sent you friend request.");
            this.textview_display.getText().toString();
        }
        this.button_accept.setOnClickListener(new C05031());
        return convertView;
    }

    public void accept_friend_request_method(String friend1, String friend2) {
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/add_friends.php?friend1=" + friend1 + "&friend2=" + friend2));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        ((Activity) this.context).finish();
        this.context.startActivity(new Intent(this.context, MainActivity.class));
    }
}
