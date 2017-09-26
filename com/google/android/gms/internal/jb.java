package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.ir.C0989h;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class jb implements Creator<C0989h> {
    static void m1001a(C0989h c0989h, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0989h.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0989h.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m246c(parcel, 3, c0989h.io());
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m236a(parcel, 4, c0989h.getValue(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, c0989h.getLabel(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m246c(parcel, 6, c0989h.getType());
        }
        C0212b.m226D(parcel, p);
    }

    public C0989h aR(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0989h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0989h[] bO(int i) {
        return new C0989h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
