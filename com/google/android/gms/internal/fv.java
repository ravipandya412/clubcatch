package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0612a;
import com.google.android.gms.drive.metadata.internal.C0613d;

public class fv {
    public static final MetadataField<Integer> EJ;
    public static final MetadataField<Boolean> EK;

    static {
        EJ = new C0613d("contentAvailability", 4300000);
        EK = new C0612a("isPinnable", 4300000);
    }
}
