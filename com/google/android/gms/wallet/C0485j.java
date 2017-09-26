package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.LatLng;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C0485j implements Creator<LoyaltyWalletObject> {
    static void m1385a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0212b.m236a(parcel, 2, loyaltyWalletObject.eN, false);
        C0212b.m236a(parcel, 3, loyaltyWalletObject.YC, false);
        C0212b.m236a(parcel, 4, loyaltyWalletObject.YD, false);
        C0212b.m236a(parcel, 5, loyaltyWalletObject.YE, false);
        C0212b.m236a(parcel, 6, loyaltyWalletObject.YF, false);
        C0212b.m236a(parcel, 7, loyaltyWalletObject.YG, false);
        C0212b.m236a(parcel, 8, loyaltyWalletObject.YH, false);
        C0212b.m236a(parcel, 9, loyaltyWalletObject.YI, false);
        C0212b.m236a(parcel, 10, loyaltyWalletObject.YJ, false);
        C0212b.m236a(parcel, 11, loyaltyWalletObject.YK, false);
        C0212b.m246c(parcel, 12, loyaltyWalletObject.state);
        C0212b.m245b(parcel, 13, loyaltyWalletObject.YL, false);
        C0212b.m234a(parcel, 14, loyaltyWalletObject.YM, i, false);
        C0212b.m245b(parcel, 15, loyaltyWalletObject.YN, false);
        C0212b.m236a(parcel, 17, loyaltyWalletObject.YP, false);
        C0212b.m236a(parcel, 16, loyaltyWalletObject.YO, false);
        C0212b.m239a(parcel, 19, loyaltyWalletObject.YR);
        C0212b.m245b(parcel, 18, loyaltyWalletObject.YQ, false);
        C0212b.m245b(parcel, 21, loyaltyWalletObject.YT, false);
        C0212b.m245b(parcel, 20, loyaltyWalletObject.YS, false);
        C0212b.m234a(parcel, 23, loyaltyWalletObject.YV, i, false);
        C0212b.m245b(parcel, 22, loyaltyWalletObject.YU, false);
        C0212b.m226D(parcel, p);
    }

    public LoyaltyWalletObject ba(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList eH = fj.eH();
        jr jrVar = null;
        ArrayList eH2 = fj.eH();
        String str11 = null;
        String str12 = null;
        ArrayList eH3 = fj.eH();
        boolean z = false;
        ArrayList eH4 = fj.eH();
        ArrayList eH5 = fj.eH();
        ArrayList eH6 = fj.eH();
        jl jlVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str6 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str7 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str8 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    str9 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    str10 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    eH = C0211a.m197c(parcel, n, jv.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    jrVar = (jr) C0211a.m191a(parcel, n, jr.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    eH2 = C0211a.m197c(parcel, n, LatLng.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    str11 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    str12 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    eH3 = C0211a.m197c(parcel, n, jj.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    eH4 = C0211a.m197c(parcel, n, jt.CREATOR);
                    break;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    eH5 = C0211a.m197c(parcel, n, jp.CREATOR);
                    break;
                case C0519R.styleable.Theme_actionBarSize /*22*/:
                    eH6 = C0211a.m197c(parcel, n, jt.CREATOR);
                    break;
                case C0519R.styleable.Theme_actionBarDivider /*23*/:
                    jlVar = (jl) C0211a.m191a(parcel, n, jl.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, eH, jrVar, eH2, str11, str12, eH3, z, eH4, eH5, eH6, jlVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public LoyaltyWalletObject[] cg(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cg(x0);
    }
}
