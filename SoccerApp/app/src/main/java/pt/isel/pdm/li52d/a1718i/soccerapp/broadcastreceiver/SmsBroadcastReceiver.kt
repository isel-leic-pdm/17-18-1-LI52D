package pt.isel.pdm.li52d.a1718i.soccerapp.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import pt.isel.pdm.li52d.a1718i.soccerapp.view.MainActivity

/**
 * Created by lfalcao on 08/11/2017.
 */
class SmsBroadcastReceiver : BroadcastReceiver() {
    val TAG: String = ServiceLaucherBroadcastReceiver::class.simpleName!!;
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "SMSBroadcast receiver onReceive called with intent $intent")

        val messagesFromIntent: Array<SmsMessage> = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        Log.i(TAG, "SMSBroadcast receiver messages are: ")
        messagesFromIntent.forEach { m -> Log.i(TAG, "Message: ${m.displayMessageBody}") }


        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.putExtra("search", messagesFromIntent[0].displayMessageBody)
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context?.startActivity(activityIntent)

    }

}