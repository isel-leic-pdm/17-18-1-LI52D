package pt.isel.pdm.li52d.a1718i.helloworldandroid

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity1 : Activity() {
    val TAG: String = "MainActivity";
    private val COUNTER_KEY = "counter"



    private val textView: TextView
        get() {
            val counter: TextView = findViewById(R.id.counter)
            return counter
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter: TextView = textView

        //increment.setOnClickListener {}
//        decrement.setOnClickListener(clickListener(counter, "decrement", -1));
//        increment.setOnClickListener(clickListener(counter, "increment", 1));
   }

    private fun clickListener(counter: TextView, message: String, delta: Int): View.OnClickListener {
        return View.OnClickListener  {
                Log.i(TAG, "onClick invoked on $message.");
                val countValue: Int = counter.text.toString().toInt();
            Log.i(TAG, "current counter value is $countValue.");
                counter.text = (countValue + delta).toString()
        };

    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState called");
        outState?.putString(COUNTER_KEY, textView.text.toString());
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState called");
        val value = savedInstanceState?.getString(COUNTER_KEY)
        textView.text = value;

    }
}