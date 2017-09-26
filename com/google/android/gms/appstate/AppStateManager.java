package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;

public final class AppStateManager {
    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final C0191b<dl> va;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C05861 implements C0191b<dl> {
        C05861() {
        }

        public dl m1497a(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new dl(context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.dR(), (String[]) eeVar.dT().toArray(new String[0]));
        }

        public /* synthetic */ C0190a m1498b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1497a(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C08852 implements StateResult {
        final /* synthetic */ Status vb;

        C08852(Status status) {
            this.vb = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.vb;
        }

        public void release() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.a */
    public static abstract class C0887a<R extends Result> extends C0592a<R, dl> implements PendingResult<R> {
        public C0887a() {
            super(AppStateManager.va);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.b */
    private static abstract class C1019b extends C0887a<StateDeletedResult> {
        private C1019b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.c */
    private static abstract class C1020c extends C0887a<StateListResult> {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.c.1 */
        class C08881 implements StateListResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C1020c vh;

            C08881(C1020c c1020c, Status status) {
                this.vh = c1020c;
                this.vb = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1020c() {
        }

        public /* synthetic */ Result m2890d(Status status) {
            return m2891e(status);
        }

        public StateListResult m2891e(Status status) {
            return new C08881(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.d */
    private static abstract class C1021d extends C0887a<Status> {
        private C1021d() {
        }

        public /* synthetic */ Result m2892d(Status status) {
            return m2893f(status);
        }

        public Status m2893f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.e */
    private static abstract class C1022e extends C0887a<StateResult> {
        private C1022e() {
        }

        public /* synthetic */ Result m2894d(Status status) {
            return m2895g(status);
        }

        public StateResult m2895g(Status status) {
            return AppStateManager.m90a(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C11063 extends C1022e {
        final /* synthetic */ int vc;
        final /* synthetic */ byte[] vd;

        C11063(int i, byte[] bArr) {
            this.vc = i;
            this.vd = bArr;
            super();
        }

        protected void m3120a(dl dlVar) {
            dlVar.m2547a(null, this.vc, this.vd);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C11074 extends C1022e {
        final /* synthetic */ int vc;
        final /* synthetic */ byte[] vd;

        C11074(int i, byte[] bArr) {
            this.vc = i;
            this.vd = bArr;
            super();
        }

        protected void m3122a(dl dlVar) {
            dlVar.m2547a(this, this.vc, this.vd);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C11085 extends C1019b {
        final /* synthetic */ int vc;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C08861 implements StateDeletedResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C11085 ve;

            C08861(C11085 c11085, Status status) {
                this.ve = c11085;
                this.vb = status;
            }

            public int getStateKey() {
                return this.ve.vc;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        C11085(int i) {
            this.vc = i;
            super();
        }

        protected void m3124a(dl dlVar) {
            dlVar.m2545a((C0194c) this, this.vc);
        }

        public StateDeletedResult m3125c(Status status) {
            return new C08861(this, status);
        }

        public /* synthetic */ Result m3126d(Status status) {
            return m3125c(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C11096 extends C1022e {
        final /* synthetic */ int vc;

        C11096(int i) {
            this.vc = i;
            super();
        }

        protected void m3128a(dl dlVar) {
            dlVar.m2550b(this, this.vc);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C11107 extends C1020c {
        C11107() {
            super();
        }

        protected void m3130a(dl dlVar) {
            dlVar.m2544a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C11118 extends C1022e {
        final /* synthetic */ int vc;
        final /* synthetic */ String vf;
        final /* synthetic */ byte[] vg;

        C11118(int i, String str, byte[] bArr) {
            this.vc = i;
            this.vf = str;
            this.vg = bArr;
            super();
        }

        protected void m3132a(dl dlVar) {
            dlVar.m2546a(this, this.vc, this.vf, this.vg);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C11129 extends C1021d {
        C11129() {
            super();
        }

        protected void m3134a(dl dlVar) {
            dlVar.m2549b((C0194c) this);
        }
    }

    static {
        va = new C05861();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api(va, SCOPE_APP_STATE);
    }

    private AppStateManager() {
    }

    private static StateResult m90a(Status status) {
        return new C08852(status);
    }

    public static dl m91a(GoogleApiClient googleApiClient) {
        boolean z = true;
        er.m724b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m721a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        dl dlVar = (dl) googleApiClient.m139a(va);
        if (dlVar == null) {
            z = false;
        }
        er.m721a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return dlVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m141b(new C11085(stateKey));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m91a(googleApiClient).cO();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m91a(googleApiClient).cN();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.m140a(new C11107());
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m140a(new C11096(stateKey));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int stateKey, String resolvedVersion, byte[] resolvedData) {
        return googleApiClient.m141b(new C11118(stateKey, resolvedVersion, resolvedData));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m141b(new C11129());
    }

    public static void update(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        googleApiClient.m141b(new C11063(stateKey, data));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        return googleApiClient.m141b(new C11074(stateKey, data));
    }
}
