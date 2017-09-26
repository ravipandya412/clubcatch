package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.C0296c.C0938f;
import com.google.android.gms.internal.C0296c.C0942j;
import com.pkr.clubcatch.C0519R;
import java.io.IOException;

public interface jd {

    /* renamed from: com.google.android.gms.internal.jd.a */
    public static final class C0991a extends ka<C0991a> {
        public long Yb;
        public C0942j Yc;
        public C0938f fV;

        public C0991a() {
            kw();
        }

        public static C0991a m2776l(byte[] bArr) throws kd {
            return (C0991a) ke.m1064a(new C0991a(), bArr);
        }

        public void m2777a(jz jzVar) throws IOException {
            jzVar.m1049b(1, this.Yb);
            if (this.fV != null) {
                jzVar.m1046a(2, this.fV);
            }
            if (this.Yc != null) {
                jzVar.m1046a(3, this.Yc);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2778b(jy jyVar) throws IOException {
            return m2780n(jyVar);
        }

        public int m2779c() {
            int c = super.m2115c() + jz.m1036d(1, this.Yb);
            if (this.fV != null) {
                c += jz.m1032b(2, this.fV);
            }
            if (this.Yc != null) {
                c += jz.m1032b(3, this.Yc);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0991a)) {
                return false;
            }
            C0991a c0991a = (C0991a) o;
            if (this.Yb != c0991a.Yb) {
                return false;
            }
            if (this.fV == null) {
                if (c0991a.fV != null) {
                    return false;
                }
            } else if (!this.fV.equals(c0991a.fV)) {
                return false;
            }
            if (this.Yc == null) {
                if (c0991a.Yc != null) {
                    return false;
                }
            } else if (!this.Yc.equals(c0991a.Yc)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0991a.aae == null || c0991a.aae.isEmpty();
            } else {
                return this.aae.equals(c0991a.aae);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.Yc == null ? 0 : this.Yc.hashCode()) + (((this.fV == null ? 0 : this.fV.hashCode()) + ((((int) (this.Yb ^ (this.Yb >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        public C0991a kw() {
            this.Yb = 0;
            this.fV = null;
            this.Yc = null;
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public C0991a m2780n(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        this.Yb = jyVar.kA();
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        if (this.fV == null) {
                            this.fV = new C0938f();
                        }
                        jyVar.m1024a(this.fV);
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        if (this.Yc == null) {
                            this.Yc = new C0942j();
                        }
                        jyVar.m1024a(this.Yc);
                        continue;
                    default:
                        if (!m2114a(jyVar, ky)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }
}
