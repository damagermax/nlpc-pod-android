package com.maxwell.nlpcpod.domain.use_case.auth

import com.maxwell.nlpcpod.domain.manager.TokenManager
import kotlinx.coroutines.flow.Flow

class ReadAccessToken (private val tokenManager: TokenManager) {

    operator fun invoke():Flow<String>{ return tokenManager.getAccessToken()}
}