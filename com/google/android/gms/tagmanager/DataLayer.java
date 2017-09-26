package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT;
    static final String[] Ur;
    private static final Pattern Us;
    private final ConcurrentHashMap<C0420b, Integer> Ut;
    private final Map<String, Object> Uu;
    private final ReentrantLock Uv;
    private final LinkedList<Map<String, Object>> Uw;
    private final C0422c Ux;
    private final CountDownLatch Uy;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.a */
    static final class C0419a {
        public final String UA;
        public final Object UB;

        C0419a(String str, Object obj) {
            this.UA = str;
            this.UB = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C0419a)) {
                return false;
            }
            C0419a c0419a = (C0419a) o;
            return this.UA.equals(c0419a.UA) && this.UB.equals(c0419a.UB);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.UA.hashCode()), Integer.valueOf(this.UB.hashCode())});
        }

        public String toString() {
            return "Key: " + this.UA + " value: " + this.UB.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.b */
    interface C0420b {
        void m1217v(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.c */
    interface C0422c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer.c.a */
        public interface C0421a {
            void m1218b(List<C0419a> list);
        }

        void m1219a(C0421a c0421a);

        void m1220a(List<C0419a> list, long j);

        void bi(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.1 */
    class C08341 implements C0422c {
        C08341() {
        }

        public void m2233a(C0421a c0421a) {
            c0421a.m1218b(new ArrayList());
        }

        public void m2234a(List<C0419a> list, long j) {
        }

        public void bi(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.2 */
    class C08352 implements C0421a {
        final /* synthetic */ DataLayer Uz;

        C08352(DataLayer dataLayer) {
            this.Uz = dataLayer;
        }

        public void m2235b(List<C0419a> list) {
            for (C0419a c0419a : list) {
                this.Uz.m1228x(this.Uz.m1234b(c0419a.UA, c0419a.UB));
            }
            this.Uz.Uy.countDown();
        }
    }

    static {
        OBJECT_NOT_PRESENT = new Object();
        Ur = "gtm.lifetime".toString().split("\\.");
        Us = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    DataLayer() {
        this(new C08341());
    }

    DataLayer(C0422c persistentStore) {
        this.Ux = persistentStore;
        this.Ut = new ConcurrentHashMap();
        this.Uu = new HashMap();
        this.Uv = new ReentrantLock();
        this.Uw = new LinkedList();
        this.Uy = new CountDownLatch(1);
        iP();
    }

    private Object m1221A(Map<String, Object> map) {
        String[] strArr = Ur;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<C0419a> m1222B(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m1227a(map, "", arrayList);
        return arrayList;
    }

    private void m1223C(Map<String, Object> map) {
        synchronized (this.Uu) {
            for (String str : map.keySet()) {
                m1233a(m1234b(str, map.get(str)), this.Uu);
            }
        }
        m1224D(map);
    }

    private void m1224D(Map<String, Object> map) {
        for (C0420b v : this.Ut.keySet()) {
            v.m1217v(map);
        }
    }

    private void m1227a(Map<String, Object> map, String str, Collection<C0419a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m1227a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C0419a(str2, entry.getValue()));
            }
        }
    }

    static Long bh(String str) {
        Matcher matcher = Us.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m1273w("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m1271u("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m1273w("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m1271u("unknown _lifetime: " + str);
        return null;
    }

    private void iP() {
        this.Ux.m1219a(new C08352(this));
    }

    private void iQ() {
        int i = 0;
        while (true) {
            Map map = (Map) this.Uw.poll();
            if (map != null) {
                m1223C(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.Uw.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    private void m1228x(Map<String, Object> map) {
        this.Uv.lock();
        try {
            this.Uw.offer(map);
            if (this.Uv.getHoldCount() == 1) {
                iQ();
            }
            m1229y(map);
        } finally {
            this.Uv.unlock();
        }
    }

    private void m1229y(Map<String, Object> map) {
        Long z = m1230z(map);
        if (z != null) {
            List B = m1222B(map);
            B.remove("gtm.lifetime");
            this.Ux.m1220a(B, z.longValue());
        }
    }

    private Long m1230z(Map<String, Object> map) {
        Object A = m1221A(map);
        return A == null ? null : bh(A.toString());
    }

    void m1231a(C0420b c0420b) {
        this.Ut.put(c0420b, Integer.valueOf(0));
    }

    void m1232a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m1232a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m1233a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void m1233a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m1232a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m1233a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    Map<String, Object> m1234b(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void bg(String str) {
        push(str, null);
        this.Ux.bi(str);
    }

    public Object get(String key) {
        synchronized (this.Uu) {
            Map map = this.Uu;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(m1234b(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.Uy.await();
        } catch (InterruptedException e) {
            bh.m1273w("DataLayer.push: unexpected InterruptedException");
        }
        m1228x(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
