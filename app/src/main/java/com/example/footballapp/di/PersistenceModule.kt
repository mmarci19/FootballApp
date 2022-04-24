package com.example.footballapp.di

import android.app.Application
import androidx.room.Room
import com.example.footballapp.R
import com.example.footballapp.persistence.AppDatabase
import com.example.footballapp.persistence.LeagueDao
import com.example.footballapp.persistence.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabaseTeam(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "FootballDatabase.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideTeamDao(appDatabase: AppDatabase): TeamDao {
        return appDatabase.teamDao()
    }

    @Provides
    @Singleton
    fun provideLeagueDao(appDatabase: AppDatabase): LeagueDao {
        return appDatabase.leagueDao()
    }

}