package com.maxwell.nlpcpod.di

import android.app.Application
import com.maxwell.nlpcpod.data.manager.ManagerImpl
import com.maxwell.nlpcpod.data.remote.AuthApi
import com.maxwell.nlpcpod.data.remote.PodcastApi
import com.maxwell.nlpcpod.data.repository.AuthRepositoryImpl
import com.maxwell.nlpcpod.data.repository.PodcastRepositoryImpl
import com.maxwell.nlpcpod.domain.manager.TokenManager
import com.maxwell.nlpcpod.domain.repository.AuthRepository
import com.maxwell.nlpcpod.domain.repository.PodcastRepository
import com.maxwell.nlpcpod.domain.use_case.auth.Login
import com.maxwell.nlpcpod.domain.use_case.auth.ReadAccessToken
import com.maxwell.nlpcpod.domain.use_case.auth.SaveAccessToken
import com.maxwell.nlpcpod.domain.use_case.podcast.GetAllSeries
import com.maxwell.nlpcpod.domain.use_case.podcast.GetCategories
import com.maxwell.nlpcpod.domain.use_case.podcast.GetEpisode
import com.maxwell.nlpcpod.domain.use_case.podcast.GetSeries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLogin(authRepository: AuthRepository) = Login(authRepository)

    @Provides
    @Singleton
    fun provideManagerImp(application: Application) = ManagerImpl(application)

    @Provides
    @Singleton
    fun provideReadAccessToken(tokenManager: TokenManager) = ReadAccessToken(tokenManager)

    @Provides
    @Singleton
    fun provideSavaAccessToken(tokenManager: TokenManager) = SaveAccessToken(tokenManager)

    @Provides
    @Singleton
    fun provideGetCategories(podcastRepository: PodcastRepository) = GetCategories(podcastRepository)

    @Provides
    @Singleton
    fun provideGetSeries(podcastRepository: PodcastRepository) = GetSeries(podcastRepository)

    @Provides
    @Singleton
    fun provideGetAllSeries(podcastRepository: PodcastRepository) = GetAllSeries(podcastRepository)

    @Provides
    @Singleton
    fun provideGetEpisodes(podcastRepository: PodcastRepository) = GetEpisode(podcastRepository)


}