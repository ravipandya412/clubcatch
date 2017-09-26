package com.google.ads.mediation.jsadapter;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.da;
import java.net.URI;
import java.net.URISyntaxException;

public final class BannerWebViewClient extends WebViewClient {
    private final String f19A;
    private boolean f20B;
    private final JavascriptAdapter f21r;

    public BannerWebViewClient(JavascriptAdapter adapter, String passbackUrl) {
        this.f19A = m18c(passbackUrl);
        this.f21r = adapter;
        this.f20B = false;
    }

    private boolean m17b(String str) {
        Object c = m18c(str);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        try {
            URI uri = new URI(c);
            if ("passback".equals(uri.getScheme())) {
                da.m566s("Passback received");
                this.f21r.sendAdNotReceivedUpdate();
                return true;
            } else if (TextUtils.isEmpty(this.f19A)) {
                return false;
            } else {
                URI uri2 = new URI(this.f19A);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!equals(host, host2) || !equals(path, path2)) {
                    return false;
                }
                da.m566s("Passback received");
                this.f21r.sendAdNotReceivedUpdate();
                return true;
            }
        } catch (URISyntaxException e) {
            da.m567t(e.getMessage());
            return false;
        }
    }

    private String m18c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                da.m567t(e.getMessage());
            }
        }
        return str;
    }

    private static boolean equals(Object obj1, Object obj2) {
        return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
    }

    public void onLoadResource(WebView view, String url) {
        da.m569v("onLoadResource: " + url);
        if (!m17b(url)) {
            super.onLoadResource(view, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        da.m569v("onPageFinished: " + url);
        super.onPageFinished(view, url);
        if (!this.f20B) {
            this.f21r.startCheckingForAd();
            this.f20B = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        da.m569v("shouldOverrideUrlLoading: " + url);
        if (!m17b(url)) {
            return false;
        }
        da.m566s("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
