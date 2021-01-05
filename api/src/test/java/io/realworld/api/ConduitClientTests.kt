package io.realworld.api

import org.junit.Test
import org.junit.Assert.assertNotNull

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET ARTICLE`() {
        val articles = conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }
}