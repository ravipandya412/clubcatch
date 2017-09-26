package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C0183u.C0182a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean tB;
    private static GoogleAnalytics tI;
    private Context mContext;
    private String qR;
    private String qS;
    private C0159f rk;
    private boolean tC;
    private af tD;
    private volatile Boolean tE;
    private Logger tF;
    private Set<C0148a> tG;
    private boolean tH;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.a */
    interface C0148a {
        void m42f(Activity activity);

        void m43g(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.b */
    class C0149b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics tJ;

        C0149b(GoogleAnalytics googleAnalytics) {
            this.tJ = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.tJ.m1398d(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.tJ.m1399e(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0581t.m1487q(context), C0578r.bB());
    }

    private GoogleAnalytics(Context context, C0159f thread, af serviceManager) {
        this.tE = Boolean.valueOf(false);
        this.tH = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.rk = thread;
        this.tD = serviceManager;
        C0574g.m1443n(this.mContext);
        ae.m1421n(this.mContext);
        C0575h.m1448n(this.mContext);
        this.tF = new C0576l();
        this.tG = new HashSet();
        cg();
    }

    private int m1394D(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    private Tracker m1395a(Tracker tracker) {
        if (this.qR != null) {
            tracker.set("&an", this.qR);
        }
        if (this.qS != null) {
            tracker.set("&av", this.qS);
        }
        return tracker;
    }

    static GoogleAnalytics cf() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = tI;
        }
        return googleAnalytics;
    }

    private void cg() {
        if (!tB) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                aa.m50v("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.m51w("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C0584w c0584w = (C0584w) new C0583v(this.mContext).m75p(i);
                    if (c0584w != null) {
                        m1401a(c0584w);
                    }
                }
            }
        }
    }

    private void m1398d(Activity activity) {
        for (C0148a f : this.tG) {
            f.m42f(activity);
        }
    }

    private void m1399e(Activity activity) {
        for (C0148a g : this.tG) {
            g.m43g(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (tI == null) {
                tI = new GoogleAnalytics(context);
            }
            googleAnalytics = tI;
        }
        return googleAnalytics;
    }

    void m1400a(C0148a c0148a) {
        this.tG.add(c0148a);
    }

    void m1401a(C0584w c0584w) {
        aa.m50v("Loading global config values.");
        if (c0584w.bV()) {
            this.qR = c0584w.bW();
            aa.m50v("app name loaded: " + this.qR);
        }
        if (c0584w.bX()) {
            this.qS = c0584w.bY();
            aa.m50v("app version loaded: " + this.qS);
        }
        if (c0584w.bZ()) {
            int D = m1394D(c0584w.ca());
            if (D >= 0) {
                aa.m50v("log level loaded: " + D);
                getLogger().setLogLevel(D);
            }
        }
        if (c0584w.cb()) {
            this.tD.setLocalDispatchPeriod(c0584w.cc());
        }
        if (c0584w.cd()) {
            setDryRun(c0584w.ce());
        }
    }

    void m1402b(C0148a c0148a) {
        this.tG.remove(c0148a);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.tD.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.tH) {
            application.registerActivityLifecycleCallbacks(new C0149b(this));
            this.tH = true;
        }
    }

    public boolean getAppOptOut() {
        C0183u.bR().m84a(C0182a.GET_APP_OPT_OUT);
        return this.tE.booleanValue();
    }

    public Logger getLogger() {
        return this.tF;
    }

    public boolean isDryRunEnabled() {
        C0183u.bR().m84a(C0182a.GET_DRY_RUN);
        return this.tC;
    }

    void m1403n(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.m61a(map, "&ul", ak.m60a(Locale.getDefault()));
            ak.m61a(map, "&sr", ae.cs().getValue("&sr"));
            map.put("&_u", C0183u.bR().bT());
            C0183u.bR().bS();
            this.rk.m69n(map);
        }
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0183u.bR().m84a(C0182a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).m75p(configResId);
                if (ajVar != null) {
                    tracker.m46a(this.mContext, ajVar);
                }
            }
            a = m1395a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0183u.bR().m84a(C0182a.GET_TRACKER);
            a = m1395a(new Tracker(trackingId, this));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.tH) {
            m1398d(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.tH) {
            m1399e(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0183u.bR().m84a(C0182a.SET_APP_OPT_OUT);
        this.tE = Boolean.valueOf(optOut);
        if (this.tE.booleanValue()) {
            this.rk.bk();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0183u.bR().m84a(C0182a.SET_DRY_RUN);
        this.tC = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.tD.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0183u.bR().m84a(C0182a.SET_LOGGER);
        this.tF = logger;
    }
}
