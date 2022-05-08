package com.example.footballapp.persistence

import com.example.footballapp.model.team.Team
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class TeamDaoTest : LocalDatabase() {

    private lateinit var teamDao: TeamDao

    @Before
    fun init() {
        teamDao = db.teamDao()
    }

    @Test
    fun insertAndLoadTeamTest() = runBlocking {
        val mockTeam = Team.mock()
        teamDao.insertTeam(mockTeam)

        val loadFromDB = teamDao.getById(271)
        assertThat(loadFromDB.name, `is` (mockTeam.name))
    }

}