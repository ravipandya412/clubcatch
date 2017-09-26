package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.dn.C0668a;
import com.google.android.gms.internal.eh.C0329b;
import com.google.android.gms.internal.eh.C0675d;
import com.google.android.gms.internal.eh.C0951e;

public final class dl extends eh<dn> {
    private final String vi;

    /* renamed from: com.google.android.gms.internal.dl.h */
    final class C0664h extends C0329b<C0194c<Status>> {
        final /* synthetic */ dl vk;
        private final Status vl;

        public C0664h(dl dlVar, C0194c<Status> c0194c, Status status) {
            this.vk = dlVar;
            super(dlVar, c0194c);
            this.vl = status;
        }

        public /* synthetic */ void m1714a(Object obj) {
            m1715c((C0194c) obj);
        }

        public void m1715c(C0194c<Status> c0194c) {
            c0194c.m147b(this.vl);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.b */
    final class C0946b extends C0329b<C0194c<StateDeletedResult>> implements StateDeletedResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final int vm;

        public C0946b(dl dlVar, C0194c<StateDeletedResult> c0194c, Status status, int i) {
            this.vk = dlVar;
            super(dlVar, c0194c);
            this.vl = status;
            this.vm = i;
        }

        public /* synthetic */ void m2538a(Object obj) {
            m2539c((C0194c) obj);
        }

        public void m2539c(C0194c<StateDeletedResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public int getStateKey() {
            return this.vm;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.d */
    final class C0947d extends C0675d<C0194c<StateListResult>> implements StateListResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final AppStateBuffer vn;

        public C0947d(dl dlVar, C0194c<StateListResult> c0194c, Status status, DataHolder dataHolder) {
            this.vk = dlVar;
            super(dlVar, c0194c, dataHolder);
            this.vl = status;
            this.vn = new AppStateBuffer(dataHolder);
        }

        public void m2540a(C0194c<StateListResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.vn;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.f */
    final class C0948f extends C0675d<C0194c<StateResult>> implements StateConflictResult, StateLoadedResult, StateResult {
        final /* synthetic */ dl vk;
        private final Status vl;
        private final int vm;
        private final AppStateBuffer vn;

        public C0948f(dl dlVar, C0194c<StateResult> c0194c, int i, DataHolder dataHolder) {
            this.vk = dlVar;
            super(dlVar, c0194c, dataHolder);
            this.vm = i;
            this.vl = new Status(dataHolder.getStatusCode());
            this.vn = new AppStateBuffer(dataHolder);
        }

        private boolean cQ() {
            return this.vl.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public void m2542a(C0194c<StateResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public StateConflictResult getConflictResult() {
            return cQ() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return cQ() ? null : this;
        }

        public byte[] getLocalData() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.vn.getCount() == 0 ? null : this.vn.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.vm;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            this.vn.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.a */
    final class C1049a extends dk {
        private final C0194c<StateDeletedResult> vj;
        final /* synthetic */ dl vk;

        public C1049a(dl dlVar, C0194c<StateDeletedResult> c0194c) {
            this.vk = dlVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Result holder must not be null");
        }

        public void m2976b(int i, int i2) {
            this.vk.m1778a(new C0946b(this.vk, this.vj, new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.c */
    final class C1050c extends dk {
        private final C0194c<StateListResult> vj;
        final /* synthetic */ dl vk;

        public C1050c(dl dlVar, C0194c<StateListResult> c0194c) {
            this.vk = dlVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Result holder must not be null");
        }

        public void m2977a(DataHolder dataHolder) {
            this.vk.m1778a(new C0947d(this.vk, this.vj, new Status(dataHolder.getStatusCode()), dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.e */
    final class C1051e extends dk {
        private final C0194c<StateResult> vj;
        final /* synthetic */ dl vk;

        public C1051e(dl dlVar, C0194c<StateResult> c0194c) {
            this.vk = dlVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Result holder must not be null");
        }

        public void m2978a(int i, DataHolder dataHolder) {
            this.vk.m1778a(new C0948f(this.vk, this.vj, i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl.g */
    final class C1052g extends dk {
        C0194c<Status> vj;
        final /* synthetic */ dl vk;

        public C1052g(dl dlVar, C0194c<Status> c0194c) {
            this.vk = dlVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void cM() {
            this.vk.m1778a(new C0664h(this.vk, this.vj, new Status(0)));
        }
    }

    public dl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.vi = (String) er.m725f(str);
    }

    public void m2544a(C0194c<StateListResult> c0194c) {
        try {
            ((dn) eb()).m604a(new C1050c(this, c0194c));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2545a(C0194c<StateDeletedResult> c0194c, int i) {
        try {
            ((dn) eb()).m609b(new C1049a(this, c0194c), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2546a(C0194c<StateResult> c0194c, int i, String str, byte[] bArr) {
        try {
            ((dn) eb()).m606a(new C1051e(this, c0194c), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2547a(C0194c<StateResult> c0194c, int i, byte[] bArr) {
        if (c0194c == null) {
            dm dmVar = null;
        } else {
            Object c1051e = new C1051e(this, c0194c);
        }
        try {
            ((dn) eb()).m607a(dmVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m2548a(en enVar, C0951e c0951e) throws RemoteException {
        enVar.m695a((em) c0951e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.vi, ea());
    }

    protected String aF() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void m2549b(C0194c<Status> c0194c) {
        try {
            ((dn) eb()).m608b(new C1052g(this, c0194c));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m2550b(C0194c<StateResult> c0194c, int i) {
        try {
            ((dn) eb()).m605a(new C1051e(this, c0194c), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m2551b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        er.m721a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    public int cN() {
        try {
            return ((dn) eb()).cN();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int cO() {
        try {
            return ((dn) eb()).cO();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface m2552p(IBinder iBinder) {
        return m2553s(iBinder);
    }

    protected dn m2553s(IBinder iBinder) {
        return C0668a.m1728u(iBinder);
    }
}
