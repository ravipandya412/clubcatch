package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0612a extends MetadataField<Boolean> {
    public C0612a(String str, int i) {
        super(str, i);
    }

    protected void m1595a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object m1597b(DataHolder dataHolder, int i, int i2) {
        return m1598d(dataHolder, i, i2);
    }

    protected Boolean m1598d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }

    protected /* synthetic */ Object m1599e(Bundle bundle) {
        return m1600f(bundle);
    }

    protected Boolean m1600f(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
