package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.k */
abstract class C0164k<T extends C0162j> {
    Context mContext;
    C0163a<T> rb;

    /* renamed from: com.google.android.gms.analytics.k.a */
    public interface C0163a<U extends C0162j> {
        void m70a(String str, int i);

        void m71a(String str, String str2);

        void m72b(String str, String str2);

        U bz();

        void m73c(String str, boolean z);
    }

    public C0164k(Context context, C0163a<T> c0163a) {
        this.mContext = context;
        this.rb = c0163a;
    }

    private T m74a(XmlResourceParser xmlResourceParser) {
        String trim;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.rb.m71a(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.rb.m72b(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.rb.m73c(r0, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.m48t("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.rb.m70a(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.m48t("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.m48t("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.m48t("Error parsing tracker configuration file: " + e4);
        }
        return this.rb.bz();
    }

    public T m75p(int i) {
        try {
            return m74a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.m51w("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
