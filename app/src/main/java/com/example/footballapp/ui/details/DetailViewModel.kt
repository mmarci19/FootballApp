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

    val team: Flow<TeamDetailModel> =
        detailRepository.loadTeamById(
            id = "651",
            l_id = "271",
            onStart = { },
            onCompletion = { },
            onError = {  }
        )


}