package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0251b.C0623a;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.bh.C0652a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public interface bg extends IInterface {

    /* renamed from: com.google.android.gms.internal.bg.a */
    public static abstract class C0650a extends Binder implements bg {

        /* renamed from: com.google.android.gms.internal.bg.a.a */
        private static class C0649a implements bg {
            private IBinder ky;

            C0649a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m1675a(C0251b c0251b, ab abVar, C0739z c0739z, String str, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0739z != null) {
                        obtain.writeInt(1);
                        c0739z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1676a(C0251b c0251b, ab abVar, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (c0739z != null) {
                        obtain.writeInt(1);
                        c0739z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1677a(C0251b c0251b, C0739z c0739z, String str, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    if (c0739z != null) {
                        obtain.writeInt(1);
                        c0739z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1678a(C0251b c0251b, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0251b != null ? c0251b.asBinder() : null);
                    if (c0739z != null) {
                        obtain.writeInt(1);
                        c0739z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0251b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0251b G = C0623a.m1628G(obtain2.readStrongBinder());
                    return G;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0650a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static bg m1679j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bg)) ? new C0649a(iBinder) : (bg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            C0739z c0739z = null;
            C0251b view;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m439a(C0623a.m1628G(data.readStrongBinder()), data.readInt() != 0 ? ab.CREATOR.m386b(data) : null, data.readInt() != 0 ? C0739z.CREATOR.m383a(data) : null, data.readString(), C0652a.m1681k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0623a.m1628G(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        c0739z = C0739z.CREATOR.m383a(data);
                    }
                    m441a(view, c0739z, data.readString(), C0652a.m1681k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m440a(C0623a.m1628G(data.readStrongBinder()), data.readInt() != 0 ? ab.CREATOR.m386b(data) : null, data.readInt() != 0 ? C0739z.CREATOR.m383a(data) : null, data.readString(), data.readString(), C0652a.m1681k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m442a(C0623a.m1628G(data.readStrongBinder()), data.readInt() != 0 ? C0739z.CREATOR.m383a(data) : null, data.readString(), data.readString(), C0652a.m1681k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m439a(C0251b c0251b, ab abVar, C0739z c0739z, String str, bh bhVar) throws RemoteException;

    void m440a(C0251b c0251b, ab abVar, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException;

    void m441a(C0251b c0251b, C0739z c0739z, String str, bh bhVar) throws RemoteException;

    void m442a(C0251b c0251b, C0739z c0739z, String str, String str2, bh bhVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0251b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
