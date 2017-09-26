package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C0990j extends C0724i {
    private static Method kc;
    private static Method kd;
    private static Method ke;
    private static Method kf;
    private static Method kg;
    private static Method kh;
    private static String ki;
    private static C0360p kj;
    static boolean kk;
    private static long startTime;

    /* renamed from: com.google.android.gms.internal.j.a */
    static class C0352a extends Exception {
        public C0352a(Throwable th) {
            super(th);
        }
    }

    static {
        startTime = 0;
        kk = false;
    }

    protected C0990j(Context context, C0357n c0357n, C0358o c0358o) {
        super(context, c0357n, c0358o);
    }

    static String m2764a(Context context, C0357n c0357n) throws C0352a {
        if (ke == null) {
            throw new C0352a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) ke.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0357n.m1083a(byteBuffer.array(), true);
            }
            throw new C0352a();
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    static ArrayList<Long> m2765a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0352a {
        if (kf == null || motionEvent == null) {
            throw new C0352a();
        }
        try {
            return (ArrayList) kf.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    protected static synchronized void m2766a(String str, Context context, C0357n c0357n) {
        synchronized (C0990j.class) {
            if (!kk) {
                try {
                    kj = new C0360p(c0357n, null);
                    ki = str;
                    C0990j.m2770e(context);
                    startTime = C0990j.m2772w().longValue();
                    kk = true;
                } catch (C0352a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String m2767b(Context context, C0357n c0357n) throws C0352a {
        if (kh == null) {
            throw new C0352a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kh.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0357n.m1083a(byteBuffer.array(), true);
            }
            throw new C0352a();
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    private static String m2768b(byte[] bArr, String str) throws C0352a {
        try {
            return new String(kj.m1089c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    static String m2769d(Context context) throws C0352a {
        if (kg == null) {
            throw new C0352a();
        }
        try {
            String str = (String) kg.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0352a();
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    private static void m2770e(Context context) throws C0352a {
        try {
            byte[] d = kj.m1090d(C0361r.getKey());
            byte[] c = kj.m1089c(d, C0361r.m1091A());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0352a();
                }
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1092B()));
            Class loadClass2 = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1098H()));
            Class loadClass3 = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1096F()));
            Class loadClass4 = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1102L()));
            Class loadClass5 = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1094D()));
            Class loadClass6 = dexClassLoader.loadClass(C0990j.m2768b(d, C0361r.m1100J()));
            kc = loadClass.getMethod(C0990j.m2768b(d, C0361r.m1093C()), new Class[0]);
            kd = loadClass2.getMethod(C0990j.m2768b(d, C0361r.m1099I()), new Class[0]);
            ke = loadClass3.getMethod(C0990j.m2768b(d, C0361r.m1097G()), new Class[]{Context.class});
            kf = loadClass4.getMethod(C0990j.m2768b(d, C0361r.m1103M()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            kg = loadClass5.getMethod(C0990j.m2768b(d, C0361r.m1095E()), new Class[]{Context.class});
            kh = loadClass6.getMethod(C0990j.m2768b(d, C0361r.m1101K()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        } catch (Throwable e22) {
            throw new C0352a(e22);
        } catch (Throwable e222) {
            throw new C0352a(e222);
        } catch (Throwable e2222) {
            throw new C0352a(e2222);
        } catch (Throwable e22222) {
            throw new C0352a(e22222);
        }
    }

    static String m2771v() throws C0352a {
        if (ki != null) {
            return ki;
        }
        throw new C0352a();
    }

    static Long m2772w() throws C0352a {
        if (kc == null) {
            throw new C0352a();
        }
        try {
            return (Long) kc.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    static String m2773x() throws C0352a {
        if (kd == null) {
            throw new C0352a();
        }
        try {
            return (String) kd.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0352a(e);
        } catch (Throwable e2) {
            throw new C0352a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m2774b(android.content.Context r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C0990j.m2773x();	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
        r4.m2094a(r0, r1);	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C0990j.m2771v();	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
        r4.m2094a(r0, r1);	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C0990j.m2772w();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r2 = r1.longValue();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r4.m2093a(r0, r2);	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
    L_0x001d:
        r0 = 24;
        r1 = com.google.android.gms.internal.C0990j.m2769d(r5);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
        r4.m2094a(r0, r1);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0029:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0010;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m2775c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C0990j.m2771v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m2094a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C0990j.m2773x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m2094a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = com.google.android.gms.internal.C0990j.m2772w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m2093a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r4 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r4;
        r6.m2093a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m2093a(r0, r2);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jY;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jZ;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0990j.m2765a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2093a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2093a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2093a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.ka;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0990j.m2764a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m2094a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.ka;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0990j.m2767b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m2094a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.c(android.content.Context):void");
    }
}
