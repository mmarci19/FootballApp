package com.example.footballapp.ui.teams

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballapp.databinding.LeaguesListBinding
import com.example.footballapp.databinding.TeamsBinding
import com.example.footballapp.model.league.League
import com.example.footballapp.model.team.Team
import com.example.footballapp.ui.details.DetailsActivity
import com.example.footballapp.ui.leagues.LeagueAdapter
import com.example.footballapp.ui.leagues.LeagueViewModel
import com.example.footballapp.ui.leagues.TeamAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class TeamsActivity : ComponentActivity() {
private lateinit var binding: TeamsBinding
    private lateinit var adapter: TeamAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
internal val teamsViewModel: TeamViewModel by viewModels()

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val league_id = intent.getStringExtra("league_id").toString()
    Log.d("league_id", league_id.toString())
    teamsViewModel.setLeagueId(league_id)
    binding = TeamsBinding.inflate(layoutInflater)
    setContentView(binding.root)
    teamsViewModel.forceTeamLoad()

    val teams = teamsViewModel.teamsList

    val teamsList: List<Team>
    runBlocking(Dispatchers.IO) {
        teamsList = teams.first()
    }

    linearLayoutManager = LinearLayoutManager(this)
    binding.recyclerView.layoutManager = linearLayoutManager
    adapter = TeamAdapter(teamsList)
    binding.recyclerView.adapter = adapter
}
}