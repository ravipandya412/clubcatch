package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ac implements C0157d {
    private static final String ua;
    private final Context mContext;
    private C0161i rJ;
    private final C0158e rr;
    private final C0152a ub;
    private volatile C0166n uc;
    private final String ud;
    private ab ue;
    private long uf;
    private final int ug;

    /* renamed from: com.google.android.gms.analytics.ac.a */
    class C0152a extends SQLiteOpenHelper {
        final /* synthetic */ ac uh;
        private boolean ui;
        private long uj;

        C0152a(ac acVar, Context context, String str) {
            this.uh = acVar;
            super(context, str, null, 1);
            this.uj = 0;
        }

        private void m53a(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        private boolean m54a(String str, SQLiteDatabase sQLiteDatabase) {
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
                        aa.m51w("Error querying for table " + str);
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
                aa.m51w("Error querying for table " + str);
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
            if (!this.ui || this.uj + 3600000 <= this.uh.rJ.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.ui = true;
                this.uj = this.uh.rJ.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.uh.mContext.getDatabasePath(this.uh.ud).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.ui = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C0168p.m81B(db.getPath());
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
            if (m54a("hits2", db)) {
                m53a(db);
            } else {
                db.execSQL(ac.ua);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.analytics.ac.1 */
    class C05711 implements C0161i {
        final /* synthetic */ ac uh;

        C05711(ac acVar) {
            this.uh = acVar;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    static {
        ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    }

    ac(C0158e c0158e, Context context) {
        this(c0158e, context, "google_analytics_v4.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    ac(C0158e c0158e, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.ud = str;
        this.rr = c0158e;
        this.rJ = new C05711(this);
        this.ub = new C0152a(this, this.mContext, this.ud);
        this.uc = new ah(new DefaultHttpClient(), this.mContext);
        this.uf = 0;
        this.ug = i;
    }

    private SQLiteDatabase m1408G(String str) {
        try {
            return this.ub.getWritableDatabase();
        } catch (SQLiteException e) {
            aa.m51w(str);
            return null;
        }
    }

    private void m1410a(Map<String, String> map, long j, String str) {
        SQLiteDatabase G = m1408G("Error opening database for putHit");
        if (G != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m1414t((Map) map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                aa.m51w("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                G.insert("hits2", null, contentValues);
                this.rr.m68p(false);
            } catch (SQLiteException e2) {
                aa.m51w("Error storing hit");
            }
        }
    }

    private void m1411a(Map<String, String> map, Collection<di> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (di diVar : collection) {
                if ("appendVersion".equals(diVar.getId())) {
                    map.put(substring, diVar.getValue());
                    return;
                }
            }
        }
    }

    private void co() {
        int cq = (cq() - this.ug) + 1;
        if (cq > 0) {
            List s = m1419s(cq);
            aa.m50v("Store full, deleting " + s.size() + " hits to make room.");
            m1416a((String[]) s.toArray(new String[0]));
        }
    }

    static String m1414t(Map<String, String> map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(C0185y.encode((String) entry.getKey()) + "=" + C0185y.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    public void m1415a(Map<String, String> map, long j, String str, Collection<di> collection) {
        cp();
        co();
        m1411a(map, collection);
        m1410a(map, j, str);
    }

    void m1416a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            aa.m51w("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase G = m1408G("Error opening database for deleteHits.");
        if (G != null) {
            try {
                G.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C0158e c0158e = this.rr;
                if (cq() != 0) {
                    z = false;
                }
                c0158e.m68p(z);
            } catch (SQLiteException e) {
                aa.m51w("Error deleting hits " + strArr);
            }
        }
    }

    @Deprecated
    void m1417b(Collection<C0184x> collection) {
        if (collection == null || collection.isEmpty()) {
            aa.m51w("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (C0184x ci : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(ci.ci());
            i = i2;
        }
        m1416a(strArr);
    }

    public void bp() {
        boolean z = true;
        aa.m50v("Dispatch running...");
        if (this.uc.bA()) {
            List t = m1420t(40);
            if (t.isEmpty()) {
                aa.m50v("...nothing to dispatch");
                this.rr.m68p(true);
                return;
            }
            if (this.ue == null) {
                this.ue = new ab("_t=dispatch&_v=ma4.0.0", true);
            }
            if (cq() > t.size()) {
                z = false;
            }
            int a = this.uc.m77a(t, this.ue, z);
            aa.m50v("sent " + a + " of " + t.size() + " hits");
            m1417b(t.subList(0, Math.min(a, t.size())));
            if (a != t.size() || cq() <= 0) {
                this.ue = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    public C0166n bq() {
        return this.uc;
    }

    int cp() {
        boolean z = true;
        long currentTimeMillis = this.rJ.currentTimeMillis();
        if (currentTimeMillis <= this.uf + 86400000) {
            return 0;
        }
        this.uf = currentTimeMillis;
        SQLiteDatabase G = m1408G("Error opening database for deleteStaleHits.");
        if (G == null) {
            return 0;
        }
        int delete = G.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.rJ.currentTimeMillis() - 2592000000L)});
        C0158e c0158e = this.rr;
        if (cq() != 0) {
            z = false;
        }
        c0158e.m68p(z);
        return delete;
    }

    int cq() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m1408G("Error opening database for getNumStoredHits.");
        if (G != null) {
            try {
                cursor = G.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                aa.m51w("Error getting numStoredHits");
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

    public void m1418i(long j) {
        boolean z = true;
        SQLiteDatabase G = m1408G("Error opening database for clearHits");
        if (G != null) {
            if (j == 0) {
                G.delete("hits2", null, null);
            } else {
                G.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0158e c0158e = this.rr;
            if (cq() != 0) {
                z = false;
            }
            c0158e.m68p(z);
        }
    }

    List<String> m1419s(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            aa.m51w("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase G = m1408G("Error opening database for peekHitIds.");
        if (G == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = G.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
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
                    aa.m51w("Error in peekHits fetching hitIds: " + e.getMessage());
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
            aa.m51w("Error in peekHits fetching hitIds: " + e.getMessage());
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.C0184x> m1420t(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.m1408G(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r12.<init>();	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 == 0) goto L_0x005f;
    L_0x0046:
        r4 = new com.google.android.gms.analytics.x;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r5 = 0;
        r3 = 0;
        r6 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = 1;
        r8 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r4.<init>(r5, r6, r8);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r12.add(r4);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 != 0) goto L_0x0046;
    L_0x005f:
        if (r13 == 0) goto L_0x0064;
    L_0x0061:
        r13.close();
    L_0x0064:
        r11 = 0;
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0173 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0173 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0173 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 == 0) goto L_0x00cc;
    L_0x0099:
        r4 = r11;
    L_0x009a:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 <= 0) goto L_0x0100;
    L_0x00a8:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C0184x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.m86E(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C0184x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 2;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.m87F(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
    L_0x00c4:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r4 != 0) goto L_0x0187;
    L_0x00cc:
        if (r3 == 0) goto L_0x00d1;
    L_0x00ce:
        r3.close();
    L_0x00d1:
        r2 = r12;
        goto L_0x0010;
    L_0x00d4:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00d8:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r5.<init>();	 Catch:{ all -> 0x0178 }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0178 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0178 }
        r3 = r5.append(r3);	 Catch:{ all -> 0x0178 }
        r3 = r3.toString();	 Catch:{ all -> 0x0178 }
        com.google.android.gms.analytics.aa.m51w(r3);	 Catch:{ all -> 0x0178 }
        if (r4 == 0) goto L_0x0010;
    L_0x00f4:
        r4.close();
        goto L_0x0010;
    L_0x00f9:
        r2 = move-exception;
    L_0x00fa:
        if (r12 == 0) goto L_0x00ff;
    L_0x00fc:
        r12.close();
    L_0x00ff:
        throw r2;
    L_0x0100:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C0184x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r8 = r2.ci();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        com.google.android.gms.analytics.aa.m51w(r2);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        goto L_0x00c4;
    L_0x011e:
        r2 = move-exception;
        r13 = r3;
    L_0x0120:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = "Error in peekHits fetching hitString: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0169 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0169 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0169 }
        r2 = r2.toString();	 Catch:{ all -> 0x0169 }
        com.google.android.gms.analytics.aa.m51w(r2);	 Catch:{ all -> 0x0169 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x0169 }
    L_0x0144:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0169 }
        if (r2 == 0) goto L_0x015c;
    L_0x014a:
        r2 = r5.next();	 Catch:{ all -> 0x0169 }
        r2 = (com.google.android.gms.analytics.C0184x) r2;	 Catch:{ all -> 0x0169 }
        r6 = r2.ch();	 Catch:{ all -> 0x0169 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0169 }
        if (r6 == 0) goto L_0x0165;
    L_0x015a:
        if (r4 == 0) goto L_0x0164;
    L_0x015c:
        if (r13 == 0) goto L_0x0161;
    L_0x015e:
        r13.close();
    L_0x0161:
        r2 = r3;
        goto L_0x0010;
    L_0x0164:
        r4 = 1;
    L_0x0165:
        r3.add(r2);	 Catch:{ all -> 0x0169 }
        goto L_0x0144;
    L_0x0169:
        r2 = move-exception;
    L_0x016a:
        if (r13 == 0) goto L_0x016f;
    L_0x016c:
        r13.close();
    L_0x016f:
        throw r2;
    L_0x0170:
        r2 = move-exception;
        r13 = r3;
        goto L_0x016a;
    L_0x0173:
        r2 = move-exception;
        goto L_0x0120;
    L_0x0175:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00fa;
    L_0x0178:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00fa;
    L_0x017b:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00d8;
    L_0x0181:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00d8;
    L_0x0187:
        r4 = r2;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.t(int):java.util.List<com.google.android.gms.analytics.x>");
    }
}
