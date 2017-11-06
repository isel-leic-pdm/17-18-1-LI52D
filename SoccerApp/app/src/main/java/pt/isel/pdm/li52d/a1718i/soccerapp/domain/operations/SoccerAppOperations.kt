package pt.isel.pdm.li52d.a1718i.soccerapp.domain.operations

import pt.isel.pdm.li52d.a1718i.soccerapp.data.ImagesRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.data.SoccerRepository
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.ImageItem
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.toDomain

/**
 * Created by lfalcao on 16/10/2017.
 */

const val IMAGE_WIDTH = 60
const val IMAGE_HEIGHT = 60

object SoccerAppOperations {
    var SoccerRepository: SoccerRepository? = null
    var ImagesRepository: ImagesRepository? = null

     public fun getLeagues(search: String, leaguesCb: (List<League>) -> Unit) : Unit {
        val leagues = ArrayList<League>().toMutableList()


        fun imageItemCallback(leagueDto: LeagueDto, size: Int): (List<ImageItem>) -> Unit {
            return { imageItems: List<ImageItem> ->
                leagues.add(leagueDto.toDomain(if(imageItems.size > 0) imageItems[0].thumbnail else null, null))
                if(size == leagues.size) {
                    leaguesCb(leagues)
                }
            }
        }

        SoccerRepository?.searchLeagues(search) { leagueDtos: List<LeagueDto> ->
            leagueDtos.forEach {
                ImagesRepository?.serachImagesUrl(it.caption, 1, imageItemCallback(it, leagueDtos.size)) }
        }
    }


}