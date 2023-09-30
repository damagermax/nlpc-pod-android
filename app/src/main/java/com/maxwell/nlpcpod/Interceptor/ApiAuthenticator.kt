package com.maxwell.nlpcpod.Interceptor

import com.maxwell.nlpcpod.domain.use_case.auth.ReadAccessToken
import dagger.Lazy
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class ApiAuthenticator @Inject constructor (private val readAccessToken: ReadAccessToken) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder=chain.request().newBuilder()
       val accessToken= runBlocking { readAccessToken().first() }
        requestBuilder.addHeader("authorization","Bearer $accessToken")
        return  chain.proceed(requestBuilder.build())
    }
}