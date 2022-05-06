package com.example.footballapp.ui.details


import com.example.footballapp.databinding.DetailsBinding
import com.example.footballapp.model.details.TeamDetailModel
import com.example.footballapp.ui.teams.TeamViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.footballapp.databinding.LeaguesBinding
import com.example.footballapp.databinding.TeamsBinding
import com.example.footballapp.model.league.League
import com.example.footballapp.model.team.Team
import com.example.footballapp.ui.leagues.LeagueViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class DetailsActivity : ComponentActivity() {
    private lateinit var binding: DetailsBinding

    internal val detailsViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val team = detailsViewModel.team

        val data: TeamDetailModel
        runBlocking(Dispatchers.IO) {
            data = team.first()
        }

        binding.form.text = data.responses.form.toString()
        binding.league.text = data.responses.league.name.toString()
        binding.cards.text = data.responses.cards?.yellow?.firstQuarter?.percentage.toString()

    }
}