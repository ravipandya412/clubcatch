package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.b */
public final class C0899b extends Metadata {
    private final MetadataBundle CZ;

    public C0899b(MetadataBundle metadataBundle) {
        this.CZ = metadataBundle;
    }

    protected <T> T m2382a(MetadataField<T> metadataField) {
        return this.CZ.m1593a((MetadataField) metadataField);
    }

    public Metadata eQ() {
        return new C0899b(MetadataBundle.m1592a(this.CZ));
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
