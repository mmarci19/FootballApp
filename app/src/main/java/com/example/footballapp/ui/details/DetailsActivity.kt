package com.example.footballapp.ui.details


import com.example.footballapp.databinding.DetailsBinding
import com.example.footballapp.ui.teams.TeamViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.footballapp.databinding.TeamsBinding
import com.example.footballapp.model.details.*
import com.example.footballapp.model.league.League
import com.example.footballapp.model.team.Team
import com.example.footballapp.ui.leagues.LeagueViewModel
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.league_row.view.*
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


        val league_id = intent.getStringExtra("league_id").toString()
        detailsViewModel.setLeagueId(league_id)
        val team_id = intent.getStringExtra("team_id").toString()
        detailsViewModel.setTeamId(team_id)
        detailsViewModel.forceTeamLoad()
        val team = detailsViewModel.team
        val data: TeamDetailModel
        runBlocking(Dispatchers.IO) {
            data = team.first()
        }


        binding.textView.text = data.responses.team?.name.toString()
        binding.league2.text = data.responses.league.name.toString()
        binding.cards2.text = data.responses.cards?.yellow?.firstQuarter?.percentage.toString()
        binding.penalty2.text = data.responses.penalty?.scored?.total.toString()
        binding.failed2.text = data.responses.failed?.streak.toString()
        binding.clean2.text = data.responses.cleanSheets?.total.toString()
        //binding.league.text = data.responses.league.name.toString()
        Picasso.get().load(data.responses.team?.logo).into(binding.imageView)

    }
}