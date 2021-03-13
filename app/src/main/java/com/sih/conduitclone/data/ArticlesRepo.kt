package com.sih.conduitclone.data

import io.realworld.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()
}