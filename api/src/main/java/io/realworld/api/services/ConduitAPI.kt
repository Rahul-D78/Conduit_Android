package io.realworld.api.services

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.requests.SignUpRequest
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.TagsResponse
import io.realworld.api.models.responses.UserRespone
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signUpUser(
        @Body UserCreds: SignUpRequest
    ): Response<UserRespone>

    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserRespone>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag :String? = null
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticlesBySlug(
        @Path("slug") slug: String
    ): Response<ArticlesResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>
}