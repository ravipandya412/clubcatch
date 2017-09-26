package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class de extends WebViewClient {
    private ap lV;
    private final Object mg;
    protected final dd ng;
    private final HashMap<String, ar> qf;
    private C0364u qg;
    private br qh;
    private C0309a qi;
    private boolean qj;
    private boolean qk;
    private bu ql;

    /* renamed from: com.google.android.gms.internal.de.1 */
    class C03081 implements Runnable {
        final /* synthetic */ bo qm;
        final /* synthetic */ de qn;

        C03081(de deVar, bo boVar) {
            this.qn = deVar;
            this.qm = boVar;
        }

        public void run() {
            this.qm.ar();
        }
    }

    /* renamed from: com.google.android.gms.internal.de.a */
    public interface C0309a {
        void m581a(dd ddVar);
    }

    public de(dd ddVar, boolean z) {
        this.qf = new HashMap();
        this.mg = new Object();
        this.qj = false;
        this.ng = ddVar;
        this.qk = z;
    }

    private void m582a(bq bqVar) {
        bo.m2456a(this.ng.getContext(), bqVar);
    }

    private static boolean m583b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m584c(Uri uri) {
        String path = uri.getPath();
        ar arVar = (ar) this.qf.get(path);
        if (arVar != null) {
            Map hashMap = new HashMap();
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(uri.toString());
            for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
                hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
            }
            if (da.m565n(2)) {
                da.m569v("Received GMSG: " + path);
                for (String str : hashMap.keySet()) {
                    da.m569v("  " + str + ": " + ((String) hashMap.get(str)));
                }
            }
            arVar.m426a(this.ng, hashMap);
            return;
        }
        da.m570w("No GMSG handler found for GMSG: " + uri);
    }

    public final void m585a(bn bnVar) {
        br brVar = null;
        boolean be = this.ng.be();
        C0364u c0364u = (!be || this.ng.m575Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m582a(new bq(bnVar, c0364u, brVar, this.ql, this.ng.bd()));
    }

    public final void m586a(C0309a c0309a) {
        this.qi = c0309a;
    }

    public void m587a(C0364u c0364u, br brVar, ap apVar, bu buVar, boolean z) {
        m588a("/appEvent", new ao(apVar));
        m588a("/canOpenURLs", aq.lW);
        m588a("/click", aq.lX);
        m588a("/close", aq.lY);
        m588a("/customClose", aq.lZ);
        m588a("/httpTrack", aq.ma);
        m588a("/log", aq.mb);
        m588a("/open", aq.mc);
        m588a("/touch", aq.md);
        m588a("/video", aq.me);
        this.qg = c0364u;
        this.qh = brVar;
        this.lV = apVar;
        this.ql = buVar;
        m592o(z);
    }

    public final void m588a(String str, ar arVar) {
        this.qf.put(str, arVar);
    }

    public final void m589a(boolean z, int i) {
        C0364u c0364u = (!this.ng.be() || this.ng.m575Q().lo) ? this.qg : null;
        m582a(new bq(c0364u, this.qh, this.ql, this.ng, z, i, this.ng.bd()));
    }

    public final void m590a(boolean z, int i, String str) {
        br brVar = null;
        boolean be = this.ng.be();
        C0364u c0364u = (!be || this.ng.m575Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m582a(new bq(c0364u, brVar, this.lV, this.ql, this.ng, z, i, str, this.ng.bd()));
    }

    public final void m591a(boolean z, int i, String str, String str2) {
        br brVar = null;
        boolean be = this.ng.be();
        C0364u c0364u = (!be || this.ng.m575Q().lo) ? this.qg : null;
        if (!be) {
            brVar = this.qh;
        }
        m582a(new bq(c0364u, brVar, this.lV, this.ql, this.ng, z, i, str, str2, this.ng.bd()));
    }

    public final void ar() {
        synchronized (this.mg) {
            this.qj = false;
            this.qk = true;
            bo ba = this.ng.ba();
            if (ba != null) {
                if (cz.aX()) {
                    ba.ar();
                } else {
                    cz.pT.post(new C03081(this, ba));
                }
            }
        }
    }

    public boolean bi() {
        boolean z;
        synchronized (this.mg) {
            z = this.qk;
        }
        return z;
    }

    public final void m592o(boolean z) {
        this.qj = z;
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.qi != null) {
            this.qi.m581a(this.ng);
            this.qi = null;
        }
    }

    public final void reset() {
        synchronized (this.mg) {
            this.qf.clear();
            this.qg = null;
            this.qh = null;
            this.qi = null;
            this.lV = null;
            this.qj = false;
            this.qk = false;
            this.ql = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        da.m569v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m584c(parse);
        } else if (this.qj && webView == this.ng && m583b(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.ng.willNotDraw()) {
                da.m570w("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C0355l bc = this.ng.bc();
                    if (bc != null && bc.m1081a(parse)) {
                        parse = bc.m1079a(parse, this.ng.getContext());
                    }
                    uri = parse;
                } catch (C0356m e) {
                    da.m570w("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                m585a(new bn("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
