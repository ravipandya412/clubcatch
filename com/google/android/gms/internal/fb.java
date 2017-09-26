package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class fb {

    /* renamed from: com.google.android.gms.internal.fb.b */
    public interface C0340b<I, O> {
        int el();

        int em();

        I m746g(O o);
    }

    /* renamed from: com.google.android.gms.internal.fb.a */
    public static class C0696a<I, O> implements SafeParcelable {
        public static final fc CREATOR;
        protected final Class<? extends fb> CA;
        protected final String CB;
        private fe CC;
        private C0340b<I, O> CD;
        protected final int Cu;
        protected final boolean Cv;
        protected final int Cw;
        protected final boolean Cx;
        protected final String Cy;
        protected final int Cz;
        private final int wj;

        static {
            CREATOR = new fc();
        }

        C0696a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ew ewVar) {
            this.wj = i;
            this.Cu = i2;
            this.Cv = z;
            this.Cw = i3;
            this.Cx = z2;
            this.Cy = str;
            this.Cz = i4;
            if (str2 == null) {
                this.CA = null;
                this.CB = null;
            } else {
                this.CA = fh.class;
                this.CB = str2;
            }
            if (ewVar == null) {
                this.CD = null;
            } else {
                this.CD = ewVar.ej();
            }
        }

        protected C0696a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends fb> cls, C0340b<I, O> c0340b) {
            this.wj = 1;
            this.Cu = i;
            this.Cv = z;
            this.Cw = i2;
            this.Cx = z2;
            this.Cy = str;
            this.Cz = i3;
            this.CA = cls;
            if (cls == null) {
                this.CB = null;
            } else {
                this.CB = cls.getCanonicalName();
            }
            this.CD = c0340b;
        }

        public static C0696a m1833a(String str, int i, C0340b<?, ?> c0340b, boolean z) {
            return new C0696a(c0340b.el(), z, c0340b.em(), false, str, i, null, c0340b);
        }

        public static <T extends fb> C0696a<T, T> m1834a(String str, int i, Class<T> cls) {
            return new C0696a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends fb> C0696a<ArrayList<T>, ArrayList<T>> m1835b(String str, int i, Class<T> cls) {
            return new C0696a(11, true, 11, true, str, i, cls, null);
        }

        public static C0696a<Integer, Integer> m1837g(String str, int i) {
            return new C0696a(0, false, 0, false, str, i, null, null);
        }

        public static C0696a<Double, Double> m1838h(String str, int i) {
            return new C0696a(4, false, 4, false, str, i, null, null);
        }

        public static C0696a<Boolean, Boolean> m1839i(String str, int i) {
            return new C0696a(6, false, 6, false, str, i, null, null);
        }

        public static C0696a<String, String> m1840j(String str, int i) {
            return new C0696a(7, false, 7, false, str, i, null, null);
        }

        public static C0696a<ArrayList<String>, ArrayList<String>> m1841k(String str, int i) {
            return new C0696a(7, true, 7, true, str, i, null, null);
        }

        public void m1842a(fe feVar) {
            this.CC = feVar;
        }

        public int describeContents() {
            fc fcVar = CREATOR;
            return 0;
        }

        public int el() {
            return this.Cu;
        }

        public int em() {
            return this.Cw;
        }

        public C0696a<I, O> eq() {
            return new C0696a(this.wj, this.Cu, this.Cv, this.Cw, this.Cx, this.Cy, this.Cz, this.CB, ey());
        }

        public boolean er() {
            return this.Cv;
        }

        public boolean es() {
            return this.Cx;
        }

        public String et() {
            return this.Cy;
        }

        public int eu() {
            return this.Cz;
        }

        public Class<? extends fb> ev() {
            return this.CA;
        }

        String ew() {
            return this.CB == null ? null : this.CB;
        }

        public boolean ex() {
            return this.CD != null;
        }

        ew ey() {
            return this.CD == null ? null : ew.m1816a(this.CD);
        }

        public HashMap<String, C0696a<?, ?>> ez() {
            er.m725f(this.CB);
            er.m725f(this.CC);
            return this.CC.ao(this.CB);
        }

        public I m1843g(O o) {
            return this.CD.m746g(o);
        }

        public int getVersionCode() {
            return this.wj;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.wj).append('\n');
            stringBuilder.append("                 typeIn=").append(this.Cu).append('\n');
            stringBuilder.append("            typeInArray=").append(this.Cv).append('\n');
            stringBuilder.append("                typeOut=").append(this.Cw).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.Cx).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.Cy).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Cz).append('\n');
            stringBuilder.append("       concreteTypeName=").append(ew()).append('\n');
            if (ev() != null) {
                stringBuilder.append("     concreteType.class=").append(ev().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.CD == null ? "null" : this.CD.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            fc fcVar = CREATOR;
            fc.m752a(this, out, flags);
        }
    }

    private void m747a(StringBuilder stringBuilder, C0696a c0696a, Object obj) {
        if (c0696a.el() == 11) {
            stringBuilder.append(((fb) c0696a.ev().cast(obj)).toString());
        } else if (c0696a.el() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(fp.ap((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m748a(StringBuilder stringBuilder, C0696a c0696a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m747a(stringBuilder, c0696a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m749a(C0696a<I, O> c0696a, Object obj) {
        return c0696a.CD != null ? c0696a.m1843g(obj) : obj;
    }

    protected boolean m750a(C0696a c0696a) {
        return c0696a.em() == 11 ? c0696a.es() ? an(c0696a.et()) : am(c0696a.et()) : al(c0696a.et());
    }

    protected abstract Object ak(String str);

    protected abstract boolean al(String str);

    protected boolean am(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean an(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object m751b(C0696a c0696a) {
        boolean z = true;
        String et = c0696a.et();
        if (c0696a.ev() == null) {
            return ak(c0696a.et());
        }
        if (ak(c0696a.et()) != null) {
            z = false;
        }
        er.m721a(z, "Concrete field shouldn't be value object: " + c0696a.et());
        Map ep = c0696a.es() ? ep() : eo();
        if (ep != null) {
            return ep.get(et);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(et.charAt(0)) + et.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, C0696a<?, ?>> en();

    public HashMap<String, Object> eo() {
        return null;
    }

    public HashMap<String, Object> ep() {
        return null;
    }

    public String toString() {
        HashMap en = en();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : en.keySet()) {
            C0696a c0696a = (C0696a) en.get(str);
            if (m750a(c0696a)) {
                Object a = m749a(c0696a, m751b(c0696a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c0696a.em()) {
                        case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                            stringBuilder.append("\"").append(fk.m773d((byte[]) a)).append("\"");
                            break;
                        case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                            stringBuilder.append("\"").append(fk.m774e((byte[]) a)).append("\"");
                            break;
                        case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                            fq.m777a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c0696a.er()) {
                                m747a(stringBuilder, c0696a, a);
                                break;
                            }
                            m748a(stringBuilder, c0696a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
