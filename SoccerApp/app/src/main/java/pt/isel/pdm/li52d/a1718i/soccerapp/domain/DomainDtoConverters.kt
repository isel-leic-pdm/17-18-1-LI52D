package pt.isel.pdm.li52d.a1718i.soccerapp.domain

import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League

/**
 * Created by lfalcao on 17/10/2017.
 */


fun LeagueDto.toDomain() : League = League(this.id, this.caption, this.league)