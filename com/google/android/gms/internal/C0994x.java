package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.af.C0633a;

/* renamed from: com.google.android.gms.internal.x */
public final class C0994x extends C0633a {
    private final AdListener lc;

    public C0994x(AdListener adListener) {
        this.lc = adListener;
    }

    public void onAdClosed() {
        this.lc.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.lc.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.lc.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.lc.onAdLoaded();
    }

    public void onAdOpened() {
        this.lc.onAdOpened();
    }
}
