package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1009a;
import com.google.android.gms.plus.internal.C1013e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class il implements People {
    private final C0191b<C1013e> Rw;

    /* renamed from: com.google.android.gms.internal.il.a */
    private static abstract class C1092a extends C1009a<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.il.a.1 */
        class C09801 implements LoadPeopleResult {
            final /* synthetic */ C1092a RK;
            final /* synthetic */ Status vb;

            C09801(C1092a c1092a, Status status) {
                this.RK = c1092a;
                this.vb = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        C1092a(C0191b<C1013e> c0191b) {
            super(c0191b);
        }

        public LoadPeopleResult m3087N(Status status) {
            return new C09801(this, status);
        }

        public /* synthetic */ Result m3088d(Status status) {
            return m3087N(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.1 */
    class C11871 extends C1092a {
        final /* synthetic */ int RG;
        final /* synthetic */ il RH;
        final /* synthetic */ String Rz;

        C11871(il ilVar, C0191b c0191b, int i, String str) {
            this.RH = ilVar;
            this.RG = i;
            this.Rz = str;
            super(c0191b);
        }

        protected void m3296a(C1013e c1013e) {
            c1013e.m2835a((C0194c) this, this.RG, this.Rz);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.2 */
    class C11882 extends C1092a {
        final /* synthetic */ il RH;
        final /* synthetic */ String Rz;

        C11882(il ilVar, C0191b c0191b, String str) {
            this.RH = ilVar;
            this.Rz = str;
            super(c0191b);
        }

        protected void m3298a(C1013e c1013e) {
            c1013e.m2842i(this, this.Rz);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.3 */
    class C11893 extends C1092a {
        final /* synthetic */ il RH;

        C11893(il ilVar, C0191b c0191b) {
            this.RH = ilVar;
            super(c0191b);
        }

        protected void m3300a(C1013e c1013e) {
            c1013e.m2843j(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.4 */
    class C11904 extends C1092a {
        final /* synthetic */ il RH;
        final /* synthetic */ Collection RI;

        C11904(il ilVar, C0191b c0191b, Collection collection) {
            this.RH = ilVar;
            this.RI = collection;
            super(c0191b);
        }

        protected void m3302a(C1013e c1013e) {
            c1013e.m2838a((C0194c) this, this.RI);
        }
    }

    /* renamed from: com.google.android.gms.internal.il.5 */
    class C11915 extends C1092a {
        final /* synthetic */ il RH;
        final /* synthetic */ String[] RJ;

        C11915(il ilVar, C0191b c0191b, String[] strArr) {
            this.RH = ilVar;
            this.RJ = strArr;
            super(c0191b);
        }

        protected void m3304a(C1013e c1013e) {
            c1013e.m2840c(this, this.RJ);
        }
    }

    public il(C0191b<C1013e> c0191b) {
        this.Rw = c0191b;
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m1178a(googleApiClient, this.Rw).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> personIds) {
        return googleApiClient.m140a(new C11904(this, this.Rw, personIds));
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.m140a(new C11915(this, this.Rw, personIds));
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.m140a(new C11893(this, this.Rw));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.m140a(new C11871(this, this.Rw, orderBy, pageToken));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.m140a(new C11882(this, this.Rw, pageToken));
    }
}
