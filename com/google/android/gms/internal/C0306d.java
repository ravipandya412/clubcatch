package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C0306d {

    /* renamed from: com.google.android.gms.internal.d.a */
    public static final class C0945a extends ka<C0945a> {
        private static volatile C0945a[] fX;
        public String fY;
        public C0945a[] fZ;
        public C0945a[] ga;
        public C0945a[] gb;
        public String gc;
        public String gd;
        public long ge;
        public boolean gf;
        public C0945a[] gg;
        public int[] gh;
        public boolean gi;
        public int type;

        public C0945a() {
            m2533s();
        }

        public static C0945a[] m2528r() {
            if (fX == null) {
                synchronized (kc.aah) {
                    if (fX == null) {
                        fX = new C0945a[0];
                    }
                }
            }
            return fX;
        }

        public void m2529a(jz jzVar) throws IOException {
            int i = 0;
            jzVar.m1055f(1, this.type);
            if (!this.fY.equals("")) {
                jzVar.m1050b(2, this.fY);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                for (ke keVar : this.fZ) {
                    if (keVar != null) {
                        jzVar.m1046a(3, keVar);
                    }
                }
            }
            if (this.ga != null && this.ga.length > 0) {
                for (ke keVar2 : this.ga) {
                    if (keVar2 != null) {
                        jzVar.m1046a(4, keVar2);
                    }
                }
            }
            if (this.gb != null && this.gb.length > 0) {
                for (ke keVar22 : this.gb) {
                    if (keVar22 != null) {
                        jzVar.m1046a(5, keVar22);
                    }
                }
            }
            if (!this.gc.equals("")) {
                jzVar.m1050b(6, this.gc);
            }
            if (!this.gd.equals("")) {
                jzVar.m1050b(7, this.gd);
            }
            if (this.ge != 0) {
                jzVar.m1049b(8, this.ge);
            }
            if (this.gi) {
                jzVar.m1047a(9, this.gi);
            }
            if (this.gh != null && this.gh.length > 0) {
                for (int f : this.gh) {
                    jzVar.m1055f(10, f);
                }
            }
            if (this.gg != null && this.gg.length > 0) {
                while (i < this.gg.length) {
                    ke keVar3 = this.gg[i];
                    if (keVar3 != null) {
                        jzVar.m1046a(11, keVar3);
                    }
                    i++;
                }
            }
            if (this.gf) {
                jzVar.m1047a(12, this.gf);
            }
            super.m2113a(jzVar);
        }

        public /* synthetic */ ke m2530b(jy jyVar) throws IOException {
            return m2532l(jyVar);
        }

        public int m2531c() {
            int i;
            int i2 = 0;
            int c = super.m2115c() + jz.m1039g(1, this.type);
            if (!this.fY.equals("")) {
                c += jz.m1040g(2, this.fY);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                i = c;
                for (ke keVar : this.fZ) {
                    if (keVar != null) {
                        i += jz.m1032b(3, keVar);
                    }
                }
                c = i;
            }
            if (this.ga != null && this.ga.length > 0) {
                i = c;
                for (ke keVar2 : this.ga) {
                    if (keVar2 != null) {
                        i += jz.m1032b(4, keVar2);
                    }
                }
                c = i;
            }
            if (this.gb != null && this.gb.length > 0) {
                i = c;
                for (ke keVar22 : this.gb) {
                    if (keVar22 != null) {
                        i += jz.m1032b(5, keVar22);
                    }
                }
                c = i;
            }
            if (!this.gc.equals("")) {
                c += jz.m1040g(6, this.gc);
            }
            if (!this.gd.equals("")) {
                c += jz.m1040g(7, this.gd);
            }
            if (this.ge != 0) {
                c += jz.m1036d(8, this.ge);
            }
            if (this.gi) {
                c += jz.m1033b(9, this.gi);
            }
            if (this.gh != null && this.gh.length > 0) {
                int i3 = 0;
                for (int cC : this.gh) {
                    i3 += jz.cC(cC);
                }
                c = (c + i3) + (this.gh.length * 1);
            }
            if (this.gg != null && this.gg.length > 0) {
                while (i2 < this.gg.length) {
                    ke keVar3 = this.gg[i2];
                    if (keVar3 != null) {
                        c += jz.m1032b(11, keVar3);
                    }
                    i2++;
                }
            }
            if (this.gf) {
                c += jz.m1033b(12, this.gf);
            }
            this.DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0945a)) {
                return false;
            }
            C0945a c0945a = (C0945a) o;
            if (this.type != c0945a.type) {
                return false;
            }
            if (this.fY == null) {
                if (c0945a.fY != null) {
                    return false;
                }
            } else if (!this.fY.equals(c0945a.fY)) {
                return false;
            }
            if (!kc.equals(this.fZ, c0945a.fZ) || !kc.equals(this.ga, c0945a.ga) || !kc.equals(this.gb, c0945a.gb)) {
                return false;
            }
            if (this.gc == null) {
                if (c0945a.gc != null) {
                    return false;
                }
            } else if (!this.gc.equals(c0945a.gc)) {
                return false;
            }
            if (this.gd == null) {
                if (c0945a.gd != null) {
                    return false;
                }
            } else if (!this.gd.equals(c0945a.gd)) {
                return false;
            }
            if (this.ge != c0945a.ge || this.gf != c0945a.gf || !kc.equals(this.gg, c0945a.gg) || !kc.equals(this.gh, c0945a.gh) || this.gi != c0945a.gi) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return c0945a.aae == null || c0945a.aae.isEmpty();
            } else {
                return this.aae.equals(c0945a.aae);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.gf ? 1231 : 1237) + (((((this.gd == null ? 0 : this.gd.hashCode()) + (((this.gc == null ? 0 : this.gc.hashCode()) + (((((((((this.fY == null ? 0 : this.fY.hashCode()) + ((this.type + 527) * 31)) * 31) + kc.hashCode(this.fZ)) * 31) + kc.hashCode(this.ga)) * 31) + kc.hashCode(this.gb)) * 31)) * 31)) * 31) + ((int) (this.ge ^ (this.ge >>> 32)))) * 31)) * 31) + kc.hashCode(this.gg)) * 31) + kc.hashCode(this.gh)) * 31;
            if (!this.gi) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.aae == null || this.aae.isEmpty())) {
                i2 = this.aae.hashCode();
            }
            return hashCode + i2;
        }

        public C0945a m2532l(jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.ky();
                int c;
                Object obj;
                int i;
                switch (ky) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                        ky = jyVar.kB();
                        switch (ky) {
                            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                            case DetectedActivity.ON_FOOT /*2*/:
                            case DetectedActivity.STILL /*3*/:
                            case DetectedActivity.UNKNOWN /*4*/:
                            case DetectedActivity.TILTING /*5*/:
                            case Participant.STATUS_UNRESPONSIVE /*6*/:
                            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                                this.type = ky;
                                break;
                            default:
                                continue;
                        }
                    case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                        this.fY = jyVar.readString();
                        continue;
                    case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                        c = kh.m1075c(jyVar, 26);
                        ky = this.fZ == null ? 0 : this.fZ.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.fZ, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.fZ = obj;
                        continue;
                    case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                        c = kh.m1075c(jyVar, 34);
                        ky = this.ga == null ? 0 : this.ga.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.ga, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.ga = obj;
                        continue;
                    case C0519R.styleable.Theme_dialogTheme /*42*/:
                        c = kh.m1075c(jyVar, 42);
                        ky = this.gb == null ? 0 : this.gb.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.gb, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.gb = obj;
                        continue;
                    case C0519R.styleable.Theme_buttonBarStyle /*50*/:
                        this.gc = jyVar.readString();
                        continue;
                    case C0519R.styleable.Theme_toolbarStyle /*58*/:
                        this.gd = jyVar.readString();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        this.ge = jyVar.kA();
                        continue;
                    case C0519R.styleable.Theme_listPreferredItemPaddingRight /*72*/:
                        this.gi = jyVar.kC();
                        continue;
                    case C0519R.styleable.Theme_listChoiceBackgroundIndicator /*80*/:
                        int c2 = kh.m1075c(jyVar, 80);
                        Object obj2 = new int[c2];
                        i = 0;
                        c = 0;
                        while (i < c2) {
                            if (i != 0) {
                                jyVar.ky();
                            }
                            int kB = jyVar.kB();
                            switch (kB) {
                                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                                case DetectedActivity.ON_FOOT /*2*/:
                                case DetectedActivity.STILL /*3*/:
                                case DetectedActivity.UNKNOWN /*4*/:
                                case DetectedActivity.TILTING /*5*/:
                                case Participant.STATUS_UNRESPONSIVE /*6*/:
                                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                                    ky = c + 1;
                                    obj2[c] = kB;
                                    break;
                                default:
                                    ky = c;
                                    break;
                            }
                            i++;
                            c = ky;
                        }
                        if (c != 0) {
                            ky = this.gh == null ? 0 : this.gh.length;
                            if (ky != 0 || c != obj2.length) {
                                Object obj3 = new int[(ky + c)];
                                if (ky != 0) {
                                    System.arraycopy(this.gh, 0, obj3, 0, ky);
                                }
                                System.arraycopy(obj2, 0, obj3, ky, c);
                                this.gh = obj3;
                                break;
                            }
                            this.gh = obj2;
                            break;
                        }
                        continue;
                    case C0519R.styleable.Theme_colorPrimaryDark /*82*/:
                        i = jyVar.cw(jyVar.kE());
                        c = jyVar.getPosition();
                        ky = 0;
                        while (jyVar.kJ() > 0) {
                            switch (jyVar.kB()) {
                                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                                case DetectedActivity.ON_FOOT /*2*/:
                                case DetectedActivity.STILL /*3*/:
                                case DetectedActivity.UNKNOWN /*4*/:
                                case DetectedActivity.TILTING /*5*/:
                                case Participant.STATUS_UNRESPONSIVE /*6*/:
                                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                                    ky++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (ky != 0) {
                            jyVar.cy(c);
                            c = this.gh == null ? 0 : this.gh.length;
                            Object obj4 = new int[(ky + c)];
                            if (c != 0) {
                                System.arraycopy(this.gh, 0, obj4, 0, c);
                            }
                            while (jyVar.kJ() > 0) {
                                int kB2 = jyVar.kB();
                                switch (kB2) {
                                    case SpinnerCompat.MODE_DROPDOWN /*1*/:
                                    case DetectedActivity.ON_FOOT /*2*/:
                                    case DetectedActivity.STILL /*3*/:
                                    case DetectedActivity.UNKNOWN /*4*/:
                                    case DetectedActivity.TILTING /*5*/:
                                    case Participant.STATUS_UNRESPONSIVE /*6*/:
                                    case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                                    case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                                    case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                                    case C0519R.styleable.Toolbar_titleMargins /*11*/:
                                    case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                                    case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                                    case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                                    case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                                    case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                                    case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                                        ky = c + 1;
                                        obj4[c] = kB2;
                                        c = ky;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.gh = obj4;
                        }
                        jyVar.cx(i);
                        continue;
                    case C0519R.styleable.Theme_alertDialogButtonGroupStyle /*90*/:
                        c = kh.m1075c(jyVar, 90);
                        ky = this.gg == null ? 0 : this.gg.length;
                        obj = new C0945a[(c + ky)];
                        if (ky != 0) {
                            System.arraycopy(this.gg, 0, obj, 0, ky);
                        }
                        while (ky < obj.length - 1) {
                            obj[ky] = new C0945a();
                            jyVar.m1024a(obj[ky]);
                            jyVar.ky();
                            ky++;
                        }
                        obj[ky] = new C0945a();
                        jyVar.m1024a(obj[ky]);
                        this.gg = obj;
                        continue;
                    case C0519R.styleable.Theme_buttonBarNeutralButtonStyle /*96*/:
                        this.gf = jyVar.kC();
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

        public C0945a m2533s() {
            this.type = 1;
            this.fY = "";
            this.fZ = C0945a.m2528r();
            this.ga = C0945a.m2528r();
            this.gb = C0945a.m2528r();
            this.gc = "";
            this.gd = "";
            this.ge = 0;
            this.gf = false;
            this.gg = C0945a.m2528r();
            this.gh = kh.aaj;
            this.gi = false;
            this.aae = null;
            this.DY = -1;
            return this;
        }
    }
}
