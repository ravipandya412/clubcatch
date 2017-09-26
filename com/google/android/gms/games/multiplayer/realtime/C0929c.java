package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.C0201b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.C0927d;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.c */
public final class C0929c extends C0201b implements Room {
    private final int IN;

    C0929c(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.IN = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return RoomEntity.m2968a((Room) this, obj);
    }

    public Room freeze() {
        return new RoomEntity(this);
    }

    public Bundle getAutoMatchCriteria() {
        return !getBoolean("has_automatch_criteria") ? null : RoomConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return getInteger("automatch_wait_estimate_sec");
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public String getCreatorId() {
        return getString("creator_external");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m156a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return RoomEntity.m2972c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return RoomEntity.m2970b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return RoomEntity.m2973c(this);
    }

    public int getParticipantStatus(String participantId) {
        return RoomEntity.m2967a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> arrayList = new ArrayList(this.IN);
        for (int i = 0; i < this.IN; i++) {
            arrayList.add(new C0927d(this.zU, this.zW + i));
        }
        return arrayList;
    }

    public String getRoomId() {
        return getString("external_match_id");
    }

    public int getStatus() {
        return getInteger(NotificationCompatApi21.CATEGORY_STATUS);
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return RoomEntity.m2966a(this);
    }

    public String toString() {
        return RoomEntity.m2969b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((RoomEntity) freeze()).writeToParcel(dest, flags);
    }
}
