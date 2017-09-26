package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0188b implements Creator<CastDevice> {
    static void m116a(CastDevice castDevice, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, castDevice.getVersionCode());
        C0212b.m236a(parcel, 2, castDevice.getDeviceId(), false);
        C0212b.m236a(parcel, 3, castDevice.wD, false);
        C0212b.m236a(parcel, 4, castDevice.getFriendlyName(), false);
        C0212b.m236a(parcel, 5, castDevice.getModelName(), false);
        C0212b.m236a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0212b.m246c(parcel, 7, castDevice.getServicePort());
        C0212b.m245b(parcel, 8, castDevice.getIcons(), false);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m117k(x0);
    }

    public CastDevice m117k(Parcel parcel) {
        int i = 0;
        List list = null;
        int o = C0211a.m211o(parcel);
        String str = null;
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
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    list = C0211a.m197c(parcel, n, WebImage.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CastDevice(i2, str5, str4, str3, str2, str, i, list);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m118y(x0);
    }

    public CastDevice[] m118y(int i) {
        return new CastDevice[i];
    }
}
