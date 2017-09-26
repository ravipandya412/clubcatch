package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0373c;
import com.google.android.gms.maps.internal.C0387q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        er.m725f(context);
        try {
            C0373c A = C0387q.m1139A(context);
            try {
                CameraUpdateFactory.m1119a(A.gY());
                BitmapDescriptorFactory.m1144a(A.gZ());
                return 0;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
            return e2.errorCode;
        }
    }
}
