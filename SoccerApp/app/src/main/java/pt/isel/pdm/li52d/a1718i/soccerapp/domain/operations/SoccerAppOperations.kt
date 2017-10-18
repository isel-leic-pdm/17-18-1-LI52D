package pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations

import pt.isel.pdm.li52d.a1718i.soccerapp.data.SoccerRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.toDomain

/**
 * Created by lfalcao on 16/10/2017.
 */
object SoccerAppOperations {
    var Repository: SoccerRepository? = null;

    public fun getLeagues(search: String, leagues: (List<League>) -> Unit) : Unit{
        Repository?.searchLeagues(search) { leagues(it.map { it.toDomain() }) }
    }
}