package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0296c.C0941i;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.tagmanager.C0460l.C0459a;
import com.google.android.gms.tagmanager.C0867s.C0465a;
import com.google.android.gms.tagmanager.cr.C0442a;
import com.google.android.gms.tagmanager.cr.C0444c;
import com.google.android.gms.tagmanager.cr.C0446e;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct {
    private static final by<C0945a> WH;
    private final DataLayer TN;
    private final C0444c WI;
    private final ag WJ;
    private final Map<String, aj> WK;
    private final Map<String, aj> WL;
    private final Map<String, aj> WM;
    private final C0458k<C0442a, by<C0945a>> WN;
    private final C0458k<String, C0450b> WO;
    private final Set<C0446e> WP;
    private final Map<String, C0451c> WQ;
    private volatile String WR;
    private int WS;

    /* renamed from: com.google.android.gms.tagmanager.ct.a */
    interface C0449a {
        void m1316a(C0446e c0446e, Set<C0442a> set, Set<C0442a> set2, cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.b */
    private static class C0450b {
        private by<C0945a> WY;
        private C0945a Wt;

        public C0450b(by<C0945a> byVar, C0945a c0945a) {
            this.WY = byVar;
            this.Wt = c0945a;
        }

        public int getSize() {
            return (this.Wt == null ? 0 : this.Wt.eW()) + ((C0945a) this.WY.getObject()).eW();
        }

        public C0945a jG() {
            return this.Wt;
        }

        public by<C0945a> ka() {
            return this.WY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.c */
    private static class C0451c {
        private final Set<C0446e> WP;
        private final Map<C0446e, List<C0442a>> WZ;
        private final Map<C0446e, List<C0442a>> Xa;
        private final Map<C0446e, List<String>> Xb;
        private final Map<C0446e, List<String>> Xc;
        private C0442a Xd;

        public C0451c() {
            this.WP = new HashSet();
            this.WZ = new HashMap();
            this.Xb = new HashMap();
            this.Xa = new HashMap();
            this.Xc = new HashMap();
        }

        public void m1317a(C0446e c0446e, C0442a c0442a) {
            List list = (List) this.WZ.get(c0446e);
            if (list == null) {
                list = new ArrayList();
                this.WZ.put(c0446e, list);
            }
            list.add(c0442a);
        }

        public void m1318a(C0446e c0446e, String str) {
            List list = (List) this.Xb.get(c0446e);
            if (list == null) {
                list = new ArrayList();
                this.Xb.put(c0446e, list);
            }
            list.add(str);
        }

        public void m1319b(C0446e c0446e) {
            this.WP.add(c0446e);
        }

        public void m1320b(C0446e c0446e, C0442a c0442a) {
            List list = (List) this.Xa.get(c0446e);
            if (list == null) {
                list = new ArrayList();
                this.Xa.put(c0446e, list);
            }
            list.add(c0442a);
        }

        public void m1321b(C0446e c0446e, String str) {
            List list = (List) this.Xc.get(c0446e);
            if (list == null) {
                list = new ArrayList();
                this.Xc.put(c0446e, list);
            }
            list.add(str);
        }

        public void m1322i(C0442a c0442a) {
            this.Xd = c0442a;
        }

        public Set<C0446e> kb() {
            return this.WP;
        }

        public Map<C0446e, List<C0442a>> kc() {
            return this.WZ;
        }

        public Map<C0446e, List<String>> kd() {
            return this.Xb;
        }

        public Map<C0446e, List<String>> ke() {
            return this.Xc;
        }

        public Map<C0446e, List<C0442a>> kf() {
            return this.Xa;
        }

        public C0442a kg() {
            return this.Xd;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.1 */
    class C08451 implements C0459a<C0442a, by<C0945a>> {
        final /* synthetic */ ct WT;

        C08451(ct ctVar) {
            this.WT = ctVar;
        }

        public int m2297a(C0442a c0442a, by<C0945a> byVar) {
            return ((C0945a) byVar.getObject()).eW();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2297a((C0442a) x0, (by) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.2 */
    class C08462 implements C0459a<String, C0450b> {
        final /* synthetic */ ct WT;

        C08462(ct ctVar) {
            this.WT = ctVar;
        }

        public int m2298a(String str, C0450b c0450b) {
            return str.length() + c0450b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2298a((String) x0, (C0450b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.3 */
    class C08473 implements C0449a {
        final /* synthetic */ ct WT;
        final /* synthetic */ Map WU;
        final /* synthetic */ Map WV;
        final /* synthetic */ Map WW;
        final /* synthetic */ Map WX;

        C08473(ct ctVar, Map map, Map map2, Map map3, Map map4) {
            this.WT = ctVar;
            this.WU = map;
            this.WV = map2;
            this.WW = map3;
            this.WX = map4;
        }

        public void m2299a(C0446e c0446e, Set<C0442a> set, Set<C0442a> set2, cn cnVar) {
            List list = (List) this.WU.get(c0446e);
            List list2 = (List) this.WV.get(c0446e);
            if (list != null) {
                set.addAll(list);
                cnVar.jl().m1291b(list, list2);
            }
            list = (List) this.WW.get(c0446e);
            list2 = (List) this.WX.get(c0446e);
            if (list != null) {
                set2.addAll(list);
                cnVar.jm().m1291b(list, list2);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct.4 */
    class C08484 implements C0449a {
        final /* synthetic */ ct WT;

        C08484(ct ctVar) {
            this.WT = ctVar;
        }

        public void m2300a(C0446e c0446e, Set<C0442a> set, Set<C0442a> set2, cn cnVar) {
            set.addAll(c0446e.jP());
            set2.addAll(c0446e.jQ());
            cnVar.jn().m1291b(c0446e.jP(), c0446e.jU());
            cnVar.jo().m1291b(c0446e.jQ(), c0446e.jV());
        }
    }

    static {
        WH = new by(di.ku(), true);
    }

    public ct(Context context, C0444c c0444c, DataLayer dataLayer, C0465a c0465a, C0465a c0465a2, ag agVar) {
        if (c0444c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.WI = c0444c;
        this.WP = new HashSet(c0444c.jJ());
        this.TN = dataLayer;
        this.WJ = agVar;
        this.WN = new C0460l().m1370a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C08451(this));
        this.WO = new C0460l().m1370a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C08462(this));
        this.WK = new HashMap();
        m1337b(new C1014i(context));
        m1337b(new C0867s(c0465a2));
        m1337b(new C1017w(dataLayer));
        m1337b(new dj(context, dataLayer));
        this.WL = new HashMap();
        m1338c(new C1100q());
        m1338c(new ad());
        m1338c(new ae());
        m1338c(new al());
        m1338c(new am());
        m1338c(new bd());
        m1338c(new be());
        m1338c(new ci());
        m1338c(new dc());
        this.WM = new HashMap();
        m1336a(new C0839b(context));
        m1336a(new C0841c(context));
        m1336a(new C0852e(context));
        m1336a(new C0853f(context));
        m1336a(new C0854g(context));
        m1336a(new C0855h(context));
        m1336a(new C0858m());
        m1336a(new C0866p(this.WI.getVersion()));
        m1336a(new C0867s(c0465a));
        m1336a(new C0868u(dataLayer));
        m1336a(new C0872z(context));
        m1336a(new aa());
        m1336a(new ac());
        m1336a(new ah(this));
        m1336a(new an());
        m1336a(new ao());
        m1336a(new ax(context));
        m1336a(new az());
        m1336a(new bc());
        m1336a(new bk(context));
        m1336a(new bz());
        m1336a(new cc());
        m1336a(new cf());
        m1336a(new ch());
        m1336a(new cj(context));
        m1336a(new cu());
        m1336a(new cv());
        m1336a(new de());
        this.WQ = new HashMap();
        for (C0446e c0446e : this.WP) {
            if (agVar.jb()) {
                m1328a(c0446e.jR(), c0446e.jS(), "add macro");
                m1328a(c0446e.jW(), c0446e.jT(), "remove macro");
                m1328a(c0446e.jP(), c0446e.jU(), "add tag");
                m1328a(c0446e.jQ(), c0446e.jV(), "remove tag");
            }
            int i = 0;
            while (i < c0446e.jR().size()) {
                C0442a c0442a = (C0442a) c0446e.jR().get(i);
                String str = "Unknown";
                if (agVar.jb() && i < c0446e.jS().size()) {
                    str = (String) c0446e.jS().get(i);
                }
                C0451c c = m1330c(this.WQ, m1331h(c0442a));
                c.m1319b(c0446e);
                c.m1317a(c0446e, c0442a);
                c.m1318a(c0446e, str);
                i++;
            }
            i = 0;
            while (i < c0446e.jW().size()) {
                c0442a = (C0442a) c0446e.jW().get(i);
                str = "Unknown";
                if (agVar.jb() && i < c0446e.jT().size()) {
                    str = (String) c0446e.jT().get(i);
                }
                c = m1330c(this.WQ, m1331h(c0442a));
                c.m1319b(c0446e);
                c.m1320b(c0446e, c0442a);
                c.m1321b(c0446e, str);
                i++;
            }
        }
        for (Entry entry : this.WI.jK().entrySet()) {
            for (C0442a c0442a2 : (List) entry.getValue()) {
                if (!di.m1355n((C0945a) c0442a2.jF().get(C0273b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1330c(this.WQ, (String) entry.getKey()).m1322i(c0442a2);
                }
            }
        }
    }

    private by<C0945a> m1323a(C0945a c0945a, Set<String> set, dk dkVar) {
        if (!c0945a.gi) {
            return new by(c0945a, true);
        }
        C0945a g;
        int i;
        by a;
        switch (c0945a.type) {
            case DetectedActivity.ON_FOOT /*2*/:
                g = cr.m1313g(c0945a);
                g.fZ = new C0945a[c0945a.fZ.length];
                for (i = 0; i < c0945a.fZ.length; i++) {
                    a = m1323a(c0945a.fZ[i], (Set) set, dkVar.bS(i));
                    if (a == WH) {
                        return WH;
                    }
                    g.fZ[i] = (C0945a) a.getObject();
                }
                return new by(g, false);
            case DetectedActivity.STILL /*3*/:
                g = cr.m1313g(c0945a);
                if (c0945a.ga.length != c0945a.gb.length) {
                    bh.m1270t("Invalid serving value: " + c0945a.toString());
                    return WH;
                }
                g.ga = new C0945a[c0945a.ga.length];
                g.gb = new C0945a[c0945a.ga.length];
                for (i = 0; i < c0945a.ga.length; i++) {
                    a = m1323a(c0945a.ga[i], (Set) set, dkVar.bT(i));
                    by a2 = m1323a(c0945a.gb[i], (Set) set, dkVar.bU(i));
                    if (a == WH || a2 == WH) {
                        return WH;
                    }
                    g.ga[i] = (C0945a) a.getObject();
                    g.gb[i] = (C0945a) a2.getObject();
                }
                return new by(g, false);
            case DetectedActivity.UNKNOWN /*4*/:
                if (set.contains(c0945a.gc)) {
                    bh.m1270t("Macro cycle detected.  Current macro reference: " + c0945a.gc + "." + "  Previous macro references: " + set.toString() + ".");
                    return WH;
                }
                set.add(c0945a.gc);
                by<C0945a> a3 = dl.m1366a(m1324a(c0945a.gc, (Set) set, dkVar.jq()), c0945a.gh);
                set.remove(c0945a.gc);
                return a3;
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                g = cr.m1313g(c0945a);
                g.gg = new C0945a[c0945a.gg.length];
                for (i = 0; i < c0945a.gg.length; i++) {
                    a = m1323a(c0945a.gg[i], (Set) set, dkVar.bV(i));
                    if (a == WH) {
                        return WH;
                    }
                    g.gg[i] = (C0945a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m1270t("Unknown type: " + c0945a.type);
                return WH;
        }
    }

    private by<C0945a> m1324a(String str, Set<String> set, bj bjVar) {
        this.WS++;
        C0450b c0450b = (C0450b) this.WO.get(str);
        if (c0450b == null || this.WJ.jb()) {
            C0451c c0451c = (C0451c) this.WQ.get(str);
            if (c0451c == null) {
                bh.m1270t(jZ() + "Invalid macro: " + str);
                this.WS--;
                return WH;
            }
            C0442a kg;
            by a = m1334a(str, c0451c.kb(), c0451c.kc(), c0451c.kd(), c0451c.kf(), c0451c.ke(), set, bjVar.iS());
            if (((Set) a.getObject()).isEmpty()) {
                kg = c0451c.kg();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m1273w(jZ() + "Multiple macros active for macroName " + str);
                }
                kg = (C0442a) ((Set) a.getObject()).iterator().next();
            }
            if (kg == null) {
                this.WS--;
                return WH;
            }
            by a2 = m1325a(this.WM, kg, (Set) set, bjVar.jh());
            boolean z = a.jr() && a2.jr();
            by<C0945a> byVar = a2 == WH ? WH : new by(a2.getObject(), z);
            C0945a jG = kg.jG();
            if (byVar.jr()) {
                this.WO.m1369e(str, new C0450b(byVar, jG));
            }
            m1327a(jG, (Set) set);
            this.WS--;
            return byVar;
        }
        m1327a(c0450b.jG(), (Set) set);
        this.WS--;
        return c0450b.ka();
    }

    private by<C0945a> m1325a(Map<String, aj> map, C0442a c0442a, Set<String> set, ck ckVar) {
        boolean z = true;
        C0945a c0945a = (C0945a) c0442a.jF().get(C0273b.FUNCTION.toString());
        if (c0945a == null) {
            bh.m1270t("No function id in properties");
            return WH;
        }
        String str = c0945a.gd;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m1270t(str + " has no backing implementation.");
            return WH;
        }
        by<C0945a> byVar = (by) this.WN.get(c0442a);
        if (byVar != null && !this.WJ.jb()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0442a.jF().entrySet()) {
            by a = m1323a((C0945a) entry.getValue(), (Set) set, ckVar.bs((String) entry.getKey()).m1292e((C0945a) entry.getValue()));
            if (a == WH) {
                return WH;
            }
            boolean z3;
            if (a.jr()) {
                c0442a.m1296a((String) entry.getKey(), (C0945a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m1251a(hashMap.keySet())) {
            if (!(z2 && ajVar.iy())) {
                z = false;
            }
            byVar = new by(ajVar.m1252u(hashMap), z);
            if (z) {
                this.WN.m1369e(c0442a, byVar);
            }
            ckVar.m1290d((C0945a) byVar.getObject());
            return byVar;
        }
        bh.m1270t("Incorrect keys for function " + str + " required " + ajVar.jd() + " had " + hashMap.keySet());
        return WH;
    }

    private by<Set<C0442a>> m1326a(Set<C0446e> set, Set<String> set2, C0449a c0449a, cs csVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0446e c0446e : set) {
            cn jp = csVar.jp();
            by a = m1333a(c0446e, (Set) set2, jp);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0449a.m1316a(c0446e, hashSet, hashSet2, jp);
            }
            boolean z2 = z && a.jr();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        csVar.m1315b(hashSet);
        return new by(hashSet, z);
    }

    private void m1327a(C0945a c0945a, Set<String> set) {
        if (c0945a != null) {
            by a = m1323a(c0945a, (Set) set, new bw());
            if (a != WH) {
                Object o = di.m1357o((C0945a) a.getObject());
                if (o instanceof Map) {
                    this.TN.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.TN.push((Map) o2);
                        } else {
                            bh.m1273w("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m1273w("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m1328a(List<C0442a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m1271u("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m1329a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.jc())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.jc());
        }
        map.put(ajVar.jc(), ajVar);
    }

    private static C0451c m1330c(Map<String, C0451c> map, String str) {
        C0451c c0451c = (C0451c) map.get(str);
        if (c0451c != null) {
            return c0451c;
        }
        c0451c = new C0451c();
        map.put(str, c0451c);
        return c0451c;
    }

    private static String m1331h(C0442a c0442a) {
        return di.m1349j((C0945a) c0442a.jF().get(C0273b.INSTANCE_NAME.toString()));
    }

    private String jZ() {
        if (this.WS <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.WS));
        for (int i = 2; i < this.WS; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by<Boolean> m1332a(C0442a c0442a, Set<String> set, ck ckVar) {
        by a = m1325a(this.WL, c0442a, (Set) set, ckVar);
        Boolean n = di.m1355n((C0945a) a.getObject());
        ckVar.m1290d(di.m1360r(n));
        return new by(n, a.jr());
    }

    by<Boolean> m1333a(C0446e c0446e, Set<String> set, cn cnVar) {
        boolean z = true;
        for (C0442a a : c0446e.jO()) {
            by a2 = m1332a(a, (Set) set, cnVar.jj());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.m1293f(di.m1360r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.jr());
            }
            boolean z2 = z && a2.jr();
            z = z2;
        }
        for (C0442a a3 : c0446e.jN()) {
            a2 = m1332a(a3, (Set) set, cnVar.jk());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.jr();
            } else {
                cnVar.m1293f(di.m1360r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.jr());
            }
        }
        cnVar.m1293f(di.m1360r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by<Set<C0442a>> m1334a(String str, Set<C0446e> set, Map<C0446e, List<C0442a>> map, Map<C0446e, List<String>> map2, Map<C0446e, List<C0442a>> map3, Map<C0446e, List<String>> map4, Set<String> set2, cs csVar) {
        return m1326a((Set) set, (Set) set2, new C08473(this, map, map2, map3, map4), csVar);
    }

    by<Set<C0442a>> m1335a(Set<C0446e> set, cs csVar) {
        return m1326a((Set) set, new HashSet(), new C08484(this), csVar);
    }

    void m1336a(aj ajVar) {
        m1329a(this.WM, ajVar);
    }

    void m1337b(aj ajVar) {
        m1329a(this.WK, ajVar);
    }

    public by<C0945a> bC(String str) {
        this.WS = 0;
        af bl = this.WJ.bl(str);
        by<C0945a> a = m1324a(str, new HashSet(), bl.iY());
        bl.ja();
        return a;
    }

    synchronized void bD(String str) {
        this.WR = str;
    }

    public synchronized void ba(String str) {
        bD(str);
        af bm = this.WJ.bm(str);
        C0466t iZ = bm.iZ();
        for (C0442a a : (Set) m1335a(this.WP, iZ.iS()).getObject()) {
            m1325a(this.WK, a, new HashSet(), iZ.iR());
        }
        bm.ja();
        bD(null);
    }

    void m1338c(aj ajVar) {
        m1329a(this.WL, ajVar);
    }

    public synchronized void m1339f(List<C0941i> list) {
        for (C0941i c0941i : list) {
            if (c0941i.name == null || !c0941i.name.startsWith("gaExperiment:")) {
                bh.m1272v("Ignored supplemental: " + c0941i);
            } else {
                ai.m1247a(this.TN, c0941i);
            }
        }
    }

    synchronized String jY() {
        return this.WR;
    }
}
