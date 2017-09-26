package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0296c {

    /* renamed from: com.google.android.gms.internal.c.a */
    public static final class C0933a extends ka<C0933a> {
        public int eP;
        public int eQ;
        public int level;

        public C0933a() {
            m2465b();
        }

        public C0933a m2463a(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        ky = jyVar.kB();
                        switch (ky) {
                            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                            case DetectedActivity.ON_FOOT /*2*/:
                            case DetectedActivity.STILL /*3*/:
                                this.level = ky;
                                break;
                            default:
                                continue;
                        }
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eP = jyVar.kB();
                        continue;
                    case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                        this.eQ = jyVar.kB();
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

        public void m2464a(jz jzVar) throws IOException {
            if (this.level != 1) {
                jzVar.m1055f(1, this.level);
            }
            if (this.eP != 0) {
                jzVar.m1055f(2, this.eP);
            }
            if (this.eQ != 0) {
                jzVar.m1055f(3, this.eQ);
            }
            super.m2113a(jzVar);
        }

        public C0933a m2465b() {
            this.level = 1;
            this.eP = 0;
            this.eQ = 0;
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public /* synthetic */ ke m2466b(jy jyVar) throws IOException {
            return m2463a(jyVar);
        }

        public int m2467c() {
            int c = super.m2115c();
            if (this.level != 1) {
                c += jz.m1039g(1, this.level);
            }
            if (this.eP != 0) {
                c += jz.m1039g(2, this.eP);
            }
            if (this.eQ != 0) {
                c += jz.m1039g(3, this.eQ);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0933a)) {
                return false;
            }
            C0933a c0933a = (C0933a) o;
            if (this.level != c0933a.level || this.eP != c0933a.eP || this.eQ != c0933a.eQ) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0933a.aae == null || c0933a.aae.isEmpty();
            } else {
                return this.aae.equals(c0933a.aae);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eP) * 31) + this.eQ) * 31;
            int hashCode = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.b */
    public static final class C0934b extends ka<C0934b> {
        private static volatile C0934b[] eR;
        public int[] eS;
        public int eT;
        public boolean eU;
        public boolean eV;
        public int name;

        public C0934b() {
            m2473e();
        }

        public static C0934b[] m2468d() {
            if (eR == null) {
                synchronized (kc.aah) {
                    if (eR == null) {
                        eR = new C0934b[0];
                    }
                }
            }
            return eR;
        }

        public void m2469a(jz jzVar) throws IOException {
            if (this.eV) {
                jzVar.m1047a(1, this.eV);
            }
            jzVar.m1055f(2, this.eT);
            if (this.eS != null && this.eS.length > 0) {
                for (int f : this.eS) {
                    jzVar.m1055f(3, f);
                }
            }
            if (this.name != 0) {
                jzVar.m1055f(4, this.name);
            }
            if (this.eU) {
                jzVar.m1047a(6, this.eU);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2470b(jy jyVar) throws IOException {
            return m2472c(jyVar);
        }

        public int m2471c() {
            int i = 0;
            int c = super.m2115c();
            if (this.eV) {
                c += jz.m1033b(1, this.eV);
            }
            int g = jz.m1039g(2, this.eT) + c;
            if (this.eS == null || this.eS.length <= 0) {
                c = g;
            } else {
                for (int cC : this.eS) {
                    i += jz.cC(cC);
                }
                c = (g + i) + (this.eS.length * 1);
            }
            if (this.name != 0) {
                c += jz.m1039g(4, this.name);
            }
            if (this.eU) {
                c += jz.m1033b(6, this.eU);
            }
            this.DY = c;
            return c;
        }

        public C0934b m2472c(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        this.eV = jyVar.kC();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eT = jyVar.kB();
                        continue;
                    case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                        c = kh.m1075c(jyVar, 24);
                        ky = this.eS == null ? 0 : this.eS.length;
                        Object obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.eS = obj;
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        int cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.eS == null ? 0 : this.eS.length;
                        Object obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.eS, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.eS = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.name = jyVar.kB();
                        continue;
                    case C0519R.styleable.Theme_homeAsUpIndicator /*48*/:
                        this.eU = jyVar.kC();
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

        public C0934b m2473e() {
            this.eS = kh.aaj;
            this.eT = 0;
            this.name = 0;
            this.eU = false;
            this.eV = false;
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0934b)) {
                return false;
            }
            C0934b c0934b = (C0934b) o;
            if (!kc.equals(this.eS, c0934b.eS) || this.eT != c0934b.eT || this.name != c0934b.name || this.eU != c0934b.eU || this.eV != c0934b.eV) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0934b.aae == null || c0934b.aae.isEmpty();
            } else {
                return this.aae.equals(c0934b.aae);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eU ? 1231 : 1237) + ((((((kc.hashCode(this.eS) + 527) * 31) + this.eT) * 31) + this.name) * 31)) * 31;
            if (!this.eV) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.c */
    public static final class C0935c extends ka<C0935c> {
        private static volatile C0935c[] eW;
        public String eX;
        public long eY;
        public long eZ;
        public boolean fa;
        public long fb;

        public C0935c() {
            m2479g();
        }

        public static C0935c[] m2474f() {
            if (eW == null) {
                synchronized (kc.aah) {
                    if (eW == null) {
                        eW = new C0935c[0];
                    }
                }
            }
            return eW;
        }

        public void m2475a(jz jzVar) throws IOException {
            if (!this.eX.equals("")) {
                jzVar.m1050b(1, this.eX);
            }
            if (this.eY != 0) {
                jzVar.m1049b(2, this.eY);
            }
            if (this.eZ != 2147483647L) {
                jzVar.m1049b(3, this.eZ);
            }
            if (this.fa) {
                jzVar.m1047a(4, this.fa);
            }
            if (this.fb != 0) {
                jzVar.m1049b(5, this.fb);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2476b(jy jyVar) throws IOException {
            return m2478d(jyVar);
        }

        public int m2477c() {
            int c = super.m2115c();
            if (!this.eX.equals("")) {
                c += jz.m1040g(1, this.eX);
            }
            if (this.eY != 0) {
                c += jz.m1036d(2, this.eY);
            }
            if (this.eZ != 2147483647L) {
                c += jz.m1036d(3, this.eZ);
            }
            if (this.fa) {
                c += jz.m1033b(4, this.fa);
            }
            if (this.fb != 0) {
                c += jz.m1036d(5, this.fb);
            }
            this.DY = c;
            return c;
        }

        public C0935c m2478d(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        this.eX = jyVar.readString();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.eY = jyVar.kA();
                        continue;
                    case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                        this.eZ = jyVar.kA();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.fa = jyVar.kC();
                        continue;
                    case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                        this.fb = jyVar.kA();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0935c)) {
                return false;
            }
            C0935c c0935c = (C0935c) o;
            if (this.eX == null) {
                if (c0935c.eX != null) {
                    return false;
                }
            } else if (!this.eX.equals(c0935c.eX)) {
                return false;
            }
            if (this.eY != c0935c.eY || this.eZ != c0935c.eZ || this.fa != c0935c.fa || this.fb != c0935c.fb) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0935c.aae == null || c0935c.aae.isEmpty();
            } else {
                return this.aae.equals(c0935c.aae);
            }
        }

        public C0935c m2479g() {
            this.eX = "";
            this.eY = 0;
            this.eZ = 2147483647L;
            this.fa = false;
            this.fb = 0;
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.fa ? 1231 : 1237) + (((((((this.eX == null ? 0 : this.eX.hashCode()) + 527) * 31) + ((int) (this.eY ^ (this.eY >>> 32)))) * 31) + ((int) (this.eZ ^ (this.eZ >>> 32)))) * 31)) * 31) + ((int) (this.fb ^ (this.fb >>> 32)))) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.d */
    public static final class C0936d extends ka<C0936d> {
        public C0945a[] fc;
        public C0945a[] fd;
        public C0935c[] fe;

        public C0936d() {
            m2484h();
        }

        public void m2480a(jz jzVar) throws IOException {
            int i = 0;
            if (this.fc != null && this.fc.length > 0) {
                for (ke keVar : this.fc) {
                    if (keVar != null) {
                        jzVar.m1046a(1, keVar);
                    }
                }
            }
            if (this.fd != null && this.fd.length > 0) {
                for (ke keVar2 : this.fd) {
                    if (keVar2 != null) {
                        jzVar.m1046a(2, keVar2);
                    }
                }
            }
            if (this.fe != null && this.fe.length > 0) {
                while (i < this.fe.length) {
                    ke keVar3 = this.fe[i];
                    if (keVar3 != null) {
                        jzVar.m1046a(3, keVar3);
                    }
                    i++;
                }
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2481b(jy jyVar) throws IOException {
            return m2483e(jyVar);
        }

        public int m2482c() {
            int i;
            int i2 = 0;
            int c = super.m2115c();
            if (this.fc != null && this.fc.length > 0) {
                i = c;
                for (ke keVar : this.fc) {
                    if (keVar != null) {
                        i += jz.m1032b(1, keVar);
                    }
                }
                c = i;
            }
            if (this.fd != null && this.fd.length > 0) {
                i = c;
                for (ke keVar2 : this.fd) {
                    if (keVar2 != null) {
                        i += jz.m1032b(2, keVar2);
                    }
                }
                c = i;
            }
            if (this.fe != null && this.fe.length > 0) {
                while (i2 < this.fe.length) {
                    ke keVar3 = this.fe[i2];
                    if (keVar3 != null) {
                        c += jz.m1032b(3, keVar3);
                    }
                    i2++;
                }
            }
            this.DY = c;
            return c;
        }

        public C0936d m2483e(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        c = kh.m1075c(jyVar, 10);
                        ky = this.fc == null ? 0 : this.fc.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.fc = obj;
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        c = kh.m1075c(jyVar, 18);
                        ky = this.fd == null ? 0 : this.fd.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fd, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.fd = obj;
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        c = kh.m1075c(jyVar, 26);
                        ky = this.fe == null ? 0 : this.fe.length;
                        obj = new C0935c[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fe, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0935c();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0935c();
                        jyVar.m1024a(obj[ky]);
                        this.fe = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0936d)) {
                return false;
            }
            C0936d c0936d = (C0936d) o;
            if (!kc.equals(this.fc, c0936d.fc) || !kc.equals(this.fd, c0936d.fd) || !kc.equals(this.fe, c0936d.fe)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0936d.aae == null || c0936d.aae.isEmpty();
            } else {
                return this.aae.equals(c0936d.aae);
            }
        }

        public C0936d m2484h() {
            this.fc = C0945a.m2528r();
            this.fd = C0945a.m2528r();
            this.fe = C0935c.m2474f();
            this.aae = null;
            this.DY = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((kc.hashCode(this.fc) + 527) * 31) + kc.hashCode(this.fd)) * 31) + kc.hashCode(this.fe)) * 31;
            int hashCode2 = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.e */
    public static final class C0937e extends ka<C0937e> {
        private static volatile C0937e[] ff;
        public int key;
        public int value;

        public C0937e() {
            m2490j();
        }

        public static C0937e[] m2485i() {
            if (ff == null) {
                synchronized (kc.aah) {
                    if (ff == null) {
                        ff = new C0937e[0];
                    }
                }
            }
            return ff;
        }

        public void m2486a(jz jzVar) throws IOException {
            jzVar.m1055f(1, this.key);
            jzVar.m1055f(2, this.value);
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2487b(jy jyVar) throws IOException {
            return m2489f(jyVar);
        }

        public int m2488c() {
            int c = (super.m2115c() + jz.m1039g(1, this.key)) + jz.m1039g(2, this.value);
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0937e)) {
                return false;
            }
            C0937e c0937e = (C0937e) o;
            if (this.key != c0937e.key || this.value != c0937e.value) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0937e.aae == null || c0937e.aae.isEmpty();
            } else {
                return this.aae.equals(c0937e.aae);
            }
        }

        public C0937e m2489f(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        this.key = jyVar.kB();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        this.value = jyVar.kB();
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

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode + i;
        }

        public C0937e m2490j() {
            this.key = 0;
            this.value = 0;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.f */
    public static final class C0938f extends ka<C0938f> {
        public String[] fg;
        public String[] fh;
        public C0945a[] fi;
        public C0937e[] fj;
        public C0934b[] fk;
        public C0934b[] fl;
        public C0934b[] fm;
        public C0939g[] fn;
        public String fo;
        public String fp;
        public String fq;
        public String fr;
        public C0933a fs;
        public float ft;
        public boolean fu;
        public String[] fv;
        public int fw;

        public C0938f() {
            m2496k();
        }

        public static C0938f m2491a(byte[] bArr) throws kd {
            return (C0938f) ke.m1064a(new C0938f(), bArr);
        }

        public void m2492a(jz jzVar) throws IOException {
            int i = 0;
            if (this.fh != null && this.fh.length > 0) {
                for (String str : this.fh) {
                    if (str != null) {
                        jzVar.m1050b(1, str);
                    }
                }
            }
            if (this.fi != null && this.fi.length > 0) {
                for (ke keVar : this.fi) {
                    if (keVar != null) {
                        jzVar.m1046a(2, keVar);
                    }
                }
            }
            if (this.fj != null && this.fj.length > 0) {
                for (ke keVar2 : this.fj) {
                    if (keVar2 != null) {
                        jzVar.m1046a(3, keVar2);
                    }
                }
            }
            if (this.fk != null && this.fk.length > 0) {
                for (ke keVar22 : this.fk) {
                    if (keVar22 != null) {
                        jzVar.m1046a(4, keVar22);
                    }
                }
            }
            if (this.fl != null && this.fl.length > 0) {
                for (ke keVar222 : this.fl) {
                    if (keVar222 != null) {
                        jzVar.m1046a(5, keVar222);
                    }
                }
            }
            if (this.fm != null && this.fm.length > 0) {
                for (ke keVar2222 : this.fm) {
                    if (keVar2222 != null) {
                        jzVar.m1046a(6, keVar2222);
                    }
                }
            }
            if (this.fn != null && this.fn.length > 0) {
                for (ke keVar22222 : this.fn) {
                    if (keVar22222 != null) {
                        jzVar.m1046a(7, keVar22222);
                    }
                }
            }
            if (!this.fo.equals("")) {
                jzVar.m1050b(9, this.fo);
            }
            if (!this.fp.equals("")) {
                jzVar.m1050b(10, this.fp);
            }
            if (!this.fq.equals("0")) {
                jzVar.m1050b(12, this.fq);
            }
            if (!this.fr.equals("")) {
                jzVar.m1050b(13, this.fr);
            }
            if (this.fs != null) {
                jzVar.m1046a(14, this.fs);
            }
            if (Float.floatToIntBits(this.ft) != Float.floatToIntBits(0.0f)) {
                jzVar.m1045a(15, this.ft);
            }
            if (this.fv != null && this.fv.length > 0) {
                for (String str2 : this.fv) {
                    if (str2 != null) {
                        jzVar.m1050b(16, str2);
                    }
                }
            }
            if (this.fw != 0) {
                jzVar.m1055f(17, this.fw);
            }
            if (this.fu) {
                jzVar.m1047a(18, this.fu);
            }
            if (this.fg != null && this.fg.length > 0) {
                while (i < this.fg.length) {
                    String str3 = this.fg[i];
                    if (str3 != null) {
                        jzVar.m1050b(19, str3);
                    }
                    i++;
                }
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2493b(jy jyVar) throws IOException {
            return m2495g(jyVar);
        }

        public int m2494c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.m2115c();
            if (this.fh == null || this.fh.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.fh) {
                    if (str != null) {
                        i3++;
                        i2 += jz.bQ(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.fi != null && this.fi.length > 0) {
                i2 = i;
                for (ke keVar : this.fi) {
                    if (keVar != null) {
                        i2 += jz.m1032b(2, keVar);
                    }
                }
                i = i2;
            }
            if (this.fj != null && this.fj.length > 0) {
                i2 = i;
                for (ke keVar2 : this.fj) {
                    if (keVar2 != null) {
                        i2 += jz.m1032b(3, keVar2);
                    }
                }
                i = i2;
            }
            if (this.fk != null && this.fk.length > 0) {
                i2 = i;
                for (ke keVar22 : this.fk) {
                    if (keVar22 != null) {
                        i2 += jz.m1032b(4, keVar22);
                    }
                }
                i = i2;
            }
            if (this.fl != null && this.fl.length > 0) {
                i2 = i;
                for (ke keVar222 : this.fl) {
                    if (keVar222 != null) {
                        i2 += jz.m1032b(5, keVar222);
                    }
                }
                i = i2;
            }
            if (this.fm != null && this.fm.length > 0) {
                i2 = i;
                for (ke keVar2222 : this.fm) {
                    if (keVar2222 != null) {
                        i2 += jz.m1032b(6, keVar2222);
                    }
                }
                i = i2;
            }
            if (this.fn != null && this.fn.length > 0) {
                i2 = i;
                for (ke keVar22222 : this.fn) {
                    if (keVar22222 != null) {
                        i2 += jz.m1032b(7, keVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fo.equals("")) {
                i += jz.m1040g(9, this.fo);
            }
            if (!this.fp.equals("")) {
                i += jz.m1040g(10, this.fp);
            }
            if (!this.fq.equals("0")) {
                i += jz.m1040g(12, this.fq);
            }
            if (!this.fr.equals("")) {
                i += jz.m1040g(13, this.fr);
            }
            if (this.fs != null) {
                i += jz.m1032b(14, this.fs);
            }
            if (Float.floatToIntBits(this.ft) != Float.floatToIntBits(0.0f)) {
                i += jz.m1031b(15, this.ft);
            }
            if (this.fv != null && this.fv.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fv) {
                    if (str2 != null) {
                        c++;
                        i3 += jz.bQ(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fw != 0) {
                i += jz.m1039g(17, this.fw);
            }
            if (this.fu) {
                i += jz.m1033b(18, this.fu);
            }
            if (this.fg != null && this.fg.length > 0) {
                i2 = 0;
                i3 = 0;
                while (i4 < this.fg.length) {
                    String str3 = this.fg[i4];
                    if (str3 != null) {
                        i3++;
                        i2 += jz.bQ(str3);
                    }
                    i4++;
                }
                i = (i + i2) + (i3 * 2);
            }
            this.DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0938f)) {
                return false;
            }
            C0938f c0938f = (C0938f) o;
            if (!kc.equals(this.fg, c0938f.fg) || !kc.equals(this.fh, c0938f.fh) || !kc.equals(this.fi, c0938f.fi) || !kc.equals(this.fj, c0938f.fj) || !kc.equals(this.fk, c0938f.fk) || !kc.equals(this.fl, c0938f.fl) || !kc.equals(this.fm, c0938f.fm) || !kc.equals(this.fn, c0938f.fn)) {
                return false;
            }
            if (this.fo == null) {
                if (c0938f.fo != null) {
                    return false;
                }
            } else if (!this.fo.equals(c0938f.fo)) {
                return false;
            }
            if (this.fp == null) {
                if (c0938f.fp != null) {
                    return false;
                }
            } else if (!this.fp.equals(c0938f.fp)) {
                return false;
            }
            if (this.fq == null) {
                if (c0938f.fq != null) {
                    return false;
                }
            } else if (!this.fq.equals(c0938f.fq)) {
                return false;
            }
            if (this.fr == null) {
                if (c0938f.fr != null) {
                    return false;
                }
            } else if (!this.fr.equals(c0938f.fr)) {
                return false;
            }
            if (this.fs == null) {
                if (c0938f.fs != null) {
                    return false;
                }
            } else if (!this.fs.equals(c0938f.fs)) {
                return false;
            }
            if (Float.floatToIntBits(this.ft) != Float.floatToIntBits(c0938f.ft) || this.fu != c0938f.fu || !kc.equals(this.fv, c0938f.fv) || this.fw != c0938f.fw) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0938f.aae == null || c0938f.aae.isEmpty();
            } else {
                return this.aae.equals(c0938f.aae);
            }
        }

        public C0938f m2495g(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        c = kh.m1075c(jyVar, 10);
                        ky = this.fh == null ? 0 : this.fh.length;
                        obj = new String[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fh, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.readString();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.readString();
                        this.fh = obj;
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        c = kh.m1075c(jyVar, 18);
                        ky = this.fi == null ? 0 : this.fi.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fi, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.fi = obj;
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        c = kh.m1075c(jyVar, 26);
                        ky = this.fj == null ? 0 : this.fj.length;
                        obj = new C0937e[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fj, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0937e();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0937e();
                        jyVar.m1024a(obj[ky]);
                        this.fj = obj;
                        continue;
                    case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                        c = kh.m1075c(jyVar, 34);
                        ky = this.fk == null ? 0 : this.fk.length;
                        obj = new C0934b[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0934b();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0934b();
                        jyVar.m1024a(obj[ky]);
                        this.fk = obj;
                        continue;
                    case C0519R.styleable.Theme_dialogTheme /*42*/:
                        c = kh.m1075c(jyVar, 42);
                        ky = this.fl == null ? 0 : this.fl.length;
                        obj = new C0934b[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fl, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0934b();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0934b();
                        jyVar.m1024a(obj[ky]);
                        this.fl = obj;
                        continue;
                    case C0519R.styleable.Theme_buttonBarStyle /*50*/:
                        c = kh.m1075c(jyVar, 50);
                        ky = this.fm == null ? 0 : this.fm.length;
                        obj = new C0934b[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fm, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0934b();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0934b();
                        jyVar.m1024a(obj[ky]);
                        this.fm = obj;
                        continue;
                    case C0519R.styleable.Theme_toolbarStyle /*58*/:
                        c = kh.m1075c(jyVar, 58);
                        ky = this.fn == null ? 0 : this.fn.length;
                        obj = new C0939g[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0939g();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0939g();
                        jyVar.m1024a(obj[ky]);
                        this.fn = obj;
                        continue;
                    case C0519R.styleable.Theme_listPopupWindowStyle /*74*/:
                        this.fo = jyVar.readString();
                        continue;
                    case C0519R.styleable.Theme_colorPrimaryDark /*82*/:
                        this.fp = jyVar.readString();
                        continue;
                    case C0519R.styleable.Theme_buttonStyle /*98*/:
                        this.fq = jyVar.readString();
                        continue;
                    case C0519R.styleable.Theme_switchStyle /*106*/:
                        this.fr = jyVar.readString();
                        continue;
                    case 114:
                        if (this.fs == null) {
                            this.fs = new C0933a();
                        }
                        jyVar.m1024a(this.fs);
                        continue;
                    case 125:
                        this.ft = jyVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        c = kh.m1075c(jyVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        ky = this.fv == null ? 0 : this.fv.length;
                        obj = new String[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.readString();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.readString();
                        this.fv = obj;
                        continue;
                    case 136:
                        this.fw = jyVar.kB();
                        continue;
                    case 144:
                        this.fu = jyVar.kC();
                        continue;
                    case 154:
                        c = kh.m1075c(jyVar, 154);
                        ky = this.fg == null ? 0 : this.fg.length;
                        obj = new String[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fg, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.readString();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.readString();
                        this.fg = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fu ? 1231 : 1237) + (((((this.fs == null ? 0 : this.fs.hashCode()) + (((this.fr == null ? 0 : this.fr.hashCode()) + (((this.fq == null ? 0 : this.fq.hashCode()) + (((this.fp == null ? 0 : this.fp.hashCode()) + (((this.fo == null ? 0 : this.fo.hashCode()) + ((((((((((((((((kc.hashCode(this.fg) + 527) * 31) + kc.hashCode(this.fh)) * 31) + kc.hashCode(this.fi)) * 31) + kc.hashCode(this.fj)) * 31) + kc.hashCode(this.fk)) * 31) + kc.hashCode(this.fl)) * 31) + kc.hashCode(this.fm)) * 31) + kc.hashCode(this.fn)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.ft)) * 31)) * 31) + kc.hashCode(this.fv)) * 31) + this.fw) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        public C0938f m2496k() {
            this.fg = kh.aao;
            this.fh = kh.aao;
            this.fi = C0945a.m2528r();
            this.fj = C0937e.m2485i();
            this.fk = C0934b.m2468d();
            this.fl = C0934b.m2468d();
            this.fm = C0934b.m2468d();
            this.fn = C0939g.m2497l();
            this.fo = "";
            this.fp = "";
            this.fq = "0";
            this.fr = "";
            this.fs = null;
            this.ft = 0.0f;
            this.fu = false;
            this.fv = kh.aao;
            this.fw = 0;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.g */
    public static final class C0939g extends ka<C0939g> {
        private static volatile C0939g[] fx;
        public int[] fA;
        public int[] fB;
        public int[] fC;
        public int[] fD;
        public int[] fE;
        public int[] fF;
        public int[] fG;
        public int[] fH;
        public int[] fy;
        public int[] fz;

        public C0939g() {
            m2502m();
        }

        public static C0939g[] m2497l() {
            if (fx == null) {
                synchronized (kc.aah) {
                    if (fx == null) {
                        fx = new C0939g[0];
                    }
                }
            }
            return fx;
        }

        public void m2498a(jz jzVar) throws IOException {
            int i = 0;
            if (this.fy != null && this.fy.length > 0) {
                for (int f : this.fy) {
                    jzVar.m1055f(1, f);
                }
            }
            if (this.fz != null && this.fz.length > 0) {
                for (int f2 : this.fz) {
                    jzVar.m1055f(2, f2);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int f22 : this.fA) {
                    jzVar.m1055f(3, f22);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int f222 : this.fB) {
                    jzVar.m1055f(4, f222);
                }
            }
            if (this.fC != null && this.fC.length > 0) {
                for (int f2222 : this.fC) {
                    jzVar.m1055f(5, f2222);
                }
            }
            if (this.fD != null && this.fD.length > 0) {
                for (int f22222 : this.fD) {
                    jzVar.m1055f(6, f22222);
                }
            }
            if (this.fE != null && this.fE.length > 0) {
                for (int f222222 : this.fE) {
                    jzVar.m1055f(7, f222222);
                }
            }
            if (this.fF != null && this.fF.length > 0) {
                for (int f2222222 : this.fF) {
                    jzVar.m1055f(8, f2222222);
                }
            }
            if (this.fG != null && this.fG.length > 0) {
                for (int f22222222 : this.fG) {
                    jzVar.m1055f(9, f22222222);
                }
            }
            if (this.fH != null && this.fH.length > 0) {
                while (i < this.fH.length) {
                    jzVar.m1055f(10, this.fH[i]);
                    i++;
                }
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2499b(jy jyVar) throws IOException {
            return m2501h(jyVar);
        }

        public int m2500c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2115c();
            if (this.fy == null || this.fy.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cC : this.fy) {
                    i2 += jz.cC(cC);
                }
                i = (c + i2) + (this.fy.length * 1);
            }
            if (this.fz != null && this.fz.length > 0) {
                c = 0;
                for (int cC2 : this.fz) {
                    c += jz.cC(cC2);
                }
                i = (i + c) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int cC22 : this.fA) {
                    c += jz.cC(cC22);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int cC222 : this.fB) {
                    c += jz.cC(cC222);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != null && this.fC.length > 0) {
                c = 0;
                for (int cC2222 : this.fC) {
                    c += jz.cC(cC2222);
                }
                i = (i + c) + (this.fC.length * 1);
            }
            if (this.fD != null && this.fD.length > 0) {
                c = 0;
                for (int cC22222 : this.fD) {
                    c += jz.cC(cC22222);
                }
                i = (i + c) + (this.fD.length * 1);
            }
            if (this.fE != null && this.fE.length > 0) {
                c = 0;
                for (int cC222222 : this.fE) {
                    c += jz.cC(cC222222);
                }
                i = (i + c) + (this.fE.length * 1);
            }
            if (this.fF != null && this.fF.length > 0) {
                c = 0;
                for (int cC2222222 : this.fF) {
                    c += jz.cC(cC2222222);
                }
                i = (i + c) + (this.fF.length * 1);
            }
            if (this.fG != null && this.fG.length > 0) {
                c = 0;
                for (int cC22222222 : this.fG) {
                    c += jz.cC(cC22222222);
                }
                i = (i + c) + (this.fG.length * 1);
            }
            if (this.fH != null && this.fH.length > 0) {
                i2 = 0;
                while (i3 < this.fH.length) {
                    i2 += jz.cC(this.fH[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fH.length * 1);
            }
            this.DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0939g)) {
                return false;
            }
            C0939g c0939g = (C0939g) o;
            if (!kc.equals(this.fy, c0939g.fy) || !kc.equals(this.fz, c0939g.fz) || !kc.equals(this.fA, c0939g.fA) || !kc.equals(this.fB, c0939g.fB) || !kc.equals(this.fC, c0939g.fC) || !kc.equals(this.fD, c0939g.fD) || !kc.equals(this.fE, c0939g.fE) || !kc.equals(this.fF, c0939g.fF) || !kc.equals(this.fG, c0939g.fG) || !kc.equals(this.fH, c0939g.fH)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0939g.aae == null || c0939g.aae.isEmpty();
            } else {
                return this.aae.equals(c0939g.aae);
            }
        }

        public C0939g m2501h(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                int cw;
                Object obj2;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        c = kh.m1075c(jyVar, 8);
                        ky = this.fy == null ? 0 : this.fy.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fy, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fy = obj;
                        continue;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fy == null ? 0 : this.fy.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fy, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fy = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        c = kh.m1075c(jyVar, 16);
                        ky = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fz = obj;
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fz = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                        c = kh.m1075c(jyVar, 24);
                        ky = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fA = obj;
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fA = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        c = kh.m1075c(jyVar, 32);
                        ky = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fB = obj;
                        continue;
                    case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fB = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                        c = kh.m1075c(jyVar, 40);
                        ky = this.fC == null ? 0 : this.fC.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fC, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fC = obj;
                        continue;
                    case C0519R.styleable.Theme_dialogTheme /*42*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fC == null ? 0 : this.fC.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fC, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fC = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_homeAsUpIndicator /*48*/:
                        c = kh.m1075c(jyVar, 48);
                        ky = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fD = obj;
                        continue;
                    case C0519R.styleable.Theme_buttonBarStyle /*50*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fD = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_dividerHorizontal /*56*/:
                        c = kh.m1075c(jyVar, 56);
                        ky = this.fE == null ? 0 : this.fE.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fE, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fE = obj;
                        continue;
                    case C0519R.styleable.Theme_toolbarStyle /*58*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fE == null ? 0 : this.fE.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fE, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fE = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        c = kh.m1075c(jyVar, 64);
                        ky = this.fF == null ? 0 : this.fF.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fF, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fF = obj;
                        continue;
                    case C0519R.styleable.Theme_textColorSearchUrl /*66*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fF == null ? 0 : this.fF.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fF, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fF = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_listPreferredItemPaddingRight /*72*/:
                        c = kh.m1075c(jyVar, 72);
                        ky = this.fG == null ? 0 : this.fG.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fG, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fG = obj;
                        continue;
                    case C0519R.styleable.Theme_listPopupWindowStyle /*74*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fG == null ? 0 : this.fG.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fG, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fG = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_listChoiceBackgroundIndicator /*80*/:
                        c = kh.m1075c(jyVar, 80);
                        ky = this.fH == null ? 0 : this.fH.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fH, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fH = obj;
                        continue;
                    case C0519R.styleable.Theme_colorPrimaryDark /*82*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fH == null ? 0 : this.fH.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fH, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fH = obj2;
                        jyVar.cx(cw);
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

        public int hashCode() {
            int hashCode = (((((((((((((((((((kc.hashCode(this.fy) + 527) * 31) + kc.hashCode(this.fz)) * 31) + kc.hashCode(this.fA)) * 31) + kc.hashCode(this.fB)) * 31) + kc.hashCode(this.fC)) * 31) + kc.hashCode(this.fD)) * 31) + kc.hashCode(this.fE)) * 31) + kc.hashCode(this.fF)) * 31) + kc.hashCode(this.fG)) * 31) + kc.hashCode(this.fH)) * 31;
            int hashCode2 = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode2 + hashCode;
        }

        public C0939g m2502m() {
            this.fy = kh.aaj;
            this.fz = kh.aaj;
            this.fA = kh.aaj;
            this.fB = kh.aaj;
            this.fC = kh.aaj;
            this.fD = kh.aaj;
            this.fE = kh.aaj;
            this.fF = kh.aaj;
            this.fG = kh.aaj;
            this.fH = kh.aaj;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.h */
    public static final class C0940h extends ka<C0940h> {
        public static final kb<C0945a, C0940h> fI;
        private static final C0940h[] fJ;
        public int[] fK;
        public int[] fL;
        public int[] fM;
        public int fN;
        public int[] fO;
        public int fP;
        public int fQ;

        static {
            fI = kb.m1060a(11, C0940h.class, 810);
            fJ = new C0940h[0];
        }

        public C0940h() {
            m2507n();
        }

        public void m2503a(jz jzVar) throws IOException {
            int i = 0;
            if (this.fK != null && this.fK.length > 0) {
                for (int f : this.fK) {
                    jzVar.m1055f(1, f);
                }
            }
            if (this.fL != null && this.fL.length > 0) {
                for (int f2 : this.fL) {
                    jzVar.m1055f(2, f2);
                }
            }
            if (this.fM != null && this.fM.length > 0) {
                for (int f22 : this.fM) {
                    jzVar.m1055f(3, f22);
                }
            }
            if (this.fN != 0) {
                jzVar.m1055f(4, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                while (i < this.fO.length) {
                    jzVar.m1055f(5, this.fO[i]);
                    i++;
                }
            }
            if (this.fP != 0) {
                jzVar.m1055f(6, this.fP);
            }
            if (this.fQ != 0) {
                jzVar.m1055f(7, this.fQ);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2504b(jy jyVar) throws IOException {
            return m2506i(jyVar);
        }

        public int m2505c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m2115c();
            if (this.fK == null || this.fK.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cC : this.fK) {
                    i2 += jz.cC(cC);
                }
                i = (c + i2) + (this.fK.length * 1);
            }
            if (this.fL != null && this.fL.length > 0) {
                c = 0;
                for (int cC2 : this.fL) {
                    c += jz.cC(cC2);
                }
                i = (i + c) + (this.fL.length * 1);
            }
            if (this.fM != null && this.fM.length > 0) {
                c = 0;
                for (int cC22 : this.fM) {
                    c += jz.cC(cC22);
                }
                i = (i + c) + (this.fM.length * 1);
            }
            if (this.fN != 0) {
                i += jz.m1039g(4, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                i2 = 0;
                while (i3 < this.fO.length) {
                    i2 += jz.cC(this.fO[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fO.length * 1);
            }
            if (this.fP != 0) {
                i += jz.m1039g(6, this.fP);
            }
            if (this.fQ != 0) {
                i += jz.m1039g(7, this.fQ);
            }
            this.DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0940h)) {
                return false;
            }
            C0940h c0940h = (C0940h) o;
            if (!kc.equals(this.fK, c0940h.fK) || !kc.equals(this.fL, c0940h.fL) || !kc.equals(this.fM, c0940h.fM) || this.fN != c0940h.fN || !kc.equals(this.fO, c0940h.fO) || this.fP != c0940h.fP || this.fQ != c0940h.fQ) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0940h.aae == null || c0940h.aae.isEmpty();
            } else {
                return this.aae.equals(c0940h.aae);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((kc.hashCode(this.fK) + 527) * 31) + kc.hashCode(this.fL)) * 31) + kc.hashCode(this.fM)) * 31) + this.fN) * 31) + kc.hashCode(this.fO)) * 31) + this.fP) * 31) + this.fQ) * 31;
            int hashCode2 = (this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode();
            return hashCode2 + hashCode;
        }

        public C0940h m2506i(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                int cw;
                Object obj2;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        c = kh.m1075c(jyVar, 8);
                        ky = this.fK == null ? 0 : this.fK.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fK, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fK = obj;
                        continue;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fK == null ? 0 : this.fK.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fK, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fK = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                        c = kh.m1075c(jyVar, 16);
                        ky = this.fL == null ? 0 : this.fL.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fL, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fL = obj;
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fL == null ? 0 : this.fL.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fL, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fL = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                        c = kh.m1075c(jyVar, 24);
                        ky = this.fM == null ? 0 : this.fM.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fM, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fM = obj;
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fM == null ? 0 : this.fM.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fM, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fM = obj2;
                        jyVar.cx(cw);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                        this.fN = jyVar.kB();
                        continue;
                    case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                        c = kh.m1075c(jyVar, 40);
                        ky = this.fO == null ? 0 : this.fO.length;
                        obj = new int[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fO, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = jyVar.kB();
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = jyVar.kB();
                        this.fO = obj;
                        continue;
                    case C0519R.styleable.Theme_dialogTheme /*42*/:
                        cw = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            jyVar.kB();
                            ky++;
                        }
                        jyVar.cy(c);
                        c = this.fO == null ? 0 : this.fO.length;
                        obj2 = new int[(ky + c)];
                        if (c != 0) {
                            System.arraycopy(this.fO, 0, obj2, 0, c);
                        }
                        while (c < obj2.length) {
                            obj2[c] = jyVar.kB();
                            c++;
                        }
                        this.fO = obj2;
                        jyVar.cx(cw);
                        continue;
                    case C0519R.styleable.Theme_homeAsUpIndicator /*48*/:
                        this.fP = jyVar.kB();
                        continue;
                    case C0519R.styleable.Theme_dividerHorizontal /*56*/:
                        this.fQ = jyVar.kB();
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

        public C0940h m2507n() {
            this.fK = kh.aaj;
            this.fL = kh.aaj;
            this.fM = kh.aaj;
            this.fN = 0;
            this.fO = kh.aaj;
            this.fP = 0;
            this.fQ = 0;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.i */
    public static final class C0941i extends ka<C0941i> {
        private static volatile C0941i[] fR;
        public C0945a fS;
        public C0936d fT;
        public String name;

        public C0941i() {
            m2513p();
        }

        public static C0941i[] m2508o() {
            if (fR == null) {
                synchronized (kc.aah) {
                    if (fR == null) {
                        fR = new C0941i[0];
                    }
                }
            }
            return fR;
        }

        public void m2509a(jz jzVar) throws IOException {
            if (!this.name.equals("")) {
                jzVar.m1050b(1, this.name);
            }
            if (this.fS != null) {
                jzVar.m1046a(2, this.fS);
            }
            if (this.fT != null) {
                jzVar.m1046a(3, this.fT);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2510b(jy jyVar) throws IOException {
            return m2512j(jyVar);
        }

        public int m2511c() {
            int c = super.m2115c();
            if (!this.name.equals("")) {
                c += jz.m1040g(1, this.name);
            }
            if (this.fS != null) {
                c += jz.m1032b(2, this.fS);
            }
            if (this.fT != null) {
                c += jz.m1032b(3, this.fT);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0941i)) {
                return false;
            }
            C0941i c0941i = (C0941i) o;
            if (this.name == null) {
                if (c0941i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c0941i.name)) {
                return false;
            }
            if (this.fS == null) {
                if (c0941i.fS != null) {
                    return false;
                }
            } else if (!this.fS.equals(c0941i.fS)) {
                return false;
            }
            if (this.fT == null) {
                if (c0941i.fT != null) {
                    return false;
                }
            } else if (!this.fT.equals(c0941i.fT)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0941i.aae == null || c0941i.aae.isEmpty();
            } else {
                return this.aae.equals(c0941i.aae);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fT == null ? 0 : this.fT.hashCode()) + (((this.fS == null ? 0 : this.fS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        public C0941i m2512j(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        this.name = jyVar.readString();
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        if (this.fS == null) {
                            this.fS = new C0945a();
                        }
                        jyVar.m1024a(this.fS);
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        if (this.fT == null) {
                            this.fT = new C0936d();
                        }
                        jyVar.m1024a(this.fT);
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

        public C0941i m2513p() {
            this.name = "";
            this.fS = null;
            this.fT = null;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.j */
    public static final class C0942j extends ka<C0942j> {
        public C0941i[] fU;
        public C0938f fV;
        public String fW;

        public C0942j() {
            m2519q();
        }

        public static C0942j m2514b(byte[] bArr) throws kd {
            return (C0942j) ke.m1064a(new C0942j(), bArr);
        }

        public void m2515a(jz jzVar) throws IOException {
            if (this.fU != null && this.fU.length > 0) {
                for (ke keVar : this.fU) {
                    if (keVar != null) {
                        jzVar.m1046a(1, keVar);
                    }
                }
            }
            if (this.fV != null) {
                jzVar.m1046a(2, this.fV);
            }
            if (!this.fW.equals("")) {
                jzVar.m1050b(3, this.fW);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2516b(jy jyVar) throws IOException {
            return m2518k(jyVar);
        }

        public int m2517c() {
            int c = super.m2115c();
            if (this.fU != null && this.fU.length > 0) {
                for (ke keVar : this.fU) {
                    if (keVar != null) {
                        c += jz.m1032b(1, keVar);
                    }
                }
            }
            if (this.fV != null) {
                c += jz.m1032b(2, this.fV);
            }
            if (!this.fW.equals("")) {
                c += jz.m1040g(3, this.fW);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0942j)) {
                return false;
            }
            C0942j c0942j = (C0942j) o;
            if (!kc.equals(this.fU, c0942j.fU)) {
                return false;
            }
            if (this.fV == null) {
                if (c0942j.fV != null) {
                    return false;
                }
            } else if (!this.fV.equals(c0942j.fV)) {
                return false;
            }
            if (this.fW == null) {
                if (c0942j.fW != null) {
                    return false;
                }
            } else if (!this.fW.equals(c0942j.fW)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0942j.aae == null || c0942j.aae.isEmpty();
            } else {
                return this.aae.equals(c0942j.aae);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fW == null ? 0 : this.fW.hashCode()) + (((this.fV == null ? 0 : this.fV.hashCode()) + ((kc.hashCode(this.fU) + 527) * 31)) * 31)) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        public C0942j m2518k(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                        int c = kh.m1075c(jyVar, 10);
                        ky = this.fU == null ? 0 : this.fU.length;
                        Object obj = new C0941i[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fU, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0941i();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0941i();
                        jyVar.m1024a(obj[ky]);
                        this.fU = obj;
                        continue;
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        if (this.fV == null) {
                            this.fV = new C0938f();
                        }
                        jyVar.m1024a(this.fV);
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        this.fW = jyVar.readString();
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

        public C0942j m2519q() {
            this.fU = C0941i.m2508o();
            this.fV = null;
            this.fW = "";
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }
}
