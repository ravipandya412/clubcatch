package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.games.multiplayer.c */
public class C0260c implements Creator<ParticipantEntity> {
    static void m370a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, participantEntity.getParticipantId(), false);
        C0212b.m236a(parcel, 2, participantEntity.getDisplayName(), false);
        C0212b.m234a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0212b.m234a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0212b.m246c(parcel, 5, participantEntity.getStatus());
        C0212b.m236a(parcel, 6, participantEntity.ge(), false);
        C0212b.m239a(parcel, 7, participantEntity.isConnectedToRoom());
        C0212b.m234a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0212b.m246c(parcel, 9, participantEntity.getCapabilities());
        C0212b.m234a(parcel, 10, participantEntity.getResult(), i, false);
        C0212b.m236a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0212b.m236a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C0212b.m226D(parcel, p);
    }

    public ParticipantEntity ao(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    playerEntity = (PlayerEntity) C0211a.m191a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    participantResult = (ParticipantResult) C0211a.m191a(parcel, n, ParticipantResult.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    str5 = C0211a.m208m(parcel, n);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ParticipantEntity[] bb(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ao(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bb(x0);
    }
}
