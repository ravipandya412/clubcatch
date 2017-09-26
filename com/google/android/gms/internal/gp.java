package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0917a;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class gp implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.internal.gp.a */
    private static abstract class C1081a extends C0917a<CancelMatchResult> {
        private final String uS;

        /* renamed from: com.google.android.gms.internal.gp.a.1 */
        class C09681 implements CancelMatchResult {
            final /* synthetic */ C1081a Iy;
            final /* synthetic */ Status vb;

            C09681(C1081a c1081a, Status status) {
                this.Iy = c1081a;
                this.vb = status;
            }

            public String getMatchId() {
                return this.Iy.uS;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        public C1081a(String str) {
            this.uS = str;
        }

        public CancelMatchResult m3065D(Status status) {
            return new C09681(this, status);
        }

        public /* synthetic */ Result m3066d(Status status) {
            return m3065D(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.b */
    private static abstract class C1082b extends C0917a<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.b.1 */
        class C09691 implements InitiateMatchResult {
            final /* synthetic */ C1082b Iz;
            final /* synthetic */ Status vb;

            C09691(C1082b c1082b, Status status) {
                this.Iz = c1082b;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1082b() {
        }

        public InitiateMatchResult m3067E(Status status) {
            return new C09691(this, status);
        }

        public /* synthetic */ Result m3068d(Status status) {
            return m3067E(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.c */
    private static abstract class C1083c extends C0917a<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.c.1 */
        class C09701 implements LeaveMatchResult {
            final /* synthetic */ C1083c IA;
            final /* synthetic */ Status vb;

            C09701(C1083c c1083c, Status status) {
                this.IA = c1083c;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1083c() {
        }

        public LeaveMatchResult m3069F(Status status) {
            return new C09701(this, status);
        }

        public /* synthetic */ Result m3070d(Status status) {
            return m3069F(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.d */
    private static abstract class C1084d extends C0917a<LoadMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.d.1 */
        class C09711 implements LoadMatchResult {
            final /* synthetic */ C1084d IB;
            final /* synthetic */ Status vb;

            C09711(C1084d c1084d, Status status) {
                this.IB = c1084d;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1084d() {
        }

        public LoadMatchResult m3071G(Status status) {
            return new C09711(this, status);
        }

        public /* synthetic */ Result m3072d(Status status) {
            return m3071G(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.e */
    private static abstract class C1085e extends C0917a<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.internal.gp.e.1 */
        class C09721 implements LoadMatchesResult {
            final /* synthetic */ C1085e IC;
            final /* synthetic */ Status vb;

            C09721(C1085e c1085e, Status status) {
                this.IC = c1085e;
                this.vb = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1085e() {
        }

        public LoadMatchesResult m3073H(Status status) {
            return new C09721(this, status);
        }

        public /* synthetic */ Result m3074d(Status status) {
            return m3073H(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.f */
    private static abstract class C1086f extends C0917a<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.internal.gp.f.1 */
        class C09731 implements UpdateMatchResult {
            final /* synthetic */ C1086f IE;
            final /* synthetic */ Status vb;

            C09731(C1086f c1086f, Status status) {
                this.IE = c1086f;
                this.vb = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        private C1086f() {
        }

        public UpdateMatchResult m3075I(Status status) {
            return new C09731(this, status);
        }

        public /* synthetic */ Result m3076d(Status status) {
            return m3075I(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.10 */
    class AnonymousClass10 extends C1085e {
        final /* synthetic */ gp Iq;
        final /* synthetic */ int Iw;
        final /* synthetic */ int[] Ix;

        AnonymousClass10(gp gpVar, int i, int[] iArr) {
            this.Iq = gpVar;
            this.Iw = i;
            this.Ix = iArr;
            super();
        }

        protected void m3266a(fx fxVar) {
            fxVar.m2674a((C0194c) this, this.Iw, this.Ix);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.1 */
    class C11731 extends C1082b {
        final /* synthetic */ TurnBasedMatchConfig Ip;
        final /* synthetic */ gp Iq;

        C11731(gp gpVar, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.Iq = gpVar;
            this.Ip = turnBasedMatchConfig;
            super();
        }

        protected void m3268a(fx fxVar) {
            fxVar.m2676a((C0194c) this, this.Ip);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.2 */
    class C11742 extends C1084d {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11742(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3270a(fx fxVar) {
            fxVar.m2714h(this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.3 */
    class C11753 extends C1082b {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11753(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3272a(fx fxVar) {
            fxVar.m2708d((C0194c) this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.4 */
    class C11764 extends C1082b {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Is;

        C11764(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Is = str;
            super();
        }

        protected void m3274a(fx fxVar) {
            fxVar.m2710e(this, this.Is);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.5 */
    class C11775 extends C1086f {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ byte[] It;
        final /* synthetic */ String Iu;
        final /* synthetic */ ParticipantResult[] Iv;

        C11775(gp gpVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.Iq = gpVar;
            this.Ir = str;
            this.It = bArr;
            this.Iu = str2;
            this.Iv = participantResultArr;
            super();
        }

        protected void m3276a(fx fxVar) {
            fxVar.m2685a((C0194c) this, this.Ir, this.It, this.Iu, this.Iv);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.6 */
    class C11786 extends C1086f {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ byte[] It;
        final /* synthetic */ ParticipantResult[] Iv;

        C11786(gp gpVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.Iq = gpVar;
            this.Ir = str;
            this.It = bArr;
            this.Iv = participantResultArr;
            super();
        }

        protected void m3278a(fx fxVar) {
            fxVar.m2686a((C0194c) this, this.Ir, this.It, this.Iv);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.7 */
    class C11797 extends C1083c {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11797(gp gpVar, String str) {
            this.Iq = gpVar;
            this.Ir = str;
            super();
        }

        protected void m3280a(fx fxVar) {
            fxVar.m2711f(this, this.Ir);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.8 */
    class C11808 extends C1083c {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;
        final /* synthetic */ String Iu;

        C11808(gp gpVar, String str, String str2) {
            this.Iq = gpVar;
            this.Ir = str;
            this.Iu = str2;
            super();
        }

        protected void m3282a(fx fxVar) {
            fxVar.m2682a((C0194c) this, this.Ir, this.Iu);
        }
    }

    /* renamed from: com.google.android.gms.internal.gp.9 */
    class C11819 extends C1081a {
        final /* synthetic */ gp Iq;
        final /* synthetic */ String Ir;

        C11819(gp gpVar, String str, String str2) {
            this.Iq = gpVar;
            this.Ir = str2;
            super(str);
        }

        protected void m3284a(fx fxVar) {
            fxVar.m2713g(this, this.Ir);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.m141b(new C11764(this, invitationId));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m141b(new C11819(this, matchId, matchId));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.m141b(new C11731(this, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m364c(apiClient).m2717m(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m364c(apiClient).m2716l(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m364c(apiClient).av(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.m141b(new C11786(this, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).ft();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fC();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m364c(apiClient).m2667a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m364c(apiClient).m2667a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m141b(new C11797(this, matchId));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.m141b(new C11808(this, matchId, pendingParticipantId));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m140a(new C11742(this, matchId));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.m140a(new AnonymousClass10(this, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m364c(apiClient).m2692a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m141b(new C11753(this, matchId));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.m141b(new C11775(this, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m364c(apiClient).fw();
    }
}
