package pt.isel.pdm.profslist.provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.text.TextUtils
import android.util.Log

import pt.isel.pdm.profslist.provider.ProfsContract.get

/*
 * Original ideas taken from:
 * https://www.grokkingandroid.com/android-tutorial-writing-your-own-content-provider/
 */

class ProfsProvider : ContentProvider() {
    val TAG: String = ProfsProvider::class.java.simpleName;
    private val PROFS_LST = 1
    private val PROFS_OBJ = 2



    private val URI_MATCHER : UriMatcher

    init {
        URI_MATCHER = UriMatcher(UriMatcher.NO_MATCH)

        URI_MATCHER.addURI(
                ProfsContract.AUTHORITY,
                ProfsContract.Profs.RESOURCE,
                PROFS_LST
        )
        URI_MATCHER.addURI(
                ProfsContract.AUTHORITY,
                ProfsContract.Profs.RESOURCE + "/#",
                PROFS_OBJ
        )
    }

    private lateinit var dbHelper: DbOpenHelper

    override fun onCreate(): Boolean {
        dbHelper = DbOpenHelper(context)
        changeNames()
        return true
    }



    override fun getType(uri: Uri?): String {
        return when (URI_MATCHER.match(uri)) {
            PROFS_LST -> ProfsContract.Profs.CONTENT_TYPE
            PROFS_OBJ -> ProfsContract.Profs.CONTENT_ITEM_TYPE
            else -> throw badUri(uri)
        }
    }

    override fun query(uri: Uri?, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
        Log.i(TAG, "query called for ${uri}")
        var sortOrder = sortOrder

        val qbuilder = SQLiteQueryBuilder()
        when (URI_MATCHER.match(uri)) {
            PROFS_LST -> {
                qbuilder.tables = DbSchema.Profs.TBL_NAME
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = ProfsContract.Profs.DEFAULT_SORT_ORDER
                }
            }
            PROFS_OBJ -> {
                qbuilder.tables = DbSchema.Profs.TBL_NAME
                qbuilder.appendWhere(DbSchema.COL_ID + "=" + uri!!.lastPathSegment)
            }
            else -> throw badUri(uri)
        }

        val db = dbHelper.readableDatabase
        val cursor = qbuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder)

        //cursor.setNotificationUri(context.contentResolver, uri);
        return cursor
    }

    override fun insert(uri: Uri?, values: ContentValues?): Uri {
        val table : String
        when (URI_MATCHER.match(uri)) {
            PROFS_LST -> table = DbSchema.Profs.TBL_NAME
            else -> throw badUri(uri)
        }

        val db = dbHelper.writableDatabase
        val newId = db.insert(table, null, values)
        if(newId > 0) {
            var insertedUri: Uri = ContentUris.withAppendedId(uri, newId)
            getContext().contentResolver.notifyChange(insertedUri, null);
            return insertedUri
        }

        throw SQLException("Failed to insert row into " + uri);

    }

    override fun update(uri: Uri?, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val count = internalUpdate(uri, values, selection, selectionArgs)
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }

    override fun delete(uri: Uri?, selection: String?, selectionArgs: Array<out String>?): Int {
        val table : String
        when (URI_MATCHER.match(uri)) {
            PROFS_LST -> {
                table = DbSchema.Profs.TBL_NAME
                if (selection != null) {
                    throw IllegalArgumentException("selection not supported")
                }
            }
            else -> throw badUri(uri)
        }

        val db = dbHelper!!.writableDatabase
        var ndel = db.delete(table, null, null)

        getContext().getContentResolver().notifyChange(uri, null);

        return ndel
    }



    fun internalUpdate(uri: Uri?, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = dbHelper.writableDatabase
        var count: Int
        var where: String = selection ?: ""
        when (URI_MATCHER.match(uri)) {
            PROFS_LST -> { }
        // If URI is main table, update uses incoming where clause and args.

            PROFS_OBJ -> {
                // If URI is for a particular row ID, update is based on incoming
                // data but modified to restrict to the given ID.
                where = DbSchema.COL_ID + " = " + ContentUris.parseId(uri)

            }
            else -> throw IllegalArgumentException("Unknown URI " + uri)
        }

        count = db.update(DbSchema.Profs.TBL_NAME, values, where, selectionArgs)

        return count
    }


    private fun badUri(uri: Uri?) =
            IllegalArgumentException("unknown uri: $uri");


    private fun changeNames() {
        val t = Thread {
            var count = 0

            while(true) {
                val cursor = query(ProfsContract.Profs.CONTENT_URI, arrayOf(ProfsContract.Profs.ID, ProfsContract.Profs.NAME), null, null, null)
                while(cursor.moveToNext()) {
                    count = (count+1) % 10
                    val id = cursor.getInt(0)
                    var name = cursor.getString(1)
                    name = name.replaceAfter("-", count.toString())
                    val values = ContentValues();
                    values.put(ProfsContract.Profs.NAME, name)

                    val uri = ProfsContract.Profs.OBJ_URI[id]
                    Log.i(TAG, "changing record with uri ${uri}")
                    internalUpdate(uri, values, null, null)

                }
                context!!.contentResolver.notifyChange(ProfsContract.Profs.CONTENT_URI, null)
                cursor.close()
                Thread.sleep(2000)
            }

        }
        t.start()
    }
}


