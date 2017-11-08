package pt.isel.pdm.li52d.a1718i.soccerapp.service

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.os.Message
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
        Log.i(TAG, "ResultsService onCreate with pid ${android.os.Process.myPid()} and in thread ${Thread.currentThread().id} ")


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

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "ResultsService service onDestroy")
    }

}