package pt.isel.pdm.li52d.a1718i.soccerapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import pt.isel.pdm.li52d.a1718i.soccerapp.data.ImagesApiRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.data.SoccerApiRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations.SoccerAppOperations
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.MessageHandler
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.Notifications

/**
 * Created by lfalcao on 16/10/2017.
 */
class MyApplication: Application() {
    val TAG: String = "MyApplication";

    val Handler: MessageHandler = MessageHandler();
    lateinit var Notifications: Notifications

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "My Application started")

        HttpRequests.init(applicationContext)

        SoccerAppOperations.SoccerRepository = SoccerApiRepository;
        SoccerAppOperations.ImagesRepository = ImagesApiRepository;
        //scheduleJobs()

        Notifications = Notifications(this)


    }

//    private fun scheduleJobs() {
//        val jobScheduler: JobScheduler = this.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
//
//        val schedule = jobScheduler.schedule(JobInfo.Builder(LOAD_LATEST_RESULTS,
//                ComponentName(this, ResultsJobService::class.java))
//                //.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
//                .setPeriodic(2000)
//                .build())
//    }
//
}