package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C0368a;
import com.google.android.gms.location.C0368a.C0741a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class hh {
    private final hl<hg> Lk;
    private ContentProviderClient Ll;
    private boolean Lm;
    private HashMap<LocationListener, C0975b> Ln;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.hh.a */
    private static class C0347a extends Handler {
        private final LocationListener Lo;

        public C0347a(LocationListener locationListener) {
            this.Lo = locationListener;
        }

        public C0347a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.Lo = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    this.Lo.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hh.b */
    private static class C0975b extends C0741a {
        private Handler Lp;

        C0975b(LocationListener locationListener, Looper looper) {
            this.Lp = looper == null ? new C0347a(locationListener) : new C0347a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.Lp == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.Lp.sendMessage(obtain);
        }

        public void release() {
            this.Lp = null;
        }
    }

    public hh(Context context, hl<hg> hlVar) {
        this.Ll = null;
        this.Lm = false;
        this.Ln = new HashMap();
        this.mContext = context;
        this.Lk = hlVar;
    }

    public Location getLastLocation() {
        this.Lk.bm();
        try {
            return ((hg) this.Lk.eb()).aF(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void gl() {
        if (this.Lm) {
            setMockMode(false);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.Ln) {
                for (C0368a c0368a : this.Ln.values()) {
                    if (c0368a != null) {
                        ((hg) this.Lk.eb()).m969a(c0368a);
                    }
                }
                this.Ln.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).m958a(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Lk.bm();
        er.m723b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.Ln) {
            C0368a c0368a = (C0975b) this.Ln.remove(listener);
            if (this.Ll != null && this.Ln.isEmpty()) {
                this.Ll.release();
                this.Ll = null;
            }
            if (c0368a != null) {
                c0368a.release();
                try {
                    ((hg) this.Lk.eb()).m969a(c0368a);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).m966a(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.Lk.bm();
        if (looper == null) {
            er.m723b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.Ln) {
            C0368a c0975b;
            C0975b c0975b2 = (C0975b) this.Ln.get(listener);
            if (c0975b2 == null) {
                c0975b = new C0975b(listener, looper);
            } else {
                Object obj = c0975b2;
            }
            this.Ln.put(listener, c0975b);
            try {
                ((hg) this.Lk.eb()).m968a(request, c0975b, this.mContext.getPackageName());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.Lk.bm();
        try {
            ((hg) this.Lk.eb()).setMockMode(isMockMode);
            this.Lm = isMockMode;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
