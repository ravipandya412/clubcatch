package com.google.android.gms.drive.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.jy;
import com.google.android.gms.internal.jz;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.ke;
import com.google.android.gms.internal.kh;
import com.pkr.clubcatch.C0519R;
import java.io.IOException;

/* renamed from: com.google.android.gms.drive.internal.y */
public final class C0611y extends ke {
    public static final C0611y[] DU;
    public String DV;
    public long DW;
    public long DX;
    private int DY;
    public int versionCode;

    static {
        DU = new C0611y[0];
    }

    public C0611y() {
        this.versionCode = 1;
        this.DV = "";
        this.DW = -1;
        this.DX = -1;
        this.DY = -1;
    }

    public static C0611y m1584g(byte[] bArr) throws kd {
        return (C0611y) ke.m1064a(new C0611y(), bArr);
    }

    public void m1585a(jz jzVar) throws IOException {
        jzVar.m1055f(1, this.versionCode);
        jzVar.m1050b(2, this.DV);
        jzVar.m1052c(3, this.DW);
        jzVar.m1052c(4, this.DX);
    }

    public /* synthetic */ ke m1586b(jy jyVar) throws IOException {
        return m1588m(jyVar);
    }

    public int m1587c() {
        int g = (((0 + jz.m1039g(1, this.versionCode)) + jz.m1040g(2, this.DV)) + jz.m1038e(3, this.DW)) + jz.m1038e(4, this.DX);
        this.DY = g;
        return g;
    }

    public int eW() {
        if (this.DY < 0) {
            m1587c();
        }
        return this.DY;
    }

    public C0611y m1588m(jy jyVar) throws IOException {
        while (true) {
            int ky = jyVar.ky();
            switch (ky) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    this.versionCode = jyVar.kB();
                    continue;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    this.DV = jyVar.readString();
                    continue;
                case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                    this.DW = jyVar.kD();
                    continue;
                case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                    this.DX = jyVar.kD();
                    continue;
                default:
                    if (!kh.m1074b(jyVar, ky)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
