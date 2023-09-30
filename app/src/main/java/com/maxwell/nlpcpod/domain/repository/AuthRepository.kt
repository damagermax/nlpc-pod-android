package com.maxwell.nlpcpod.domain.repository

import com.maxwell.nlpcpod.data.remote.dto.AuthResponse
import com.maxwell.nlpcpod.utils.Resource
import kotlinx.coroutines.flow.Flow

typealias LoginResponse=Flow<Resource<AuthResponse>>
typealias SignResponse=LoginResponse

interface AuthRepository {

    suspend fun login(user:Map<String,String>):LoginResponse

    suspend fun signup(user:Map<String,String>):SignResponse

    suspend fun forgotPassword(email: String)




}