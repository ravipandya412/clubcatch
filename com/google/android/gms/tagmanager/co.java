package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0296c.C0942j;
import com.google.android.gms.tagmanager.bg.C0433a;
import com.google.android.gms.tagmanager.ce.C0436a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class co implements Runnable {
    private final String TM;
    private volatile String Ui;
    private final bm Wg;
    private final String Wh;
    private bg<C0942j> Wi;
    private volatile C0464r Wj;
    private volatile String Wk;
    private final Context mContext;

    co(Context context, String str, bm bmVar, C0464r c0464r) {
        this.mContext = context;
        this.Wg = bmVar;
        this.TM = str;
        this.Wj = c0464r;
        this.Wh = "/r?id=" + str;
        this.Ui = this.Wh;
        this.Wk = null;
    }

    public co(Context context, String str, C0464r c0464r) {
        this(context, str, new bm(), c0464r);
    }

    private boolean jx() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m1272v("...no network connectivity");
        return false;
    }

    private void jy() {
        if (jx()) {
            bh.m1272v("Start loading resource from network ...");
            String jz = jz();
            bl ji = this.Wg.ji();
            try {
                InputStream bo = ji.bo(jz);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cr.m1312b(bo, byteArrayOutputStream);
                    C0942j b = C0942j.m2514b(byteArrayOutputStream.toByteArray());
                    bh.m1272v("Successfully loaded supplemented resource: " + b);
                    if (b.fV == null && b.fU.length == 0) {
                        bh.m1272v("No change for container: " + this.TM);
                    }
                    this.Wi.m1266i(b);
                    bh.m1272v("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m1267b("Error when parsing downloaded resources from url: " + jz + " " + e.getMessage(), e);
                    this.Wi.m1265a(C0433a.SERVER_ERROR);
                    ji.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m1273w("No data is retrieved from the given url: " + jz + ". Make sure container_id: " + this.TM + " is correct.");
                this.Wi.m1265a(C0433a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m1267b("Error when loading resources from url: " + jz + " " + e3.getMessage(), e3);
                this.Wi.m1265a(C0433a.IO_ERROR);
            } finally {
                ji.close();
            }
        } else {
            this.Wi.m1265a(C0433a.NOT_AVAILABLE);
        }
    }

    void m1294a(bg<C0942j> bgVar) {
        this.Wi = bgVar;
    }

    void bf(String str) {
        if (str == null) {
            this.Ui = this.Wh;
            return;
        }
        bh.m1269s("Setting CTFE URL path: " + str);
        this.Ui = str;
    }

    void bu(String str) {
        bh.m1269s("Setting previous container version: " + str);
        this.Wk = str;
    }

    String jz() {
        String str = this.Wj.iO() + this.Ui + "&v=a59512756";
        if (!(this.Wk == null || this.Wk.trim().equals(""))) {
            str = str + "&pv=" + this.Wk;
        }
        return ce.ju().jv().equals(C0436a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.Wi == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.Wi.iM();
        jy();
    }
}
