package io.realworld.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRespone(
    @Json(name = "user")
    val user: User
)