package com.DB;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.bean.UserBean;
import com.bean.UserBean2;
import com.pkr.clubcatch.MainActivity;
import com.pkr.clubcatch.SplashActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

public class DBConnect {
    static ThreadPolicy th;

    static {
        th = new Builder().build();
    }

    public static ArrayList friend_list() {
        Exception exception;
        HttpGet get1 = new HttpGet(SplashActivity.server_Url + "/get_friend_list.php?login_user=" + MainActivity.user);
        ArrayList arrayList1 = new ArrayList();
        try {
            HttpClient httpClient = new DefaultHttpClient();
            httpClient.execute(get1);
            HttpResponse httpResponse = httpClient.execute(new HttpPost(SplashActivity.server_Url + "/friend_list_reply.json"));
            HttpEntity httpEntity = httpResponse.getEntity();
            JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("friend");
            ArrayList arrayList12 = new ArrayList();
            try {
                UserBean bean1 = new UserBean();
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList12.add(jsonArray.getJSONObject(i).optString("friend").toString());
                }
                return arrayList12;
            } catch (Exception e) {
                exception = e;
                arrayList1 = arrayList12;
                System.out.println(exception);
                return arrayList1;
            }
        } catch (Exception e2) {
            exception = e2;
            System.out.println(exception);
            return arrayList1;
        }
    }

    public static void create_grp(String gName, ArrayList users) {
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/create_grp.php?gName=" + gName + "&user=" + MainActivity.user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < users.size(); i++) {
            try {
                new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/create_grp.php?gName=" + gName + "&user=" + users.get(i)));
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public static ArrayList get_grp_list() {
        StrictMode.setThreadPolicy(th);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost get2 = new HttpPost(SplashActivity.server_Url + "/get_grp_list.php?login_user=" + MainActivity.user);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpClient.execute(get2).getEntity().getContent(), "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
            }
            System.out.println(builder);
            String f = builder.toString();
            System.out.println(f);
            JSONArray jsonArray = new JSONObject(f).optJSONArray("groupname");
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(jsonArray.getJSONObject(i).optString("groupname").toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.bean.UserBean> get_grp_Sms(java.lang.String r24) {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        r20 = new com.bean.UserBean;
        r20.<init>();
        r11 = new org.apache.http.impl.client.DefaultHttpClient;
        r11.<init>();
        r10 = new org.apache.http.client.methods.HttpPost;
        r22 = new java.lang.StringBuilder;
        r23 = com.pkr.clubcatch.SplashActivity.server_Url;
        r23 = java.lang.String.valueOf(r23);
        r22.<init>(r23);
        r23 = "/get_grp_sms.php?login_user=";
        r22 = r22.append(r23);
        r23 = com.pkr.clubcatch.MainActivity.user;
        r22 = r22.append(r23);
        r23 = "&groupname=";
        r22 = r22.append(r23);
        r0 = r22;
        r1 = r24;
        r22 = r0.append(r1);
        r22 = r22.toString();
        r0 = r22;
        r10.<init>(r0);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r9 = 0;
        r13 = r11.execute(r10);	 Catch:{ Exception -> 0x00b1 }
        r12 = r13.getEntity();	 Catch:{ Exception -> 0x00b1 }
        r15 = r12.getContent();	 Catch:{ Exception -> 0x00b1 }
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00b1 }
        r22 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00b1 }
        r23 = "UTF-8";
        r0 = r22;
        r1 = r23;
        r0.<init>(r15, r1);	 Catch:{ Exception -> 0x00b1 }
        r23 = 8;
        r0 = r22;
        r1 = r23;
        r4.<init>(r0, r1);	 Catch:{ Exception -> 0x00b1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b1 }
        r5.<init>();	 Catch:{ Exception -> 0x00b1 }
        r19 = 0;
    L_0x006e:
        r19 = r4.readLine();	 Catch:{ Exception -> 0x00b1 }
        if (r19 != 0) goto L_0x0098;
    L_0x0074:
        r8 = r5.toString();	 Catch:{ Exception -> 0x00b1 }
        r17 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00b1 }
        r0 = r17;
        r0.<init>(r8);	 Catch:{ Exception -> 0x00b1 }
        r22 = "groupsms";
        r0 = r17;
        r1 = r22;
        r16 = r0.optJSONArray(r1);	 Catch:{ Exception -> 0x00b1 }
        r6 = 0;
        r14 = 0;
        r21 = r20;
    L_0x008d:
        r22 = r16.length();	 Catch:{ Exception -> 0x0101 }
        r0 = r22;
        if (r14 < r0) goto L_0x00b6;
    L_0x0095:
        r20 = r21;
    L_0x0097:
        return r2;
    L_0x0098:
        r22 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b1 }
        r23 = java.lang.String.valueOf(r19);	 Catch:{ Exception -> 0x00b1 }
        r22.<init>(r23);	 Catch:{ Exception -> 0x00b1 }
        r23 = "\n";
        r22 = r22.append(r23);	 Catch:{ Exception -> 0x00b1 }
        r22 = r22.toString();	 Catch:{ Exception -> 0x00b1 }
        r0 = r22;
        r5.append(r0);	 Catch:{ Exception -> 0x00b1 }
        goto L_0x006e;
    L_0x00b1:
        r7 = move-exception;
    L_0x00b2:
        r7.printStackTrace();
        goto L_0x0097;
    L_0x00b6:
        r0 = r16;
        r18 = r0.getJSONObject(r14);	 Catch:{ Exception -> 0x0101 }
        if (r6 != 0) goto L_0x00eb;
    L_0x00be:
        r20 = new com.bean.UserBean;	 Catch:{ Exception -> 0x0101 }
        r20.<init>();	 Catch:{ Exception -> 0x0101 }
        r22 = "sms";
        r0 = r18;
        r1 = r22;
        r22 = r0.optString(r1);	 Catch:{ Exception -> 0x00b1 }
        r22 = r22.toString();	 Catch:{ Exception -> 0x00b1 }
        r0 = r20;
        r1 = r22;
        r0.setGRP_SMS(r1);	 Catch:{ Exception -> 0x00b1 }
        r6 = r6 + 1;
    L_0x00da:
        r22 = 2;
        r0 = r22;
        if (r6 != r0) goto L_0x00e6;
    L_0x00e0:
        r0 = r20;
        r2.add(r0);	 Catch:{ Exception -> 0x00b1 }
        r6 = 0;
    L_0x00e6:
        r14 = r14 + 1;
        r21 = r20;
        goto L_0x008d;
    L_0x00eb:
        r22 = "who";
        r0 = r18;
        r1 = r22;
        r22 = r0.optString(r1);	 Catch:{ Exception -> 0x0101 }
        r22 = r22.toString();	 Catch:{ Exception -> 0x0101 }
        r21.setSMS_WHO(r22);	 Catch:{ Exception -> 0x0101 }
        r6 = r6 + 1;
        r20 = r21;
        goto L_0x00da;
    L_0x0101:
        r7 = move-exception;
        r20 = r21;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.DB.DBConnect.get_grp_Sms(java.lang.String):java.util.ArrayList<com.bean.UserBean>");
    }

    public static void send_grp_sms(String grpName, String sms) {
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/send_grp_sms.php?gName=" + grpName + "&user=" + MainActivity.user + "&sms=" + URLEncoder.encode(sms, "UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void set_pinpoint(String latitude, String longitude, String grpName, String namePin) {
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/set_pinpoint.php?gName=" + grpName + "&user=" + MainActivity.user + "&latitude=" + latitude + "&longitude=" + longitude + "&namePin=" + URLEncoder.encode(namePin, "UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList get_pinpoint(String gName) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost get2 = new HttpPost(SplashActivity.server_Url + "/get_pinpoint.php?gName=" + gName);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpClient.execute(get2).getEntity().getContent(), "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
            }
            System.out.println(builder);
            String f = builder.toString();
            System.out.println(f);
            JSONArray jsonArray = new JSONObject(f).optJSONArray("getP");
            UserBean2 userBean = null;
            int count = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                if (count == 0) {
                    userBean = new UserBean2();
                    userBean.setNamePin(jsonObject2.optString("n").toString());
                    count++;
                } else if (count == 1) {
                    userBean.setWho(jsonObject2.optString("w").toString());
                    count++;
                } else if (count == 2) {
                    userBean.setLat(jsonObject2.optString("lat").toString());
                    count++;
                } else {
                    userBean.setLon(jsonObject2.optString("lon").toString());
                    count++;
                }
                if (count == 4) {
                    arrayList.add(userBean);
                    count = 0;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }
}
