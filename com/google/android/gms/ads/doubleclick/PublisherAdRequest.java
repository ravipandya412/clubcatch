package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.aj.C0271a;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final aj kA;

    public static final class Builder {
        private final C0271a kB;

        public Builder() {
            this.kB = new C0271a();
        }

        public Builder addKeyword(String keyword) {
            this.kB.m414g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.kB.m409a(networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.kB.m415h(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.kB.m410a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.kB.m416i(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.kB.m411d(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.kB.m408a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.kB.m412d(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.kB.m417j(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.kB.m413e(tagForChildDirectedTreatment);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = aj.DEVICE_ID_EMULATOR;
    }

    private PublisherAdRequest(Builder builder) {
        this.kA = new aj(builder.kB);
    }

    aj m23N() {
        return this.kA;
    }

    public Date getBirthday() {
        return this.kA.getBirthday();
    }

    public String getContentUrl() {
        return this.kA.getContentUrl();
    }

    public int getGender() {
        return this.kA.getGender();
    }

    public Set<String> getKeywords() {
        return this.kA.getKeywords();
    }

    public Location getLocation() {
        return this.kA.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.kA.getManualImpressionsEnabled();
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.kA.getNetworkExtras(networkExtrasClass);
    }

    public String getPublisherProvidedId() {
        return this.kA.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.kA.isTestDevice(context);
    }
}
