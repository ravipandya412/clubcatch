package com.pkr.clubcatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.DB.DBConnect;

public class GetPinpoint extends Activity {
    private ListView listview_get_pinpoint;

    /* renamed from: com.pkr.clubcatch.GetPinpoint.1 */
    class C05061 implements OnItemClickListener {
        private TextView textview_lat;
        private TextView textview_lon;
        private TextView textview_n;
        private TextView textview_w;

        C05061() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            this.textview_n = (TextView) view.findViewById(C0519R.id.textView_pinpoint_name);
            this.textview_w = (TextView) view.findViewById(C0519R.id.textView_pinpoint_who);
            this.textview_lat = (TextView) view.findViewById(C0519R.id.textView_pinpoint_latitude);
            this.textview_lon = (TextView) view.findViewById(C0519R.id.textView_pinpoint_longitude);
            Intent intent = new Intent(GetPinpoint.this, ShowPinpointMap.class);
            intent.putExtra("n", this.textview_n.getText().toString());
            intent.putExtra("lat", this.textview_lat.getText().toString());
            intent.putExtra("lon", this.textview_lon.getText().toString());
            GetPinpoint.this.startActivity(intent);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0519R.layout.activity_get_pinpoint);
        this.listview_get_pinpoint = (ListView) findViewById(C0519R.id.listview_get_pinpoint);
        this.listview_get_pinpoint.setAdapter(new CustomAdapterGetPinpoint(this, DBConnect.get_pinpoint(GroupSms.grpName)));
        this.listview_get_pinpoint.setOnItemClickListener(new C05061());
    }
}
