package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bs extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final MediaController nB;
    private final C0289a nC;
    private final VideoView nD;
    private long nE;
    private String nF;
    private final dd ng;

    /* renamed from: com.google.android.gms.internal.bs.a */
    private static final class C0289a {
        private final Runnable kW;
        private volatile boolean nG;

        /* renamed from: com.google.android.gms.internal.bs.a.1 */
        class C02881 implements Runnable {
            private final WeakReference<bs> nH;
            final /* synthetic */ bs nI;
            final /* synthetic */ C0289a nJ;

            C02881(C0289a c0289a, bs bsVar) {
                this.nJ = c0289a;
                this.nI = bsVar;
                this.nH = new WeakReference(this.nI);
            }

            public void run() {
                bs bsVar = (bs) this.nH.get();
                if (!this.nJ.nG && bsVar != null) {
                    bsVar.az();
                    this.nJ.aA();
                }
            }
        }

        public C0289a(bs bsVar) {
            this.nG = false;
            this.kW = new C02881(this, bsVar);
        }

        public void aA() {
            cz.pT.postDelayed(this.kW, 250);
        }

        public void cancel() {
            this.nG = true;
            cz.pT.removeCallbacks(this.kW);
        }
    }

    public bs(Context context, dd ddVar) {
        super(context);
        this.ng = ddVar;
        this.nD = new VideoView(context);
        addView(this.nD, new LayoutParams(-1, -1, 17));
        this.nB = new MediaController(context);
        this.nC = new C0289a(this);
        this.nC.aA();
        this.nD.setOnCompletionListener(this);
        this.nD.setOnPreparedListener(this);
        this.nD.setOnErrorListener(this);
    }

    private static void m460a(dd ddVar, String str) {
        m463a(ddVar, str, new HashMap(1));
    }

    public static void m461a(dd ddVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m463a(ddVar, "error", hashMap);
    }

    private static void m462a(dd ddVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m463a(ddVar, str, hashMap);
    }

    private static void m463a(dd ddVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        ddVar.m579a("onVideoEvent", (Map) map);
    }

    public void ay() {
        if (TextUtils.isEmpty(this.nF)) {
            m461a(this.ng, "no_src", null);
        } else {
            this.nD.setVideoPath(this.nF);
        }
    }

    public void az() {
        long currentPosition = (long) this.nD.getCurrentPosition();
        if (this.nE != currentPosition) {
            m462a(this.ng, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.nE = currentPosition;
        }
    }

    public void m464b(MotionEvent motionEvent) {
        this.nD.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.nC.cancel();
        this.nD.stopPlayback();
    }

    public void m465i(boolean z) {
        if (z) {
            this.nD.setMediaController(this.nB);
            return;
        }
        this.nB.hide();
        this.nD.setMediaController(null);
    }

    public void m466o(String str) {
        this.nF = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m460a(this.ng, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m461a(this.ng, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m462a(this.ng, "canplaythrough", "duration", String.valueOf(((float) this.nD.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.nD.pause();
    }

    public void play() {
        this.nD.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.nD.seekTo(timeInMilliseconds);
    }
}
