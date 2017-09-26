package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m373a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m234a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0212b.m236a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0212b.m236a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0212b.m230a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0212b.m236a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0212b.m230a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0212b.m236a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0212b.m246c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0212b.m246c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0212b.m246c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0212b.m240a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0212b.m245b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0212b.m236a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0212b.m240a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0212b.m231a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0212b.m246c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, turnBasedMatchEntity.getVersionCode());
        C0212b.m239a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0212b.m246c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0212b.m236a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0212b.m236a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0212b.m226D(parcel, p);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    bArr = C0211a.m213p(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    arrayList = C0211a.m197c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    bArr2 = C0211a.m213p(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    i5 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    i6 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    str6 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    str7 = C0211a.m208m(parcel, n);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
