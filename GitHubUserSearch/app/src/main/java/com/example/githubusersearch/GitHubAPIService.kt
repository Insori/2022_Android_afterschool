package com.example.githubusersearch

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import java.lang.reflect.Type

interface GitHubAPIService {
    @GET("/users/{user}")
    fun getUser(
        @Path("user") id: String,
        @Header("Authorization") pat: String
    ) : Call<GitHubUser>

    @GET("/users/{userId}/repos")
    fun getRepos(
        @Path("userId") id: String,
        @Header("Authorization") pat: String
    ) : Call<List<GitHubRepo>>
}

data class GitHubRepo(
    val name: String,
    val html_url: String,
    val description: String?,
    val forks_count: Int,
    val watchers_count: Int,
    val stargazers_count: Int
)

data class GitHubUser(
    val id: Int,
    val login: String,
    val name : String?,
    val followers : Int,
    val following : Int,
    @SerializedName("avatar_url")
    val avatar_url : String
)

/*
class GitHubUserDeserializer : JsonDeserializer<GitHubUser> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GitHubUser {
        val node = json?.getAsJsonObject()
        val id = node?.getAsJsonPrimitive("id")?.asInt
        val login = node?.getAsJsonPrimitive("login")?.asString
        val name = node?.getAsJsonPrimitive("name")?.asString
        val followers = node?.getAsJsonPrimitive("followers")?.asInt
        val following = node?.getAsJsonPrimitive("following")?.asInt

        return GitHubUser(id!!, login!!, name!!, followers!!, following!!)
    }

}
*/