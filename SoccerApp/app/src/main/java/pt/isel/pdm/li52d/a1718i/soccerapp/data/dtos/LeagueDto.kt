package pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by lfalcao on 16/10/2017.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
data class LeagueDto(val id: Int, val caption: String, val league: String, val currentMatchday: Int, val numberOfMatchdays: Int) {
}