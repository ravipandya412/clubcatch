package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.internal.w */
public interface C0234w extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.w.a */
    public static abstract class C0610a extends Binder implements C0234w {

        /* renamed from: com.google.android.gms.drive.internal.w.a.a */
        private static class C0609a implements C0234w {
            private IBinder ky;

            C0609a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1582a(OnEventResponse onEventResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
                    if (onEventResponse != null) {
                        obtain.writeInt(1);
                        onEventResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public C0610a() {
            attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
        }

        public static C0234w m1583F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0234w)) ? new C0609a(iBinder) : (C0234w) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
                    m328a(data.readInt() != 0 ? (OnEventResponse) OnEventResponse.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m328a(OnEventResponse onEventResponse) throws RemoteException;
}
