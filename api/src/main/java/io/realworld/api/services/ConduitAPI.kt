package io.realworld.api.services

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.SignUpRequest
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.UserRespone
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitAPI {

    @POST("users")
    suspend fun signUpUser(
        @Body UserCreds: SignUpRequest
    ): Response<UserRespone>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag :String? = null
    ): Response<ArticlesResponse>

}