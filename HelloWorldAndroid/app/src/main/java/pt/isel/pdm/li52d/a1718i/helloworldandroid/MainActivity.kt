package pt.isel.pdm.li52d.a1718i.helloworldandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val TAG: String = "MainActivity";

class MainActivity : Activity() {
    private val COUNTER_KEY = "currentValue"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter.text = "";
        increment.setOnClickListener(getOnClickListener("increment", 1));
        decrement.setOnClickListener(getOnClickListener("decrement", -1));
    }

    private var currentValue: Int
        get() = counter.text.toString().toInt()
        set(value) { counter.text = value.toString() }


private fun getOnClickListener(message: String, delta: Int): View.OnClickListener {
    return View.OnClickListener {
        Log.i(TAG, "$message click called")
        currentValue += delta*2;
    }

}

}
