package com.maxwell.nlpcpod.data.repository

import com.maxwell.nlpcpod.data.remote.AuthApi
import com.maxwell.nlpcpod.data.remote.dto.AuthResponse
import com.maxwell.nlpcpod.domain.repository.AuthRepository
import com.maxwell.nlpcpod.domain.repository.LoginResponse
import com.maxwell.nlpcpod.domain.repository.SignResponse
import com.maxwell.nlpcpod.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository, BaseRepository() {
    override suspend fun login(user: Map<String, String>): LoginResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(authApi.login(user))
        emit(response)
    }

    override suspend fun signup(user: Map<String, String>): SignResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(authApi.login(user))
        emit(response)
    }

    override suspend fun forgotPassword(email: String) {
        TODO("Not yet implemented")
    }
}