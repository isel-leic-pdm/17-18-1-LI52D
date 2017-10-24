package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations.SoccerAppOperations
import android.content.DialogInterface
import android.app.AlertDialog
import android.content.Intent
import android.content.Intent.EXTRA_EMAIL
import android.content.Intent.EXTRA_TEXT
import pt.isel.pdm.li52d.a1718i.soccerapp.data.ImagesApiRepository


class MainActivity : Activity() {
    val TAG: String = MainActivity::class.simpleName!!;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchBtn.setOnClickListener {
            Log.i(TAG, "click pressed on internal button")
//            if (leagueEdit.text.toString().trim().equals("")) {
//                showAlertDialog(R.string.league_not_supplied)
//                return@setOnClickListener
//            }


            val intent = Intent(this, SoccerListActivity::class.java)
            intent.putExtra(EXTRA_TEXT, leagueEdit.text.toString())

            startActivity(intent)

        }
    }

    private fun showAlertDialog(messageId: Int) {
        AlertDialog.Builder(this).setTitle(R.string.leage_not_supported_title).setMessage(messageId)
                .setPositiveButton("Continue", { dialog, which ->
                    // Just close alert.
                })
                .show()

    }
}
