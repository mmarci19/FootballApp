package com.example.footballapp.ui.details

import androidx.lifecycle.ViewModel
import com.example.footballapp.ui.leagues.LeagueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository

) : ViewModel() {

}