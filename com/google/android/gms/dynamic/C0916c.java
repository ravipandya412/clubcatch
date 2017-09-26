package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0251b.C0623a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.c */
public final class C0916c<T> extends C0623a {
    private final T FB;

    private C0916c(T t) {
        this.FB = t;
    }

    public static <T> T m2414b(C0251b c0251b) {
        if (c0251b instanceof C0916c) {
            return ((C0916c) c0251b).FB;
        }
        IBinder asBinder = c0251b.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0251b m2415h(T t) {
        return new C0916c(t);
    }
}
