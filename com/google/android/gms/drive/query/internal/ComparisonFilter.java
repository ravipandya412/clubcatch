package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class ComparisonFilter<T> implements SafeParcelable, Filter {
    public static final C0240a CREATOR;
    final Operator EO;
    final MetadataBundle EP;
    final MetadataField<T> EQ;
    final int wj;

    static {
        CREATOR = new C0240a();
    }

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.wj = versionCode;
        this.EO = operator;
        this.EP = value;
        this.EQ = C0243d.m346b(value);
    }

    public ComparisonFilter(Operator operator, MetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m1591a(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0240a.m343a(this, out, flags);
    }
}
