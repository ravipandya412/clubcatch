package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0602l;
import com.google.android.gms.drive.internal.C0603p;
import com.google.android.gms.drive.internal.C0906n;
import com.google.android.gms.internal.ee;
import java.util.List;

public final class Drive {
    public static final Api API;
    public static final Scope Da;
    public static final C0215c Db;
    public static final DriveApi DriveApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final C0191b<C0906n> va;

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C06011 implements C0191b<C0906n> {
        C06011() {
        }

        public /* synthetic */ C0190a m1551b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1552d(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public C0906n m1552d(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List dT = eeVar.dT();
            return new C0906n(context, looper, eeVar, connectionCallbacks, onConnectionFailedListener, (String[]) dT.toArray(new String[dT.size()]));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    static {
        va = new C06011();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        Da = new Scope(Scopes.DRIVE_FULL);
        API = new Api(va, new Scope[0]);
        DriveApi = new C0602l();
        Db = new C0603p();
    }

    private Drive() {
    }
}
