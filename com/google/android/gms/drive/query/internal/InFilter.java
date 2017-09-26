package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
    public static final C0244e CREATOR;
    final MetadataBundle EP;
    private final CollectionMetadataField<T> EX;
    final int wj;

    static {
        CREATOR = new C0244e();
    }

    InFilter(int versionCode, MetadataBundle value) {
        this.wj = versionCode;
        this.EP = value;
        this.EX = (CollectionMetadataField) C0243d.m346b(value);
    }

    public InFilter(CollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m1591a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0244e.m347a(this, out, flags);
    }
}
