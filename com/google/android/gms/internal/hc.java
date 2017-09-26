package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.hd.C0711a;
import com.google.android.gms.internal.he.C0713a;

public class hc extends eh<he> {
    private C0974a KA;
    private final int mTheme;
    private Activity nd;
    private final String vi;

    /* renamed from: com.google.android.gms.internal.hc.a */
    public static final class C0974a extends C0711a {
        private final int Bq;
        private Activity nd;

        public C0974a(int i, Activity activity) {
            this.Bq = i;
            this.nd = activity;
        }

        private void setActivity(Activity activity) {
            this.nd = activity;
        }

        public void m2721c(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.nd.createPendingResult(this.Bq, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.nd, this.Bq);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.nd.createPendingResult(this.Bq, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public hc(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.vi = str;
        this.nd = activity;
        this.mTheme = i;
    }

    protected he m2722K(IBinder iBinder) {
        return C0713a.m2054M(iBinder);
    }

    public void m2723a(UserAddressRequest userAddressRequest, int i) {
        Bundle bundle;
        gj();
        this.KA = new C0974a(i, this.nd);
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.vi)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.vi, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            gi().m956a(this.KA, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.KA.m2721c(1, bundle);
        }
    }

    protected void m2724a(en enVar, C0951e c0951e) throws RemoteException {
        enVar.m703d(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected String aF() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String aG() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.KA != null) {
            this.KA.setActivity(null);
            this.KA = null;
        }
    }

    protected he gi() {
        return (he) super.eb();
    }

    protected void gj() {
        super.bm();
    }

    protected /* synthetic */ IInterface m2725p(IBinder iBinder) {
        return m2722K(iBinder);
    }
}
