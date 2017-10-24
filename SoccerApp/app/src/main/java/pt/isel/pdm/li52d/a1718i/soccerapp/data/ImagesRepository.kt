package pt.isel.pdm.li52d.a1718i.soccerapp.data

import android.graphics.Bitmap
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.ImageItem

/**
 * Created by lfalcao on 16/10/2017.
 */
interface ImagesRepository {
    fun serachImagesUrl(searchStr: String, numImages: Int, cb: (List<ImageItem>) -> Unit): Unit
    fun serachImages(searchStr: String, numImages: Int,  cb: (List<Bitmap>) -> Unit) : Unit
}