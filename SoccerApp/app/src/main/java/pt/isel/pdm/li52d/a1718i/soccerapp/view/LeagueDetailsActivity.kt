package pt.isel.pdm.li52d.a1718i.soccerapp.view

import android.os.Bundle
import android.app.Activity
import kotlinx.android.synthetic.main.league_details_activity.*

import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League

class LeagueDetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.league_details_activity)

        var league: League = intent.getParcelableExtra(League::class.simpleName)
        name.text = league.name + '(' + league.shortName + ')'
    }

}
