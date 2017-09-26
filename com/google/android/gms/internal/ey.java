package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0340b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ey implements SafeParcelable, C0340b<String, Integer> {
    public static final ez CREATOR;
    private final HashMap<String, Integer> Cp;
    private final HashMap<Integer, String> Cq;
    private final ArrayList<C0683a> Cr;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.ey.a */
    public static final class C0683a implements SafeParcelable {
        public static final fa CREATOR;
        final String Cs;
        final int Ct;
        final int versionCode;

        static {
            CREATOR = new fa();
        }

        C0683a(int i, String str, int i2) {
            this.versionCode = i;
            this.Cs = str;
            this.Ct = i2;
        }

        C0683a(String str, int i) {
            this.versionCode = 1;
            this.Cs = str;
            this.Ct = i;
        }

        public int describeContents() {
            fa faVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fa faVar = CREATOR;
            fa.m743a(this, out, flags);
        }
    }

    static {
        CREATOR = new ez();
    }

    public ey() {
        this.wj = 1;
        this.Cp = new HashMap();
        this.Cq = new HashMap();
        this.Cr = null;
    }

    ey(int i, ArrayList<C0683a> arrayList) {
        this.wj = i;
        this.Cp = new HashMap();
        this.Cq = new HashMap();
        this.Cr = null;
        m1817a((ArrayList) arrayList);
    }

    private void m1817a(ArrayList<C0683a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0683a c0683a = (C0683a) it.next();
            m1819f(c0683a.Cs, c0683a.Ct);
        }
    }

    public String m1818a(Integer num) {
        String str = (String) this.Cq.get(num);
        return (str == null && this.Cp.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        ez ezVar = CREATOR;
        return 0;
    }

    ArrayList<C0683a> ek() {
        ArrayList<C0683a> arrayList = new ArrayList();
        for (String str : this.Cp.keySet()) {
            arrayList.add(new C0683a(str, ((Integer) this.Cp.get(str)).intValue()));
        }
        return arrayList;
    }

    public int el() {
        return 7;
    }

    public int em() {
        return 0;
    }

    public ey m1819f(String str, int i) {
        this.Cp.put(str, Integer.valueOf(i));
        this.Cq.put(Integer.valueOf(i), str);
        return this;
    }

    public /* synthetic */ Object m1820g(Object obj) {
        return m1818a((Integer) obj);
    }

    int getVersionCode() {
        return this.wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        ez ezVar = CREATOR;
        ez.m738a(this, out, flags);
    }
}
