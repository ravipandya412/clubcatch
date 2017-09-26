package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.ft;
import com.google.android.gms.internal.fv;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract <T> T m1554a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) m1554a(fs.Ep);
    }

    public int getContentAvailability() {
        Integer num = (Integer) m1554a(fv.EJ);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) m1554a(ft.EG);
    }

    public String getDescription() {
        return (String) m1554a(fs.Er);
    }

    public DriveId getDriveId() {
        return (DriveId) m1554a(fs.El);
    }

    public String getEmbedLink() {
        return (String) m1554a(fs.Et);
    }

    public String getFileExtension() {
        return (String) m1554a(fs.Eu);
    }

    public long getFileSize() {
        return ((Long) m1554a(fs.Ev)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) m1554a(ft.LAST_VIEWED_BY_ME);
    }

    public String getMimeType() {
        return (String) m1554a(fs.MIME_TYPE);
    }

    public Date getModifiedByMeDate() {
        return (Date) m1554a(ft.EF);
    }

    public Date getModifiedDate() {
        return (Date) m1554a(ft.EE);
    }

    public String getOriginalFilename() {
        return (String) m1554a(fs.Ey);
    }

    public long getQuotaBytesUsed() {
        return ((Long) m1554a(fs.Ez)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) m1554a(ft.EH);
    }

    public String getTitle() {
        return (String) m1554a(fs.TITLE);
    }

    public String getWebContentLink() {
        return (String) m1554a(fs.EA);
    }

    public String getWebViewLink() {
        return (String) m1554a(fs.EB);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) m1554a(fs.Em);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) m1554a(fs.En);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) m1554a(fv.EK);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) m1554a(fs.IS_PINNED);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) m1554a(fs.Ex);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) m1554a(fs.Eo);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) m1554a(fs.STARRED);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) m1554a(fs.TRASHED);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) m1554a(fs.Ew);
        return bool == null ? false : bool.booleanValue();
    }
}
