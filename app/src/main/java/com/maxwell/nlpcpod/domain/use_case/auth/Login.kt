package com.maxwell.nlpcpod.domain.use_case.auth

import com.maxwell.nlpcpod.data.remote.dto.AuthResponse
import com.maxwell.nlpcpod.domain.repository.AuthRepository
import com.maxwell.nlpcpod.domain.repository.LoginResponse
import kotlinx.coroutines.flow.Flow

class Login(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: Map<String, String>): LoginResponse =
        authRepository.login(user)

}