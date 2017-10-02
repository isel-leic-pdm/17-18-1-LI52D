package pt.isel.pdm.li52d.a1718i.helloworldandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

const val TAG: String = "MainActivity";

class MainActivity : Activity() {
    private val COUNTER_KEY = "counter"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decrement: Button = findViewById(R.id.decrement);
        val increment: Button = findViewById(R.id.increment);

        increment.setOnClickListener(getOnClickListener("increment", 1));
        decrement.setOnClickListener(getOnClickListener("derement", -1));
    }

    private var counter: Int
        get() = findViewById<TextView>(R.id.counter).text.toString().toInt()
        set(value) {
            findViewById<TextView>(R.id.counter).text = value.toString()
        }


private fun getOnClickListener(message: String, delta: Int): View.OnClickListener {
    return View.OnClickListener {
        Log.i(TAG, "$message click called")
        counter += delta*2;
    }

}

}
