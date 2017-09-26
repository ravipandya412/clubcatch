package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C0602l implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.l.a */
    static class C0902a implements ContentsResult {
        private final Contents CW;
        private final Status vl;

        public C0902a(Status status, Contents contents) {
            this.vl = status;
            this.CW = contents;
        }

        public Contents getContents() {
            return this.CW;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.c */
    static class C0903c implements DriveIdResult {
        private final DriveId CS;
        private final Status vl;

        public C0903c(Status status, DriveId driveId) {
            this.vl = status;
            this.CS = driveId;
        }

        public DriveId getDriveId() {
            return this.CS;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.e */
    static class C0904e implements MetadataBufferResult {
        private final MetadataBuffer Dy;
        private final Status vl;

        public C0904e(Status status, MetadataBuffer metadataBuffer) {
            this.vl = status;
            this.Dy = metadataBuffer;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.Dy;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.b */
    private static class C1026b extends C0900c {
        private final C0194c<DriveIdResult> vj;

        public C1026b(C0194c<DriveIdResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2903a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.vj.m147b(new C0903c(Status.zQ, new C0901j(onMetadataResponse.fe()).getDriveId()));
        }

        public void m2904l(Status status) throws RemoteException {
            this.vj.m147b(new C0903c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.d */
    abstract class C1027d extends C0905m<DriveIdResult> {
        final /* synthetic */ C0602l Dv;

        C1027d(C0602l c0602l) {
            this.Dv = c0602l;
        }

        public /* synthetic */ Result m2905d(Status status) {
            return m2906m(status);
        }

        public DriveIdResult m2906m(Status status) {
            return new C0903c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.f */
    private static class C1028f extends C0900c {
        private final C0194c<ContentsResult> vj;

        public C1028f(C0194c<ContentsResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2907a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.vj.m147b(new C0902a(Status.zQ, onContentsResponse.eX()));
        }

        public void m2908l(Status status) throws RemoteException {
            this.vj.m147b(new C0902a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.g */
    abstract class C1029g extends C0905m<ContentsResult> {
        final /* synthetic */ C0602l Dv;

        C1029g(C0602l c0602l) {
            this.Dv = c0602l;
        }

        public /* synthetic */ Result m2909d(Status status) {
            return m2910n(status);
        }

        public ContentsResult m2910n(Status status) {
            return new C0902a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.h */
    static class C1030h extends C0900c {
        private final C0194c<MetadataBufferResult> vj;

        public C1030h(C0194c<MetadataBufferResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2911a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.vj.m147b(new C0904e(Status.zQ, new MetadataBuffer(onListEntriesResponse.fc(), null)));
        }

        public void m2912l(Status status) throws RemoteException {
            this.vj.m147b(new C0904e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.i */
    abstract class C1031i extends C0905m<MetadataBufferResult> {
        final /* synthetic */ C0602l Dv;

        C1031i(C0602l c0602l) {
            this.Dv = c0602l;
        }

        public /* synthetic */ Result m2913d(Status status) {
            return m2914o(status);
        }

        public MetadataBufferResult m2914o(Status status) {
            return new C0904e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.j */
    static abstract class C1032j extends C0905m<Status> {
        C1032j() {
        }

        public /* synthetic */ Result m2915d(Status status) {
            return m2916f(status);
        }

        public Status m2916f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.l */
    abstract class C1033l extends C0905m<Status> {
        final /* synthetic */ C0602l Dv;

        C1033l(C0602l c0602l) {
            this.Dv = c0602l;
        }

        public /* synthetic */ Result m2917d(Status status) {
            return m2918f(status);
        }

        public Status m2918f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.1 */
    class C11301 extends C1031i {
        final /* synthetic */ Query Du;
        final /* synthetic */ C0602l Dv;

        C11301(C0602l c0602l, Query query) {
            this.Dv = c0602l;
            this.Du = query;
            super(c0602l);
        }

        protected void m3170a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m316a(new QueryRequest(this.Du), new C1030h(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.2 */
    class C11312 extends C1029g {
        final /* synthetic */ C0602l Dv;

        C11312(C0602l c0602l) {
            this.Dv = c0602l;
            super(c0602l);
        }

        protected void m3172a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m309a(new CreateContentsRequest(), new C1028f(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.3 */
    class C11323 extends C1032j {
        final /* synthetic */ C0602l Dv;
        final /* synthetic */ Contents Dw;

        C11323(C0602l c0602l, Contents contents) {
            this.Dv = c0602l;
            this.Dw = contents;
        }

        protected void m3174a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m308a(new CloseContentsRequest(this.Dw, false), new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.4 */
    class C11334 extends C1027d {
        final /* synthetic */ C0602l Dv;
        final /* synthetic */ String Dx;

        C11334(C0602l c0602l, String str) {
            this.Dv = c0602l;
            this.Dx = str;
            super(c0602l);
        }

        protected void m3176a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m313a(new GetMetadataRequest(DriveId.aq(this.Dx)), new C1026b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.5 */
    class C11345 extends C1033l {
        final /* synthetic */ C0602l Dv;

        C11345(C0602l c0602l) {
            this.Dv = c0602l;
            super(c0602l);
        }

        protected void m3178a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m320a(new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.k */
    static class C1135k extends C1032j {
        C1135k(Status status) {
            m1514a((Result) status);
        }

        protected void m3180a(C0906n c0906n) {
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return apiClient.m141b(new C11323(this, contents));
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, String resourceId) {
        return apiClient.m140a(new C11334(this, resourceId));
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId eV = ((C0906n) apiClient.m139a(Drive.va)).eV();
            return eV != null ? new C0910q(eV) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0907o(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0910q(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C0910q(((C0906n) apiClient.m139a(Drive.va)).eU());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.m140a(new C11312(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, Query query) {
        if (query != null) {
            return apiClient.m140a(new C11301(this, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.m141b(new C11345(this));
    }
}
