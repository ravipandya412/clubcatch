package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0195a.C0194c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0416i;
import com.google.android.gms.plus.internal.C1013e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1013e QN;

    @Deprecated
    public static class Builder {
        private final ConnectionCallbacks QS;
        private final OnConnectionFailedListener QT;
        private final C0416i QU;
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.QS = connectionCallbacks;
            this.QT = connectionFailedListener;
            this.QU = new C0416i(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new C1013e(this.mContext, this.QS, this.QT, this.QU.hA()));
        }

        public Builder clearScopes() {
            this.QU.hz();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.QU.aS(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.QU.m1211f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.QU.m1210e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.1 */
    class C08131 implements C0194c<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener QO;
        final /* synthetic */ PlusClient QP;

        C08131(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.QP = plusClient;
            this.QO = onMomentsLoadedListener;
        }

        public void m2188a(LoadMomentsResult loadMomentsResult) {
            this.QO.onMomentsLoaded(loadMomentsResult.getStatus().dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m2189b(Object obj) {
            m2188a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.2 */
    class C08142 implements C0194c<LoadMomentsResult> {
        final /* synthetic */ OnMomentsLoadedListener QO;
        final /* synthetic */ PlusClient QP;

        C08142(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.QP = plusClient;
            this.QO = onMomentsLoadedListener;
        }

        public void m2190a(LoadMomentsResult loadMomentsResult) {
            this.QO.onMomentsLoaded(loadMomentsResult.getStatus().dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m2191b(Object obj) {
            m2190a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.3 */
    class C08153 implements C0194c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C08153(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2192a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2193b(Object obj) {
            m2192a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.4 */
    class C08164 implements C0194c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C08164(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2194a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2195b(Object obj) {
            m2194a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.5 */
    class C08175 implements C0194c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C08175(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2196a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2197b(Object obj) {
            m2196a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.6 */
    class C08186 implements C0194c<LoadPeopleResult> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnPeopleLoadedListener QQ;

        C08186(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.QP = plusClient;
            this.QQ = onPeopleLoadedListener;
        }

        public void m2198a(LoadPeopleResult loadPeopleResult) {
            this.QQ.onPeopleLoaded(loadPeopleResult.getStatus().dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m2199b(Object obj) {
            m2198a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.7 */
    class C08197 implements C0194c<Status> {
        final /* synthetic */ PlusClient QP;
        final /* synthetic */ OnAccessRevokedListener QR;

        C08197(PlusClient plusClient, OnAccessRevokedListener onAccessRevokedListener) {
            this.QP = plusClient;
            this.QR = onAccessRevokedListener;
        }

        public void m2200K(Status status) {
            this.QR.onAccessRevoked(status.getStatus().dG());
        }

        public /* synthetic */ void m2201b(Object obj) {
            m2200K((Status) obj);
        }
    }

    PlusClient(C1013e plusClientImpl) {
        this.QN = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.QN.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.QN.connect();
    }

    @Deprecated
    public void disconnect() {
        this.QN.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.QN.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.QN.getCurrentPerson();
    }

    C1013e hj() {
        return this.QN;
    }

    @Deprecated
    public boolean isConnected() {
        return this.QN.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.QN.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.QN.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.QN.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener) {
        this.QN.m2841i(new C08131(this, listener));
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.QN.m2836a(new C08142(this, listener), maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.QN.m2838a(new C08175(this, listener), (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.QN.m2840c(new C08186(this, listener), personIds);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.QN.m2835a(new C08153(this, listener), orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.QN.m2842i(new C08164(this, listener), pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.QN.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QN.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.QN.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.QN.m2844k(new C08197(this, listener));
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.QN.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.QN.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.QN.m2837a(null, moment);
    }
}
