package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fb.C0696a;
import java.util.ArrayList;
import java.util.HashMap;

public class fe implements SafeParcelable {
    public static final ff CREATOR;
    private final HashMap<String, HashMap<String, C0696a<?, ?>>> CE;
    private final ArrayList<C0697a> CF;
    private final String CG;
    private final int wj;

    /* renamed from: com.google.android.gms.internal.fe.a */
    public static class C0697a implements SafeParcelable {
        public static final fg CREATOR;
        final ArrayList<C0698b> CH;
        final String className;
        final int versionCode;

        static {
            CREATOR = new fg();
        }

        C0697a(int i, String str, ArrayList<C0698b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.CH = arrayList;
        }

        C0697a(String str, HashMap<String, C0696a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.CH = C0697a.m1844b(hashMap);
        }

        private static ArrayList<C0698b> m1844b(HashMap<String, C0696a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0698b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0698b(str, (C0696a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            fg fgVar = CREATOR;
            return 0;
        }

        HashMap<String, C0696a<?, ?>> eE() {
            HashMap<String, C0696a<?, ?>> hashMap = new HashMap();
            int size = this.CH.size();
            for (int i = 0; i < size; i++) {
                C0698b c0698b = (C0698b) this.CH.get(i);
                hashMap.put(c0698b.eX, c0698b.CI);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            fg fgVar = CREATOR;
            fg.m761a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fe.b */
    public static class C0698b implements SafeParcelable {
        public static final fd CREATOR;
        final C0696a<?, ?> CI;
        final String eX;
        final int versionCode;

        static {
            CREATOR = new fd();
        }

        C0698b(int i, String str, C0696a<?, ?> c0696a) {
            this.versionCode = i;
            this.eX = str;
            this.CI = c0696a;
        }

        C0698b(String str, C0696a<?, ?> c0696a) {
            this.versionCode = 1;
            this.eX = str;
            this.CI = c0696a;
        }

        public int describeContents() {
            fd fdVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fd fdVar = CREATOR;
            fd.m755a(this, out, flags);
        }
    }

    static {
        CREATOR = new ff();
    }

    fe(int i, ArrayList<C0697a> arrayList, String str) {
        this.wj = i;
        this.CF = null;
        this.CE = m1845b((ArrayList) arrayList);
        this.CG = (String) er.m725f(str);
        eA();
    }

    public fe(Class<? extends fb> cls) {
        this.wj = 1;
        this.CF = null;
        this.CE = new HashMap();
        this.CG = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, C0696a<?, ?>>> m1845b(ArrayList<C0697a> arrayList) {
        HashMap<String, HashMap<String, C0696a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0697a c0697a = (C0697a) arrayList.get(i);
            hashMap.put(c0697a.className, c0697a.eE());
        }
        return hashMap;
    }

    public void m1846a(Class<? extends fb> cls, HashMap<String, C0696a<?, ?>> hashMap) {
        this.CE.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap<String, C0696a<?, ?>> ao(String str) {
        return (HashMap) this.CE.get(str);
    }

    public boolean m1847b(Class<? extends fb> cls) {
        return this.CE.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ff ffVar = CREATOR;
        return 0;
    }

    public void eA() {
        for (String str : this.CE.keySet()) {
            HashMap hashMap = (HashMap) this.CE.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0696a) hashMap.get(str2)).m1842a(this);
            }
        }
    }

    public void eB() {
        for (String str : this.CE.keySet()) {
            HashMap hashMap = (HashMap) this.CE.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0696a) hashMap.get(str2)).eq());
            }
            this.CE.put(str, hashMap2);
        }
    }

    ArrayList<C0697a> eC() {
        ArrayList<C0697a> arrayList = new ArrayList();
        for (String str : this.CE.keySet()) {
            arrayList.add(new C0697a(str, (HashMap) this.CE.get(str)));
        }
        return arrayList;
    }

    public String eD() {
        return this.CG;
    }

    int getVersionCode() {
        return this.wj;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.CE.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.CE.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ff ffVar = CREATOR;
        ff.m758a(this, out, flags);
    }
}
