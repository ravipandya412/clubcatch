package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return true;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
            case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                return false;
            default:
                return true;
        }
    }
}
