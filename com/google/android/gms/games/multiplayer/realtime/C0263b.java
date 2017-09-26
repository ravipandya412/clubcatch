package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0263b implements Creator<RoomEntity> {
    static void m371a(RoomEntity roomEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, roomEntity.getRoomId(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0212b.m236a(parcel, 2, roomEntity.getCreatorId(), false);
        C0212b.m230a(parcel, 3, roomEntity.getCreationTimestamp());
        C0212b.m246c(parcel, 4, roomEntity.getStatus());
        C0212b.m236a(parcel, 5, roomEntity.getDescription(), false);
        C0212b.m246c(parcel, 6, roomEntity.getVariant());
        C0212b.m231a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0212b.m245b(parcel, 8, roomEntity.getParticipants(), false);
        C0212b.m246c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0212b.m226D(parcel, p);
    }

    public RoomEntity aq(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C0211a.m211o(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    arrayList = C0211a.m197c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
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
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public RoomEntity[] bd(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
