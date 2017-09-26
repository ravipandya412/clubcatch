package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class in implements Creator<im> {
    static void m990a(im imVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = imVar.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, imVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m234a(parcel, 2, imVar.hC(), i, true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m237a(parcel, 3, imVar.getAdditionalName(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m234a(parcel, 4, imVar.hD(), i, true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0212b.m236a(parcel, 5, imVar.getAddressCountry(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0212b.m236a(parcel, 6, imVar.getAddressLocality(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0212b.m236a(parcel, 7, imVar.getAddressRegion(), true);
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0212b.m245b(parcel, 8, imVar.hE(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0212b.m246c(parcel, 9, imVar.getAttendeeCount());
        }
        if (hB.contains(Integer.valueOf(10))) {
            C0212b.m245b(parcel, 10, imVar.hF(), true);
        }
        if (hB.contains(Integer.valueOf(11))) {
            C0212b.m234a(parcel, 11, imVar.hG(), i, true);
        }
        if (hB.contains(Integer.valueOf(12))) {
            C0212b.m245b(parcel, 12, imVar.hH(), true);
        }
        if (hB.contains(Integer.valueOf(13))) {
            C0212b.m236a(parcel, 13, imVar.getBestRating(), true);
        }
        if (hB.contains(Integer.valueOf(14))) {
            C0212b.m236a(parcel, 14, imVar.getBirthDate(), true);
        }
        if (hB.contains(Integer.valueOf(15))) {
            C0212b.m234a(parcel, 15, imVar.hI(), i, true);
        }
        if (hB.contains(Integer.valueOf(17))) {
            C0212b.m236a(parcel, 17, imVar.getContentSize(), true);
        }
        if (hB.contains(Integer.valueOf(16))) {
            C0212b.m236a(parcel, 16, imVar.getCaption(), true);
        }
        if (hB.contains(Integer.valueOf(19))) {
            C0212b.m245b(parcel, 19, imVar.hJ(), true);
        }
        if (hB.contains(Integer.valueOf(18))) {
            C0212b.m236a(parcel, 18, imVar.getContentUrl(), true);
        }
        if (hB.contains(Integer.valueOf(21))) {
            C0212b.m236a(parcel, 21, imVar.getDateModified(), true);
        }
        if (hB.contains(Integer.valueOf(20))) {
            C0212b.m236a(parcel, 20, imVar.getDateCreated(), true);
        }
        if (hB.contains(Integer.valueOf(23))) {
            C0212b.m236a(parcel, 23, imVar.getDescription(), true);
        }
        if (hB.contains(Integer.valueOf(22))) {
            C0212b.m236a(parcel, 22, imVar.getDatePublished(), true);
        }
        if (hB.contains(Integer.valueOf(25))) {
            C0212b.m236a(parcel, 25, imVar.getEmbedUrl(), true);
        }
        if (hB.contains(Integer.valueOf(24))) {
            C0212b.m236a(parcel, 24, imVar.getDuration(), true);
        }
        if (hB.contains(Integer.valueOf(27))) {
            C0212b.m236a(parcel, 27, imVar.getFamilyName(), true);
        }
        if (hB.contains(Integer.valueOf(26))) {
            C0212b.m236a(parcel, 26, imVar.getEndDate(), true);
        }
        if (hB.contains(Integer.valueOf(29))) {
            C0212b.m234a(parcel, 29, imVar.hK(), i, true);
        }
        if (hB.contains(Integer.valueOf(28))) {
            C0212b.m236a(parcel, 28, imVar.getGender(), true);
        }
        if (hB.contains(Integer.valueOf(31))) {
            C0212b.m236a(parcel, 31, imVar.getHeight(), true);
        }
        if (hB.contains(Integer.valueOf(30))) {
            C0212b.m236a(parcel, 30, imVar.getGivenName(), true);
        }
        if (hB.contains(Integer.valueOf(34))) {
            C0212b.m234a(parcel, 34, imVar.hL(), i, true);
        }
        if (hB.contains(Integer.valueOf(32))) {
            C0212b.m236a(parcel, 32, imVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(33))) {
            C0212b.m236a(parcel, 33, imVar.getImage(), true);
        }
        if (hB.contains(Integer.valueOf(38))) {
            C0212b.m228a(parcel, 38, imVar.getLongitude());
        }
        if (hB.contains(Integer.valueOf(39))) {
            C0212b.m236a(parcel, 39, imVar.getName(), true);
        }
        if (hB.contains(Integer.valueOf(36))) {
            C0212b.m228a(parcel, 36, imVar.getLatitude());
        }
        if (hB.contains(Integer.valueOf(37))) {
            C0212b.m234a(parcel, 37, imVar.hM(), i, true);
        }
        if (hB.contains(Integer.valueOf(42))) {
            C0212b.m236a(parcel, 42, imVar.getPlayerType(), true);
        }
        if (hB.contains(Integer.valueOf(43))) {
            C0212b.m236a(parcel, 43, imVar.getPostOfficeBoxNumber(), true);
        }
        if (hB.contains(Integer.valueOf(40))) {
            C0212b.m234a(parcel, 40, imVar.hN(), i, true);
        }
        if (hB.contains(Integer.valueOf(41))) {
            C0212b.m245b(parcel, 41, imVar.hO(), true);
        }
        if (hB.contains(Integer.valueOf(46))) {
            C0212b.m234a(parcel, 46, imVar.hP(), i, true);
        }
        if (hB.contains(Integer.valueOf(47))) {
            C0212b.m236a(parcel, 47, imVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(44))) {
            C0212b.m236a(parcel, 44, imVar.getPostalCode(), true);
        }
        if (hB.contains(Integer.valueOf(45))) {
            C0212b.m236a(parcel, 45, imVar.getRatingValue(), true);
        }
        if (hB.contains(Integer.valueOf(51))) {
            C0212b.m236a(parcel, 51, imVar.getThumbnailUrl(), true);
        }
        if (hB.contains(Integer.valueOf(50))) {
            C0212b.m234a(parcel, 50, imVar.hQ(), i, true);
        }
        if (hB.contains(Integer.valueOf(49))) {
            C0212b.m236a(parcel, 49, imVar.getText(), true);
        }
        if (hB.contains(Integer.valueOf(48))) {
            C0212b.m236a(parcel, 48, imVar.getStreetAddress(), true);
        }
        if (hB.contains(Integer.valueOf(55))) {
            C0212b.m236a(parcel, 55, imVar.getWidth(), true);
        }
        if (hB.contains(Integer.valueOf(54))) {
            C0212b.m236a(parcel, 54, imVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(53))) {
            C0212b.m236a(parcel, 53, imVar.getType(), true);
        }
        if (hB.contains(Integer.valueOf(52))) {
            C0212b.m236a(parcel, 52, imVar.getTickerSymbol(), true);
        }
        if (hB.contains(Integer.valueOf(56))) {
            C0212b.m236a(parcel, 56, imVar.getWorstRating(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public im aG(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        im imVar = null;
        List list = null;
        im imVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        im imVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        im imVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        im imVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        im imVar6 = null;
        double d = 0.0d;
        im imVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        im imVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        im imVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        im imVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            im imVar11;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    imVar = imVar11;
                    break;
                case DetectedActivity.STILL /*3*/:
                    list = C0211a.m222y(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imVar2 = imVar11;
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str2 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str3 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    list2 = C0211a.m197c(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    list3 = C0211a.m197c(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    imVar3 = imVar11;
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    list4 = C0211a.m197c(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    str4 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    str5 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    imVar4 = imVar11;
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    str6 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    str7 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    str8 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    list5 = C0211a.m197c(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    str9 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    str10 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case C0519R.styleable.Theme_actionBarSize /*22*/:
                    str11 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case C0519R.styleable.Theme_actionBarDivider /*23*/:
                    str12 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                    str13 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case C0519R.styleable.Theme_actionMenuTextAppearance /*25*/:
                    str14 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                    str15 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case C0519R.styleable.Theme_actionModeStyle /*27*/:
                    str16 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case C0519R.styleable.Theme_actionModeCloseButtonStyle /*28*/:
                    str17 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case C0519R.styleable.Theme_actionModeBackground /*29*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    imVar5 = imVar11;
                    break;
                case C0519R.styleable.Theme_actionModeSplitBackground /*30*/:
                    str18 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case C0519R.styleable.Theme_actionModeCloseDrawable /*31*/:
                    str19 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                    str20 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case C0519R.styleable.Theme_actionModeCopyDrawable /*33*/:
                    str21 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    imVar6 = imVar11;
                    break;
                case C0519R.styleable.Theme_actionModeShareDrawable /*36*/:
                    d = C0211a.m206k(parcel, n);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case C0519R.styleable.Theme_actionModeFindDrawable /*37*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    imVar7 = imVar11;
                    break;
                case C0519R.styleable.Theme_actionModeWebSearchDrawable /*38*/:
                    d2 = C0211a.m206k(parcel, n);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case C0519R.styleable.Theme_actionModePopupWindowStyle /*39*/:
                    str22 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    imVar8 = imVar11;
                    break;
                case C0519R.styleable.Theme_textAppearanceSmallPopupMenu /*41*/:
                    list6 = C0211a.m197c(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case C0519R.styleable.Theme_dialogTheme /*42*/:
                    str23 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case C0519R.styleable.Theme_dialogPreferredPadding /*43*/:
                    str24 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case C0519R.styleable.Theme_listDividerAlertDialog /*44*/:
                    str25 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case C0519R.styleable.Theme_actionDropDownStyle /*45*/:
                    str26 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case C0519R.styleable.Theme_dropdownListPreferredItemHeight /*46*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    imVar9 = imVar11;
                    break;
                case C0519R.styleable.Theme_spinnerDropDownItemStyle /*47*/:
                    str27 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case C0519R.styleable.Theme_homeAsUpIndicator /*48*/:
                    str28 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case C0519R.styleable.Theme_actionButtonStyle /*49*/:
                    str29 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case C0519R.styleable.Theme_buttonBarStyle /*50*/:
                    imVar11 = (im) C0211a.m191a(parcel, n, im.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    imVar10 = imVar11;
                    break;
                case C0519R.styleable.Theme_buttonBarButtonStyle /*51*/:
                    str30 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case C0519R.styleable.Theme_selectableItemBackground /*52*/:
                    str31 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case C0519R.styleable.Theme_selectableItemBackgroundBorderless /*53*/:
                    str32 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case C0519R.styleable.Theme_borderlessButtonStyle /*54*/:
                    str33 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case C0519R.styleable.Theme_dividerVertical /*55*/:
                    str34 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case C0519R.styleable.Theme_dividerHorizontal /*56*/:
                    str35 = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new im(hashSet, i, imVar, list, imVar2, str, str2, str3, list2, i2, list3, imVar3, list4, str4, str5, imVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, imVar5, str18, str19, str20, str21, imVar6, d, imVar7, d2, str22, imVar8, list6, str23, str24, str25, str26, imVar9, str27, str28, str29, imVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public im[] bD(int i) {
        return new im[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bD(x0);
    }
}
