package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C0460l<K, V> {
    final C0459a<K, V> TK;

    /* renamed from: com.google.android.gms.tagmanager.l.a */
    public interface C0459a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l.1 */
    class C08571 implements C0459a<K, V> {
        final /* synthetic */ C0460l TL;

        C08571(C0460l c0460l) {
            this.TL = c0460l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public C0460l() {
        this.TK = new C08571(this);
    }

    public C0458k<K, V> m1370a(int i, C0459a<K, V> c0459a) {
        if (i > 0) {
            return iA() < 12 ? new da(i, c0459a) : new bb(i, c0459a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int iA() {
        return VERSION.SDK_INT;
    }
}
