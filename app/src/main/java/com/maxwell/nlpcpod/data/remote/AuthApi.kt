package com.maxwell.nlpcpod.data.remote

import com.maxwell.nlpcpod.data.remote.dto.AuthResponse
import com.maxwell.nlpcpod.utils.Constant.FORGOT_PASSWORD
import com.maxwell.nlpcpod.utils.Constant.LOGIN
import com.maxwell.nlpcpod.utils.Constant.SIGNUP
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(LOGIN)
    suspend fun login(
        @Body user:Map<String,String>
    ): Response<AuthResponse>

    @POST(SIGNUP)
    suspend fun signup(
        @Body user:Map<String,String>
    ): Response<AuthResponse>

    @POST(FORGOT_PASSWORD)
    suspend fun forgotPassword(
        @Body email:Map<String,String>
    )
}