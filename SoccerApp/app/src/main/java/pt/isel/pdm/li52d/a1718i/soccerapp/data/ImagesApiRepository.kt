package pt.isel.pdm.li52d.a1718i.soccerapp.data

import android.graphics.Bitmap
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.ImageItem
import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.ResultQwant
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.JsonConverter
import java.net.URLEncoder

/**
 * Created by lfalcao on 16/10/2017.
 */


object ImagesApiRepository : ImagesRepository {
    private val BASE_URI = "https://api.qwant.com/api/search/images?"

    override fun serachImagesUrl(searchStr: String, numImages: Int, cb: (List<ImageItem>) -> Unit) {
        getImageItems(searchStr, numImages, cb);
    }

    private fun getImageItems(searchStr: String, numImages: Int, cb: (List<ImageItem>) -> Unit) {
        var searchStr = URLEncoder.encode(searchStr, "utf-8")
        val uri = BASE_URI + "count=$numImages&q=$searchStr"

        fun processImageSearchResults(str: String) {
            val resultQwant = JsonConverter.convert<ResultQwant>(str)

            resultQwant.data.result.items.forEach { it.thumbnail = "https:" + it.thumbnail };
            cb(resultQwant.data.result.items)

        }

        HttpRequests.get(uri, { processImageSearchResults(it) })

    }

    override fun serachImages(searchStr: String, numImages: Int, cb: (List<Bitmap>) -> Unit) : Unit {

        fun processImageItems(imageItems: List<ImageItem>): Unit {
            TODO("get bitmaps")
        }

        getImageItems(searchStr, numImages, { processImageItems(it) })
    }
}