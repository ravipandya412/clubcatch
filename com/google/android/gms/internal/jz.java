package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class jz {
    private final int aad;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.jz.a */
    public static class C0353a extends IOException {
        C0353a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private jz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.aad = i + i2;
    }

    public static int m1027A(long j) {
        return m1029C(m1030D(j));
    }

    public static int m1028B(boolean z) {
        return 1;
    }

    public static int m1029C(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m1030D(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int m1031b(int i, float f) {
        return cE(i) + m1037e(f);
    }

    public static int m1032b(int i, ke keVar) {
        return cE(i) + m1035c(keVar);
    }

    public static int m1033b(int i, boolean z) {
        return cE(i) + m1028B(z);
    }

    public static jz m1034b(byte[] bArr, int i, int i2) {
        return new jz(bArr, i, i2);
    }

    public static int bQ(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + cG(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m1035c(ke keVar) {
        int c = keVar.m1070c();
        return c + cG(c);
    }

    public static int cC(int i) {
        return i >= 0 ? cG(i) : 10;
    }

    public static int cE(int i) {
        return cG(kh.m1076i(i, 0));
    }

    public static int cG(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m1036d(int i, long j) {
        return cE(i) + m1042z(j);
    }

    public static int m1037e(float f) {
        return 4;
    }

    public static int m1038e(int i, long j) {
        return cE(i) + m1027A(j);
    }

    public static int m1039g(int i, int i2) {
        return cE(i) + cC(i2);
    }

    public static int m1040g(int i, String str) {
        return cE(i) + bQ(str);
    }

    public static jz m1041o(byte[] bArr) {
        return m1034b(bArr, 0, bArr.length);
    }

    public static int m1042z(long j) {
        return m1029C(j);
    }

    public void m1043A(boolean z) throws IOException {
        cD(z ? 1 : 0);
    }

    public void m1044B(long j) throws IOException {
        while ((-128 & j) != 0) {
            cD((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            j >>>= 7;
        }
        cD((int) j);
    }

    public void m1045a(int i, float f) throws IOException {
        m1056h(i, 5);
        m1054d(f);
    }

    public void m1046a(int i, ke keVar) throws IOException {
        m1056h(i, 2);
        m1051b(keVar);
    }

    public void m1047a(int i, boolean z) throws IOException {
        m1056h(i, 0);
        m1043A(z);
    }

    public void m1048b(byte b) throws IOException {
        if (this.position == this.aad) {
            throw new C0353a(this.position, this.aad);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void m1049b(int i, long j) throws IOException {
        m1056h(i, 0);
        m1058x(j);
    }

    public void m1050b(int i, String str) throws IOException {
        m1056h(i, 2);
        bP(str);
    }

    public void m1051b(ke keVar) throws IOException {
        cF(keVar.eW());
        keVar.m1068a(this);
    }

    public void bP(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        cF(bytes.length);
        m1057p(bytes);
    }

    public void m1052c(int i, long j) throws IOException {
        m1056h(i, 0);
        m1059y(j);
    }

    public void m1053c(byte[] bArr, int i, int i2) throws IOException {
        if (this.aad - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C0353a(this.position, this.aad);
    }

    public void cB(int i) throws IOException {
        if (i >= 0) {
            cF(i);
        } else {
            m1044B((long) i);
        }
    }

    public void cD(int i) throws IOException {
        m1048b((byte) i);
    }

    public void cF(int i) throws IOException {
        while ((i & -128) != 0) {
            cD((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | TransportMediator.FLAG_KEY_MEDIA_NEXT);
            i >>>= 7;
        }
        cD(i);
    }

    public void cH(int i) throws IOException {
        cD(i & MotionEventCompat.ACTION_MASK);
        cD((i >> 8) & MotionEventCompat.ACTION_MASK);
        cD((i >> 16) & MotionEventCompat.ACTION_MASK);
        cD((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public void m1054d(float f) throws IOException {
        cH(Float.floatToIntBits(f));
    }

    public void m1055f(int i, int i2) throws IOException {
        m1056h(i, 0);
        cB(i2);
    }

    public void m1056h(int i, int i2) throws IOException {
        cF(kh.m1076i(i, i2));
    }

    public int kM() {
        return this.aad - this.position;
    }

    public void kN() {
        if (kM() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m1057p(byte[] bArr) throws IOException {
        m1053c(bArr, 0, bArr.length);
    }

    public void m1058x(long j) throws IOException {
        m1044B(j);
    }

    public void m1059y(long j) throws IOException {
        m1044B(m1030D(j));
    }
}
