package com.google.android.gms.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0917a;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class go implements Requests {

    /* renamed from: com.google.android.gms.internal.go.a */
    private static abstract class C1079a extends C0917a<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.internal.go.a.1 */
        class C09661 implements LoadRequestsResult {
            final /* synthetic */ C1079a In;
            final /* synthetic */ Status vb;

            C09661(C1079a c1079a, Status status) {
                this.In = c1079a;
                this.vb = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return null;
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1079a() {
        }

        public LoadRequestsResult m3060B(Status status) {
            return new C09661(this, status);
        }

        public /* synthetic */ Result m3061d(Status status) {
            return m3060B(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.b */
    private static abstract class C1080b extends C0917a<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.internal.go.b.1 */
        class C09671 implements UpdateRequestsResult {
            final /* synthetic */ C1080b Io;
            final /* synthetic */ Status vb;

            C09671(C1080b c1080b, Status status) {
                this.Io = c1080b;
                this.vb = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1080b() {
        }

        public UpdateRequestsResult m3062C(Status status) {
            return new C09671(this, status);
        }

        public /* synthetic */ Result m3063d(Status status) {
            return m3062C(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.1 */
    class C11701 extends C1080b {
        final /* synthetic */ String[] Ij;
        final /* synthetic */ go Ik;

        C11701(go goVar, String[] strArr) {
            this.Ik = goVar;
            this.Ij = strArr;
            super();
        }

        protected void m3260a(fx fxVar) {
            fxVar.m2688a((C0194c) this, this.Ij);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.2 */
    class C11712 extends C1080b {
        final /* synthetic */ String[] Ij;
        final /* synthetic */ go Ik;

        C11712(go goVar, String[] strArr) {
            this.Ik = goVar;
            this.Ij = strArr;
            super();
        }

        protected void m3262a(fx fxVar) {
            fxVar.m2701b((C0194c) this, this.Ij);
        }
    }

    /* renamed from: com.google.android.gms.internal.go.3 */
    class C11723 extends C1079a {
        final /* synthetic */ int HP;
        final /* synthetic */ go Ik;
        final /* synthetic */ int Il;
        final /* synthetic */ int Im;

        C11723(go goVar, int i, int i2, int i3) {
            this.Ik = goVar;
            this.Il = i;
            this.Im = i2;
            this.HP = i3;
            super();
        }

        protected void m3264a(fx fxVar) {
            fxVar.m2672a((C0194c) this, this.Il, this.Im, this.HP);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m141b(new C11701(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.m141b(new C11712(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fD();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fF();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fE();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m364c(apiClient).m2668a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.m140a(new C11723(this, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m364c(apiClient).m2693a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m364c(apiClient).fx();
    }
}
