package com.example.footballapp.model


data class Team (
    val id: String,
    val name: String,
    val league: String,
    val logo: String,
    val goalScored: String,
    val penalties: String,
    val yellowCards: String,
    val cleanSheets: String,
    val victories: String,
    val losses: String
)
{
}