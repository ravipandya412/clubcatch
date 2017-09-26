package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public interface dt extends IInterface {

    /* renamed from: com.google.android.gms.internal.dt.a */
    public static abstract class C0671a extends Binder implements dt {
        public C0671a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m636z(data.readInt());
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ApplicationMetadata applicationMetadata = data.readInt() != 0 ? (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data) : null;
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m630a(applicationMetadata, readString, readString2, z);
                    return true;
                case DetectedActivity.STILL /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m627A(data.readInt());
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m633b(readString3, readDouble, z);
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m635d(data.readString(), data.readString());
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m634b(data.readString(), data.createByteArray());
                    return true;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m629C(data.readInt());
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m628B(data.readInt());
                    return true;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m632a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m631a(data.readString(), data.readLong());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m627A(int i) throws RemoteException;

    void m628B(int i) throws RemoteException;

    void m629C(int i) throws RemoteException;

    void m630a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void m631a(String str, long j) throws RemoteException;

    void m632a(String str, long j, int i) throws RemoteException;

    void m633b(String str, double d, boolean z) throws RemoteException;

    void m634b(String str, byte[] bArr) throws RemoteException;

    void m635d(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;

    void m636z(int i) throws RemoteException;
}
