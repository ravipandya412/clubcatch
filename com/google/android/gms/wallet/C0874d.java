package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C0874d implements SafeParcelable {
    public static final Creator<C0874d> CREATOR;
    LoyaltyWalletObject Yj;
    private final int wj;

    static {
        CREATOR = new C0480e();
    }

    C0874d() {
        this.wj = 1;
    }

    C0874d(int i, LoyaltyWalletObject loyaltyWalletObject) {
        this.wj = i;
        this.Yj = loyaltyWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0480e.m1380a(this, dest, flags);
    }
}
