package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.Status;

public class ak extends C0900c {
    private final C0194c<Status> vj;

    public ak(C0194c<Status> c0194c) {
        this.vj = c0194c;
    }

    public void m2902l(Status status) throws RemoteException {
        this.vj.m147b(status);
    }

    public void onSuccess() throws RemoteException {
        this.vj.m147b(Status.zQ);
    }
}
