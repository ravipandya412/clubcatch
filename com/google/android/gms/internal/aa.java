package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.List;

public class aa implements Creator<C0739z> {
    static void m382a(C0739z c0739z, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0739z.versionCode);
        C0212b.m230a(parcel, 2, c0739z.le);
        C0212b.m231a(parcel, 3, c0739z.extras, false);
        C0212b.m246c(parcel, 4, c0739z.lf);
        C0212b.m237a(parcel, 5, c0739z.lg, false);
        C0212b.m239a(parcel, 6, c0739z.lh);
        C0212b.m246c(parcel, 7, c0739z.tagForChildDirectedTreatment);
        C0212b.m239a(parcel, 8, c0739z.li);
        C0212b.m236a(parcel, 9, c0739z.lj, false);
        C0212b.m234a(parcel, 10, c0739z.lk, i, false);
        C0212b.m234a(parcel, 11, c0739z.ll, i, false);
        C0212b.m236a(parcel, 12, c0739z.lm, false);
        C0212b.m226D(parcel, p);
    }

    public C0739z m383a(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        am amVar = null;
        Location location = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0211a.m222y(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    amVar = (am) C0211a.m191a(parcel, n, am.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    location = (Location) C0211a.m191a(parcel, n, Location.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0739z(i, j, bundle, i2, list, z, i3, z2, str, amVar, location, str2);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0739z[] m384b(int i) {
        return new C0739z[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m383a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m384b(x0);
    }
}
