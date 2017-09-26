package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public abstract class C0615h<T extends Parcelable> extends MetadataField<T> {
    public C0615h(String str, Collection<String> collection, int i) {
        super(str, collection, i);
    }

    protected void m1613a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object m1615e(Bundle bundle) {
        return m1616k(bundle);
    }

    protected T m1616k(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
