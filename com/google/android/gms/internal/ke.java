package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ke {
    protected int DY;

    public ke() {
        this.DY = -1;
    }

    public static final <T extends ke> T m1064a(T t, byte[] bArr) throws kd {
        return m1066b(t, bArr, 0, bArr.length);
    }

    public static final void m1065a(ke keVar, byte[] bArr, int i, int i2) {
        try {
            jz b = jz.m1034b(bArr, i, i2);
            keVar.m1068a(b);
            b.kN();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends ke> T m1066b(T t, byte[] bArr, int i, int i2) throws kd {
        try {
            jy a = jy.m1021a(bArr, i, i2);
            t.m1069b(a);
            a.cu(0);
            return t;
        } catch (kd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] m1067d(ke keVar) {
        byte[] bArr = new byte[keVar.m1070c()];
        m1065a(keVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void m1068a(jz jzVar) throws IOException {
    }

    public abstract ke m1069b(jy jyVar) throws IOException;

    public int m1070c() {
        this.DY = 0;
        return 0;
    }

    public int eW() {
        if (this.DY < 0) {
            m1070c();
        }
        return this.DY;
    }

    public String toString() {
        return kf.m1073e(this);
    }
}
