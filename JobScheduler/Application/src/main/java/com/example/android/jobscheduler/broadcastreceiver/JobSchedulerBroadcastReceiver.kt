package com.example.android.jobscheduler.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


/**
 * Created by lfalcao on 08/11/2017.
 */

class JobSchedulerBroadcastReceiver : BroadcastReceiver() {
//    val TAG: String = JobSchedulerBroadcastReceiver::class.simpleName!!;
    // am broadcast -a android.intent.action.BOOT_COMPLETED
    val TAG: String = "JobSchedulerBReceiver";
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "Broadcast receiver onReceive called with intent $intent")
    }
}