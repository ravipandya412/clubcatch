package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m374a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m234a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameRequestEntity.getVersionCode());
        C0212b.m234a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0212b.m240a(parcel, 3, gameRequestEntity.getData(), false);
        C0212b.m236a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0212b.m245b(parcel, 5, gameRequestEntity.fU(), false);
        C0212b.m246c(parcel, 7, gameRequestEntity.getType());
        C0212b.m230a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0212b.m230a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0212b.m231a(parcel, 11, gameRequestEntity.gf(), false);
        C0212b.m226D(parcel, p);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    gameEntity = (GameEntity) C0211a.m191a(parcel, n, GameEntity.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    playerEntity = (PlayerEntity) C0211a.m191a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bArr = C0211a.m213p(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    arrayList = C0211a.m197c(parcel, n, PlayerEntity.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    bundle = C0211a.m212o(parcel, n);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
