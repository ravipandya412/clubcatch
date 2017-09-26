package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.DB.DBConnect2;
import com.bean.UserBean;
import java.net.URLEncoder;
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

public class GroupActivity extends Activity {
    private ListView listview_users;
    String name;

    /* renamed from: com.pkr.clubcatch.GroupActivity.1 */
    class C05101 implements OnItemClickListener {
        private final /* synthetic */ HttpClient val$httpClient;

        /* renamed from: com.pkr.clubcatch.GroupActivity.1.1 */
        class C05081 implements OnClickListener {
            private final /* synthetic */ HttpClient val$httpClient;

            /* renamed from: com.pkr.clubcatch.GroupActivity.1.1.1 */
            class C05071 implements OnClickListener {
                C05071() {
                }

                public void onClick(DialogInterface dialog, int which) {
                }
            }

            C05081(HttpClient httpClient) {
                this.val$httpClient = httpClient;
            }

            public void onClick(DialogInterface dialog, int which) {
                try {
                    String from = URLEncoder.encode(MainActivity.user, "UTF-8");
                    String to = URLEncoder.encode(GroupActivity.this.name, "UTF-8");
                    if (DBConnect2.check_friend(from, to).equals("0")) {
                        this.val$httpClient.execute(new HttpGet(SplashActivity.server_Url + "/send_request.php?from=" + from + "&to=" + to));
                        Toast.makeText(GroupActivity.this, "Friend request sent to " + GroupActivity.this.name, 1).show();
                        GroupActivity.this.startActivity(new Intent(GroupActivity.this, MainActivity.class));
                        return;
                    }
                    Builder builder = new Builder(GroupActivity.this);
                    builder.setTitle(new StringBuilder(String.valueOf(to)).append(" is already your friend.").toString());
                    builder.setPositiveButton("Ok", new C05071());
                    builder.show();
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        }

        /* renamed from: com.pkr.clubcatch.GroupActivity.1.2 */
        class C05092 implements OnClickListener {
            C05092() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        C05101(HttpClient httpClient) {
            this.val$httpClient = httpClient;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            GroupActivity.this.name = (String) GroupActivity.this.listview_users.getItemAtPosition(position);
            Builder builder = new Builder(GroupActivity.this);
            builder.setTitle("Do you want to send Friend Request to " + GroupActivity.this.name + " ?");
            builder.setPositiveButton("YES", new C05081(this.val$httpClient));
            builder.setNegativeButton("NO", new C05092());
            builder.show();
        }
    }

    public GroupActivity() {
        this.name = "";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_group);
        this.listview_users = (ListView) findViewById(C0519R.id.listView_users);
        get_Users();
        this.listview_users.setOnItemClickListener(new C05101(new DefaultHttpClient()));
    }

    public void get_Users() {
        HttpGet get1 = new HttpGet(SplashActivity.server_Url + "/get_users.php?login_user=" + MainActivity.user);
        try {
            HttpClient httpClient = new DefaultHttpClient();
            httpClient.execute(get1);
            HttpResponse httpResponse = httpClient.execute(new HttpPost(SplashActivity.server_Url + "/user_list_reply.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("user");
            ArrayList arrayList1 = new ArrayList();
            UserBean bean1 = new UserBean();
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList1.add(jsonArray.getJSONObject(i).optString("user").toString());
            }
            ArrayAdapter adapterNotify = new ArrayAdapter(this, C0519R.layout.custom_listview, arrayList1);
            this.listview_users.setAdapter(adapterNotify);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
