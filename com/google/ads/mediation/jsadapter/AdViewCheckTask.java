package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.da;

public final class AdViewCheckTask implements Runnable {
    public static final int BACKGROUND_COLOR = 0;
    private final JavascriptAdapter f15r;
    private final Handler f16s;
    private final long f17t;
    private long f18u;

    /* renamed from: com.google.ads.mediation.jsadapter.AdViewCheckTask.a */
    private final class C0142a extends AsyncTask<Void, Void, Boolean> {
        private final int f10v;
        private final int f11w;
        private final WebView f12x;
        private Bitmap f13y;
        final /* synthetic */ AdViewCheckTask f14z;

        public C0142a(AdViewCheckTask adViewCheckTask, int i, int i2, WebView webView) {
            this.f14z = adViewCheckTask;
            this.f10v = i2;
            this.f11w = i;
            this.f12x = webView;
        }

        protected synchronized Boolean m10a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f13y.getWidth();
            int height = this.f13y.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f13y.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m11a(Boolean bool) {
            AdViewCheckTask.m12a(this.f14z);
            if (bool.booleanValue()) {
                this.f14z.f15r.sendAdReceivedUpdate();
            } else if (this.f14z.f18u > 0) {
                if (da.m565n(2)) {
                    da.m566s("Ad not detected, scheduling another run.");
                }
                this.f14z.f16s.postDelayed(this.f14z, this.f14z.f17t);
            } else {
                da.m566s("Ad not detected, Not scheduling anymore runs.");
                this.f14z.f15r.sendAdNotReceivedUpdate();
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return m10a((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            m11a((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.f13y = Bitmap.createBitmap(this.f11w, this.f10v, Config.ARGB_8888);
            this.f12x.setVisibility(0);
            this.f12x.measure(MeasureSpec.makeMeasureSpec(this.f11w, 0), MeasureSpec.makeMeasureSpec(this.f10v, 0));
            this.f12x.layout(0, 0, this.f11w, this.f10v);
            this.f12x.draw(new Canvas(this.f13y));
            this.f12x.invalidate();
        }
    }

    public AdViewCheckTask(JavascriptAdapter adapter, long checkIntervalInMillis, long numIterations) {
        this.f15r = adapter;
        this.f17t = checkIntervalInMillis;
        this.f18u = numIterations;
        this.f16s = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ long m12a(AdViewCheckTask adViewCheckTask) {
        long j = adViewCheckTask.f18u - 1;
        adViewCheckTask.f18u = j;
        return j;
    }

    public void run() {
        if (this.f15r != null && !this.f15r.shouldStopAdCheck()) {
            new C0142a(this, this.f15r.getWebViewWidth(), this.f15r.getWebViewHeight(), this.f15r.getWebView()).execute(new Void[0]);
        }
    }

    public void start() {
        this.f16s.postDelayed(this, this.f17t);
    }
}
