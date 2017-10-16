package pt.isel.pdm.li52d.a1718i.soccerapp

import android.app.Application
import android.util.Log
import pt.isel.pdm.li52d.a1718i.soccerapp.data.SoccerApiRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations.SoccerAppOperations
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests

/**
 * Created by lfalcao on 16/10/2017.
 */
class MyApplication: Application() {
    val TAG: String = "MyApplication";
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "My Application started1")

        HttpRequests.init(applicationContext)

        SoccerAppOperations.Repository = SoccerApiRepository;
    }
}