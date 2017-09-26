package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.fv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public final class C0237c {
    private static Map<String, MetadataField<?>> Ej;

    static {
        Ej = new HashMap();
        C0237c.m340b(fs.El);
        C0237c.m340b(fs.TITLE);
        C0237c.m340b(fs.MIME_TYPE);
        C0237c.m340b(fs.STARRED);
        C0237c.m340b(fs.TRASHED);
        C0237c.m340b(fs.Em);
        C0237c.m340b(fs.IS_PINNED);
        C0237c.m340b(fs.En);
        C0237c.m340b(fs.Eo);
        C0237c.m340b(fs.PARENTS);
        C0237c.m340b(fs.Ep);
        C0237c.m340b(fs.Eq);
        C0237c.m340b(fs.Er);
        C0237c.m340b(fs.Es);
        C0237c.m340b(fs.Et);
        C0237c.m340b(fs.Eu);
        C0237c.m340b(fs.Ev);
        C0237c.m340b(fs.Ew);
        C0237c.m340b(fs.Ex);
        C0237c.m340b(fs.Ey);
        C0237c.m340b(fs.Ez);
        C0237c.m340b(fs.EA);
        C0237c.m340b(fs.EB);
        C0237c.m340b(fs.EC);
        C0237c.m340b(fs.ED);
        C0237c.m340b(ft.EG);
        C0237c.m340b(ft.EE);
        C0237c.m340b(ft.EF);
        C0237c.m340b(ft.EH);
        C0237c.m340b(ft.LAST_VIEWED_BY_ME);
        C0237c.m340b(fv.EJ);
        C0237c.m340b(fv.EK);
    }

    public static MetadataField<?> ar(String str) {
        return (MetadataField) Ej.get(str);
    }

    private static void m340b(MetadataField<?> metadataField) {
        if (Ej.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        Ej.put(metadataField.getName(), metadataField);
    }

    public static Collection<MetadataField<?>> fg() {
        return Collections.unmodifiableCollection(Ej.values());
    }
}
