package com.maxwell.nlpcpod.di

import com.maxwell.nlpcpod.Interceptor.ApiAuthenticator
import com.maxwell.nlpcpod.data.remote.AuthApi
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


}