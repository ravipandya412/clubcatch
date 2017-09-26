package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.HashSet;
import java.util.Set;

public class ip implements Creator<io> {
    static void m991a(io ioVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = ioVar.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, ioVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m236a(parcel, 2, ioVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m234a(parcel, 4, ioVar.hS(), i, true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, ioVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m234a(parcel, 6, ioVar.hT(), i, true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0212b.m236a(parcel, 7, ioVar.getType(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public io aH(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        im imVar = null;
        String str2 = null;
        im imVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            im imVar3;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str3 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    imVar3 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imVar2 = imVar3;
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    imVar3 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    imVar = imVar3;
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
            return new io(hashSet, i, str3, imVar2, str2, imVar, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public io[] bE(int i) {
        return new io[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
