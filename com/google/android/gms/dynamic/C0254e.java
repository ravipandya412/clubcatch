package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.er;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0254e<T> {
    private final String FC;
    private T FD;

    /* renamed from: com.google.android.gms.dynamic.e.a */
    public static class C0253a extends Exception {
        public C0253a(String str) {
            super(str);
        }

        public C0253a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0254e(String str) {
        this.FC = str;
    }

    protected abstract T m362d(IBinder iBinder);

    protected final T m363z(Context context) throws C0253a {
        if (this.FD == null) {
            er.m725f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0253a("Could not get remote context.");
            }
            try {
                this.FD = m362d((IBinder) remoteContext.getClassLoader().loadClass(this.FC).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0253a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0253a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0253a("Could not access creator.");
            }
        }
        return this.FD;
    }
}
