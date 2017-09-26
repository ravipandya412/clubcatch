package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C0416i {
    private String[] Ro;
    private String Rp;
    private String Rq;
    private String Rr;
    private PlusCommonExtras Rt;
    private final ArrayList<String> Ru;
    private String[] Rv;
    private String vi;

    public C0416i(Context context) {
        this.Ru = new ArrayList();
        this.Rq = context.getPackageName();
        this.Rp = context.getPackageName();
        this.Rt = new PlusCommonExtras();
        this.Ru.add(Scopes.PLUS_LOGIN);
    }

    public C0416i aS(String str) {
        this.vi = str;
        return this;
    }

    public C0416i m1210e(String... strArr) {
        this.Ru.clear();
        this.Ru.addAll(Arrays.asList(strArr));
        return this;
    }

    public C0416i m1211f(String... strArr) {
        this.Rv = strArr;
        return this;
    }

    public C0831h hA() {
        if (this.vi == null) {
            this.vi = "<<default account>>";
        }
        return new C0831h(this.vi, (String[]) this.Ru.toArray(new String[this.Ru.size()]), this.Rv, this.Ro, this.Rp, this.Rq, this.Rr, this.Rt);
    }

    public C0416i hz() {
        this.Ru.clear();
        return this;
    }
}
