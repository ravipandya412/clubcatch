package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class cl {
    private int mOrientation;
    private String oC;
    private String oD;
    private String oE;
    private List<String> oF;
    private List<String> oG;
    private long oH;
    private boolean oI;
    private final long oJ;
    private List<String> oK;
    private long oL;

    public cl() {
        this.oH = -1;
        this.oI = false;
        this.oJ = -1;
        this.oL = -1;
        this.mOrientation = -1;
    }

    private static long m496a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                da.m570w("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private static List<String> m497b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m498e(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Ad-Size");
        if (list != null && !list.isEmpty()) {
            this.oC = (String) list.get(0);
        }
    }

    private void m499f(Map<String, List<String>> map) {
        List b = m497b(map, "X-Afma-Click-Tracking-Urls");
        if (b != null) {
            this.oF = b;
        }
    }

    private void m500g(Map<String, List<String>> map) {
        List b = m497b(map, "X-Afma-Tracking-Urls");
        if (b != null) {
            this.oG = b;
        }
    }

    private void m501h(Map<String, List<String>> map) {
        long a = m496a(map, "X-Afma-Interstitial-Timeout");
        if (a != -1) {
            this.oH = a;
        }
    }

    private void m502i(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.oI = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m503j(Map<String, List<String>> map) {
        List b = m497b(map, "X-Afma-Manual-Tracking-Urls");
        if (b != null) {
            this.oK = b;
        }
    }

    private void m504k(Map<String, List<String>> map) {
        long a = m496a(map, "X-Afma-Refresh-Rate");
        if (a != -1) {
            this.oL = a;
        }
    }

    private void m505l(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = cv.aU();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = cv.aT();
            }
        }
    }

    public void m506a(String str, Map<String, List<String>> map, String str2) {
        this.oD = str;
        this.oE = str2;
        m507d(map);
    }

    public void m507d(Map<String, List<String>> map) {
        m498e(map);
        m499f((Map) map);
        m500g(map);
        m501h(map);
        m502i(map);
        m503j(map);
        m504k(map);
        m505l(map);
    }

    public cf m508f(long j) {
        return new cf(this.oD, this.oE, this.oF, this.oG, this.oH, this.oI, -1, this.oK, this.oL, this.mOrientation, this.oC, j);
    }
}
