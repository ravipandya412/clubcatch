package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0906n;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.internal.er;
import java.io.IOException;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private MetadataChangeSet CV;
    private Contents CW;
    private String CX;
    private DriveId CY;

    public IntentSender build(GoogleApiClient apiClient) {
        er.m723b(this.CW, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.CW.getParcelFileDescriptor().close();
        } catch (IOException e) {
        }
        this.CW.close();
        er.m721a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C0906n) apiClient.m139a(Drive.va)).eT().m303a(new CreateFileIntentSenderRequest(this.CV.eS(), this.CW.eP(), this.CX, this.CY));
        } catch (Throwable e2) {
            throw new RuntimeException("Unable to connect Drive Play Service", e2);
        }
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.CY = (DriveId) er.m725f(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.CX = (String) er.m725f(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.CW = (Contents) er.m725f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.CV = (MetadataChangeSet) er.m725f(metadataChangeSet);
        return this;
    }
}
