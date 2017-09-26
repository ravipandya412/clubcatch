package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.DB.DBConnect2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends Activity {
    final Context context;
    HttpClient httpClient;
    ThreadPolicy th;

    /* renamed from: com.pkr.clubcatch.RegistrationActivity.1 */
    class C05221 implements OnClickListener {
        private final /* synthetic */ EditText val$phnnum;
        private final /* synthetic */ EditText val$pswd;
        private final /* synthetic */ Button val$regstr;
        private final /* synthetic */ EditText val$repswd;
        private final /* synthetic */ EditText val$usrname;

        /* renamed from: com.pkr.clubcatch.RegistrationActivity.1.1 */
        class C05211 implements DialogInterface.OnClickListener {
            private final /* synthetic */ String val$mobile;
            private final /* synthetic */ String val$password;
            private final /* synthetic */ Button val$regstr;
            private final /* synthetic */ String val$username;

            /* renamed from: com.pkr.clubcatch.RegistrationActivity.1.1.1 */
            class C05201 implements DialogInterface.OnClickListener {
                C05201() {
                }

                public void onClick(DialogInterface dialog, int which) {
                }
            }

            C05211(String str, String str2, String str3, Button button) {
                this.val$username = str;
                this.val$mobile = str2;
                this.val$password = str3;
                this.val$regstr = button;
            }

            public void onClick(DialogInterface dialog, int which) {
                if (DBConnect2.check_register(this.val$username).equals("0")) {
                    try {
                        RegistrationActivity.this.httpClient.execute(new HttpGet(SplashActivity.server_Url + "/send_username.php?username=" + this.val$username + "&mobile=" + this.val$mobile + "&pass=" + this.val$password));
                        RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                        return;
                    } catch (Exception exception) {
                        System.out.println(exception);
                        return;
                    }
                }
                this.val$regstr.setClickable(true);
                Builder builder = new Builder(RegistrationActivity.this);
                builder.setTitle("Username " + this.val$username + " is already registered.");
                builder.setPositiveButton("Ok", new C05201());
                builder.show();
            }
        }

        C05221(EditText editText, EditText editText2, EditText editText3, EditText editText4, Button button) {
            this.val$usrname = editText;
            this.val$phnnum = editText2;
            this.val$pswd = editText3;
            this.val$repswd = editText4;
            this.val$regstr = button;
        }

        public void onClick(View v) {
            if (this.val$usrname.getText().toString().matches("") && this.val$phnnum.getText().toString().matches("")) {
                RegistrationActivity.this.showMessage("Error", "Field can not be empty!!");
            } else if (this.val$phnnum.getText().toString().length() > 10) {
                RegistrationActivity.this.showMessage("Error", "Please enter valid Phone_Number");
            } else if (this.val$phnnum.getText().toString().length() < 10) {
                RegistrationActivity.this.showMessage("Error", "Please enter valid Phone Number");
            } else if (this.val$pswd.getText().toString().matches("") && this.val$repswd.getText().toString().matches("")) {
                RegistrationActivity.this.showMessage("Error", "Field can not be empty!!");
            } else if (this.val$pswd.getText().toString().equals(this.val$repswd.getText().toString())) {
                String username = this.val$usrname.getText().toString();
                String mobile = this.val$phnnum.getText().toString();
                String password = this.val$pswd.getText().toString();
                this.val$regstr.setClickable(false);
                Builder builder = new Builder(RegistrationActivity.this);
                builder.setTitle("Is this " + mobile + " is confirmed??");
                builder.setPositiveButton("YES", new C05211(username, mobile, password, this.val$regstr));
                builder.show();
            } else {
                RegistrationActivity.this.showMessage("Error", "Please enter valid Password");
            }
        }
    }

    public class SignupActivity extends AsyncTask<String, Void, String> {
        private Context context;

        public SignupActivity(Context context) {
            this.context = context;
        }

        protected void onPreExecute() {
        }

        protected String doInBackground(String... arg0) {
            try {
                return new BufferedReader(new InputStreamReader(((HttpURLConnection) new URL("http://testandroid.netai.net/signup.php" + new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("?fullname=" + URLEncoder.encode(arg0[0], "UTF-8"))).append("&username=").append(URLEncoder.encode(arg0[1], "UTF-8")).toString())).append("&password=").append(URLEncoder.encode(arg0[2], "UTF-8")).toString()).openConnection()).getInputStream())).readLine();
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    String query_result = new JSONObject(jsonStr).getString("query_result");
                    if (query_result.equals("SUCCESS")) {
                        Toast.makeText(this.context, "Data inserted successfully. Signup successfull.", 0).show();
                        return;
                    } else if (query_result.equals("FAILURE")) {
                        Toast.makeText(this.context, "Data could not be inserted. Signup failed.", 0).show();
                        return;
                    } else {
                        Toast.makeText(this.context, "Couldn't connect to remote database.", 0).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this.context, "Error parsing JSON data.", 0).show();
                    return;
                }
            }
            Toast.makeText(this.context, "Couldn't get any JSON data.", 0).show();
        }
    }

    public RegistrationActivity() {
        this.context = this;
        this.th = new ThreadPolicy.Builder().build();
        this.httpClient = new DefaultHttpClient();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_registration);
        getWindow().setSoftInputMode(3);
        StrictMode.setThreadPolicy(this.th);
        EditText usrname = (EditText) findViewById(C0519R.id.username_reg);
        EditText phnnum = (EditText) findViewById(C0519R.id.phone_num);
        EditText pswd = (EditText) findViewById(C0519R.id.passwrd_reg);
        EditText repswd = (EditText) findViewById(C0519R.id.re_enter_passwrd);
        Button regstr = (Button) findViewById(C0519R.id.register);
        regstr.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/lucidacalligraphyitalic.ttf"));
        regstr.setOnClickListener(new C05221(usrname, phnnum, pswd, repswd, regstr));
    }

    protected void showMessage(String title, String Msg) {
        Builder b = new Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(Msg);
        b.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.registration, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0519R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
