package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class db implements ab {
    private final Context Xf;
    private final String Xw;
    private final HttpClient Xx;
    private C0455a Xy;

    /* renamed from: com.google.android.gms.tagmanager.db.a */
    public interface C0455a {
        void m1343a(ap apVar);

        void m1344b(ap apVar);

        void m1345c(ap apVar);
    }

    db(HttpClient httpClient, Context context, C0455a c0455a) {
        this.Xf = context.getApplicationContext();
        this.Xw = m2317a("GoogleTagManager", "3.02b1", VERSION.RELEASE, m2316b(Locale.getDefault()), Build.MODEL, Build.ID);
        this.Xx = httpClient;
        this.Xy = c0455a;
    }

    private HttpEntityEnclosingRequest m2314a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.Xw);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.m1273w("Exception sending hit: " + e.getClass().getSimpleName());
                bh.m1273w(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.m1273w("Exception sending hit: " + e.getClass().getSimpleName());
            bh.m1273w(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void m2315a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
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
                bh.m1272v("Error Writing hit to log...");
            }
        }
        bh.m1272v(stringBuffer.toString());
    }

    static String m2316b(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String m2317a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public boolean bA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.Xf.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1272v("...no network connectivity");
        return false;
    }

    URL m2318d(ap apVar) {
        try {
            return new URL(apVar.jf());
        } catch (MalformedURLException e) {
            bh.m1270t("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void m2319e(List<ap> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ap apVar = (ap) list.get(i);
            URL d = m2318d(apVar);
            if (d == null) {
                bh.m1273w("No destination: discarding hit.");
                this.Xy.m1344b(apVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a = m2314a(d);
                if (a == null) {
                    this.Xy.m1344b(apVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    m2315a(a);
                    if (obj != null) {
                        try {
                            bn.m1281p(this.Xf);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.m1273w("ClientProtocolException sending hit; discarding hit...");
                            this.Xy.m1344b(apVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bh.m1273w("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.m1273w(e2.getMessage());
                            this.Xy.m1345c(apVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.Xx.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bh.m1273w("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.Xy.m1345c(apVar);
                    } else {
                        this.Xy.m1343a(apVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
