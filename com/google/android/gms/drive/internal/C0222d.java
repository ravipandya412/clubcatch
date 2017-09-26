package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.d */
public class C0222d implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void m286a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, closeContentsAndUpdateMetadataRequest.wj);
        C0212b.m234a(parcel, 2, closeContentsAndUpdateMetadataRequest.Do, i, false);
        C0212b.m234a(parcel, 3, closeContentsAndUpdateMetadataRequest.Dp, i, false);
        C0212b.m234a(parcel, 4, closeContentsAndUpdateMetadataRequest.Dq, i, false);
        C0212b.m226D(parcel, p);
    }

    public CloseContentsAndUpdateMetadataRequest m287E(Parcel parcel) {
        Contents contents = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            MetadataBundle metadataBundle2;
            DriveId driveId2;
            int g;
            Contents contents2;
            int n = C0211a.m209n(parcel);
            Contents contents3;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    contents3 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = C0211a.m202g(parcel, n);
                    contents2 = contents3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i;
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    driveId2 = driveId;
                    g = i;
                    contents3 = contents;
                    metadataBundle2 = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    contents2 = contents3;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    contents2 = (Contents) C0211a.m191a(parcel, n, Contents.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
            contents = contents2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] aj(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m287E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aj(x0);
    }
}
