package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;

public final class RoomEntity extends fy implements Room {
    public static final Creator<RoomEntity> CREATOR;
    private final String FH;
    private final String GU;
    private final Bundle JO;
    private final String JS;
    private final int JT;
    private final int JU;
    private final long Jr;
    private final ArrayList<ParticipantEntity> Ju;
    private final int Jv;
    private final int wj;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RoomEntity.a */
    static final class C0630a extends C0263b {
        C0630a() {
        }

        public RoomEntity aq(Parcel parcel) {
            if (fy.m2719c(eg.dY()) || eg.ae(RoomEntity.class.getCanonicalName())) {
                return super.aq(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return aq(x0);
        }
    }

    static {
        CREATOR = new C0630a();
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.wj = versionCode;
        this.GU = roomId;
        this.JS = creatorId;
        this.Jr = creationTimestamp;
        this.JT = roomStatus;
        this.FH = description;
        this.Jv = variant;
        this.JO = autoMatchCriteria;
        this.Ju = participants;
        this.JU = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.wj = 2;
        this.GU = room.getRoomId();
        this.JS = room.getCreatorId();
        this.Jr = room.getCreationTimestamp();
        this.JT = room.getStatus();
        this.FH = room.getDescription();
        this.Jv = room.getVariant();
        this.JO = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.Ju = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.Ju.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.JU = room.getAutoMatchWaitEstimateSeconds();
    }

    static int m2966a(Room room) {
        return ep.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int m2967a(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean m2968a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return ep.equal(room2.getRoomId(), room.getRoomId()) && ep.equal(room2.getCreatorId(), room.getCreatorId()) && ep.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && ep.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && ep.equal(room2.getDescription(), room.getDescription()) && ep.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && ep.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && ep.equal(room2.getParticipants(), room.getParticipants()) && ep.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String m2969b(Room room) {
        return ep.m717e(room).m716a("RoomId", room.getRoomId()).m716a("CreatorId", room.getCreatorId()).m716a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).m716a("RoomStatus", Integer.valueOf(room.getStatus())).m716a("Description", room.getDescription()).m716a("Variant", Integer.valueOf(room.getVariant())).m716a("AutoMatchCriteria", room.getAutoMatchCriteria()).m716a("Participants", room.getParticipants()).m716a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String m2970b(Room room, String str) {
        ArrayList participants = room.getParticipants();
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

    static Participant m2972c(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> m2973c(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m2968a((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.JO;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.JU;
    }

    public long getCreationTimestamp() {
        return this.Jr;
    }

    public String getCreatorId() {
        return this.JS;
    }

    public String getDescription() {
        return this.FH;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        fm.m775b(this.FH, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return m2972c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m2970b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m2973c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m2967a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.Ju);
    }

    public String getRoomId() {
        return this.GU;
    }

    public int getStatus() {
        return this.JT;
    }

    public int getVariant() {
        return this.Jv;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return m2966a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m2969b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (dZ()) {
            dest.writeString(this.GU);
            dest.writeString(this.JS);
            dest.writeLong(this.Jr);
            dest.writeInt(this.JT);
            dest.writeString(this.FH);
            dest.writeInt(this.Jv);
            dest.writeBundle(this.JO);
            int size = this.Ju.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.Ju.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        C0263b.m371a(this, dest, flags);
    }
}
