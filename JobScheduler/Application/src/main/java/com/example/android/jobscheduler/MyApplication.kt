package com.example.android.jobscheduler

import android.app.Application
import android.os.Messenger
import android.util.Log

/**
 * Created by lfalcao on 16/10/2017.
 */
class MyApplication: Application() {
    val LOAD_LATEST_RESULTS = 1;
    val TAG: String = "MyApplication";
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "My Application started1")

    }

    lateinit var Messenger: Messenger;
}