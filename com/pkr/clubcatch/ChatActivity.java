package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.DB.DBConnect;

public class ChatActivity extends Activity {
    private ListView chat_list;

    /* renamed from: com.pkr.clubcatch.ChatActivity.1 */
    class C04921 implements OnItemClickListener {
        C04921() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String name = (String) ChatActivity.this.chat_list.getItemAtPosition(position);
            Intent intent = new Intent(ChatActivity.this, SmsActivity.class);
            intent.putExtra("sms_to", name);
            ChatActivity.this.startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_chat);
        this.chat_list = (ListView) findViewById(C0519R.id.listview_Chatview);
        this.chat_list.setAdapter(new ArrayAdapter(this, C0519R.layout.custom_listview, DBConnect.friend_list()));
        this.chat_list.setOnItemClickListener(new C04921());
    }
}
