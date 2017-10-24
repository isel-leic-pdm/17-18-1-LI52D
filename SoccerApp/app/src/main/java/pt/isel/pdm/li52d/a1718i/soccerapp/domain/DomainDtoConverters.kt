package pt.isel.pdm.li52d.a1718i.soccerapp.domain

import android.graphics.Bitmap
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities.League

/**
 * Created by lfalcao on 17/10/2017.
 */


fun LeagueDto.toDomain(imageUrl: String, image: Bitmap?) : League = League(this.id, this.caption, this.league, this.currentMatchday, this.numberOfMatchdays, imageUrl, image)