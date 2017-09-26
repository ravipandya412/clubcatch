package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fr;
import com.google.android.gms.location.DetectedActivity;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public final class C0208a {
    final C0207a AF;
    private int AG;
    private int AH;
    int AI;
    private int AJ;
    private WeakReference<OnImageLoadedListener> AK;
    private WeakReference<ImageView> AL;
    private WeakReference<TextView> AM;
    private int AN;
    private boolean AO;
    private boolean AP;
    private int AQ;

    /* renamed from: com.google.android.gms.common.images.a.a */
    public static final class C0207a {
        public final Uri uri;

        public C0207a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0207a) {
                return this == obj || ((C0207a) obj).hashCode() == hashCode();
            } else {
                return false;
            }
        }

        public int hashCode() {
            return ep.hashCode(this.uri);
        }
    }

    public C0208a(int i) {
        this.AG = 0;
        this.AH = 0;
        this.AN = -1;
        this.AO = true;
        this.AP = false;
        this.AF = new C0207a(null);
        this.AH = i;
    }

    public C0208a(Uri uri) {
        this.AG = 0;
        this.AH = 0;
        this.AN = -1;
        this.AO = true;
        this.AP = false;
        this.AF = new C0207a(uri);
        this.AH = 0;
    }

    private ea m174a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof ea) {
            drawable = ((ea) drawable).dO();
        }
        return new ea(drawable, drawable2);
    }

    private void m175a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        switch (this.AI) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                if (!z2) {
                    OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.AK.get();
                    if (onImageLoadedListener != null) {
                        onImageLoadedListener.onImageLoaded(this.AF.uri, drawable, z3);
                    }
                }
            case DetectedActivity.ON_FOOT /*2*/:
                ImageView imageView = (ImageView) this.AL.get();
                if (imageView != null) {
                    m176a(imageView, drawable, z, z2, z3);
                }
            case DetectedActivity.STILL /*3*/:
                TextView textView = (TextView) this.AM.get();
                if (textView != null) {
                    m177a(textView, this.AN, drawable, z, z2);
                }
            default:
        }
    }

    private void m176a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
        Object obj = (z2 || z3) ? null : 1;
        if (obj != null && (imageView instanceof ec)) {
            int dQ = ((ec) imageView).dQ();
            if (this.AH != 0 && dQ == this.AH) {
                return;
            }
        }
        boolean b = m178b(z, z2);
        Drawable a = b ? m174a(imageView.getDrawable(), drawable) : drawable;
        imageView.setImageDrawable(a);
        if (imageView instanceof ec) {
            ec ecVar = (ec) imageView;
            ecVar.m663d(z3 ? this.AF.uri : null);
            ecVar.m662N(obj != null ? this.AH : 0);
        }
        if (b) {
            ((ea) a).startTransition(250);
        }
    }

    private void m177a(TextView textView, int i, Drawable drawable, boolean z, boolean z2) {
        boolean b = m178b(z, z2);
        Drawable[] compoundDrawablesRelative = fr.eO() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable a = b ? m174a(compoundDrawablesRelative[i], drawable) : drawable;
        Drawable drawable2 = i == 0 ? a : compoundDrawablesRelative[0];
        Drawable drawable3 = i == 1 ? a : compoundDrawablesRelative[1];
        Drawable drawable4 = i == 2 ? a : compoundDrawablesRelative[2];
        Drawable drawable5 = i == 3 ? a : compoundDrawablesRelative[3];
        if (fr.eO()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        }
        if (b) {
            ((ea) a).startTransition(250);
        }
    }

    private boolean m178b(boolean z, boolean z2) {
        return this.AO && !z2 && (!z || this.AP);
    }

    public void m179L(int i) {
        this.AH = i;
    }

    void m180a(Context context, Bitmap bitmap, boolean z) {
        ed.m665d(bitmap);
        if ((this.AQ & 1) != 0) {
            bitmap = eb.m659a(bitmap);
        }
        m175a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    public void m181a(ImageView imageView) {
        ed.m665d(imageView);
        this.AK = null;
        this.AL = new WeakReference(imageView);
        this.AM = null;
        this.AN = -1;
        this.AI = 2;
        this.AJ = imageView.hashCode();
    }

    public void m182a(OnImageLoadedListener onImageLoadedListener) {
        ed.m665d(onImageLoadedListener);
        this.AK = new WeakReference(onImageLoadedListener);
        this.AL = null;
        this.AM = null;
        this.AN = -1;
        this.AI = 1;
        this.AJ = ep.hashCode(onImageLoadedListener, this.AF);
    }

    void m183b(Context context, boolean z) {
        Drawable drawable = null;
        if (this.AH != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.AH);
            if ((this.AQ & 1) != 0) {
                drawable = eb.m661a(resources, drawable);
            }
        }
        m175a(drawable, z, false, false);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0208a) {
            return this == obj || ((C0208a) obj).hashCode() == hashCode();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.AJ;
    }

    void m184x(Context context) {
        Drawable drawable = null;
        if (this.AG != 0) {
            Resources resources = context.getResources();
            drawable = resources.getDrawable(this.AG);
            if ((this.AQ & 1) != 0) {
                drawable = eb.m661a(resources, drawable);
            }
        }
        m175a(drawable, false, true, false);
    }
}
