package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class cz {
    public static final Handler pT;

    static {
        pT = new Handler(Looper.getMainLooper());
    }

    public static int m556a(Context context, int i) {
        return m557a(context.getResources().getDisplayMetrics(), i);
    }

    public static int m557a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    public static void m558a(ViewGroup viewGroup, ab abVar, String str) {
        m559a(viewGroup, abVar, str, ViewCompat.MEASURED_STATE_MASK, -1);
    }

    private static void m559a(ViewGroup viewGroup, ab abVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m556a(context, 3);
            frameLayout.addView(textView, new LayoutParams(abVar.widthPixels - a, abVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, abVar.widthPixels, abVar.heightPixels);
        }
    }

    public static void m560a(ViewGroup viewGroup, ab abVar, String str, String str2) {
        da.m570w(str2);
        m559a(viewGroup, abVar, str, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK);
    }

    public static boolean aW() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean aX() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String m561l(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || aW()) {
            string = "emulator";
        }
        return m562r(string);
    }

    public static String m562r(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }
}
