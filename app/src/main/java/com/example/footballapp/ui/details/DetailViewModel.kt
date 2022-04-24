package com.example.footballapp.ui.details

import androidx.lifecycle.ViewModel
import com.example.footballapp.model.League
import com.example.footballapp.model.Team
import com.example.footballapp.ui.teams.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {

    val team: Flow<List<Team>> =
        detailRepository.loadTeamById(
            id = "1",
            l_id = "2",
            onStart = { },
            onCompletion = { },
            onError = {  }
        )


}