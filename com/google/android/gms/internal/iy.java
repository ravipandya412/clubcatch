package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.ir.C0986d;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.HashSet;
import java.util.Set;

public class iy implements Creator<C0986d> {
    static void m998a(C0986d c0986d, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0986d.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0986d.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m236a(parcel, 2, c0986d.getFamilyName(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m236a(parcel, 3, c0986d.getFormatted(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m236a(parcel, 4, c0986d.getGivenName(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, c0986d.getHonorificPrefix(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m236a(parcel, 6, c0986d.getHonorificSuffix(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0212b.m236a(parcel, 7, c0986d.getMiddleName(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public C0986d aO(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str6 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str5 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0986d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0986d[] bL(int i) {
        return new C0986d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bL(x0);
    }
}
