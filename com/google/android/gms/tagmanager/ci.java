package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ci extends dd {
    private static final String ID;
    private static final String We;

    static {
        ID = C0270a.REGEX.toString();
        We = C0273b.IGNORE_CASE.toString();
    }

    public ci() {
        super(ID);
    }

    protected boolean m3106a(String str, String str2, Map<String, C0945a> map) {
        try {
            return Pattern.compile(str2, di.m1355n((C0945a) map.get(We)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
