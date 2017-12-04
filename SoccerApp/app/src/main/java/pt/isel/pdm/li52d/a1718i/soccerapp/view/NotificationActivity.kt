package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.Activity
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notifications.*
import kotlinx.android.synthetic.main.toast.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.MyApplication


class NotificationActivity : Activity() {
    lateinit var notificationService: NotificationManager;
    private var notificationId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        notificationService = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        showToast.setOnClickListener {
            val toast = Toast.makeText(this, notificationText.text, Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP xor Gravity.LEFT, 0, 0)

            val layout = layoutInflater.inflate(R.layout.toast, toast_layout_root, true)
            toast.view = layout

            layout.findViewById<TextView>(R.id.toastMessage).text = notificationText.text

            toast.show()
        }

        showNotificationChannel1.setOnClickListener {
            showNotification(MyApplication.Notifications.CHANNEL_ID1)
        }

        showNotificationChannel2.setOnClickListener {
            showNotification(MyApplication.Notifications.CHANNEL_ID2)
        }
    }

    fun showNotification(chId: String) {
        val builder = Notification.Builder(this, chId)
                //val builder = Notification.Builder(this)
                .setTicker("New message arrived")
                .setContentTitle("Title of Message")
                .setSmallIcon(R.mipmap.country_flag)
                .setContentText(notificationText.text)

        notificationService.notify(notificationId++, builder.build())
    }

}
