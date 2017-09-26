package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
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

public class ce implements Creator<cd> {
    static void m476a(cd cdVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, cdVar.versionCode);
        C0212b.m231a(parcel, 2, cdVar.ob, false);
        C0212b.m234a(parcel, 3, cdVar.oc, i, false);
        C0212b.m234a(parcel, 4, cdVar.kQ, i, false);
        C0212b.m236a(parcel, 5, cdVar.adUnitId, false);
        C0212b.m234a(parcel, 6, cdVar.applicationInfo, i, false);
        C0212b.m234a(parcel, 7, cdVar.od, i, false);
        C0212b.m236a(parcel, 8, cdVar.oe, false);
        C0212b.m236a(parcel, 9, cdVar.of, false);
        C0212b.m236a(parcel, 10, cdVar.og, false);
        C0212b.m234a(parcel, 11, cdVar.kN, i, false);
        C0212b.m231a(parcel, 12, cdVar.oh, false);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m477f(x0);
    }

    public cd m477f(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        Bundle bundle = null;
        C0739z c0739z = null;
        ab abVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        db dbVar = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    c0739z = (C0739z) C0211a.m191a(parcel, n, C0739z.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    abVar = (ab) C0211a.m191a(parcel, n, ab.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    applicationInfo = (ApplicationInfo) C0211a.m191a(parcel, n, ApplicationInfo.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    packageInfo = (PackageInfo) C0211a.m191a(parcel, n, PackageInfo.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    dbVar = (db) C0211a.m191a(parcel, n, db.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    bundle2 = C0211a.m212o(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cd(i, bundle, c0739z, abVar, str, applicationInfo, packageInfo, str2, str3, str4, dbVar, bundle2);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public cd[] m478k(int i) {
        return new cd[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m478k(x0);
    }
}
