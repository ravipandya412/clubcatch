package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.pkr.clubcatch.C0519R;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1117a(LocationRequest locationRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, locationRequest.mPriority);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequest.getVersionCode());
        C0212b.m230a(parcel, 2, locationRequest.Lc);
        C0212b.m230a(parcel, 3, locationRequest.Ld);
        C0212b.m239a(parcel, 4, locationRequest.Le);
        C0212b.m230a(parcel, 5, locationRequest.KV);
        C0212b.m246c(parcel, 6, locationRequest.Lf);
        C0212b.m229a(parcel, 7, locationRequest.Lg);
        C0212b.m226D(parcel, p);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0211a.m211o(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j3 = C0211a.m203h(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
