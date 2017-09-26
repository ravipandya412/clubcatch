package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.leaderboard.C0920a;
import com.google.android.gms.games.leaderboard.C0922d;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.C0928a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.eh.C0329b;
import com.google.android.gms.internal.eh.C0675d;
import com.google.android.gms.internal.eh.C0951e;
import com.google.android.gms.internal.gb.C0708a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class fx extends eh<gb> implements ConnectionCallbacks, OnConnectionFailedListener {
    private boolean GA;
    private boolean GB;
    private int GC;
    private final Binder GD;
    private final long GE;
    private final boolean GF;
    private final int GG;
    private final boolean GH;
    private final String Gv;
    private final Map<String, RealTimeSocket> Gw;
    private PlayerEntity Gx;
    private GameEntity Gy;
    private final gd Gz;
    private final String vi;

    final class aa extends C0329b<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GZ;

        aa(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener);
            this.GZ = str;
        }

        public void m1860a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.GZ);
            }
        }

        protected void cP() {
        }
    }

    final class ab extends C0329b<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GZ;

        ab(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener);
            this.GZ = str;
        }

        public void m1862a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.GZ);
            }
        }

        protected void cP() {
        }
    }

    final class am extends C0329b<ReliableMessageSentCallback> {
        final /* synthetic */ fx GJ;
        private final String Hc;
        private final int Hd;
        private final int yJ;

        am(fx fxVar, ReliableMessageSentCallback reliableMessageSentCallback, int i, int i2, String str) {
            this.GJ = fxVar;
            super(fxVar, reliableMessageSentCallback);
            this.yJ = i;
            this.Hd = i2;
            this.Hc = str;
        }

        public void m1864a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.yJ, this.Hd, this.Hc);
            }
        }

        protected void cP() {
        }
    }

    final class ap extends C0329b<OnRequestReceivedListener> {
        final /* synthetic */ fx GJ;
        private final GameRequest Hg;

        ap(fx fxVar, OnRequestReceivedListener onRequestReceivedListener, GameRequest gameRequest) {
            this.GJ = fxVar;
            super(fxVar, onRequestReceivedListener);
            this.Hg = gameRequest;
        }

        protected /* synthetic */ void m1866a(Object obj) {
            m1867b((OnRequestReceivedListener) obj);
        }

        protected void m1867b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Hg);
        }

        protected void cP() {
        }
    }

    final class aq extends C0329b<OnRequestReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String Hh;

        aq(fx fxVar, OnRequestReceivedListener onRequestReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onRequestReceivedListener);
            this.Hh = str;
        }

        protected /* synthetic */ void m1868a(Object obj) {
            m1869b((OnRequestReceivedListener) obj);
        }

        protected void m1869b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Hh);
        }

        protected void cP() {
        }
    }

    final class bc extends C0329b<C0194c<Status>> {
        final /* synthetic */ fx GJ;
        private final Status vl;

        public bc(fx fxVar, C0194c<Status> c0194c, Status status) {
            this.GJ = fxVar;
            super(fxVar, c0194c);
            this.vl = status;
        }

        public /* synthetic */ void m1870a(Object obj) {
            m1871c((C0194c) obj);
        }

        public void m1871c(C0194c<Status> c0194c) {
            c0194c.m147b(this.vl);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.m */
    final class C0699m extends C0329b<OnInvitationReceivedListener> {
        final /* synthetic */ fx GJ;
        private final Invitation GO;

        C0699m(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            this.GJ = fxVar;
            super(fxVar, onInvitationReceivedListener);
            this.GO = invitation;
        }

        protected /* synthetic */ void m1872a(Object obj) {
            m1873b((OnInvitationReceivedListener) obj);
        }

        protected void m1873b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.GO);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.n */
    final class C0700n extends C0329b<OnInvitationReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String GP;

        C0700n(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onInvitationReceivedListener);
            this.GP = str;
        }

        protected /* synthetic */ void m1874a(Object obj) {
            m1875b((OnInvitationReceivedListener) obj);
        }

        protected void m1875b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.GP);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.v */
    final class C0701v extends C0329b<RoomUpdateListener> {
        final /* synthetic */ fx GJ;
        private final String GU;
        private final int yJ;

        C0701v(fx fxVar, RoomUpdateListener roomUpdateListener, int i, String str) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener);
            this.yJ = i;
            this.GU = str;
        }

        public void m1876a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.yJ, this.GU);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.w */
    final class C0702w extends C0329b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ fx GJ;
        private final String GV;

        C0702w(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, String str) {
            this.GJ = fxVar;
            super(fxVar, onTurnBasedMatchUpdateReceivedListener);
            this.GV = str;
        }

        protected /* synthetic */ void m1878a(Object obj) {
            m1879b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m1879b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.GV);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.y */
    final class C0703y extends C0329b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ fx GJ;
        private final TurnBasedMatch GX;

        C0703y(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, TurnBasedMatch turnBasedMatch) {
            this.GJ = fxVar;
            super(fxVar, onTurnBasedMatchUpdateReceivedListener);
            this.GX = turnBasedMatch;
        }

        protected /* synthetic */ void m1880a(Object obj) {
            m1881b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m1881b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.GX);
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.z */
    final class C0704z extends C0329b<RealTimeMessageReceivedListener> {
        final /* synthetic */ fx GJ;
        private final RealTimeMessage GY;

        C0704z(fx fxVar, RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            this.GJ = fxVar;
            super(fxVar, realTimeMessageReceivedListener);
            this.GY = realTimeMessage;
        }

        public void m1882a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.GY);
            }
        }

        protected void cP() {
        }
    }

    final class aj extends C0675d<C0194c<LoadPlayerScoreResult>> implements LoadPlayerScoreResult {
        final /* synthetic */ fx GJ;
        private final C0922d Ha;
        private final Status vl;

        aj(fx fxVar, C0194c<LoadPlayerScoreResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.vl = new Status(dataHolder.getStatusCode());
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Ha = (C0922d) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Ha = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        protected void m2646a(C0194c<LoadPlayerScoreResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public LeaderboardScore getScore() {
            return this.Ha;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    final class as extends C0329b<C0194c<LoadRequestsResult>> implements LoadRequestsResult {
        final /* synthetic */ fx GJ;
        private final Bundle Hj;
        private final Status vl;

        as(fx fxVar, C0194c<LoadRequestsResult> c0194c, Status status, Bundle bundle) {
            this.GJ = fxVar;
            super(fxVar, c0194c);
            this.vl = status;
            this.Hj = bundle;
        }

        protected /* synthetic */ void m2648a(Object obj) {
            m2649c((C0194c) obj);
        }

        protected void m2649c(C0194c<LoadRequestsResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
            release();
        }

        public GameRequestBuffer getRequests(int requestType) {
            String aW = gs.aW(requestType);
            return !this.Hj.containsKey(aW) ? null : new GameRequestBuffer((DataHolder) this.Hj.get(aW));
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            for (String parcelable : this.Hj.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Hj.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    abstract class av<R extends C0194c<?>> extends C0675d<R> implements Releasable, Result {
        final /* synthetic */ fx GJ;
        final Status vl;
        final DataHolder zU;

        public av(fx fxVar, R r, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, r, dataHolder);
            this.vl = new Status(dataHolder.getStatusCode());
            this.zU = dataHolder;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            if (this.zU != null) {
                this.zU.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.b */
    abstract class C0954b extends C0675d<RoomUpdateListener> {
        final /* synthetic */ fx GJ;

        C0954b(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        protected void m2650a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            m2651a(roomUpdateListener, this.GJ.m2662G(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void m2651a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    final class bh extends C0329b<C0194c<CancelMatchResult>> implements CancelMatchResult {
        final /* synthetic */ fx GJ;
        private final String Hr;
        private final Status vl;

        bh(fx fxVar, C0194c<CancelMatchResult> c0194c, Status status, String str) {
            this.GJ = fxVar;
            super(fxVar, c0194c);
            this.vl = status;
            this.Hr = str;
        }

        public /* synthetic */ void m2653a(Object obj) {
            m2654c((C0194c) obj);
        }

        public void m2654c(C0194c<CancelMatchResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public String getMatchId() {
            return this.Hr;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    final class br extends C0329b<C0194c<LoadMatchesResult>> implements LoadMatchesResult {
        final /* synthetic */ fx GJ;
        private final LoadMatchesResponse Hx;
        private final Status vl;

        br(fx fxVar, C0194c<LoadMatchesResult> c0194c, Status status, Bundle bundle) {
            this.GJ = fxVar;
            super(fxVar, c0194c);
            this.vl = status;
            this.Hx = new LoadMatchesResponse(bundle);
        }

        protected /* synthetic */ void m2655a(Object obj) {
            m2656c((C0194c) obj);
        }

        protected void m2656c(C0194c<LoadMatchesResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public LoadMatchesResponse getMatches() {
            return this.Hx;
        }

        public Status getStatus() {
            return this.vl;
        }

        public void release() {
            this.Hx.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.c */
    abstract class C0955c extends C0675d<RoomStatusUpdateListener> {
        final /* synthetic */ fx GJ;

        C0955c(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        protected void m2657a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            m2658a(roomStatusUpdateListener, this.GJ.m2662G(dataHolder));
        }

        protected abstract void m2658a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.fx.e */
    final class C0956e extends C0329b<C0194c<UpdateAchievementResult>> implements UpdateAchievementResult {
        final /* synthetic */ fx GJ;
        private final String GK;
        private final Status vl;

        C0956e(fx fxVar, C0194c<UpdateAchievementResult> c0194c, int i, String str) {
            this.GJ = fxVar;
            super(fxVar, c0194c);
            this.vl = new Status(i);
            this.GK = str;
        }

        protected /* synthetic */ void m2660a(Object obj) {
            m2661c((C0194c) obj);
        }

        protected void m2661c(C0194c<UpdateAchievementResult> c0194c) {
            c0194c.m147b(this);
        }

        protected void cP() {
        }

        public String getAchievementId() {
            return this.GK;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.a */
    abstract class C1053a extends C0955c {
        private final ArrayList<String> GI;
        final /* synthetic */ fx GJ;

        C1053a(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
            this.GI = new ArrayList();
            for (Object add : strArr) {
                this.GI.add(add);
            }
        }

        protected void m2979a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m2980a(roomStatusUpdateListener, room, this.GI);
        }

        protected abstract void m2980a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    final class ai extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadPlayerScoreResult> vj;

        ai(fx fxVar, C0194c<LoadPlayerScoreResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m2981C(DataHolder dataHolder) {
            this.GJ.m1778a(new aj(this.GJ, this.vj, dataHolder));
        }
    }

    final class ak extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadPlayersResult> vj;

        ak(fx fxVar, C0194c<LoadPlayersResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m2982e(DataHolder dataHolder) {
            this.GJ.m1778a(new al(this.GJ, this.vj, dataHolder));
        }
    }

    final class al extends av<C0194c<LoadPlayersResult>> implements LoadPlayersResult {
        final /* synthetic */ fx GJ;
        private final PlayerBuffer Hb;

        al(fx fxVar, C0194c<LoadPlayersResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.Hb = new PlayerBuffer(dataHolder);
        }

        protected void m2983a(C0194c<LoadPlayersResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.Hb;
        }
    }

    final class an extends fw {
        final /* synthetic */ fx GJ;
        final ReliableMessageSentCallback He;

        public an(fx fxVar, ReliableMessageSentCallback reliableMessageSentCallback) {
            this.GJ = fxVar;
            this.He = reliableMessageSentCallback;
        }

        public void m2985b(int i, int i2, String str) {
            this.GJ.m1778a(new am(this.GJ, this.He, i, i2, str));
        }
    }

    final class ao extends fw {
        final /* synthetic */ fx GJ;
        private final OnRequestReceivedListener Hf;

        ao(fx fxVar, OnRequestReceivedListener onRequestReceivedListener) {
            this.GJ = fxVar;
            this.Hf = onRequestReceivedListener;
        }

        public void m2986m(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.GJ.m1778a(new ap(this.GJ, this.Hf, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.GJ.m1778a(new aq(this.GJ, this.Hf, requestId));
        }
    }

    final class ar extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadRequestsResult> Hi;

        public ar(fx fxVar, C0194c<LoadRequestsResult> c0194c) {
            this.GJ = fxVar;
            this.Hi = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m2987b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.GJ.m1778a(new as(this.GJ, this.Hi, new Status(i), bundle));
        }
    }

    final class at extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<UpdateRequestsResult> Hk;

        public at(fx fxVar, C0194c<UpdateRequestsResult> c0194c) {
            this.GJ = fxVar;
            this.Hk = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m2988D(DataHolder dataHolder) {
            this.GJ.m1778a(new au(this.GJ, this.Hk, dataHolder));
        }
    }

    final class au extends av<C0194c<UpdateRequestsResult>> implements UpdateRequestsResult {
        final /* synthetic */ fx GJ;
        private final hb Hl;

        au(fx fxVar, C0194c<UpdateRequestsResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.Hl = hb.m954H(dataHolder);
        }

        protected void m2989a(C0194c<UpdateRequestsResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public Set<String> getRequestIds() {
            return this.Hl.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.Hl.getRequestOutcome(requestId);
        }
    }

    final class aw extends C0955c {
        final /* synthetic */ fx GJ;

        aw(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m2991a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class ax extends fw {
        final /* synthetic */ fx GJ;
        private final RoomUpdateListener Hm;
        private final RoomStatusUpdateListener Hn;
        private final RealTimeMessageReceivedListener Ho;

        public ax(fx fxVar, RoomUpdateListener roomUpdateListener) {
            this.GJ = fxVar;
            this.Hm = (RoomUpdateListener) er.m723b((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.Hn = null;
            this.Ho = null;
        }

        public ax(fx fxVar, RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.GJ = fxVar;
            this.Hm = (RoomUpdateListener) er.m723b((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.Hn = roomStatusUpdateListener;
            this.Ho = realTimeMessageReceivedListener;
        }

        public void m2992a(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new af(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m2993b(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new ag(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m2994c(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new ah(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m2995d(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new ad(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m2996e(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new ac(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void m2997f(DataHolder dataHolder, String[] strArr) {
            this.GJ.m1778a(new ae(this.GJ, this.Hn, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.GJ.m1778a(new C0701v(this.GJ, this.Hm, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.GJ.m1778a(new aa(this.GJ, this.Hn, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.GJ.m1778a(new ab(this.GJ, this.Hn, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.GJ.m1778a(new C0704z(this.GJ, this.Ho, message));
        }

        public void m2998s(DataHolder dataHolder) {
            this.GJ.m1778a(new ba(this.GJ, this.Hm, dataHolder));
        }

        public void m2999t(DataHolder dataHolder) {
            this.GJ.m1778a(new C1064q(this.GJ, this.Hm, dataHolder));
        }

        public void m3000u(DataHolder dataHolder) {
            this.GJ.m1778a(new az(this.GJ, this.Hn, dataHolder));
        }

        public void m3001v(DataHolder dataHolder) {
            this.GJ.m1778a(new aw(this.GJ, this.Hn, dataHolder));
        }

        public void m3002w(DataHolder dataHolder) {
            this.GJ.m1778a(new ay(this.GJ, this.Hm, dataHolder));
        }

        public void m3003x(DataHolder dataHolder) {
            this.GJ.m1778a(new C1057h(this.GJ, this.Hn, dataHolder));
        }

        public void m3004y(DataHolder dataHolder) {
            this.GJ.m1778a(new C1058i(this.GJ, this.Hn, dataHolder));
        }
    }

    final class ay extends C0954b {
        final /* synthetic */ fx GJ;

        ay(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3005a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class az extends C0955c {
        final /* synthetic */ fx GJ;

        az(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3006a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class ba extends C0954b {
        final /* synthetic */ fx GJ;

        public ba(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3007a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class bb extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<Status> vj;

        public bb(fx fxVar, C0194c<Status> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void cM() {
            this.GJ.m1778a(new bc(this.GJ, this.vj, new Status(0)));
        }
    }

    final class bd extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<SubmitScoreResult> vj;

        public bd(fx fxVar, C0194c<SubmitScoreResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3008d(DataHolder dataHolder) {
            this.GJ.m1778a(new be(this.GJ, this.vj, dataHolder));
        }
    }

    final class be extends av<C0194c<SubmitScoreResult>> implements SubmitScoreResult {
        final /* synthetic */ fx GJ;
        private final ScoreSubmissionData Hp;

        public be(fx fxVar, C0194c<SubmitScoreResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            try {
                this.Hp = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public void m3009a(C0194c<SubmitScoreResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.Hp;
        }
    }

    abstract class bf<T extends C0194c<?>> extends av<T> {
        final /* synthetic */ fx GJ;
        final TurnBasedMatch GX;

        bf(fx fxVar, T t, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, t, dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.GX = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.GX = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        protected void m3011a(T t, DataHolder dataHolder) {
            m3013h(t);
        }

        public TurnBasedMatch getMatch() {
            return this.GX;
        }

        abstract void m3013h(T t);
    }

    final class bg extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<CancelMatchResult> Hq;

        public bg(fx fxVar, C0194c<CancelMatchResult> c0194c) {
            this.GJ = fxVar;
            this.Hq = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3014f(int i, String str) {
            this.GJ.m1778a(new bh(this.GJ, this.Hq, new Status(i), str));
        }
    }

    final class bi extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<InitiateMatchResult> Hs;

        public bi(fx fxVar, C0194c<InitiateMatchResult> c0194c) {
            this.GJ = fxVar;
            this.Hs = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3015o(DataHolder dataHolder) {
            this.GJ.m1778a(new bj(this.GJ, this.Hs, dataHolder));
        }
    }

    final class bk extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LeaveMatchResult> Ht;

        public bk(fx fxVar, C0194c<LeaveMatchResult> c0194c) {
            this.GJ = fxVar;
            this.Ht = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3016q(DataHolder dataHolder) {
            this.GJ.m1778a(new bl(this.GJ, this.Ht, dataHolder));
        }
    }

    final class bm extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadMatchResult> Hu;

        public bm(fx fxVar, C0194c<LoadMatchResult> c0194c) {
            this.GJ = fxVar;
            this.Hu = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3017n(DataHolder dataHolder) {
            this.GJ.m1778a(new bn(this.GJ, this.Hu, dataHolder));
        }
    }

    final class bo extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<UpdateMatchResult> Hv;

        public bo(fx fxVar, C0194c<UpdateMatchResult> c0194c) {
            this.GJ = fxVar;
            this.Hv = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3018p(DataHolder dataHolder) {
            this.GJ.m1778a(new bp(this.GJ, this.Hv, dataHolder));
        }
    }

    final class bq extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadMatchesResult> Hw;

        public bq(fx fxVar, C0194c<LoadMatchesResult> c0194c) {
            this.GJ = fxVar;
            this.Hw = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3019a(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.GJ.m1778a(new br(this.GJ, this.Hw, new Status(i), bundle));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.d */
    final class C1054d extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<UpdateAchievementResult> vj;

        C1054d(fx fxVar, C0194c<UpdateAchievementResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3020e(int i, String str) {
            this.GJ.m1778a(new C0956e(this.GJ, this.vj, i, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.f */
    final class C1055f extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadAchievementsResult> vj;

        C1055f(fx fxVar, C0194c<LoadAchievementsResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3021b(DataHolder dataHolder) {
            this.GJ.m1778a(new C1056g(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.g */
    final class C1056g extends av<C0194c<LoadAchievementsResult>> implements LoadAchievementsResult {
        final /* synthetic */ fx GJ;
        private final AchievementBuffer GL;

        C1056g(fx fxVar, C0194c<LoadAchievementsResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.GL = new AchievementBuffer(dataHolder);
        }

        protected void m3022a(C0194c<LoadAchievementsResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.GL;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.h */
    final class C1057h extends C0955c {
        final /* synthetic */ fx GJ;

        C1057h(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3024a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.i */
    final class C1058i extends C0955c {
        final /* synthetic */ fx GJ;

        C1058i(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder);
        }

        public void m3025a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.j */
    final class C1059j extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadGamesResult> vj;

        C1059j(fx fxVar, C0194c<LoadGamesResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3026g(DataHolder dataHolder) {
            this.GJ.m1778a(new C1060k(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.k */
    final class C1060k extends av<C0194c<LoadGamesResult>> implements LoadGamesResult {
        final /* synthetic */ fx GJ;
        private final GameBuffer GM;

        C1060k(fx fxVar, C0194c<LoadGamesResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.GM = new GameBuffer(dataHolder);
        }

        protected void m3027a(C0194c<LoadGamesResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public GameBuffer getGames() {
            return this.GM;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.l */
    final class C1061l extends fw {
        final /* synthetic */ fx GJ;
        private final OnInvitationReceivedListener GN;

        C1061l(fx fxVar, OnInvitationReceivedListener onInvitationReceivedListener) {
            this.GJ = fxVar;
            this.GN = onInvitationReceivedListener;
        }

        public void m3029l(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.GJ.m1778a(new C0699m(this.GJ, this.GN, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.GJ.m1778a(new C0700n(this.GJ, this.GN, invitationId));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.o */
    final class C1062o extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadInvitationsResult> vj;

        C1062o(fx fxVar, C0194c<LoadInvitationsResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3030k(DataHolder dataHolder) {
            this.GJ.m1778a(new C1063p(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.p */
    final class C1063p extends av<C0194c<LoadInvitationsResult>> implements LoadInvitationsResult {
        final /* synthetic */ fx GJ;
        private final InvitationBuffer GQ;

        C1063p(fx fxVar, C0194c<LoadInvitationsResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.GQ = new InvitationBuffer(dataHolder);
        }

        protected void m3031a(C0194c<LoadInvitationsResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.GQ;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.q */
    final class C1064q extends C0954b {
        final /* synthetic */ fx GJ;

        public C1064q(fx fxVar, RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, roomUpdateListener, dataHolder);
        }

        public void m3033a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.r */
    final class C1065r extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LoadScoresResult> vj;

        C1065r(fx fxVar, C0194c<LoadScoresResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3034a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.GJ.m1778a(new C1066s(this.GJ, this.vj, dataHolder, dataHolder2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.s */
    final class C1066s extends av<C0194c<LoadScoresResult>> implements LoadScoresResult {
        final /* synthetic */ fx GJ;
        private final C0920a GR;
        private final LeaderboardScoreBuffer GS;

        C1066s(fx fxVar, C0194c<LoadScoresResult> c0194c, DataHolder dataHolder, DataHolder dataHolder2) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.GR = (C0920a) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.GR = null;
                }
                leaderboardBuffer.close();
                this.GS = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        protected void m3035a(C0194c<LoadScoresResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.GR;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.GS;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.t */
    final class C1067t extends fw {
        final /* synthetic */ fx GJ;
        private final C0194c<LeaderboardMetadataResult> vj;

        C1067t(fx fxVar, C0194c<LeaderboardMetadataResult> c0194c) {
            this.GJ = fxVar;
            this.vj = (C0194c) er.m723b((Object) c0194c, (Object) "Holder must not be null");
        }

        public void m3037c(DataHolder dataHolder) {
            this.GJ.m1778a(new C1068u(this.GJ, this.vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.u */
    final class C1068u extends av<C0194c<LeaderboardMetadataResult>> implements LeaderboardMetadataResult {
        final /* synthetic */ fx GJ;
        private final LeaderboardBuffer GT;

        C1068u(fx fxVar, C0194c<LeaderboardMetadataResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
            this.GT = new LeaderboardBuffer(dataHolder);
        }

        protected void m3038a(C0194c<LeaderboardMetadataResult> c0194c, DataHolder dataHolder) {
            c0194c.m147b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.GT;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx.x */
    final class C1069x extends fw {
        final /* synthetic */ fx GJ;
        private final OnTurnBasedMatchUpdateReceivedListener GW;

        C1069x(fx fxVar, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            this.GJ = fxVar;
            this.GW = onTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.GJ.m1778a(new C0702w(this.GJ, this.GW, matchId));
        }

        public void m3040r(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.GJ.m1778a(new C0703y(this.GJ, this.GW, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    final class ac extends C1053a {
        final /* synthetic */ fx GJ;

        ac(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3201a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class ad extends C1053a {
        final /* synthetic */ fx GJ;

        ad(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3202a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class ae extends C1053a {
        final /* synthetic */ fx GJ;

        ae(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3203a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class af extends C1053a {
        final /* synthetic */ fx GJ;

        af(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3204a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class ag extends C1053a {
        final /* synthetic */ fx GJ;

        ag(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3205a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class ah extends C1053a {
        final /* synthetic */ fx GJ;

        ah(fx fxVar, RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            this.GJ = fxVar;
            super(fxVar, roomStatusUpdateListener, dataHolder, strArr);
        }

        protected void m3206a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class bj extends bf<C0194c<InitiateMatchResult>> implements InitiateMatchResult {
        final /* synthetic */ fx GJ;

        bj(fx fxVar, C0194c<InitiateMatchResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
        }

        protected void m3207h(C0194c<InitiateMatchResult> c0194c) {
            c0194c.m147b(this);
        }
    }

    final class bl extends bf<C0194c<LeaveMatchResult>> implements LeaveMatchResult {
        final /* synthetic */ fx GJ;

        bl(fx fxVar, C0194c<LeaveMatchResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
        }

        protected void m3208h(C0194c<LeaveMatchResult> c0194c) {
            c0194c.m147b(this);
        }
    }

    final class bn extends bf<C0194c<LoadMatchResult>> implements LoadMatchResult {
        final /* synthetic */ fx GJ;

        bn(fx fxVar, C0194c<LoadMatchResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
        }

        protected void m3209h(C0194c<LoadMatchResult> c0194c) {
            c0194c.m147b(this);
        }
    }

    final class bp extends bf<C0194c<UpdateMatchResult>> implements UpdateMatchResult {
        final /* synthetic */ fx GJ;

        bp(fx fxVar, C0194c<UpdateMatchResult> c0194c, DataHolder dataHolder) {
            this.GJ = fxVar;
            super(fxVar, c0194c, dataHolder);
        }

        protected void m3210h(C0194c<UpdateMatchResult> c0194c) {
            c0194c.m147b(this);
        }
    }

    public fx(Context context, Looper looper, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z, boolean z2, int i2, boolean z3, int i3) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.GA = false;
        this.GB = false;
        this.Gv = str;
        this.vi = (String) er.m725f(str2);
        this.GD = new Binder();
        this.Gw = new HashMap();
        this.Gz = gd.m945a(this, i);
        m2709e(view);
        this.GB = z2;
        this.GC = i2;
        this.GE = (long) hashCode();
        this.GF = z;
        this.GH = z3;
        this.GG = i3;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private Room m2662G(DataHolder dataHolder) {
        C0928a c0928a = new C0928a(dataHolder);
        Room room = null;
        try {
            if (c0928a.getCount() > 0) {
                room = (Room) ((Room) c0928a.get(0)).freeze();
            }
            c0928a.close();
            return room;
        } catch (Throwable th) {
            c0928a.close();
        }
    }

    private RealTimeSocket aw(String str) {
        try {
            ParcelFileDescriptor aD = ((gb) eb()).aD(str);
            RealTimeSocket gcVar;
            if (aD != null) {
                fz.m779f("GamesClientImpl", "Created native libjingle socket.");
                gcVar = new gc(aD);
                this.Gw.put(str, gcVar);
                return gcVar;
            }
            fz.m779f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String ay = ((gb) eb()).ay(str);
            if (ay == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(ay));
                gcVar = new ge(localSocket, str);
                this.Gw.put(str, gcVar);
                return gcVar;
            } catch (IOException e) {
                fz.m781h("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            fz.m781h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void fG() {
        for (RealTimeSocket close : this.Gw.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                fz.m778a("GamesClientImpl", "IOException:", e);
            }
        }
        this.Gw.clear();
    }

    private void fm() {
        this.Gx = null;
    }

    protected gb m2664H(IBinder iBinder) {
        return C0708a.m2048J(iBinder);
    }

    public int m2665a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((gb) eb()).m827a(new an(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int m2666a(byte[] bArr, String str, String[] strArr) {
        er.m723b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((gb) eb()).m875b(bArr, str, strArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent m2667a(int i, int i2, boolean z) {
        try {
            return ((gb) eb()).m828a(i, i2, z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m2668a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((gb) eb()).m829a(i, bArr, i2, str);
            er.m723b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m2669a(Room room, int i) {
        try {
            return ((gb) eb()).m830a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void m2670a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.GA = bundle.getBoolean("show_welcome_popup");
        }
        super.m1777a(i, iBinder, bundle);
    }

    public void m2671a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((gb) eb()).m835a(iBinder, bundle);
            } catch (RemoteException e) {
                fz.m780g("GamesClientImpl", "service died");
            }
        }
    }

    public void m2672a(C0194c<LoadRequestsResult> c0194c, int i, int i2, int i3) {
        try {
            ((gb) eb()).m838a(new ar(this, c0194c), i, i2, i3);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2673a(C0194c<LoadPlayersResult> c0194c, int i, boolean z, boolean z2) {
        try {
            ((gb) eb()).m841a(new ak(this, c0194c), i, z, z2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2674a(C0194c<LoadMatchesResult> c0194c, int i, int[] iArr) {
        try {
            ((gb) eb()).m842a(new bq(this, c0194c), i, iArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2675a(C0194c<LoadScoresResult> c0194c, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((gb) eb()).m845a(new C1065r(this, c0194c), leaderboardScoreBuffer.fX().fY(), i, i2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2676a(C0194c<InitiateMatchResult> c0194c, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((gb) eb()).m840a(new bi(this, c0194c), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2677a(C0194c<LoadPlayersResult> c0194c, String str) {
        try {
            ((gb) eb()).m848a(new ak(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2678a(C0194c<UpdateAchievementResult> c0194c, String str, int i) {
        try {
            ((gb) eb()).m851a(c0194c == null ? null : new C1054d(this, c0194c), str, i, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2679a(C0194c<LoadScoresResult> c0194c, String str, int i, int i2, int i3, boolean z) {
        try {
            ((gb) eb()).m850a(new C1065r(this, c0194c), str, i, i2, i3, z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2680a(C0194c<LoadPlayersResult> c0194c, String str, int i, boolean z, boolean z2) {
        if (str.equals("playedWith")) {
            try {
                ((gb) eb()).m910d(new ak(this, c0194c), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                fz.m780g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m2681a(C0194c<SubmitScoreResult> c0194c, String str, long j, String str2) {
        try {
            ((gb) eb()).m857a(c0194c == null ? null : new bd(this, c0194c), str, j, str2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2682a(C0194c<LeaveMatchResult> c0194c, String str, String str2) {
        try {
            ((gb) eb()).m902c(new bk(this, c0194c), str, str2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2683a(C0194c<LoadPlayerScoreResult> c0194c, String str, String str2, int i, int i2) {
        try {
            ((gb) eb()).m860a(new ai(this, c0194c), str, str2, i, i2);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2684a(C0194c<LeaderboardMetadataResult> c0194c, String str, boolean z) {
        try {
            ((gb) eb()).m903c(new C1067t(this, c0194c), str, z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2685a(C0194c<UpdateMatchResult> c0194c, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((gb) eb()).m867a(new bo(this, c0194c), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2686a(C0194c<UpdateMatchResult> c0194c, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((gb) eb()).m868a(new bo(this, c0194c), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2687a(C0194c<LoadPlayersResult> c0194c, boolean z) {
        try {
            ((gb) eb()).m904c(new ak(this, c0194c), z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2688a(C0194c<UpdateRequestsResult> c0194c, String[] strArr) {
        try {
            ((gb) eb()).m874a(new at(this, c0194c), strArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2689a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((gb) eb()).m843a(new C1061l(this, onInvitationReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2690a(RoomConfig roomConfig) {
        try {
            ((gb) eb()).m846a(new ax(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.GD, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2691a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((gb) eb()).m900c(new ax(this, roomUpdateListener), str);
            fG();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2692a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((gb) eb()).m880b(new C1069x(this, onTurnBasedMatchUpdateReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2693a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((gb) eb()).m898c(new ao(this, onRequestReceivedListener), this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    protected void m2694a(en enVar, C0951e c0951e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.GF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.GB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.GC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.GH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.GG);
        enVar.m697a(c0951e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.vi, ea(), this.Gv, this.Gz.fP(), locale, bundle);
    }

    protected String aF() {
        return "com.google.android.gms.games.service.START";
    }

    protected String aG() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void aT(int i) {
        this.Gz.setGravity(i);
    }

    public void aU(int i) {
        try {
            ((gb) eb()).aU(i);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public Intent au(String str) {
        try {
            return ((gb) eb()).au(str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void av(String str) {
        try {
            ((gb) eb()).aC(str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public Intent m2695b(int i, int i2, boolean z) {
        try {
            return ((gb) eb()).m876b(i, i2, z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m2696b(C0194c<Status> c0194c) {
        try {
            ((gb) eb()).m836a(new bb(this, c0194c));
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2697b(C0194c<UpdateAchievementResult> c0194c, String str) {
        if (c0194c == null) {
            ga gaVar = null;
        } else {
            Object c1054d = new C1054d(this, c0194c);
        }
        try {
            ((gb) eb()).m858a(gaVar, str, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2698b(C0194c<UpdateAchievementResult> c0194c, String str, int i) {
        try {
            ((gb) eb()).m884b(c0194c == null ? null : new C1054d(this, c0194c), str, i, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2699b(C0194c<LoadScoresResult> c0194c, String str, int i, int i2, int i3, boolean z) {
        try {
            ((gb) eb()).m883b(new C1065r(this, c0194c), str, i, i2, i3, z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2700b(C0194c<LeaderboardMetadataResult> c0194c, boolean z) {
        try {
            ((gb) eb()).m892b(new C1067t(this, c0194c), z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2701b(C0194c<UpdateRequestsResult> c0194c, String[] strArr) {
        try {
            ((gb) eb()).m893b(new at(this, c0194c), strArr);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2702b(RoomConfig roomConfig) {
        try {
            ((gb) eb()).m847a(new ax(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.GD, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    protected void m2703b(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            er.m721a(!z, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        er.m721a(z, String.format("Games APIs requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    public void m2704c(C0194c<LoadInvitationsResult> c0194c, int i) {
        try {
            ((gb) eb()).m837a(new C1062o(this, c0194c), i);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2705c(C0194c<UpdateAchievementResult> c0194c, String str) {
        if (c0194c == null) {
            ga gaVar = null;
        } else {
            Object c1054d = new C1054d(this, c0194c);
        }
        try {
            ((gb) eb()).m887b(gaVar, str, this.Gz.fP(), this.Gz.fO());
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2706c(C0194c<LoadAchievementsResult> c0194c, boolean z) {
        try {
            ((gb) eb()).m871a(new C1055f(this, c0194c), z);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public Bundle cY() {
        try {
            Bundle cY = ((gb) eb()).cY();
            if (cY == null) {
                return cY;
            }
            cY.setClassLoader(fx.class.getClassLoader());
            return cY;
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void connect() {
        fm();
        super.connect();
    }

    public int m2707d(byte[] bArr, String str) {
        try {
            return ((gb) eb()).m875b(bArr, str, null);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m2708d(C0194c<InitiateMatchResult> c0194c, String str) {
        try {
            ((gb) eb()).m930l(new bi(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.GA = false;
        if (isConnected()) {
            try {
                gb gbVar = (gb) eb();
                gbVar.fH();
                gbVar.m934n(this.GE);
            } catch (RemoteException e) {
                fz.m780g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        fG();
        super.disconnect();
    }

    public void m2709e(View view) {
        this.Gz.m946f(view);
    }

    public void m2710e(C0194c<InitiateMatchResult> c0194c, String str) {
        try {
            ((gb) eb()).m932m(new bi(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2711f(C0194c<LeaveMatchResult> c0194c, String str) {
        try {
            ((gb) eb()).m938o(new bk(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public int fA() {
        try {
            return ((gb) eb()).fA();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String fB() {
        try {
            return ((gb) eb()).fB();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int fC() {
        try {
            return ((gb) eb()).fC();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public Intent fD() {
        try {
            return ((gb) eb()).fD();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int fE() {
        try {
            return ((gb) eb()).fE();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public int fF() {
        try {
            return ((gb) eb()).fF();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public void fH() {
        if (isConnected()) {
            try {
                ((gb) eb()).fH();
            } catch (RemoteException e) {
                fz.m780g("GamesClientImpl", "service died");
            }
        }
    }

    public String fn() {
        try {
            return ((gb) eb()).fn();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public String fo() {
        try {
            return ((gb) eb()).fo();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player fp() {
        bm();
        synchronized (this) {
            if (this.Gx == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((gb) eb()).fI());
                    if (playerBuffer.getCount() > 0) {
                        this.Gx = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    fz.m780g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Gx;
    }

    public Game fq() {
        bm();
        synchronized (this) {
            if (this.Gy == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((gb) eb()).fK());
                    if (gameBuffer.getCount() > 0) {
                        this.Gy = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    fz.m780g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Gy;
    }

    public Intent fr() {
        try {
            return ((gb) eb()).fr();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fs() {
        try {
            return ((gb) eb()).fs();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent ft() {
        try {
            return ((gb) eb()).ft();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fu() {
        try {
            return ((gb) eb()).fu();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void fv() {
        try {
            ((gb) eb()).m937o(this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void fw() {
        try {
            ((gb) eb()).m940p(this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void fx() {
        try {
            ((gb) eb()).m942q(this.GE);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public Intent fy() {
        try {
            return ((gb) eb()).fy();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent fz() {
        try {
            return ((gb) eb()).fz();
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m2712g(C0194c<LoadGamesResult> c0194c) {
        try {
            ((gb) eb()).m907d(new C1059j(this, c0194c));
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2713g(C0194c<CancelMatchResult> c0194c, String str) {
        try {
            ((gb) eb()).m935n(new bg(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2714h(C0194c<LoadMatchResult> c0194c, String str) {
        try {
            ((gb) eb()).m941p(new bm(this, c0194c), str);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket m2715i(String str, String str2) {
        if (str2 == null || !ParticipantUtils.aE(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Gw.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aw(str2) : realTimeSocket;
    }

    public void m2716l(String str, int i) {
        try {
            ((gb) eb()).m931l(str, i);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void m2717m(String str, int i) {
        try {
            ((gb) eb()).m933m(str, i);
        } catch (RemoteException e) {
            fz.m780g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.GA) {
            this.Gz.fN();
            this.GA = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.GA = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    protected /* synthetic */ IInterface m2718p(IBinder iBinder) {
        return m2664H(iBinder);
    }
}
