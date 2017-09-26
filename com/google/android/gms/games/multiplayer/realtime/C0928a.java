package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0599d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0928a extends C0599d<Room> {
    public C0928a(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m2427c(int i, int i2) {
        return m2428d(i, i2);
    }

    protected Room m2428d(int i, int i2) {
        return new C0929c(this.zU, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
