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

public class LocationActivity extends Activity {
    HttpClient httpClient;
    private ListView listviewLocation;
    ThreadPolicy th;

    public LocationActivity() {
        this.httpClient = new DefaultHttpClient();
        this.th = new Builder().build();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_location);
        StrictMode.setThreadPolicy(this.th);
        this.listviewLocation = (ListView) findViewById(C0519R.id.listView1_location);
        HttpGet get2 = new HttpGet(SplashActivity.server_Url + "/get_location.php?login_user=" + MainActivity.user);
        try {
            this.httpClient.execute(get2);
            HttpResponse httpResponse = new DefaultHttpClient().execute(new HttpPost(SplashActivity.server_Url + "/location.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("location");
            int count = 0;
            ArrayList<UserBean> arrayList = new ArrayList();
            UserBean bean = new UserBean();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String whom = jsonObject2.optString("whom").toString();
                String latitude = jsonObject2.optString("latitude").toString();
                String longitude = jsonObject2.optString("longitude").toString();
                if (whom.equals("")) {
                    if (latitude.equals("")) {
                        bean.setLONGITUDE(longitude);
                    } else {
                        bean.setLATITUDE(latitude);
                    }
                } else {
                    bean.setWHOM_LOCATION(whom);
                }
                count++;
                if (count == 3) {
                    arrayList.add(bean);
                    bean = new UserBean();
                    count = 0;
                }
            }
            CustomAdapterLocation adapterLocation = new CustomAdapterLocation(this, arrayList);
            this.listviewLocation.setAdapter(adapterLocation);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
