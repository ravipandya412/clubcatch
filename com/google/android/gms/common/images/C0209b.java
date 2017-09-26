package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.common.images.b */
public class C0209b implements Creator<WebImage> {
    static void m185a(WebImage webImage, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, webImage.getVersionCode());
        C0212b.m234a(parcel, 2, webImage.getUrl(), i, false);
        C0212b.m246c(parcel, 3, webImage.getWidth());
        C0212b.m246c(parcel, 4, webImage.getHeight());
        C0212b.m226D(parcel, p);
    }

    public WebImage[] m186M(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m187l(x0);
    }

    public WebImage m187l(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            Uri uri2;
            int g;
            int n = C0211a.m209n(parcel);
            int i4;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0211a.m202g(parcel, n);
                    n = i4;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    n = i;
                    i = i4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0211a.m202g(parcel, n);
                    n = i4;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    n = C0211a.m202g(parcel, n);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    n = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m186M(x0);
    }
}
