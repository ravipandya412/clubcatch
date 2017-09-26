package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.er;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR;
    final Contents Dq;
    final MetadataBundle Ds;
    final DriveId Dt;
    final int wj;

    static {
        CREATOR = new C0226h();
    }

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this.wj = versionCode;
        this.Dt = (DriveId) er.m725f(parentDriveId);
        this.Ds = (MetadataBundle) er.m725f(metadata);
        this.Dq = (Contents) er.m725f(contentsReference);
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this(1, parentDriveId, metadata, contentsReference);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0226h.m294a(this, dest, flags);
    }
}
