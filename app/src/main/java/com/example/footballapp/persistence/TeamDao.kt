package com.example.footballapp.persistence
import androidx.room.Dao


@Dao
interface TeamDao {

    fun getById(id: Long){

    }

    fun getAllTeams(){

    }

    fun insertTeam(){

    }

}