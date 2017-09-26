package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1014i extends dg {
    private static final String ID;
    private static final String TF;
    private static final String TG;
    static final String TH;
    private static final Set<String> TI;
    private static final String URL;
    private final C0456a TJ;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i.a */
    public interface C0456a {
        aq iz();
    }

    /* renamed from: com.google.android.gms.tagmanager.i.1 */
    class C08561 implements C0456a {
        final /* synthetic */ Context os;

        C08561(Context context) {
            this.os = context;
        }

        public aq iz() {
            return C0871y.m2364F(this.os);
        }
    }

    static {
        ID = C0270a.ARBITRARY_PIXEL.toString();
        URL = C0273b.URL.toString();
        TF = C0273b.ADDITIONAL_PARAMS.toString();
        TG = C0273b.UNREPEATABLE.toString();
        TH = "gtm_" + ID + "_unrepeatable";
        TI = new HashSet();
    }

    public C1014i(Context context) {
        this(context, new C08561(context));
    }

    C1014i(Context context, C0456a c0456a) {
        super(ID, URL);
        this.TJ = c0456a;
        this.mContext = context;
    }

    private synchronized boolean aU(String str) {
        boolean z = true;
        synchronized (this) {
            if (!aW(str)) {
                if (aV(str)) {
                    TI.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean aV(String str) {
        return this.mContext.getSharedPreferences(TH, 0).contains(str);
    }

    boolean aW(String str) {
        return TI.contains(str);
    }

    public void m2867w(Map<String, C0945a> map) {
        String j = map.get(TG) != null ? di.m1349j((C0945a) map.get(TG)) : null;
        if (j == null || !aU(j)) {
            Builder buildUpon = Uri.parse(di.m1349j((C0945a) map.get(URL))).buildUpon();
            C0945a c0945a = (C0945a) map.get(TF);
            if (c0945a != null) {
                Object o = di.m1357o(c0945a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m1270t("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m1270t("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.TJ.iz().bk(uri);
            bh.m1272v("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1014i.class) {
                    TI.add(j);
                    cz.m1341a(this.mContext, TH, j, "true");
                }
            }
        }
    }
}
