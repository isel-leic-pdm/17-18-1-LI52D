package pt.isel.pdm.li52d.a1718i.soccerapp.data

import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto

/**
 * Created by lfalcao on 16/10/2017.
 */
interface SoccerRepository {
    fun searchLeagues(searchStr: String, cb: (LeagueDto) -> Unit) : Unit
}