package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GrpCreationActivity extends Activity {
    public static String grp_name;
    private Button button_next;
    private EditText edittext_grp_name;

    /* renamed from: com.pkr.clubcatch.GrpCreationActivity.1 */
    class C05161 implements OnClickListener {
        C05161() {
        }

        public void onClick(View v) {
            GrpCreationActivity.grp_name = GrpCreationActivity.this.edittext_grp_name.getText().toString();
            if (GrpCreationActivity.grp_name.equals("")) {
                Toast.makeText(GrpCreationActivity.this, "Group Name cannot be empty", 0).show();
            } else {
                GrpCreationActivity.this.startActivity(new Intent(GrpCreationActivity.this, AddMemberActivity.class));
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_grp_creation);
        setTitle("Creation Of Group");
        this.edittext_grp_name = (EditText) findViewById(C0519R.id.grp_name);
        this.button_next = (Button) findViewById(C0519R.id.create);
        this.button_next.setOnClickListener(new C05161());
    }
}
