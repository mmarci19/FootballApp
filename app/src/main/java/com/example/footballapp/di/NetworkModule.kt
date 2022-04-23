package com.example.footballapp.di

import android.content.Context
import com.example.footballapp.network.LeagueService
import com.example.footballapp.network.RequestInterceptor
import com.example.footballapp.network.TeamService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(
                "https://api-football-beta.p.rapidapi.com/"
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTeamService(retrofit: Retrofit): TeamService {
        return retrofit.create(TeamService::class.java)
    }


    @Provides
    @Singleton
    fun provideLeagueService(retrofit: Retrofit): LeagueService {
        return retrofit.create(LeagueService::class.java)
    }



}