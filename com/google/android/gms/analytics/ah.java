package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class ah implements C0166n {
    private final Context mContext;
    private GoogleAnalytics rA;
    private final String ul;
    private final HttpClient um;
    private URL un;

    ah(HttpClient httpClient, Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }

    ah(HttpClient httpClient, GoogleAnalytics googleAnalytics, Context context) {
        this.mContext = context.getApplicationContext();
        this.ul = m1428a("GoogleAnalytics", "3.0", VERSION.RELEASE, ak.m60a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.um = httpClient;
        this.rA = googleAnalytics;
    }

    private void m1423a(ab abVar, URL url, boolean z) {
        if (!TextUtils.isEmpty(abVar.cn())) {
            URL url2;
            if (url == null) {
                try {
                    url2 = this.un != null ? this.un : new URL("https://ssl.google-analytics.com/collect");
                } catch (MalformedURLException e) {
                    return;
                }
            }
            url2 = url;
            HttpHost httpHost = new HttpHost(url2.getHost(), url2.getPort(), url2.getProtocol());
            try {
                HttpEntityEnclosingRequest c = m1425c(abVar.cn(), url2.getPath());
                if (c != null) {
                    c.addHeader("Host", httpHost.toHostString());
                    if (aa.cm()) {
                        m1424a(c);
                    }
                    if (z) {
                        C0169q.m82p(this.mContext);
                    }
                    HttpResponse execute = this.um.execute(httpHost, c);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        aa.m51w("Bad response: " + execute.getStatusLine().getStatusCode());
                    }
                }
            } catch (ClientProtocolException e2) {
                aa.m51w("ClientProtocolException sending monitoring hit.");
            } catch (IOException e3) {
                aa.m51w("Exception sending monitoring hit: " + e3.getClass().getSimpleName());
                aa.m51w(e3.getMessage());
            }
        }
    }

    private void m1424a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                aa.m50v("Error Writing hit to log...");
            }
        }
        aa.m50v(stringBuffer.toString());
    }

    private HttpEntityEnclosingRequest m1425c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            aa.m51w("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                aa.m51w("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.ul);
        return basicHttpEntityEnclosingRequest;
    }

    public void m1426A(String str) {
        try {
            this.un = new URL(str);
        } catch (MalformedURLException e) {
            this.un = null;
        }
    }

    public int m1427a(List<C0184x> list, ab abVar, boolean z) {
        int i = 0;
        int min = Math.min(list.size(), 40);
        abVar.m52c("_hr", list.size());
        int i2 = 0;
        URL url = null;
        boolean z2 = true;
        int i3 = 0;
        while (i3 < min) {
            int i4;
            URL url2;
            C0184x c0184x = (C0184x) list.get(i3);
            URL a = m1429a(c0184x);
            c0184x.ch().contains("_t=flow");
            if (a == null) {
                if (aa.cm()) {
                    aa.m51w("No destination: discarding hit: " + c0184x.ch());
                } else {
                    aa.m51w("No destination: discarding hit.");
                }
                i2++;
                URL url3 = url;
                i4 = i + 1;
                url2 = url3;
            } else {
                HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                String path = a.getPath();
                String a2 = TextUtils.isEmpty(c0184x.ch()) ? "" : C0185y.m88a(c0184x, System.currentTimeMillis());
                HttpEntityEnclosingRequest c = m1425c(a2, path);
                if (c == null) {
                    i2++;
                    i4 = i + 1;
                    url2 = a;
                } else {
                    c.addHeader("Host", httpHost.toHostString());
                    if (aa.cm()) {
                        m1424a(c);
                    }
                    if (a2.length() > AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD) {
                        aa.m51w("Hit too long (> 8192 bytes)--not sent");
                        i2++;
                    } else if (this.rA.isDryRunEnabled()) {
                        aa.m49u("Dry run enabled. Hit not actually sent.");
                    } else {
                        if (z2) {
                            try {
                                C0169q.m82p(this.mContext);
                                z2 = false;
                            } catch (ClientProtocolException e) {
                                aa.m51w("ClientProtocolException sending hit; discarding hit...");
                                abVar.m52c("_hd", i2);
                            } catch (IOException e2) {
                                aa.m51w("Exception sending hit: " + e2.getClass().getSimpleName());
                                aa.m51w(e2.getMessage());
                                abVar.m52c("_de", 1);
                                abVar.m52c("_hd", i2);
                                abVar.m52c("_hs", i);
                                m1423a(abVar, a, z2);
                                return i;
                            }
                        }
                        HttpResponse execute = this.um.execute(httpHost, c);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        if (statusCode != 200) {
                            aa.m51w("Bad response: " + execute.getStatusLine().getStatusCode());
                        }
                    }
                    abVar.m52c("_td", a2.getBytes().length);
                    i4 = i + 1;
                    url2 = a;
                }
            }
            i3++;
            i = i4;
            url = url2;
        }
        abVar.m52c("_hd", i2);
        abVar.m52c("_hs", i);
        if (z) {
            m1423a(abVar, url, z2);
        }
        return i;
    }

    String m1428a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL m1429a(C0184x c0184x) {
        if (this.un != null) {
            return this.un;
        }
        try {
            return new URL("http:".equals(c0184x.ck()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            aa.m48t("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    public boolean bA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        aa.m50v("...no network connectivity");
        return false;
    }
}
