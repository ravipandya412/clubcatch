package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.drive.internal.C0233v.C0608a;
import com.google.android.gms.drive.internal.C0234w.C0610a;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

/* renamed from: com.google.android.gms.drive.internal.u */
public interface C0232u extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.u.a */
    public static abstract class C0606a extends Binder implements C0232u {

        /* renamed from: com.google.android.gms.drive.internal.u.a.a */
        private static class C0605a implements C0232u {
            private IBinder ky;

            C0605a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IntentSender m1555a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender m1556a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1557a(AddEventListenerRequest addEventListenerRequest, C0234w c0234w, String str, C0233v c0233v) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0234w != null ? c0234w.asBinder() : null);
                    obtain.writeString(str);
                    if (c0233v != null) {
                        iBinder = c0233v.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1558a(AuthorizeAccessRequest authorizeAccessRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1559a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1560a(CloseContentsRequest closeContentsRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1561a(CreateContentsRequest createContentsRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1562a(CreateFileRequest createFileRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1563a(CreateFolderRequest createFolderRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1564a(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1565a(GetMetadataRequest getMetadataRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1566a(ListParentsRequest listParentsRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1567a(OpenContentsRequest openContentsRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1568a(QueryRequest queryRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1569a(RemoveEventListenerRequest removeEventListenerRequest, C0234w c0234w, String str, C0233v c0233v) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0234w != null ? c0234w.asBinder() : null);
                    obtain.writeString(str);
                    if (c0233v != null) {
                        iBinder = c0233v.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1570a(TrashResourceRequest trashResourceRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1571a(UpdateMetadataRequest updateMetadataRequest, C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1572a(C0233v c0233v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(c0233v != null ? c0233v.asBinder() : null);
                    this.ky.transact(9, obtain, obtain2, 0);
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

        public static C0232u m1573D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0232u)) ? new C0605a(iBinder) : (C0232u) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest = null;
            IntentSender a;
            switch (code) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    GetMetadataRequest getMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getMetadataRequest = (GetMetadataRequest) GetMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m313a(getMetadataRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    QueryRequest queryRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(data);
                    }
                    m316a(queryRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.STILL /*3*/:
                    UpdateMetadataRequest updateMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updateMetadataRequest = (UpdateMetadataRequest) UpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m319a(updateMetadataRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.UNKNOWN /*4*/:
                    CreateContentsRequest createContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createContentsRequest = (CreateContentsRequest) CreateContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m309a(createContentsRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case DetectedActivity.TILTING /*5*/:
                    CreateFileRequest createFileRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileRequest = (CreateFileRequest) CreateFileRequest.CREATOR.createFromParcel(data);
                    }
                    m310a(createFileRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    CreateFolderRequest createFolderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFolderRequest = (CreateFolderRequest) CreateFolderRequest.CREATOR.createFromParcel(data);
                    }
                    m311a(createFolderRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    OpenContentsRequest openContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openContentsRequest = (OpenContentsRequest) OpenContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m315a(openContentsRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    CloseContentsRequest closeContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsRequest = (CloseContentsRequest) CloseContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m308a(closeContentsRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    m320a(C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    OpenFileIntentSenderRequest openFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openFileIntentSenderRequest = (OpenFileIntentSenderRequest) OpenFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    a = m304a(openFileIntentSenderRequest);
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    CreateFileIntentSenderRequest createFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileIntentSenderRequest = (CreateFileIntentSenderRequest) CreateFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    a = m303a(createFileIntentSenderRequest);
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    AuthorizeAccessRequest authorizeAccessRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        authorizeAccessRequest = (AuthorizeAccessRequest) AuthorizeAccessRequest.CREATOR.createFromParcel(data);
                    }
                    m306a(authorizeAccessRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    ListParentsRequest listParentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        listParentsRequest = (ListParentsRequest) ListParentsRequest.CREATOR.createFromParcel(data);
                    }
                    m314a(listParentsRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    AddEventListenerRequest addEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addEventListenerRequest = (AddEventListenerRequest) AddEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    m305a(addEventListenerRequest, C0610a.m1583F(data.readStrongBinder()), data.readString(), C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    RemoveEventListenerRequest removeEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removeEventListenerRequest = (RemoveEventListenerRequest) RemoveEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    m317a(removeEventListenerRequest, C0610a.m1583F(data.readStrongBinder()), data.readString(), C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    DisconnectRequest disconnectRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        disconnectRequest = (DisconnectRequest) DisconnectRequest.CREATOR.createFromParcel(data);
                    }
                    m312a(disconnectRequest);
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                    TrashResourceRequest trashResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        trashResourceRequest = (TrashResourceRequest) TrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    m318a(trashResourceRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest) CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m307a(closeContentsAndUpdateMetadataRequest, C0608a.m1581E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IntentSender m303a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender m304a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    void m305a(AddEventListenerRequest addEventListenerRequest, C0234w c0234w, String str, C0233v c0233v) throws RemoteException;

    void m306a(AuthorizeAccessRequest authorizeAccessRequest, C0233v c0233v) throws RemoteException;

    void m307a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0233v c0233v) throws RemoteException;

    void m308a(CloseContentsRequest closeContentsRequest, C0233v c0233v) throws RemoteException;

    void m309a(CreateContentsRequest createContentsRequest, C0233v c0233v) throws RemoteException;

    void m310a(CreateFileRequest createFileRequest, C0233v c0233v) throws RemoteException;

    void m311a(CreateFolderRequest createFolderRequest, C0233v c0233v) throws RemoteException;

    void m312a(DisconnectRequest disconnectRequest) throws RemoteException;

    void m313a(GetMetadataRequest getMetadataRequest, C0233v c0233v) throws RemoteException;

    void m314a(ListParentsRequest listParentsRequest, C0233v c0233v) throws RemoteException;

    void m315a(OpenContentsRequest openContentsRequest, C0233v c0233v) throws RemoteException;

    void m316a(QueryRequest queryRequest, C0233v c0233v) throws RemoteException;

    void m317a(RemoveEventListenerRequest removeEventListenerRequest, C0234w c0234w, String str, C0233v c0233v) throws RemoteException;

    void m318a(TrashResourceRequest trashResourceRequest, C0233v c0233v) throws RemoteException;

    void m319a(UpdateMetadataRequest updateMetadataRequest, C0233v c0233v) throws RemoteException;

    void m320a(C0233v c0233v) throws RemoteException;
}
