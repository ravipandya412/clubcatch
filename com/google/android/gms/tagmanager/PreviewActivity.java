package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C04231 implements OnClickListener {
        final /* synthetic */ PreviewActivity VR;

        C04231(PreviewActivity previewActivity) {
            this.VR = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void m1236a(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C04231(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            bh.m1271u("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).m1241f(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                bh.m1273w(str);
                m1236a("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                bh.m1271u("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            bh.m1271u("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            bh.m1270t("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
