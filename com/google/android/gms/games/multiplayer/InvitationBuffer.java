package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0599d;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C0599d<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m2426c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Invitation getEntry(int rowIndex, int numChildren) {
        return new C0926b(this.zU, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
