package com.google.android.gms.analytics;

public class aa {
    private static GoogleAnalytics tV;

    public static boolean cm() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (tV == null) {
            tV = GoogleAnalytics.cf();
        }
        return tV != null ? tV.getLogger() : null;
    }

    public static void m48t(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void m49u(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void m50v(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void m51w(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }
}
