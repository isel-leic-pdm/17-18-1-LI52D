package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import android.app.Activity
import android.app.Service
import pt.isel.pdm.li52d.a1718i.soccerapp.MyApplication

/**
 * Created by lfalcao on 06/11/2017.
 */


val Activity.MyApplication: MyApplication
        get() = this.application as MyApplication

val Service.MyApplication: MyApplication
    get() = this.application as MyApplication