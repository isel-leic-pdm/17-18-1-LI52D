package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.Activity
import android.app.AlertDialog
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.service.ResultsService
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.MyApplication
import java.util.*
import android.view.MenuItem
import pt.isel.pdm.li52d.a1718i.soccerapp.service.ResultsJobService


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
        val search: String = intent.getStringExtra("search") ?: "";
        leagueEdit.setText(search)

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
        scheduleJob()
    }

    private fun showAlertDialog(messageId: Int) {
        AlertDialog.Builder(this).setTitle(R.string.leage_not_supported_title).setMessage(messageId)
                .setPositiveButton("Continue", { dialog, which ->
                    // Just close alert.
                })
                .show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.i(TAG, "onOptionsItemSelected")
        when(item?.itemId) {
           R.id.menu_notification  -> this.startActivity(Intent(this, NotificationActivity::class.java))
            R.id.shared_preferences  -> this.startActivity(Intent(this, SharedPreferencesActivity::class.java))
        }

        return super.onOptionsItemSelected(item);
    }

    var jobId = 0;
    private fun scheduleJob() {
        val jobScheduler: JobScheduler = this.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        val schedule = jobScheduler.schedule(JobInfo.Builder(jobId++,
                ComponentName(this, ResultsJobService::class.java))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                //.setPeriodic(2000)
                .build())
    }
}