package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C0420b;
import com.google.android.gms.tagmanager.ce.C0436a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager XB;
    private final DataLayer TN;
    private final C0464r Wj;
    private final ConcurrentMap<C1015n, Boolean> XA;
    private final C0425a Xz;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    static /* synthetic */ class C04243 {
        static final /* synthetic */ int[] XD;

        static {
            XD = new int[C0436a.values().length];
            try {
                XD[C0436a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                XD[C0436a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                XD[C0436a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.a */
    interface C0425a {
        C1016o m1237a(Context context, TagManager tagManager, Looper looper, String str, int i, C0464r c0464r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C08361 implements C0420b {
        final /* synthetic */ TagManager XC;

        C08361(TagManager tagManager) {
            this.XC = tagManager;
        }

        public void m2236v(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.XC.bE(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C08372 implements C0425a {
        C08372() {
        }

        public C1016o m2237a(Context context, TagManager tagManager, Looper looper, String str, int i, C0464r c0464r) {
            return new C1016o(context, tagManager, looper, str, i, c0464r);
        }
    }

    TagManager(Context context, C0425a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.Xz = containerHolderLoaderProvider;
        this.XA = new ConcurrentHashMap();
        this.TN = dataLayer;
        this.TN.m1231a(new C08361(this));
        this.TN.m1231a(new C0850d(this.mContext));
        this.Wj = new C0464r();
    }

    private void bE(String str) {
        for (C1015n ba : this.XA.keySet()) {
            ba.ba(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (XB == null) {
                if (context == null) {
                    bh.m1270t("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                XB = new TagManager(context, new C08372(), new DataLayer(new C0869v(context)));
            }
            tagManager = XB;
        }
        return tagManager;
    }

    void m1239a(C1015n c1015n) {
        this.XA.put(c1015n, Boolean.valueOf(true));
    }

    boolean m1240b(C1015n c1015n) {
        return this.XA.remove(c1015n) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m1241f(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.ce.ju();	 Catch:{ all -> 0x0049 }
        r0 = r1.m1289f(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C04243.XD;	 Catch:{ all -> 0x0049 }
        r3 = r1.jv();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.XA;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1015n) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.bc(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.XA;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C1015n) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.jw();	 Catch:{ all -> 0x0049 }
        r0.bc(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.iF();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.bc(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.f(android.net.Uri):boolean");
    }

    public DataLayer getDataLayer() {
        return this.TN;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iI();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iK();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Wj);
        a.iJ();
        return a;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.Xz.m1237a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Wj);
        a.iJ();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
