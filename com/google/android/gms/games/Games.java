package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gw;

public final class Games {
    public static final Api API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final Scope FY;
    public static final Api FZ;
    public static final Multiplayer Ga;
    public static final GamesMetadata GamesMetadata;
    public static final gw Gb;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    static final C0191b<fx> va;

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C06251 implements C0191b<fx> {
        C06251() {
        }

        public /* synthetic */ C0190a m1629b(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1630e(context, looper, eeVar, apiOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public fx m1630e(Context context, Looper looper, ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions;
            GamesOptions gamesOptions2 = new GamesOptions();
            if (apiOptions != null) {
                er.m724b(apiOptions instanceof GamesOptions, (Object) "Must provide valid GamesOptions!");
                gamesOptions = (GamesOptions) apiOptions;
            } else {
                gamesOptions = gamesOptions2;
            }
            return new fx(context, looper, eeVar.dV(), eeVar.dR(), connectionCallbacks, onConnectionFailedListener, eeVar.dU(), eeVar.dS(), eeVar.dW(), gamesOptions.Gc, gamesOptions.Gd, gamesOptions.Ge, gamesOptions.Gf, gamesOptions.Gg);
        }

        public int getPriority() {
            return 1;
        }
    }

    public static final class GamesOptions implements ApiOptions {
        final boolean Gc;
        final boolean Gd;
        final int Ge;
        final boolean Gf;
        final int Gg;

        public static final class Builder {
            boolean Gc;
            boolean Gd;
            int Ge;
            boolean Gf;
            int Gg;

            private Builder() {
                this.Gc = false;
                this.Gd = true;
                this.Ge = 17;
                this.Gf = false;
                this.Gg = 4368;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.Gg = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.Gd = showConnectingPopup;
                this.Ge = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.Gd = showConnectingPopup;
                this.Ge = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.Gc = false;
            this.Gd = true;
            this.Ge = 17;
            this.Gf = false;
            this.Gg = 4368;
        }

        private GamesOptions(Builder builder) {
            this.Gc = builder.Gc;
            this.Gd = builder.Gd;
            this.Ge = builder.Ge;
            this.Gf = builder.Gf;
            this.Gg = builder.Gg;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.games.Games.a */
    public static abstract class C0917a<R extends Result> extends C0592a<R, fx> implements PendingResult<R> {
        public C0917a() {
            super(Games.va);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.b */
    private static abstract class C1047b extends C0917a<Status> {
        private C1047b() {
        }

        public /* synthetic */ Result m2952d(Status status) {
            return m2953f(status);
        }

        public Status m2953f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C11452 extends C1047b {
        C11452() {
            super();
        }

        protected void m3200a(fx fxVar) {
            fxVar.m2696b((C0194c) this);
        }
    }

    static {
        va = new C06251();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api(va, SCOPE_GAMES);
        FY = new Scope("https://www.googleapis.com/auth/games.firstparty");
        FZ = new Api(va, FY);
        GamesMetadata = new gh();
        Achievements = new gf();
        Leaderboards = new gj();
        Invitations = new gi();
        TurnBasedMultiplayer = new gp();
        RealTimeMultiplayer = new gn();
        Ga = new gk();
        Players = new gm();
        Notifications = new gl();
        Requests = new go();
        Gb = new gg();
    }

    private Games() {
    }

    public static fx m364c(GoogleApiClient googleApiClient) {
        boolean z = true;
        er.m724b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        er.m721a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        fx fxVar = (fx) googleApiClient.m139a(va);
        if (fxVar == null) {
            z = false;
        }
        er.m721a(z, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return fxVar;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m364c(apiClient).fB();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m364c(apiClient).fn();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m364c(apiClient).fA();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m364c(apiClient).fz();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m364c(apiClient).aT(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        er.m725f(gamesContentView);
        m364c(apiClient).m2709e(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.m141b(new C11452());
    }
}
