package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bf.C0648a;
import java.util.Map;

public final class be extends C0648a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> mQ;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bg m2447n(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, be.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new bi(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.mQ.get(mediationAdapter.getAdditionalParametersType()));
            }
            da.m570w("Could not instantiate mediation adapter: " + str + ".");
            throw new RemoteException();
        } catch (Throwable th) {
            da.m570w("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m2448c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.mQ = map;
    }

    public bg m2449m(String str) throws RemoteException {
        return m2447n(str);
    }
}
