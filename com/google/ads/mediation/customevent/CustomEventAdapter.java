package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.da;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f73m;
    private CustomEventBanner f74n;
    private CustomEventInterstitial f75o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0883a implements CustomEventBannerListener {
        private final MediationBannerListener f68k;
        private final CustomEventAdapter f69p;

        public C0883a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f69p = customEventAdapter;
            this.f68k = mediationBannerListener;
        }

        public void onClick() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f68k.onClick(this.f69p);
        }

        public void onDismissScreen() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f68k.onDismissScreen(this.f69p);
        }

        public void onFailedToReceiveAd() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f68k.onFailedToReceiveAd(this.f69p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f68k.onLeaveApplication(this.f69p);
        }

        public void onPresentScreen() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f68k.onPresentScreen(this.f69p);
        }

        public void onReceivedAd(View view) {
            da.m566s("Custom event adapter called onReceivedAd.");
            this.f69p.m2373a(view);
            this.f68k.onReceivedAd(this.f69p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0884b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f70l;
        private final CustomEventAdapter f71p;
        final /* synthetic */ CustomEventAdapter f72q;

        public C0884b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f72q = customEventAdapter;
            this.f71p = customEventAdapter2;
            this.f70l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            da.m566s("Custom event adapter called onDismissScreen.");
            this.f70l.onDismissScreen(this.f71p);
        }

        public void onFailedToReceiveAd() {
            da.m566s("Custom event adapter called onFailedToReceiveAd.");
            this.f70l.onFailedToReceiveAd(this.f71p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            da.m566s("Custom event adapter called onLeaveApplication.");
            this.f70l.onLeaveApplication(this.f71p);
        }

        public void onPresentScreen() {
            da.m566s("Custom event adapter called onPresentScreen.");
            this.f70l.onPresentScreen(this.f71p);
        }

        public void onReceivedAd() {
            da.m566s("Custom event adapter called onReceivedAd.");
            this.f70l.onReceivedAd(this.f72q);
        }
    }

    private static <T> T m2372a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            da.m570w("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m2373a(View view) {
        this.f73m = view;
    }

    public void destroy() {
        if (this.f74n != null) {
            this.f74n.destroy();
        }
        if (this.f75o != null) {
            this.f75o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f73m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f74n = (CustomEventBanner) m2372a(serverParameters.className);
        if (this.f74n == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f74n.requestBannerAd(new C0883a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f75o = (CustomEventInterstitial) m2372a(serverParameters.className);
        if (this.f75o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f75o.requestInterstitialAd(new C0884b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f75o.showInterstitial();
    }
}
