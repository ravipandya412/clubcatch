package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1015n implements ContainerHolder {
    private Container TU;
    private Container TV;
    private C0462b TW;
    private C0461a TX;
    private TagManager TY;
    private Status vl;
    private boolean zk;
    private final Looper zs;

    /* renamed from: com.google.android.gms.tagmanager.n.a */
    public interface C0461a {
        void bc(String str);

        String iF();

        void iH();
    }

    /* renamed from: com.google.android.gms.tagmanager.n.b */
    private class C0462b extends Handler {
        private final ContainerAvailableListener TZ;
        final /* synthetic */ C1015n Ua;

        public C0462b(C1015n c1015n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.Ua = c1015n;
            super(looper);
            this.TZ = containerAvailableListener;
        }

        public void bd(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void be(String str) {
            this.TZ.onContainerAvailable(this.Ua, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    be((String) msg.obj);
                default:
                    bh.m1270t("Don't know how to handle this message.");
            }
        }
    }

    public C1015n(Status status) {
        this.vl = status;
        this.zs = null;
    }

    public C1015n(TagManager tagManager, Looper looper, Container container, C0461a c0461a) {
        this.TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zs = looper;
        this.TU = container;
        this.TX = c0461a;
        this.vl = Status.zQ;
        tagManager.m1239a(this);
    }

    private void iG() {
        if (this.TW != null) {
            this.TW.bd(this.TV.iD());
        }
    }

    public synchronized void m2868a(Container container) {
        if (!this.zk) {
            if (container == null) {
                bh.m1270t("Unexpected null container.");
            } else {
                this.TV = container;
                iG();
            }
        }
    }

    public synchronized void ba(String str) {
        if (!this.zk) {
            this.TU.ba(str);
        }
    }

    void bc(String str) {
        if (this.zk) {
            bh.m1270t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.TX.bc(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zk) {
                bh.m1270t("ContainerHolder is released.");
            } else {
                if (this.TV != null) {
                    this.TU = this.TV;
                    this.TV = null;
                }
                container = this.TU;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.zk) {
            return this.TU.getContainerId();
        }
        bh.m1270t("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.vl;
    }

    String iF() {
        if (!this.zk) {
            return this.TX.iF();
        }
        bh.m1270t("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.zk) {
            bh.m1270t("Refreshing a released ContainerHolder.");
        } else {
            this.TX.iH();
        }
    }

    public synchronized void release() {
        if (this.zk) {
            bh.m1270t("Releasing a released ContainerHolder.");
        } else {
            this.zk = true;
            this.TY.m1240b(this);
            this.TU.release();
            this.TU = null;
            this.TV = null;
            this.TX = null;
            this.TW = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.zk) {
            bh.m1270t("ContainerHolder is released.");
        } else if (listener == null) {
            this.TW = null;
        } else {
            this.TW = new C0462b(this, listener, this.zs);
            if (this.TV != null) {
                iG();
            }
        }
    }
}
