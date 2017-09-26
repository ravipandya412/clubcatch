package com.pkr.clubcatch;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
    public static String user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_main);
        user = getSharedPreferences("login_activity", 0).getString("user", null);
        System.out.println(user);
        Typeface logintf1 = Typeface.createFromAsset(getAssets(), "fonts/lucidacalligraphyitalic.ttf");
        setTitle("Club Catch");
        TabHost tabHost = (TabHost) findViewById(16908306);
        TabSpec ts = tabHost.newTabSpec("Group");
        TabSpec ts1 = tabHost.newTabSpec("Chat");
        TabSpec ts2 = tabHost.newTabSpec("Group");
        ts.setIndicator("Group").setContent(new Intent(this, GroupList.class));
        ts1.setIndicator("Chat").setContent(new Intent(this, ChatActivity.class));
        ts2.setIndicator("Users").setContent(new Intent(this, GroupActivity.class));
        tabHost.addTab(ts);
        tabHost.addTab(ts1);
        tabHost.addTab(ts2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0519R.id.action_create_group) {
            startActivity(new Intent(getApplicationContext(), GrpCreationActivity.class));
        } else if (id == C0519R.id.action_logout) {
            finish();
            getSharedPreferences("login_activity", 0).edit().remove("user").commit();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        } else if (id == C0519R.id.action_request_notification) {
            startActivity(new Intent(getApplicationContext(), NotificationRequestActivity.class));
        } else if (id == C0519R.id.action_track_notification) {
            startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
        } else if (id == C0519R.id.action_show_location) {
            startActivity(new Intent(getApplicationContext(), LocationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
