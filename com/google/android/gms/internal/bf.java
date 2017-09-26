package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.bg.C0650a;

public interface bf extends IInterface {

    /* renamed from: com.google.android.gms.internal.bf.a */
    public static abstract class C0648a extends Binder implements bf {

        /* renamed from: com.google.android.gms.internal.bf.a.a */
        private static class C0647a implements bf {
            private IBinder ky;

            C0647a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public bg m1673m(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    bg j = C0650a.m1679j(obtain2.readStrongBinder());
                    return j;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0648a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static bf m1674i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bf)) ? new C0647a(iBinder) : (bf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    bg m = m438m(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(m != null ? m.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    bg m438m(String str) throws RemoteException;
}
