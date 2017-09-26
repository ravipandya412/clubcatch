package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0602l.C0904e;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0604r implements DriveResource {
    protected final DriveId CS;

    /* renamed from: com.google.android.gms.drive.internal.r.e */
    private static class C0911e implements MetadataResult {
        private final Metadata DQ;
        private final Status vl;

        public C0911e(Status status, Metadata metadata) {
            this.vl = status;
            this.DQ = metadata;
        }

        public Metadata getMetadata() {
            return this.DQ;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.a */
    private abstract class C1042a extends C0905m<MetadataResult> {
        final /* synthetic */ C0604r DP;

        private C1042a(C0604r c0604r) {
            this.DP = c0604r;
        }

        public /* synthetic */ Result m2938d(Status status) {
            return m2939r(status);
        }

        public MetadataResult m2939r(Status status) {
            return new C0911e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.b */
    private static class C1043b extends C0900c {
        private final C0194c<MetadataBufferResult> vj;

        public C1043b(C0194c<MetadataBufferResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2940a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.vj.m147b(new C0904e(Status.zQ, new MetadataBuffer(onListParentsResponse.fd(), null)));
        }

        public void m2941l(Status status) throws RemoteException {
            this.vj.m147b(new C0904e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.c */
    private abstract class C1044c extends C0905m<MetadataBufferResult> {
        final /* synthetic */ C0604r DP;

        private C1044c(C0604r c0604r) {
            this.DP = c0604r;
        }

        public /* synthetic */ Result m2942d(Status status) {
            return m2943o(status);
        }

        public MetadataBufferResult m2943o(Status status) {
            return new C0904e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.d */
    private static class C1045d extends C0900c {
        private final C0194c<MetadataResult> vj;

        public C1045d(C0194c<MetadataResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2944a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.vj.m147b(new C0911e(Status.zQ, new C0901j(onMetadataResponse.fe())));
        }

        public void m2945l(Status status) throws RemoteException {
            this.vj.m147b(new C0911e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.f */
    private abstract class C1046f extends C0905m<MetadataResult> {
        final /* synthetic */ C0604r DP;

        private C1046f(C0604r c0604r) {
            this.DP = c0604r;
        }

        public /* synthetic */ Result m2946d(Status status) {
            return m2947r(status);
        }

        public MetadataResult m2947r(Status status) {
            return new C0911e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.1 */
    class C11421 extends C1042a {
        final /* synthetic */ C0604r DP;

        C11421(C0604r c0604r) {
            this.DP = c0604r;
            super(null);
        }

        protected void m3194a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m313a(new GetMetadataRequest(this.DP.CS), new C1045d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.2 */
    class C11432 extends C1044c {
        final /* synthetic */ C0604r DP;

        C11432(C0604r c0604r) {
            this.DP = c0604r;
            super(null);
        }

        protected void m3196a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m314a(new ListParentsRequest(this.DP.CS), new C1043b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.3 */
    class C11443 extends C1046f {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0604r DP;

        C11443(C0604r c0604r, MetadataChangeSet metadataChangeSet) {
            this.DP = c0604r;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3198a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m319a(new UpdateMetadataRequest(this.DP.CS, this.DK.eS()), new C1045d(this));
        }
    }

    protected C0604r(DriveId driveId) {
        this.CS = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0906n) apiClient.m139a(Drive.va)).m2392a(apiClient, this.CS, 1, listener);
    }

    public DriveId getDriveId() {
        return this.CS;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.m140a(new C11421(this));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.m140a(new C11432(this));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0906n) apiClient.m139a(Drive.va)).m2395b(apiClient, this.CS, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.m141b(new C11443(this, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
