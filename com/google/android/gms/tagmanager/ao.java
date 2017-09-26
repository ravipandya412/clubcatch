package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID;
    private static final String US;
    private static final String UU;
    private static final String UY;

    static {
        ID = C0270a.HASH.toString();
        US = C0273b.ARG0.toString();
        UY = C0273b.ALGORITHM.toString();
        UU = C0273b.INPUT_FORMAT.toString();
    }

    public ao() {
        super(ID, US);
    }

    private byte[] m2242c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2243u(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(US);
        if (c0945a == null || c0945a == di.ku()) {
            return di.ku();
        }
        byte[] bytes;
        String j = di.m1349j(c0945a);
        c0945a = (C0945a) map.get(UY);
        String j2 = c0945a == null ? "MD5" : di.m1349j(c0945a);
        c0945a = (C0945a) map.get(UU);
        String j3 = c0945a == null ? "text" : di.m1349j(c0945a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0457j.aX(j);
        } else {
            bh.m1270t("Hash: unknown input format: " + j3);
            return di.ku();
        }
        try {
            return di.m1360r(C0457j.m1368d(m2242c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m1270t("Hash: unknown algorithm: " + j2);
            return di.ku();
        }
    }
}
