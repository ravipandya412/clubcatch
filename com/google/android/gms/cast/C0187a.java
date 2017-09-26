package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0187a implements Creator<ApplicationMetadata> {
    static void m113a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, applicationMetadata.getVersionCode());
        C0212b.m236a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0212b.m236a(parcel, 3, applicationMetadata.getName(), false);
        C0212b.m245b(parcel, 4, applicationMetadata.getImages(), false);
        C0212b.m237a(parcel, 5, applicationMetadata.wm, false);
        C0212b.m236a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0212b.m234a(parcel, 7, applicationMetadata.cR(), i, false);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m114j(x0);
    }

    public ApplicationMetadata m114j(Parcel parcel) {
        Uri uri = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list2 = C0211a.m197c(parcel, n, WebImage.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0211a.m222y(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    uri = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m115w(x0);
    }

    public ApplicationMetadata[] m115w(int i) {
        return new ApplicationMetadata[i];
    }
}
