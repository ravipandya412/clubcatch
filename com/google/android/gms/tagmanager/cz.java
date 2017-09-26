package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cz {

    /* renamed from: com.google.android.gms.tagmanager.cz.1 */
    static class C04541 implements Runnable {
        final /* synthetic */ Editor Xr;

        C04541(Editor editor) {
            this.Xr = editor;
        }

        public void run() {
            this.Xr.commit();
        }
    }

    static void m1341a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m1342a(edit);
    }

    static void m1342a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C04541(editor)).start();
        }
    }
}
