package com.example.footballapp.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp.model.League
import com.example.footballapp.model.Team


@Dao
interface LeagueDao {

    @Query("SELECT * FROM League WHERE id_ = :id__")
    fun getById(id__: Long)

    @Query("SELECT * FROM League")
    fun getAllLeagues(): List<League>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLeagueList(leagues: List<League>)

}