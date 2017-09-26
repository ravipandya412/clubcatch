package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0201b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0918b;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.b */
public final class C0921b extends C0201b implements Leaderboard {
    private final Game IM;
    private final int IN;

    C0921b(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.IN = i2;
        this.IM = new C0918b(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0920a.m2418a(this, obj);
    }

    public Leaderboard fW() {
        return new C0920a(this);
    }

    public /* synthetic */ Object freeze() {
        return fW();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        m156a("name", dataOut);
    }

    public Game getGame() {
        return this.IM;
    }

    public Uri getIconImageUri() {
        return aa("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.IN);
        for (int i = 0; i < this.IN; i++) {
            arrayList.add(new C0925g(this.zU, this.zW + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return C0920a.m2417a(this);
    }

    public String toString() {
        return C0920a.m2419b(this);
    }
}
