package com.example.footballapp.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.footballapp.model.details.TeamDetailModel
import com.example.footballapp.model.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {
    private var team_id = "0"
    private var league_id = "0"



    fun setLeagueId(id_: String){
        Log.d("ID-SET", id_)
        this.league_id = id_
    }

    fun setTeamId(id_: String){
        Log.d("ID-SET", id_)
        this.team_id = id_
    }



    lateinit var team: Flow<TeamDetailModel>

    fun forceTeamLoad(){
        detailRepository.loadTeamById(
            id = team_id, //TODO Team ID - Will get from the user in runtime.
            l_id = league_id, //TODO League ID - Will get from the user in runtime.
            onStart = { },
            onCompletion = { },
            onError = {  }
        )
    }

}