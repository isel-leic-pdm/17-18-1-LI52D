package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.reflect.KClass

/**
 * Created by lfalcao on 16/10/2017.
 */
object JsonConverter {
    val mapper: ObjectMapper = ObjectMapper();

    public fun <T : Any> convert(str: String, kclass: KClass<T>) : T {
        val ret: T =  mapper.readValue(str, kclass.java)
        return ret
    }
}