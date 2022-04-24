package com.example.footballapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballapp.model.details.TeamDetailModel
import com.example.footballapp.model.league.League
import com.example.footballapp.model.team.Team
import com.example.footballapp.ui.details.DetailViewModel
import com.example.footballapp.ui.leagues.LeagueViewModel
import com.example.footballapp.ui.teams.TeamViewModel
import com.example.footballapp.ui.theme.FootballAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class LeaguesActivity : ComponentActivity() {
    internal val teamViewModel: TeamViewModel by viewModels()
    internal val leagueViewModel: LeagueViewModel by viewModels()
    internal val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MSG","Before")
        runBlocking {
            val value = leagueViewModel.leaguesList.first()
        }
        runBlocking {
            val value = teamViewModel.teamsList.first()
        }
        runBlocking {
            val value = detailViewModel.team.first()
        }
        setContent {
            FootballAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FootballAppTheme {
        Greeting("Android")
    }
}