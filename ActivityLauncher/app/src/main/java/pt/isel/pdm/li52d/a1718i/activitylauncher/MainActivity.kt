package pt.isel.pdm.li52d.a1718i.activitylauncher

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : Activity() {
    val TAG: String = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlBtn.setOnClickListener {
            val urlText: String = url.text.toString();
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(urlText)))
        }

        internalBtn.setOnClickListener {
            Log.i(TAG, "click pressed on internal button")
            startActivity(Intent(this, InternalActivity::class.java))
        }

        browserActivityBtn.setOnClickListener {
            Log.i(TAG, "click pressed on browserActivity button")
            startActivity(Intent(this, BrowserActivity::class.java))
        }
    }
}
