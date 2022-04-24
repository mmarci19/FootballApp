package com.example.footballapp.persistence

import com.example.footballapp.model.team.Team
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

class TeamDaoTest : LocalDatabase() {

    private lateinit var teamDao: TeamDao



}