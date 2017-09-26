package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C0672e implements C0357n {
    C0672e() {
    }

    public String m1761a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m1762a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
