package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.gms.cast.Cast;
import java.util.HashMap;
import java.util.Map;

public final class aq {
    public static final ar lW;
    public static final ar lX;
    public static final ar lY;
    public static final ar lZ;
    public static final ar ma;
    public static final ar mb;
    public static final ar mc;
    public static final ar md;
    public static final ar me;

    /* renamed from: com.google.android.gms.internal.aq.1 */
    static class C06401 implements ar {
        C06401() {
        }

        public void m1649a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (str == null) {
                da.m570w("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = ddVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), Cast.MAX_MESSAGE_LENGTH) != null));
            }
            ddVar.m579a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.2 */
    static class C06412 implements ar {
        C06412() {
        }

        public void m1650a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                da.m570w("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0355l bc = ddVar.bc();
                if (bc != null && bc.m1081a(parse)) {
                    a = bc.m1079a(parse, ddVar.getContext());
                    new cy(ddVar.getContext(), ddVar.bd().pU, a.toString()).start();
                }
            } catch (C0356m e) {
                da.m570w("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new cy(ddVar.getContext(), ddVar.bd().pU, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.3 */
    static class C06423 implements ar {
        C06423() {
        }

        public void m1651a(dd ddVar, Map<String, String> map) {
            bo ba = ddVar.ba();
            if (ba == null) {
                da.m570w("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ba.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.4 */
    static class C06434 implements ar {
        C06434() {
        }

        public void m1652a(dd ddVar, Map<String, String> map) {
            bo ba = ddVar.ba();
            if (ba == null) {
                da.m570w("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ba.m2462g("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.5 */
    static class C06445 implements ar {
        C06445() {
        }

        public void m1653a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                da.m570w("URL missing from httpTrack GMSG.");
            } else {
                new cy(ddVar.getContext(), ddVar.bd().pU, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.6 */
    static class C06456 implements ar {
        C06456() {
        }

        public void m1654a(dd ddVar, Map<String, String> map) {
            da.m568u("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.aq.7 */
    static class C06467 implements ar {
        C06467() {
        }

        public void m1655a(dd ddVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0355l bc = ddVar.bc();
                if (bc != null) {
                    bc.m1082y().m950a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                da.m570w("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        lW = new C06401();
        lX = new C06412();
        lY = new C06423();
        lZ = new C06434();
        ma = new C06445();
        mb = new C06456();
        mc = new as();
        md = new C06467();
        me = new at();
    }
}
