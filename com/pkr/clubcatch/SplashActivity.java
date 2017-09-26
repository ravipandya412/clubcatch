package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {
    public static String server_Url;

    /* renamed from: com.pkr.clubcatch.SplashActivity.1 */
    class C05271 extends Thread {
        C05271() {
        }

        public void run() {
            try {
                C05271.sleep(3000);
                if (SplashActivity.this.getSharedPreferences("login_activity", 0).getString("user", null) == null) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    SplashActivity.this.finish();
                    return;
                }
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /* renamed from: com.pkr.clubcatch.SplashActivity.2 */
    class C05282 implements OnClickListener {
        C05282() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            SplashActivity.this.startActivity(new Intent(SplashActivity.this.getApplicationContext(), SplashActivity.class));
            SplashActivity.this.finish();
        }
    }

    /* renamed from: com.pkr.clubcatch.SplashActivity.3 */
    class C05293 implements OnClickListener {
        C05293() {
        }

        public void onClick(DialogInterface dialog, int which) {
            System.exit(0);
        }
    }

    static {
        server_Url = "http://clubcatch.freeoda.com/Club";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_splash);
        if (Boolean.valueOf(isNetworkAvailable()).equals(Boolean.valueOf(false))) {
            show_Dialog_Box();
        } else {
            new C05271().start();
        }
    }

    public void show_Dialog_Box() {
        System.out.println("1");
        Builder builder = new Builder(this);
        builder.setTitle("No Internet Connection : ");
        System.out.println("2");
        builder.setPositiveButton("Try Again", new C05282());
        System.out.println("3");
        builder.setNegativeButton("Exit", new C05293());
        System.out.println("4");
        builder.show();
    }

    private boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.splash, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0519R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
