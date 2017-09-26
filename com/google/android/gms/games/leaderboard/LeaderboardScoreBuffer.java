package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final C0258c IO;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.IO = new C0258c(dataHolder.getMetadata());
    }

    public C0258c fX() {
        return this.IO;
    }

    public LeaderboardScore get(int position) {
        return new C0923e(this.zU, position);
    }
}
