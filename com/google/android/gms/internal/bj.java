package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class bj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bh mT;

    /* renamed from: com.google.android.gms.internal.bj.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ bj mU;
        final /* synthetic */ ErrorCode mV;

        AnonymousClass10(bj bjVar, ErrorCode errorCode) {
            this.mU = bjVar;
            this.mV = errorCode;
        }

        public void run() {
            try {
                this.mU.mT.onAdFailedToLoad(bk.m444a(this.mV));
            } catch (Throwable e) {
                da.m564b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.1 */
    class C02761 implements Runnable {
        final /* synthetic */ bj mU;

        C02761(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.m443O();
            } catch (Throwable e) {
                da.m564b("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.2 */
    class C02772 implements Runnable {
        final /* synthetic */ bj mU;

        C02772(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdOpened();
            } catch (Throwable e) {
                da.m564b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.3 */
    class C02783 implements Runnable {
        final /* synthetic */ bj mU;

        C02783(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLoaded();
            } catch (Throwable e) {
                da.m564b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.4 */
    class C02794 implements Runnable {
        final /* synthetic */ bj mU;

        C02794(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdClosed();
            } catch (Throwable e) {
                da.m564b("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.5 */
    class C02805 implements Runnable {
        final /* synthetic */ bj mU;
        final /* synthetic */ ErrorCode mV;

        C02805(bj bjVar, ErrorCode errorCode) {
            this.mU = bjVar;
            this.mV = errorCode;
        }

        public void run() {
            try {
                this.mU.mT.onAdFailedToLoad(bk.m444a(this.mV));
            } catch (Throwable e) {
                da.m564b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.6 */
    class C02816 implements Runnable {
        final /* synthetic */ bj mU;

        C02816(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLeftApplication();
            } catch (Throwable e) {
                da.m564b("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.7 */
    class C02827 implements Runnable {
        final /* synthetic */ bj mU;

        C02827(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdOpened();
            } catch (Throwable e) {
                da.m564b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.8 */
    class C02838 implements Runnable {
        final /* synthetic */ bj mU;

        C02838(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdLoaded();
            } catch (Throwable e) {
                da.m564b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bj.9 */
    class C02849 implements Runnable {
        final /* synthetic */ bj mU;

        C02849(bj bjVar) {
            this.mU = bjVar;
        }

        public void run() {
            try {
                this.mU.mT.onAdClosed();
            } catch (Throwable e) {
                da.m564b("Could not call onAdClosed.", e);
            }
        }
    }

    public bj(bh bhVar) {
        this.mT = bhVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m566s("Adapter called onClick.");
        if (cz.aX()) {
            try {
                this.mT.m443O();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdClicked.", e);
                return;
            }
        }
        da.m570w("onClick must be called on the main UI thread.");
        cz.pT.post(new C02761(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m566s("Adapter called onDismissScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdClosed();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdClosed.", e);
                return;
            }
        }
        da.m570w("onDismissScreen must be called on the main UI thread.");
        cz.pT.post(new C02794(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m566s("Adapter called onDismissScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdClosed();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdClosed.", e);
                return;
            }
        }
        da.m570w("onDismissScreen must be called on the main UI thread.");
        cz.pT.post(new C02849(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        da.m566s("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (cz.aX()) {
            try {
                this.mT.onAdFailedToLoad(bk.m444a(errorCode));
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        da.m570w("onFailedToReceiveAd must be called on the main UI thread.");
        cz.pT.post(new C02805(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        da.m566s("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (cz.aX()) {
            try {
                this.mT.onAdFailedToLoad(bk.m444a(errorCode));
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        da.m570w("onFailedToReceiveAd must be called on the main UI thread.");
        cz.pT.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m566s("Adapter called onLeaveApplication.");
        if (cz.aX()) {
            try {
                this.mT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        da.m570w("onLeaveApplication must be called on the main UI thread.");
        cz.pT.post(new C02816(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m566s("Adapter called onLeaveApplication.");
        if (cz.aX()) {
            try {
                this.mT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        da.m570w("onLeaveApplication must be called on the main UI thread.");
        cz.pT.post(new Runnable() {
            final /* synthetic */ bj mU;

            {
                this.mU = r1;
            }

            public void run() {
                try {
                    this.mU.mT.onAdLeftApplication();
                } catch (Throwable e) {
                    da.m564b("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m566s("Adapter called onPresentScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdOpened();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdOpened.", e);
                return;
            }
        }
        da.m570w("onPresentScreen must be called on the main UI thread.");
        cz.pT.post(new C02827(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m566s("Adapter called onPresentScreen.");
        if (cz.aX()) {
            try {
                this.mT.onAdOpened();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdOpened.", e);
                return;
            }
        }
        da.m570w("onPresentScreen must be called on the main UI thread.");
        cz.pT.post(new C02772(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        da.m566s("Adapter called onReceivedAd.");
        if (cz.aX()) {
            try {
                this.mT.onAdLoaded();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdLoaded.", e);
                return;
            }
        }
        da.m570w("onReceivedAd must be called on the main UI thread.");
        cz.pT.post(new C02838(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        da.m566s("Adapter called onReceivedAd.");
        if (cz.aX()) {
            try {
                this.mT.onAdLoaded();
                return;
            } catch (Throwable e) {
                da.m564b("Could not call onAdLoaded.", e);
                return;
            }
        }
        da.m570w("onReceivedAd must be called on the main UI thread.");
        cz.pT.post(new C02783(this));
    }
}
