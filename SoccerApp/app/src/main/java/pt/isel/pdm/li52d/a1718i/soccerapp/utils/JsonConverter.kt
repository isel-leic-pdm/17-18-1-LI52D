package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlin.reflect.KClass


/**
 * Created by lfalcao on 16/10/2017.
 */
object JsonConverter {
    val mapper: ObjectMapper = ObjectMapper().registerKotlinModule()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    inline fun <reified T : Any> convert(str: String) : T {
        val ret: T =  mapper.readValue(str)
        return ret
    }

    inline fun <reified T : Any> convertInJava(str: String, kclass: KClass<T>) : T {
        val ret: T =  mapper.readValue(str, kclass.java)
        return ret
    }
}