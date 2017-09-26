package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.DB.DBConnect;
import com.bean.UserBean;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GroupSms extends Activity {
    static String grpName;
    private Button button_send_group_sms;
    private Button buttton_get_pinpoint;
    private Button buttton_set_pinpoint;
    int chk;
    private EditText edittext_group_sms;
    Handler handler;
    int leng;
    private ListView listview_group_sms;
    Runnable f50r;

    /* renamed from: com.pkr.clubcatch.GroupSms.1 */
    class C05121 implements Runnable {
        C05121() {
        }

        public void run() {
            GroupSms groupSms = GroupSms.this;
            groupSms.chk++;
            GroupSms.this.refresh_Adapter();
            GroupSms.this.handler.postDelayed(GroupSms.this.f50r, 4000);
        }
    }

    /* renamed from: com.pkr.clubcatch.GroupSms.2 */
    class C05132 implements OnClickListener {
        C05132() {
        }

        public void onClick(View v) {
            if (!GroupSms.this.edittext_group_sms.getText().equals("")) {
                DBConnect.send_grp_sms(GroupSms.grpName, GroupSms.this.edittext_group_sms.getText().toString());
                GroupSms.this.edittext_group_sms.setText("");
                GroupSms.this.refresh_Adapter();
            }
        }
    }

    /* renamed from: com.pkr.clubcatch.GroupSms.3 */
    class C05143 implements OnClickListener {
        C05143() {
        }

        public void onClick(View v) {
            GroupSms.this.startActivity(new Intent(GroupSms.this, SetPinpoint.class));
        }
    }

    /* renamed from: com.pkr.clubcatch.GroupSms.4 */
    class C05154 implements OnClickListener {
        C05154() {
        }

        public void onClick(View v) {
            GroupSms.this.startActivity(new Intent(GroupSms.this, GetPinpoint.class));
        }
    }

    public GroupSms() {
        this.chk = 0;
        this.leng = 0;
        this.handler = new Handler();
        this.f50r = null;
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.handler.removeCallbacks(this.f50r);
    }

    protected void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.f50r);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_group_sms);
        getWindow().setSoftInputMode(3);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            grpName = bundle.getString("grp");
        }
        getActionBar().setTitle(grpName);
        send_my_location();
        this.buttton_set_pinpoint = (Button) findViewById(C0519R.id.button_set_pinpoint);
        this.buttton_get_pinpoint = (Button) findViewById(C0519R.id.button_get_pinpoint);
        this.listview_group_sms = (ListView) findViewById(C0519R.id.listView_group_sms);
        this.edittext_group_sms = (EditText) findViewById(C0519R.id.editText_group_sms);
        this.button_send_group_sms = (Button) findViewById(C0519R.id.button_send_sms_group);
        refresh_Adapter();
        this.f50r = new C05121();
        this.handler.postDelayed(this.f50r, 4000);
        this.button_send_group_sms.setOnClickListener(new C05132());
        this.buttton_set_pinpoint.setOnClickListener(new C05143());
        this.buttton_get_pinpoint.setOnClickListener(new C05154());
    }

    public void refresh_Adapter() {
        ArrayList<UserBean> arrayList = DBConnect.get_grp_Sms(grpName);
        if (this.chk == 0) {
            this.listview_group_sms.setAdapter(new CustomAdapterGroupSms(this, arrayList));
        } else if (arrayList.size() != this.leng) {
            this.leng = this.listview_group_sms.getAdapter().getCount();
            this.listview_group_sms.setAdapter(new CustomAdapterGroupSms(this, arrayList));
        }
    }

    public void send_my_location() {
        GPSTracker gps = new GPSTracker(this);
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/send_my_location.php?gName=" + grpName + "&user=" + MainActivity.user + "&latitude=" + gps.getLatitude() + "&longitude=" + gps.getLongitude()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
