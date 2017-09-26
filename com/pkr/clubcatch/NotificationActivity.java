package com.pkr.clubcatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.widget.Button;
import android.widget.ListView;
import com.bean.UserBean;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificationActivity extends Activity {
    Button btnShowLocation;
    private Button button_accept;
    private Button button_reject;
    GPSTracker gps;
    HttpClient httpClient;
    private ListView listview_notification;
    ThreadPolicy th;

    public NotificationActivity() {
        this.httpClient = new DefaultHttpClient();
        this.th = new Builder().build();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_notification);
        this.listview_notification = (ListView) findViewById(C0519R.id.listview_notification);
        StrictMode.setThreadPolicy(this.th);
        HttpGet get2 = new HttpGet(SplashActivity.server_Url + "/get_track_notification.php?login_user=" + MainActivity.user);
        try {
            this.httpClient.execute(get2);
            HttpResponse httpResponse = new DefaultHttpClient().execute(new HttpPost(SplashActivity.server_Url + "/track_request_reply.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("track_request");
            int count = 0;
            ArrayList<UserBean> arrayList = new ArrayList();
            if (arrayList != null) {
                UserBean bean = new UserBean();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                    String who = jsonObject2.optString("who").toString();
                    String whom = jsonObject2.optString("whom").toString();
                    if (!who.equals("")) {
                        bean.setWHO(who);
                    } else if (!whom.equals("")) {
                        bean.setWHOM(whom);
                    }
                    count++;
                    if (count == 2) {
                        arrayList.add(bean);
                        bean = new UserBean();
                        count = 0;
                    }
                }
                CustomAdapterNotification adapterNotify = new CustomAdapterNotification(this, arrayList);
                this.listview_notification.setAdapter(adapterNotify);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
