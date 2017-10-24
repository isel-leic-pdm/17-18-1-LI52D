package pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos

/**
 * Created by lfalcao on 23/10/2017.
 */


data class ResultQwant(val data: Data ) {
}

data class Data(val result: Result) {
}

data class Result(val items: List<ImageItem>) {
}


data class ImageItem(val title: String, var thumbnail: String) {
}