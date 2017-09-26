package com.pkr.clubcatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapterAddMember extends BaseAdapter {
    static ArrayList user_selected;
    ArrayList arrayList;
    private CheckBox chkSelect;
    Context context;
    private ListView listview_add;
    private TextView textview_add_member_name;

    /* renamed from: com.pkr.clubcatch.CustomAdapterAddMember.1 */
    class C04961 implements OnCheckedChangeListener {
        private final /* synthetic */ int val$position;

        C04961(int i) {
            this.val$position = i;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                CustomAdapterAddMember.user_selected.add(this.val$position);
            } else {
                CustomAdapterAddMember.user_selected.remove(this.val$position);
            }
        }
    }

    static {
        user_selected = new ArrayList();
    }

    public CustomAdapterAddMember(Context context, ArrayList arrayList) {
        this.arrayList = new ArrayList();
        this.context = context;
        this.arrayList = arrayList;
    }

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int position) {
        return Integer.valueOf(this.arrayList.size());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (convertView == null) {
            convertView = inflater.inflate(C0519R.layout.custom_add_member, null);
        }
        this.textview_add_member_name = (TextView) convertView.findViewById(C0519R.id.textView_add_member_name);
        this.chkSelect = (CheckBox) convertView.findViewById(C0519R.id.checkBox_add_member);
        this.textview_add_member_name.setText(this.arrayList.get(position).toString());
        this.chkSelect.setOnCheckedChangeListener(new C04961(position));
        return convertView;
    }
}
