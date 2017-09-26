package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.C0201b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0918b;
import com.google.android.gms.games.C0919d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.request.a */
public final class C0931a extends C0201b implements GameRequest {
    private final int IN;

    public C0931a(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.IN = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.m2439a(this, obj);
    }

    public ArrayList<Player> fU() {
        ArrayList<Player> arrayList = new ArrayList(this.IN);
        for (int i = 0; i < this.IN; i++) {
            arrayList.add(new C0919d(this.zU, this.zW + i, "recipient_"));
        }
        return arrayList;
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new C0918b(this.zU, this.zW);
    }

    public Player getRecipient() {
        return new C0919d(this.zU, this.zW, "recipient_");
    }

    public int getRecipientStatus() {
        return getInteger("recipient_status");
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.zW; i < this.zW + this.IN; i++) {
            int I = this.zU.m1541I(i);
            if (this.zU.getString("recipient_external_player_id", i, I).equals(playerId)) {
                return this.zU.getInteger("recipient_status", i, I);
            }
        }
        return -1;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new C0919d(this.zU, this.zW, "sender_");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.m2438a(this);
    }

    public boolean isConsumed() {
        return getRecipientStatus() == 1;
    }

    public String toString() {
        return GameRequestEntity.m2441c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
