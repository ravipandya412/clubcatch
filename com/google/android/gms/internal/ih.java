package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0350if.C0726a;
import com.google.android.gms.internal.eh.C0329b;
import com.google.android.gms.internal.eh.C0674c;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.eh.C0952g;
import com.google.android.gms.internal.ig.C0728a;
import com.google.android.gms.panorama.Panorama.C1006a;
import com.google.android.gms.panorama.Panorama.PanoramaResult;

public class ih extends eh<ig> {

    /* renamed from: com.google.android.gms.internal.ih.b */
    final class C0977b extends C0726a {
        final /* synthetic */ ih QG;
        private final C0194c<C1006a> QH;
        private final C0194c<PanoramaResult> QI;
        private final Uri QJ;

        public C0977b(ih ihVar, C0194c<C1006a> c0194c, C0194c<PanoramaResult> c0194c2, Uri uri) {
            this.QG = ihVar;
            this.QH = c0194c;
            this.QI = c0194c2;
            this.QJ = uri;
        }

        public void m2731a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.QJ != null) {
                this.QG.getContext().revokeUriPermission(this.QJ, 1);
            }
            Status status = new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.QI != null) {
                this.QG.m1778a(new C0978c(this.QG, this.QI, status, intent));
            } else if (this.QH != null) {
                this.QG.m1778a(new C1087a(this.QG, this.QH, status, i2, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.c */
    final class C0978c extends C0329b<C0194c<PanoramaResult>> implements PanoramaResult {
        private final Status QE;
        private final Intent QF;
        final /* synthetic */ ih QG;

        public C0978c(ih ihVar, C0194c<PanoramaResult> c0194c, Status status, Intent intent) {
            this.QG = ihVar;
            super(ihVar, c0194c);
            this.QE = status;
            this.QF = intent;
        }

        protected /* synthetic */ void m2732a(Object obj) {
            m2733c((C0194c) obj);
        }

        protected void m2733c(C0194c<PanoramaResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public Status getStatus() {
            return this.QE;
        }

        public Intent getViewerIntent() {
            return this.QF;
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.a */
    final class C1087a extends C0329b<C0194c<C1006a>> implements C1006a {
        public final Status QE;
        public final Intent QF;
        final /* synthetic */ ih QG;
        public final int type;

        public C1087a(ih ihVar, C0194c<C1006a> c0194c, Status status, int i, Intent intent) {
            this.QG = ihVar;
            super(ihVar, c0194c);
            this.QE = status;
            this.type = i;
            this.QF = intent;
        }

        protected /* synthetic */ void m3077a(Object obj) {
            m3078c((C0194c) obj);
        }

        protected void m3078c(C0194c<C1006a> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public Status getStatus() {
            return this.QE;
        }

        public Intent getViewerIntent() {
            return this.QF;
        }
    }

    public ih(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    @Deprecated
    public ih(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, context.getMainLooper(), new C0674c(connectionCallbacks), new C0952g(onConnectionFailedListener));
    }

    public void m2734a(C0194c<PanoramaResult> c0194c, Uri uri, boolean z) {
        m2736a(new C0977b(this, null, c0194c, z ? uri : null), uri, null, z);
    }

    protected void m2735a(en enVar, C0951e c0951e) throws RemoteException {
        enVar.m693a(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m2736a(C0977b c0977b, Uri uri, Bundle bundle, boolean z) {
        bm();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((ig) eb()).m989a(c0977b, uri, bundle, z);
        } catch (RemoteException e) {
            c0977b.m2731a(8, null, 0, null);
        }
    }

    protected String aF() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public ig ax(IBinder iBinder) {
        return C0728a.aw(iBinder);
    }

    public /* synthetic */ IInterface m2737p(IBinder iBinder) {
        return ax(iBinder);
    }
}
