package com.example.footballapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import com.example.footballapp.model.League
import com.example.footballapp.model.Model
import com.example.footballapp.model.Team
import com.example.footballapp.ui.leagues.LeagueViewModel
import com.example.footballapp.ui.leagues.LeaguesRepository
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val leagues = leagueViewModel.leaguesList
        val teams = teamViewModel.teamsList
        Log.d("TAG","Before")
        val flowValue: List<League>
        runBlocking(Dispatchers.IO) {
            flowValue = leagues.first()
        }
        val flowValue_2: List<Team>
        runBlocking(Dispatchers.IO) {
            flowValue_2 = teams.first()
        }

        Log.d("TAG","After")
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