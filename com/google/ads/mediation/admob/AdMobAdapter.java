package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cz;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {
    private AdView f66h;
    private InterstitialAd f67i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0566a extends AdListener {
        private final AdMobAdapter f58j;
        private final MediationBannerListener f59k;

        public C0566a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f58j = adMobAdapter;
            this.f59k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f59k.onDismissScreen(this.f58j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f59k.onFailedToReceiveAd(this.f58j, bk.m449h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f59k.onLeaveApplication(this.f58j);
        }

        public void onAdLoaded() {
            this.f59k.onReceivedAd(this.f58j);
        }

        public void onAdOpened() {
            this.f59k.onClick(this.f58j);
            this.f59k.onPresentScreen(this.f58j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0567b extends AdListener {
        private final AdMobAdapter f60j;
        private final MediationInterstitialListener f61l;

        public C0567b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f60j = adMobAdapter;
            this.f61l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f61l.onDismissScreen(this.f60j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f61l.onFailedToReceiveAd(this.f60j, bk.m449h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f61l.onLeaveApplication(this.f60j);
        }

        public void onAdLoaded() {
            this.f61l.onReceivedAd(this.f60j);
        }

        public void onAdOpened() {
            this.f61l.onPresentScreen(this.f60j);
        }
    }

    private static AdRequest m2371a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        NetworkExtras adMobExtras2;
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(bk.m445a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(cz.m561l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras2 = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras2.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        if (!TextUtils.isEmpty(adMobServerParameters.adJson)) {
            extras.putString("_ad", adMobServerParameters.adJson);
        }
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras2);
        return builder.build();
    }

    public void destroy() {
        if (this.f66h != null) {
            this.f66h.destroy();
            this.f66h = null;
        }
        if (this.f67i != null) {
            this.f67i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f66h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f66h = new AdView(activity);
        this.f66h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f66h.setAdUnitId(serverParameters.adUnitId);
        this.f66h.setAdListener(new C0566a(this, bannerListener));
        this.f66h.loadAd(m2371a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f67i = new InterstitialAd(activity);
        this.f67i.setAdUnitId(serverParameters.adUnitId);
        this.f67i.setAdListener(new C0567b(this, interstitialListener));
        this.f67i.loadAd(m2371a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f67i.show();
    }
}
