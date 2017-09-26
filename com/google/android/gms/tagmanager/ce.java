package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ce {
    private static ce VS;
    private volatile String TM;
    private volatile C0436a VT;
    private volatile String VU;
    private volatile String VV;

    /* renamed from: com.google.android.gms.tagmanager.ce.a */
    enum C0436a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    ce() {
        clear();
    }

    private String bt(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String m1288g(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    static ce ju() {
        ce ceVar;
        synchronized (ce.class) {
            if (VS == null) {
                VS = new ce();
            }
            ceVar = VS;
        }
        return ceVar;
    }

    void clear() {
        this.VT = C0436a.NONE;
        this.VU = null;
        this.TM = null;
        this.VV = null;
    }

    synchronized boolean m1289f(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    bh.m1272v("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.VT = C0436a.CONTAINER_DEBUG;
                    } else {
                        this.VT = C0436a.CONTAINER;
                    }
                    this.VV = m1288g(uri);
                    if (this.VT == C0436a.CONTAINER || this.VT == C0436a.CONTAINER_DEBUG) {
                        this.VU = "/r?" + this.VV;
                    }
                    this.TM = bt(this.VV);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        bh.m1273w("Invalid preview uri: " + decode);
                        z = false;
                    } else if (bt(uri.getQuery()).equals(this.TM)) {
                        bh.m1272v("Exit preview mode for container: " + this.TM);
                        this.VT = C0436a.NONE;
                        this.VU = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    String getContainerId() {
        return this.TM;
    }

    C0436a jv() {
        return this.VT;
    }

    String jw() {
        return this.VU;
    }
}
