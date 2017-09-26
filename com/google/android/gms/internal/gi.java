package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0917a;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class gi implements Invitations {

    /* renamed from: com.google.android.gms.internal.gi.a */
    private static abstract class C1073a extends C0917a<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.internal.gi.a.1 */
        class C09601 implements LoadInvitationsResult {
            final /* synthetic */ C1073a HR;
            final /* synthetic */ Status vb;

            C09601(C1073a c1073a, Status status) {
                this.HR = c1073a;
                this.vb = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1073a() {
        }

        public /* synthetic */ Result m3048d(Status status) {
            return m3049v(status);
        }

        public LoadInvitationsResult m3049v(Status status) {
            return new C09601(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gi.1 */
    class C11561 extends C1073a {
        final /* synthetic */ int HP;
        final /* synthetic */ gi HQ;

        C11561(gi giVar, int i) {
            this.HQ = giVar;
            this.HP = i;
            super();
        }

        protected void m3232a(fx fxVar) {
            fxVar.m2704c((C0194c) this, this.HP);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fu();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, int sortOrder) {
        return apiClient.m140a(new C11561(this, sortOrder));
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m364c(apiClient).m2689a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m364c(apiClient).fv();
    }
}
