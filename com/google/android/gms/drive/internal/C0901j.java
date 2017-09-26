package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.j */
public final class C0901j extends Metadata {
    private final MetadataBundle CZ;

    public C0901j(MetadataBundle metadataBundle) {
        this.CZ = metadataBundle;
    }

    protected <T> T m2390a(MetadataField<T> metadataField) {
        return this.CZ.m1593a((MetadataField) metadataField);
    }

    public Metadata eQ() {
        return new C0901j(MetadataBundle.m1592a(this.CZ));
    }

    public /* synthetic */ Object freeze() {
        return eQ();
    }

    public boolean isDataValid() {
        return this.CZ != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.CZ + "]";
    }
}
