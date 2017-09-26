package com.pkr.clubcatch;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ContactActivity extends Activity {
    HttpClient httpClient;
    private TextView name_of_Contact;
    String[] namearray;
    String namecsv;
    private TextView number_of_Contact;
    String[] phonearray;
    String phonecsv;
    ThreadPolicy th;

    /* renamed from: com.pkr.clubcatch.ContactActivity.1 */
    class C04951 implements OnItemClickListener {

        /* renamed from: com.pkr.clubcatch.ContactActivity.1.1 */
        class C04931 implements OnClickListener {
            private final /* synthetic */ String val$name;

            C04931(String str) {
                this.val$name = str;
            }

            public void onClick(DialogInterface dialog, int which) {
                try {
                    String from = URLEncoder.encode(LoginActivity.login_user, "UTF-8");
                    ContactActivity.this.httpClient.execute(new HttpGet(SplashActivity.server_Url + "/send_request.php?from=" + from + "&to=" + URLEncoder.encode(this.val$name, "UTF-8")));
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        }

        /* renamed from: com.pkr.clubcatch.ContactActivity.1.2 */
        class C04942 implements OnClickListener {
            C04942() {
            }

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }

        C04951() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            ContactActivity.this.name_of_Contact = (TextView) view.findViewById(C0519R.id.name);
            ContactActivity.this.number_of_Contact = (TextView) view.findViewById(C0519R.id.phonenumber);
            String name = ContactActivity.this.name_of_Contact.getText().toString();
            String phone = ContactActivity.this.number_of_Contact.getText().toString();
            Builder builder = new Builder(ContactActivity.this);
            builder.setTitle("Do you want to send Friend Request to " + name + " ?");
            builder.setPositiveButton("YES", new C04931(name));
            builder.setNegativeButton("NO", new C04942());
            builder.show();
        }
    }

    public ContactActivity() {
        this.namecsv = "";
        this.phonecsv = "";
        this.httpClient = new DefaultHttpClient();
        this.th = new ThreadPolicy.Builder().build();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_contact);
        StrictMode.setThreadPolicy(this.th);
        ListView lv = (ListView) findViewById(C0519R.id.contct);
        Cursor phones = getContentResolver().query(Phone.CONTENT_URI, null, null, null, "display_name ASC");
        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex("display_name"));
            String phonenumber = phones.getString(phones.getColumnIndex("data1"));
            if (name != null) {
                this.namecsv += name + ",";
                this.phonecsv += phonenumber + ",";
            }
            lv.setOnItemClickListener(new C04951());
        }
        phones.close();
        this.namearray = this.namecsv.split(",");
        this.phonearray = this.phonecsv.split(",");
        ArrayList<Contact__modelclass> contacts = new ArrayList();
        Cursor c = getContentResolver().query(Phone.CONTENT_URI, null, null, null, "display_name ASC");
        while (c.moveToNext()) {
            contacts.add(new Contact__modelclass(c.getString(c.getColumnIndex("display_name")), c.getString(c.getColumnIndex("data1"))));
        }
        c.close();
        lv.setAdapter(new ListAdapter(getBaseContext(), contacts));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0519R.menu.contact, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0519R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
