package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C0913b extends OrderedMetadataField<Date> {
    public C0913b(String str, int i) {
        super(str, i);
    }

    protected void m2399a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object m2400b(DataHolder dataHolder, int i, int i2) {
        return m2402e(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m2401e(Bundle bundle) {
        return m2403g(bundle);
    }

    protected Date m2402e(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.getLong(getName(), i, i2));
    }

    protected Date m2403g(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
