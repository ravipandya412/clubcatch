package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.C0913b;
import java.util.Date;

public class ft {
    public static final OrderedMetadataField<Date> EE;
    public static final OrderedMetadataField<Date> EF;
    public static final OrderedMetadataField<Date> EG;
    public static final OrderedMetadataField<Date> EH;
    public static final OrderedMetadataField<Date> LAST_VIEWED_BY_ME;

    static {
        EE = new C0913b("modified", 4100000);
        EF = new C0913b("modifiedByMe", 4100000);
        EG = new C0913b("created", 4100000);
        EH = new C0913b("sharedWithMe", 4100000);
        LAST_VIEWED_BY_ME = new C0913b("lastOpenedTime", 4300000);
    }
}
