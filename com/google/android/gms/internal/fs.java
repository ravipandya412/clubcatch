package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0612a;
import com.google.android.gms.drive.metadata.internal.C0614e;
import com.google.android.gms.drive.metadata.internal.C0616j;
import com.google.android.gms.drive.metadata.internal.C0914g;
import com.google.android.gms.drive.metadata.internal.C0915i;
import com.google.android.gms.plus.PlusShare;

public class fs {
    public static final MetadataField<String> EA;
    public static final MetadataField<String> EB;
    public static final MetadataField<String> EC;
    public static final MetadataField<Boolean> ED;
    public static final MetadataField<DriveId> El;
    public static final MetadataField<Boolean> Em;
    public static final MetadataField<Boolean> En;
    public static final MetadataField<Boolean> Eo;
    public static final MetadataField<String> Ep;
    public static final CollectionMetadataField<String> Eq;
    public static final MetadataField<String> Er;
    public static final MetadataField<Boolean> Es;
    public static final MetadataField<String> Et;
    public static final MetadataField<String> Eu;
    public static final MetadataField<Long> Ev;
    public static final MetadataField<Boolean> Ew;
    public static final MetadataField<Boolean> Ex;
    public static final MetadataField<String> Ey;
    public static final MetadataField<Long> Ez;
    public static final MetadataField<Boolean> IS_PINNED;
    public static final MetadataField<String> MIME_TYPE;
    public static final CollectionMetadataField<DriveId> PARENTS;
    public static final MetadataField<Boolean> STARRED;
    public static final MetadataField<String> TITLE;
    public static final MetadataField<Boolean> TRASHED;

    /* renamed from: com.google.android.gms.internal.fs.1 */
    static class C09531 extends C0612a {
        C09531(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object m2597b(DataHolder dataHolder, int i, int i2) {
            return m2598d(dataHolder, i, i2);
        }

        protected Boolean m2598d(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
        }
    }

    static {
        El = fu.EI;
        TITLE = new C0616j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        MIME_TYPE = new C0616j("mimeType", 4100000);
        STARRED = new C0612a("starred", 4100000);
        TRASHED = new C09531("trashed", 4100000);
        Em = new C0612a("isEditable", 4100000);
        IS_PINNED = new C0612a("isPinned", 4100000);
        En = new C0612a("isAppData", 4300000);
        Eo = new C0612a("isShared", 4300000);
        PARENTS = new C0914g("parents", 4100000);
        Ep = new C0616j("alternateLink", 4300000);
        Eq = new C0915i("ownerNames", 4300000);
        Er = new C0616j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        Es = new C0612a("isCopyable", 4300000);
        Et = new C0616j("embedLink", 4300000);
        Eu = new C0616j("fileExtension", 4300000);
        Ev = new C0614e("fileSize", 4300000);
        Ew = new C0612a("isViewed", 4300000);
        Ex = new C0612a("isRestricted", 4300000);
        Ey = new C0616j("originalFilename", 4300000);
        Ez = new C0614e("quotaBytesUsed", 4300000);
        EA = new C0616j("webContentLink", 4300000);
        EB = new C0616j("webViewLink", 4300000);
        EC = new C0616j("indexableText", 4300000);
        ED = new C0612a("hasThumbnail", 4300000);
    }
}
