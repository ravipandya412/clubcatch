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

/* renamed from: com.google.android.gms.wallet.k */
public class C0486k implements Creator<MaskedWallet> {
    static void m1386a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, maskedWallet.getVersionCode());
        C0212b.m236a(parcel, 2, maskedWallet.Yk, false);
        C0212b.m236a(parcel, 3, maskedWallet.Yl, false);
        C0212b.m242a(parcel, 4, maskedWallet.Yq, false);
        C0212b.m236a(parcel, 5, maskedWallet.Yn, false);
        C0212b.m234a(parcel, 6, maskedWallet.Yo, i, false);
        C0212b.m234a(parcel, 7, maskedWallet.Yp, i, false);
        C0212b.m241a(parcel, 8, maskedWallet.YW, i, false);
        C0212b.m241a(parcel, 9, maskedWallet.YX, i, false);
        C0212b.m234a(parcel, 10, maskedWallet.Yr, i, false);
        C0212b.m234a(parcel, 11, maskedWallet.Ys, i, false);
        C0212b.m241a(parcel, 12, maskedWallet.Yt, i, false);
        C0212b.m226D(parcel, p);
    }

    public MaskedWallet bb(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    strArr = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    address = (Address) C0211a.m191a(parcel, n, Address.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    address2 = (Address) C0211a.m191a(parcel, n, Address.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0211a.m196b(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C0211a.m196b(parcel, n, OfferWalletObject.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    userAddress = (UserAddress) C0211a.m191a(parcel, n, UserAddress.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    userAddress2 = (UserAddress) C0211a.m191a(parcel, n, UserAddress.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) C0211a.m196b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public MaskedWallet[] ch(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ch(x0);
    }
}
