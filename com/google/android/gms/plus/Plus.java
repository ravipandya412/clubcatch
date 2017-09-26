package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.il;
import com.google.android.gms.plus.internal.C0831h;
import com.google.android.gms.plus.internal.C1013e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api API;
    public static final Account AccountApi;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final C0409a QK;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    static final C0191b<C1013e> va;

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C08121 implements C0191b<C1013e> {
        C08121() {
        }

        public /* synthetic */ C0190a m2186b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2187h(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return 2;
        }

        public C1013e m2187h(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            PlusOptions plusOptions;
            PlusOptions plusOptions2 = new PlusOptions();
            if (apiOptions != null) {
                er.m724b(apiOptions instanceof PlusOptions, (Object) "Must provide valid PlusOptions!");
                plusOptions = (PlusOptions) apiOptions;
            } else {
                plusOptions = plusOptions2;
            }
            return new C1013e(context, looper, connectionCallbacks, onConnectionFailedListener, new C0831h(eeVar.dR(), eeVar.dU(), (String[]) plusOptions.QM.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }
    }

    public static final class PlusOptions implements ApiOptions {
        final String QL;
        final Set<String> QM;

        public static final class Builder {
            String QL;
            final Set<String> QM;

            public Builder() {
                this.QM = new HashSet();
            }

            public Builder addActivityTypes(String... activityTypes) {
                er.m723b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.QM.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.QL = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.QL = null;
            this.QM = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.QL = builder.QL;
            this.QM = builder.QM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.a */
    public static abstract class C1009a<R extends Result> extends C0592a<R, C1013e> {
        public C1009a(C0191b<C1013e> c0191b) {
            super(c0191b);
        }
    }

    static {
        va = new C08121();
        API = new Api(va, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new ik(va);
        PeopleApi = new il(va);
        AccountApi = new ii(va);
        QK = new ij(va);
    }

    private Plus() {
    }

    public static C1013e m1178a(GoogleApiClient googleApiClient, C0191b<C1013e> c0191b) {
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
}
