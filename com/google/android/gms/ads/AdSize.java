package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.cz;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final String kC;
    private final int f22v;
    private final int f23w;

    static {
        BANNER = new AdSize(320, 50, "320x50_mb");
        FULL_BANNER = new AdSize(468, 60, "468x60_as");
        LEADERBOARD = new AdSize(728, 90, "728x90_as");
        MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(FULL_WIDTH, AUTO_HEIGHT, "smart_banner");
    }

    public AdSize(int width, int height) {
        this(width, height, (width == FULL_WIDTH ? "FULL" : String.valueOf(width)) + "x" + (height == AUTO_HEIGHT ? "AUTO" : String.valueOf(height)) + "_as");
    }

    AdSize(int width, int height, String formatString) {
        if (width < 0 && width != FULL_WIDTH) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + width);
        } else if (height >= 0 || height == AUTO_HEIGHT) {
            this.f23w = width;
            this.f22v = height;
            this.kC = formatString;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + height);
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        return this.f23w == adSize.f23w && this.f22v == adSize.f22v && this.kC.equals(adSize.kC);
    }

    public int getHeight() {
        return this.f22v;
    }

    public int getHeightInPixels(Context context) {
        return this.f22v == AUTO_HEIGHT ? ab.m1634b(context.getResources().getDisplayMetrics()) : cz.m556a(context, this.f22v);
    }

    public int getWidth() {
        return this.f23w;
    }

    public int getWidthInPixels(Context context) {
        return this.f23w == FULL_WIDTH ? ab.m1633a(context.getResources().getDisplayMetrics()) : cz.m556a(context, this.f23w);
    }

    public int hashCode() {
        return this.kC.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f22v == AUTO_HEIGHT;
    }

    public boolean isFullWidth() {
        return this.f23w == FULL_WIDTH;
    }

    public String toString() {
        return this.kC;
    }
}
