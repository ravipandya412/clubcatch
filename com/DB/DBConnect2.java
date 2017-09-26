package com.DB;

import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.pkr.clubcatch.SplashActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class DBConnect2 {
    static ThreadPolicy th;

    static {
        th = new Builder().build();
    }

    public static String check_friend(String from, String to) {
        String status = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/check_friend.php?from=" + from + "&to=" + to)).getEntity().getContent(), "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
            }
            JSONArray jsonArray = new JSONObject(builder.toString()).optJSONArray("s");
            for (int i = 0; i < jsonArray.length(); i++) {
                status = jsonArray.getJSONObject(i).optString("s").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static String check_register(String username) {
        String status = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/check_register.php?username=" + username)).getEntity().getContent(), "UTF-8"), 8);
            StringBuilder builder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
            }
            JSONArray jsonArray = new JSONObject(builder.toString()).optJSONArray("s");
            for (int i = 0; i < jsonArray.length(); i++) {
                status = jsonArray.getJSONObject(i).optString("s").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void send_new_track(String whom, String who) {
        try {
            new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/send_new_track.php?whom=" + whom + "&who=" + who));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
