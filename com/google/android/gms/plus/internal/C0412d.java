package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fh;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.internal.C0410b.C0824a;
import com.pkr.clubcatch.C0519R;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C0412d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d.a */
    public static abstract class C0828a extends Binder implements C0412d {

        /* renamed from: com.google.android.gms.plus.internal.d.a.a */
        private static class C0827a implements C0412d {
            private IBinder ky;

            C0827a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public void m2213a(fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2214a(C0410b c0410b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2215a(C0410b c0410b, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2216a(C0410b c0410b, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2217a(C0410b c0410b, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public void m2218a(C0410b c0410b, fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2219a(C0410b c0410b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2220a(C0410b c0410b, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2221a(C0410b c0410b, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }

            public void m2222b(C0410b c0410b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    this.ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2223b(C0410b c0410b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2224c(C0410b c0410b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2225d(C0410b c0410b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m2226e(C0410b c0410b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0410b != null ? c0410b.asBinder() : null);
                    obtain.writeString(str);
                    this.ky.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String hl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean hm() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String hn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.ky.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0412d aA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0412d)) ? new C0827a(iBinder) : (C0412d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            fh fhVar = null;
            String accountName;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1199a(C0824a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1200a(C0824a.ay(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1203b(C0824a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1193a(data.readInt() != 0 ? fh.CREATOR.m765x(data) : null);
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1194a(C0824a.ay(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1197a(C0824a.ay(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    Uri uri;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0410b ay = C0824a.ay(data.readStrongBinder());
                    int readInt = data.readInt();
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    m1196a(ay, readInt, readString, uri, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1195a(C0824a.ay(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1204c(C0824a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1202b(C0824a.ay(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1201a(C0824a.ay(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1205d(C0824a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_textAppearanceSmallPopupMenu /*41*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = hl();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case C0519R.styleable.Theme_dialogTheme /*42*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean hm = hm();
                    reply.writeNoException();
                    reply.writeInt(hm ? 1 : 0);
                    return true;
                case C0519R.styleable.Theme_dialogPreferredPadding /*43*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = hn();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case C0519R.styleable.Theme_listDividerAlertDialog /*44*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m1206e(C0824a.ay(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Theme_actionDropDownStyle /*45*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0410b ay2 = C0824a.ay(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        fhVar = fh.CREATOR.m765x(data);
                    }
                    m1198a(ay2, fhVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m1193a(fh fhVar) throws RemoteException;

    void m1194a(C0410b c0410b) throws RemoteException;

    void m1195a(C0410b c0410b, int i, int i2, int i3, String str) throws RemoteException;

    void m1196a(C0410b c0410b, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void m1197a(C0410b c0410b, Uri uri, Bundle bundle) throws RemoteException;

    void m1198a(C0410b c0410b, fh fhVar) throws RemoteException;

    void m1199a(C0410b c0410b, String str) throws RemoteException;

    void m1200a(C0410b c0410b, String str, String str2) throws RemoteException;

    void m1201a(C0410b c0410b, List<String> list) throws RemoteException;

    void m1202b(C0410b c0410b) throws RemoteException;

    void m1203b(C0410b c0410b, String str) throws RemoteException;

    void m1204c(C0410b c0410b, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    void m1205d(C0410b c0410b, String str) throws RemoteException;

    void m1206e(C0410b c0410b, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String hl() throws RemoteException;

    boolean hm() throws RemoteException;

    String hn() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
