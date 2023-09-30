package com.maxwell.nlpcpod.di

import android.app.Application
import com.maxwell.nlpcpod.data.manager.ManagerImpl
import com.maxwell.nlpcpod.data.remote.AuthApi
import com.maxwell.nlpcpod.data.remote.PodcastApi
import com.maxwell.nlpcpod.data.repository.AuthRepositoryImpl
import com.maxwell.nlpcpod.data.repository.PodcastRepositoryImpl
import com.maxwell.nlpcpod.domain.manager.TokenManager
import com.maxwell.nlpcpod.domain.repository.AuthRepository
import com.maxwell.nlpcpod.domain.use_case.auth.Login
import com.maxwell.nlpcpod.domain.use_case.auth.ReadAccessToken
import com.maxwell.nlpcpod.domain.use_case.auth.SaveAccessToken
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
    fun provideAuthRepository(authApi: AuthApi)=AuthRepositoryImpl(authApi)

    @Provides
    @Singleton
    fun provideLogin(authRepository: AuthRepository)= Login(authRepository)

    @Provides
    @Singleton
    fun provideManagerImp(application:Application)=ManagerImpl(application)

    @Provides
    @Singleton
    fun provideReadAccessToken(tokenManager: TokenManager)=ReadAccessToken(tokenManager)

    @Provides
    @Singleton
    fun provideSavaAccessToken(tokenManager: TokenManager)=SaveAccessToken(tokenManager)

    @Provides
    @Singleton
    fun providePodcastRepository(podcastApi: PodcastApi)=PodcastRepositoryImpl(podcastApi)

}