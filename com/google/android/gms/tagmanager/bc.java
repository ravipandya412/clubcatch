package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID;

    static {
        ID = C0270a.LANGUAGE.toString();
    }

    public bc() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2262u(Map<String, C0945a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return di.ku();
        }
        String language = locale.getLanguage();
        return language == null ? di.ku() : di.m1360r(language.toLowerCase());
    }
}
