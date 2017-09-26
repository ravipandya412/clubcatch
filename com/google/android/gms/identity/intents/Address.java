package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.hc;

public final class Address {
    public static final Api API;
    static final C0191b<hc> va;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C06311 implements C0191b<hc> {
        C06311() {
        }

        public /* synthetic */ C0190a m1631b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1632f(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public hc m1632f(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            AddressOptions addressOptions;
            er.m724b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            AddressOptions addressOptions2 = new AddressOptions();
            if (apiOptions != null) {
                er.m724b(apiOptions instanceof AddressOptions, (Object) "Must use AddressOptions with Address API");
                addressOptions = (AddressOptions) apiOptions;
            } else {
                addressOptions = addressOptions2;
            }
            return new hc((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class AddressOptions implements ApiOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.a */
    private static abstract class C0932a extends C0592a<Status, hc> {
        public C0932a() {
            super(Address.va);
        }

        public /* synthetic */ Result m2442d(Status status) {
            return m2443f(status);
        }

        public Status m2443f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C10482 extends C0932a {
        final /* synthetic */ UserAddressRequest Kw;
        final /* synthetic */ int Kx;

        C10482(UserAddressRequest userAddressRequest, int i) {
            this.Kw = userAddressRequest;
            this.Kx = i;
        }

        protected void m2975a(hc hcVar) throws RemoteException {
            hcVar.m2723a(this.Kw, this.Kx);
            m1514a(Status.zQ);
        }
    }

    static {
        va = new C06311();
        API = new Api(va, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.m140a(new C10482(request, requestCode));
    }
}
