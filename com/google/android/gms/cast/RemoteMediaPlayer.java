package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C0891a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final Object mg;
    private final dv xg;
    private final C0590a xh;
    private OnMetadataUpdatedListener xi;
    private OnStatusUpdatedListener xj;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a */
    private class C0590a implements dw {
        final /* synthetic */ RemoteMediaPlayer xk;
        private GoogleApiClient xu;
        private long xv;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a.a */
        private final class C0589a implements ResultCallback<Status> {
            private final long xw;
            final /* synthetic */ C0590a xx;

            C0589a(C0590a c0590a, long j) {
                this.xx = c0590a;
                this.xw = j;
            }

            public void m1502i(Status status) {
                if (!status.isSuccess()) {
                    this.xx.xk.xg.m1758a(this.xw, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m1502i((Status) x0);
            }
        }

        public C0590a(RemoteMediaPlayer remoteMediaPlayer) {
            this.xk = remoteMediaPlayer;
            this.xv = 0;
        }

        public void m1503a(String str, String str2, long j, String str3) throws IOException {
            if (this.xu == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.xu, str, str2).setResultCallback(new C0589a(this, j));
        }

        public void m1504b(GoogleApiClient googleApiClient) {
            this.xu = googleApiClient;
        }

        public long cV() {
            long j = this.xv + 1;
            this.xv = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C08931 extends dv {
        final /* synthetic */ RemoteMediaPlayer xk;

        C08931(RemoteMediaPlayer remoteMediaPlayer) {
            this.xk = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.xk.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.xk.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.c */
    private static final class C0895c implements MediaChannelResult {
        private final Status vl;
        private final JSONObject wP;

        C0895c(Status status, JSONObject jSONObject) {
            this.vl = status;
            this.wP = jSONObject;
        }

        public Status getStatus() {
            return this.vl;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b */
    private static abstract class C1025b extends C0891a<MediaChannelResult> {
        dx xy;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.1 */
        class C05911 implements dx {
            final /* synthetic */ C1025b xz;

            C05911(C1025b c1025b) {
                this.xz = c1025b;
            }

            public void m1505a(long j, int i, JSONObject jSONObject) {
                this.xz.m1514a(new C0895c(new Status(i), jSONObject));
            }

            public void m1506k(long j) {
                this.xz.m1514a(this.xz.m2901j(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.2 */
        class C08942 implements MediaChannelResult {
            final /* synthetic */ Status vb;
            final /* synthetic */ C1025b xz;

            C08942(C1025b c1025b, Status status) {
                this.xz = c1025b;
                this.vb = status;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        C1025b() {
            this.xy = new C05911(this);
        }

        public /* synthetic */ Result m2900d(Status status) {
            return m2901j(status);
        }

        public MediaChannelResult m2901j(Status status) {
            return new C08942(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C11222 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ MediaInfo xm;
        final /* synthetic */ boolean xn;
        final /* synthetic */ long xo;
        final /* synthetic */ JSONObject xp;

        C11222(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xm = mediaInfo;
            this.xn = z;
            this.xo = j;
            this.xp = jSONObject;
        }

        protected void m3154a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1755a(this.xy, this.xm, this.xn, this.xo, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C11233 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C11233(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3156a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1756a(this.xy, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C11244 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C11244(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3158a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1759b(this.xy, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C11255 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;

        C11255(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xp = jSONObject;
        }

        protected void m3160a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1760c(this.xy, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C11266 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ long xq;
        final /* synthetic */ int xr;

        C11266(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xq = j;
            this.xr = i;
            this.xp = jSONObject;
        }

        protected void m3162a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1754a(this.xy, this.xq, this.xr, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C11277 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ double xs;

        C11277(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xs = d;
            this.xp = jSONObject;
        }

        protected void m3164a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1753a(this.xy, this.xs, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IllegalStateException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (IllegalArgumentException e2) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (IOException e3) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C11288 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;
        final /* synthetic */ JSONObject xp;
        final /* synthetic */ boolean xt;

        C11288(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
            this.xt = z;
            this.xp = jSONObject;
        }

        protected void m3166a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1757a(this.xy, this.xt, this.xp);
                    this.xk.xh.m1504b(null);
                } catch (IllegalStateException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (IOException e2) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C11299 extends C1025b {
        final /* synthetic */ RemoteMediaPlayer xk;
        final /* synthetic */ GoogleApiClient xl;

        C11299(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
            this.xk = remoteMediaPlayer;
            this.xl = googleApiClient;
        }

        protected void m3168a(dq dqVar) {
            synchronized (this.xk.mg) {
                this.xk.xh.m1504b(this.xl);
                try {
                    this.xk.xg.m1752a(this.xy);
                    this.xk.xh.m1504b(null);
                } catch (IOException e) {
                    m1514a(m2901j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.xk.xh.m1504b(null);
                } catch (Throwable th) {
                    this.xk.xh.m1504b(null);
                }
            }
        }
    }

    public RemoteMediaPlayer() {
        this.mg = new Object();
        this.xh = new C0590a(this);
        this.xg = new C08931(this);
        this.xg.m613a(this.xh);
    }

    private void onMetadataUpdated() {
        if (this.xi != null) {
            this.xi.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.xj != null) {
            this.xj.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mg) {
            approximateStreamPosition = this.xg.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mg) {
            mediaInfo = this.xg.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mg) {
            mediaStatus = this.xg.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.xg.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mg) {
            streamDuration = this.xg.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return apiClient.m141b(new C11222(this, apiClient, mediaInfo, autoplay, playPosition, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.xg.m1751P(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m141b(new C11233(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m141b(new C11255(this, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient apiClient) {
        return apiClient.m141b(new C11299(this, apiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.m141b(new C11266(this, apiClient, position, resumeState, customData));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.xi = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.xj = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.m141b(new C11288(this, apiClient, muteState, customData));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.m141b(new C11277(this, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m141b(new C11244(this, apiClient, customData));
    }
}
