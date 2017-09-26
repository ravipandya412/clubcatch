package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dv extends dp {
    private static final long yi;
    private static final long yj;
    private static final long yk;
    private static final long yl;
    private final Handler mHandler;
    private long ym;
    private MediaStatus yn;
    private final dy yo;
    private final dy yp;
    private final dy yq;
    private final dy yr;
    private final dy ys;
    private final dy yt;
    private final dy yu;
    private final dy yv;
    private final Runnable yw;
    private boolean yx;

    /* renamed from: com.google.android.gms.internal.dv.a */
    private class C0323a implements Runnable {
        final /* synthetic */ dv yy;

        private C0323a(dv dvVar) {
            this.yy = dvVar;
        }

        public void run() {
            boolean z = false;
            this.yy.yx = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.yy.yo.m650d(elapsedRealtime, 3);
            this.yy.yp.m650d(elapsedRealtime, 3);
            this.yy.yq.m650d(elapsedRealtime, 3);
            this.yy.yr.m650d(elapsedRealtime, 3);
            this.yy.ys.m650d(elapsedRealtime, 3);
            this.yy.yt.m650d(elapsedRealtime, 3);
            this.yy.yu.m650d(elapsedRealtime, 3);
            this.yy.yv.m650d(elapsedRealtime, 3);
            synchronized (dy.yD) {
                if (this.yy.yo.dl() || this.yy.ys.dl() || this.yy.yt.dl() || this.yy.yu.dl() || this.yy.yv.dl()) {
                    z = true;
                }
            }
            this.yy.m1750u(z);
        }
    }

    static {
        yi = TimeUnit.HOURS.toMillis(24);
        yj = TimeUnit.HOURS.toMillis(24);
        yk = TimeUnit.HOURS.toMillis(24);
        yl = TimeUnit.SECONDS.toMillis(1);
    }

    public dv() {
        super("urn:x-cast:com.google.cast.media", "MediaControlChannel");
        this.mHandler = new Handler(Looper.getMainLooper());
        this.yw = new C0323a();
        this.yo = new dy(yj);
        this.yp = new dy(yi);
        this.yq = new dy(yi);
        this.yr = new dy(yi);
        this.ys = new dy(yk);
        this.yt = new dy(yi);
        this.yu = new dy(yi);
        this.yv = new dy(yi);
        dj();
    }

    private void m1740a(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean m = this.yo.m651m(j);
        int i2 = (!this.ys.dl() || this.ys.m651m(j)) ? 0 : 1;
        if ((!this.yt.dl() || this.yt.m651m(j)) && (!this.yu.dl() || this.yu.m651m(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (m || this.yn == null) {
            this.yn = new MediaStatus(jSONObject);
            this.ym = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.yn.m112a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        this.yo.m649c(j, 0);
        this.yp.m649c(j, 0);
        this.yq.m649c(j, 0);
        this.yr.m649c(j, 0);
        this.ys.m649c(j, 0);
        this.yt.m649c(j, 0);
        this.yu.m649c(j, 0);
        this.yv.m649c(j, 0);
    }

    private void dj() {
        m1750u(false);
        this.ym = 0;
        this.yn = null;
        this.yo.clear();
        this.ys.clear();
        this.yt.clear();
    }

    private void m1750u(boolean z) {
        if (this.yx != z) {
            this.yx = z;
            if (z) {
                this.mHandler.postDelayed(this.yw, yl);
            } else {
                this.mHandler.removeCallbacks(this.yw);
            }
        }
    }

    public final void m1751P(String str) {
        this.xB.m641b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray(NotificationCompatApi21.CATEGORY_STATUS);
                if (jSONArray.length() > 0) {
                    m1740a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.yn = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.yv.m649c(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.xB.m643d("received unexpected error: Invalid Player State.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.yo.m648b(optLong, 1, jSONObject);
                this.yp.m648b(optLong, 1, jSONObject);
                this.yq.m648b(optLong, 1, jSONObject);
                this.yr.m648b(optLong, 1, jSONObject);
                this.ys.m648b(optLong, 1, jSONObject);
                this.yt.m648b(optLong, 1, jSONObject);
                this.yu.m648b(optLong, 1, jSONObject);
                this.yv.m648b(optLong, 1, jSONObject);
            } else if (string.equals("LOAD_FAILED")) {
                this.yo.m648b(optLong, 1, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.yo.m648b(optLong, 2, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.xB.m643d("received unexpected error: Invalid Request.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.yo.m648b(optLong, 1, jSONObject);
                this.yp.m648b(optLong, 1, jSONObject);
                this.yq.m648b(optLong, 1, jSONObject);
                this.yr.m648b(optLong, 1, jSONObject);
                this.ys.m648b(optLong, 1, jSONObject);
                this.yt.m648b(optLong, 1, jSONObject);
                this.yu.m648b(optLong, 1, jSONObject);
                this.yv.m648b(optLong, 1, jSONObject);
            }
        } catch (JSONException e) {
            this.xB.m643d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long m1752a(dx dxVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long cW = cW();
        this.yv.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject.put("requestId", cW);
            jSONObject.put("type", "GET_STATUS");
            if (this.yn != null) {
                jSONObject.put("mediaSessionId", this.yn.cU());
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject.toString(), cW, null);
        return cW;
    }

    public long m1753a(dx dxVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yt.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", cU());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long m1754a(dx dxVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.ys.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", cU());
            jSONObject2.put("currentTime", dr.m617l(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long m1755a(dx dxVar, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yo.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.cT());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", dr.m617l(j));
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long m1756a(dx dxVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yp.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long m1757a(dx dxVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yu.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", cU());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public void m1758a(long j, int i) {
        this.yo.m649c(j, i);
        this.yp.m649c(j, i);
        this.yq.m649c(j, i);
        this.yr.m649c(j, i);
        this.ys.m649c(j, i);
        this.yt.m649c(j, i);
        this.yu.m649c(j, i);
        this.yv.m649c(j, i);
    }

    public long m1759b(dx dxVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yr.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long m1760c(dx dxVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = cW();
        this.yq.m647a(cW, dxVar);
        m1750u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m614a(jSONObject2.toString(), cW, null);
        return cW;
    }

    public long cU() throws IllegalStateException {
        if (this.yn != null) {
            return this.yn.cU();
        }
        throw new IllegalStateException("No current media session");
    }

    public void cX() {
        dj();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.ym == 0) {
            return 0;
        }
        double playbackRate = this.yn.getPlaybackRate();
        long streamPosition = this.yn.getStreamPosition();
        int playerState = this.yn.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.ym;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.yn == null ? null : this.yn.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.yn;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }
}
