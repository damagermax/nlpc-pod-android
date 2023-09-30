package com.maxwell.nlpcpod.data.remote.dto

import com.maxwell.nlpcpod.domain.model.User

data class AuthResponse(
    val success:String,
    val user:User,
    val token:String
)
