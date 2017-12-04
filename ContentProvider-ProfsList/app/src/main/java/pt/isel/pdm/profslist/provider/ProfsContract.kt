package pt.isel.pdm.profslist.provider

import android.content.ContentResolver
import android.net.Uri
import android.provider.BaseColumns

object ProfsContract {

    val AUTHORITY = "pt.isel.pdm.profslist.provider"

    val CONTENT_PROVIDER_URI = Uri.parse("content://" + AUTHORITY)

    val MEDIA_BASE_SUBTYPE = "/vnd.profslist."

    object Profs : BaseColumns {
        val RESOURCE = "profs"

        val CONTENT_URI = Uri.withAppendedPath(
                ProfsContract.CONTENT_PROVIDER_URI,
                RESOURCE
        )

        val CONTENT_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + MEDIA_BASE_SUBTYPE + RESOURCE

        val CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + MEDIA_BASE_SUBTYPE + RESOURCE

        val ID = BaseColumns._ID
        val CODE = "code"
        val NAME = "name"
        val EMAIL = "email"

        val PROJECT_ALL = arrayOf(BaseColumns._ID, CODE, NAME, EMAIL)

        val DEFAULT_SORT_ORDER = NAME + " ASC"

    }

    fun customSortOrder(columnName: Array<String>, ascending: Boolean): String =
        columnName.joinToString { s -> s } + if(ascending) " ASC" else " DESC"


}