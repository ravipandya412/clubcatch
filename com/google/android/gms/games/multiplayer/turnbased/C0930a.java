package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.C0201b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0918b;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.C0927d;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.turnbased.a */
public final class C0930a extends C0201b implements TurnBasedMatch {
    private final Game IM;
    private final int IN;

    C0930a(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.IM = new C0918b(dataHolder, i);
        this.IN = i2;
    }

    public boolean canRematch() {
        return getTurnStatus() == 3 && getRematchId() == null && getParticipants().size() > 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return TurnBasedMatchEntity.m2432a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return new TurnBasedMatchEntity(this);
    }

    public Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : TurnBasedMatchConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public String getCreatorId() {
        return getString("creator_external");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m156a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public Participant getDescriptionParticipant() {
        return getParticipant(getDescriptionParticipantId());
    }

    public String getDescriptionParticipantId() {
        return getString("description_participant_id");
    }

    public Game getGame() {
        return this.IM;
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getLastUpdaterId() {
        return getString("last_updater_external");
    }

    public String getMatchId() {
        return getString("external_match_id");
    }

    public int getMatchNumber() {
        return getInteger("match_number");
    }

    public Participant getParticipant(String participantId) {
        return TurnBasedMatchEntity.m2435c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return TurnBasedMatchEntity.m2434b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return TurnBasedMatchEntity.m2436c(this);
    }

    public int getParticipantStatus(String participantId) {
        return TurnBasedMatchEntity.m2431a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.IN);
        for (int i = 0; i < this.IN; i++) {
            arrayList.add(new C0927d(this.zU, this.zW + i));
        }
        return arrayList;
    }

    public String getPendingParticipantId() {
        return getString("pending_participant_external");
    }

    public byte[] getPreviousMatchData() {
        return getByteArray("previous_match_data");
    }

    public String getRematchId() {
        return getString("rematch_id");
    }

    public int getStatus() {
        return getInteger(NotificationCompatApi21.CATEGORY_STATUS);
    }

    public int getTurnStatus() {
        return getInteger("user_match_status");
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int getVersion() {
        return getInteger("version");
    }

    public int hashCode() {
        return TurnBasedMatchEntity.m2430a(this);
    }

    public boolean isLocallyModified() {
        return getBoolean("upsync_required");
    }

    public String toString() {
        return TurnBasedMatchEntity.m2433b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((TurnBasedMatchEntity) freeze()).writeToParcel(dest, flags);
    }
}
