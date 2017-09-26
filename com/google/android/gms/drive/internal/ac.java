package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;
import com.google.android.gms.location.DetectedActivity;

public class ac implements Creator<OnEventResponse> {
    static void m264a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, onEventResponse.wj);
        C0212b.m246c(parcel, 2, onEventResponse.Dm);
        C0212b.m234a(parcel, 3, onEventResponse.Eb, i, false);
        C0212b.m234a(parcel, 4, onEventResponse.Ec, i, false);
        C0212b.m226D(parcel, p);
    }

    public OnEventResponse m265Q(Parcel parcel) {
        ConflictEvent conflictEvent = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            ChangeEvent changeEvent2;
            int i3;
            ConflictEvent conflictEvent2;
            int n = C0211a.m209n(parcel);
            ConflictEvent conflictEvent3;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C0211a.m202g(parcel, n);
                    conflictEvent2 = conflictEvent3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C0211a.m202g(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    i3 = i;
                    i = i2;
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = (ChangeEvent) C0211a.m191a(parcel, n, ChangeEvent.CREATOR);
                    conflictEvent2 = conflictEvent3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    conflictEvent2 = (ConflictEvent) C0211a.m191a(parcel, n, ConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            conflictEvent = conflictEvent2;
        }
        if (parcel.dataPosition() == o) {
            return new OnEventResponse(i2, i, changeEvent, conflictEvent);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OnEventResponse[] av(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m265Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
