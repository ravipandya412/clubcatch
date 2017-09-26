package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ch extends IInterface {

    /* renamed from: com.google.android.gms.internal.ch.a */
    public static abstract class C0659a extends Binder implements ch {

        /* renamed from: com.google.android.gms.internal.ch.a.a */
        private static class C0658a implements ch {
            private IBinder ky;

            C0658a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public cf m1707b(cd cdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (cdVar != null) {
                        obtain.writeInt(1);
                        cdVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    cf g = obtain2.readInt() != 0 ? cf.CREATOR.m480g(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return g;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0659a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static ch m1708q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ch)) ? new C0658a(iBinder) : (ch) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    cf b = m482b(data.readInt() != 0 ? cd.CREATOR.m477f(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    cf m482b(cd cdVar) throws RemoteException;
}
