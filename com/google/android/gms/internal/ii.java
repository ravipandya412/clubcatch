package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus.C1009a;
import com.google.android.gms.plus.internal.C1013e;

public final class ii implements Account {
    private final C0191b<C1013e> Rw;

    /* renamed from: com.google.android.gms.internal.ii.a */
    private static abstract class C1088a extends C1009a<Status> {
        C1088a(C0191b<C1013e> c0191b) {
            super(c0191b);
        }

        public /* synthetic */ Result m3079d(Status status) {
            return m3080f(status);
        }

        public Status m3080f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ii.1 */
    class C11821 extends C1088a {
        final /* synthetic */ ii Rx;

        C11821(ii iiVar, C0191b c0191b) {
            this.Rx = iiVar;
            super(c0191b);
        }

        protected void m3286a(C1013e c1013e) {
            c1013e.m2844k(this);
        }
    }

    public ii(C0191b<C1013e> c0191b) {
        this.Rw = c0191b;
    }

    private static C1013e m2101a(GoogleApiClient googleApiClient, C0191b<C1013e> c0191b) {
        boolean z = true;
        er.m724b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m721a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1013e c1013e = (C1013e) googleApiClient.m139a((C0191b) c0191b);
        if (c1013e == null) {
            z = false;
        }
        er.m721a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1013e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m2101a(googleApiClient, this.Rw).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m2101a(googleApiClient, this.Rw).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.m141b(new C11821(this, this.Rw));
    }
}
