package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

public class DataHolderCreator implements Creator<DataHolder> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m155a(DataHolder dataHolder, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m242a(parcel, 1, dataHolder.dH(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        C0212b.m241a(parcel, 2, dataHolder.dI(), i, false);
        C0212b.m246c(parcel, 3, dataHolder.getStatusCode());
        C0212b.m231a(parcel, 4, dataHolder.getMetadata(), false);
        C0212b.m226D(parcel, p);
    }

    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int o = C0211a.m211o(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    strArr = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0211a.m196b(parcel, n, CursorWindow.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0210a("Overread allowed size end=" + o, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.validateContents();
        return dataHolder;
    }

    public DataHolder[] newArray(int size) {
        return new DataHolder[size];
    }
}
