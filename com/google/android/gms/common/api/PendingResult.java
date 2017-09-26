package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public interface PendingResult<R extends Result> {

    /* renamed from: com.google.android.gms.common.api.PendingResult.a */
    public interface C0192a {
        void m142k(Status status);
    }

    R await();

    R await(long j, TimeUnit timeUnit);

    void setResultCallback(ResultCallback<R> resultCallback);

    void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit);
}
