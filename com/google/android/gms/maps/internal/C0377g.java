package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0251b.C0623a;

/* renamed from: com.google.android.gms.maps.internal.g */
public interface C0377g extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.g.a */
    public static abstract class C0775a extends Binder implements C0377g {

        /* renamed from: com.google.android.gms.maps.internal.g.a.a */
        private static class C0774a implements C0377g {
            private IBinder ky;

            C0774a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2153g(C0251b c0251b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0377g ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0377g)) ? new C0774a(iBinder) : (C0377g) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    m1131g(C0623a.m1628G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1131g(C0251b c0251b) throws RemoteException;
}
