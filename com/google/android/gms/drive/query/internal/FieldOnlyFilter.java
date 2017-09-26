package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter implements SafeParcelable, Filter {
    public static final Creator<FieldOnlyFilter> CREATOR;
    final MetadataBundle EP;
    private final MetadataField<?> EQ;
    final int wj;

    static {
        CREATOR = new C0241b();
    }

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.wj = versionCode;
        this.EP = value;
        this.EQ = C0243d.m346b(value);
    }

    public FieldOnlyFilter(MetadataField<?> field) {
        this(1, MetadataBundle.m1591a(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0241b.m344a(this, out, flags);
    }
}
