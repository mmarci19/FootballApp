package com.example.footballapp.persistence

import com.example.footballapp.model.Team
import com.example.footballapp.utils.MockTeam
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class PosterDaoTest : LocalDatabase() {

    private lateinit var posterDao: PosterDao

    @Before
    fun init() {
        posterDao = db.posterDao()
    }

    @Test
    fun insertAndLoadPosterListTest() = runBlocking {
        val mockDataList = mockPosterList()
        posterDao.insertPosterList(mockDataList)

        val loadFromDB = posterDao.getPosterList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = Poster.mock()
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }
}