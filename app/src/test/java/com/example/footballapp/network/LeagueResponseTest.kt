
package com.example.footballapp.network

import com.example.footballapp.R
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.SandwichInitializer
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@RunWith(JUnit4::class)
class LeagueResponseTest {
    lateinit var service: LeagueService
    lateinit var mockWebServer: MockWebServer
    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse.error<String>(exception)
        assertThat(apiResponse.message, `is`("foo"))
    }

    @Test
    fun success() {
        val apiResponse =
            ApiResponse.of(SandwichInitializer.successCodeRange) { Response.success("foo") }
        if (apiResponse is ApiResponse.Success) {
            assertThat(apiResponse.data, `is`("foo"))
        }
    }

    @Throws(IOException::class)
    private fun enqueueResponse(file___NAME: String) {

        val mockResponse = MockResponse()
        mockWebServer = MockWebServer()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        var resp = "{\n" +
                "  \"get\":\"leagues\",\n" +
                "  \"parameters\":{\n" +
                "    \"season\":\"2021\",\n" +
                "    \"code\":\"HU\"\n" +
                "  },\n" +
                "  \"errors\":[\n" +
                "\n" +
                "  ],\n" +
                "  \"results\":6,\n" +
                "  \"paging\":{\n" +
                "    \"current\":1,\n" +
                "    \"total\":1\n" +
                "  },\n" +
                "  \"response\":[\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":271,\n" +
                "        \"name\":\"NB I\",\n" +
                "        \"type\":\"League\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/271.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-07-30\",\n" +
                "          \"end\":\"2022-05-14\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":true,\n" +
                "              \"statistics_fixtures\":true,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":true,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":272,\n" +
                "        \"name\":\"NB II\",\n" +
                "        \"type\":\"League\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/272.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-08-01\",\n" +
                "          \"end\":\"2022-05-22\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":true,\n" +
                "              \"statistics_fixtures\":false,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":true,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":634,\n" +
                "        \"name\":\"NB III - Nyugati\",\n" +
                "        \"type\":\"League\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/634.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-08-01\",\n" +
                "          \"end\":\"2022-05-29\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":false,\n" +
                "              \"statistics_fixtures\":false,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":true,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":633,\n" +
                "        \"name\":\"NB III - Keleti\",\n" +
                "        \"type\":\"League\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/633.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-08-01\",\n" +
                "          \"end\":\"2022-05-29\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":false,\n" +
                "              \"statistics_fixtures\":false,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":true,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":635,\n" +
                "        \"name\":\"NB III - K\\u00f6z\\u00e9p\",\n" +
                "        \"type\":\"League\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/635.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-08-01\",\n" +
                "          \"end\":\"2022-05-29\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":false,\n" +
                "              \"statistics_fixtures\":false,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":true,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"league\":{\n" +
                "        \"id\":273,\n" +
                "        \"name\":\"Magyar Kupa\",\n" +
                "        \"type\":\"Cup\",\n" +
                "        \"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/273.png\"\n" +
                "      },\n" +
                "      \"country\":{\n" +
                "        \"name\":\"Hungary\",\n" +
                "        \"code\":\"HU\",\n" +
                "        \"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\"\n" +
                "      },\n" +
                "      \"seasons\":[\n" +
                "        {\n" +
                "          \"year\":2021,\n" +
                "          \"start\":\"2021-08-07\",\n" +
                "          \"end\":\"2022-05-11\",\n" +
                "          \"current\":true,\n" +
                "          \"coverage\":{\n" +
                "            \"fixtures\":{\n" +
                "              \"events\":true,\n" +
                "              \"lineups\":true,\n" +
                "              \"statistics_fixtures\":false,\n" +
                "              \"statistics_players\":false\n" +
                "            },\n" +
                "            \"standings\":false,\n" +
                "            \"players\":true,\n" +
                "            \"top_scorers\":true,\n" +
                "            \"top_assists\":true,\n" +
                "            \"top_cards\":true,\n" +
                "            \"injuries\":false,\n" +
                "            \"predictions\":true,\n" +
                "            \"odds\":true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"




        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))//We will use MockWebServers url
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(LeagueService::class.java)

        mockWebServer.enqueue(mockResponse.setBody(resp))
    }

    @Test
    fun testLeaguePathRequest() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchLeagueList("2021","HU","League")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(request.path,"/leagues?season=2021&code=HU&type=League")
        }
    }
    @Test
    fun testLeagueRequestObject() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchLeagueList("2021","HU","League")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses[0].country?.name,"Hungary")
        }
    }


    @Test
    fun testLeaguesSize() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchLeagueList("2021","HU","League")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses.size,6)
        }
    }

    @Test
    fun testLeaguesLogo() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchLeagueList("2021","HU","League")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses[0].league?.logo,"https://media.api-sports.io/football/leagues/271.png")
        }
    }
}