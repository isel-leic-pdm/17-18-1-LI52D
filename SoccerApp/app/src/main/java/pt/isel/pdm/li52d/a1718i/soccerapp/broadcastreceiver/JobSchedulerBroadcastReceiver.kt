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
        Log.i(TAG, "Broadcast receiver onReceive called with intent $intent")
    }
}