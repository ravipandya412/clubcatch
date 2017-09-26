package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.p */
public class C0360p {
    private final C0357n ka;
    private final SecureRandom kt;

    /* renamed from: com.google.android.gms.internal.p.a */
    public class C0359a extends Exception {
        final /* synthetic */ C0360p ku;

        public C0359a(C0360p c0360p) {
            this.ku = c0360p;
        }

        public C0359a(C0360p c0360p, Throwable th) {
            this.ku = c0360p;
            super(th);
        }
    }

    public C0360p(C0357n c0357n, SecureRandom secureRandom) {
        this.ka = c0357n;
        this.kt = secureRandom;
    }

    static void m1088c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m1089c(byte[] bArr, String str) throws C0359a {
        if (bArr.length != 16) {
            throw new C0359a(this);
        }
        try {
            byte[] a = this.ka.m1084a(str, false);
            if (a.length <= 16) {
                throw new C0359a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0359a(this, e);
        } catch (Throwable e2) {
            throw new C0359a(this, e2);
        } catch (Throwable e22) {
            throw new C0359a(this, e22);
        } catch (Throwable e222) {
            throw new C0359a(this, e222);
        } catch (Throwable e2222) {
            throw new C0359a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0359a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0359a(this, e222222);
        }
    }

    public byte[] m1090d(String str) throws C0359a {
        try {
            byte[] a = this.ka.m1084a(str, false);
            if (a.length != 32) {
                throw new C0359a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0360p.m1088c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0359a(this, e);
        }
    }
}
