package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.eh.C0329b;
import com.google.android.gms.internal.eh.C0674c;
import com.google.android.gms.internal.eh.C0675d;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.eh.C0952g;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.ir;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0412d.C0828a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1013e extends eh<C0412d> implements GooglePlayServicesClient {
    private Person Rd;
    private final C0831h Re;

    /* renamed from: com.google.android.gms.plus.internal.e.d */
    final class C0829d extends C0329b<C0194c<Status>> {
        final /* synthetic */ C1013e Rf;
        private final Status vl;

        public C0829d(C1013e c1013e, C0194c<Status> c0194c, Status status) {
            this.Rf = c1013e;
            super(c1013e, c0194c);
            this.vl = status;
        }

        protected /* synthetic */ void m2227a(Object obj) {
            m2228c((C0194c) obj);
        }

        protected void m2228c(C0194c<Status> c0194c) {
            if (c0194c != null) {
                c0194c.m147b(this.vl);
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.h */
    final class C0830h extends C0329b<C0194c<Status>> {
        final /* synthetic */ C1013e Rf;
        private final Status vl;

        public C0830h(C1013e c1013e, C0194c<Status> c0194c, Status status) {
            this.Rf = c1013e;
            super(c1013e, c0194c);
            this.vl = status;
        }

        protected /* synthetic */ void m2229a(Object obj) {
            m2230c((C0194c) obj);
        }

        protected void m2230c(C0194c<Status> c0194c) {
            this.Rf.disconnect();
            if (c0194c != null) {
                c0194c.m147b(this.vl);
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.c */
    final class C1011c extends C0675d<C0194c<LoadMomentsResult>> implements LoadMomentsResult {
        private final String Dh;
        final /* synthetic */ C1013e Rf;
        private final String Rg;
        private MomentBuffer Rh;
        private final Status vl;

        public C1011c(C1013e c1013e, C0194c<LoadMomentsResult> c0194c, Status status, DataHolder dataHolder, String str, String str2) {
            this.Rf = c1013e;
            super(c1013e, c0194c, dataHolder);
            this.vl = status;
            this.Dh = str;
            this.Rg = str2;
        }

        protected void m2830a(C0194c<LoadMomentsResult> c0194c, DataHolder dataHolder) {
            this.Rh = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0194c.m147b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.Rh;
        }

        public String getNextPageToken() {
            return this.Dh;
        }

        public Status getStatus() {
            return this.vl;
        }

        public String getUpdated() {
            return this.Rg;
        }

        public void release() {
            if (this.Rh != null) {
                this.Rh.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.f */
    final class C1012f extends C0675d<C0194c<LoadPeopleResult>> implements LoadPeopleResult {
        private final String Dh;
        final /* synthetic */ C1013e Rf;
        private PersonBuffer Ri;
        private final Status vl;

        public C1012f(C1013e c1013e, C0194c<LoadPeopleResult> c0194c, Status status, DataHolder dataHolder, String str) {
            this.Rf = c1013e;
            super(c1013e, c0194c, dataHolder);
            this.vl = status;
            this.Dh = str;
        }

        protected void m2832a(C0194c<LoadPeopleResult> c0194c, DataHolder dataHolder) {
            this.Ri = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0194c.m147b(this);
        }

        public String getNextPageToken() {
            return this.Dh;
        }

        public PersonBuffer getPersonBuffer() {
            return this.Ri;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            if (this.Ri != null) {
                this.Ri.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.a */
    final class C1096a extends C1010a {
        private final C0194c<Status> QI;
        final /* synthetic */ C1013e Rf;

        public C1096a(C1013e c1013e, C0194c<Status> c0194c) {
            this.Rf = c1013e;
            this.QI = c0194c;
        }

        public void m3096L(Status status) {
            this.Rf.m1778a(new C0829d(this.Rf, this.QI, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.b */
    final class C1097b extends C1010a {
        private final C0194c<LoadMomentsResult> QI;
        final /* synthetic */ C1013e Rf;

        public C1097b(C1013e c1013e, C0194c<LoadMomentsResult> c0194c) {
            this.Rf = c1013e;
            this.QI = c0194c;
        }

        public void m3097a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Rf.m1778a(new C1011c(this.Rf, this.QI, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.e */
    final class C1098e extends C1010a {
        private final C0194c<LoadPeopleResult> QI;
        final /* synthetic */ C1013e Rf;

        public C1098e(C1013e c1013e, C0194c<LoadPeopleResult> c0194c) {
            this.Rf = c1013e;
            this.QI = c0194c;
        }

        public void m3098a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Rf.m1778a(new C1012f(this.Rf, this.QI, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.g */
    final class C1099g extends C1010a {
        private final C0194c<Status> QI;
        final /* synthetic */ C1013e Rf;

        public C1099g(C1013e c1013e, C0194c<Status> c0194c) {
            this.Rf = c1013e;
            this.QI = c0194c;
        }

        public void m3099d(int i, Bundle bundle) {
            this.Rf.m1778a(new C0830h(this.Rf, this.QI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C1013e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C0831h c0831h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c0831h.hq());
        this.Re = c0831h;
    }

    @Deprecated
    public C1013e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C0831h c0831h) {
        this(context, context.getMainLooper(), new C0674c(connectionCallbacks), new C0952g(onConnectionFailedListener), c0831h);
    }

    protected void m2834a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.Rd = ir.m2761i(bundle.getByteArray("loaded_person"));
        }
        super.m1777a(i, iBinder, bundle);
    }

    public void m2835a(C0194c<LoadPeopleResult> c0194c, int i, String str) {
        bm();
        Object c1098e = new C1098e(this, c0194c);
        try {
            ((C0412d) eb()).m1195a(c1098e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1098e.m3098a(DataHolder.empty(8), null);
        }
    }

    public void m2836a(C0194c<LoadMomentsResult> c0194c, int i, String str, Uri uri, String str2, String str3) {
        bm();
        Object c1097b = c0194c != null ? new C1097b(this, c0194c) : null;
        try {
            ((C0412d) eb()).m1196a(c1097b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1097b.m3097a(DataHolder.empty(8), null, null);
        }
    }

    public void m2837a(C0194c<Status> c0194c, Moment moment) {
        bm();
        C0410b c1096a = c0194c != null ? new C1096a(this, c0194c) : null;
        try {
            ((C0412d) eb()).m1198a(c1096a, fh.m1848a((io) moment));
        } catch (Throwable e) {
            if (c1096a == null) {
                throw new IllegalStateException(e);
            }
            c1096a.m3096L(new Status(8, null, null));
        }
    }

    public void m2838a(C0194c<LoadPeopleResult> c0194c, Collection<String> collection) {
        bm();
        C0410b c1098e = new C1098e(this, c0194c);
        try {
            ((C0412d) eb()).m1201a(c1098e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1098e.m3098a(DataHolder.empty(8), null);
        }
    }

    protected void m2839a(en enVar, C0951e c0951e) throws RemoteException {
        Bundle hy = this.Re.hy();
        hy.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.Re.hr());
        enVar.m696a(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.Re.hu(), this.Re.ht(), ea(), this.Re.getAccountName(), hy);
    }

    protected C0412d aB(IBinder iBinder) {
        return C0828a.aA(iBinder);
    }

    protected String aF() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean aR(String str) {
        return Arrays.asList(ea()).contains(str);
    }

    public void m2840c(C0194c<LoadPeopleResult> c0194c, String[] strArr) {
        m2838a((C0194c) c0194c, Arrays.asList(strArr));
    }

    public void clearDefaultAccount() {
        bm();
        try {
            this.Rd = null;
            ((C0412d) eb()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        bm();
        try {
            return ((C0412d) eb()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bm();
        return this.Rd;
    }

    public void m2841i(C0194c<LoadMomentsResult> c0194c) {
        m2836a(c0194c, 20, null, null, null, "me");
    }

    public void m2842i(C0194c<LoadPeopleResult> c0194c, String str) {
        m2835a((C0194c) c0194c, 0, str);
    }

    public void m2843j(C0194c<LoadPeopleResult> c0194c) {
        bm();
        Object c1098e = new C1098e(this, c0194c);
        try {
            ((C0412d) eb()).m1195a(c1098e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1098e.m3098a(DataHolder.empty(8), null);
        }
    }

    public void m2844k(C0194c<Status> c0194c) {
        bm();
        clearDefaultAccount();
        Object c1099g = new C1099g(this, c0194c);
        try {
            ((C0412d) eb()).m1202b(c1099g);
        } catch (RemoteException e) {
            c1099g.m3099d(8, null);
        }
    }

    protected /* synthetic */ IInterface m2845p(IBinder iBinder) {
        return aB(iBinder);
    }

    public void removeMoment(String momentId) {
        bm();
        try {
            ((C0412d) eb()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
