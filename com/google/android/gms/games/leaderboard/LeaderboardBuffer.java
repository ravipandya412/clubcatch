package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0599d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C0599d<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m2416c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Leaderboard getEntry(int rowIndex, int numChildren) {
        return new C0921b(this.zU, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
