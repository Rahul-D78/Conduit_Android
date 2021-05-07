package com.sih.conduitclone.data

import io.realworld.api.ConduitClient
import io.realworld.api.models.entities.LoginData
import io.realworld.api.models.requests.LoginRequest
import io.realworld.api.models.responses.UserRespone

object UserRepo {

    val api = ConduitClient().api

    suspend fun login(email: String, password: String): UserRespone? {
        val response = api.loginUser(LoginRequest(LoginData(email, password)))
        return response.body()
    }
}