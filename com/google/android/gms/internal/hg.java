package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.hf.C0715a;
import com.google.android.gms.internal.hv.C0722a;
import com.google.android.gms.internal.hx.C0723a;
import com.google.android.gms.location.C0368a;
import com.google.android.gms.location.C0368a.C0741a;
import com.google.android.gms.location.C0742b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.pkr.clubcatch.C0519R;
import java.util.List;

public interface hg extends IInterface {

    /* renamed from: com.google.android.gms.internal.hg.a */
    public static abstract class C0717a extends Binder implements hg {

        /* renamed from: com.google.android.gms.internal.hg.a.a */
        private static class C0716a implements hg {
            private IBinder ky;

            C0716a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2056a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2057a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2058a(PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2059a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.ky.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2060a(hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2061a(hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2062a(hp hpVar, id idVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hpVar != null) {
                        obtain.writeInt(1);
                        hpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2063a(hr hrVar, id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hrVar != null) {
                        obtain.writeInt(1);
                        hrVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2064a(id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2065a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2066a(LocationRequest locationRequest, C0368a c0368a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0368a != null ? c0368a.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2067a(LocationRequest locationRequest, C0368a c0368a, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0368a != null ? c0368a.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2068a(C0368a c0368a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(c0368a != null ? c0368a.asBinder() : null);
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2069a(LatLng latLng, hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2070a(LatLngBounds latLngBounds, int i, hn hnVar, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2071a(String str, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2072a(List<C0723a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    this.ky.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m2073a(List<hj> list, PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2074a(String[] strArr, hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location aF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.ky.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0742b aG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    C0742b au = obtain2.readInt() != 0 ? C0742b.CREATOR.au(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return au;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2075b(String str, id idVar, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.ky.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location gk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static hg m2076P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hg)) ? new C0716a(iBinder) : (hg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            Location location = null;
            PendingIntent pendingIntent;
            LocationRequest createFromParcel;
            String readString;
            id aD;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    List createTypedArrayList = data.createTypedArrayList(hj.CREATOR);
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m974a(createTypedArrayList, pendingIntent, C0715a.m2055O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m959a(pendingIntent, C0715a.m2055O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m975a(data.createStringArray(), C0715a.m2055O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m961a(C0715a.m2055O(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    long readLong = data.readLong();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m957a(readLong, z, pendingIntent);
                    reply.writeNoException();
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    removeActivityUpdates(pendingIntent);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    location = gk();
                    reply.writeNoException();
                    if (location != null) {
                        reply.writeInt(1);
                        location.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m967a(createFromParcel, C0741a.m2132N(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationRequest createFromParcel2 = data.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m966a(createFromParcel2, pendingIntent);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m969a(C0741a.m2132N(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m958a(pendingIntent);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMockMode(z);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        location = (Location) Location.CREATOR.createFromParcel(data);
                    }
                    setMockLocation(location);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m971a(data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt() != 0 ? hn.CREATOR.aw(data) : null, data.readInt() != 0 ? id.CREATOR.aD(data) : null, C0722a.m2085R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m972a(readString, aD, C0722a.m2085R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng createFromParcel3 = data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null;
                    hn aw = data.readInt() != 0 ? hn.CREATOR.aw(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m970a(createFromParcel3, aw, aD, C0722a.m2085R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hn aw2 = data.readInt() != 0 ? hn.CREATOR.aw(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m962a(aw2, aD, C0722a.m2085R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hr ay = data.readInt() != 0 ? hr.CREATOR.ay(data) : null;
                    id aD2 = data.readInt() != 0 ? id.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m964a(ay, aD2, pendingIntent);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    id aD3 = data.readInt() != 0 ? id.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    m965a(aD3, pendingIntent);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    m968a(createFromParcel, C0741a.m2132N(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    location = aF(data.readString());
                    reply.writeNoException();
                    if (location != null) {
                        reply.writeInt(1);
                        location.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    m973a(data.createTypedArrayList(C0723a.CREATOR));
                    return true;
                case C0519R.styleable.Theme_actionMenuTextAppearance /*25*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hp ax = data.readInt() != 0 ? hp.CREATOR.ax(data) : null;
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m963a(ax, aD);
                    return true;
                case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        location = (Location) Location.CREATOR.createFromParcel(data);
                    }
                    m960a(location, data.readInt());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    C0742b aG = aG(data.readString());
                    reply.writeNoException();
                    if (aG != null) {
                        reply.writeInt(1);
                        aG.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case C0519R.styleable.Theme_dialogTheme /*42*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        aD = id.CREATOR.aD(data);
                    }
                    m976b(readString, aD, C0722a.m2085R(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m957a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void m958a(PendingIntent pendingIntent) throws RemoteException;

    void m959a(PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException;

    void m960a(Location location, int i) throws RemoteException;

    void m961a(hf hfVar, String str) throws RemoteException;

    void m962a(hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m963a(hp hpVar, id idVar) throws RemoteException;

    void m964a(hr hrVar, id idVar, PendingIntent pendingIntent) throws RemoteException;

    void m965a(id idVar, PendingIntent pendingIntent) throws RemoteException;

    void m966a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void m967a(LocationRequest locationRequest, C0368a c0368a) throws RemoteException;

    void m968a(LocationRequest locationRequest, C0368a c0368a, String str) throws RemoteException;

    void m969a(C0368a c0368a) throws RemoteException;

    void m970a(LatLng latLng, hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m971a(LatLngBounds latLngBounds, int i, hn hnVar, id idVar, hv hvVar) throws RemoteException;

    void m972a(String str, id idVar, hv hvVar) throws RemoteException;

    void m973a(List<C0723a> list) throws RemoteException;

    void m974a(List<hj> list, PendingIntent pendingIntent, hf hfVar, String str) throws RemoteException;

    void m975a(String[] strArr, hf hfVar, String str) throws RemoteException;

    Location aF(String str) throws RemoteException;

    C0742b aG(String str) throws RemoteException;

    void m976b(String str, id idVar, hv hvVar) throws RemoteException;

    Location gk() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
