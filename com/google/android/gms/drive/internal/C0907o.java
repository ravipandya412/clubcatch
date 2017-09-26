package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0602l.C0902a;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0907o extends C0604r implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.o.a */
    private abstract class C1034a extends C0905m<Status> {
        final /* synthetic */ C0907o DJ;

        private C1034a(C0907o c0907o) {
            this.DJ = c0907o;
        }

        public /* synthetic */ Result m2919d(Status status) {
            return m2920f(status);
        }

        public Status m2920f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.b */
    private abstract class C1035b extends C0905m<Status> {
        final /* synthetic */ C0907o DJ;

        private C1035b(C0907o c0907o) {
            this.DJ = c0907o;
        }

        public /* synthetic */ Result m2921d(Status status) {
            return m2922f(status);
        }

        public Status m2922f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.c */
    private static class C1036c extends C0900c {
        private final DownloadProgressListener DL;
        private final C0194c<ContentsResult> vj;

        public C1036c(C0194c<ContentsResult> c0194c, DownloadProgressListener downloadProgressListener) {
            this.vj = c0194c;
            this.DL = downloadProgressListener;
        }

        public void m2923a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.vj.m147b(new C0902a(Status.zQ, onContentsResponse.eX()));
        }

        public void m2924a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.DL != null) {
                this.DL.onProgress(onDownloadProgressResponse.eY(), onDownloadProgressResponse.eZ());
            }
        }

        public void m2925l(Status status) throws RemoteException {
            this.vj.m147b(new C0902a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.d */
    private abstract class C1037d extends C0905m<ContentsResult> {
        final /* synthetic */ C0907o DJ;

        private C1037d(C0907o c0907o) {
            this.DJ = c0907o;
        }

        public /* synthetic */ Result m2926d(Status status) {
            return m2927n(status);
        }

        public ContentsResult m2927n(Status status) {
            return new C0902a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.1 */
    class C11381 extends C1037d {
        final /* synthetic */ int DH;
        final /* synthetic */ DownloadProgressListener DI;
        final /* synthetic */ C0907o DJ;

        C11381(C0907o c0907o, int i, DownloadProgressListener downloadProgressListener) {
            this.DJ = c0907o;
            this.DH = i;
            this.DI = downloadProgressListener;
            super(null);
        }

        protected void m3186a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m315a(new OpenContentsRequest(this.DJ.getDriveId(), this.DH), new C1036c(this, this.DI));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.2 */
    class C11392 extends C1035b {
        final /* synthetic */ C0907o DJ;
        final /* synthetic */ Contents Dw;

        C11392(C0907o c0907o, Contents contents) {
            this.DJ = c0907o;
            this.Dw = contents;
            super(null);
        }

        protected void m3188a(C0906n c0906n) throws RemoteException {
            this.Dw.close();
            c0906n.eT().m308a(new CloseContentsRequest(this.Dw, true), new ak(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.3 */
    class C11403 extends C1034a {
        final /* synthetic */ C0907o DJ;
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ Contents Dw;

        C11403(C0907o c0907o, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.DJ = c0907o;
            this.Dw = contents;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3190a(C0906n c0906n) throws RemoteException {
            this.Dw.close();
            c0906n.eT().m307a(new CloseContentsAndUpdateMetadataRequest(this.DJ.CS, this.DK.eS(), this.Dw), new ak(this));
        }
    }

    public C0907o(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents) {
        if (contents != null) {
            return apiClient.m141b(new C11392(this, contents));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, Contents contents, MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.m141b(new C11403(this, contents, changeSet));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.m140a(new C11381(this, mode, listener));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
