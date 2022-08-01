package com.example.githubusersearch

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.reflect.Type

interface GitHubAPIService {
    @GET("/users/{user}")
    fun getGitHubServiceInfo(
        @Path("user") user: String
    ) : Call<GitHubServiceData>
}

data class GitHubServiceData(
    val id: Int,
    val login: String
)

class GitHubServiceDeserializerGSON : JsonDeserializer<GitHubServiceData> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GitHubServiceData {
        val node = json?.getAsJsonObject()
        val id = node?.getAsJsonPrimitive("id")?.asInt
        val login = node?.getAsJsonPrimitive("login")?.asString

        return GitHubServiceData(id!!, login!!)
    }

}