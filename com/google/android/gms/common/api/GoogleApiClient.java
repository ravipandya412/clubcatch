package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public interface ApiOptions {
    }

    public static final class Builder {
        private final Context mContext;
        private String vi;
        private final Set<String> zn;
        private int zo;
        private View zp;
        private String zq;
        private final Map<Api, ApiOptions> zr;
        private Looper zs;
        private final Set<ConnectionCallbacks> zt;
        private final Set<OnConnectionFailedListener> zu;

        public Builder(Context context) {
            this.zn = new HashSet();
            this.zr = new HashMap();
            this.zt = new HashSet();
            this.zu = new HashSet();
            this.mContext = context;
            this.zs = context.getMainLooper();
            this.zq = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            er.m723b((Object) connectedListener, (Object) "Must provide a connected listener");
            this.zt.add(connectedListener);
            er.m723b((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zu.add(connectionFailedListener);
        }

        public Builder addApi(Api api) {
            return addApi(api, null);
        }

        public Builder addApi(Api api, ApiOptions options) {
            this.zr.put(api, options);
            List dq = api.dq();
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                this.zn.add(((Scope) dq.get(i)).dD());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.zt.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.zu.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.zn.add(scope.dD());
            return this;
        }

        public GoogleApiClient build() {
            return new C0596b(this.mContext, this.zs, dx(), this.zr, this.zt, this.zu);
        }

        public ee dx() {
            return new ee(this.vi, this.zn, this.zo, this.zp, this.zq);
        }

        public Builder setAccountName(String accountName) {
            this.vi = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zo = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            er.m723b((Object) handler, (Object) "Handler must not be null");
            this.zs = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.zp = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
    }

    <C extends C0190a> C m139a(C0191b<C> c0191b);

    <A extends C0190a, T extends C0592a<? extends Result, A>> T m140a(T t);

    <A extends C0190a, T extends C0592a<? extends Result, A>> T m141b(T t);

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
