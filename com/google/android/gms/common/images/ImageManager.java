package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0208a.C0207a;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ev;
import com.google.android.gms.internal.fr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object Ar;
    private static HashSet<Uri> As;
    private static ImageManager At;
    private static ImageManager Au;
    private final ExecutorService Av;
    private final C0600b Aw;
    private final Map<C0208a, ImageReceiver> Ax;
    private final Map<Uri, ImageReceiver> Ay;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        boolean AA;
        final /* synthetic */ ImageManager AB;
        private final ArrayList<C0208a> Az;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.AB = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.AA = false;
            this.mUri = uri;
            this.Az = new ArrayList();
        }

        public void m158c(C0208a c0208a) {
            ed.m664a(!this.AA, "Cannot add an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Az.add(c0208a);
        }

        public void m159d(C0208a c0208a) {
            ed.m664a(!this.AA, "Cannot remove an ImageRequest when mHandlingRequests is true");
            ed.ac("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Az.remove(c0208a);
        }

        public void dN() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.AB.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.AB.Av.execute(new C0203c(this.AB, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.a */
    private static final class C0202a {
        static int m160a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.c */
    private final class C0203c implements Runnable {
        final /* synthetic */ ImageManager AB;
        private final ParcelFileDescriptor AC;
        private final Uri mUri;

        public C0203c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.AB = imageManager;
            this.mUri = uri;
            this.AC = parcelFileDescriptor;
        }

        public void run() {
            ed.ad("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.AC != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.AC.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.AC.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.AB.mHandler.post(new C0206f(this.AB, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.d */
    private final class C0204d implements Runnable {
        final /* synthetic */ ImageManager AB;
        private final C0208a AD;

        public C0204d(ImageManager imageManager, C0208a c0208a) {
            this.AB = imageManager;
            this.AD = c0208a;
        }

        public void run() {
            ed.ac("LoadImageRunnable must be executed on the main thread");
            this.AB.m168b(this.AD);
            C0207a c0207a = this.AD.AF;
            if (c0207a.uri == null) {
                this.AD.m183b(this.AB.mContext, true);
                return;
            }
            Bitmap a = this.AB.m164a(c0207a);
            if (a != null) {
                this.AD.m180a(this.AB.mContext, a, true);
                return;
            }
            this.AD.m184x(this.AB.mContext);
            ImageReceiver imageReceiver = (ImageReceiver) this.AB.Ay.get(c0207a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.AB, c0207a.uri);
                this.AB.Ay.put(c0207a.uri, imageReceiver);
            }
            imageReceiver.m158c(this.AD);
            if (this.AD.AI != 1) {
                this.AB.Ax.put(this.AD, imageReceiver);
            }
            synchronized (ImageManager.Ar) {
                if (!ImageManager.As.contains(c0207a.uri)) {
                    ImageManager.As.add(c0207a.uri);
                    imageReceiver.dN();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.e */
    private static final class C0205e implements ComponentCallbacks2 {
        private final C0600b Aw;

        public C0205e(C0600b c0600b) {
            this.Aw = c0600b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Aw.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Aw.evictAll();
            } else if (level >= 20) {
                this.Aw.trimToSize(this.Aw.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.f */
    private final class C0206f implements Runnable {
        final /* synthetic */ ImageManager AB;
        private boolean AE;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zf;

        public C0206f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.AB = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.AE = z;
            this.zf = countDownLatch;
        }

        private void m161a(ImageReceiver imageReceiver, boolean z) {
            imageReceiver.AA = true;
            ArrayList a = imageReceiver.Az;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0208a c0208a = (C0208a) a.get(i);
                if (z) {
                    c0208a.m180a(this.AB.mContext, this.mBitmap, false);
                } else {
                    c0208a.m183b(this.AB.mContext, false);
                }
                if (c0208a.AI != 1) {
                    this.AB.Ax.remove(c0208a);
                }
            }
            imageReceiver.AA = false;
        }

        public void run() {
            ed.ac("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.AB.Aw != null) {
                if (this.AE) {
                    this.AB.Aw.evictAll();
                    System.gc();
                    this.AE = false;
                    this.AB.mHandler.post(this);
                    return;
                } else if (z) {
                    this.AB.Aw.put(new C0207a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.AB.Ay.remove(this.mUri);
            if (imageReceiver != null) {
                m161a(imageReceiver, z);
            }
            this.zf.countDown();
            synchronized (ImageManager.Ar) {
                ImageManager.As.remove(this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.b */
    private static final class C0600b extends ev<C0207a, Bitmap> {
        public C0600b(Context context) {
            super(C0600b.m1547w(context));
        }

        private static int m1547w(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !fr.eJ()) ? activityManager.getMemoryClass() : C0202a.m160a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        protected int m1548a(C0207a c0207a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m1549a(boolean z, C0207a c0207a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0207a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m1549a(x0, (C0207a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m1548a((C0207a) x0, (Bitmap) x1);
        }
    }

    static {
        Ar = new Object();
        As = new HashSet();
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Av = Executors.newFixedThreadPool(4);
        if (withMemoryCache) {
            this.Aw = new C0600b(this.mContext);
            if (fr.eM()) {
                dL();
            }
        } else {
            this.Aw = null;
        }
        this.Ax = new HashMap();
        this.Ay = new HashMap();
    }

    private Bitmap m164a(C0207a c0207a) {
        return this.Aw == null ? null : (Bitmap) this.Aw.get(c0207a);
    }

    public static ImageManager m165a(Context context, boolean z) {
        if (z) {
            if (Au == null) {
                Au = new ImageManager(context, true);
            }
            return Au;
        }
        if (At == null) {
            At = new ImageManager(context, false);
        }
        return At;
    }

    private boolean m168b(C0208a c0208a) {
        ed.ac("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (c0208a.AI == 1) {
            return true;
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.Ax.get(c0208a);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.AA) {
            return false;
        }
        this.Ax.remove(c0208a);
        imageReceiver.m159d(c0208a);
        return true;
    }

    public static ImageManager create(Context context) {
        return m165a(context, false);
    }

    private void dL() {
        this.mContext.registerComponentCallbacks(new C0205e(this.Aw));
    }

    public void m173a(C0208a c0208a) {
        ed.ac("ImageManager.loadImage() must be called in the main thread");
        boolean b = m168b(c0208a);
        Runnable c0204d = new C0204d(this, c0208a);
        if (b) {
            c0204d.run();
        } else {
            this.mHandler.post(c0204d);
        }
    }

    public void loadImage(ImageView imageView, int resId) {
        C0208a c0208a = new C0208a(resId);
        c0208a.m181a(imageView);
        m173a(c0208a);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        C0208a c0208a = new C0208a(uri);
        c0208a.m181a(imageView);
        m173a(c0208a);
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0208a c0208a = new C0208a(uri);
        c0208a.m179L(defaultResId);
        c0208a.m181a(imageView);
        m173a(c0208a);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        C0208a c0208a = new C0208a(uri);
        c0208a.m182a(listener);
        m173a(c0208a);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0208a c0208a = new C0208a(uri);
        c0208a.m179L(defaultResId);
        c0208a.m182a(listener);
        m173a(c0208a);
    }
}
