package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0250a<T extends LifecycleDelegate> {
    private T Fp;
    private Bundle Fq;
    private LinkedList<C0249a> Fr;
    private final C0252d<T> Fs;

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    static class C02485 implements OnClickListener {
        final /* synthetic */ int FA;
        final /* synthetic */ Context os;

        C02485(Context context, int i) {
            this.os = context;
            this.FA = i;
        }

        public void onClick(View v) {
            this.os.startActivity(GooglePlayServicesUtil.m125a(this.os, this.FA, -1));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C0249a {
        void m352b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C06171 implements C0252d<T> {
        final /* synthetic */ C0250a Ft;

        C06171(C0250a c0250a) {
            this.Ft = c0250a;
        }

        public void m1623a(T t) {
            this.Ft.Fp = t;
            Iterator it = this.Ft.Fr.iterator();
            while (it.hasNext()) {
                ((C0249a) it.next()).m352b(this.Ft.Fp);
            }
            this.Ft.Fr.clear();
            this.Ft.Fq = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C06182 implements C0249a {
        final /* synthetic */ C0250a Ft;
        final /* synthetic */ Activity Fu;
        final /* synthetic */ Bundle Fv;
        final /* synthetic */ Bundle Fw;

        C06182(C0250a c0250a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.Ft = c0250a;
            this.Fu = activity;
            this.Fv = bundle;
            this.Fw = bundle2;
        }

        public void m1624b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onInflate(this.Fu, this.Fv, this.Fw);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C06193 implements C0249a {
        final /* synthetic */ C0250a Ft;
        final /* synthetic */ Bundle Fw;

        C06193(C0250a c0250a, Bundle bundle) {
            this.Ft = c0250a;
            this.Fw = bundle;
        }

        public void m1625b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onCreate(this.Fw);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C06204 implements C0249a {
        final /* synthetic */ C0250a Ft;
        final /* synthetic */ Bundle Fw;
        final /* synthetic */ FrameLayout Fx;
        final /* synthetic */ LayoutInflater Fy;
        final /* synthetic */ ViewGroup Fz;

        C06204(C0250a c0250a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Ft = c0250a;
            this.Fx = frameLayout;
            this.Fy = layoutInflater;
            this.Fz = viewGroup;
            this.Fw = bundle;
        }

        public void m1626b(LifecycleDelegate lifecycleDelegate) {
            this.Fx.removeAllViews();
            this.Fx.addView(this.Ft.Fp.onCreateView(this.Fy, this.Fz, this.Fw));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C06216 implements C0249a {
        final /* synthetic */ C0250a Ft;

        C06216(C0250a c0250a) {
            this.Ft = c0250a;
        }

        public void m1627b(LifecycleDelegate lifecycleDelegate) {
            this.Ft.Fp.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    public C0250a() {
        this.Fs = new C06171(this);
    }

    private void m356a(Bundle bundle, C0249a c0249a) {
        if (this.Fp != null) {
            c0249a.m352b(this.Fp);
            return;
        }
        if (this.Fr == null) {
            this.Fr = new LinkedList();
        }
        this.Fr.add(c0249a);
        if (bundle != null) {
            if (this.Fq == null) {
                this.Fq = (Bundle) bundle.clone();
            } else {
                this.Fq.putAll(bundle);
            }
        }
        m360a(this.Fs);
    }

    private void aO(int i) {
        while (!this.Fr.isEmpty() && ((C0249a) this.Fr.getLast()).getState() >= i) {
            this.Fr.removeLast();
        }
    }

    public static void m358b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.m130b(context, isGooglePlayServicesAvailable, -1);
        CharSequence b2 = GooglePlayServicesUtil.m129b(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (b2 != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(b2);
            linearLayout.addView(button);
            button.setOnClickListener(new C02485(context, isGooglePlayServicesAvailable));
        }
    }

    protected void m359a(FrameLayout frameLayout) {
        C0250a.m358b(frameLayout);
    }

    protected abstract void m360a(C0252d<T> c0252d);

    public T fj() {
        return this.Fp;
    }

    public void onCreate(Bundle savedInstanceState) {
        m356a(savedInstanceState, new C06193(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        m356a(savedInstanceState, new C06204(this, frameLayout, inflater, container, savedInstanceState));
        if (this.Fp == null) {
            m359a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Fp != null) {
            this.Fp.onDestroy();
        } else {
            aO(1);
        }
    }

    public void onDestroyView() {
        if (this.Fp != null) {
            this.Fp.onDestroyView();
        } else {
            aO(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        m356a(savedInstanceState, new C06182(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.Fp != null) {
            this.Fp.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Fp != null) {
            this.Fp.onPause();
        } else {
            aO(5);
        }
    }

    public void onResume() {
        m356a(null, new C06216(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Fp != null) {
            this.Fp.onSaveInstanceState(outState);
        } else if (this.Fq != null) {
            outState.putAll(this.Fq);
        }
    }
}
