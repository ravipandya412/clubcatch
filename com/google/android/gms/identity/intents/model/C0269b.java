package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0269b implements Creator<UserAddress> {
    static void m381a(UserAddress userAddress, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, userAddress.getVersionCode());
        C0212b.m236a(parcel, 2, userAddress.name, false);
        C0212b.m236a(parcel, 3, userAddress.KB, false);
        C0212b.m236a(parcel, 4, userAddress.KC, false);
        C0212b.m236a(parcel, 5, userAddress.KD, false);
        C0212b.m236a(parcel, 6, userAddress.KE, false);
        C0212b.m236a(parcel, 7, userAddress.KF, false);
        C0212b.m236a(parcel, 8, userAddress.KG, false);
        C0212b.m236a(parcel, 9, userAddress.KH, false);
        C0212b.m236a(parcel, 10, userAddress.oQ, false);
        C0212b.m236a(parcel, 11, userAddress.KI, false);
        C0212b.m236a(parcel, 12, userAddress.KJ, false);
        C0212b.m236a(parcel, 13, userAddress.KK, false);
        C0212b.m239a(parcel, 14, userAddress.KL);
        C0212b.m236a(parcel, 15, userAddress.KM, false);
        C0212b.m236a(parcel, 16, userAddress.KN, false);
        C0212b.m226D(parcel, p);
    }

    public UserAddress at(Parcel parcel) {
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
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str11 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    str12 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    str13 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    str14 = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public UserAddress[] bg(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
