package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eh.C0330f;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class ej implements Callback {
    private static final Object BQ;
    private static ej BR;
    private final HashMap<String, C0334a> BS;
    private final Handler mHandler;
    private final Context qe;

    /* renamed from: com.google.android.gms.internal.ej.a */
    final class C0334a {
        private final String BT;
        private final C0333a BU;
        private final HashSet<C0330f> BV;
        private boolean BW;
        private IBinder BX;
        private ComponentName BY;
        final /* synthetic */ ej BZ;
        private int mState;

        /* renamed from: com.google.android.gms.internal.ej.a.a */
        public class C0333a implements ServiceConnection {
            final /* synthetic */ C0334a Ca;

            public C0333a(C0334a c0334a) {
                this.Ca = c0334a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.Ca.BZ.BS) {
                    this.Ca.BX = binder;
                    this.Ca.BY = component;
                    Iterator it = this.Ca.BV.iterator();
                    while (it.hasNext()) {
                        ((C0330f) it.next()).onServiceConnected(component, binder);
                    }
                    this.Ca.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.Ca.BZ.BS) {
                    this.Ca.BX = null;
                    this.Ca.BY = component;
                    Iterator it = this.Ca.BV.iterator();
                    while (it.hasNext()) {
                        ((C0330f) it.next()).onServiceDisconnected(component);
                    }
                    this.Ca.mState = 2;
                }
            }
        }

        public C0334a(ej ejVar, String str) {
            this.BZ = ejVar;
            this.BT = str;
            this.BU = new C0333a(this);
            this.BV = new HashSet();
            this.mState = 0;
        }

        public void m677a(C0330f c0330f) {
            this.BV.add(c0330f);
        }

        public void m678b(C0330f c0330f) {
            this.BV.remove(c0330f);
        }

        public boolean m679c(C0330f c0330f) {
            return this.BV.contains(c0330f);
        }

        public C0333a ee() {
            return this.BU;
        }

        public String ef() {
            return this.BT;
        }

        public boolean eg() {
            return this.BV.isEmpty();
        }

        public IBinder getBinder() {
            return this.BX;
        }

        public ComponentName getComponentName() {
            return this.BY;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.BW;
        }

        public void m680w(boolean z) {
            this.BW = z;
        }
    }

    static {
        BQ = new Object();
    }

    private ej(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.BS = new HashMap();
        this.qe = context.getApplicationContext();
    }

    public static ej m682y(Context context) {
        synchronized (BQ) {
            if (BR == null) {
                BR = new ej(context.getApplicationContext());
            }
        }
        return BR;
    }

    public boolean m683a(String str, C0330f c0330f) {
        boolean isBound;
        synchronized (this.BS) {
            C0334a c0334a = (C0334a) this.BS.get(str);
            if (c0334a != null) {
                this.mHandler.removeMessages(0, c0334a);
                if (!c0334a.m679c(c0330f)) {
                    c0334a.m677a((C0330f) c0330f);
                    switch (c0334a.getState()) {
                        case SpinnerCompat.MODE_DROPDOWN /*1*/:
                            c0330f.onServiceConnected(c0334a.getComponentName(), c0334a.getBinder());
                            break;
                        case DetectedActivity.ON_FOOT /*2*/:
                            c0334a.m680w(this.qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0334a.ee(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0334a = new C0334a(this, str);
            c0334a.m677a((C0330f) c0330f);
            c0334a.m680w(this.qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0334a.ee(), 129));
            this.BS.put(str, c0334a);
            isBound = c0334a.isBound();
        }
        return isBound;
    }

    public void m684b(String str, C0330f c0330f) {
        synchronized (this.BS) {
            C0334a c0334a = (C0334a) this.BS.get(str);
            if (c0334a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0334a.m679c(c0330f)) {
                c0334a.m678b(c0330f);
                if (c0334a.eg()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0334a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                C0334a c0334a = (C0334a) msg.obj;
                synchronized (this.BS) {
                    if (c0334a.eg()) {
                        this.qe.unbindService(c0334a.ee());
                        this.BS.remove(c0334a.ef());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
