package pt.isel.pdm.li52d.a1718i.soccerapp.view.adapter

import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import pt.isel.pdm.li52d.a1718i.soccerapp.R
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests

/**
 * Created by lfalcao on 21/10/2017.
 */


const val IMAGE_WIDTH = 60
const val IMAGE_HEIGHT = 60

class  SoccerListAdapter<T>(val list: List<T>, val textExtractor: (T) -> String, val urlExtractor: (T)-> String?, val imageExtractor: (T) -> Bitmap?, val layoutInflater: LayoutInflater) : BaseAdapter() {
    val TAG: String = SoccerListAdapter::class.simpleName!!;

    override fun getItemId(idx: Int): Long = idx.toLong()

    override fun getCount(): Int = list.size

    override fun getItem(idx: Int): Any = list[idx] as Any;

    // override other abstract methods here

    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        Log.i(TAG, "getView called with - position: $position")

        var convertView = convertView
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_view, container, false)
        }

        val retView : View = convertView!!;


        val item: T = list[position];
        val caption = convertView?.findViewById<TextView>(R.id.caption)
        caption?.text = textExtractor(item)

        setImage(item, retView.findViewById<ImageView>(R.id.image))

        return retView!!
    }

    private fun setImage(item: T, image: ImageView) {
        image.tag = item;
        val tag = image.tag;

        val url = urlExtractor(item);
        if (url != null) {
            HttpRequests.getImage(url, IMAGE_WIDTH, IMAGE_HEIGHT,
                    { err, bitmap ->
                        if (err == null) {
                            Log.e(TAG, "Could not obtain image");
                        }
                        if (tag == image.tag)
                            image.setImageBitmap(bitmap!!)

                    })
            image.setImageResource(R.mipmap.ic_launcher)
        }
    }
}
