package com.maxwell.nlpcpod.di

import com.maxwell.nlpcpod.utils.Interceptor.ApiAuthenticator
import com.maxwell.nlpcpod.data.remote.AuthApi
import com.maxwell.nlpcpod.data.remote.PodcastApi
import com.maxwell.nlpcpod.data.repository.AuthRepositoryImpl
import com.maxwell.nlpcpod.data.repository.PodcastRepositoryImpl
import com.maxwell.nlpcpod.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(
        apiAuthenticator: ApiAuthenticator
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiAuthenticator)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(authApi: AuthApi) = AuthRepositoryImpl(authApi)

    @Provides
    @Singleton
    fun providePodcastApi(retrofit: Retrofit): PodcastApi = retrofit.create(PodcastApi::class.java)


    @Provides
    @Singleton
    fun providePodcastRepository(podcastApi: PodcastApi) = PodcastRepositoryImpl(podcastApi)


}