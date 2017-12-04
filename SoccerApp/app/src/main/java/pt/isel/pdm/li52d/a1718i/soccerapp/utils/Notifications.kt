package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

/**
 * Created by lfalcao on 27/11/2017.
 */
class Notifications(context: Context) {
    val CHANNEL_ID1 = "SoccerAppChannel1"
    val SOCCER_APP_CHANNEL_NAME1 = "SoccerApp1"

    val CHANNEL_ID2 = "SoccerAppChannel2"
    val SOCCER_APP_CHANNEL_NAME2 = "SoccerApp2"

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if(nm.getNotificationChannel(CHANNEL_ID1) == null) {
                // Create Channel 1
                val notificationChannel1 = NotificationChannel(CHANNEL_ID1, SOCCER_APP_CHANNEL_NAME1, NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel1.enableLights(true)
                nm.createNotificationChannel(notificationChannel1)


                // Create Channel 2
                val notificationChannel2 = NotificationChannel(CHANNEL_ID2, SOCCER_APP_CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel2.enableLights(true)
                nm.createNotificationChannel(notificationChannel2)
            }
        }
    }

}