package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ep {

    /* renamed from: com.google.android.gms.internal.ep.a */
    public static final class C0336a {
        private final List<String> Ce;
        private final Object Cf;

        private C0336a(Object obj) {
            this.Cf = er.m725f(obj);
            this.Ce = new ArrayList();
        }

        public C0336a m716a(String str, Object obj) {
            this.Ce.add(((String) er.m725f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.Cf.getClass().getSimpleName()).append('{');
            int size = this.Ce.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.Ce.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static C0336a m717e(Object obj) {
        return new C0336a(null);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
