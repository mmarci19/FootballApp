package com.example.footballapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapp.model.League

@Database(entities = [League::class], version = 1, exportSchema = true)
abstract class AppDatabase2 : RoomDatabase() {

    abstract fun leagueDao(): LeagueDao

}