package com.maxwell.nlpcpod.domain.manager

import kotlinx.coroutines.flow.Flow

interface TokenManager {
   fun getAccessToken():Flow<String>
    suspend fun saveAccessToke(token:String)
}