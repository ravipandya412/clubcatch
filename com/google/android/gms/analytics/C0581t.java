package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.internal.di;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C0581t extends Thread implements C0159f {
    private static C0581t sd;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile String qX;
    private final LinkedBlockingQueue<Runnable> rZ;
    private volatile boolean sa;
    private volatile List<di> sb;
    private volatile String sc;
    private volatile ag se;

    /* renamed from: com.google.android.gms.analytics.t.1 */
    class C01781 implements Runnable {
        final /* synthetic */ Map sf;
        final /* synthetic */ C0581t sg;

        C01781(C0581t c0581t, Map map) {
            this.sg = c0581t;
            this.sf = map;
        }

        public void run() {
            if (TextUtils.isEmpty((CharSequence) this.sf.get("&cid"))) {
                this.sf.put("&cid", this.sg.qX);
            }
            if (!GoogleAnalytics.getInstance(this.sg.mContext).getAppOptOut() && !this.sg.m1486p(this.sf)) {
                if (!TextUtils.isEmpty(this.sg.sc)) {
                    C0183u.bR().m85r(true);
                    this.sf.putAll(new HitBuilder().setCampaignParamsFromUrl(this.sg.sc).build());
                    C0183u.bR().m85r(false);
                    this.sg.sc = null;
                }
                this.sg.m1490r(this.sf);
                this.sg.m1488q(this.sf);
                this.sg.se.m56b(C0185y.m89s(this.sf), Long.valueOf((String) this.sf.get("&ht")).longValue(), this.sg.m1485o(this.sf), this.sg.sb);
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.2 */
    class C01792 implements Runnable {
        final /* synthetic */ C0581t sg;

        C01792(C0581t c0581t) {
            this.sg = c0581t;
        }

        public void run() {
            this.sg.se.bp();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.3 */
    class C01803 implements Runnable {
        final /* synthetic */ C0581t sg;

        C01803(C0581t c0581t) {
            this.sg = c0581t;
        }

        public void run() {
            this.sg.se.bk();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.4 */
    class C01814 implements Runnable {
        final /* synthetic */ C0581t sg;

        C01814(C0581t c0581t) {
            this.sg = c0581t;
        }

        public void run() {
            this.sg.se.br();
        }
    }

    private C0581t(Context context) {
        super("GAThread");
        this.rZ = new LinkedBlockingQueue();
        this.sa = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int m1473C(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String m1476a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private String m1485o(Map<String, String> map) {
        return map.containsKey("useSecure") ? ak.m62d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    private boolean m1486p(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.m59a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C0581t.m1473C((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get("&t");
        aa.m50v(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    static C0581t m1487q(Context context) {
        if (sd == null) {
            sd = new C0581t(context);
        }
        return sd;
    }

    private void m1488q(Map<String, String> map) {
        C0165m m = C0570a.m1407m(this.mContext);
        ak.m61a(map, "&adid", m.getValue("&adid"));
        ak.m61a(map, "&ate", m.getValue("&ate"));
    }

    static String m1489r(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD];
            int read = openFileInput.read(bArr, 0, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD);
            if (openFileInput.available() > 0) {
                aa.m48t("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m51w("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m49u("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m49u("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m48t("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private void m1490r(Map<String, String> map) {
        C0165m bt = C0574g.bt();
        ak.m61a(map, "&an", bt.getValue("&an"));
        ak.m61a(map, "&av", bt.getValue("&av"));
        ak.m61a(map, "&aid", bt.getValue("&aid"));
        ak.m61a(map, "&aiid", bt.getValue("&aiid"));
        map.put("&v", "1");
    }

    void m1491a(Runnable runnable) {
        this.rZ.add(runnable);
    }

    public void bk() {
        m1491a(new C01803(this));
    }

    public void bp() {
        m1491a(new C01792(this));
    }

    public void br() {
        m1491a(new C01814(this));
    }

    public LinkedBlockingQueue<Runnable> bs() {
        return this.rZ;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.se.bI();
        this.sb = new ArrayList();
        this.sb.add(new di("appendVersion", "&_v".substring(1), "ma4.0.0"));
        this.sb.add(new di("appendQueueTime", "&qt".substring(1), null));
        this.sb.add(new di("appendCacheBuster", "&z".substring(1), null));
    }

    public void m1492n(Map<String, String> map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1491a(new C01781(this, hashMap));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m51w("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.se == null) {
                this.se = new C0580s(this.mContext, this);
            }
            init();
            this.qX = C0575h.bu().getValue("&cid");
            if (this.qX == null) {
                this.sa = true;
            }
            this.sc = C0581t.m1489r(this.mContext);
            aa.m50v("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m48t("Error initializing the GAThread: " + m1476a(th));
            aa.m48t("Google Analytics will not start up.");
            this.sa = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.rZ.take();
                if (!this.sa) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m49u(e2.toString());
            } catch (Throwable th2) {
                aa.m48t("Error on GAThread: " + m1476a(th2));
                aa.m48t("Google Analytics is shutting down.");
                this.sa = true;
            }
        }
    }
}
