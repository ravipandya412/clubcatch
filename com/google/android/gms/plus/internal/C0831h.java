package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C0831h implements SafeParcelable {
    public static final C0417j CREATOR;
    private final String[] Rm;
    private final String[] Rn;
    private final String[] Ro;
    private final String Rp;
    private final String Rq;
    private final String Rr;
    private final String Rs;
    private final PlusCommonExtras Rt;
    private final String vi;
    private final int wj;

    static {
        CREATOR = new C0417j();
    }

    C0831h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.wj = i;
        this.vi = str;
        this.Rm = strArr;
        this.Rn = strArr2;
        this.Ro = strArr3;
        this.Rp = str2;
        this.Rq = str3;
        this.Rr = str4;
        this.Rs = str5;
        this.Rt = plusCommonExtras;
    }

    public C0831h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.wj = 1;
        this.vi = str;
        this.Rm = strArr;
        this.Rn = strArr2;
        this.Ro = strArr3;
        this.Rp = str2;
        this.Rq = str3;
        this.Rr = str4;
        this.Rs = null;
        this.Rt = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0831h)) {
            return false;
        }
        C0831h c0831h = (C0831h) obj;
        return this.wj == c0831h.wj && ep.equal(this.vi, c0831h.vi) && Arrays.equals(this.Rm, c0831h.Rm) && Arrays.equals(this.Rn, c0831h.Rn) && Arrays.equals(this.Ro, c0831h.Ro) && ep.equal(this.Rp, c0831h.Rp) && ep.equal(this.Rq, c0831h.Rq) && ep.equal(this.Rr, c0831h.Rr) && ep.equal(this.Rs, c0831h.Rs) && ep.equal(this.Rt, c0831h.Rt);
    }

    public String getAccountName() {
        return this.vi;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public int hashCode() {
        return ep.hashCode(Integer.valueOf(this.wj), this.vi, this.Rm, this.Rn, this.Ro, this.Rp, this.Rq, this.Rr, this.Rs, this.Rt);
    }

    public String[] hq() {
        return this.Rm;
    }

    public String[] hr() {
        return this.Rn;
    }

    public String[] hs() {
        return this.Ro;
    }

    public String ht() {
        return this.Rp;
    }

    public String hu() {
        return this.Rq;
    }

    public String hv() {
        return this.Rr;
    }

    public String hw() {
        return this.Rs;
    }

    public PlusCommonExtras hx() {
        return this.Rt;
    }

    public Bundle hy() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.Rt.m2202m(bundle);
        return bundle;
    }

    public String toString() {
        return ep.m717e(this).m716a("versionCode", Integer.valueOf(this.wj)).m716a("accountName", this.vi).m716a("requestedScopes", this.Rm).m716a("visibleActivities", this.Rn).m716a("requiredFeatures", this.Ro).m716a("packageNameForAuth", this.Rp).m716a("callingPackageName", this.Rq).m716a("applicationName", this.Rr).m716a("extra", this.Rt.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0417j.m1212a(this, out, flags);
    }
}
