package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public final class C0616j extends MetadataField<String> {
    public C0616j(String str, int i) {
        super(str, i);
    }

    protected void m1618a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object m1619b(DataHolder dataHolder, int i, int i2) {
        return m1621h(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m1620e(Bundle bundle) {
        return m1622l(bundle);
    }

    protected String m1621h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.getString(getName(), i, i2);
    }

    protected String m1622l(Bundle bundle) {
        return bundle.getString(getName());
    }
}
