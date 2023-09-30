package com.maxwell.nlpcpod.domain.use_case.auth

import com.maxwell.nlpcpod.domain.manager.TokenManager

class SaveAccessToken(private val tokenManager: TokenManager) {


    suspend operator fun invoke(token:String){
        tokenManager.saveAccessToke(token)
    }
}