package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0251b.C0623a;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0751a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0757a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0759a;
import com.google.android.gms.maps.model.internal.C0398a;
import com.google.android.gms.maps.model.internal.C0398a.C0796a;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0373c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C0767a extends Binder implements C0373c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C0766a implements C0373c {
            private IBinder ky;

            C0766a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IMapViewDelegate m2144a(C0251b c0251b, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate Z = C0759a.m2142Z(obtain2.readStrongBinder());
                    return Z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2145a(C0251b c0251b, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    obtain.writeInt(i);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2146e(C0251b c0251b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m2147f(C0251b c0251b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate Y = C0757a.m2141Y(obtain2.readStrongBinder());
                    return Y;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate gY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate S = C0751a.m2138S(obtain2.readStrongBinder());
                    return S;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0398a gZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0398a an = C0796a.an(obtain2.readStrongBinder());
                    return an;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0373c m2148U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0373c)) ? new C0766a(iBinder) : (C0373c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1126e(C0623a.m1628G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate f = m1127f(C0623a.m1628G(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m1124a(C0623a.m1628G(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate gY = gY();
                    reply.writeNoException();
                    if (gY != null) {
                        iBinder = gY.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0398a gZ = gZ();
                    reply.writeNoException();
                    if (gZ != null) {
                        iBinder = gZ.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m1125a(C0623a.m1628G(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate m1124a(C0251b c0251b, GoogleMapOptions googleMapOptions) throws RemoteException;

    void m1125a(C0251b c0251b, int i) throws RemoteException;

    void m1126e(C0251b c0251b) throws RemoteException;

    IMapFragmentDelegate m1127f(C0251b c0251b) throws RemoteException;

    ICameraUpdateFactoryDelegate gY() throws RemoteException;

    C0398a gZ() throws RemoteException;
}
