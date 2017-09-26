package com.google.android.gms.tagmanager;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0296c.C0934b;
import com.google.android.gms.internal.C0296c.C0937e;
import com.google.android.gms.internal.C0296c.C0938f;
import com.google.android.gms.internal.C0296c.C0939g;
import com.google.android.gms.internal.C0296c.C0940h;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {

    /* renamed from: com.google.android.gms.tagmanager.cr.a */
    public static class C0442a {
        private final Map<String, C0945a> Ws;
        private final C0945a Wt;

        private C0442a(Map<String, C0945a> map, C0945a c0945a) {
            this.Ws = map;
            this.Wt = c0945a;
        }

        public static C0443b jE() {
            return new C0443b();
        }

        public void m1296a(String str, C0945a c0945a) {
            this.Ws.put(str, c0945a);
        }

        public Map<String, C0945a> jF() {
            return Collections.unmodifiableMap(this.Ws);
        }

        public C0945a jG() {
            return this.Wt;
        }

        public String toString() {
            return "Properties: " + jF() + " pushAfterEvaluate: " + this.Wt;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.b */
    public static class C0443b {
        private final Map<String, C0945a> Ws;
        private C0945a Wt;

        private C0443b() {
            this.Ws = new HashMap();
        }

        public C0443b m1297b(String str, C0945a c0945a) {
            this.Ws.put(str, c0945a);
            return this;
        }

        public C0443b m1298i(C0945a c0945a) {
            this.Wt = c0945a;
            return this;
        }

        public C0442a jH() {
            return new C0442a(this.Wt, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.c */
    public static class C0444c {
        private final String Un;
        private final List<C0446e> Wu;
        private final Map<String, List<C0442a>> Wv;
        private final int Ww;

        private C0444c(List<C0446e> list, Map<String, List<C0442a>> map, String str, int i) {
            this.Wu = Collections.unmodifiableList(list);
            this.Wv = Collections.unmodifiableMap(map);
            this.Un = str;
            this.Ww = i;
        }

        public static C0445d jI() {
            return new C0445d();
        }

        public String getVersion() {
            return this.Un;
        }

        public List<C0446e> jJ() {
            return this.Wu;
        }

        public Map<String, List<C0442a>> jK() {
            return this.Wv;
        }

        public String toString() {
            return "Rules: " + jJ() + "  Macros: " + this.Wv;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.d */
    public static class C0445d {
        private String Un;
        private final List<C0446e> Wu;
        private final Map<String, List<C0442a>> Wv;
        private int Ww;

        private C0445d() {
            this.Wu = new ArrayList();
            this.Wv = new HashMap();
            this.Un = "";
            this.Ww = 0;
        }

        public C0445d m1299a(C0442a c0442a) {
            String j = di.m1349j((C0945a) c0442a.jF().get(C0273b.INSTANCE_NAME.toString()));
            List list = (List) this.Wv.get(j);
            if (list == null) {
                list = new ArrayList();
                this.Wv.put(j, list);
            }
            list.add(c0442a);
            return this;
        }

        public C0445d m1300a(C0446e c0446e) {
            this.Wu.add(c0446e);
            return this;
        }

        public C0445d bW(int i) {
            this.Ww = i;
            return this;
        }

        public C0445d bx(String str) {
            this.Un = str;
            return this;
        }

        public C0444c jL() {
            return new C0444c(this.Wv, this.Un, this.Ww, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.e */
    public static class C0446e {
        private final List<C0442a> WA;
        private final List<C0442a> WB;
        private final List<C0442a> WC;
        private final List<String> WD;
        private final List<String> WE;
        private final List<String> WF;
        private final List<String> WG;
        private final List<C0442a> Wx;
        private final List<C0442a> Wy;
        private final List<C0442a> Wz;

        private C0446e(List<C0442a> list, List<C0442a> list2, List<C0442a> list3, List<C0442a> list4, List<C0442a> list5, List<C0442a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.Wx = Collections.unmodifiableList(list);
            this.Wy = Collections.unmodifiableList(list2);
            this.Wz = Collections.unmodifiableList(list3);
            this.WA = Collections.unmodifiableList(list4);
            this.WB = Collections.unmodifiableList(list5);
            this.WC = Collections.unmodifiableList(list6);
            this.WD = Collections.unmodifiableList(list7);
            this.WE = Collections.unmodifiableList(list8);
            this.WF = Collections.unmodifiableList(list9);
            this.WG = Collections.unmodifiableList(list10);
        }

        public static C0447f jM() {
            return new C0447f();
        }

        public List<C0442a> jN() {
            return this.Wx;
        }

        public List<C0442a> jO() {
            return this.Wy;
        }

        public List<C0442a> jP() {
            return this.Wz;
        }

        public List<C0442a> jQ() {
            return this.WA;
        }

        public List<C0442a> jR() {
            return this.WB;
        }

        public List<String> jS() {
            return this.WD;
        }

        public List<String> jT() {
            return this.WE;
        }

        public List<String> jU() {
            return this.WF;
        }

        public List<String> jV() {
            return this.WG;
        }

        public List<C0442a> jW() {
            return this.WC;
        }

        public String toString() {
            return "Positive predicates: " + jN() + "  Negative predicates: " + jO() + "  Add tags: " + jP() + "  Remove tags: " + jQ() + "  Add macros: " + jR() + "  Remove macros: " + jW();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.f */
    public static class C0447f {
        private final List<C0442a> WA;
        private final List<C0442a> WB;
        private final List<C0442a> WC;
        private final List<String> WD;
        private final List<String> WE;
        private final List<String> WF;
        private final List<String> WG;
        private final List<C0442a> Wx;
        private final List<C0442a> Wy;
        private final List<C0442a> Wz;

        private C0447f() {
            this.Wx = new ArrayList();
            this.Wy = new ArrayList();
            this.Wz = new ArrayList();
            this.WA = new ArrayList();
            this.WB = new ArrayList();
            this.WC = new ArrayList();
            this.WD = new ArrayList();
            this.WE = new ArrayList();
            this.WF = new ArrayList();
            this.WG = new ArrayList();
        }

        public C0447f m1301b(C0442a c0442a) {
            this.Wx.add(c0442a);
            return this;
        }

        public C0447f bA(String str) {
            this.WD.add(str);
            return this;
        }

        public C0447f bB(String str) {
            this.WE.add(str);
            return this;
        }

        public C0447f by(String str) {
            this.WF.add(str);
            return this;
        }

        public C0447f bz(String str) {
            this.WG.add(str);
            return this;
        }

        public C0447f m1302c(C0442a c0442a) {
            this.Wy.add(c0442a);
            return this;
        }

        public C0447f m1303d(C0442a c0442a) {
            this.Wz.add(c0442a);
            return this;
        }

        public C0447f m1304e(C0442a c0442a) {
            this.WA.add(c0442a);
            return this;
        }

        public C0447f m1305f(C0442a c0442a) {
            this.WB.add(c0442a);
            return this;
        }

        public C0447f m1306g(C0442a c0442a) {
            this.WC.add(c0442a);
            return this;
        }

        public C0446e jX() {
            return new C0446e(this.Wy, this.Wz, this.WA, this.WB, this.WC, this.WD, this.WE, this.WF, this.WG, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr.g */
    public static class C0448g extends Exception {
        public C0448g(String str) {
            super(str);
        }
    }

    private static C0945a m1307a(int i, C0938f c0938f, C0945a[] c0945aArr, Set<Integer> set) throws C0448g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            bw("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C0945a c0945a = (C0945a) m1310a(c0938f.fi, i, "values");
        if (c0945aArr[i] != null) {
            return c0945aArr[i];
        }
        C0945a c0945a2 = null;
        set.add(Integer.valueOf(i));
        C0940h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c0945a.type) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case DetectedActivity.TILTING /*5*/:
            case Participant.STATUS_UNRESPONSIVE /*6*/:
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                c0945a2 = c0945a;
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                h = m1314h(c0945a);
                c0945a2 = m1313g(c0945a);
                c0945a2.fZ = new C0945a[h.fK.length];
                iArr = h.fK;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0945a2.fZ[i3] = m1307a(iArr[i2], c0938f, c0945aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case DetectedActivity.STILL /*3*/:
                c0945a2 = m1313g(c0945a);
                C0940h h2 = m1314h(c0945a);
                if (h2.fL.length != h2.fM.length) {
                    bw("Uneven map keys (" + h2.fL.length + ") and map values (" + h2.fM.length + ")");
                }
                c0945a2.ga = new C0945a[h2.fL.length];
                c0945a2.gb = new C0945a[h2.fL.length];
                int[] iArr2 = h2.fL;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c0945a2.ga[i4] = m1307a(iArr2[i3], c0938f, c0945aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fM;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0945a2.gb[i3] = m1307a(iArr[i2], c0938f, c0945aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case DetectedActivity.UNKNOWN /*4*/:
                c0945a2 = m1313g(c0945a);
                c0945a2.gc = di.m1349j(m1307a(m1314h(c0945a).fP, c0938f, c0945aArr, (Set) set));
                break;
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                c0945a2 = m1313g(c0945a);
                h = m1314h(c0945a);
                c0945a2.gg = new C0945a[h.fO.length];
                iArr = h.fO;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0945a2.gg[i3] = m1307a(iArr[i2], c0938f, c0945aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c0945a2 == null) {
            bw("Invalid value: " + c0945a);
        }
        c0945aArr[i] = c0945a2;
        set.remove(Integer.valueOf(i));
        return c0945a2;
    }

    private static C0442a m1308a(C0934b c0934b, C0938f c0938f, C0945a[] c0945aArr, int i) throws C0448g {
        C0443b jE = C0442a.jE();
        for (int valueOf : c0934b.eS) {
            C0937e c0937e = (C0937e) m1310a(c0938f.fj, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m1310a(c0938f.fh, c0937e.key, "keys");
            C0945a c0945a = (C0945a) m1310a(c0945aArr, c0937e.value, "values");
            if (C0273b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                jE.m1298i(c0945a);
            } else {
                jE.m1297b(str, c0945a);
            }
        }
        return jE.jH();
    }

    private static C0446e m1309a(C0939g c0939g, List<C0442a> list, List<C0442a> list2, List<C0442a> list3, C0938f c0938f) {
        C0447f jM = C0446e.jM();
        for (int valueOf : c0939g.fy) {
            jM.m1301b((C0442a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c0939g.fz) {
            jM.m1302c((C0442a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c0939g.fA) {
            jM.m1303d((C0442a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c0939g.fC) {
            jM.by(c0938f.fi[Integer.valueOf(valueOf3).intValue()].fY);
        }
        for (int valueOf222 : c0939g.fB) {
            jM.m1304e((C0442a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c0939g.fD) {
            jM.bz(c0938f.fi[Integer.valueOf(valueOf32).intValue()].fY);
        }
        for (int valueOf2222 : c0939g.fE) {
            jM.m1305f((C0442a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c0939g.fG) {
            jM.bA(c0938f.fi[Integer.valueOf(valueOf322).intValue()].fY);
        }
        for (int valueOf22222 : c0939g.fF) {
            jM.m1306g((C0442a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c0939g.fH) {
            jM.bB(c0938f.fi[Integer.valueOf(valueOf4).intValue()].fY);
        }
        return jM.jX();
    }

    private static <T> T m1310a(T[] tArr, int i, String str) throws C0448g {
        if (i < 0 || i >= tArr.length) {
            bw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static C0444c m1311b(C0938f c0938f) throws C0448g {
        int i;
        int i2 = 0;
        C0945a[] c0945aArr = new C0945a[c0938f.fi.length];
        for (i = 0; i < c0938f.fi.length; i++) {
            m1307a(i, c0938f, c0945aArr, new HashSet(0));
        }
        C0445d jI = C0444c.jI();
        List arrayList = new ArrayList();
        for (i = 0; i < c0938f.fl.length; i++) {
            arrayList.add(m1308a(c0938f.fl[i], c0938f, c0945aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c0938f.fm.length; i++) {
            arrayList2.add(m1308a(c0938f.fm[i], c0938f, c0945aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c0938f.fk.length; i++) {
            C0442a a = m1308a(c0938f.fk[i], c0938f, c0945aArr, i);
            jI.m1299a(a);
            arrayList3.add(a);
        }
        C0939g[] c0939gArr = c0938f.fn;
        int length = c0939gArr.length;
        while (i2 < length) {
            jI.m1300a(m1309a(c0939gArr[i2], arrayList, arrayList3, arrayList2, c0938f));
            i2++;
        }
        jI.bx(c0938f.fr);
        jI.bW(c0938f.fw);
        return jI.jL();
    }

    public static void m1312b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void bw(String str) throws C0448g {
        bh.m1270t(str);
        throw new C0448g(str);
    }

    public static C0945a m1313g(C0945a c0945a) {
        C0945a c0945a2 = new C0945a();
        c0945a2.type = c0945a.type;
        c0945a2.gh = (int[]) c0945a.gh.clone();
        if (c0945a.gi) {
            c0945a2.gi = c0945a.gi;
        }
        return c0945a2;
    }

    private static C0940h m1314h(C0945a c0945a) throws C0448g {
        if (((C0940h) c0945a.m2112a(C0940h.fI)) == null) {
            bw("Expected a ServingValue and didn't get one. Value is: " + c0945a);
        }
        return (C0940h) c0945a.m2112a(C0940h.fI);
    }
}
