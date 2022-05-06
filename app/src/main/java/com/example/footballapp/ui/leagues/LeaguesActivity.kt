package com.example.footballapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.databinding.LeaguesBinding
import com.example.footballapp.model.league.League
import com.example.footballapp.ui.leagues.LeagueViewModel
import com.example.footballapp.ui.teams.TeamViewModel
import com.example.footballapp.ui.teams.TeamsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


@AndroidEntryPoint
class LeaguesActivity : ComponentActivity() {

    internal val leagueViewModel: LeagueViewModel by viewModels()
    internal val teamViewModel: TeamViewModel by viewModels()
    private lateinit var binding: LeaguesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LeaguesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val leagues = leagueViewModel.leaguesList

        val leaguesList: List<League>
        runBlocking(Dispatchers.IO) {
            leaguesList = leagues.first()
        }

        binding.textView.text = leaguesList[0].name
        binding.button.setOnClickListener {
            val intent = Intent(this, TeamsActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("league_id", "271")
            Log.d("INTENT",intent.getStringExtra("league_id").toString())
            // start your next activity
            startActivity(intent)
        }
    }
}
