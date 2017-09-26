package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0917a;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class gj implements Leaderboards {

    /* renamed from: com.google.android.gms.internal.gj.a */
    private static abstract class C1074a extends C0917a<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.internal.gj.a.1 */
        class C09611 implements LeaderboardMetadataResult {
            final /* synthetic */ C1074a Ib;
            final /* synthetic */ Status vb;

            C09611(C1074a c1074a, Status status) {
                this.Ib = c1074a;
                this.vb = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1074a() {
        }

        public /* synthetic */ Result m3050d(Status status) {
            return m3051w(status);
        }

        public LeaderboardMetadataResult m3051w(Status status) {
            return new C09611(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.b */
    private static abstract class C1075b extends C0917a<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.internal.gj.b.1 */
        class C09621 implements LoadPlayerScoreResult {
            final /* synthetic */ C1075b Ic;
            final /* synthetic */ Status vb;

            C09621(C1075b c1075b, Status status) {
                this.Ic = c1075b;
                this.vb = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1075b() {
        }

        public /* synthetic */ Result m3052d(Status status) {
            return m3053x(status);
        }

        public LoadPlayerScoreResult m3053x(Status status) {
            return new C09621(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.c */
    private static abstract class C1076c extends C0917a<LoadScoresResult> {

        /* renamed from: com.google.android.gms.internal.gj.c.1 */
        class C09631 implements LoadScoresResult {
            final /* synthetic */ C1076c Id;
            final /* synthetic */ Status vb;

            C09631(C1076c c1076c, Status status) {
                this.Id = c1076c;
                this.vb = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1076c() {
        }

        public /* synthetic */ Result m3054d(Status status) {
            return m3055y(status);
        }

        public LoadScoresResult m3055y(Status status) {
            return new C09631(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.d */
    protected static abstract class C1077d extends C0917a<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.internal.gj.d.1 */
        class C09641 implements SubmitScoreResult {
            final /* synthetic */ C1077d Ie;
            final /* synthetic */ Status vb;

            C09641(C1077d c1077d, Status status) {
                this.Ie = c1077d;
                this.vb = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        protected C1077d() {
        }

        public /* synthetic */ Result m3056d(Status status) {
            return m3057z(status);
        }

        public SubmitScoreResult m3057z(Status status) {
            return new C09641(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.1 */
    class C11571 extends C1074a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;

        C11571(gj gjVar, boolean z) {
            this.HS = gjVar;
            this.HH = z;
            super();
        }

        protected void m3234a(fx fxVar) {
            fxVar.m2700b((C0194c) this, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.2 */
    class C11582 extends C1074a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;

        C11582(gj gjVar, String str, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HH = z;
            super();
        }

        protected void m3236a(fx fxVar) {
            fxVar.m2684a((C0194c) this, this.HT, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.3 */
    class C11593 extends C1075b {
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;

        C11593(gj gjVar, String str, int i, int i2) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            super();
        }

        protected void m3238a(fx fxVar) {
            fxVar.m2683a((C0194c) this, null, this.HT, this.HU, this.HV);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.4 */
    class C11604 extends C1076c {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;
        final /* synthetic */ int HW;

        C11604(gj gjVar, String str, int i, int i2, int i3, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            this.HW = i3;
            this.HH = z;
            super();
        }

        protected void m3240a(fx fxVar) {
            fxVar.m2679a(this, this.HT, this.HU, this.HV, this.HW, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.5 */
    class C11615 extends C1076c {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ int HU;
        final /* synthetic */ int HV;
        final /* synthetic */ int HW;

        C11615(gj gjVar, String str, int i, int i2, int i3, boolean z) {
            this.HS = gjVar;
            this.HT = str;
            this.HU = i;
            this.HV = i2;
            this.HW = i3;
            this.HH = z;
            super();
        }

        protected void m3242a(fx fxVar) {
            fxVar.m2699b(this, this.HT, this.HU, this.HV, this.HW, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.6 */
    class C11626 extends C1076c {
        final /* synthetic */ gj HS;
        final /* synthetic */ int HW;
        final /* synthetic */ LeaderboardScoreBuffer HX;
        final /* synthetic */ int HY;

        C11626(gj gjVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.HS = gjVar;
            this.HX = leaderboardScoreBuffer;
            this.HW = i;
            this.HY = i2;
            super();
        }

        protected void m3244a(fx fxVar) {
            fxVar.m2675a((C0194c) this, this.HX, this.HW, this.HY);
        }
    }

    /* renamed from: com.google.android.gms.internal.gj.7 */
    class C11637 extends C1077d {
        final /* synthetic */ gj HS;
        final /* synthetic */ String HT;
        final /* synthetic */ long HZ;
        final /* synthetic */ String Ia;

        C11637(gj gjVar, String str, long j, String str2) {
            this.HS = gjVar;
            this.HT = str;
            this.HZ = j;
            this.Ia = str2;
        }

        protected void m3246a(fx fxVar) {
            fxVar.m2681a((C0194c) this, this.HT, this.HZ, this.Ia);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fr();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m364c(apiClient).au(leaderboardId);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        return apiClient.m140a(new C11593(this, leaderboardId, span, leaderboardCollection));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, String leaderboardId, boolean forceReload) {
        return apiClient.m140a(new C11582(this, leaderboardId, forceReload));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m140a(new C11571(this, forceReload));
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        return apiClient.m140a(new C11626(this, buffer, maxResults, pageDirection));
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m140a(new C11615(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m140a(new C11604(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m364c(apiClient).m2681a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        return apiClient.m141b(new C11637(this, leaderboardId, score, scoreTag));
    }
}
