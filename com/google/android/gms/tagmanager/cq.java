package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0296c.C0938f;
import com.google.android.gms.internal.jd.C0991a;
import com.google.android.gms.internal.kd;
import com.google.android.gms.tagmanager.C1016o.C0865f;
import com.google.android.gms.tagmanager.cr.C0444c;
import com.google.android.gms.tagmanager.cr.C0448g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cq implements C0865f {
    private final String TM;
    private bg<C0991a> Wi;
    private final ExecutorService Wp;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cq.1 */
    class C04391 implements Runnable {
        final /* synthetic */ cq Wq;

        C04391(cq cqVar) {
            this.Wq = cqVar;
        }

        public void run() {
            this.Wq.jC();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.2 */
    class C04402 implements Runnable {
        final /* synthetic */ cq Wq;
        final /* synthetic */ C0991a Wr;

        C04402(cq cqVar, C0991a c0991a) {
            this.Wq = cqVar;
            this.Wr = c0991a;
        }

        public void run() {
            this.Wq.m2856c(this.Wr);
        }
    }

    cq(Context context, String str) {
        this.mContext = context;
        this.TM = str;
        this.Wp = Executors.newSingleThreadExecutor();
    }

    private C0444c m2852a(ByteArrayOutputStream byteArrayOutputStream) {
        C0444c c0444c = null;
        try {
            c0444c = ba.br(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m1269s("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
        } catch (JSONException e2) {
            bh.m1273w("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c0444c;
    }

    private C0444c m2853k(byte[] bArr) {
        C0444c c0444c = null;
        try {
            c0444c = cr.m1311b(C0938f.m2491a(bArr));
        } catch (kd e) {
            bh.m1273w("Resource doesn't contain a binary container");
        } catch (C0448g e2) {
            bh.m1273w("Resource doesn't contain a binary container");
        }
        return c0444c;
    }

    public void m2854a(bg<C0991a> bgVar) {
        this.Wi = bgVar;
    }

    public void m2855b(C0991a c0991a) {
        this.Wp.execute(new C04402(this, c0991a));
    }

    public C0444c bP(int i) {
        bh.m1272v("Atttempting to load container from resource ID " + i);
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            cr.m1312b(openRawResource, byteArrayOutputStream);
            C0444c a = m2852a(byteArrayOutputStream);
            return a != null ? a : m2853k(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            bh.m1273w("Error reading default container resource with ID " + i);
            return null;
        } catch (NotFoundException e2) {
            bh.m1273w("No default container resource found.");
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m2856c(com.google.android.gms.internal.jd.C0991a r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.jD();
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0016 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0016 }
        r3 = com.google.android.gms.internal.ke.m1067d(r5);	 Catch:{ IOException -> 0x0024 }
        r2.write(r3);	 Catch:{ IOException -> 0x0024 }
        r0 = 1;
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = move-exception;
        r1 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.bh.m1270t(r1);
        goto L_0x0015;
    L_0x001d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1273w(r1);
        goto L_0x0015;
    L_0x0024:
        r3 = move-exception;
        r3 = "Error writing resource to disk. Removing resource from disk.";
        com.google.android.gms.tagmanager.bh.m1273w(r3);	 Catch:{ all -> 0x0038 }
        r1.delete();	 Catch:{ all -> 0x0038 }
        r2.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1273w(r1);
        goto L_0x0015;
    L_0x0038:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x003d }
    L_0x003c:
        throw r0;
    L_0x003d:
        r1 = move-exception;
        r1 = "error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.bh.m1273w(r1);
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.c(com.google.android.gms.internal.jd$a):boolean");
    }

    public void iN() {
        this.Wp.execute(new C04391(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void jC() {
        /*
        r3 = this;
        r0 = r3.Wi;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.IllegalStateException;
        r1 = "callback must be set before execute";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        r0 = r3.Wi;
        r0.iM();
        r0 = "Start loading resource from disk ...";
        com.google.android.gms.tagmanager.bh.m1272v(r0);
        r0 = com.google.android.gms.tagmanager.ce.ju();
        r0 = r0.jv();
        r1 = com.google.android.gms.tagmanager.ce.C0436a.CONTAINER;
        if (r0 == r1) goto L_0x002e;
    L_0x0022:
        r0 = com.google.android.gms.tagmanager.ce.ju();
        r0 = r0.jv();
        r1 = com.google.android.gms.tagmanager.ce.C0436a.CONTAINER_DEBUG;
        if (r0 != r1) goto L_0x0046;
    L_0x002e:
        r0 = r3.TM;
        r1 = com.google.android.gms.tagmanager.ce.ju();
        r1 = r1.getContainerId();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = r3.Wi;
        r1 = com.google.android.gms.tagmanager.bg.C0433a.NOT_AVAILABLE;
        r0.m1265a(r1);
    L_0x0045:
        return;
    L_0x0046:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = r3.jD();	 Catch:{ FileNotFoundException -> 0x006d }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x006d }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0082 }
        r0.<init>();	 Catch:{ IOException -> 0x0082 }
        com.google.android.gms.tagmanager.cr.m1312b(r1, r0);	 Catch:{ IOException -> 0x0082 }
        r2 = r3.Wi;	 Catch:{ IOException -> 0x0082 }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x0082 }
        r0 = com.google.android.gms.internal.jd.C0991a.m2776l(r0);	 Catch:{ IOException -> 0x0082 }
        r2.m1266i(r0);	 Catch:{ IOException -> 0x0082 }
        r1.close();	 Catch:{ IOException -> 0x007b }
    L_0x0067:
        r0 = "Load resource from disk finished.";
        com.google.android.gms.tagmanager.bh.m1272v(r0);
        goto L_0x0045;
    L_0x006d:
        r0 = move-exception;
        r0 = "resource not on disk";
        com.google.android.gms.tagmanager.bh.m1269s(r0);
        r0 = r3.Wi;
        r1 = com.google.android.gms.tagmanager.bg.C0433a.NOT_AVAILABLE;
        r0.m1265a(r1);
        goto L_0x0045;
    L_0x007b:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1273w(r0);
        goto L_0x0067;
    L_0x0082:
        r0 = move-exception;
        r0 = "error reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1273w(r0);	 Catch:{ all -> 0x009a }
        r0 = r3.Wi;	 Catch:{ all -> 0x009a }
        r2 = com.google.android.gms.tagmanager.bg.C0433a.IO_ERROR;	 Catch:{ all -> 0x009a }
        r0.m1265a(r2);	 Catch:{ all -> 0x009a }
        r1.close();	 Catch:{ IOException -> 0x0093 }
        goto L_0x0067;
    L_0x0093:
        r0 = move-exception;
        r0 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1273w(r0);
        goto L_0x0067;
    L_0x009a:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x009f }
    L_0x009e:
        throw r0;
    L_0x009f:
        r1 = move-exception;
        r1 = "error closing stream for reading resource from disk";
        com.google.android.gms.tagmanager.bh.m1273w(r1);
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cq.jC():void");
    }

    File jD() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.TM);
    }

    public synchronized void release() {
        this.Wp.shutdown();
    }
}
