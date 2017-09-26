package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0164k.C0163a;

class ai extends C0164k<aj> {

    /* renamed from: com.google.android.gms.analytics.ai.a */
    private static class C0572a implements C0163a<aj> {
        private final aj uJ;

        public C0572a() {
            this.uJ = new aj();
        }

        public void m1430a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.uJ.uM = i;
            } else {
                aa.m51w("int configuration name not recognized:  " + str);
            }
        }

        public void m1431a(String str, String str2) {
            this.uJ.uQ.put(str, str2);
        }

        public void m1432b(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.uJ.uK = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.uJ.uL = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    aa.m48t("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                aa.m51w("string configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C0162j bz() {
            return cA();
        }

        public void m1433c(String str, boolean z) {
            int i = 1;
            aj ajVar;
            if ("ga_autoActivityTracking".equals(str)) {
                ajVar = this.uJ;
                if (!z) {
                    i = 0;
                }
                ajVar.uN = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                ajVar = this.uJ;
                if (!z) {
                    i = 0;
                }
                ajVar.uO = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                ajVar = this.uJ;
                if (!z) {
                    i = 0;
                }
                ajVar.uP = i;
            } else {
                aa.m51w("bool configuration name not recognized:  " + str);
            }
        }

        public aj cA() {
            return this.uJ;
        }
    }

    public ai(Context context) {
        super(context, new C0572a());
    }
}
