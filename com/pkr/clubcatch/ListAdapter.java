package com.pkr.clubcatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private ArrayList<Contact__modelclass> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public class ViewHolder {
        TextView name;
        TextView phone_num;
    }

    public ListAdapter(Context context, ArrayList<Contact__modelclass> arrayList) {
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(C0519R.layout.row_contact, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(C0519R.id.name);
            viewHolder.phone_num = (TextView) convertView.findViewById(C0519R.id.phonenumber);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(((Contact__modelclass) this.arrayList.get(position)).getName());
        viewHolder.phone_num.setText(((Contact__modelclass) this.arrayList.get(position)).getPhone());
        return convertView;
    }
}
