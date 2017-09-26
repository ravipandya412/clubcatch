package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C0417j implements Creator<C0831h> {
    static void m1212a(C0831h c0831h, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, c0831h.getAccountName(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0831h.getVersionCode());
        C0212b.m242a(parcel, 2, c0831h.hq(), false);
        C0212b.m242a(parcel, 3, c0831h.hr(), false);
        C0212b.m242a(parcel, 4, c0831h.hs(), false);
        C0212b.m236a(parcel, 5, c0831h.ht(), false);
        C0212b.m236a(parcel, 6, c0831h.hu(), false);
        C0212b.m236a(parcel, 7, c0831h.hv(), false);
        C0212b.m236a(parcel, 8, c0831h.hw(), false);
        C0212b.m234a(parcel, 9, c0831h.hx(), i, false);
        C0212b.m226D(parcel, p);
    }

    public C0831h aF(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    strArr3 = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    strArr2 = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    strArr = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    plusCommonExtras = (PlusCommonExtras) C0211a.m191a(parcel, n, PlusCommonExtras.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0831h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0831h[] bC(int i) {
        return new C0831h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bC(x0);
    }
}
