package pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities

import android.graphics.Bitmap

/**
 * Created by lfalcao on 16/10/2017.
 */
data class League(val id: Int, val name: String, val shortName: String, val currentMatchday: Int, val numberOfMatchdays: Int, val imageUrl: String, val image: Bitmap?) {

}