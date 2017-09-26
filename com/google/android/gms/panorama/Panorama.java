package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ih;

public final class Panorama {
    public static final Api API;
    static final C0191b<ih> va;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C08091 implements C0191b<ih> {
        C08091() {
        }

        public /* synthetic */ C0190a m2180b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2181g(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public ih m2181g(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ih(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface PanoramaResult extends Result {
        Intent getViewerIntent();
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.a */
    public interface C1006a extends PanoramaResult {
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.b */
    private static abstract class C1008b extends C0592a<PanoramaResult, ih> {

        /* renamed from: com.google.android.gms.panorama.Panorama.b.1 */
        class C10071 implements PanoramaResult {
            final /* synthetic */ C1008b QA;
            final /* synthetic */ Status vb;

            C10071(C1008b c1008b, Status status) {
                this.QA = c1008b;
                this.vb = status;
            }

            public Status getStatus() {
                return this.vb;
            }

            public Intent getViewerIntent() {
                return null;
            }
        }

        public C1008b() {
            super(Panorama.va);
        }

        public PanoramaResult m2820J(Status status) {
            return new C10071(this, status);
        }

        public /* synthetic */ Result m2821d(Status status) {
            return m2820J(status);
        }
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.2 */
    static class C10942 extends C1008b {
        final /* synthetic */ Uri Qz;

        C10942(Uri uri) {
            this.Qz = uri;
        }

        protected void m3093a(ih ihVar) {
            ihVar.m2734a(this, this.Qz, false);
        }
    }

    /* renamed from: com.google.android.gms.panorama.Panorama.3 */
    static class C10953 extends C1008b {
        final /* synthetic */ Uri Qz;

        C10953(Uri uri) {
            this.Qz = uri;
        }

        protected void m3095a(ih ihVar) {
            ihVar.m2734a(this, this.Qz, true);
        }
    }

    static {
        va = new C08091();
        API = new Api(va, new Scope[0]);
    }

    private Panorama() {
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, Uri uri) {
        return client.m140a(new C10942(uri));
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, Uri uri) {
        return client.m140a(new C10953(uri));
    }
}
