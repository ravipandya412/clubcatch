package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0143R;
import com.google.android.gms.location.DetectedActivity;

public final class et extends Button {
    public et(Context context) {
        this(context, null);
    }

    public et(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int m728b(int i, int i2, int i3) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return i2;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m729b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                b = m728b(i2, C0143R.drawable.common_signin_btn_text_dark, C0143R.drawable.common_signin_btn_text_light);
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                b = m728b(i2, C0143R.drawable.common_signin_btn_icon_dark, C0143R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    private void m730c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m731c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m728b(i2, C0143R.color.common_signin_btn_text_dark, C0143R.color.common_signin_btn_text_light)));
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                setText(resources.getString(C0143R.string.common_signin_button_text));
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                setText(resources.getString(C0143R.string.common_signin_button_text_long));
            case DetectedActivity.ON_FOOT /*2*/:
                setText(null);
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void m732a(Resources resources, int i, int i2) {
        boolean z = true;
        boolean z2 = i >= 0 && i < 3;
        er.m721a(z2, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        er.m721a(z, "Unknown color scheme " + i2);
        m730c(resources);
        m729b(resources, i, i2);
        m731c(resources, i, i2);
    }
}
