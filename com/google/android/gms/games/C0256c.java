package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.games.c */
public class C0256c implements Creator<PlayerEntity> {
    static void m366a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, playerEntity.getPlayerId(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0212b.m236a(parcel, 2, playerEntity.getDisplayName(), false);
        C0212b.m234a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0212b.m234a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0212b.m230a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0212b.m246c(parcel, 6, playerEntity.fl());
        C0212b.m230a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0212b.m236a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0212b.m236a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0212b.m226D(parcel, p);
    }

    public PlayerEntity[] aQ(int i) {
        return new PlayerEntity[i];
    }

    public PlayerEntity ak(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    uri = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri2 = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
