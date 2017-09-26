package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0201b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0919d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.leaderboard.e */
public final class C0923e extends C0201b implements LeaderboardScore {
    private final C0919d Jc;

    C0923e(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.Jc = new C0919d(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0922d.m2421a(this, obj);
    }

    public LeaderboardScore fZ() {
        return new C0922d(this);
    }

    public /* synthetic */ Object freeze() {
        return fZ();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        m156a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        m156a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return ab("external_player_id") ? null : this.Jc;
    }

    public String getScoreHolderDisplayName() {
        return ab("external_player_id") ? getString("default_display_name") : this.Jc.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (ab("external_player_id")) {
            m156a("default_display_name", dataOut);
        } else {
            this.Jc.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return ab("external_player_id") ? null : this.Jc.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return ab("external_player_id") ? null : this.Jc.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return ab("external_player_id") ? aa("default_display_image_uri") : this.Jc.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return ab("external_player_id") ? getString("default_display_image_url") : this.Jc.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return C0922d.m2420a(this);
    }

    public String toString() {
        return C0922d.m2422b(this);
    }
}
