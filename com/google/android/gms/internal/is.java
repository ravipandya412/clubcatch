package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.ir.C0981a;
import com.google.android.gms.internal.ir.C0984b;
import com.google.android.gms.internal.ir.C0985c;
import com.google.android.gms.internal.ir.C0986d;
import com.google.android.gms.internal.ir.C0987f;
import com.google.android.gms.internal.ir.C0988g;
import com.google.android.gms.internal.ir.C0989h;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class is implements Creator<ir> {
    static void m992a(ir irVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = irVar.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, irVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m236a(parcel, 2, irVar.getAboutMe(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m234a(parcel, 3, irVar.hW(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m236a(parcel, 4, irVar.getBirthday(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, irVar.getBraggingRights(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m246c(parcel, 6, irVar.getCircledByCount());
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0212b.m234a(parcel, 7, irVar.hX(), i, true);
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0212b.m236a(parcel, 8, irVar.getCurrentLocation(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0212b.m236a(parcel, 9, irVar.getDisplayName(), true);
        }
        if (hB.contains(Integer.valueOf(12))) {
            C0212b.m246c(parcel, 12, irVar.getGender());
        }
        if (hB.contains(Integer.valueOf(14))) {
            C0212b.m236a(parcel, 14, irVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(15))) {
            C0212b.m234a(parcel, 15, irVar.hY(), i, true);
        }
        if (hB.contains(Integer.valueOf(16))) {
            C0212b.m239a(parcel, 16, irVar.isPlusUser());
        }
        if (hB.contains(Integer.valueOf(19))) {
            C0212b.m234a(parcel, 19, irVar.hZ(), i, true);
        }
        if (hB.contains(Integer.valueOf(18))) {
            C0212b.m236a(parcel, 18, irVar.getLanguage(), true);
        }
        if (hB.contains(Integer.valueOf(21))) {
            C0212b.m246c(parcel, 21, irVar.getObjectType());
        }
        if (hB.contains(Integer.valueOf(20))) {
            C0212b.m236a(parcel, 20, irVar.getNickname(), true);
        }
        if (hB.contains(Integer.valueOf(23))) {
            C0212b.m245b(parcel, 23, irVar.ib(), true);
        }
        if (hB.contains(Integer.valueOf(22))) {
            C0212b.m245b(parcel, 22, irVar.ia(), true);
        }
        if (hB.contains(Integer.valueOf(25))) {
            C0212b.m246c(parcel, 25, irVar.getRelationshipStatus());
        }
        if (hB.contains(Integer.valueOf(24))) {
            C0212b.m246c(parcel, 24, irVar.getPlusOneCount());
        }
        if (hB.contains(Integer.valueOf(27))) {
            C0212b.m236a(parcel, 27, irVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(26))) {
            C0212b.m236a(parcel, 26, irVar.getTagline(), true);
        }
        if (hB.contains(Integer.valueOf(29))) {
            C0212b.m239a(parcel, 29, irVar.isVerified());
        }
        if (hB.contains(Integer.valueOf(28))) {
            C0212b.m245b(parcel, 28, irVar.ic(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public ir aI(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0981a c0981a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0984b c0984b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0985c c0985c = null;
        boolean z = false;
        String str7 = null;
        C0986d c0986d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0981a c0981a2 = (C0981a) C0211a.m191a(parcel, n, C0981a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0981a = c0981a2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    C0984b c0984b2 = (C0984b) C0211a.m191a(parcel, n, C0984b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c0984b = c0984b2;
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str4 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str5 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    i3 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    str6 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    C0985c c0985c2 = (C0985c) C0211a.m191a(parcel, n, C0985c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c0985c = c0985c2;
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    z = C0211a.m198c(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    str7 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    C0986d c0986d2 = (C0986d) C0211a.m191a(parcel, n, C0986d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c0986d = c0986d2;
                    break;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    str8 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    i4 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case C0519R.styleable.Theme_actionBarSize /*22*/:
                    list = C0211a.m197c(parcel, n, C0987f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case C0519R.styleable.Theme_actionBarDivider /*23*/:
                    list2 = C0211a.m197c(parcel, n, C0988g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                    i5 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case C0519R.styleable.Theme_actionMenuTextAppearance /*25*/:
                    i6 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                    str9 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case C0519R.styleable.Theme_actionModeStyle /*27*/:
                    str10 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case C0519R.styleable.Theme_actionModeCloseButtonStyle /*28*/:
                    list3 = C0211a.m197c(parcel, n, C0989h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case C0519R.styleable.Theme_actionModeBackground /*29*/:
                    z2 = C0211a.m198c(parcel, n);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ir(hashSet, i, str, c0981a, str2, str3, i2, c0984b, str4, str5, i3, str6, c0985c, z, str7, c0986d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ir[] bF(int i) {
        return new ir[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bF(x0);
    }
}
