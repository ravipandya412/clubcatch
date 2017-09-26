package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0917a;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

public final class gh implements GamesMetadata {

    /* renamed from: com.google.android.gms.internal.gh.a */
    private static abstract class C1072a extends C0917a<LoadGamesResult> {

        /* renamed from: com.google.android.gms.internal.gh.a.1 */
        class C09591 implements LoadGamesResult {
            final /* synthetic */ C1072a HO;
            final /* synthetic */ Status vb;

            C09591(C1072a c1072a, Status status) {
                this.HO = c1072a;
                this.vb = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1072a() {
        }

        public /* synthetic */ Result m3046d(Status status) {
            return m3047u(status);
        }

        public LoadGamesResult m3047u(Status status) {
            return new C09591(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gh.1 */
    class C11551 extends C1072a {
        final /* synthetic */ gh HN;

        C11551(gh ghVar) {
            this.HN = ghVar;
            super();
        }

        protected void m3230a(fx fxVar) {
            fxVar.m2712g(this);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fq();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.m140a(new C11551(this));
    }
}
