package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0388r;
import com.google.android.gms.maps.model.internal.C0404g;
import com.google.android.gms.maps.model.internal.C0404g.C0808a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR;
    private float PP;
    private boolean PQ;
    private C0404g Qt;
    private TileProvider Qu;
    private boolean Qv;
    private final int wj;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C07921 implements TileProvider {
        private final C0404g Qw;
        final /* synthetic */ TileOverlayOptions Qx;

        C07921(TileOverlayOptions tileOverlayOptions) {
            this.Qx = tileOverlayOptions;
            this.Qw = this.Qx.Qt;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.Qw.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C10052 extends C0808a {
        final /* synthetic */ TileOverlayOptions Qx;
        final /* synthetic */ TileProvider Qy;

        C10052(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.Qx = tileOverlayOptions;
            this.Qy = tileProvider;
        }

        public Tile getTile(int x, int y, int zoom) {
            return this.Qy.getTile(x, y, zoom);
        }
    }

    static {
        CREATOR = new TileOverlayOptionsCreator();
    }

    public TileOverlayOptions() {
        this.PQ = true;
        this.Qv = true;
        this.wj = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.PQ = true;
        this.Qv = true;
        this.wj = versionCode;
        this.Qt = C0808a.au(delegate);
        this.Qu = this.Qt == null ? null : new C07921(this);
        this.PQ = visible;
        this.PP = zIndex;
        this.Qv = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.Qv = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.Qv;
    }

    public TileProvider getTileProvider() {
        return this.Qu;
    }

    int getVersionCode() {
        return this.wj;
    }

    public float getZIndex() {
        return this.PP;
    }

    IBinder hh() {
        return this.Qt.asBinder();
    }

    public boolean isVisible() {
        return this.PQ;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.Qu = tileProvider;
        this.Qt = this.Qu == null ? null : new C10052(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0388r.hc()) {
            C0405j.m1176a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m1155a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.PP = zIndex;
        return this;
    }
}
