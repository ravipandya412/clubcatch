package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.wallet.i */
public class C0484i implements Creator<LineItem> {
    static void m1384a(LineItem lineItem, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, lineItem.getVersionCode());
        C0212b.m236a(parcel, 2, lineItem.description, false);
        C0212b.m236a(parcel, 3, lineItem.Yy, false);
        C0212b.m236a(parcel, 4, lineItem.Yz, false);
        C0212b.m236a(parcel, 5, lineItem.Yf, false);
        C0212b.m246c(parcel, 6, lineItem.YA);
        C0212b.m236a(parcel, 7, lineItem.Yg, false);
        C0212b.m226D(parcel, p);
    }

    public LineItem aZ(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0211a.m211o(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public LineItem[] cf(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cf(x0);
    }
}
