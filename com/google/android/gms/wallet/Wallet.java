package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
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
import com.google.android.gms.internal.jg;

public final class Wallet {
    public static final Api API;
    static final C0191b<jg> va;

    /* renamed from: com.google.android.gms.wallet.Wallet.1 */
    static class C08731 implements C0191b<jg> {
        C08731() {
        }

        public /* synthetic */ C0190a m2367b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2368i(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public jg m2368i(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            er.m724b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            boolean z = apiOptions == null || (apiOptions instanceof WalletOptions);
            er.m724b(z, (Object) "WalletOptions must be used for Wallet APIs");
            WalletOptions walletOptions = apiOptions != null ? (WalletOptions) apiOptions : new WalletOptions();
            return new jg(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, eeVar.getAccountName(), walletOptions.theme);
        }
    }

    public static final class WalletOptions implements ApiOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int Zw;
            private int mTheme;

            public Builder() {
                this.Zw = 0;
                this.mTheme = 0;
            }

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.Zw = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format("Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format("Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.Zw;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.a */
    private static abstract class C1018a extends C0592a<Status, jg> {
        public C1018a() {
            super(Wallet.va);
        }

        public /* synthetic */ Result m2888d(Status status) {
            return m2889f(status);
        }

        public Status m2889f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.2 */
    static class C11012 extends C1018a {
        final /* synthetic */ int Kx;

        C11012(int i) {
            this.Kx = i;
        }

        protected void m3110a(jg jgVar) {
            jgVar.checkForPreAuthorization(this.Kx);
            m1514a(Status.zQ);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.3 */
    static class C11023 extends C1018a {
        final /* synthetic */ int Kx;
        final /* synthetic */ MaskedWalletRequest Zr;

        C11023(MaskedWalletRequest maskedWalletRequest, int i) {
            this.Zr = maskedWalletRequest;
            this.Kx = i;
        }

        protected void m3112a(jg jgVar) {
            jgVar.loadMaskedWallet(this.Zr, this.Kx);
            m1514a(Status.zQ);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.4 */
    static class C11034 extends C1018a {
        final /* synthetic */ int Kx;
        final /* synthetic */ FullWalletRequest Zs;

        C11034(FullWalletRequest fullWalletRequest, int i) {
            this.Zs = fullWalletRequest;
            this.Kx = i;
        }

        protected void m3114a(jg jgVar) {
            jgVar.loadFullWallet(this.Zs, this.Kx);
            m1514a(Status.zQ);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.5 */
    static class C11045 extends C1018a {
        final /* synthetic */ int Kx;
        final /* synthetic */ String Zt;
        final /* synthetic */ String Zu;

        C11045(String str, String str2, int i) {
            this.Zt = str;
            this.Zu = str2;
            this.Kx = i;
        }

        protected void m3116a(jg jgVar) {
            jgVar.changeMaskedWallet(this.Zt, this.Zu, this.Kx);
            m1514a(Status.zQ);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet.6 */
    static class C11056 extends C1018a {
        final /* synthetic */ NotifyTransactionStatusRequest Zv;

        C11056(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.Zv = notifyTransactionStatusRequest;
        }

        protected void m3118a(jg jgVar) {
            jgVar.notifyTransactionStatus(this.Zv);
            m1514a(Status.zQ);
        }
    }

    static {
        va = new C08731();
        API = new Api(va, new Scope[0]);
    }

    private Wallet() {
    }

    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        googleApiClient.m140a(new C11045(googleTransactionId, merchantTransactionId, requestCode));
    }

    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.m140a(new C11012(requestCode));
    }

    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        googleApiClient.m140a(new C11034(request, requestCode));
    }

    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        googleApiClient.m140a(new C11023(request, requestCode));
    }

    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        googleApiClient.m140a(new C11056(request));
    }
}
