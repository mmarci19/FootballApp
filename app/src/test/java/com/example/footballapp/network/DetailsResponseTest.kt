
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
class DetailsResponseTest {
    lateinit var service: TeamService
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

        var resp = "{\"get\":\"teams\\/statistics\",\"parameters\":{\"league\":\"271\",\"season\":\"2021\",\"team\":\"651\"},\"errors\":[],\"results\":11,\"paging\":{\"current\":1,\"total\":1},\"response\":{\"league\":{\"id\":271,\"name\":\"NB I\",\"country\":\"Hungary\",\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/leagues\\/271.png\",\"flag\":\"https:\\/\\/media.api-sports.io\\/flags\\/hu.svg\",\"season\":2021},\"team\":{\"id\":651,\"name\":\"Ferencvarosi TC\",\"logo\":\"https:\\/\\/media.api-sports.io\\/football\\/teams\\/651.png\"},\"form\":\"LWWWWWWLDWWWWDLWLWLWDDWWWDWWWWWL\",\"fixtures\":{\"played\":{\"home\":17,\"away\":15,\"total\":32},\"wins\":{\"home\":10,\"away\":11,\"total\":21},\"draws\":{\"home\":3,\"away\":2,\"total\":5},\"loses\":{\"home\":4,\"away\":2,\"total\":6}},\"goals\":{\"for\":{\"total\":{\"home\":32,\"away\":26,\"total\":58},\"average\":{\"home\":\"1.9\",\"away\":\"1.7\",\"total\":\"1.8\"},\"minute\":{\"0-15\":{\"total\":7,\"percentage\":\"12.07%\"},\"16-30\":{\"total\":8,\"percentage\":\"13.79%\"},\"31-45\":{\"total\":9,\"percentage\":\"15.52%\"},\"46-60\":{\"total\":10,\"percentage\":\"17.24%\"},\"61-75\":{\"total\":9,\"percentage\":\"15.52%\"},\"76-90\":{\"total\":8,\"percentage\":\"13.79%\"},\"91-105\":{\"total\":7,\"percentage\":\"12.07%\"},\"106-120\":{\"total\":null,\"percentage\":null}}},\"against\":{\"total\":{\"home\":21,\"away\":9,\"total\":30},\"average\":{\"home\":\"1.2\",\"away\":\"0.6\",\"total\":\"0.9\"},\"minute\":{\"0-15\":{\"total\":6,\"percentage\":\"20.00%\"},\"16-30\":{\"total\":2,\"percentage\":\"6.67%\"},\"31-45\":{\"total\":4,\"percentage\":\"13.33%\"},\"46-60\":{\"total\":9,\"percentage\":\"30.00%\"},\"61-75\":{\"total\":5,\"percentage\":\"16.67%\"},\"76-90\":{\"total\":3,\"percentage\":\"10.00%\"},\"91-105\":{\"total\":1,\"percentage\":\"3.33%\"},\"106-120\":{\"total\":null,\"percentage\":null}}}},\"biggest\":{\"streak\":{\"wins\":6,\"draws\":2,\"loses\":1},\"wins\":{\"home\":\"4-1\",\"away\":\"0-4\"},\"loses\":{\"home\":\"0-3\",\"away\":\"2-0\"},\"goals\":{\"for\":{\"home\":5,\"away\":4},\"against\":{\"home\":3,\"away\":2}}},\"clean_sheet\":{\"home\":5,\"away\":8,\"total\":13},\"failed_to_score\":{\"home\":3,\"away\":3,\"total\":6},\"penalty\":{\"scored\":{\"total\":7,\"percentage\":\"100.00%\"},\"missed\":{\"total\":0,\"percentage\":\"0%\"},\"total\":7},\"lineups\":[{\"formation\":\"4-2-3-1\",\"played\":19},{\"formation\":\"4-3-3\",\"played\":3},{\"formation\":\"3-4-2-1\",\"played\":2},{\"formation\":\"3-5-2\",\"played\":2},{\"formation\":\"3-4-1-2\",\"played\":2},{\"formation\":\"4-4-2\",\"played\":1}],\"cards\":{\"yellow\":{\"0-15\":{\"total\":7,\"percentage\":\"9.09%\"},\"16-30\":{\"total\":6,\"percentage\":\"7.79%\"},\"31-45\":{\"total\":13,\"percentage\":\"16.88%\"},\"46-60\":{\"total\":13,\"percentage\":\"16.88%\"},\"61-75\":{\"total\":15,\"percentage\":\"19.48%\"},\"76-90\":{\"total\":17,\"percentage\":\"22.08%\"},\"91-105\":{\"total\":6,\"percentage\":\"7.79%\"},\"106-120\":{\"total\":null,\"percentage\":null}},\"red\":{\"0-15\":{\"total\":null,\"percentage\":null},\"16-30\":{\"total\":2,\"percentage\":\"100.00%\"},\"31-45\":{\"total\":null,\"percentage\":null},\"46-60\":{\"total\":null,\"percentage\":null},\"61-75\":{\"total\":null,\"percentage\":null},\"76-90\":{\"total\":null,\"percentage\":null},\"91-105\":{\"total\":null,\"percentage\":null},\"106-120\":{\"total\":null,\"percentage\":null}}}}}"




        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))//We will use MockWebServers url
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TeamService::class.java)

        mockWebServer.enqueue(mockResponse.setBody(resp))
    }

    @Test
    fun testTeamStatPathRequest() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamStats("2021","651","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(request.path,"/teams/statistics?season=2021&team=651&league=271")
        }
    }
    @Test
    fun testTeamStatRequestLeague() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamStats("2021","651","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(responseBody.responses.league.name,"NB I")
        }
    }


    @Test
    fun testTeamNotNull() {
        runBlocking {
            // Prepare fake response
            enqueueResponse("TestResponse.json")
            //Send Request to the MockServer
            val responseBody = service.fetchTeamStats("2021","651","271")
            //Request received by the mock server
            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(responseBody.responses)
        }
    }

}