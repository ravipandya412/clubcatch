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

/* renamed from: com.google.android.gms.games.a */
public class C0255a implements Creator<GameEntity> {
    static void m365a(GameEntity gameEntity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, gameEntity.getApplicationId(), false);
        C0212b.m236a(parcel, 2, gameEntity.getDisplayName(), false);
        C0212b.m236a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0212b.m236a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0212b.m236a(parcel, 5, gameEntity.getDescription(), false);
        C0212b.m236a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0212b.m234a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0212b.m234a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0212b.m234a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0212b.m239a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0212b.m239a(parcel, 11, gameEntity.isInstanceInstalled());
        C0212b.m236a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0212b.m246c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0212b.m246c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0212b.m246c(parcel, 15, gameEntity.getLeaderboardCount());
        C0212b.m239a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0212b.m239a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0212b.m236a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0212b.m236a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0212b.m239a(parcel, 21, gameEntity.isMuted());
        C0212b.m236a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0212b.m226D(parcel, p);
    }

    public GameEntity[] aP(int i) {
        return new GameEntity[i];
    }

    public GameEntity aj(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
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
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str6 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    uri = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    uri2 = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    uri3 = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    str7 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    z3 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    z4 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    str8 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    str9 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    str10 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    z5 = C0211a.m198c(parcel, n);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
