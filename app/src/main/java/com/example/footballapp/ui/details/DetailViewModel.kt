package com.example.footballapp.ui.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    //private val detailRepository: DetailRepository
) : ViewModel() {

    //private val teamIdSharedFlow: MutableSharedFlow<Long> = MutableSharedFlow(replay = 1)

    //val teamDetailsFlow = teamIdSharedFlow.flatMapLatest {
    //    detailRepository.getTeamById(it)
    //}

   // fun loadTeamById(id: Long) = teamIdSharedFlow.tryEmit(id)
}