package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.wallet.f */
public class C0481f implements Creator<FullWallet> {
    static void m1381a(FullWallet fullWallet, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, fullWallet.getVersionCode());
        C0212b.m236a(parcel, 2, fullWallet.Yk, false);
        C0212b.m236a(parcel, 3, fullWallet.Yl, false);
        C0212b.m234a(parcel, 4, fullWallet.Ym, i, false);
        C0212b.m236a(parcel, 5, fullWallet.Yn, false);
        C0212b.m234a(parcel, 6, fullWallet.Yo, i, false);
        C0212b.m234a(parcel, 7, fullWallet.Yp, i, false);
        C0212b.m242a(parcel, 8, fullWallet.Yq, false);
        C0212b.m234a(parcel, 9, fullWallet.Yr, i, false);
        C0212b.m234a(parcel, 10, fullWallet.Ys, i, false);
        C0212b.m241a(parcel, 11, fullWallet.Yt, i, false);
        C0212b.m226D(parcel, p);
    }

    public FullWallet aW(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    proxyCard = (ProxyCard) C0211a.m191a(parcel, n, ProxyCard.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    address2 = (Address) C0211a.m191a(parcel, n, Address.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    address = (Address) C0211a.m191a(parcel, n, Address.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    strArr = C0211a.m221x(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    userAddress2 = (UserAddress) C0211a.m191a(parcel, n, UserAddress.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    userAddress = (UserAddress) C0211a.m191a(parcel, n, UserAddress.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0211a.m196b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public FullWallet[] cc(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
