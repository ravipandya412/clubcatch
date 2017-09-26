package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api {
    private final C0191b<?> za;
    private final ArrayList<Scope> zb;

    /* renamed from: com.google.android.gms.common.api.Api.a */
    public interface C0190a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api.b */
    public interface C0191b<T extends C0190a> {
        T m138b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public Api(C0191b<?> ClientBuilder, Scope... impliedScopes) {
        this.za = ClientBuilder;
        this.zb = new ArrayList(Arrays.asList(impliedScopes));
    }

    public C0191b<?> dp() {
        return this.za;
    }

    public List<Scope> dq() {
        return this.zb;
    }
}
