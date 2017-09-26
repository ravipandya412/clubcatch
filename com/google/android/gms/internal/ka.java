package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ka<M extends ka<M>> extends ke {
    protected List<kg> aae;

    public final <T> T m2112a(kb<M, T> kbVar) {
        return kbVar.m1062g(this.aae);
    }

    public void m2113a(jz jzVar) throws IOException {
        int size = this.aae == null ? 0 : this.aae.size();
        for (int i = 0; i < size; i++) {
            kg kgVar = (kg) this.aae.get(i);
            jzVar.cF(kgVar.tag);
            jzVar.m1057p(kgVar.aai);
        }
    }

    protected final boolean m2114a(jy jyVar, int i) throws IOException {
        int position = jyVar.getPosition();
        if (!jyVar.cv(i)) {
            return false;
        }
        if (this.aae == null) {
            this.aae = new ArrayList();
        }
        this.aae.add(new kg(i, jyVar.m1026e(position, jyVar.getPosition() - position)));
        return true;
    }

    public int m2115c() {
        int i = 0;
        for (int i2 = 0; i2 < (this.aae == null ? 0 : this.aae.size()); i2++) {
            kg kgVar = (kg) this.aae.get(i2);
            i = (i + jz.cG(kgVar.tag)) + kgVar.aai.length;
        }
        this.DY = i;
        return i;
    }
}
