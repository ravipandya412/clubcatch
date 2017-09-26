package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends aj {
    private static final String ID;
    private static final String Wc;
    private static final String Wd;
    private static final String We;
    private static final String Wf;

    static {
        ID = C0270a.REGEX_GROUP.toString();
        Wc = C0273b.ARG0.toString();
        Wd = C0273b.ARG1.toString();
        We = C0273b.IGNORE_CASE.toString();
        Wf = C0273b.GROUP.toString();
    }

    public ch() {
        super(ID, Wc, Wd);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2294u(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(Wc);
        C0945a c0945a2 = (C0945a) map.get(Wd);
        if (c0945a == null || c0945a == di.ku() || c0945a2 == null || c0945a2 == di.ku()) {
            return di.ku();
        }
        int i = 64;
        if (di.m1355n((C0945a) map.get(We)).booleanValue()) {
            i = 66;
        }
        C0945a c0945a3 = (C0945a) map.get(Wf);
        int intValue;
        if (c0945a3 != null) {
            Long l = di.m1351l(c0945a3);
            if (l == di.kp()) {
                return di.ku();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return di.ku();
            }
        }
        intValue = 1;
        try {
            CharSequence j = di.m1349j(c0945a);
            Object obj = null;
            Matcher matcher = Pattern.compile(di.m1349j(c0945a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? di.ku() : di.m1360r(obj);
        } catch (PatternSyntaxException e) {
            return di.ku();
        }
    }
}
