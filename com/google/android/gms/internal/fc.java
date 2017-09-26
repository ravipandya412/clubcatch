package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public class fc implements Creator<C0696a> {
    static void m752a(C0696a c0696a, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0696a.getVersionCode());
        C0212b.m246c(parcel, 2, c0696a.el());
        C0212b.m239a(parcel, 3, c0696a.er());
        C0212b.m246c(parcel, 4, c0696a.em());
        C0212b.m239a(parcel, 5, c0696a.es());
        C0212b.m236a(parcel, 6, c0696a.et(), false);
        C0212b.m246c(parcel, 7, c0696a.eu());
        C0212b.m236a(parcel, 8, c0696a.ew(), false);
        C0212b.m234a(parcel, 9, c0696a.ey(), i, false);
        C0212b.m226D(parcel, p);
    }

    public C0696a[] m753W(int i) {
        return new C0696a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m754t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m753W(x0);
    }

    public C0696a m754t(Parcel parcel) {
        ew ewVar = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    ewVar = (ew) C0211a.m191a(parcel, n, ew.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0696a(i4, i3, z2, i2, z, str2, i, str, ewVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
