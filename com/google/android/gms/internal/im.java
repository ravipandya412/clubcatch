package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class im extends fb implements SafeParcelable, ItemScope {
    public static final in CREATOR;
    private static final HashMap<String, C0696a<?, ?>> RL;
    private String FH;
    private double KX;
    private double KY;
    private String Oc;
    private final Set<Integer> RM;
    private im RN;
    private List<String> RO;
    private im RP;
    private String RQ;
    private String RR;
    private String RS;
    private List<im> RT;
    private int RU;
    private List<im> RV;
    private im RW;
    private List<im> RX;
    private String RY;
    private String RZ;
    private String SA;
    private String SB;
    private im SC;
    private String SD;
    private String SE;
    private String SF;
    private String SG;
    private im Sa;
    private String Sb;
    private String Sc;
    private List<im> Sd;
    private String Se;
    private String Sf;
    private String Sg;
    private String Sh;
    private String Si;
    private String Sj;
    private String Sk;
    private String Sl;
    private im Sm;
    private String Sn;
    private String So;
    private String Sp;
    private im Sq;
    private im Sr;
    private im Ss;
    private List<im> St;
    private String Su;
    private String Sv;
    private String Sw;
    private String Sx;
    private im Sy;
    private String Sz;
    private String lt;
    private String mName;
    private String pS;
    private String uS;
    private final int wj;

    static {
        CREATOR = new in();
        RL = new HashMap();
        RL.put("about", C0696a.m1834a("about", 2, im.class));
        RL.put("additionalName", C0696a.m1841k("additionalName", 3));
        RL.put("address", C0696a.m1834a("address", 4, im.class));
        RL.put("addressCountry", C0696a.m1840j("addressCountry", 5));
        RL.put("addressLocality", C0696a.m1840j("addressLocality", 6));
        RL.put("addressRegion", C0696a.m1840j("addressRegion", 7));
        RL.put("associated_media", C0696a.m1835b("associated_media", 8, im.class));
        RL.put("attendeeCount", C0696a.m1837g("attendeeCount", 9));
        RL.put("attendees", C0696a.m1835b("attendees", 10, im.class));
        RL.put("audio", C0696a.m1834a("audio", 11, im.class));
        RL.put("author", C0696a.m1835b("author", 12, im.class));
        RL.put("bestRating", C0696a.m1840j("bestRating", 13));
        RL.put("birthDate", C0696a.m1840j("birthDate", 14));
        RL.put("byArtist", C0696a.m1834a("byArtist", 15, im.class));
        RL.put("caption", C0696a.m1840j("caption", 16));
        RL.put("contentSize", C0696a.m1840j("contentSize", 17));
        RL.put("contentUrl", C0696a.m1840j("contentUrl", 18));
        RL.put("contributor", C0696a.m1835b("contributor", 19, im.class));
        RL.put("dateCreated", C0696a.m1840j("dateCreated", 20));
        RL.put("dateModified", C0696a.m1840j("dateModified", 21));
        RL.put("datePublished", C0696a.m1840j("datePublished", 22));
        RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0696a.m1840j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        RL.put("duration", C0696a.m1840j("duration", 24));
        RL.put("embedUrl", C0696a.m1840j("embedUrl", 25));
        RL.put("endDate", C0696a.m1840j("endDate", 26));
        RL.put("familyName", C0696a.m1840j("familyName", 27));
        RL.put("gender", C0696a.m1840j("gender", 28));
        RL.put("geo", C0696a.m1834a("geo", 29, im.class));
        RL.put("givenName", C0696a.m1840j("givenName", 30));
        RL.put("height", C0696a.m1840j("height", 31));
        RL.put("id", C0696a.m1840j("id", 32));
        RL.put("image", C0696a.m1840j("image", 33));
        RL.put("inAlbum", C0696a.m1834a("inAlbum", 34, im.class));
        RL.put("latitude", C0696a.m1838h("latitude", 36));
        RL.put("location", C0696a.m1834a("location", 37, im.class));
        RL.put("longitude", C0696a.m1838h("longitude", 38));
        RL.put("name", C0696a.m1840j("name", 39));
        RL.put("partOfTVSeries", C0696a.m1834a("partOfTVSeries", 40, im.class));
        RL.put("performers", C0696a.m1835b("performers", 41, im.class));
        RL.put("playerType", C0696a.m1840j("playerType", 42));
        RL.put("postOfficeBoxNumber", C0696a.m1840j("postOfficeBoxNumber", 43));
        RL.put("postalCode", C0696a.m1840j("postalCode", 44));
        RL.put("ratingValue", C0696a.m1840j("ratingValue", 45));
        RL.put("reviewRating", C0696a.m1834a("reviewRating", 46, im.class));
        RL.put("startDate", C0696a.m1840j("startDate", 47));
        RL.put("streetAddress", C0696a.m1840j("streetAddress", 48));
        RL.put("text", C0696a.m1840j("text", 49));
        RL.put("thumbnail", C0696a.m1834a("thumbnail", 50, im.class));
        RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C0696a.m1840j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        RL.put("tickerSymbol", C0696a.m1840j("tickerSymbol", 52));
        RL.put("type", C0696a.m1840j("type", 53));
        RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0696a.m1840j(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        RL.put("width", C0696a.m1840j("width", 55));
        RL.put("worstRating", C0696a.m1840j("worstRating", 56));
    }

    public im() {
        this.wj = 1;
        this.RM = new HashSet();
    }

    im(Set<Integer> set, int i, im imVar, List<String> list, im imVar2, String str, String str2, String str3, List<im> list2, int i2, List<im> list3, im imVar3, List<im> list4, String str4, String str5, im imVar4, String str6, String str7, String str8, List<im> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, im imVar5, String str18, String str19, String str20, String str21, im imVar6, double d, im imVar7, double d2, String str22, im imVar8, List<im> list6, String str23, String str24, String str25, String str26, im imVar9, String str27, String str28, String str29, im imVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.RM = set;
        this.wj = i;
        this.RN = imVar;
        this.RO = list;
        this.RP = imVar2;
        this.RQ = str;
        this.RR = str2;
        this.RS = str3;
        this.RT = list2;
        this.RU = i2;
        this.RV = list3;
        this.RW = imVar3;
        this.RX = list4;
        this.RY = str4;
        this.RZ = str5;
        this.Sa = imVar4;
        this.Sb = str6;
        this.Sc = str7;
        this.lt = str8;
        this.Sd = list5;
        this.Se = str9;
        this.Sf = str10;
        this.Sg = str11;
        this.FH = str12;
        this.Sh = str13;
        this.Si = str14;
        this.Sj = str15;
        this.Sk = str16;
        this.Sl = str17;
        this.Sm = imVar5;
        this.Sn = str18;
        this.So = str19;
        this.uS = str20;
        this.Sp = str21;
        this.Sq = imVar6;
        this.KX = d;
        this.Sr = imVar7;
        this.KY = d2;
        this.mName = str22;
        this.Ss = imVar8;
        this.St = list6;
        this.Su = str23;
        this.Sv = str24;
        this.Sw = str25;
        this.Sx = str26;
        this.Sy = imVar9;
        this.Sz = str27;
        this.SA = str28;
        this.SB = str29;
        this.SC = imVar10;
        this.SD = str30;
        this.SE = str31;
        this.Oc = str32;
        this.pS = str33;
        this.SF = str34;
        this.SG = str35;
    }

    public im(Set<Integer> set, im imVar, List<String> list, im imVar2, String str, String str2, String str3, List<im> list2, int i, List<im> list3, im imVar3, List<im> list4, String str4, String str5, im imVar4, String str6, String str7, String str8, List<im> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, im imVar5, String str18, String str19, String str20, String str21, im imVar6, double d, im imVar7, double d2, String str22, im imVar8, List<im> list6, String str23, String str24, String str25, String str26, im imVar9, String str27, String str28, String str29, im imVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.RM = set;
        this.wj = 1;
        this.RN = imVar;
        this.RO = list;
        this.RP = imVar2;
        this.RQ = str;
        this.RR = str2;
        this.RS = str3;
        this.RT = list2;
        this.RU = i;
        this.RV = list3;
        this.RW = imVar3;
        this.RX = list4;
        this.RY = str4;
        this.RZ = str5;
        this.Sa = imVar4;
        this.Sb = str6;
        this.Sc = str7;
        this.lt = str8;
        this.Sd = list5;
        this.Se = str9;
        this.Sf = str10;
        this.Sg = str11;
        this.FH = str12;
        this.Sh = str13;
        this.Si = str14;
        this.Sj = str15;
        this.Sk = str16;
        this.Sl = str17;
        this.Sm = imVar5;
        this.Sn = str18;
        this.So = str19;
        this.uS = str20;
        this.Sp = str21;
        this.Sq = imVar6;
        this.KX = d;
        this.Sr = imVar7;
        this.KY = d2;
        this.mName = str22;
        this.Ss = imVar8;
        this.St = list6;
        this.Su = str23;
        this.Sv = str24;
        this.Sw = str25;
        this.Sx = str26;
        this.Sy = imVar9;
        this.Sz = str27;
        this.SA = str28;
        this.SB = str29;
        this.SC = imVar10;
        this.SD = str30;
        this.SE = str31;
        this.Oc = str32;
        this.pS = str33;
        this.SF = str34;
        this.SG = str35;
    }

    protected boolean m2738a(C0696a c0696a) {
        return this.RM.contains(Integer.valueOf(c0696a.eu()));
    }

    protected Object ak(String str) {
        return null;
    }

    protected boolean al(String str) {
        return false;
    }

    protected Object m2739b(C0696a c0696a) {
        switch (c0696a.eu()) {
            case DetectedActivity.ON_FOOT /*2*/:
                return this.RN;
            case DetectedActivity.STILL /*3*/:
                return this.RO;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.RP;
            case DetectedActivity.TILTING /*5*/:
                return this.RQ;
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return this.RR;
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                return this.RS;
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                return this.RT;
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                return Integer.valueOf(this.RU);
            case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                return this.RV;
            case C0519R.styleable.Toolbar_titleMargins /*11*/:
                return this.RW;
            case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                return this.RX;
            case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                return this.RY;
            case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                return this.RZ;
            case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                return this.Sa;
            case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                return this.Sb;
            case C0519R.styleable.Toolbar_collapseIcon /*17*/:
                return this.Sc;
            case C0519R.styleable.Toolbar_collapseContentDescription /*18*/:
                return this.lt;
            case C0519R.styleable.Toolbar_navigationIcon /*19*/:
                return this.Sd;
            case C0519R.styleable.Toolbar_navigationContentDescription /*20*/:
                return this.Se;
            case C0519R.styleable.Theme_actionBarWidgetTheme /*21*/:
                return this.Sf;
            case C0519R.styleable.Theme_actionBarSize /*22*/:
                return this.Sg;
            case C0519R.styleable.Theme_actionBarDivider /*23*/:
                return this.FH;
            case C0519R.styleable.Theme_actionBarItemBackground /*24*/:
                return this.Sh;
            case C0519R.styleable.Theme_actionMenuTextAppearance /*25*/:
                return this.Si;
            case C0519R.styleable.Theme_actionMenuTextColor /*26*/:
                return this.Sj;
            case C0519R.styleable.Theme_actionModeStyle /*27*/:
                return this.Sk;
            case C0519R.styleable.Theme_actionModeCloseButtonStyle /*28*/:
                return this.Sl;
            case C0519R.styleable.Theme_actionModeBackground /*29*/:
                return this.Sm;
            case C0519R.styleable.Theme_actionModeSplitBackground /*30*/:
                return this.Sn;
            case C0519R.styleable.Theme_actionModeCloseDrawable /*31*/:
                return this.So;
            case TransportMediator.FLAG_KEY_MEDIA_STOP /*32*/:
                return this.uS;
            case C0519R.styleable.Theme_actionModeCopyDrawable /*33*/:
                return this.Sp;
            case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                return this.Sq;
            case C0519R.styleable.Theme_actionModeShareDrawable /*36*/:
                return Double.valueOf(this.KX);
            case C0519R.styleable.Theme_actionModeFindDrawable /*37*/:
                return this.Sr;
            case C0519R.styleable.Theme_actionModeWebSearchDrawable /*38*/:
                return Double.valueOf(this.KY);
            case C0519R.styleable.Theme_actionModePopupWindowStyle /*39*/:
                return this.mName;
            case C0519R.styleable.Theme_textAppearanceLargePopupMenu /*40*/:
                return this.Ss;
            case C0519R.styleable.Theme_textAppearanceSmallPopupMenu /*41*/:
                return this.St;
            case C0519R.styleable.Theme_dialogTheme /*42*/:
                return this.Su;
            case C0519R.styleable.Theme_dialogPreferredPadding /*43*/:
                return this.Sv;
            case C0519R.styleable.Theme_listDividerAlertDialog /*44*/:
                return this.Sw;
            case C0519R.styleable.Theme_actionDropDownStyle /*45*/:
                return this.Sx;
            case C0519R.styleable.Theme_dropdownListPreferredItemHeight /*46*/:
                return this.Sy;
            case C0519R.styleable.Theme_spinnerDropDownItemStyle /*47*/:
                return this.Sz;
            case C0519R.styleable.Theme_homeAsUpIndicator /*48*/:
                return this.SA;
            case C0519R.styleable.Theme_actionButtonStyle /*49*/:
                return this.SB;
            case C0519R.styleable.Theme_buttonBarStyle /*50*/:
                return this.SC;
            case C0519R.styleable.Theme_buttonBarButtonStyle /*51*/:
                return this.SD;
            case C0519R.styleable.Theme_selectableItemBackground /*52*/:
                return this.SE;
            case C0519R.styleable.Theme_selectableItemBackgroundBorderless /*53*/:
                return this.Oc;
            case C0519R.styleable.Theme_borderlessButtonStyle /*54*/:
                return this.pS;
            case C0519R.styleable.Theme_dividerVertical /*55*/:
                return this.SF;
            case C0519R.styleable.Theme_dividerHorizontal /*56*/:
                return this.SG;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0696a.eu());
        }
    }

    public int describeContents() {
        in inVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0696a<?, ?>> en() {
        return RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof im)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        im imVar = (im) obj;
        for (C0696a c0696a : RL.values()) {
            if (m2738a(c0696a)) {
                if (!imVar.m2738a(c0696a)) {
                    return false;
                }
                if (!m2739b(c0696a).equals(imVar.m2739b(c0696a))) {
                    return false;
                }
            } else if (imVar.m2738a(c0696a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return hR();
    }

    public ItemScope getAbout() {
        return this.RN;
    }

    public List<String> getAdditionalName() {
        return this.RO;
    }

    public ItemScope getAddress() {
        return this.RP;
    }

    public String getAddressCountry() {
        return this.RQ;
    }

    public String getAddressLocality() {
        return this.RR;
    }

    public String getAddressRegion() {
        return this.RS;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.RT;
    }

    public int getAttendeeCount() {
        return this.RU;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.RV;
    }

    public ItemScope getAudio() {
        return this.RW;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.RX;
    }

    public String getBestRating() {
        return this.RY;
    }

    public String getBirthDate() {
        return this.RZ;
    }

    public ItemScope getByArtist() {
        return this.Sa;
    }

    public String getCaption() {
        return this.Sb;
    }

    public String getContentSize() {
        return this.Sc;
    }

    public String getContentUrl() {
        return this.lt;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.Sd;
    }

    public String getDateCreated() {
        return this.Se;
    }

    public String getDateModified() {
        return this.Sf;
    }

    public String getDatePublished() {
        return this.Sg;
    }

    public String getDescription() {
        return this.FH;
    }

    public String getDuration() {
        return this.Sh;
    }

    public String getEmbedUrl() {
        return this.Si;
    }

    public String getEndDate() {
        return this.Sj;
    }

    public String getFamilyName() {
        return this.Sk;
    }

    public String getGender() {
        return this.Sl;
    }

    public ItemScope getGeo() {
        return this.Sm;
    }

    public String getGivenName() {
        return this.Sn;
    }

    public String getHeight() {
        return this.So;
    }

    public String getId() {
        return this.uS;
    }

    public String getImage() {
        return this.Sp;
    }

    public ItemScope getInAlbum() {
        return this.Sq;
    }

    public double getLatitude() {
        return this.KX;
    }

    public ItemScope getLocation() {
        return this.Sr;
    }

    public double getLongitude() {
        return this.KY;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.Ss;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.St;
    }

    public String getPlayerType() {
        return this.Su;
    }

    public String getPostOfficeBoxNumber() {
        return this.Sv;
    }

    public String getPostalCode() {
        return this.Sw;
    }

    public String getRatingValue() {
        return this.Sx;
    }

    public ItemScope getReviewRating() {
        return this.Sy;
    }

    public String getStartDate() {
        return this.Sz;
    }

    public String getStreetAddress() {
        return this.SA;
    }

    public String getText() {
        return this.SB;
    }

    public ItemScope getThumbnail() {
        return this.SC;
    }

    public String getThumbnailUrl() {
        return this.SD;
    }

    public String getTickerSymbol() {
        return this.SE;
    }

    public String getType() {
        return this.Oc;
    }

    public String getUrl() {
        return this.pS;
    }

    int getVersionCode() {
        return this.wj;
    }

    public String getWidth() {
        return this.SF;
    }

    public String getWorstRating() {
        return this.SG;
    }

    Set<Integer> hB() {
        return this.RM;
    }

    im hC() {
        return this.RN;
    }

    im hD() {
        return this.RP;
    }

    List<im> hE() {
        return this.RT;
    }

    List<im> hF() {
        return this.RV;
    }

    im hG() {
        return this.RW;
    }

    List<im> hH() {
        return this.RX;
    }

    im hI() {
        return this.Sa;
    }

    List<im> hJ() {
        return this.Sd;
    }

    im hK() {
        return this.Sm;
    }

    im hL() {
        return this.Sq;
    }

    im hM() {
        return this.Sr;
    }

    im hN() {
        return this.Ss;
    }

    List<im> hO() {
        return this.St;
    }

    im hP() {
        return this.Sy;
    }

    im hQ() {
        return this.SC;
    }

    public im hR() {
        return this;
    }

    public boolean hasAbout() {
        return this.RM.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.RM.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.RM.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.RM.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.RM.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.RM.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.RM.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.RM.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.RM.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.RM.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.RM.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.RM.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.RM.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.RM.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.RM.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.RM.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.RM.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.RM.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.RM.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.RM.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.RM.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.RM.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.RM.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.RM.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.RM.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.RM.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.RM.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.RM.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.RM.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.RM.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.RM.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.RM.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.RM.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.RM.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.RM.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.RM.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.RM.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.RM.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.RM.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.RM.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.RM.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.RM.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.RM.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.RM.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.RM.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.RM.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.RM.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.RM.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.RM.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.RM.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.RM.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.RM.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.RM.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.RM.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (C0696a c0696a : RL.values()) {
            int hashCode;
            if (m2738a(c0696a)) {
                hashCode = m2739b(c0696a).hashCode() + (i + c0696a.eu());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        in inVar = CREATOR;
        in.m990a(this, out, flags);
    }
}
