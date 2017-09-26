package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.bean.UserBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Timer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class SmsActivity extends Activity {
    int chk;
    private EditText enter_sms;
    Handler handler;
    HttpClient httpClient;
    int leng;
    private ListView listview_sms;
    private Timer mTimer;
    Runnable f52r;
    private Button send_sms;
    final String sms_from;
    String sms_to;
    ThreadPolicy th;

    /* renamed from: com.pkr.clubcatch.SmsActivity.1 */
    class C05251 implements Runnable {
        C05251() {
        }

        public void run() {
            SmsActivity smsActivity = SmsActivity.this;
            smsActivity.chk++;
            SmsActivity.this.get_message_method();
            SmsActivity.this.handler.postDelayed(SmsActivity.this.f52r, 5000);
        }
    }

    /* renamed from: com.pkr.clubcatch.SmsActivity.2 */
    class C05262 implements OnClickListener {
        C05262() {
        }

        public void onClick(View v) {
            String message = "";
            try {
                message = URLEncoder.encode(SmsActivity.this.enter_sms.getText().toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (message.equals("")) {
                Toast.makeText(SmsActivity.this, "Empty Message", 0).show();
                return;
            }
            HttpGet get2 = new HttpGet(SplashActivity.server_Url + "/send_sms.php?to_user=" + SmsActivity.this.sms_to + "&login_user=" + SmsActivity.this.sms_from + "&sms=" + message);
            SmsActivity.this.enter_sms.setText("");
            try {
                SmsActivity.this.httpClient.execute(get2);
                SmsActivity.this.get_message_method();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public SmsActivity() {
        this.sms_from = MainActivity.user;
        this.sms_to = "";
        this.httpClient = new DefaultHttpClient();
        this.th = new Builder().build();
        this.leng = 0;
        this.handler = new Handler();
        this.f52r = null;
        this.chk = 0;
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.handler.removeCallbacks(this.f52r);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_sms);
        getWindow().setSoftInputMode(3);
        StrictMode.setThreadPolicy(this.th);
        this.sms_to = getIntent().getExtras().getString("sms_to");
        getActionBar().setTitle(this.sms_to);
        this.listview_sms = (ListView) findViewById(C0519R.id.listView_sms);
        this.enter_sms = (EditText) findViewById(C0519R.id.editText_sms);
        this.send_sms = (Button) findViewById(C0519R.id.button_send_sms);
        get_message_method();
        this.f52r = new C05251();
        this.handler.postDelayed(this.f52r, 4000);
        this.send_sms.setOnClickListener(new C05262());
    }

    public void get_message_method() {
        String str = this.sms_to;
        HttpGet get2 = new HttpGet(SplashActivity.server_Url + "/get_sms.php?to_user=" + r0 + "&login_user=" + this.sms_from);
        try {
            this.httpClient.execute(get2);
            HttpResponse httpResponse = new DefaultHttpClient().execute(new HttpPost(SplashActivity.server_Url + "/user_sms.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("user_sms");
            int count = 0;
            ArrayList<UserBean> arrayList = new ArrayList();
            UserBean bean = new UserBean();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String to = jsonObject2.optString("to").toString();
                String login = jsonObject2.optString("login").toString();
                String sms = jsonObject2.optString("sms").toString();
                if (to.equals("")) {
                    if (login.equals("")) {
                        bean.setSMS(sms);
                    } else {
                        bean.setLOGIN(login);
                    }
                } else {
                    bean.setTO(to);
                }
                count++;
                if (count == 3) {
                    arrayList.add(bean);
                    bean = new UserBean();
                    count = 0;
                }
            }
            CustomAdapterSms adapterSms;
            if (this.chk == 0) {
                adapterSms = new CustomAdapterSms(this, arrayList);
                this.listview_sms.setAdapter(adapterSms);
                return;
            }
            if (arrayList.size() != this.leng) {
                this.leng = this.listview_sms.getAdapter().getCount();
                adapterSms = new CustomAdapterSms(this, arrayList);
                this.listview_sms.setAdapter(adapterSms);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.track_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0519R.id.action_track_location) {
            Intent grp = new Intent(getApplicationContext(), TrackActivity.class);
            grp.putExtra("whom", this.sms_to);
            startActivity(grp);
        }
        return super.onOptionsItemSelected(item);
    }
}
