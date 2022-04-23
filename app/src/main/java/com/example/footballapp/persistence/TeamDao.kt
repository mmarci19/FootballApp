package com.example.footballapp.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp.model.Team


@Dao
interface TeamDao {

    @Query("SELECT * FROM Team WHERE id = :id_")
    suspend fun getById(id_: Long)

    @Query("SELECT * FROM Team")
    suspend fun getAllTeams(): List<Team>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teams: List<Team>)


}