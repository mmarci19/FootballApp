package com.example.footballapp.network

import com.google.gson.GsonBuilder
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.SandwichInitializer
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


@RunWith(JUnit4::class)
class TeamResponseApi {
    lateinit var service: TeamService
    lateinit var mockWebServer: MockWebServer
    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse.error<String>(exception)
        MatcherAssert.assertThat(apiResponse.message, CoreMatchers.`is`("foo"))
    }

    @Test
    fun success() {
        val apiResponse =
            ApiResponse.of(SandwichInitializer.successCodeRange) { Response.success("foo") }
        if (apiResponse is ApiResponse.Success) {
            MatcherAssert.assertThat(apiResponse.data, CoreMatchers.`is`("foo"))
        }
    }

    @Throws(IOException::class)
    private fun enqueueResponse(file___NAME: String) {

        val mockResponse = MockResponse()
        mockWebServer = MockWebServer()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val resp = "{\"get\":\"teams\",\"parameters\":{\"league\":\"271\",\"season\":\"2021\"},\"errors\":[],\"results\":12,\"paging\":{\"current\":1,\"total\":1},\"response\":[{\"team\":{\"id\":576,\"name\":\"Budapest Honved\",\"code\":\"HON\",\"country\":\"Hungary\",\"founded\":1908,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/576.png\"},\"venue\":{\"id\":11902,\"name\":\"Bozsik Ar\\u00e9na\",\"address\":\"Pusk\\u00e1s Ferenc u. 1-3\",\"city\":\"Budapest\",\"capacity\":8200,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/11902.png\"}},{\"team\":{\"id\":610,\"name\":\"Videoton FC\",\"code\":\"VID\",\"country\":\"Hungary\",\"founded\":1941,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/610.png\"},\"venue\":{\"id\":798,\"name\":\"MOL Ar\\u00e9na S\\u00f3st\\u00f3\",\"address\":\"Csikv\\u00e1ri \\u00fat 10\",\"city\":\"Sz\\u00e9kesfeh\\u00e9rv\\u00e1r\",\"capacity\":14201,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/798.png\"}},{\"team\":{\"id\":651,\"name\":\"Ferencvarosi TC\",\"code\":\"FER\",\"country\":\"Hungary\",\"founded\":1899,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/651.png\"},\"venue\":{\"id\":799,\"name\":\"Groupama Ar\\u00e9na\",\"address\":\"\\u00dcll\\u0151i \\u00fat, IX. ker.\",\"city\":\"Budapest\",\"capacity\":23698,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/799.png\"}},{\"team\":{\"id\":2255,\"name\":\"Ujpest\",\"code\":\"UJP\",\"country\":\"Hungary\",\"founded\":1885,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2255.png\"},\"venue\":{\"id\":814,\"name\":\"Szusza Ferenc Stadion\",\"address\":\"Megyeri \\u00fat 13., IV. ker\",\"city\":\"Budapest\",\"capacity\":13501,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/814.png\"}},{\"team\":{\"id\":2389,\"name\":\"Mezokovesd-zsory\",\"code\":\"MEZ\",\"country\":\"Hungary\",\"founded\":1975,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2389.png\"},\"venue\":{\"id\":805,\"name\":\"V\\u00e1rosi Stadion\",\"address\":\"Sz\\u00e9chenyi Istv\\u00e1n u. 9.\",\"city\":\"Mez\\u0151k\\u00f6vesd\",\"capacity\":4165,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/805.png\"}},{\"team\":{\"id\":2390,\"name\":\"Paks\",\"code\":\"PAK\",\"country\":\"Hungary\",\"founded\":1952,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2390.png\"},\"venue\":{\"id\":809,\"name\":\"Paksi FC Stadion\",\"address\":\"Feh\\u00e9rv\\u00e1ri \\u00fat 29.\",\"city\":\"Paks\",\"capacity\":4950,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/809.png\"}},{\"team\":{\"id\":2391,\"name\":\"Puskas Academy\",\"code\":\"PUS\",\"country\":\"Hungary\",\"founded\":2007,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2391.png\"},\"venue\":{\"id\":1764,\"name\":\"Pusk\\u00e1s Akad\\u00e9mia Pancho Ar\\u00e9na\",\"address\":null,\"city\":\"Felcs\\u00fat\",\"capacity\":3865,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/1764.png\"}},{\"team\":{\"id\":2392,\"name\":\"Debreceni VSC\",\"code\":\"DEB\",\"country\":\"Hungary\",\"founded\":1902,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2392.png\"},\"venue\":{\"id\":795,\"name\":\"Nagyerdei Stadion\",\"address\":\"Nagyerdei park 12\",\"city\":\"Debrecen\",\"capacity\":20340,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/795.png\"}},{\"team\":{\"id\":2394,\"name\":\"Kisvarda FC\",\"code\":\"KIS\",\"country\":\"Hungary\",\"founded\":2003,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2394.png\"},\"venue\":{\"id\":816,\"name\":\"V\\u00e1rkerti Stadion\",\"address\":null,\"city\":\"Kisv\\u00e1rda\",\"capacity\":3385,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/816.png\"}},{\"team\":{\"id\":2396,\"name\":\"MTK Budapest\",\"code\":\"BUD\",\"country\":\"Hungary\",\"founded\":1888,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2396.png\"},\"venue\":{\"id\":802,\"name\":\"Hidegkuti N\\u00e1ndor Stadion\",\"address\":\"Salg\\u00f3tarj\\u00e1ni \\u00fat 12-14., VIII. ker.\",\"city\":\"Budapest\",\"capacity\":5322,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/802.png\"}},{\"team\":{\"id\":2398,\"name\":\"Gyirmot SE\",\"code\":\"GYI\",\"country\":\"Hungary\",\"founded\":1993,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2398.png\"},\"venue\":{\"id\":800,\"name\":\"Alcufer Stadion\",\"address\":\"M\\u00e9nf\\u0151i \\u00fat 59., Gyirm\\u00f3t\",\"city\":\"Gy\\u0151r\",\"capacity\":4500,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/800.png\"}},{\"team\":{\"id\":2414,\"name\":\"Zalaegerszegi TE\",\"code\":\"ZAL\",\"country\":\"Hungary\",\"founded\":1920,\"national\":false,\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/2414.png\"},\"venue\":{\"id\":818,\"name\":\"ZTE-Ar\\u00e9na\",\"address\":\"Okt\\u00f3ber 6. t\\u00e9r 16.\",\"city\":\"Zalaegerszeg\",\"capacity\":11200,\"surface\":\"grass\",\"image\":\"https:\\/\\/media.api-sports.io\\/football\\/venues\\/818.png\"}}]}"

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))//We will use MockWebServers url
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TeamService::class.java)

        mockWebServer.enqueue(mockResponse.setBody(resp))
    }

    @Test
    fun testTeamPathRequest() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamList("2021","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(request.path,"/teams?season=2021&league=271")
        }
    }
    @Test
    fun testTeamRequestObject() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamList("2021","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses[0].team?.name,"Budapest Honved")
        }
    }


    @Test
    fun testTeamSize() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamList("2021","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses.size,12)
        }
    }

    @Test
    fun testTeamsLogo() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamList("2021","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses[0].team?.logo,"https://media.api-sports.io/football/teams/576.png")
        }
    }
}