package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0251b.C0623a;

public interface eo extends IInterface {

    /* renamed from: com.google.android.gms.internal.eo.a */
    public static abstract class C0682a extends Binder implements eo {

        /* renamed from: com.google.android.gms.internal.eo.a.a */
        private static class C0681a implements eo {
            private IBinder ky;

            C0681a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public C0251b m1810a(C0251b c0251b, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0251b G = C0623a.m1628G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static eo m1811A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof eo)) ? new C0681a(iBinder) : (eo) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0251b a = m715a(C0623a.m1628G(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0251b m715a(C0251b c0251b, int i, int i2) throws RemoteException;
}
