package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.location.DetectedActivity;

public class df extends WebChromeClient {
    private final dd ng;

    /* renamed from: com.google.android.gms.internal.df.1 */
    static class C03101 implements OnCancelListener {
        final /* synthetic */ JsResult qo;

        C03101(JsResult jsResult) {
            this.qo = jsResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.qo.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.df.2 */
    static class C03112 implements OnClickListener {
        final /* synthetic */ JsResult qo;

        C03112(JsResult jsResult) {
            this.qo = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.qo.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.df.3 */
    static class C03123 implements OnClickListener {
        final /* synthetic */ JsResult qo;

        C03123(JsResult jsResult) {
            this.qo = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.qo.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.df.4 */
    static class C03134 implements OnCancelListener {
        final /* synthetic */ JsPromptResult qp;

        C03134(JsPromptResult jsPromptResult) {
            this.qp = jsPromptResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.qp.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.df.5 */
    static class C03145 implements OnClickListener {
        final /* synthetic */ JsPromptResult qp;

        C03145(JsPromptResult jsPromptResult) {
            this.qp = jsPromptResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.qp.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.df.6 */
    static class C03156 implements OnClickListener {
        final /* synthetic */ JsPromptResult qp;
        final /* synthetic */ EditText qq;

        C03156(JsPromptResult jsPromptResult, EditText editText) {
            this.qp = jsPromptResult;
            this.qq = editText;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.qp.confirm(this.qq.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.df.7 */
    static /* synthetic */ class C03167 {
        static final /* synthetic */ int[] qr;

        static {
            qr = new int[MessageLevel.values().length];
            try {
                qr[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                qr[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                qr[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                qr[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                qr[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public df(dd ddVar) {
        this.ng = ddVar;
    }

    private static void m593a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C03123(jsResult)).setNegativeButton(17039360, new C03112(jsResult)).setOnCancelListener(new C03101(jsResult)).create().show();
    }

    private static void m594a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C03156(jsPromptResult, editText)).setNegativeButton(17039360, new C03145(jsPromptResult)).setOnCancelListener(new C03134(jsPromptResult)).create().show();
    }

    private static boolean m595a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        if (z) {
            m594a(context, builder, str2, str3, jsPromptResult);
        } else {
            m593a(builder, str2, jsResult);
        }
        return true;
    }

    protected final void m596a(View view, int i, CustomViewCallback customViewCallback) {
        bo ba = this.ng.ba();
        if (ba == null) {
            da.m570w("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        ba.m2458a(view, customViewCallback);
        ba.setRequestedOrientation(i);
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof dd) {
            bo ba = ((dd) webView).ba();
            if (ba == null) {
                da.m570w("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                ba.close();
                return;
            }
        }
        da.m570w("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (C03167.qr[consoleMessage.messageLevel().ordinal()]) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                da.m567t(str);
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                da.m570w(str);
                break;
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
                da.m568u(str);
                break;
            case DetectedActivity.TILTING /*5*/:
                da.m566s(str);
                break;
            default:
                da.m568u(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        WebViewTransport webViewTransport = (WebViewTransport) resultMsg.obj;
        WebView webView = new WebView(view.getContext());
        webView.setWebViewClient(this.ng.bb());
        webViewTransport.setWebView(webView);
        resultMsg.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        bo ba = this.ng.ba();
        if (ba == null) {
            da.m570w("Could not get ad overlay when hiding custom view.");
        } else {
            ba.aq();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return m595a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return m595a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return m595a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return m595a(webView.getContext(), url, message, defaultValue, null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m596a(view, -1, customViewCallback);
    }
}
