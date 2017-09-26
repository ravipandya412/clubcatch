package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
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

public class LoginActivity extends Activity {
    public static String login_user;
    HttpClient httpClient2;
    private ProgressBar progress_Bar;
    ThreadPolicy th;

    /* renamed from: com.pkr.clubcatch.LoginActivity.1 */
    class C05171 implements OnClickListener {
        C05171() {
        }

        public void onClick(View v) {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this.getApplicationContext(), RegistrationActivity.class));
            LoginActivity.this.finish();
        }
    }

    /* renamed from: com.pkr.clubcatch.LoginActivity.2 */
    class C05182 implements OnClickListener {
        ArrayList arrayList;
        private final /* synthetic */ Button val$login;
        private final /* synthetic */ EditText val$pword;
        private final /* synthetic */ EditText val$uname;

        C05182(Button button, EditText editText, EditText editText2) {
            this.val$login = button;
            this.val$uname = editText;
            this.val$pword = editText2;
            this.arrayList = new ArrayList();
        }

        public void onClick(View v) {
            LoginActivity.this.progress_Bar.setVisibility(0);
            LoginActivity.this.progress_Bar.showContextMenu();
            this.val$login.setClickable(false);
            String username = this.val$uname.getText().toString();
            String password = this.val$pword.getText().toString();
            try {
                HttpGet get2 = new HttpGet(SplashActivity.server_Url + "/check_user.php?username=" + username + "&pass=" + password);
                LoginActivity.this.httpClient2.execute(get2);
                HttpResponse httpResponse = new DefaultHttpClient().execute(new HttpPost(SplashActivity.server_Url + "/user_count.json"));
                HttpEntity httpEntity = httpResponse.getEntity();
                JSONArray jsonArray = new JSONObject(EntityUtils.toString(httpResponse.getEntity(), "UTF-8")).optJSONArray("count");
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (jsonArray.getJSONObject(i).optString("count").toString().equals("1")) {
                        LoginActivity.login_user = this.val$uname.getText().toString();
                        LoginActivity.this.progress_Bar.setVisibility(4);
                        Editor editor = LoginActivity.this.getSharedPreferences("login_activity", 0).edit();
                        editor.putString("user", LoginActivity.login_user);
                        editor.commit();
                        LoginActivity.this.finish();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(intent);
                    } else {
                        this.val$login.setClickable(true);
                        LoginActivity.this.progress_Bar.setVisibility(4);
                        Toast.makeText(LoginActivity.this, "Invalid User!", 1).show();
                    }
                }
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }

    public LoginActivity() {
        this.httpClient2 = new DefaultHttpClient();
        this.th = new Builder().build();
    }

    static {
        login_user = "";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_login);
        getWindow().setSoftInputMode(3);
        StrictMode.setThreadPolicy(this.th);
        Button login = (Button) findViewById(C0519R.id.login);
        TextView loginLogo = (TextView) findViewById(C0519R.id.loginlogo);
        TextView newacc = (TextView) findViewById(C0519R.id.new_acc);
        TextView register = (TextView) findViewById(C0519R.id.registration);
        EditText uname = (EditText) findViewById(C0519R.id.username);
        EditText pword = (EditText) findViewById(C0519R.id.passwrd);
        this.progress_Bar = (ProgressBar) findViewById(C0519R.id.progressBar1);
        Typeface logintf = Typeface.createFromAsset(getAssets(), "fonts/segoe-script.ttf");
        Typeface logintf1 = Typeface.createFromAsset(getAssets(), "fonts/lucidacalligraphyitalic.ttf");
        loginLogo.setTypeface(logintf);
        login.setTypeface(logintf1);
        newacc.setTypeface(logintf1);
        register.setTypeface(logintf1);
        register.setOnClickListener(new C05171());
        login.setOnClickListener(new C05182(login, uname, pword));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.login, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0519R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
