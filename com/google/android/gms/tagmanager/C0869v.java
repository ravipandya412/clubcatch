package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.google.android.gms.tagmanager.DataLayer.C0419a;
import com.google.android.gms.tagmanager.DataLayer.C0422c;
import com.google.android.gms.tagmanager.DataLayer.C0422c.C0421a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C0869v implements C0422c {
    private static final String UD;
    private fl Ty;
    private final Executor UE;
    private C0470a UF;
    private int UG;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.v.1 */
    class C04671 implements Runnable {
        final /* synthetic */ List UH;
        final /* synthetic */ long UI;
        final /* synthetic */ C0869v UJ;

        C04671(C0869v c0869v, List list, long j) {
            this.UJ = c0869v;
            this.UH = list;
            this.UI = j;
        }

        public void run() {
            this.UJ.m2347b(this.UH, this.UI);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.2 */
    class C04682 implements Runnable {
        final /* synthetic */ C0869v UJ;
        final /* synthetic */ C0421a UK;

        C04682(C0869v c0869v, C0421a c0421a) {
            this.UJ = c0869v;
            this.UK = c0421a;
        }

        public void run() {
            this.UK.m1218b(this.UJ.iT());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.3 */
    class C04693 implements Runnable {
        final /* synthetic */ C0869v UJ;
        final /* synthetic */ String UL;

        C04693(C0869v c0869v, String str) {
            this.UJ = c0869v;
            this.UL = str;
        }

        public void run() {
            this.UJ.bj(this.UL);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.a */
    class C0470a extends SQLiteOpenHelper {
        final /* synthetic */ C0869v UJ;

        C0470a(C0869v c0869v, Context context, String str) {
            this.UJ = c0869v;
            super(context, str, null, 1);
        }

        private void m1373a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1374a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.m1273w("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.m1273w("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.UJ.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.m1253B(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m1374a("datalayer", db)) {
                m1373a(db);
            } else {
                db.execSQL(C0869v.UD);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.b */
    private static class C0471b {
        final String UA;
        final byte[] UM;

        C0471b(String str, byte[] bArr) {
            this.UA = str;
            this.UM = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.UA + " serialized hash = " + Arrays.hashCode(this.UM);
        }
    }

    static {
        UD = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public C0869v(Context context) {
        this(context, fn.eI(), "google_tagmanager.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, Executors.newSingleThreadExecutor());
    }

    C0869v(Context context, fl flVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.Ty = flVar;
        this.UG = i;
        this.UE = executor;
        this.UF = new C0470a(this, this.mContext, str);
    }

    private SQLiteDatabase m2342G(String str) {
        try {
            return this.UF.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1273w(str);
            return null;
        }
    }

    private synchronized void m2347b(List<C0471b> list, long j) {
        try {
            long currentTimeMillis = this.Ty.currentTimeMillis();
            m2354t(currentTimeMillis);
            bQ(list.size());
            m2349c(list, currentTimeMillis + j);
            iW();
        } catch (Throwable th) {
            iW();
        }
    }

    private void bQ(int i) {
        int iV = (iV() - this.UG) + i;
        if (iV > 0) {
            List bR = bR(iV);
            bh.m1271u("DataLayer store full, deleting " + bR.size() + " entries to make room.");
            m2351g((String[]) bR.toArray(new String[0]));
        }
    }

    private List<String> bR(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1273w("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase G = m2342G("Error opening database for peekEntryIds.");
        if (G == null) {
            return arrayList;
        }
        try {
            query = G.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.m1273w("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.m1273w("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private void bj(String str) {
        SQLiteDatabase G = m2342G("Error opening database for clearKeysWithPrefix.");
        if (G != null) {
            try {
                bh.m1272v("Cleared " + G.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m1273w("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                iW();
            }
        }
    }

    private List<C0419a> m2348c(List<C0471b> list) {
        List<C0419a> arrayList = new ArrayList();
        for (C0471b c0471b : list) {
            arrayList.add(new C0419a(c0471b.UA, m2352j(c0471b.UM)));
        }
        return arrayList;
    }

    private void m2349c(List<C0471b> list, long j) {
        SQLiteDatabase G = m2342G("Error opening database for writeEntryToDatabase.");
        if (G != null) {
            for (C0471b c0471b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c0471b.UA);
                contentValues.put("value", c0471b.UM);
                G.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<C0471b> m2350d(List<C0419a> list) {
        List<C0471b> arrayList = new ArrayList();
        for (C0419a c0419a : list) {
            arrayList.add(new C0471b(c0419a.UA, m2353j(c0419a.UB)));
        }
        return arrayList;
    }

    private void m2351g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase G = m2342G("Error opening database for deleteEntries.");
            if (G != null) {
                try {
                    G.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m1273w("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private List<C0419a> iT() {
        try {
            m2354t(this.Ty.currentTimeMillis());
            List<C0419a> c = m2348c(iU());
            return c;
        } finally {
            iW();
        }
    }

    private List<C0471b> iU() {
        SQLiteDatabase G = m2342G("Error opening database for loadSerialized.");
        List<C0471b> arrayList = new ArrayList();
        if (G == null) {
            return arrayList;
        }
        Cursor query = G.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C0471b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int iV() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m2342G("Error opening database for getNumStoredEntries.");
        if (G != null) {
            try {
                cursor = G.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1273w("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void iW() {
        try {
            this.UF.close();
        } catch (SQLiteException e) {
        }
    }

    private Object m2352j(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream2.readObject();
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream2 = objectInputStream;
            th = th4;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] m2353j(Object obj) {
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private void m2354t(long j) {
        SQLiteDatabase G = m2342G("Error opening database for deleteOlderThan.");
        if (G != null) {
            try {
                bh.m1272v("Deleted " + G.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m1273w("Error deleting old entries.");
            }
        }
    }

    public void m2355a(C0421a c0421a) {
        this.UE.execute(new C04682(this, c0421a));
    }

    public void m2356a(List<C0419a> list, long j) {
        this.UE.execute(new C04671(this, m2350d(list), j));
    }

    public void bi(String str) {
        this.UE.execute(new C04693(this, str));
    }
}
