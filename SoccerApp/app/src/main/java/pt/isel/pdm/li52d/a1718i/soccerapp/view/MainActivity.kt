package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.service.ResultsService
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.MyApplication
import java.util.*


class MainActivity : Activity() {
    val TAG: String = MainActivity::class.simpleName!!;

    var handler: Handler? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "Current device language ${Locale.getDefault().language}")
        Log.i(TAG, "Activity pid ${android.os.Process.myPid()}")

        MyApplication.Handler.onMessage("service_status") {
            startService.text = "Service started"
        }

        searchBtn.setOnClickListener {
            Log.i(TAG, "click pressed on internal button")
//            if (leagueEdit.text.toString().trim().equals("")) {
//                showAlertDialog(R.string.league_not_supplied)
//                return@setOnClickListener
//            }


            val intent = Intent(this, SoccerListActivity::class.java)
            intent.putExtra(EXTRA_TEXT, leagueEdit.text.toString())

            startActivity(intent)

        }

        startService.setOnClickListener {
            startService.text = "Service Starting..."
            this.startService(Intent(this, ResultsService::class.java))
        }


        // Get optional search string from intent
        val search: String =  intent.getStringExtra("search") ?:  "";
        leagueEdit.setText(search)
    }

    private fun showAlertDialog(messageId: Int) {
        AlertDialog.Builder(this).setTitle(R.string.leage_not_supported_title).setMessage(messageId)
                .setPositiveButton("Continue", { dialog, which ->
                    // Just close alert.
                })
                .show()

    }
}
