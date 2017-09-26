package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0259a implements Creator<InvitationEntity> {
    static void m369a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m234a(parcel, 1, invitationEntity.getGame(), i, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0212b.m236a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0212b.m230a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0212b.m246c(parcel, 4, invitationEntity.getInvitationType());
        C0212b.m234a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0212b.m245b(parcel, 6, invitationEntity.getParticipants(), false);
        C0212b.m246c(parcel, 7, invitationEntity.getVariant());
        C0212b.m246c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0212b.m226D(parcel, p);
    }

    public InvitationEntity an(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    gameEntity = (GameEntity) C0211a.m191a(parcel, n, GameEntity.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    participantEntity = (ParticipantEntity) C0211a.m191a(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    arrayList = C0211a.m197c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public InvitationEntity[] ba(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ba(x0);
    }
}
