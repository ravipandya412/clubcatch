package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj implements C0162j {
    String uK;
    double uL;
    int uM;
    int uN;
    int uO;
    int uP;
    Map<String, String> uQ;

    aj() {
        this.uL = -1.0d;
        this.uM = -1;
        this.uN = -1;
        this.uO = -1;
        this.uP = -1;
        this.uQ = new HashMap();
    }

    public String m1434H(String str) {
        String str2 = (String) this.uQ.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean cB() {
        return this.uK != null;
    }

    public String cC() {
        return this.uK;
    }

    public boolean cD() {
        return this.uL >= 0.0d;
    }

    public double cE() {
        return this.uL;
    }

    public boolean cF() {
        return this.uM >= 0;
    }

    public boolean cG() {
        return this.uN != -1;
    }

    public boolean cH() {
        return this.uN == 1;
    }

    public boolean cI() {
        return this.uO != -1;
    }

    public boolean cJ() {
        return this.uO == 1;
    }

    public boolean cK() {
        return this.uP == 1;
    }

    public int getSessionTimeout() {
        return this.uM;
    }

    public String m1435h(Activity activity) {
        return m1434H(activity.getClass().getCanonicalName());
    }
}
