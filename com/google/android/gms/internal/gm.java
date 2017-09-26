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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;

public final class gm implements Players {

    /* renamed from: com.google.android.gms.internal.gm.a */
    private static abstract class C1078a extends C0917a<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.internal.gm.a.1 */
        class C09651 implements LoadPlayersResult {
            final /* synthetic */ C1078a Ii;
            final /* synthetic */ Status vb;

            C09651(C1078a c1078a, Status status) {
                this.Ii = c1078a;
                this.vb = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1078a() {
        }

        public LoadPlayersResult m3058A(Status status) {
            return new C09651(this, status);
        }

        public /* synthetic */ Result m3059d(Status status) {
            return m3058A(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.1 */
    class C11641 extends C1078a {
        final /* synthetic */ String If;
        final /* synthetic */ gm Ig;

        C11641(gm gmVar, String str) {
            this.Ig = gmVar;
            this.If = str;
            super();
        }

        protected void m3248a(fx fxVar) {
            fxVar.m2677a((C0194c) this, this.If);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.2 */
    class C11652 extends C1078a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11652(gm gmVar, int i, boolean z) {
            this.Ig = gmVar;
            this.Ih = i;
            this.HH = z;
            super();
        }

        protected void m3250a(fx fxVar) {
            fxVar.m2673a((C0194c) this, this.Ih, false, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.3 */
    class C11663 extends C1078a {
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11663(gm gmVar, int i) {
            this.Ig = gmVar;
            this.Ih = i;
            super();
        }

        protected void m3252a(fx fxVar) {
            fxVar.m2673a((C0194c) this, this.Ih, true, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.4 */
    class C11674 extends C1078a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11674(gm gmVar, int i, boolean z) {
            this.Ig = gmVar;
            this.Ih = i;
            this.HH = z;
            super();
        }

        protected void m3254a(fx fxVar) {
            fxVar.m2680a((C0194c) this, "playedWith", this.Ih, false, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.5 */
    class C11685 extends C1078a {
        final /* synthetic */ gm Ig;
        final /* synthetic */ int Ih;

        C11685(gm gmVar, int i) {
            this.Ig = gmVar;
            this.Ih = i;
            super();
        }

        protected void m3256a(fx fxVar) {
            fxVar.m2680a((C0194c) this, "playedWith", this.Ih, true, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.gm.6 */
    class C11696 extends C1078a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gm Ig;

        C11696(gm gmVar, boolean z) {
            this.Ig = gmVar;
            this.HH = z;
            super();
        }

        protected void m3258a(fx fxVar) {
            fxVar.m2687a((C0194c) this, this.HH);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fp();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fo();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fy();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m140a(new C11696(this, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m140a(new C11652(this, pageSize, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m140a(new C11663(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m140a(new C11685(this, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.m140a(new C11641(this, playerId));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m140a(new C11674(this, pageSize, forceReload));
    }
}
