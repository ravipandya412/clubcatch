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
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.eh.C0674c;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.eh.C0952g;
import com.google.android.gms.internal.je.C0730a;
import com.google.android.gms.internal.jf.C0732a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class jg extends eh<je> {
    private final int Zw;
    private final int mTheme;
    private final Activity nd;
    private final String vi;

    /* renamed from: com.google.android.gms.internal.jg.a */
    final class C0992a extends C0732a {
        private final int Bq;
        final /* synthetic */ jg Zz;

        public C0992a(jg jgVar, int i) {
            this.Zz = jgVar;
            this.Bq = i;
        }

        public void m2781a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.Zz.nd, this.Bq);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.Zz.nd.createPendingResult(this.Bq, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m2782a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.Zz.nd, this.Bq);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.Zz.nd.createPendingResult(this.Bq, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m2783a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.Zz.nd.createPendingResult(this.Bq, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void m2784e(int i, Bundle bundle) {
            er.m723b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.Zz.nd, this.Bq);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.Zz.nd.createPendingResult(this.Bq, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public jg(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.nd = activity;
        this.Zw = i;
        this.vi = str;
        this.mTheme = i2;
    }

    @Deprecated
    public jg(Activity activity, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        this(activity, activity.getMainLooper(), new C0674c(connectionCallbacks), new C0952g(onConnectionFailedListener), i, str, i2);
    }

    private Bundle kx() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.Zw);
        bundle.putString("androidPackageName", this.nd.getPackageName());
        if (!TextUtils.isEmpty(this.vi)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(this.vi, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
        return bundle;
    }

    protected void m2786a(en enVar, C0951e c0951e) throws RemoteException {
        enVar.m691a(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    protected je aE(IBinder iBinder) {
        return C0730a.aC(iBinder);
    }

    protected String aF() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String aG() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void changeMaskedWallet(String googleTransactionId, String merchantTransactionId, int requestCode) {
        Bundle kx = kx();
        Object c0992a = new C0992a(this, requestCode);
        try {
            ((je) eb()).m1007a(googleTransactionId, merchantTransactionId, kx, c0992a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c0992a.m2782a(8, null, null);
        }
    }

    public void checkForPreAuthorization(int requestCode) {
        Bundle kx = kx();
        jf c0992a = new C0992a(this, requestCode);
        try {
            ((je) eb()).m1002a(kx, c0992a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c0992a.m2783a(8, false, null);
        }
    }

    public void loadFullWallet(FullWalletRequest request, int requestCode) {
        jf c0992a = new C0992a(this, requestCode);
        try {
            ((je) eb()).m1003a(request, kx(), c0992a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c0992a.m2781a(8, null, null);
        }
    }

    public void loadMaskedWallet(MaskedWalletRequest request, int requestCode) {
        Bundle kx = kx();
        jf c0992a = new C0992a(this, requestCode);
        try {
            ((je) eb()).m1004a(request, kx, c0992a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c0992a.m2782a(8, null, null);
        }
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest request) {
        try {
            ((je) eb()).m1005a(request, kx());
        } catch (RemoteException e) {
        }
    }

    protected /* synthetic */ IInterface m2787p(IBinder iBinder) {
        return aE(iBinder);
    }
}
