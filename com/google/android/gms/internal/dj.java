package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;
import java.util.Map;

public interface dj extends IInterface {

    /* renamed from: com.google.android.gms.internal.dj.a */
    public static abstract class C0663a extends Binder implements dj {

        /* renamed from: com.google.android.gms.internal.dj.a.a */
        private static class C0662a implements dj {
            private IBinder ky;

            C0662a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1712a(Map map, long j, String str, List<di> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    obtain.writeMap(map);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
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

            public void bk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static dj m1713r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dj)) ? new C0662a(iBinder) : (dj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    m599a(data.readHashMap(getClass().getClassLoader()), data.readLong(), data.readString(), data.createTypedArrayList(di.CREATOR));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    bk();
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    String version = getVersion();
                    reply.writeNoException();
                    reply.writeString(version);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m599a(Map map, long j, String str, List<di> list) throws RemoteException;

    void bk() throws RemoteException;

    String getVersion() throws RemoteException;
}
