package pt.isel.pdm.li52d.a1718i.soccerapp.data

import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.JsonConverter

/**
 * Created by lfalcao on 16/10/2017.
 */




object SoccerFsRepository : SoccerRepository {
    override fun searchLeagues(searchStr: String, cb: (LeagueDto) -> Unit) : Unit {
        TODO("Not implemented")
    }



}