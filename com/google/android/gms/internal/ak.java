package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0916c;

public final class ak {
    private final be lF;
    private ag lG;
    private ViewGroup lH;
    private AdListener lc;
    private AppEventListener lq;
    private AdSize[] lr;
    private String ls;

    public ak(ViewGroup viewGroup) {
        this.lF = new be();
        this.lH = viewGroup;
    }

    public ak(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this.lF = new be();
        this.lH = viewGroup;
        Context context = viewGroup.getContext();
        try {
            ae aeVar = new ae(context, attributeSet);
            this.lr = aeVar.m389c(z);
            this.ls = aeVar.getAdUnitId();
            if (viewGroup.isInEditMode()) {
                cz.m558a(viewGroup, new ab(context, this.lr[0]), "Ads by Google");
            }
        } catch (IllegalArgumentException e) {
            cz.m560a(viewGroup, new ab(context, AdSize.BANNER), e.getMessage(), e.getMessage());
        }
    }

    private void am() {
        try {
            C0251b P = this.lG.m390P();
            if (P != null) {
                this.lH.addView((View) C0916c.m2414b(P));
            }
        } catch (Throwable e) {
            da.m564b("Failed to get an ad frame.", e);
        }
    }

    private void an() throws RemoteException {
        if ((this.lr == null || this.ls == null) && this.lG == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.lH.getContext();
        this.lG = C0738y.m2126a(context, new ab(context, this.lr), this.ls, this.lF);
        if (this.lc != null) {
            this.lG.m394a(new C0994x(this.lc));
        }
        if (this.lq != null) {
            this.lG.m395a(new ad(this.lq));
        }
        am();
    }

    public void m418a(aj ajVar) {
        try {
            if (this.lG == null) {
                an();
            }
            if (this.lG.m396a(new C0739z(this.lH.getContext(), ajVar))) {
                this.lF.m2448c(ajVar.ak());
            }
        } catch (Throwable e) {
            da.m564b("Failed to load ad.", e);
        }
    }

    public void m419a(AdSize... adSizeArr) {
        this.lr = adSizeArr;
        try {
            if (this.lG != null) {
                this.lG.m393a(new ab(this.lH.getContext(), this.lr));
            }
        } catch (Throwable e) {
            da.m564b("Failed to set the ad size.", e);
        }
        this.lH.requestLayout();
    }

    public void destroy() {
        try {
            if (this.lG != null) {
                this.lG.destroy();
            }
        } catch (Throwable e) {
            da.m564b("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lc;
    }

    public AdSize getAdSize() {
        try {
            if (this.lG != null) {
                return this.lG.m391Q().ai();
            }
        } catch (Throwable e) {
            da.m564b("Failed to get the current AdSize.", e);
        }
        return this.lr != null ? this.lr[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.lr;
    }

    public String getAdUnitId() {
        return this.ls;
    }

    public AppEventListener getAppEventListener() {
        return this.lq;
    }

    public void pause() {
        try {
            if (this.lG != null) {
                this.lG.pause();
            }
        } catch (Throwable e) {
            da.m564b("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            this.lG.m392Z();
        } catch (Throwable e) {
            da.m564b("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.lG != null) {
                this.lG.resume();
            }
        } catch (Throwable e) {
            da.m564b("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lc = adListener;
            if (this.lG != null) {
                this.lG.m394a(adListener != null ? new C0994x(adListener) : null);
            }
        } catch (Throwable e) {
            da.m564b("Failed to set the AdListener.", e);
        }
    }

    public void setAdSizes(AdSize... adSizes) {
        if (this.lr != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m419a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.ls != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.ls = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.lq = appEventListener;
            if (this.lG != null) {
                this.lG.m395a(appEventListener != null ? new ad(appEventListener) : null);
            }
        } catch (Throwable e) {
            da.m564b("Failed to set the AppEventListener.", e);
        }
    }
}
