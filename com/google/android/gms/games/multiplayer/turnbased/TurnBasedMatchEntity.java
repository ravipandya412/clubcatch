package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR;
    private final String FH;
    private final String GV;
    private final Bundle JO;
    private final String JS;
    private final GameEntity Jq;
    private final long Jr;
    private final ArrayList<ParticipantEntity> Ju;
    private final int Jv;
    private final String Ka;
    private final long Kb;
    private final String Kc;
    private final int Kd;
    private final int Ke;
    private final byte[] Kf;
    private final String Kg;
    private final byte[] Kh;
    private final int Ki;
    private final int Kj;
    private final boolean Kk;
    private final String Kl;
    private final int wj;

    static {
        CREATOR = new TurnBasedMatchEntityCreator();
    }

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.wj = versionCode;
        this.Jq = game;
        this.GV = matchId;
        this.JS = creatorId;
        this.Jr = creationTimestamp;
        this.Ka = lastUpdaterId;
        this.Kb = lastUpdatedTimestamp;
        this.Kc = pendingParticipantId;
        this.Kd = matchStatus;
        this.Kj = turnStatus;
        this.Jv = variant;
        this.Ke = version;
        this.Kf = data;
        this.Ju = participants;
        this.Kg = rematchId;
        this.Kh = previousData;
        this.Ki = matchNumber;
        this.JO = autoMatchCriteria;
        this.Kk = isLocallyModified;
        this.FH = description;
        this.Kl = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.wj = 2;
        this.Jq = new GameEntity(match.getGame());
        this.GV = match.getMatchId();
        this.JS = match.getCreatorId();
        this.Jr = match.getCreationTimestamp();
        this.Ka = match.getLastUpdaterId();
        this.Kb = match.getLastUpdatedTimestamp();
        this.Kc = match.getPendingParticipantId();
        this.Kd = match.getStatus();
        this.Kj = match.getTurnStatus();
        this.Jv = match.getVariant();
        this.Ke = match.getVersion();
        this.Kg = match.getRematchId();
        this.Ki = match.getMatchNumber();
        this.JO = match.getAutoMatchCriteria();
        this.Kk = match.isLocallyModified();
        this.FH = match.getDescription();
        this.Kl = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.Kf = null;
        } else {
            this.Kf = new byte[data.length];
            System.arraycopy(data, 0, this.Kf, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.Kh = null;
        } else {
            this.Kh = new byte[data.length];
            System.arraycopy(data, 0, this.Kh, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.Ju = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.Ju.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int m2430a(TurnBasedMatch turnBasedMatch) {
        return ep.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int m2431a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean m2432a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return ep.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && ep.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && ep.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && ep.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && ep.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && ep.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && ep.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && ep.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && ep.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && ep.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && ep.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && ep.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && ep.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && ep.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && ep.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && ep.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && ep.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && ep.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String m2433b(TurnBasedMatch turnBasedMatch) {
        return ep.m717e(turnBasedMatch).m716a("Game", turnBasedMatch.getGame()).m716a("MatchId", turnBasedMatch.getMatchId()).m716a("CreatorId", turnBasedMatch.getCreatorId()).m716a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).m716a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).m716a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).m716a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).m716a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).m716a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).m716a("Description", turnBasedMatch.getDescription()).m716a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).m716a("Data", turnBasedMatch.getData()).m716a("Version", Integer.valueOf(turnBasedMatch.getVersion())).m716a("Participants", turnBasedMatch.getParticipants()).m716a("RematchId", turnBasedMatch.getRematchId()).m716a("PreviousData", turnBasedMatch.getPreviousMatchData()).m716a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).m716a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).m716a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).m716a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).m716a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String m2434b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant m2435c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> m2436c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.Kd == 2 && this.Kg == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2432a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.JO;
    }

    public int getAvailableAutoMatchSlots() {
        return this.JO == null ? 0 : this.JO.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.Jr;
    }

    public String getCreatorId() {
        return this.JS;
    }

    public byte[] getData() {
        return this.Kf;
    }

    public String getDescription() {
        return this.FH;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        fm.m775b(this.FH, dataOut);
    }

    public Participant getDescriptionParticipant() {
        return getParticipant(getDescriptionParticipantId());
    }

    public String getDescriptionParticipantId() {
        return this.Kl;
    }

    public Game getGame() {
        return this.Jq;
    }

    public long getLastUpdatedTimestamp() {
        return this.Kb;
    }

    public String getLastUpdaterId() {
        return this.Ka;
    }

    public String getMatchId() {
        return this.GV;
    }

    public int getMatchNumber() {
        return this.Ki;
    }

    public Participant getParticipant(String participantId) {
        return m2435c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m2434b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m2436c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m2431a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.Ju);
    }

    public String getPendingParticipantId() {
        return this.Kc;
    }

    public byte[] getPreviousMatchData() {
        return this.Kh;
    }

    public String getRematchId() {
        return this.Kg;
    }

    public int getStatus() {
        return this.Kd;
    }

    public int getTurnStatus() {
        return this.Kj;
    }

    public int getVariant() {
        return this.Jv;
    }

    public int getVersion() {
        return this.Ke;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return m2430a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.Kk;
    }

    public String toString() {
        return m2433b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.m373a(this, out, flags);
    }
}
