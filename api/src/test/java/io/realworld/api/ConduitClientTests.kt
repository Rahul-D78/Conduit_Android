package io.realworld.api

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.SignUpRequest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertNotNull
import kotlin.random.Random

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET ARTICLE`() {
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`() {
        runBlocking {
           val articles = conduitClient.api.getArticles(author ="444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `POST users - create`() {
        runBlocking {
            val userCreds =  UserCreds(
                    email = "testemail${Random.nextInt(999, 9999)}@test.com",
                    password = "pass${Random.nextInt(9999, 99999)}",
                    username = "user${Random.nextInt(99, 999)}"

            )
            runBlocking {
                val resp = ConduitClient().api.signUpUser(SignUpRequest(userCreds))
                assertEquals(userCreds.username, resp.body()?.user?.username)
            }


        }
    }
}