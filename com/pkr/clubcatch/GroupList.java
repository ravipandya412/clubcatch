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
import java.util.ArrayList;

public class GroupList extends Activity {
    private ListView listview_grp_list;

    /* renamed from: com.pkr.clubcatch.GroupList.1 */
    class C05111 implements OnItemClickListener {
        C05111() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String groupName = GroupList.this.listview_grp_list.getItemAtPosition(position).toString();
            Intent intent = new Intent(GroupList.this, GroupSms.class);
            intent.putExtra("grp", groupName);
            GroupList.this.startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_group_list);
        this.listview_grp_list = (ListView) findViewById(C0519R.id.listview_grp_list);
        ArrayList arrayList = DBConnect.get_grp_list();
        if (!arrayList.get(0).equals("0")) {
            this.listview_grp_list.setAdapter(new ArrayAdapter(this, C0519R.layout.custom_listview, arrayList));
        }
        this.listview_grp_list.setOnItemClickListener(new C05111());
    }
}
