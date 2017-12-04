package pt.isel.pdm.profslist

import android.app.ListActivity
import android.app.LoaderManager
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.widget.SimpleCursorAdapter
import pt.isel.pdm.profslist.provider.ProfsContract

class MainActivity : ListActivity(), LoaderManager.LoaderCallbacks<Cursor> {
    val TAG: String = MainActivity::class.java.simpleName;

    private val PROFS_LOADER = 1

    val adapter by lazy {
        val from = arrayOf(ProfsContract.Profs.NAME, ProfsContract.Profs.EMAIL)
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        useContentResolver(from)

        SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null, from, to, 0)

    }

    private fun useContentResolver(from: Array<String>) {
        val cursor = contentResolver.query(ProfsContract.Profs.CONTENT_URI, from, null, null, ProfsContract.customSortOrder(arrayOf(ProfsContract.Profs.ID), false))
        while (cursor.moveToNext()) {
            Log.i(TAG, "name: ${cursor.getString(0)} email: ${cursor.getString(1)}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listView.adapter = adapter
        loaderManager.initLoader(PROFS_LOADER, null, this)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        when (id) {
            PROFS_LOADER ->
                CursorLoader(
                    this,
                    ProfsContract.Profs.CONTENT_URI,
                    ProfsContract.Profs.PROJECT_ALL,
                    null,
                    null,
                    null
                )
            else ->
                throw IllegalArgumentException("unknown id: $id")
        }

    override fun onLoadFinished(loader: Loader<Cursor>?, data: Cursor?) {
        adapter.changeCursor(data)
    }

    override fun onLoaderReset(loader: Loader<Cursor>?) {
        adapter.changeCursor(null)
    }
}
