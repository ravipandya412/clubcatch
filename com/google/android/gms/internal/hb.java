package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
import java.util.Set;

public final class hb {
    private static final String[] IH;
    private final HashMap<String, Integer> II;
    private final int yJ;

    /* renamed from: com.google.android.gms.internal.hb.a */
    public static final class C0346a {
        private HashMap<String, Integer> II;
        private int yJ;

        public C0346a() {
            this.II = new HashMap();
            this.yJ = 0;
        }

        public C0346a aZ(int i) {
            this.yJ = i;
            return this;
        }

        public hb fV() {
            return new hb(this.II, null);
        }

        public C0346a m953p(String str, int i) {
            if (gt.isValid(i)) {
                this.II.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    static {
        IH = new String[]{"requestId", "outcome"};
    }

    private hb(int i, HashMap<String, Integer> hashMap) {
        this.yJ = i;
        this.II = hashMap;
    }

    public static hb m954H(DataHolder dataHolder) {
        C0346a c0346a = new C0346a();
        c0346a.aZ(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int I = dataHolder.m1541I(i);
            c0346a.m953p(dataHolder.getString("requestId", i, I), dataHolder.getInteger("outcome", i, I));
        }
        return c0346a.fV();
    }

    public Set<String> getRequestIds() {
        return this.II.keySet();
    }

    public int getRequestOutcome(String requestId) {
        er.m724b(this.II.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.II.get(requestId)).intValue();
    }
}
