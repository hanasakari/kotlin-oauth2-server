package nl.myndocs.oauth2.json

import com.google.gson.Gson

object JsonMapper {
    private val gson = Gson()

    fun toJson(content: Any) = gson.toJson(content)
}