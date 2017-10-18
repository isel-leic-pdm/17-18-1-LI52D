package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


/**
 * Created by lfalcao on 16/10/2017.
 */
object JsonConverter {
    val mapper: ObjectMapper = ObjectMapper().registerKotlinModule();

    public inline fun <reified T : Any> convert(str: String) : T {
        val ret: T =  mapper.readValue(str)
        return ret
    }
}