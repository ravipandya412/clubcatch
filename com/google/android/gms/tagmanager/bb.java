package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0460l.C0459a;

class bb<K, V> implements C0458k<K, V> {
    private LruCache<K, V> Vw;

    /* renamed from: com.google.android.gms.tagmanager.bb.1 */
    class C04321 extends LruCache<K, V> {
        final /* synthetic */ C0459a Vx;
        final /* synthetic */ bb Vy;

        C04321(bb bbVar, int i, C0459a c0459a) {
            this.Vy = bbVar;
            this.Vx = c0459a;
            super(i);
        }

        protected int sizeOf(K key, V value) {
            return this.Vx.sizeOf(key, value);
        }
    }

    bb(int i, C0459a<K, V> c0459a) {
        this.Vw = new C04321(this, i, c0459a);
    }

    public void m2261e(K k, V v) {
        this.Vw.put(k, v);
    }

    public V get(K key) {
        return this.Vw.get(key);
    }
}
