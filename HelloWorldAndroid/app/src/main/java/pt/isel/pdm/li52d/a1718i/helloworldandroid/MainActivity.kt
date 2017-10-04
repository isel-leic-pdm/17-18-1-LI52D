package pt.isel.pdm.li52d.a1718i.helloworldandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

const val TAG: String = "MainActivity";

class MainActivity : Activity() {
    private val COUNTER_KEY = "currentValue"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        increment.setOnClickListener(getOnClickListener("increment", 1));
        decrement.setOnClickListener(getOnClickListener("decrement", -1));
        
    }

    private var currentValue: Int
        get() = counter.text.toString().toInt()
        set(value) {
            counter.text = value.toString()
        }

    private var maxValue: Int = 0
        get() = max.text.toString().toInt() +1


    private fun getOnClickListener(message: String, delta: Int): View.OnClickListener {
        return View.OnClickListener {
            Log.i(TAG, "$message click called")

            currentValue = (currentValue + maxValue + delta) % maxValue
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState called");
        outState?.putInt(COUNTER_KEY, currentValue);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState called");
        currentValue = savedInstanceState?.getInt(COUNTER_KEY) ?: 0

    }

}
