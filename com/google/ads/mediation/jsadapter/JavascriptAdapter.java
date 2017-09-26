package com.google.ads.mediation.jsadapter;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.da;

public final class JavascriptAdapter implements MediationBannerAdapter<EmptyNetworkExtras, JavascriptServerParameters> {
    private WebView f76C;
    private FrameLayout f77D;
    private boolean f78E;
    private MediationBannerListener f79k;
    private int f80v;
    private int f81w;

    public void destroy() {
        this.f78E = true;
    }

    public Class<EmptyNetworkExtras> getAdditionalParametersType() {
        return EmptyNetworkExtras.class;
    }

    public View getBannerView() {
        return this.f77D;
    }

    public Class<JavascriptServerParameters> getServerParametersType() {
        return JavascriptServerParameters.class;
    }

    public WebView getWebView() {
        return this.f76C;
    }

    public int getWebViewHeight() {
        return this.f80v;
    }

    public int getWebViewWidth() {
        return this.f81w;
    }

    public void passbackReceived() {
        da.m566s("Passback received");
        sendAdNotReceivedUpdate();
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, JavascriptServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, EmptyNetworkExtras extras) {
        this.f79k = listener;
        this.f80v = serverParameters.height != null ? serverParameters.height.intValue() : adSize.getHeightInPixels(activity);
        this.f81w = serverParameters.width != null ? serverParameters.width.intValue() : adSize.getWidthInPixels(activity);
        this.f78E = false;
        this.f76C = new WebView(activity);
        this.f76C.getSettings().setJavaScriptEnabled(true);
        this.f76C.setWebViewClient(new BannerWebViewClient(this, serverParameters.passBackUrl));
        this.f76C.setBackgroundColor(0);
        this.f77D = new FrameLayout(activity);
        this.f77D.addView(this.f76C, new LayoutParams(this.f81w, this.f80v, 17));
        this.f76C.loadDataWithBaseURL(null, serverParameters.htmlScript, "text/html", "utf-8", null);
    }

    public void sendAdNotReceivedUpdate() {
        if (!this.f78E) {
            this.f78E = true;
            this.f79k.onFailedToReceiveAd(this, ErrorCode.NO_FILL);
        }
    }

    public void sendAdReceivedUpdate() {
        if (!this.f78E) {
            this.f78E = true;
            this.f79k.onReceivedAd(this);
        }
    }

    public boolean shouldStopAdCheck() {
        return this.f78E;
    }

    public void startCheckingForAd() {
        new AdViewCheckTask(this, 200, 100).start();
    }
}
