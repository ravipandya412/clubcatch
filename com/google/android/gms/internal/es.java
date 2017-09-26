package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0254e;
import com.google.android.gms.dynamic.C0254e.C0253a;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.eo.C0682a;

public final class es extends C0254e<eo> {
    private static final es Cg;

    static {
        Cg = new es();
    }

    private es() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m1812d(Context context, int i, int i2) throws C0253a {
        return Cg.m1813e(context, i, i2);
    }

    private View m1813e(Context context, int i, int i2) throws C0253a {
        try {
            return (View) C0916c.m2414b(((eo) m363z(context)).m715a(C0916c.m2415h(context), i, i2));
        } catch (Throwable e) {
            throw new C0253a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public eo m1814B(IBinder iBinder) {
        return C0682a.m1811A(iBinder);
    }

    public /* synthetic */ Object m1815d(IBinder iBinder) {
        return m1814B(iBinder);
    }
}
