package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class hx extends hm implements SafeParcelable {
    public static final hy CREATOR;
    private final Bundle Od;
    private final hz Oe;
    private final LatLng Of;
    private final float Og;
    private final LatLngBounds Oh;
    private final String Oi;
    private final Uri Oj;
    private final boolean Ok;
    private final float Ol;
    private final int Om;
    private final long On;
    private final List<ht> Oo;
    private final Map<ht, String> Op;
    private final TimeZone Oq;
    private Locale Or;
    private ic Os;
    private final String uS;
    final int wj;

    /* renamed from: com.google.android.gms.internal.hx.a */
    public static final class C0723a implements SafeParcelable {
        public static final hw CREATOR;
        private final String LE;
        private final String Ot;
        private final int Ou;
        private final String mTag;
        final int wj;

        /* renamed from: com.google.android.gms.internal.hx.a.a */
        public static class C0349a {
            private final String LE;
            private String Ot;
            private int Ou;
            private final String mTag;

            public C0349a(String str, String str2) {
                this.LE = str;
                this.mTag = str2;
            }

            public C0349a aK(String str) {
                this.Ot = str;
                return this;
            }

            public C0349a bv(int i) {
                this.Ou = i;
                return this;
            }

            public C0723a gJ() {
                return new C0723a(0, this.LE, this.mTag, this.Ot, this.Ou);
            }
        }

        static {
            CREATOR = new hw();
        }

        C0723a(int i, String str, String str2, String str3, int i2) {
            this.wj = i;
            this.LE = str;
            this.mTag = str2;
            this.Ot = str3;
            this.Ou = i2;
        }

        public int describeContents() {
            hw hwVar = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof C0723a)) {
                return false;
            }
            C0723a c0723a = (C0723a) object;
            return this.LE.equals(c0723a.LE) && ep.equal(this.mTag, c0723a.mTag);
        }

        public String gH() {
            return this.Ot;
        }

        public int gI() {
            return this.Ou;
        }

        public String getTag() {
            return this.mTag;
        }

        public String gt() {
            return this.LE;
        }

        public int hashCode() {
            return ep.hashCode(this.LE, this.mTag, this.Ot, Integer.valueOf(this.Ou));
        }

        public String toString() {
            return ep.m717e(this).m716a("placeId", this.LE).m716a("tag", this.mTag).m716a("callingAppPackageName", this.Ot).m716a("callingAppVersionCode", Integer.valueOf(this.Ou)).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            hw hwVar = CREATOR;
            hw.m983a(this, parcel, flags);
        }
    }

    static {
        CREATOR = new hy();
    }

    hx(int i, String str, List<ht> list, Bundle bundle, hz hzVar, LatLng latLng, float f, LatLngBounds latLngBounds, String str2, Uri uri, boolean z, float f2, int i2, long j) {
        this.wj = i;
        this.uS = str;
        this.Oo = Collections.unmodifiableList(list);
        this.Od = bundle;
        this.Oe = hzVar;
        this.Of = latLng;
        this.Og = f;
        this.Oh = latLngBounds;
        this.Oi = str2;
        this.Oj = uri;
        this.Ok = z;
        this.Ol = f2;
        this.Om = i2;
        this.On = j;
        Map hashMap = new HashMap();
        for (String str3 : bundle.keySet()) {
            hashMap.put(ht.aI(str3), bundle.getString(str3));
        }
        this.Op = Collections.unmodifiableMap(hashMap);
        this.Oq = TimeZone.getTimeZone(this.Oi);
        this.Or = null;
        this.Os = null;
    }

    private void aJ(String str) {
        if (this.Os != null) {
            this.Os.m986a(new C0349a(this.uS, str));
        }
    }

    public int describeContents() {
        hy hyVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof hx)) {
            return false;
        }
        hx hxVar = (hx) object;
        return this.uS.equals(hxVar.uS) && ep.equal(this.Or, hxVar.Or) && this.On == hxVar.On;
    }

    public Uri gA() {
        aJ("getWebsiteUri");
        return this.Oj;
    }

    public boolean gB() {
        aJ("isPermanentlyClosed");
        return this.Ok;
    }

    public int gC() {
        aJ("getPriceLevel");
        return this.Om;
    }

    public long gD() {
        return this.On;
    }

    public Bundle gE() {
        return this.Od;
    }

    public hz gF() {
        return this.Oe;
    }

    public String gG() {
        return this.Oi;
    }

    public String getId() {
        aJ("getId");
        return this.uS;
    }

    public float getRating() {
        aJ("getRating");
        return this.Ol;
    }

    public List<ht> gw() {
        aJ("getTypes");
        return this.Oo;
    }

    public LatLng gx() {
        aJ("getLatLng");
        return this.Of;
    }

    public float gy() {
        aJ("getLevelNumber");
        return this.Og;
    }

    public LatLngBounds gz() {
        aJ("getViewport");
        return this.Oh;
    }

    public int hashCode() {
        return ep.hashCode(this.uS, this.Or, Long.valueOf(this.On));
    }

    public String toString() {
        return ep.m717e(this).m716a("id", this.uS).m716a("localization", this.Oe).m716a("locale", this.Or).m716a("latlng", this.Of).m716a("levelNumber", Float.valueOf(this.Og)).m716a("viewport", this.Oh).m716a("timeZone", this.Oi).m716a("websiteUri", this.Oj).m716a("isPermanentlyClosed", Boolean.valueOf(this.Ok)).m716a("priceLevel", Integer.valueOf(this.Om)).m716a("timestampSecs", Long.valueOf(this.On)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        hy hyVar = CREATOR;
        hy.m984a(this, parcel, flags);
    }
}
