package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
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
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import java.io.IOException;

public final class Cast {
    public static final Api API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C0191b<dq> va;

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast.CastApi.a */
        public static final class C0588a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.1 */
            class C11131 extends C1023b {
                final /* synthetic */ String wp;
                final /* synthetic */ String wq;
                final /* synthetic */ C0588a wr;

                C11131(C0588a c0588a, String str, String str2) {
                    this.wr = c0588a;
                    this.wp = str;
                    this.wq = str2;
                    super();
                }

                protected void m3136a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2589a(this.wp, this.wq, (C0194c) this);
                    } catch (IllegalArgumentException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    } catch (IllegalStateException e2) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.2 */
            class C11142 extends C1024c {
                final /* synthetic */ C0588a wr;
                final /* synthetic */ String ws;

                C11142(C0588a c0588a, String str) {
                    this.wr = c0588a;
                    this.ws = str;
                    super();
                }

                protected void m3138a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2590a(this.ws, false, (C0194c) this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.3 */
            class C11153 extends C1024c {
                final /* synthetic */ C0588a wr;
                final /* synthetic */ String ws;
                final /* synthetic */ boolean wt;

                C11153(C0588a c0588a, String str, boolean z) {
                    this.wr = c0588a;
                    this.ws = str;
                    this.wt = z;
                    super();
                }

                protected void m3140a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2590a(this.ws, this.wt, (C0194c) this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.4 */
            class C11164 extends C1024c {
                final /* synthetic */ C0588a wr;
                final /* synthetic */ String ws;
                final /* synthetic */ String wu;

                C11164(C0588a c0588a, String str, String str2) {
                    this.wr = c0588a;
                    this.ws = str;
                    this.wu = str2;
                    super();
                }

                protected void m3142a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2591b(this.ws, this.wu, this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.5 */
            class C11175 extends C1024c {
                final /* synthetic */ C0588a wr;
                final /* synthetic */ String ws;

                C11175(C0588a c0588a, String str) {
                    this.wr = c0588a;
                    this.ws = str;
                    super();
                }

                protected void m3144a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2591b(this.ws, null, this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.6 */
            class C11186 extends C1024c {
                final /* synthetic */ C0588a wr;

                C11186(C0588a c0588a) {
                    this.wr = c0588a;
                    super();
                }

                protected void m3146a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2591b(null, null, this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.7 */
            class C11197 extends C1023b {
                final /* synthetic */ C0588a wr;

                C11197(C0588a c0588a) {
                    this.wr = c0588a;
                    super();
                }

                protected void m3148a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2592e((C0194c) this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.8 */
            class C11208 extends C1023b {
                final /* synthetic */ C0588a wr;

                C11208(C0588a c0588a) {
                    this.wr = c0588a;
                    super();
                }

                protected void m3150a(dq dqVar) throws RemoteException {
                    try {
                        dqVar.m2588a("", (C0194c) this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.9 */
            class C11219 extends C1023b {
                final /* synthetic */ C0588a wr;
                final /* synthetic */ String wu;

                C11219(C0588a c0588a, String str) {
                    this.wr = c0588a;
                    this.wu = str;
                    super();
                }

                protected void m3152a(dq dqVar) throws RemoteException {
                    if (TextUtils.isEmpty(this.wu)) {
                        m2378c(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        dqVar.m2588a(this.wu, (C0194c) this);
                    } catch (IllegalStateException e) {
                        m2379x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m139a(Cast.va)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m139a(Cast.va)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m139a(Cast.va)).da();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((dq) client.m139a(Cast.va)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.m141b(new C11186(this));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return client.m141b(new C11175(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return client.m141b(new C11164(this, applicationId, sessionId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId) {
                return client.m141b(new C11142(this, applicationId));
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return client.m141b(new C11153(this, applicationId, relaunchIfRunning));
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.m141b(new C11197(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((dq) client.m139a(Cast.va)).m2583Q(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m139a(Cast.va)).cZ();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, String namespace, String message) {
                return client.m141b(new C11131(this, namespace, message));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m139a(Cast.va)).m2587a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((dq) client.m139a(Cast.va)).m2594t(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((dq) client.m139a(Cast.va)).m2584a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.m141b(new C11208(this));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, String sessionId) {
                return client.m141b(new C11219(this, sessionId));
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static abstract class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C05871 implements C0191b<dq> {
        C05871() {
        }

        public /* synthetic */ C0190a m1499b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1500c(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public dq m1500c(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            er.m723b((Object) apiOptions, (Object) "Setting the API options is required.");
            er.m724b(apiOptions instanceof CastOptions, (Object) "Must provide valid CastOptions!");
            CastOptions castOptions = (CastOptions) apiOptions;
            return new dq(context, looper, castOptions.wv, (long) castOptions.wx, castOptions.ww, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements ApiOptions {
        final CastDevice wv;
        final Listener ww;
        private final int wx;

        public static final class Builder {
            private int wA;
            CastDevice wy;
            Listener wz;

            private Builder(CastDevice castDevice, Listener castListener) {
                er.m723b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                er.m723b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.wy = castDevice;
                this.wz = castListener;
                this.wA = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.wA |= 1;
                } else {
                    this.wA &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.wv = builder.wy;
            this.ww = builder.wz;
            this.wx = builder.wA;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castListener, null);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.a */
    protected static abstract class C0891a<R extends Result> extends C0592a<R, dq> implements PendingResult<R> {
        public C0891a() {
            super(Cast.va);
        }

        public void m2378c(int i, String str) {
            m1514a(m1518d(new Status(i, str, null)));
        }

        public void m2379x(int i) {
            m1514a(m1518d(new Status(i)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.b */
    private static abstract class C1023b extends C0891a<Status> {
        private C1023b() {
        }

        public /* synthetic */ Result m2896d(Status status) {
            return m2897f(status);
        }

        public Status m2897f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.c */
    private static abstract class C1024c extends C0891a<ApplicationConnectionResult> {

        /* renamed from: com.google.android.gms.cast.Cast.c.1 */
        class C08921 implements ApplicationConnectionResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C1024c wB;

            C08921(C1024c c1024c, Status status) {
                this.wB = c1024c;
                this.vb = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        private C1024c() {
        }

        public /* synthetic */ Result m2898d(Status status) {
            return m2899h(status);
        }

        public ApplicationConnectionResult m2899h(Status status) {
            return new C08921(this, status);
        }
    }

    static {
        va = new C05871();
        API = new Api(va, new Scope[0]);
        CastApi = new C0588a();
    }

    private Cast() {
    }
}
