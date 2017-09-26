package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public class C0614e extends MetadataField<Long> {
    public C0614e(String str, int i) {
        super(str, i);
    }

    protected void m1607a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object m1609b(DataHolder dataHolder, int i, int i2) {
        return m1611g(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1610e(Bundle bundle) {
        return m1612i(bundle);
    }

    protected Long m1611g(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.getLong(getName(), i, i2));
    }

    protected Long m1612i(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
