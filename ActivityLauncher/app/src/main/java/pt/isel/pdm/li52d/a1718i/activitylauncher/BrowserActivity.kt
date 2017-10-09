package pt.isel.pdm.li52d.a1718i.activitylauncher

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_browser.*

class BrowserActivity : Activity() {
    val TAG: String = "BrowserActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_browser)


        val uri: String = intent?.dataString ?: "http://www.isel.pt"
        Log.i(TAG, "intent data: " + uri);

        editText.setText(uri);

        browser.settings.javaScriptEnabled = true;
        browser.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        };
        browser.loadUrl(uri)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
