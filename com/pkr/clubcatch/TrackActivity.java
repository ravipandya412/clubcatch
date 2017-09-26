package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.DB.DBConnect2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrackActivity extends Activity {
    HttpClient httpClient;
    ThreadPolicy th;
    private Button track_button;
    private TextView track_textview;

    /* renamed from: com.pkr.clubcatch.TrackActivity.1 */
    class C05311 implements OnClickListener {
        private final /* synthetic */ String val$whom;

        /* renamed from: com.pkr.clubcatch.TrackActivity.1.1 */
        class C05301 implements DialogInterface.OnClickListener {
            private final /* synthetic */ String val$whom;

            C05301(String str) {
                this.val$whom = str;
            }

            public void onClick(DialogInterface dialog, int which) {
                DBConnect2.send_new_track(this.val$whom, MainActivity.user);
            }
        }

        C05311(String str) {
            this.val$whom = str;
        }

        public void onClick(View v) {
            try {
                String str = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(SplashActivity.server_Url + "/send_track_request.php?whom=" + this.val$whom + "&who=" + MainActivity.user)).getEntity().getContent(), "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    try {
                        builder.append(new StringBuilder(String.valueOf(line)).append("\n").toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                JSONArray jsonArray = new JSONObject(builder.toString()).optJSONArray("s");
                for (int i = 0; i < jsonArray.length(); i++) {
                    str = jsonArray.getJSONObject(i).optString("s").toString();
                }
                if (str.equals("1")) {
                    TrackActivity.this.finish();
                    Intent intent = new Intent(TrackActivity.this, MainActivity.class);
                    TrackActivity.this.startActivity(intent);
                    Toast.makeText(TrackActivity.this, "Track request sent to " + this.val$whom, 0).show();
                    return;
                }
                Builder builder2 = new Builder(TrackActivity.this);
                builder2.setTitle("You already have " + this.val$whom + " location");
                builder2.setMessage("Send again location request?");
                C05301 c05301 = new C05301(this.val$whom);
                builder2.setPositiveButton("Yes", c05301);
                builder2.show();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public TrackActivity() {
        this.httpClient = new DefaultHttpClient();
        this.th = new ThreadPolicy.Builder().build();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_track);
        StrictMode.setThreadPolicy(this.th);
        String whom = getIntent().getExtras().getString("whom");
        this.track_textview = (TextView) findViewById(C0519R.id.textview_track);
        this.track_button = (Button) findViewById(C0519R.id.button_track);
        this.track_textview.setText("Track to " + whom + " ?");
        this.track_button.setOnClickListener(new C05311(whom));
    }
}
