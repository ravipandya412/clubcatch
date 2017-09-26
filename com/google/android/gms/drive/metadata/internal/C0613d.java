package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0613d extends MetadataField<Integer> {
    public C0613d(String str, int i) {
        super(str, i);
    }

    protected void m1601a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object m1603b(DataHolder dataHolder, int i, int i2) {
        return m1605f(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1604e(Bundle bundle) {
        return m1606h(bundle);
    }

    protected Integer m1605f(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }

    protected Integer m1606h(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
