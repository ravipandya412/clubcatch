package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eh.C0329b;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.hf.C0715a;
import com.google.android.gms.internal.hg.C0717a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;
import java.util.Locale;

public class hi extends eh<hg> {
    private final hl<hg> Lk;
    private final hh Lq;
    private final ib Lr;
    private final String Ls;
    private final String vi;

    /* renamed from: com.google.android.gms.internal.hi.a */
    private final class C0718a extends C0329b<OnAddGeofencesResultListener> {
        private final String[] Lt;
        final /* synthetic */ hi Lu;
        private final int yJ;

        public C0718a(hi hiVar, OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            this.Lu = hiVar;
            super(hiVar, onAddGeofencesResultListener);
            this.yJ = LocationStatusCodes.bl(i);
            this.Lt = strArr;
        }

        protected void m2077a(OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.yJ, this.Lt);
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.hi.c */
    private final class C0719c implements hl<hg> {
        final /* synthetic */ hi Lu;

        private C0719c(hi hiVar) {
            this.Lu = hiVar;
        }

        public void bm() {
            this.Lu.bm();
        }

        public /* synthetic */ IInterface eb() {
            return gm();
        }

        public hg gm() {
            return (hg) this.Lu.eb();
        }
    }

    /* renamed from: com.google.android.gms.internal.hi.d */
    private final class C0720d extends C0329b<OnRemoveGeofencesResultListener> {
        private final String[] Lt;
        final /* synthetic */ hi Lu;
        private final int Ly;
        private final PendingIntent mPendingIntent;
        private final int yJ;

        public C0720d(hi hiVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.Lu = hiVar;
            super(hiVar, onRemoveGeofencesResultListener);
            if (i != 1) {
                z = false;
            }
            ed.m666v(z);
            this.Ly = i;
            this.yJ = LocationStatusCodes.bl(i2);
            this.mPendingIntent = pendingIntent;
            this.Lt = null;
        }

        public C0720d(hi hiVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            this.Lu = hiVar;
            super(hiVar, onRemoveGeofencesResultListener);
            ed.m666v(i == 2);
            this.Ly = i;
            this.yJ = LocationStatusCodes.bl(i2);
            this.Lt = strArr;
            this.mPendingIntent = null;
        }

        protected void m2079a(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.Ly) {
                    case SpinnerCompat.MODE_DROPDOWN /*1*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.yJ, this.mPendingIntent);
                    case DetectedActivity.ON_FOOT /*2*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.yJ, this.Lt);
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.Ly);
                }
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.hi.b */
    private static final class C0976b extends C0715a {
        private OnAddGeofencesResultListener Lv;
        private OnRemoveGeofencesResultListener Lw;
        private hi Lx;

        public C0976b(OnAddGeofencesResultListener onAddGeofencesResultListener, hi hiVar) {
            this.Lv = onAddGeofencesResultListener;
            this.Lw = null;
            this.Lx = hiVar;
        }

        public C0976b(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, hi hiVar) {
            this.Lw = onRemoveGeofencesResultListener;
            this.Lv = null;
            this.Lx = hiVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.Lx == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            hi hiVar = this.Lx;
            hi hiVar2 = this.Lx;
            hiVar2.getClass();
            hiVar.m1778a(new C0718a(hiVar2, this.Lv, statusCode, geofenceRequestIds));
            this.Lx = null;
            this.Lv = null;
            this.Lw = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.Lx == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            hi hiVar = this.Lx;
            hi hiVar2 = this.Lx;
            hiVar2.getClass();
            hiVar.m1778a(new C0720d(hiVar2, 1, this.Lw, statusCode, pendingIntent));
            this.Lx = null;
            this.Lv = null;
            this.Lw = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.Lx == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            hi hiVar = this.Lx;
            hi hiVar2 = this.Lx;
            hiVar2.getClass();
            hiVar.m1778a(new C0720d(hiVar2, 2, this.Lw, statusCode, geofenceRequestIds));
            this.Lx = null;
            this.Lv = null;
            this.Lw = null;
        }
    }

    public hi(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.Lk = new C0719c();
        this.Lq = new hh(context, this.Lk);
        this.Ls = str;
        this.vi = null;
        this.Lr = new ib(getContext(), Locale.getDefault(), this.Lk);
    }

    protected hg m2728Q(IBinder iBinder) {
        return C0717a.m2076P(iBinder);
    }

    protected void m2729a(en enVar, C0951e c0951e) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.Ls);
        enVar.m705e(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    protected String aF() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String aG() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void addGeofences(List<hj> geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) {
        bm();
        boolean z = geofences != null && geofences.size() > 0;
        er.m724b(z, (Object) "At least one geofence must be specified.");
        er.m723b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        er.m723b((Object) listener, (Object) "OnAddGeofencesResultListener not provided.");
        if (listener == null) {
            hf hfVar = null;
        } else {
            Object c0976b = new C0976b(listener, this);
        }
        try {
            ((hg) eb()).m974a((List) geofences, pendingIntent, hfVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void disconnect() {
        synchronized (this.Lq) {
            if (isConnected()) {
                this.Lq.removeAllListeners();
                this.Lq.gl();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.Lq.getLastLocation();
    }

    protected /* synthetic */ IInterface m2730p(IBinder iBinder) {
        return m2728Q(iBinder);
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        bm();
        er.m725f(callbackIntent);
        try {
            ((hg) eb()).removeActivityUpdates(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) {
        bm();
        er.m723b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        er.m723b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (listener == null) {
            hf hfVar = null;
        } else {
            Object c0976b = new C0976b(listener, this);
        }
        try {
            ((hg) eb()).m959a(pendingIntent, hfVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List<String> geofenceRequestIds, OnRemoveGeofencesResultListener listener) {
        bm();
        boolean z = geofenceRequestIds != null && geofenceRequestIds.size() > 0;
        er.m724b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        er.m723b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) geofenceRequestIds.toArray(new String[0]);
        if (listener == null) {
            hf hfVar = null;
        } else {
            Object c0976b = new C0976b(listener, this);
        }
        try {
            ((hg) eb()).m975a(strArr, hfVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Lq.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Lq.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        boolean z = true;
        bm();
        er.m725f(callbackIntent);
        if (detectionIntervalMillis < 0) {
            z = false;
        }
        er.m724b(z, (Object) "detectionIntervalMillis must be >= 0");
        try {
            ((hg) eb()).m957a(detectionIntervalMillis, true, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Lq.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        synchronized (this.Lq) {
            this.Lq.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Lq.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) {
        this.Lq.setMockMode(isMockMode);
    }
}
