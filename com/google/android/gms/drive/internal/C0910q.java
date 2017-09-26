package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C0910q extends C0604r implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.q.d */
    private static class C0908d implements DriveFileResult {
        private final DriveFile DN;
        private final Status vl;

        public C0908d(Status status, DriveFile driveFile) {
            this.vl = status;
            this.DN = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.DN;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.e */
    private static class C0909e implements DriveFolderResult {
        private final DriveFolder DO;
        private final Status vl;

        public C0909e(Status status, DriveFolder driveFolder) {
            this.vl = status;
            this.DO = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.DO;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.1 */
    class C10381 extends C0905m<DriveFileResult> {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0910q DM;
        final /* synthetic */ Contents Dw;

        C10381(C0910q c0910q, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.DM = c0910q;
            this.Dw = contents;
            this.DK = metadataChangeSet;
        }

        protected void m2929a(C0906n c0906n) throws RemoteException {
            this.Dw.close();
            c0906n.eT().m310a(new CreateFileRequest(this.DM.getDriveId(), this.DK.eS(), this.Dw), new C1039a(this));
        }

        public /* synthetic */ Result m2930d(Status status) {
            return m2931p(status);
        }

        public DriveFileResult m2931p(Status status) {
            return new C0908d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.a */
    private static class C1039a extends C0900c {
        private final C0194c<DriveFileResult> vj;

        public C1039a(C0194c<DriveFileResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2932a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.vj.m147b(new C0908d(Status.zQ, new C0907o(onDriveIdResponse.getDriveId())));
        }

        public void m2933l(Status status) throws RemoteException {
            this.vj.m147b(new C0908d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.b */
    private static class C1040b extends C0900c {
        private final C0194c<DriveFolderResult> vj;

        public C1040b(C0194c<DriveFolderResult> c0194c) {
            this.vj = c0194c;
        }

        public void m2934a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.vj.m147b(new C0909e(Status.zQ, new C0910q(onDriveIdResponse.getDriveId())));
        }

        public void m2935l(Status status) throws RemoteException {
            this.vj.m147b(new C0909e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.c */
    private abstract class C1041c extends C0905m<DriveFolderResult> {
        final /* synthetic */ C0910q DM;

        private C1041c(C0910q c0910q) {
            this.DM = c0910q;
        }

        public /* synthetic */ Result m2936d(Status status) {
            return m2937q(status);
        }

        public DriveFolderResult m2937q(Status status) {
            return new C0909e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.2 */
    class C11412 extends C1041c {
        final /* synthetic */ MetadataChangeSet DK;
        final /* synthetic */ C0910q DM;

        C11412(C0910q c0910q, MetadataChangeSet metadataChangeSet) {
            this.DM = c0910q;
            this.DK = metadataChangeSet;
            super(null);
        }

        protected void m3192a(C0906n c0906n) throws RemoteException {
            c0906n.eT().m311a(new CreateFolderRequest(this.DM.getDriveId(), this.DK.eS()), new C1040b(this));
        }
    }

    public C0910q(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(changeSet.getMimeType())) {
            return apiClient.m141b(new C10381(this, contents, changeSet));
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.m141b(new C11412(this, changeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
        }
        return new C0602l().query(apiClient, addFilter.build());
    }
}
