package pt.isel.pdm.li52d.a1718i.soccerapp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.MyApplication


/**
 * Created by lfalcao on 06/11/2017.
 */
class ResultsService : Service() {
    val TAG = ResultsService::class.simpleName
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "ResultsService onCreate1 with pid ${android.os.Process.myPid()} and in thread ${Thread.currentThread().id} ")


        var t:Thread = Thread {
            MyApplication.Handler.add("service_status", "ok")
            Log.i(TAG, "ResultsService thread with pid ${android.os.Process.myPid()} and in thread ${Thread.currentThread().id} ")

            while (true) {
                Log.i(TAG, "ResultsService thread is going to sleep...")
                Thread.sleep(4000)
            }
        }
        t.name = "SLB"
        t.start();
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand thread with pid ${android.os.Process.myPid()}, in thread ${Thread.currentThread().id} with intent $intent")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "ResultsService service onDestroy")
    }
}