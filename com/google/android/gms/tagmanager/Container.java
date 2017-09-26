package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296c.C0938f;
import com.google.android.gms.internal.C0296c.C0941i;
import com.google.android.gms.internal.C0296c.C0942j;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.tagmanager.C0867s.C0465a;
import com.google.android.gms.tagmanager.ce.C0436a;
import com.google.android.gms.tagmanager.cr.C0444c;
import com.google.android.gms.tagmanager.cr.C0448g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String TM;
    private final DataLayer TN;
    private ct TO;
    private Map<String, FunctionCallMacroCallback> TP;
    private Map<String, FunctionCallTagCallback> TQ;
    private volatile long TR;
    private volatile String TS;
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.a */
    private class C0832a implements C0465a {
        final /* synthetic */ Container TT;

        private C0832a(Container container) {
            this.TT = container;
        }

        public Object m2231b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback aY = this.TT.aY(str);
            return aY == null ? null : aY.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.b */
    private class C0833b implements C0465a {
        final /* synthetic */ Container TT;

        private C0833b(Container container) {
            this.TT = container;
        }

        public Object m2232b(String str, Map<String, Object> map) {
            FunctionCallTagCallback aZ = this.TT.aZ(str);
            if (aZ != null) {
                aZ.execute(str, map);
            }
            return di.kt();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0942j resource) {
        this.TP = new HashMap();
        this.TQ = new HashMap();
        this.TS = "";
        this.mContext = context;
        this.TN = dataLayer;
        this.TM = containerId;
        this.TR = lastRefreshTime;
        m1213a(resource.fV);
        if (resource.fU != null) {
            m1216a(resource.fU);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0444c resource) {
        this.TP = new HashMap();
        this.TQ = new HashMap();
        this.TS = "";
        this.mContext = context;
        this.TN = dataLayer;
        this.TM = containerId;
        this.TR = lastRefreshTime;
        m1214a(resource);
    }

    private void m1213a(C0938f c0938f) {
        if (c0938f == null) {
            throw new NullPointerException();
        }
        try {
            m1214a(cr.m1311b(c0938f));
        } catch (C0448g e) {
            bh.m1270t("Not loading resource: " + c0938f + " because it is invalid: " + e.toString());
        }
    }

    private void m1214a(C0444c c0444c) {
        this.TS = c0444c.getVersion();
        C0444c c0444c2 = c0444c;
        m1215a(new ct(this.mContext, c0444c2, this.TN, new C0832a(), new C0833b(), bb(this.TS)));
    }

    private synchronized void m1215a(ct ctVar) {
        this.TO = ctVar;
    }

    private void m1216a(C0941i[] c0941iArr) {
        List arrayList = new ArrayList();
        for (Object add : c0941iArr) {
            arrayList.add(add);
        }
        iE().m1339f(arrayList);
    }

    private synchronized ct iE() {
        return this.TO;
    }

    FunctionCallMacroCallback aY(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.TP) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.TP.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback aZ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.TQ) {
            functionCallTagCallback = (FunctionCallTagCallback) this.TQ.get(str);
        }
        return functionCallTagCallback;
    }

    void ba(String str) {
        iE().ba(str);
    }

    ag bb(String str) {
        if (ce.ju().jv().equals(C0436a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1270t("getBoolean called for closed container.");
            return di.kr().booleanValue();
        }
        try {
            return di.m1355n((C0945a) iE.bC(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m1270t("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kr().booleanValue();
        }
    }

    public String getContainerId() {
        return this.TM;
    }

    public double getDouble(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1270t("getDouble called for closed container.");
            return di.kq().doubleValue();
        }
        try {
            return di.m1352m((C0945a) iE.bC(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m1270t("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kq().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.TR;
    }

    public long getLong(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1270t("getLong called for closed container.");
            return di.kp().longValue();
        }
        try {
            return di.m1351l((C0945a) iE.bC(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m1270t("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kp().longValue();
        }
    }

    public String getString(String key) {
        ct iE = iE();
        if (iE == null) {
            bh.m1270t("getString called for closed container.");
            return di.kt();
        }
        try {
            return di.m1349j((C0945a) iE.bC(key).getObject());
        } catch (Exception e) {
            bh.m1270t("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return di.kt();
        }
    }

    String iD() {
        return this.TS;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.TP) {
            this.TP.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.TQ) {
            this.TQ.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.TO = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.TP) {
            this.TP.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.TQ) {
            this.TQ.remove(customTagName);
        }
    }
}
