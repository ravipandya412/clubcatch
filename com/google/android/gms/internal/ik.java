package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1009a;
import com.google.android.gms.plus.internal.C1013e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ik implements Moments {
    private final C0191b<C1013e> Rw;

    /* renamed from: com.google.android.gms.internal.ik.a */
    private static abstract class C1089a extends C1009a<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.ik.a.1 */
        class C09791 implements LoadMomentsResult {
            final /* synthetic */ C1089a RF;
            final /* synthetic */ Status vb;

            C09791(C1089a c1089a, Status status) {
                this.RF = c1089a;
                this.vb = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        C1089a(C0191b<C1013e> c0191b) {
            super(c0191b);
        }

        public LoadMomentsResult m3081M(Status status) {
            return new C09791(this, status);
        }

        public /* synthetic */ Result m3082d(Status status) {
            return m3081M(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.b */
    private static abstract class C1090b extends C1009a<Status> {
        C1090b(C0191b<C1013e> c0191b) {
            super(c0191b);
        }

        public /* synthetic */ Result m3083d(Status status) {
            return m3084f(status);
        }

        public Status m3084f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.c */
    private static abstract class C1091c extends C1009a<Status> {
        C1091c(C0191b<C1013e> c0191b) {
            super(c0191b);
        }

        public /* synthetic */ Result m3085d(Status status) {
            return m3086f(status);
        }

        public Status m3086f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.1 */
    class C11831 extends C1089a {
        final /* synthetic */ ik Ry;

        C11831(ik ikVar, C0191b c0191b) {
            this.Ry = ikVar;
            super(c0191b);
        }

        protected void m3288a(C1013e c1013e) {
            c1013e.m2841i(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.2 */
    class C11842 extends C1089a {
        final /* synthetic */ int HW;
        final /* synthetic */ Uri RA;
        final /* synthetic */ String RB;
        final /* synthetic */ String RC;
        final /* synthetic */ ik Ry;
        final /* synthetic */ String Rz;

        C11842(ik ikVar, C0191b c0191b, int i, String str, Uri uri, String str2, String str3) {
            this.Ry = ikVar;
            this.HW = i;
            this.Rz = str;
            this.RA = uri;
            this.RB = str2;
            this.RC = str3;
            super(c0191b);
        }

        protected void m3290a(C1013e c1013e) {
            c1013e.m2836a(this, this.HW, this.Rz, this.RA, this.RB, this.RC);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.3 */
    class C11853 extends C1091c {
        final /* synthetic */ Moment RD;
        final /* synthetic */ ik Ry;

        C11853(ik ikVar, C0191b c0191b, Moment moment) {
            this.Ry = ikVar;
            this.RD = moment;
            super(c0191b);
        }

        protected void m3292a(C1013e c1013e) {
            c1013e.m2837a((C0194c) this, this.RD);
        }
    }

    /* renamed from: com.google.android.gms.internal.ik.4 */
    class C11864 extends C1090b {
        final /* synthetic */ String RE;
        final /* synthetic */ ik Ry;

        C11864(ik ikVar, C0191b c0191b, String str) {
            this.Ry = ikVar;
            this.RE = str;
            super(c0191b);
        }

        protected void m3294a(C1013e c1013e) {
            c1013e.removeMoment(this.RE);
            m1514a(Status.zQ);
        }
    }

    public ik(C0191b<C1013e> c0191b) {
        this.Rw = c0191b;
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.m140a(new C11831(this, this.Rw));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.m140a(new C11842(this, this.Rw, maxResults, pageToken, targetUrl, type, userId));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.m141b(new C11864(this, this.Rw, momentId));
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.m141b(new C11853(this, this.Rw, moment));
    }
}
