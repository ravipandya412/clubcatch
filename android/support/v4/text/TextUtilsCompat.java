package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.Locale;

public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    public static final Locale ROOT;

    @NonNull
    public static String htmlEncode(@NonNull String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                    sb.append("&quot;");
                    break;
                case C0519R.styleable.Theme_actionModeWebSearchDrawable /*38*/:
                    sb.append("&amp;");
                    break;
                case C0519R.styleable.Theme_actionModePopupWindowStyle /*39*/:
                    sb.append("&#39;");
                    break;
                case C0519R.styleable.Theme_popupMenuStyle /*60*/:
                    sb.append("&lt;");
                    break;
                case C0519R.styleable.Theme_editTextColor /*62*/:
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        if (!(locale == null || locale.equals(ROOT))) {
            String scriptSubtag = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (scriptSubtag == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (scriptSubtag.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || scriptSubtag.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case DetectedActivity.ON_FOOT /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    static {
        ROOT = new Locale("", "");
        ARAB_SCRIPT_SUBTAG = "Arab";
        HEBR_SCRIPT_SUBTAG = "Hebr";
    }
}
