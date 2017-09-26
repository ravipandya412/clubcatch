package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0219c;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0232u.C0606a;
import com.google.android.gms.drive.internal.C0602l.C1032j;
import com.google.android.gms.drive.internal.C0602l.C1135k;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0906n extends eh<C0232u> {
    private DriveId DA;
    final ConnectionCallbacks DB;
    Map<DriveId, Map<Listener<?>, C0912s<?>>> DC;
    private DriveId Dz;
    private final String vi;

    /* renamed from: com.google.android.gms.drive.internal.n.1 */
    class C11361 extends C1032j {
        final /* synthetic */ DriveId DD;
        final /* synthetic */ int DE;
        final /* synthetic */ C0912s DF;
        final /* synthetic */ C0906n DG;

        C11361(C0906n c0906n, DriveId driveId, int i, C0912s c0912s) {
            this.DG = c0906n;
            this.DD = driveId;
            this.DE = i;
            this.DF = c0912s;
        }

        protected void m3182a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m305a(new AddEventListenerRequest(this.DD, this.DE), this.DF, null, new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.n.2 */
    class C11372 extends C1032j {
        final /* synthetic */ DriveId DD;
        final /* synthetic */ int DE;
        final /* synthetic */ C0912s DF;
        final /* synthetic */ C0906n DG;

        C11372(C0906n c0906n, DriveId driveId, int i, C0912s c0912s) {
            this.DG = c0906n;
            this.DD = driveId;
            this.DE = i;
            this.DF = c0912s;
        }

        protected void m3184a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m317a(new RemoveEventListenerRequest(this.DD, this.DE), this.DF, null, new ak(this));
        }
    }

    public C0906n(Context context, Looper looper, ee eeVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DC = new HashMap();
        this.vi = (String) er.m723b(eeVar.dR(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.DB = connectionCallbacks;
    }

    protected C0232u m2391C(IBinder iBinder) {
        return C0606a.m1573D(iBinder);
    }

    <C extends DriveEvent> PendingResult<Status> m2392a(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<C> listener) {
        PendingResult<Status> c1135k;
        er.m724b(C0219c.m257a(i, driveId), (Object) "id");
        er.m723b((Object) listener, (Object) "listener");
        er.m721a(isConnected(), "Client must be connected");
        synchronized (this.DC) {
            Map map = (Map) this.DC.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.DC.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1135k = new C1135k(Status.zQ);
            } else {
                C0912s c0912s = new C0912s(getLooper(), i, listener);
                map.put(listener, c0912s);
                c1135k = googleApiClient.m141b(new C11361(this, driveId, i, c0912s));
            }
        }
        return c1135k;
    }

    protected void m2393a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Dz = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.DA = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.m1777a(i, iBinder, bundle);
    }

    protected void m2394a(en enVar, C0951e c0951e) throws RemoteException {
        String packageName = getContext().getPackageName();
        er.m725f(c0951e);
        er.m725f(packageName);
        er.m725f(ea());
        enVar.m698a(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, ea(), this.vi, new Bundle());
    }

    protected String aF() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String aG() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult<Status> m2395b(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener<?> listener) {
        PendingResult<Status> c1135k;
        er.m724b(C0219c.m257a(i, driveId), (Object) "id");
        er.m723b((Object) listener, (Object) "listener");
        er.m721a(isConnected(), "Client must be connected");
        synchronized (this.DC) {
            Map map = (Map) this.DC.get(driveId);
            if (map == null) {
                c1135k = new C1135k(Status.zQ);
            } else {
                C0912s c0912s = (C0912s) map.remove(listener);
                if (c0912s == null) {
                    c1135k = new C1135k(Status.zQ);
                } else {
                    if (map.isEmpty()) {
                        this.DC.remove(driveId);
                    }
                    c1135k = googleApiClient.m141b(new C11372(this, driveId, i, c0912s));
                }
            }
        }
        return c1135k;
    }

    public void disconnect() {
        C0232u c0232u = (C0232u) eb();
        if (c0232u != null) {
            try {
                c0232u.m312a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.DC.clear();
    }

    public C0232u eT() {
        return (C0232u) eb();
    }

    public DriveId eU() {
        return this.Dz;
    }

    public DriveId eV() {
        return this.DA;
    }

    protected /* synthetic */ IInterface m2396p(IBinder iBinder) {
        return m2391C(iBinder);
    }
}
