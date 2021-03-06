package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.ir.C0987f;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.HashSet;
import java.util.Set;

public class iz implements Creator<C0987f> {
    static void m999a(C0987f c0987f, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0987f.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0987f.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m236a(parcel, 2, c0987f.getDepartment(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m236a(parcel, 3, c0987f.getDescription(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m236a(parcel, 4, c0987f.getEndDate(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, c0987f.getLocation(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m236a(parcel, 6, c0987f.getName(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0212b.m239a(parcel, 7, c0987f.isPrimary());
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0212b.m236a(parcel, 8, c0987f.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0212b.m236a(parcel, 9, c0987f.getTitle(), true);
        }
        if (hB.contains(Integer.valueOf(10))) {
            C0212b.m246c(parcel, 10, c0987f.getType());
        }
        C0212b.m226D(parcel, p);
    }

    public C0987f aP(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str7 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str3 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    z = C0211a.m198c(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0987f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0987f[] bM(int i) {
        return new C0987f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
