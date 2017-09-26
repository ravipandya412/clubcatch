package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0234w.C0610a;
import com.google.android.gms.internal.er;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0912s<C extends DriveEvent> extends C0610a {
    private final Listener<C> DR;
    private final C0230a<C> DS;
    private final int Dm;

    /* renamed from: com.google.android.gms.drive.internal.s.a */
    private static class C0230a<E extends DriveEvent> extends Handler {
        private C0230a(Looper looper) {
            super(looper);
        }

        public void m300a(Listener<E> listener, E e) {
            sendMessage(obtainMessage(1, new Pair(listener, e)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
            }
        }
    }

    public C0912s(Looper looper, int i, Listener<C> listener) {
        this.Dm = i;
        this.DR = listener;
        this.DS = new C0230a(null);
    }

    public void m2397a(OnEventResponse onEventResponse) throws RemoteException {
        er.m726v(this.Dm == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                this.DS.m300a(this.DR, onEventResponse.fa());
            case DetectedActivity.ON_FOOT /*2*/:
                this.DS.m300a(this.DR, onEventResponse.fb());
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
        }
    }
}
