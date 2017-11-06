package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.app.ListActivity
import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations.SoccerAppOperations
import pt.isel.pdm.li52d.a1718i.soccerapp.view.adapter.SoccerListAdapter
import android.view.Gravity
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League


class SoccerListActivity : ListActivity() {
    val TAG: String = SoccerListActivity::class.simpleName!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.soccer_list)

        // Show a PrograssBar while data loads
        val root = findViewById<View>(android.R.id.content) as ViewGroup


//        val progressBar = ProgressBar(this)
//        progressBar.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT)
//        progressBar.isIndeterminate = true
//        listView.emptyView = progressBar

        listView.emptyView = layoutInflater.inflate(R.layout.empty_list, null, false)
        // Must add the progress bar to the root of the layout
        root.addView(listView.emptyView)

        SoccerAppOperations.getLeagues(intent.extras[EXTRA_TEXT] as String) {
            listAdapter = SoccerListAdapter(it,
                    { "${it.name} (${it.shortName})" },
                    { it.imageUrl },
                    { it.image },
                    layoutInflater)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        Log.i(TAG, "Clicked optin for viwe bound to object ${v.tag}")

        var intent = Intent(this, LeagueDetailsActivity::class.java)
        intent.putExtra(League::class.simpleName, listAdapter.getItem(position) as League)
        startActivity(intent)
    }
}
