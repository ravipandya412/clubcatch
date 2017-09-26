package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import com.DB.DBConnect;
import java.util.ArrayList;

public class AddMemberActivity extends Activity {
    private Button button_add_member_done;
    private CheckBox check_bx;
    private ListView listview_add_member;
    ArrayList userName;

    /* renamed from: com.pkr.clubcatch.AddMemberActivity.1 */
    class C04911 implements OnClickListener {
        private final /* synthetic */ ArrayList val$arrayList;

        C04911(ArrayList arrayList) {
            this.val$arrayList = arrayList;
        }

        public void onClick(View v) {
            for (int i = 0; i < CustomAdapterAddMember.user_selected.size(); i++) {
                AddMemberActivity.this.userName.add(this.val$arrayList.get(Integer.parseInt((String) CustomAdapterAddMember.user_selected.get(i))));
            }
            DBConnect.create_grp(GrpCreationActivity.grp_name, AddMemberActivity.this.userName);
            AddMemberActivity.this.userName.clear();
            AddMemberActivity.this.startActivity(new Intent(AddMemberActivity.this, MainActivity.class));
        }
    }

    public AddMemberActivity() {
        this.userName = new ArrayList();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_add_member);
        this.listview_add_member = (ListView) findViewById(C0519R.id.listview_add_member);
        this.button_add_member_done = (Button) findViewById(C0519R.id.button_add_member_done);
        this.check_bx = (CheckBox) findViewById(C0519R.id.checkBox_add_member);
        ArrayList arrayList = DBConnect.friend_list();
        this.listview_add_member.setAdapter(new CustomAdapterAddMember(this, arrayList));
        this.button_add_member_done.setOnClickListener(new C04911(arrayList));
    }
}
