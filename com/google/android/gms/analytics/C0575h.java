package com.google.android.gms.analytics;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0575h implements C0165m {
    private static final Object qI;
    private static C0575h qW;
    private final Context mContext;
    private String qX;
    private boolean qY;
    private final Object qZ;

    /* renamed from: com.google.android.gms.analytics.h.1 */
    class C01601 extends Thread {
        final /* synthetic */ C0575h ra;

        C01601(C0575h c0575h, String str) {
            this.ra = c0575h;
            super(str);
        }

        public void run() {
            synchronized (this.ra.qZ) {
                this.ra.qX = this.ra.by();
                this.ra.qY = true;
                this.ra.qZ.notifyAll();
            }
        }
    }

    static {
        qI = new Object();
    }

    protected C0575h(Context context) {
        this.qY = false;
        this.qZ = new Object();
        this.mContext = context;
        bx();
    }

    public static C0575h bu() {
        C0575h c0575h;
        synchronized (qI) {
            c0575h = qW;
        }
        return c0575h;
    }

    private String bv() {
        if (!this.qY) {
            synchronized (this.qZ) {
                if (!this.qY) {
                    aa.m50v("Waiting for clientId to load");
                    do {
                        try {
                            this.qZ.wait();
                        } catch (InterruptedException e) {
                            aa.m48t("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.qY);
                }
            }
        }
        aa.m50v("Loaded clientId");
        return this.qX;
    }

    private void bx() {
        new C01601(this, "client_id_fetcher").start();
    }

    public static void m1448n(Context context) {
        synchronized (qI) {
            if (qW == null) {
                qW = new C0575h(context);
            }
        }
    }

    private boolean m1449y(String str) {
        try {
            aa.m50v("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m48t("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m48t("Error writing to clientId file.");
            return false;
        }
    }

    protected String bw() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m1449y(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String by() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[TransportMediator.FLAG_KEY_MEDIA_NEXT];
            int read = openFileInput.read(bArr, 0, TransportMediator.FLAG_KEY_MEDIA_NEXT);
            if (openFileInput.available() > 0) {
                aa.m48t("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m48t("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m48t("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m48t("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? bw() : str;
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? bv() : null;
    }

    public boolean m1450x(String str) {
        return "&cid".equals(str);
    }
}
