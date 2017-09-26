package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C0724i implements C0344h {
    protected MotionEvent jY;
    protected DisplayMetrics jZ;
    protected C0357n ka;
    private C0358o kb;

    protected C0724i(Context context, C0357n c0357n, C0358o c0358o) {
        this.ka = c0357n;
        this.kb = c0358o;
        try {
            this.jZ = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jZ = new DisplayMetrics();
            this.jZ.density = 1.0f;
        }
    }

    private String m2086a(Context context, String str, boolean z) {
        try {
            byte[] u;
            synchronized (this) {
                m2087t();
                if (z) {
                    m2098c(context);
                } else {
                    m2097b(context);
                }
                u = m2088u();
            }
            return u.length == 0 ? Integer.toString(5) : m2091a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m2087t() {
        this.kb.reset();
    }

    private byte[] m2088u() throws IOException {
        return this.kb.m1087z();
    }

    public String m2089a(Context context) {
        return m2086a(context, null, false);
    }

    public String m2090a(Context context, String str) {
        return m2086a(context, str, true);
    }

    String m2091a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m2087t();
            m2093a(20, 1);
            bArr = m2088u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        new C0339f().m742a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m2096a(str, bArr3);
        }
        return this.ka.m1083a(bArr3, true);
    }

    public void m2092a(int i, int i2, int i3) {
        if (this.jY != null) {
            this.jY.recycle();
        }
        this.jY = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jZ.density, ((float) i2) * this.jZ.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m2093a(int i, long j) throws IOException {
        this.kb.m1085b(i, j);
    }

    protected void m2094a(int i, String str) throws IOException {
        this.kb.m1086b(i, str);
    }

    public void m2095a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jY != null) {
                this.jY.recycle();
            }
            this.jY = MotionEvent.obtain(motionEvent);
        }
    }

    void m2096a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new jx(str.getBytes("UTF-8")).m1020m(bArr);
    }

    protected abstract void m2097b(Context context);

    protected abstract void m2098c(Context context);
}
