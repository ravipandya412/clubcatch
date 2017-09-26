package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C0487l implements Creator<MaskedWalletRequest> {
    static void m1387a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0212b.m236a(parcel, 2, maskedWalletRequest.Yl, false);
        C0212b.m239a(parcel, 3, maskedWalletRequest.YY);
        C0212b.m239a(parcel, 4, maskedWalletRequest.YZ);
        C0212b.m239a(parcel, 5, maskedWalletRequest.Za);
        C0212b.m236a(parcel, 6, maskedWalletRequest.Zb, false);
        C0212b.m236a(parcel, 7, maskedWalletRequest.Yg, false);
        C0212b.m236a(parcel, 8, maskedWalletRequest.Zc, false);
        C0212b.m234a(parcel, 9, maskedWalletRequest.Yu, i, false);
        C0212b.m239a(parcel, 10, maskedWalletRequest.Zd);
        C0212b.m239a(parcel, 11, maskedWalletRequest.Ze);
        C0212b.m241a(parcel, 12, maskedWalletRequest.Zf, i, false);
        C0212b.m239a(parcel, 13, maskedWalletRequest.Zg);
        C0212b.m239a(parcel, 14, maskedWalletRequest.Zh);
        C0212b.m245b(parcel, 15, maskedWalletRequest.Zi, false);
        C0212b.m226D(parcel, p);
    }

    public MaskedWalletRequest bc(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0211a.m198c(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z3 = C0211a.m198c(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    cart = (Cart) C0211a.m191a(parcel, n, Cart.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    z4 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    z5 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) C0211a.m196b(parcel, n, CountrySpecification.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    z6 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    z7 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    arrayList = C0211a.m197c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public MaskedWalletRequest[] ci(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ci(x0);
    }
}
