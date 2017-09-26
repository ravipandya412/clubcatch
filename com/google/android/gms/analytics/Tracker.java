package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0183u.C0182a;
import com.google.android.gms.analytics.GoogleAnalytics.C0148a;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tracker {
    private final TrackerHandler up;
    private final Map<String, String> uq;
    private ad ur;
    private final C0575h us;
    private final ae ut;
    private final C0574g uu;
    private boolean uv;
    private C0569a uw;
    private aj ux;

    /* renamed from: com.google.android.gms.analytics.Tracker.a */
    private class C0569a implements C0148a {
        private C0161i rJ;
        private boolean uA;
        private boolean uB;
        private int uC;
        private long uD;
        private boolean uE;
        private long uF;
        final /* synthetic */ Tracker uG;
        private Timer uy;
        private TimerTask uz;

        /* renamed from: com.google.android.gms.analytics.Tracker.a.a */
        private class C0151a extends TimerTask {
            final /* synthetic */ C0569a uI;

            private C0151a(C0569a c0569a) {
                this.uI = c0569a;
            }

            public void run() {
                this.uI.uA = false;
            }
        }

        /* renamed from: com.google.android.gms.analytics.Tracker.a.1 */
        class C05681 implements C0161i {
            final /* synthetic */ Tracker uH;
            final /* synthetic */ C0569a uI;

            C05681(C0569a c0569a, Tracker tracker) {
                this.uI = c0569a;
                this.uH = tracker;
            }

            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        }

        public C0569a(Tracker tracker) {
            this.uG = tracker;
            this.uA = false;
            this.uB = false;
            this.uC = 0;
            this.uD = -1;
            this.uE = false;
            this.rJ = new C05681(this, tracker);
        }

        private void cx() {
            GoogleAnalytics cf = GoogleAnalytics.cf();
            if (cf == null) {
                aa.m48t("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.uD >= 0 || this.uB) {
                cf.m1400a(this.uG.uw);
            } else {
                cf.m1402b(this.uG.uw);
            }
        }

        private synchronized void cy() {
            if (this.uy != null) {
                this.uy.cancel();
                this.uy = null;
            }
        }

        public long cu() {
            return this.uD;
        }

        public boolean cv() {
            return this.uB;
        }

        public boolean cw() {
            boolean z = this.uE;
            this.uE = false;
            return z;
        }

        boolean cz() {
            return this.uD == 0 || (this.uD > 0 && this.rJ.currentTimeMillis() > this.uF + this.uD);
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.uB = enabled;
            cx();
        }

        public void m1405f(Activity activity) {
            C0183u.bR().m84a(C0182a.EASY_TRACKER_ACTIVITY_START);
            cy();
            if (!this.uA && this.uC == 0 && cz()) {
                this.uE = true;
            }
            this.uA = true;
            this.uC++;
            if (this.uB) {
                Map hashMap = new HashMap();
                hashMap.put("&t", "appview");
                C0183u.bR().m85r(true);
                this.uG.set("&cd", this.uG.ux != null ? this.uG.ux.m1435h(activity) : activity.getClass().getCanonicalName());
                this.uG.send(hashMap);
                C0183u.bR().m85r(false);
            }
        }

        public void m1406g(Activity activity) {
            C0183u.bR().m84a(C0182a.EASY_TRACKER_ACTIVITY_STOP);
            this.uC--;
            this.uC = Math.max(0, this.uC);
            this.uF = this.rJ.currentTimeMillis();
            if (this.uC == 0) {
                cy();
                this.uz = new C0151a();
                this.uy = new Timer("waitForActivityStart");
                this.uy.schedule(this.uz, 1000);
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.uD = sessionTimeout;
            cx();
        }
    }

    Tracker(String trackingId, TrackerHandler handler) {
        this(trackingId, handler, C0575h.bu(), ae.cs(), C0574g.bt(), new C0585z("tracking"));
    }

    Tracker(String trackingId, TrackerHandler handler, C0575h clientIdDefaultProvider, ae screenResolutionDefaultProvider, C0574g appFieldsDefaultProvider, ad rateLimiter) {
        this.uq = new HashMap();
        this.up = handler;
        if (trackingId != null) {
            this.uq.put("&tid", trackingId);
        }
        this.uq.put("useSecure", "1");
        this.us = clientIdDefaultProvider;
        this.ut = screenResolutionDefaultProvider;
        this.uu = appFieldsDefaultProvider;
        this.ur = rateLimiter;
        this.uw = new C0569a(this);
    }

    void m46a(Context context, aj ajVar) {
        aa.m50v("Loading Tracker config values.");
        this.ux = ajVar;
        if (this.ux.cB()) {
            String cC = this.ux.cC();
            set("&tid", cC);
            aa.m50v("[Tracker] trackingId loaded: " + cC);
        }
        if (this.ux.cD()) {
            cC = Double.toString(this.ux.cE());
            set("&sf", cC);
            aa.m50v("[Tracker] sample frequency loaded: " + cC);
        }
        if (this.ux.cF()) {
            setSessionTimeout((long) this.ux.getSessionTimeout());
            aa.m50v("[Tracker] session timeout loaded: " + cu());
        }
        if (this.ux.cG()) {
            enableAutoActivityTracking(this.ux.cH());
            aa.m50v("[Tracker] auto activity tracking loaded: " + cv());
        }
        if (this.ux.cI()) {
            if (this.ux.cJ()) {
                set("&aip", "1");
                aa.m50v("[Tracker] anonymize ip loaded: true");
            }
            aa.m50v("[Tracker] anonymize ip loaded: false");
        }
        this.uv = this.ux.cK();
        if (this.ux.cK()) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context));
            aa.m50v("[Tracker] report uncaught exceptions loaded: " + this.uv);
        }
    }

    long cu() {
        return this.uw.cu();
    }

    boolean cv() {
        return this.uw.cv();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.uq.containsKey("&ate")) {
                this.uq.remove("&ate");
            }
            if (this.uq.containsKey("&adid")) {
                this.uq.remove("&adid");
                return;
            }
            return;
        }
        this.uq.put("&ate", null);
        this.uq.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.uw.enableAutoActivityTracking(enabled);
    }

    public String get(String key) {
        C0183u.bR().m84a(C0182a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.uq.containsKey(key)) {
            return (String) this.uq.get(key);
        }
        if (key.equals("&ul")) {
            return ak.m60a(Locale.getDefault());
        }
        if (this.us != null && this.us.m1450x(key)) {
            return this.us.getValue(key);
        }
        if (this.ut == null || !this.ut.m1422x(key)) {
            return (this.uu == null || !this.uu.m1444x(key)) ? null : this.uu.getValue(key);
        } else {
            return this.ut.getValue(key);
        }
    }

    public void send(Map<String, String> params) {
        C0183u.bR().m84a(C0182a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.uq);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            aa.m51w(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            aa.m51w(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.uw.cw()) {
            hashMap.put("&sc", "start");
        }
        if (str.equals("transaction") || str.equals("item") || this.ur.cl()) {
            this.up.m47n(hashMap);
        } else {
            aa.m51w("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        er.m723b((Object) key, (Object) "Key should be non-null");
        C0183u.bR().m84a(C0182a.SET);
        this.uq.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", ak.m63s(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            aa.m51w("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.uw.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", ak.m63s(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
