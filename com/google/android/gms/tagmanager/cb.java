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
import com.google.android.gms.tagmanager.db.C0455a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class cb implements at {
    private static final String ua;
    private fl Ty;
    private final C0435b VL;
    private volatile ab VM;
    private final au VN;
    private final Context mContext;
    private final String ud;
    private long uf;
    private final int ug;

    /* renamed from: com.google.android.gms.tagmanager.cb.b */
    class C0435b extends SQLiteOpenHelper {
        final /* synthetic */ cb VO;
        private boolean ui;
        private long uj;

        C0435b(cb cbVar, Context context, String str) {
            this.VO = cbVar;
            super(context, str, null, 1);
            this.uj = 0;
        }

        private void m1286a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m1287a(String str, SQLiteDatabase sQLiteDatabase) {
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
            if (!this.ui || this.uj + 3600000 <= this.VO.Ty.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.ui = true;
                this.uj = this.VO.Ty.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.VO.mContext.getDatabasePath(this.VO.ud).delete();
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
            if (m1287a("gtm_hits", db)) {
                m1286a(db);
            } else {
                db.execSQL(cb.ua);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cb.a */
    class C0842a implements C0455a {
        final /* synthetic */ cb VO;

        C0842a(cb cbVar) {
            this.VO = cbVar;
        }

        public void m2274a(ap apVar) {
            this.VO.m2285u(apVar.ci());
        }

        public void m2275b(ap apVar) {
            this.VO.m2285u(apVar.ci());
            bh.m1272v("Permanent failure dispatching hitId: " + apVar.ci());
        }

        public void m2276c(ap apVar) {
            long je = apVar.je();
            if (je == 0) {
                this.VO.m2283c(apVar.ci(), this.VO.Ty.currentTimeMillis());
            } else if (je + 14400000 < this.VO.Ty.currentTimeMillis()) {
                this.VO.m2285u(apVar.ci());
                bh.m1272v("Giving up on failed hitId: " + apVar.ci());
            }
        }
    }

    static {
        ua = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    }

    cb(au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    cb(au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.ud = str;
        this.VN = auVar;
        this.Ty = fn.eI();
        this.VL = new C0435b(this, this.mContext, this.ud);
        this.VM = new db(new DefaultHttpClient(), this.mContext, new C0842a(this));
        this.uf = 0;
        this.ug = i;
    }

    private SQLiteDatabase m2277G(String str) {
        try {
            return this.VL.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m1273w(str);
            return null;
        }
    }

    private void m2283c(long j, long j2) {
        SQLiteDatabase G = m2277G("Error opening database for getNumStoredHits.");
        if (G != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                G.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                bh.m1273w("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                m2285u(j);
            }
        }
    }

    private void co() {
        int cq = (cq() - this.ug) + 1;
        if (cq > 0) {
            List s = m2288s(cq);
            bh.m1272v("Store full, deleting " + s.size() + " hits to make room.");
            m2286a((String[]) s.toArray(new String[0]));
        }
    }

    private void m2284f(long j, String str) {
        SQLiteDatabase G = m2277G("Error opening database for putHit");
        if (G != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                G.insert("gtm_hits", null, contentValues);
                this.VN.m1257p(false);
            } catch (SQLiteException e) {
                bh.m1273w("Error storing hit");
            }
        }
    }

    private void m2285u(long j) {
        m2286a(new String[]{String.valueOf(j)});
    }

    void m2286a(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase G = m2277G("Error opening database for deleteHits.");
            if (G != null) {
                try {
                    G.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    au auVar = this.VN;
                    if (cq() != 0) {
                        z = false;
                    }
                    auVar.m1257p(z);
                } catch (SQLiteException e) {
                    bh.m1273w("Error deleting hits");
                }
            }
        }
    }

    public void bp() {
        bh.m1272v("GTM Dispatch running...");
        if (this.VM.bA()) {
            List t = m2289t(40);
            if (t.isEmpty()) {
                bh.m1272v("...nothing to dispatch");
                this.VN.m1257p(true);
                return;
            }
            this.VM.m1245e(t);
            if (js() > 0) {
                cy.kh().bp();
            }
        }
    }

    int cp() {
        boolean z = true;
        long currentTimeMillis = this.Ty.currentTimeMillis();
        if (currentTimeMillis <= this.uf + 86400000) {
            return 0;
        }
        this.uf = currentTimeMillis;
        SQLiteDatabase G = m2277G("Error opening database for deleteStaleHits.");
        if (G == null) {
            return 0;
        }
        int delete = G.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.Ty.currentTimeMillis() - 2592000000L)});
        au auVar = this.VN;
        if (cq() != 0) {
            z = false;
        }
        auVar.m1257p(z);
        return delete;
    }

    int cq() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase G = m2277G("Error opening database for getNumStoredHits.");
        if (G != null) {
            try {
                cursor = G.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m1273w("Error getting numStoredHits");
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

    public void m2287e(long j, String str) {
        cp();
        co();
        m2284f(j, str);
    }

    int js() {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        SQLiteDatabase G = m2277G("Error opening database for getNumStoredHits.");
        if (G == null) {
            return 0;
        }
        int count;
        try {
            Cursor query = G.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e) {
                cursor = query;
                try {
                    bh.m1273w("Error getting num untried hits");
                    if (cursor == null) {
                        count = 0;
                    } else {
                        cursor.close();
                        count = 0;
                    }
                    return count;
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
            bh.m1273w("Error getting num untried hits");
            if (cursor == null) {
                cursor.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return count;
    }

    List<String> m2288s(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m1273w("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase G = m2277G("Error opening database for peekHitIds.");
        if (G == null) {
            return arrayList;
        }
        try {
            query = G.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
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
                    bh.m1273w("Error in peekHits fetching hitIds: " + e.getMessage());
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
            bh.m1273w("Error in peekHits fetching hitIds: " + e.getMessage());
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
    public java.util.List<com.google.android.gms.tagmanager.ap> m2289t(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.m2277G(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "gtm_hits";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 2;
        r6 = "hit_first_send_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00ca, all -> 0x00ef }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r12.<init>();	 Catch:{ SQLiteException -> 0x0171, all -> 0x016b }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 == 0) goto L_0x0068;
    L_0x004b:
        r3 = new com.google.android.gms.tagmanager.ap;	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r4 = 0;
        r4 = r13.getLong(r4);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r6 = 1;
        r6 = r13.getLong(r6);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r8 = 2;
        r8 = r13.getLong(r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r12.add(r3);	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0177, all -> 0x016b }
        if (r3 != 0) goto L_0x004b;
    L_0x0068:
        if (r13 == 0) goto L_0x006d;
    L_0x006a:
        r13.close();
    L_0x006d:
        r11 = 0;
        r3 = "gtm_hits";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 1;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0169 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0169 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0169 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0169 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0169 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 == 0) goto L_0x00c2;
    L_0x009d:
        r4 = r11;
    L_0x009e:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r2 <= 0) goto L_0x00f6;
    L_0x00ac:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2.m1254F(r5);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
    L_0x00ba:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        if (r4 != 0) goto L_0x017d;
    L_0x00c2:
        if (r3 == 0) goto L_0x00c7;
    L_0x00c4:
        r3.close();
    L_0x00c7:
        r2 = r12;
        goto L_0x0010;
    L_0x00ca:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00ce:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016e }
        r5.<init>();	 Catch:{ all -> 0x016e }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x016e }
        r3 = r3.getMessage();	 Catch:{ all -> 0x016e }
        r3 = r5.append(r3);	 Catch:{ all -> 0x016e }
        r3 = r3.toString();	 Catch:{ all -> 0x016e }
        com.google.android.gms.tagmanager.bh.m1273w(r3);	 Catch:{ all -> 0x016e }
        if (r4 == 0) goto L_0x0010;
    L_0x00ea:
        r4.close();
        goto L_0x0010;
    L_0x00ef:
        r2 = move-exception;
    L_0x00f0:
        if (r12 == 0) goto L_0x00f5;
    L_0x00f2:
        r12.close();
    L_0x00f5:
        throw r2;
    L_0x00f6:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r8 = r2.ci();	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        com.google.android.gms.tagmanager.bh.m1273w(r2);	 Catch:{ SQLiteException -> 0x0114, all -> 0x0166 }
        goto L_0x00ba;
    L_0x0114:
        r2 = move-exception;
        r13 = r3;
    L_0x0116:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = "Error in peekHits fetching hit url: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x015f }
        r2 = r2.getMessage();	 Catch:{ all -> 0x015f }
        r2 = r3.append(r2);	 Catch:{ all -> 0x015f }
        r2 = r2.toString();	 Catch:{ all -> 0x015f }
        com.google.android.gms.tagmanager.bh.m1273w(r2);	 Catch:{ all -> 0x015f }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x015f }
        r3.<init>();	 Catch:{ all -> 0x015f }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x015f }
    L_0x013a:
        r2 = r5.hasNext();	 Catch:{ all -> 0x015f }
        if (r2 == 0) goto L_0x0152;
    L_0x0140:
        r2 = r5.next();	 Catch:{ all -> 0x015f }
        r2 = (com.google.android.gms.tagmanager.ap) r2;	 Catch:{ all -> 0x015f }
        r6 = r2.jf();	 Catch:{ all -> 0x015f }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x015f }
        if (r6 == 0) goto L_0x015b;
    L_0x0150:
        if (r4 == 0) goto L_0x015a;
    L_0x0152:
        if (r13 == 0) goto L_0x0157;
    L_0x0154:
        r13.close();
    L_0x0157:
        r2 = r3;
        goto L_0x0010;
    L_0x015a:
        r4 = 1;
    L_0x015b:
        r3.add(r2);	 Catch:{ all -> 0x015f }
        goto L_0x013a;
    L_0x015f:
        r2 = move-exception;
    L_0x0160:
        if (r13 == 0) goto L_0x0165;
    L_0x0162:
        r13.close();
    L_0x0165:
        throw r2;
    L_0x0166:
        r2 = move-exception;
        r13 = r3;
        goto L_0x0160;
    L_0x0169:
        r2 = move-exception;
        goto L_0x0116;
    L_0x016b:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00f0;
    L_0x016e:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00f0;
    L_0x0171:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00ce;
    L_0x0177:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00ce;
    L_0x017d:
        r4 = r2;
        goto L_0x009e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cb.t(int):java.util.List<com.google.android.gms.tagmanager.ap>");
    }
}
