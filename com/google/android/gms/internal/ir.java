package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ir extends fb implements SafeParcelable, Person {
    public static final is CREATOR;
    private static final HashMap<String, C0696a<?, ?>> RL;
    private String FE;
    private final Set<Integer> RM;
    private String SK;
    private C0981a SL;
    private String SM;
    private String SN;
    private int SO;
    private C0984b SP;
    private String SQ;
    private C0985c SR;
    private boolean SS;
    private String ST;
    private C0986d SU;
    private String SV;
    private int SW;
    private List<C0987f> SX;
    private List<C0988g> SY;
    private int SZ;
    private int Ta;
    private String Tb;
    private List<C0989h> Tc;
    private boolean Td;
    private int lu;
    private String pS;
    private String uS;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.ir.e */
    public static class C0351e {
        public static int aT(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.a */
    public static final class C0981a extends fb implements SafeParcelable, AgeRange {
        public static final it CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private final Set<Integer> RM;
        private int Te;
        private int Tf;
        private final int wj;

        static {
            CREATOR = new it();
            RL = new HashMap();
            RL.put("max", C0696a.m1837g("max", 2));
            RL.put("min", C0696a.m1837g("min", 3));
        }

        public C0981a() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0981a(Set<Integer> set, int i, int i2, int i3) {
            this.RM = set;
            this.wj = i;
            this.Te = i2;
            this.Tf = i3;
        }

        protected boolean m2742a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2743b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return Integer.valueOf(this.Te);
                case DetectedActivity.STILL /*3*/:
                    return Integer.valueOf(this.Tf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            it itVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0981a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0981a c0981a = (C0981a) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2742a(c0696a)) {
                    if (!c0981a.m2742a(c0696a)) {
                        return false;
                    }
                    if (!m2743b(c0696a).equals(c0981a.m2743b(c0696a))) {
                        return false;
                    }
                } else if (c0981a.m2742a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ie();
        }

        public int getMax() {
            return this.Te;
        }

        public int getMin() {
            return this.Tf;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasMax() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2742a(c0696a)) {
                    hashCode = m2743b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0981a ie() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            it itVar = CREATOR;
            it.m993a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.b */
    public static final class C0984b extends fb implements SafeParcelable, Cover {
        public static final iu CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private final Set<Integer> RM;
        private C0982a Tg;
        private C0983b Th;
        private int Ti;
        private final int wj;

        /* renamed from: com.google.android.gms.internal.ir.b.a */
        public static final class C0982a extends fb implements SafeParcelable, CoverInfo {
            public static final iv CREATOR;
            private static final HashMap<String, C0696a<?, ?>> RL;
            private final Set<Integer> RM;
            private int Tj;
            private int Tk;
            private final int wj;

            static {
                CREATOR = new iv();
                RL = new HashMap();
                RL.put("leftImageOffset", C0696a.m1837g("leftImageOffset", 2));
                RL.put("topImageOffset", C0696a.m1837g("topImageOffset", 3));
            }

            public C0982a() {
                this.wj = 1;
                this.RM = new HashSet();
            }

            C0982a(Set<Integer> set, int i, int i2, int i3) {
                this.RM = set;
                this.wj = i;
                this.Tj = i2;
                this.Tk = i3;
            }

            protected boolean m2744a(C0696a c0696a) {
                return this.RM.contains(Integer.valueOf(c0696a.eu()));
            }

            protected Object ak(String str) {
                return null;
            }

            protected boolean al(String str) {
                return false;
            }

            protected Object m2745b(C0696a c0696a) {
                switch (c0696a.eu()) {
                    case DetectedActivity.ON_FOOT /*2*/:
                        return Integer.valueOf(this.Tj);
                    case DetectedActivity.STILL /*3*/:
                        return Integer.valueOf(this.Tk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
                }
            }

            public int describeContents() {
                iv ivVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0696a<?, ?>> en() {
                return RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0982a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0982a c0982a = (C0982a) obj;
                for (C0696a c0696a : RL.values()) {
                    if (m2744a(c0696a)) {
                        if (!c0982a.m2744a(c0696a)) {
                            return false;
                        }
                        if (!m2745b(c0696a).equals(c0982a.m2745b(c0696a))) {
                            return false;
                        }
                    } else if (c0982a.m2744a(c0696a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return ii();
            }

            public int getLeftImageOffset() {
                return this.Tj;
            }

            public int getTopImageOffset() {
                return this.Tk;
            }

            int getVersionCode() {
                return this.wj;
            }

            Set<Integer> hB() {
                return this.RM;
            }

            public boolean hasLeftImageOffset() {
                return this.RM.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.RM.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0696a c0696a : RL.values()) {
                    int hashCode;
                    if (m2744a(c0696a)) {
                        hashCode = m2745b(c0696a).hashCode() + (i + c0696a.eu());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public C0982a ii() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                iv ivVar = CREATOR;
                iv.m995a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ir.b.b */
        public static final class C0983b extends fb implements SafeParcelable, CoverPhoto {
            public static final iw CREATOR;
            private static final HashMap<String, C0696a<?, ?>> RL;
            private final Set<Integer> RM;
            private String pS;
            private int f82v;
            private int f83w;
            private final int wj;

            static {
                CREATOR = new iw();
                RL = new HashMap();
                RL.put("height", C0696a.m1837g("height", 2));
                RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0696a.m1840j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                RL.put("width", C0696a.m1837g("width", 4));
            }

            public C0983b() {
                this.wj = 1;
                this.RM = new HashSet();
            }

            C0983b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.RM = set;
                this.wj = i;
                this.f82v = i2;
                this.pS = str;
                this.f83w = i3;
            }

            protected boolean m2746a(C0696a c0696a) {
                return this.RM.contains(Integer.valueOf(c0696a.eu()));
            }

            protected Object ak(String str) {
                return null;
            }

            protected boolean al(String str) {
                return false;
            }

            protected Object m2747b(C0696a c0696a) {
                switch (c0696a.eu()) {
                    case DetectedActivity.ON_FOOT /*2*/:
                        return Integer.valueOf(this.f82v);
                    case DetectedActivity.STILL /*3*/:
                        return this.pS;
                    case DetectedActivity.UNKNOWN /*4*/:
                        return Integer.valueOf(this.f83w);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
                }
            }

            public int describeContents() {
                iw iwVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0696a<?, ?>> en() {
                return RL;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0983b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0983b c0983b = (C0983b) obj;
                for (C0696a c0696a : RL.values()) {
                    if (m2746a(c0696a)) {
                        if (!c0983b.m2746a(c0696a)) {
                            return false;
                        }
                        if (!m2747b(c0696a).equals(c0983b.m2747b(c0696a))) {
                            return false;
                        }
                    } else if (c0983b.m2746a(c0696a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return ij();
            }

            public int getHeight() {
                return this.f82v;
            }

            public String getUrl() {
                return this.pS;
            }

            int getVersionCode() {
                return this.wj;
            }

            public int getWidth() {
                return this.f83w;
            }

            Set<Integer> hB() {
                return this.RM;
            }

            public boolean hasHeight() {
                return this.RM.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.RM.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.RM.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0696a c0696a : RL.values()) {
                    int hashCode;
                    if (m2746a(c0696a)) {
                        hashCode = m2747b(c0696a).hashCode() + (i + c0696a.eu());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public C0983b ij() {
                return this;
            }

            public boolean isDataValid() {
                return true;
            }

            public void writeToParcel(Parcel out, int flags) {
                iw iwVar = CREATOR;
                iw.m996a(this, out, flags);
            }
        }

        static {
            CREATOR = new iu();
            RL = new HashMap();
            RL.put("coverInfo", C0696a.m1834a("coverInfo", 2, C0982a.class));
            RL.put("coverPhoto", C0696a.m1834a("coverPhoto", 3, C0983b.class));
            RL.put("layout", C0696a.m1833a("layout", 4, new ey().m1819f("banner", 0), false));
        }

        public C0984b() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0984b(Set<Integer> set, int i, C0982a c0982a, C0983b c0983b, int i2) {
            this.RM = set;
            this.wj = i;
            this.Tg = c0982a;
            this.Th = c0983b;
            this.Ti = i2;
        }

        protected boolean m2748a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2749b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.Tg;
                case DetectedActivity.STILL /*3*/:
                    return this.Th;
                case DetectedActivity.UNKNOWN /*4*/:
                    return Integer.valueOf(this.Ti);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            iu iuVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0984b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0984b c0984b = (C0984b) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2748a(c0696a)) {
                    if (!c0984b.m2748a(c0696a)) {
                        return false;
                    }
                    if (!m2749b(c0696a).equals(c0984b.m2749b(c0696a))) {
                        return false;
                    }
                } else if (c0984b.m2748a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ih();
        }

        public CoverInfo getCoverInfo() {
            return this.Tg;
        }

        public CoverPhoto getCoverPhoto() {
            return this.Th;
        }

        public int getLayout() {
            return this.Ti;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasCoverInfo() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2748a(c0696a)) {
                    hashCode = m2749b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        C0982a m2750if() {
            return this.Tg;
        }

        C0983b ig() {
            return this.Th;
        }

        public C0984b ih() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            iu iuVar = CREATOR;
            iu.m994a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.c */
    public static final class C0985c extends fb implements SafeParcelable, Image {
        public static final ix CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private final Set<Integer> RM;
        private String pS;
        private final int wj;

        static {
            CREATOR = new ix();
            RL = new HashMap();
            RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0696a.m1840j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C0985c() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        public C0985c(String str) {
            this.RM = new HashSet();
            this.wj = 1;
            this.pS = str;
            this.RM.add(Integer.valueOf(2));
        }

        C0985c(Set<Integer> set, int i, String str) {
            this.RM = set;
            this.wj = i;
            this.pS = str;
        }

        protected boolean m2751a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2752b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.pS;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            ix ixVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0985c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0985c c0985c = (C0985c) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2751a(c0696a)) {
                    if (!c0985c.m2751a(c0696a)) {
                        return false;
                    }
                    if (!m2752b(c0696a).equals(c0985c.m2752b(c0696a))) {
                        return false;
                    }
                } else if (c0985c.m2751a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ik();
        }

        public String getUrl() {
            return this.pS;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasUrl() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2751a(c0696a)) {
                    hashCode = m2752b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0985c ik() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            ix ixVar = CREATOR;
            ix.m997a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.d */
    public static final class C0986d extends fb implements SafeParcelable, Name {
        public static final iy CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private final Set<Integer> RM;
        private String Sk;
        private String Sn;
        private String Tl;
        private String Tm;
        private String Tn;
        private String To;
        private final int wj;

        static {
            CREATOR = new iy();
            RL = new HashMap();
            RL.put("familyName", C0696a.m1840j("familyName", 2));
            RL.put("formatted", C0696a.m1840j("formatted", 3));
            RL.put("givenName", C0696a.m1840j("givenName", 4));
            RL.put("honorificPrefix", C0696a.m1840j("honorificPrefix", 5));
            RL.put("honorificSuffix", C0696a.m1840j("honorificSuffix", 6));
            RL.put("middleName", C0696a.m1840j("middleName", 7));
        }

        public C0986d() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0986d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.RM = set;
            this.wj = i;
            this.Sk = str;
            this.Tl = str2;
            this.Sn = str3;
            this.Tm = str4;
            this.Tn = str5;
            this.To = str6;
        }

        protected boolean m2753a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2754b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.Sk;
                case DetectedActivity.STILL /*3*/:
                    return this.Tl;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.Sn;
                case DetectedActivity.TILTING /*5*/:
                    return this.Tm;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    return this.Tn;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    return this.To;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            iy iyVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0986d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0986d c0986d = (C0986d) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2753a(c0696a)) {
                    if (!c0986d.m2753a(c0696a)) {
                        return false;
                    }
                    if (!m2754b(c0696a).equals(c0986d.m2754b(c0696a))) {
                        return false;
                    }
                } else if (c0986d.m2753a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return il();
        }

        public String getFamilyName() {
            return this.Sk;
        }

        public String getFormatted() {
            return this.Tl;
        }

        public String getGivenName() {
            return this.Sn;
        }

        public String getHonorificPrefix() {
            return this.Tm;
        }

        public String getHonorificSuffix() {
            return this.Tn;
        }

        public String getMiddleName() {
            return this.To;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasFamilyName() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.RM.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2753a(c0696a)) {
                    hashCode = m2754b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0986d il() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            iy iyVar = CREATOR;
            iy.m998a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.f */
    public static final class C0987f extends fb implements SafeParcelable, Organizations {
        public static final iz CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private int AI;
        private String CX;
        private String FH;
        private final Set<Integer> RM;
        private String Sj;
        private String Sz;
        private String Tp;
        private String Tq;
        private boolean Tr;
        private String mName;
        private final int wj;

        static {
            CREATOR = new iz();
            RL = new HashMap();
            RL.put("department", C0696a.m1840j("department", 2));
            RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0696a.m1840j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            RL.put("endDate", C0696a.m1840j("endDate", 4));
            RL.put("location", C0696a.m1840j("location", 5));
            RL.put("name", C0696a.m1840j("name", 6));
            RL.put("primary", C0696a.m1839i("primary", 7));
            RL.put("startDate", C0696a.m1840j("startDate", 8));
            RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0696a.m1840j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            RL.put("type", C0696a.m1833a("type", 10, new ey().m1819f("work", 0).m1819f("school", 1), false));
        }

        public C0987f() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0987f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.RM = set;
            this.wj = i;
            this.Tp = str;
            this.FH = str2;
            this.Sj = str3;
            this.Tq = str4;
            this.mName = str5;
            this.Tr = z;
            this.Sz = str6;
            this.CX = str7;
            this.AI = i2;
        }

        protected boolean m2755a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2756b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return this.Tp;
                case DetectedActivity.STILL /*3*/:
                    return this.FH;
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.Sj;
                case DetectedActivity.TILTING /*5*/:
                    return this.Tq;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    return this.mName;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    return Boolean.valueOf(this.Tr);
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    return this.Sz;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    return this.CX;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    return Integer.valueOf(this.AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            iz izVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0987f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0987f c0987f = (C0987f) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2755a(c0696a)) {
                    if (!c0987f.m2755a(c0696a)) {
                        return false;
                    }
                    if (!m2756b(c0696a).equals(c0987f.m2756b(c0696a))) {
                        return false;
                    }
                } else if (c0987f.m2755a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return im();
        }

        public String getDepartment() {
            return this.Tp;
        }

        public String getDescription() {
            return this.FH;
        }

        public String getEndDate() {
            return this.Sj;
        }

        public String getLocation() {
            return this.Tq;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.Sz;
        }

        public String getTitle() {
            return this.CX;
        }

        public int getType() {
            return this.AI;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasDepartment() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.RM.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.RM.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.RM.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.RM.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2755a(c0696a)) {
                    hashCode = m2756b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0987f im() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            iz izVar = CREATOR;
            iz.m999a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.g */
    public static final class C0988g extends fb implements SafeParcelable, PlacesLived {
        public static final ja CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private final Set<Integer> RM;
        private boolean Tr;
        private String mValue;
        private final int wj;

        static {
            CREATOR = new ja();
            RL = new HashMap();
            RL.put("primary", C0696a.m1839i("primary", 2));
            RL.put("value", C0696a.m1840j("value", 3));
        }

        public C0988g() {
            this.wj = 1;
            this.RM = new HashSet();
        }

        C0988g(Set<Integer> set, int i, boolean z, String str) {
            this.RM = set;
            this.wj = i;
            this.Tr = z;
            this.mValue = str;
        }

        protected boolean m2757a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2758b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.ON_FOOT /*2*/:
                    return Boolean.valueOf(this.Tr);
                case DetectedActivity.STILL /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            ja jaVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0988g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0988g c0988g = (C0988g) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2757a(c0696a)) {
                    if (!c0988g.m2757a(c0696a)) {
                        return false;
                    }
                    if (!m2758b(c0696a).equals(c0988g.m2758b(c0696a))) {
                        return false;
                    }
                } else if (c0988g.m2757a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return in();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasPrimary() {
            return this.RM.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.RM.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2757a(c0696a)) {
                    hashCode = m2758b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public C0988g in() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Tr;
        }

        public void writeToParcel(Parcel out, int flags) {
            ja jaVar = CREATOR;
            ja.m1000a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ir.h */
    public static final class C0989h extends fb implements SafeParcelable, Urls {
        public static final jb CREATOR;
        private static final HashMap<String, C0696a<?, ?>> RL;
        private int AI;
        private final Set<Integer> RM;
        private String Ts;
        private final int Tt;
        private String mValue;
        private final int wj;

        static {
            CREATOR = new jb();
            RL = new HashMap();
            RL.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0696a.m1840j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            RL.put("type", C0696a.m1833a("type", 6, new ey().m1819f("home", 0).m1819f("work", 1).m1819f("blog", 2).m1819f(Scopes.PROFILE, 3).m1819f("other", 4).m1819f("otherProfile", 5).m1819f("contributor", 6).m1819f("website", 7), false));
            RL.put("value", C0696a.m1840j("value", 4));
        }

        public C0989h() {
            this.Tt = 4;
            this.wj = 2;
            this.RM = new HashSet();
        }

        C0989h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.Tt = 4;
            this.RM = set;
            this.wj = i;
            this.Ts = str;
            this.AI = i2;
            this.mValue = str2;
        }

        protected boolean m2759a(C0696a c0696a) {
            return this.RM.contains(Integer.valueOf(c0696a.eu()));
        }

        protected Object ak(String str) {
            return null;
        }

        protected boolean al(String str) {
            return false;
        }

        protected Object m2760b(C0696a c0696a) {
            switch (c0696a.eu()) {
                case DetectedActivity.UNKNOWN /*4*/:
                    return this.mValue;
                case DetectedActivity.TILTING /*5*/:
                    return this.Ts;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    return Integer.valueOf(this.AI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
            }
        }

        public int describeContents() {
            jb jbVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0696a<?, ?>> en() {
            return RL;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0989h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0989h c0989h = (C0989h) obj;
            for (C0696a c0696a : RL.values()) {
                if (m2759a(c0696a)) {
                    if (!c0989h.m2759a(c0696a)) {
                        return false;
                    }
                    if (!m2760b(c0696a).equals(c0989h.m2760b(c0696a))) {
                        return false;
                    }
                } else if (c0989h.m2759a(c0696a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return ip();
        }

        public String getLabel() {
            return this.Ts;
        }

        public int getType() {
            return this.AI;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.wj;
        }

        Set<Integer> hB() {
            return this.RM;
        }

        public boolean hasLabel() {
            return this.RM.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.RM.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.RM.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0696a c0696a : RL.values()) {
                int hashCode;
                if (m2759a(c0696a)) {
                    hashCode = m2760b(c0696a).hashCode() + (i + c0696a.eu());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        @Deprecated
        public int io() {
            return 4;
        }

        public C0989h ip() {
            return this;
        }

        public boolean isDataValid() {
            return true;
        }

        public void writeToParcel(Parcel out, int flags) {
            jb jbVar = CREATOR;
            jb.m1001a(this, out, flags);
        }
    }

    static {
        CREATOR = new is();
        RL = new HashMap();
        RL.put("aboutMe", C0696a.m1840j("aboutMe", 2));
        RL.put("ageRange", C0696a.m1834a("ageRange", 3, C0981a.class));
        RL.put("birthday", C0696a.m1840j("birthday", 4));
        RL.put("braggingRights", C0696a.m1840j("braggingRights", 5));
        RL.put("circledByCount", C0696a.m1837g("circledByCount", 6));
        RL.put("cover", C0696a.m1834a("cover", 7, C0984b.class));
        RL.put("currentLocation", C0696a.m1840j("currentLocation", 8));
        RL.put("displayName", C0696a.m1840j("displayName", 9));
        RL.put("gender", C0696a.m1833a("gender", 12, new ey().m1819f("male", 0).m1819f("female", 1).m1819f("other", 2), false));
        RL.put("id", C0696a.m1840j("id", 14));
        RL.put("image", C0696a.m1834a("image", 15, C0985c.class));
        RL.put("isPlusUser", C0696a.m1839i("isPlusUser", 16));
        RL.put("language", C0696a.m1840j("language", 18));
        RL.put("name", C0696a.m1834a("name", 19, C0986d.class));
        RL.put("nickname", C0696a.m1840j("nickname", 20));
        RL.put("objectType", C0696a.m1833a("objectType", 21, new ey().m1819f("person", 0).m1819f("page", 1), false));
        RL.put("organizations", C0696a.m1835b("organizations", 22, C0987f.class));
        RL.put("placesLived", C0696a.m1835b("placesLived", 23, C0988g.class));
        RL.put("plusOneCount", C0696a.m1837g("plusOneCount", 24));
        RL.put("relationshipStatus", C0696a.m1833a("relationshipStatus", 25, new ey().m1819f("single", 0).m1819f("in_a_relationship", 1).m1819f("engaged", 2).m1819f("married", 3).m1819f("its_complicated", 4).m1819f("open_relationship", 5).m1819f("widowed", 6).m1819f("in_domestic_partnership", 7).m1819f("in_civil_union", 8), false));
        RL.put("tagline", C0696a.m1840j("tagline", 26));
        RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0696a.m1840j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        RL.put("urls", C0696a.m1835b("urls", 28, C0989h.class));
        RL.put("verified", C0696a.m1839i("verified", 29));
    }

    public ir() {
        this.wj = 2;
        this.RM = new HashSet();
    }

    public ir(String str, String str2, C0985c c0985c, int i, String str3) {
        this.wj = 2;
        this.RM = new HashSet();
        this.FE = str;
        this.RM.add(Integer.valueOf(9));
        this.uS = str2;
        this.RM.add(Integer.valueOf(14));
        this.SR = c0985c;
        this.RM.add(Integer.valueOf(15));
        this.SW = i;
        this.RM.add(Integer.valueOf(21));
        this.pS = str3;
        this.RM.add(Integer.valueOf(27));
    }

    ir(Set<Integer> set, int i, String str, C0981a c0981a, String str2, String str3, int i2, C0984b c0984b, String str4, String str5, int i3, String str6, C0985c c0985c, boolean z, String str7, C0986d c0986d, String str8, int i4, List<C0987f> list, List<C0988g> list2, int i5, int i6, String str9, String str10, List<C0989h> list3, boolean z2) {
        this.RM = set;
        this.wj = i;
        this.SK = str;
        this.SL = c0981a;
        this.SM = str2;
        this.SN = str3;
        this.SO = i2;
        this.SP = c0984b;
        this.SQ = str4;
        this.FE = str5;
        this.lu = i3;
        this.uS = str6;
        this.SR = c0985c;
        this.SS = z;
        this.ST = str7;
        this.SU = c0986d;
        this.SV = str8;
        this.SW = i4;
        this.SX = list;
        this.SY = list2;
        this.SZ = i5;
        this.Ta = i6;
        this.Tb = str9;
        this.pS = str10;
        this.Tc = list3;
        this.Td = z2;
    }

    public static ir m2761i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ir aI = CREATOR.aI(obtain);
        obtain.recycle();
        return aI;
    }

    protected boolean m2762a(C0696a c0696a) {
        return this.RM.contains(Integer.valueOf(c0696a.eu()));
    }

    protected Object ak(String str) {
        return null;
    }

    protected boolean al(String str) {
        return false;
    }

    protected Object m2763b(C0696a c0696a) {
        switch (c0696a.eu()) {
            case DetectedActivity.ON_FOOT /*2*/:
                return this.SK;
            case DetectedActivity.STILL /*3*/:
                return this.SL;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.SM;
            case DetectedActivity.TILTING /*5*/:
                return this.SN;
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return Integer.valueOf(this.SO);
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                return this.SP;
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                return this.SQ;
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                return this.FE;
            case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                return Integer.valueOf(this.lu);
            case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                return this.uS;
            case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                return this.SR;
            case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                return Boolean.valueOf(this.SS);
            case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                return this.ST;
            case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                return this.SU;
            case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                return this.SV;
            case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                return Integer.valueOf(this.SW);
            case C0519R.styleable.Theme_actionBarSize /*22*/:
                return this.SX;
            case C0519R.styleable.Theme_actionBarDivider /*23*/:
                return this.SY;
            case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                return Integer.valueOf(this.SZ);
            case C0519R.styleable.Theme_actionMenuTextAppearance /*25*/:
                return Integer.valueOf(this.Ta);
            case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                return this.Tb;
            case C0519R.styleable.Theme_actionModeStyle /*27*/:
                return this.pS;
            case C0519R.styleable.Theme_actionModeCloseButtonStyle /*28*/:
                return this.Tc;
            case C0519R.styleable.Theme_actionModeBackground /*29*/:
                return Boolean.valueOf(this.Td);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
        }
    }

    public int describeContents() {
        is isVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0696a<?, ?>> en() {
        return RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ir)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ir irVar = (ir) obj;
        for (C0696a c0696a : RL.values()) {
            if (m2762a(c0696a)) {
                if (!irVar.m2762a(c0696a)) {
                    return false;
                }
                if (!m2763b(c0696a).equals(irVar.m2763b(c0696a))) {
                    return false;
                }
            } else if (irVar.m2762a(c0696a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return id();
    }

    public String getAboutMe() {
        return this.SK;
    }

    public AgeRange getAgeRange() {
        return this.SL;
    }

    public String getBirthday() {
        return this.SM;
    }

    public String getBraggingRights() {
        return this.SN;
    }

    public int getCircledByCount() {
        return this.SO;
    }

    public Cover getCover() {
        return this.SP;
    }

    public String getCurrentLocation() {
        return this.SQ;
    }

    public String getDisplayName() {
        return this.FE;
    }

    public int getGender() {
        return this.lu;
    }

    public String getId() {
        return this.uS;
    }

    public Image getImage() {
        return this.SR;
    }

    public String getLanguage() {
        return this.ST;
    }

    public Name getName() {
        return this.SU;
    }

    public String getNickname() {
        return this.SV;
    }

    public int getObjectType() {
        return this.SW;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.SX;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.SY;
    }

    public int getPlusOneCount() {
        return this.SZ;
    }

    public int getRelationshipStatus() {
        return this.Ta;
    }

    public String getTagline() {
        return this.Tb;
    }

    public String getUrl() {
        return this.pS;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.Tc;
    }

    int getVersionCode() {
        return this.wj;
    }

    Set<Integer> hB() {
        return this.RM;
    }

    C0981a hW() {
        return this.SL;
    }

    C0984b hX() {
        return this.SP;
    }

    C0985c hY() {
        return this.SR;
    }

    C0986d hZ() {
        return this.SU;
    }

    public boolean hasAboutMe() {
        return this.RM.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.RM.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.RM.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.RM.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.RM.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.RM.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.RM.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.RM.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.RM.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.RM.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.RM.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.RM.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.RM.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.RM.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.RM.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.RM.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.RM.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.RM.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.RM.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.RM.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.RM.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.RM.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.RM.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.RM.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0696a c0696a : RL.values()) {
            int hashCode;
            if (m2762a(c0696a)) {
                hashCode = m2763b(c0696a).hashCode() + (i + c0696a.eu());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    List<C0987f> ia() {
        return this.SX;
    }

    List<C0988g> ib() {
        return this.SY;
    }

    List<C0989h> ic() {
        return this.Tc;
    }

    public ir id() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.SS;
    }

    public boolean isVerified() {
        return this.Td;
    }

    public void writeToParcel(Parcel out, int flags) {
        is isVar = CREATOR;
        is.m992a(this, out, flags);
    }
}
