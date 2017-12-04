package pt.isel.pdm.li52d.a1718i.soccerapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


/**
 * Created by lfalcao on 08/11/2017.
 */

class JobSchedulerBroadcastReceiver : BroadcastReceiver() {
    val TAG: String = JobSchedulerBroadcastReceiver::class.simpleName!!;


    override fun onReceive(context: Context?, intent: Intent?) {
        // To generate a BOOT_COMPLETED intent without restarting the device use the following commend
        //
        // adb shell
        // su
        // am broadcast -a android.intent.action.BOOT_COMPLETED

        // adb shell am broadcast -a android.intent.action.BOOT_COMPLETED
        Log.i(TAG, "Broadcast receiver onReceive called with intent $intent")
    }
}