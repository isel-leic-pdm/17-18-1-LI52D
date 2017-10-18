package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue
import com.android.volley.Response


/**
 * Created by lfalcao on 16/10/2017.
 */
object HttpRequests {
    val TAG: String = "HttpRequests";

    private var queue: RequestQueue? = null

    public fun init(context: Context) {
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(context)
    }

    public fun get(url: String, responseCb: (String) -> Unit): Unit {
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response: String ->  processResponse(response, responseCb) },
                Response.ErrorListener { error -> responseCb("That didn't work!") })
        // Add the request to the RequestQueue.
        queue?.add(stringRequest)

    }

    private fun processResponse(response: String, responseCb: (String) -> Unit) {
        Log.i(TAG, "Response is: $response")
        responseCb(response)
    }
}