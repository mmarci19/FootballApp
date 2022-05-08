package com.example.footballapp.persistence
import android.os.Build.VERSION_CODES.Q
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.footballapp.model.league.League
import com.example.footballapp.network.LeagueService
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.SandwichInitializer
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.robolectric.annotation.Config
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Q])
class LeagueDaoTest : LocalDatabase() {

    private lateinit var leagueDao: LeagueDao


    @Before
    fun init() {
        leagueDao = db.leagueDao()
    }

    @Test
    fun insertAndLoadLeagueTest() = runBlocking {
        val mockLeague = League.mock()
        leagueDao.insertLeague(mockLeague)

        val loadFromDB = leagueDao.getById(271)
        assertEquals(loadFromDB.name,mockLeague.name)
    }

}