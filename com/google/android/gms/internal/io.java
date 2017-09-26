package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.pkr.clubcatch.C0519R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class io extends fb implements SafeParcelable, Moment {
    public static final ip CREATOR;
    private static final HashMap<String, C0696a<?, ?>> RL;
    private String Oc;
    private final Set<Integer> RM;
    private im SH;
    private im SI;
    private String Sz;
    private String uS;
    private final int wj;

    static {
        CREATOR = new ip();
        RL = new HashMap();
        RL.put("id", C0696a.m1840j("id", 2));
        RL.put("result", C0696a.m1834a("result", 4, im.class));
        RL.put("startDate", C0696a.m1840j("startDate", 5));
        RL.put("target", C0696a.m1834a("target", 6, im.class));
        RL.put("type", C0696a.m1840j("type", 7));
    }

    public io() {
        this.wj = 1;
        this.RM = new HashSet();
    }

    io(Set<Integer> set, int i, String str, im imVar, String str2, im imVar2, String str3) {
        this.RM = set;
        this.wj = i;
        this.uS = str;
        this.SH = imVar;
        this.Sz = str2;
        this.SI = imVar2;
        this.Oc = str3;
    }

    public io(Set<Integer> set, String str, im imVar, String str2, im imVar2, String str3) {
        this.RM = set;
        this.wj = 1;
        this.uS = str;
        this.SH = imVar;
        this.Sz = str2;
        this.SI = imVar2;
        this.Oc = str3;
    }

    protected boolean m2740a(C0696a c0696a) {
        return this.RM.contains(Integer.valueOf(c0696a.eu()));
    }

    protected Object ak(String str) {
        return null;
    }

    protected boolean al(String str) {
        return false;
    }

    protected Object m2741b(C0696a c0696a) {
        switch (c0696a.eu()) {
            case DetectedActivity.ON_FOOT /*2*/:
                return this.uS;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.SH;
            case DetectedActivity.TILTING /*5*/:
                return this.Sz;
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return this.SI;
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                return this.Oc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
        }
    }

    public int describeContents() {
        ip ipVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0696a<?, ?>> en() {
        return RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof io)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        io ioVar = (io) obj;
        for (C0696a c0696a : RL.values()) {
            if (m2740a(c0696a)) {
                if (!ioVar.m2740a(c0696a)) {
                    return false;
                }
                if (!m2741b(c0696a).equals(ioVar.m2741b(c0696a))) {
                    return false;
                }
            } else if (ioVar.m2740a(c0696a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return hU();
    }

    public String getId() {
        return this.uS;
    }

    public ItemScope getResult() {
        return this.SH;
    }

    public String getStartDate() {
        return this.Sz;
    }

    public ItemScope getTarget() {
        return this.SI;
    }

    public String getType() {
        return this.Oc;
    }

    int getVersionCode() {
        return this.wj;
    }

    Set<Integer> hB() {
        return this.RM;
    }

    im hS() {
        return this.SH;
    }

    im hT() {
        return this.SI;
    }

    public io hU() {
        return this;
    }

    public boolean hasId() {
        return this.RM.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.RM.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.RM.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.RM.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.RM.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0696a c0696a : RL.values()) {
            int hashCode;
            if (m2740a(c0696a)) {
                hashCode = m2741b(c0696a).hashCode() + (i + c0696a.eu());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        ip ipVar = CREATOR;
        ip.m991a(this, out, flags);
    }
}
