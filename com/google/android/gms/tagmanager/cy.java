package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cy extends cx {
    private static cy Xp;
    private static final Object ri;
    private Context Xf;
    private at Xg;
    private volatile ar Xh;
    private int Xi;
    private boolean Xj;
    private boolean Xk;
    private boolean Xl;
    private au Xm;
    private bn Xn;
    private boolean Xo;
    private boolean connected;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cy.2 */
    class C04522 implements Callback {
        final /* synthetic */ cy Xq;

        C04522(cy cyVar) {
            this.Xq = cyVar;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && cy.ri.equals(msg.obj)) {
                this.Xq.bp();
                if (this.Xq.Xi > 0 && !this.Xq.Xo) {
                    this.Xq.handler.sendMessageDelayed(this.Xq.handler.obtainMessage(1, cy.ri), (long) this.Xq.Xi);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy.3 */
    class C04533 implements Runnable {
        final /* synthetic */ cy Xq;

        C04533(cy cyVar) {
            this.Xq = cyVar;
        }

        public void run() {
            this.Xq.Xg.bp();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy.1 */
    class C08491 implements au {
        final /* synthetic */ cy Xq;

        C08491(cy cyVar) {
            this.Xq = cyVar;
        }

        public void m2303p(boolean z) {
            this.Xq.m2310a(z, this.Xq.connected);
        }
    }

    static {
        ri = new Object();
    }

    private cy() {
        this.Xi = 1800000;
        this.Xj = true;
        this.Xk = false;
        this.connected = true;
        this.Xl = true;
        this.Xm = new C08491(this);
        this.Xo = false;
    }

    private void bC() {
        this.Xn = new bn(this);
        this.Xn.m1282o(this.Xf);
    }

    private void bD() {
        this.handler = new Handler(this.Xf.getMainLooper(), new C04522(this));
        if (this.Xi > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, ri), (long) this.Xi);
        }
    }

    public static cy kh() {
        if (Xp == null) {
            Xp = new cy();
        }
        return Xp;
    }

    synchronized void m2309a(Context context, ar arVar) {
        if (this.Xf == null) {
            this.Xf = context.getApplicationContext();
            if (this.Xh == null) {
                this.Xh = arVar;
            }
        }
    }

    synchronized void m2310a(boolean z, boolean z2) {
        if (!(this.Xo == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.Xi > 0) {
                    this.handler.removeMessages(1, ri);
                }
            }
            if (!z && z2 && this.Xi > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, ri), (long) this.Xi);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m1272v(append.append(str).toString());
            this.Xo = z;
            this.connected = z2;
        }
    }

    synchronized void bF() {
        if (!this.Xo && this.connected && this.Xi > 0) {
            this.handler.removeMessages(1, ri);
            this.handler.sendMessage(this.handler.obtainMessage(1, ri));
        }
    }

    public synchronized void bp() {
        if (this.Xk) {
            this.Xh.m1255a(new C04533(this));
        } else {
            bh.m1272v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.Xj = true;
        }
    }

    synchronized at ki() {
        if (this.Xg == null) {
            if (this.Xf == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.Xg = new cb(this.Xm, this.Xf);
        }
        if (this.handler == null) {
            bD();
        }
        this.Xk = true;
        if (this.Xj) {
            bp();
            this.Xj = false;
        }
        if (this.Xn == null && this.Xl) {
            bC();
        }
        return this.Xg;
    }

    synchronized void m2311q(boolean z) {
        m2310a(this.Xo, z);
    }
}
