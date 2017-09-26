package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.a */
public final class C0920a implements Leaderboard {
    private final String FE;
    private final Uri FJ;
    private final String FU;
    private final String IJ;
    private final int IK;
    private final ArrayList<C0924f> IL;
    private final Game IM;

    public C0920a(Leaderboard leaderboard) {
        this.IJ = leaderboard.getLeaderboardId();
        this.FE = leaderboard.getDisplayName();
        this.FJ = leaderboard.getIconImageUri();
        this.FU = leaderboard.getIconImageUrl();
        this.IK = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.IM = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.IL = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.IL.add((C0924f) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int m2417a(Leaderboard leaderboard) {
        return ep.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean m2418a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return ep.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && ep.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && ep.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && ep.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && ep.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String m2419b(Leaderboard leaderboard) {
        return ep.m717e(leaderboard).m716a("LeaderboardId", leaderboard.getLeaderboardId()).m716a("DisplayName", leaderboard.getDisplayName()).m716a("IconImageUri", leaderboard.getIconImageUri()).m716a("IconImageUrl", leaderboard.getIconImageUrl()).m716a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).m716a("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return C0920a.m2418a(this, obj);
    }

    public Leaderboard fW() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return fW();
    }

    public String getDisplayName() {
        return this.FE;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        fm.m775b(this.FE, dataOut);
    }

    public Game getGame() {
        return this.IM;
    }

    public Uri getIconImageUri() {
        return this.FJ;
    }

    public String getIconImageUrl() {
        return this.FU;
    }

    public String getLeaderboardId() {
        return this.IJ;
    }

    public int getScoreOrder() {
        return this.IK;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.IL);
    }

    public int hashCode() {
        return C0920a.m2417a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C0920a.m2419b(this);
    }
}
