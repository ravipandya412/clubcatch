package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class fh extends fb implements SafeParcelable {
    public static final fi CREATOR;
    private final fe CC;
    private final Parcel CJ;
    private final int CK;
    private int CL;
    private int CM;
    private final String mClassName;
    private final int wj;

    static {
        CREATOR = new fi();
    }

    fh(int i, Parcel parcel, fe feVar) {
        this.wj = i;
        this.CJ = (Parcel) er.m725f(parcel);
        this.CK = 2;
        this.CC = feVar;
        if (this.CC == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.CC.eD();
        }
        this.CL = 2;
    }

    private fh(SafeParcelable safeParcelable, fe feVar, String str) {
        this.wj = 1;
        this.CJ = Parcel.obtain();
        safeParcelable.writeToParcel(this.CJ, 0);
        this.CK = 1;
        this.CC = (fe) er.m725f(feVar);
        this.mClassName = (String) er.m725f(str);
        this.CL = 2;
    }

    public static <T extends fb & SafeParcelable> fh m1848a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new fh((SafeParcelable) t, m1854b(t), canonicalName);
    }

    private static void m1849a(fe feVar, fb fbVar) {
        Class cls = fbVar.getClass();
        if (!feVar.m1847b(cls)) {
            HashMap en = fbVar.en();
            feVar.m1846a(cls, fbVar.en());
            for (String str : en.keySet()) {
                C0696a c0696a = (C0696a) en.get(str);
                Class ev = c0696a.ev();
                if (ev != null) {
                    try {
                        m1849a(feVar, (fb) ev.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0696a.ev().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0696a.ev().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m1850a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                stringBuilder.append(obj);
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                stringBuilder.append("\"").append(fp.ap(obj.toString())).append("\"");
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                stringBuilder.append("\"").append(fk.m773d((byte[]) obj)).append("\"");
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                stringBuilder.append("\"").append(fk.m774e((byte[]) obj));
                stringBuilder.append("\"");
            case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                fq.m777a(stringBuilder, (HashMap) obj);
            case C0519R.styleable.Toolbar_titleMargins /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m1851a(StringBuilder stringBuilder, C0696a<?, ?> c0696a, Parcel parcel, int i) {
        switch (c0696a.em()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, Integer.valueOf(C0211a.m202g(parcel, i))));
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, C0211a.m204i(parcel, i)));
            case DetectedActivity.ON_FOOT /*2*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, Long.valueOf(C0211a.m203h(parcel, i))));
            case DetectedActivity.STILL /*3*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, Float.valueOf(C0211a.m205j(parcel, i))));
            case DetectedActivity.UNKNOWN /*4*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, Double.valueOf(C0211a.m206k(parcel, i))));
            case DetectedActivity.TILTING /*5*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, C0211a.m207l(parcel, i)));
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, Boolean.valueOf(C0211a.m198c(parcel, i))));
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, C0211a.m208m(parcel, i)));
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, C0211a.m213p(parcel, i)));
            case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                m1856b(stringBuilder, (C0696a) c0696a, m749a(c0696a, m1858c(C0211a.m212o(parcel, i))));
            case C0519R.styleable.Toolbar_titleMargins /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0696a.em());
        }
    }

    private void m1852a(StringBuilder stringBuilder, String str, C0696a<?, ?> c0696a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0696a.ex()) {
            m1851a(stringBuilder, c0696a, parcel, i);
        } else {
            m1855b(stringBuilder, c0696a, parcel, i);
        }
    }

    private void m1853a(StringBuilder stringBuilder, HashMap<String, C0696a<?, ?>> hashMap, Parcel parcel) {
        HashMap c = m1859c((HashMap) hashMap);
        stringBuilder.append('{');
        int o = C0211a.m211o(parcel);
        Object obj = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            Entry entry = (Entry) c.get(Integer.valueOf(C0211a.m189S(n)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m1852a(stringBuilder, (String) entry.getKey(), (C0696a) entry.getValue(), parcel, n);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0210a("Overread allowed size end=" + o, parcel);
        }
        stringBuilder.append('}');
    }

    private static fe m1854b(fb fbVar) {
        fe feVar = new fe(fbVar.getClass());
        m1849a(feVar, fbVar);
        feVar.eB();
        feVar.eA();
        return feVar;
    }

    private void m1855b(StringBuilder stringBuilder, C0696a<?, ?> c0696a, Parcel parcel, int i) {
        if (c0696a.es()) {
            stringBuilder.append("[");
            switch (c0696a.em()) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    fj.m768a(stringBuilder, C0211a.m215r(parcel, i));
                    break;
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    fj.m770a(stringBuilder, C0211a.m217t(parcel, i));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    fj.m769a(stringBuilder, C0211a.m216s(parcel, i));
                    break;
                case DetectedActivity.STILL /*3*/:
                    fj.m767a(stringBuilder, C0211a.m218u(parcel, i));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    fj.m766a(stringBuilder, C0211a.m219v(parcel, i));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    fj.m770a(stringBuilder, C0211a.m220w(parcel, i));
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    fj.m772a(stringBuilder, C0211a.m214q(parcel, i));
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    fj.m771a(stringBuilder, C0211a.m221x(parcel, i));
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    Parcel[] A = C0211a.m188A(parcel, i);
                    int length = A.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        A[i2].setDataPosition(0);
                        m1853a(stringBuilder, c0696a.ez(), A[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0696a.em()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                stringBuilder.append(C0211a.m202g(parcel, i));
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                stringBuilder.append(C0211a.m204i(parcel, i));
            case DetectedActivity.ON_FOOT /*2*/:
                stringBuilder.append(C0211a.m203h(parcel, i));
            case DetectedActivity.STILL /*3*/:
                stringBuilder.append(C0211a.m205j(parcel, i));
            case DetectedActivity.UNKNOWN /*4*/:
                stringBuilder.append(C0211a.m206k(parcel, i));
            case DetectedActivity.TILTING /*5*/:
                stringBuilder.append(C0211a.m207l(parcel, i));
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                stringBuilder.append(C0211a.m198c(parcel, i));
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                stringBuilder.append("\"").append(fp.ap(C0211a.m208m(parcel, i))).append("\"");
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                stringBuilder.append("\"").append(fk.m773d(C0211a.m213p(parcel, i))).append("\"");
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                stringBuilder.append("\"").append(fk.m774e(C0211a.m213p(parcel, i)));
                stringBuilder.append("\"");
            case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                Bundle o = C0211a.m212o(parcel, i);
                Set<String> keySet = o.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(fp.ap(o.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case C0519R.styleable.Toolbar_titleMargins /*11*/:
                Parcel z = C0211a.m223z(parcel, i);
                z.setDataPosition(0);
                m1853a(stringBuilder, c0696a.ez(), z);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m1856b(StringBuilder stringBuilder, C0696a<?, ?> c0696a, Object obj) {
        if (c0696a.er()) {
            m1857b(stringBuilder, (C0696a) c0696a, (ArrayList) obj);
        } else {
            m1850a(stringBuilder, c0696a.el(), obj);
        }
    }

    private void m1857b(StringBuilder stringBuilder, C0696a<?, ?> c0696a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m1850a(stringBuilder, c0696a.el(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> m1858c(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Entry<String, C0696a<?, ?>>> m1859c(HashMap<String, C0696a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0696a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0696a) entry.getValue()).eu()), entry);
        }
        return hashMap2;
    }

    protected Object ak(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean al(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        fi fiVar = CREATOR;
        return 0;
    }

    public Parcel eF() {
        switch (this.CL) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                this.CM = C0212b.m248p(this.CJ);
                C0212b.m226D(this.CJ, this.CM);
                this.CL = 2;
                break;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                C0212b.m226D(this.CJ, this.CM);
                this.CL = 2;
                break;
        }
        return this.CJ;
    }

    fe eG() {
        switch (this.CK) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return null;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return this.CC;
            case DetectedActivity.ON_FOOT /*2*/:
                return this.CC;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.CK);
        }
    }

    public HashMap<String, C0696a<?, ?>> en() {
        return this.CC == null ? null : this.CC.ao(this.mClassName);
    }

    public int getVersionCode() {
        return this.wj;
    }

    public String toString() {
        er.m723b(this.CC, (Object) "Cannot convert to JSON on client side.");
        Parcel eF = eF();
        eF.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m1853a(stringBuilder, this.CC.ao(this.mClassName), eF);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        fi fiVar = CREATOR;
        fi.m764a(this, out, flags);
    }
}
