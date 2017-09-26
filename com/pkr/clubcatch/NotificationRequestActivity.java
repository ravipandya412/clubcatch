package com.pkr.clubcatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
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

public class NotificationRequestActivity extends Activity {
    HttpClient httpClient;
    private ListView listview_notification2;
    ThreadPolicy th;

    public NotificationRequestActivity() {
        this.httpClient = new DefaultHttpClient();
        this.th = new Builder().build();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_notification_request);
        StrictMode.setThreadPolicy(this.th);
        this.listview_notification2 = (ListView) findViewById(C0519R.id.listview_notification2);
        HttpGet get1 = new HttpGet(SplashActivity.server_Url + "/get_friend_request_notification.php?login_user=" + MainActivity.user);
        try {
            this.httpClient.execute(get1);
            HttpResponse httpResponse = new DefaultHttpClient().execute(new HttpPost(SplashActivity.server_Url + "/friend_request_reply.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("friend_request");
            int count1 = 0;
            ArrayList<UserBean> arrayList1 = new ArrayList();
            UserBean bean1 = new UserBean();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String from = jsonObject2.optString("from_request").toString();
                String to = jsonObject2.optString("to_request").toString();
                if (from.equals("")) {
                    if (!to.equals("")) {
                        bean1.setTO_REQUEST(to);
                    }
                } else {
                    bean1.setFROM_REQUEST(from);
                }
                count1++;
                if (count1 == 2) {
                    arrayList1.add(bean1);
                    bean1 = new UserBean();
                    count1 = 0;
                }
            }
            CustomAdapterNotification2 adapterNotify = new CustomAdapterNotification2(this, arrayList1);
            this.listview_notification2.setAdapter(adapterNotify);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
