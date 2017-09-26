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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

public final class gf implements Achievements {

    /* renamed from: com.google.android.gms.internal.gf.a */
    private static abstract class C1070a extends C0917a<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.internal.gf.a.1 */
        class C09571 implements LoadAchievementsResult {
            final /* synthetic */ C1070a HL;
            final /* synthetic */ Status vb;

            C09571(C1070a c1070a, Status status) {
                this.HL = c1070a;
                this.vb = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.vb;
            }

            public void release() {
            }
        }

        private C1070a() {
        }

        public /* synthetic */ Result m3041d(Status status) {
            return m3042s(status);
        }

        public LoadAchievementsResult m3042s(Status status) {
            return new C09571(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.b */
    private static abstract class C1071b extends C0917a<UpdateAchievementResult> {
        private final String uS;

        /* renamed from: com.google.android.gms.internal.gf.b.1 */
        class C09581 implements UpdateAchievementResult {
            final /* synthetic */ C1071b HM;
            final /* synthetic */ Status vb;

            C09581(C1071b c1071b, Status status) {
                this.HM = c1071b;
                this.vb = status;
            }

            public String getAchievementId() {
                return this.HM.uS;
            }

            public Status getStatus() {
                return this.vb;
            }
        }

        public C1071b(String str) {
            this.uS = str;
        }

        public /* synthetic */ Result m3044d(Status status) {
            return m3045t(status);
        }

        public UpdateAchievementResult m3045t(Status status) {
            return new C09581(this, status);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.1 */
    class C11461 extends C1070a {
        final /* synthetic */ boolean HH;
        final /* synthetic */ gf HI;

        C11461(gf gfVar, boolean z) {
            this.HI = gfVar;
            this.HH = z;
            super();
        }

        public void m3212a(fx fxVar) {
            fxVar.m2706c((C0194c) this, this.HH);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.2 */
    class C11472 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11472(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3214a(fx fxVar) {
            fxVar.m2697b(null, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.3 */
    class C11483 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11483(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3216a(fx fxVar) {
            fxVar.m2697b((C0194c) this, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.4 */
    class C11494 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11494(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3218a(fx fxVar) {
            fxVar.m2705c(null, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.5 */
    class C11505 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;

        C11505(gf gfVar, String str, String str2) {
            this.HI = gfVar;
            this.HJ = str2;
            super(str);
        }

        public void m3220a(fx fxVar) {
            fxVar.m2705c((C0194c) this, this.HJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.6 */
    class C11516 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11516(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3222a(fx fxVar) {
            fxVar.m2678a(null, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.7 */
    class C11527 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11527(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3224a(fx fxVar) {
            fxVar.m2678a((C0194c) this, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.8 */
    class C11538 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11538(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3226a(fx fxVar) {
            fxVar.m2698b(null, this.HJ, this.HK);
        }
    }

    /* renamed from: com.google.android.gms.internal.gf.9 */
    class C11549 extends C1071b {
        final /* synthetic */ gf HI;
        final /* synthetic */ String HJ;
        final /* synthetic */ int HK;

        C11549(gf gfVar, String str, String str2, int i) {
            this.HI = gfVar;
            this.HJ = str2;
            this.HK = i;
            super(str);
        }

        public void m3228a(fx fxVar) {
            fxVar.m2698b((C0194c) this, this.HJ, this.HK);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m364c(apiClient).fs();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m141b(new C11516(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m141b(new C11527(this, id, id, numSteps));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m140a(new C11461(this, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.m141b(new C11472(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m141b(new C11483(this, id, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m141b(new C11538(this, id, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m141b(new C11549(this, id, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.m141b(new C11494(this, id, id));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m141b(new C11505(this, id, id));
    }
}
