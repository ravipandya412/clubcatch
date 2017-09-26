package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.internal.er;

/* renamed from: com.google.android.gms.common.b */
public class C0897b extends DialogFragment {
    private Dialog mDialog;
    private OnCancelListener yK;

    public C0897b() {
        this.mDialog = null;
        this.yK = null;
    }

    public static C0897b m2380a(Dialog dialog, OnCancelListener onCancelListener) {
        C0897b c0897b = new C0897b();
        Dialog dialog2 = (Dialog) er.m723b((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0897b.mDialog = dialog2;
        if (onCancelListener != null) {
            c0897b.yK = onCancelListener;
        }
        return c0897b;
    }

    public void onCancel(DialogInterface dialog) {
        if (this.yK != null) {
            this.yK.onCancel(dialog);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return this.mDialog;
    }

    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
}
