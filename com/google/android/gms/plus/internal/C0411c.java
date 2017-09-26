package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0251b.C0623a;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.plus.internal.c */
public interface C0411c extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.c.a */
    public static abstract class C0826a extends Binder implements C0411c {

        /* renamed from: com.google.android.gms.plus.internal.c.a.a */
        private static class C0825a implements C0411c {
            private IBinder ky;

            C0825a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public C0251b m2211a(C0251b c0251b, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0251b G = C0623a.m1628G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0251b m2212a(C0251b c0251b, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(2, obtain, obtain2, 0);
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

        public static C0411c az(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0411c)) ? new C0825a(iBinder) : (C0411c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0251b a;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m1191a(C0623a.m1628G(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = m1192a(C0623a.m1628G(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0251b m1191a(C0251b c0251b, int i, int i2, String str, int i3) throws RemoteException;

    C0251b m1192a(C0251b c0251b, int i, int i2, String str, String str2) throws RemoteException;
}
