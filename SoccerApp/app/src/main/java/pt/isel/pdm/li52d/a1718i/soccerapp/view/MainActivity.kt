package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations.SoccerAppOperations

class MainActivity : Activity() {
    val TAG: String = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchBtn.setOnClickListener {
            Log.i(TAG, "click pressed on internal button")
            SoccerAppOperations.getLeagues("") {
                result.text = it.toString()
            }
        }

    }
}
