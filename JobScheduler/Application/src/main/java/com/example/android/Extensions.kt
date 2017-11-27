package com.example.android

import android.app.Activity
import android.app.Service
import com.example.android.jobscheduler.MyApplication

/**
 * Created by lfalcao on 06/11/2017.
 */


val Activity.MyApplication: MyApplication
        get() = this.application as MyApplication

val Service.MyApplication: MyApplication
    get() = this.application as MyApplication