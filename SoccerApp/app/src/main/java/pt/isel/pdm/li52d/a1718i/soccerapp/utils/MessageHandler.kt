package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import android.os.Bundle
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Handler

/**
 * Created by lfalcao on 06/11/2017.
 */
class MessageHandler() {
    val map: MutableMap<String, (String) -> Unit> = mutableMapOf();

    val handler = object : android.os.Handler() {
        override fun handleMessage(m: Message) {
            val key: String = m.data.keySet().first()
            map[key]?.invoke(m.data[key].toString());

        }
    }

    fun add(key: String, value: String) {
        val msg = Message.obtain();
        val bundle = Bundle();
        bundle.putString(key, value)
        msg.data = bundle

        handler.sendMessage(msg)
    }

    fun onMessage(key: String, cb: (value: String) -> Unit) {
        map[key] = cb;
    }


}