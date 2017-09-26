package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.q */
class C0733q implements C0358o {
    private jz kv;
    private byte[] kw;
    private final int kx;

    public C0733q(int i) {
        this.kx = i;
        reset();
    }

    public void m2116b(int i, long j) throws IOException {
        this.kv.m1049b(i, j);
    }

    public void m2117b(int i, String str) throws IOException {
        this.kv.m1050b(i, str);
    }

    public void reset() {
        this.kw = new byte[this.kx];
        this.kv = jz.m1041o(this.kw);
    }

    public byte[] m2118z() throws IOException {
        int kM = this.kv.kM();
        if (kM < 0) {
            throw new IOException();
        } else if (kM == 0) {
            return this.kw;
        } else {
            Object obj = new byte[(this.kw.length - kM)];
            System.arraycopy(this.kw, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
