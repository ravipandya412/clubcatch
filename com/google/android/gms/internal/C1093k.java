package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.k */
public class C1093k extends C0990j {

    /* renamed from: com.google.android.gms.internal.k.a */
    class C0354a {
        private String kl;
        private boolean km;
        final /* synthetic */ C1093k kn;

        public C0354a(C1093k c1093k, String str, boolean z) {
            this.kn = c1093k;
            this.kl = str;
            this.km = z;
        }

        public String getId() {
            return this.kl;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.km;
        }
    }

    private C1093k(Context context, C0357n c0357n, C0358o c0358o) {
        super(context, c0357n, c0358o);
    }

    public static C1093k m3089a(String str, Context context) {
        C0357n c0672e = new C0672e();
        C0990j.m2766a(str, context, c0672e);
        return new C1093k(context, c0672e, new C0733q(239));
    }

    protected void m3090b(Context context) {
        long j = 1;
        super.m2774b(context);
        try {
            C0354a f = m3091f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m2093a(28, j);
                String id = f.getId();
                if (id != null) {
                    m2094a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m2093a(28, 1);
        }
    }

    C0354a m3091f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.ka.m1083a(bArr, true);
            }
            return new C0354a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
