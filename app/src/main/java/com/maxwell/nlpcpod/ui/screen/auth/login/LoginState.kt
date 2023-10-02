package com.maxwell.nlpcpod.ui.screen.auth.login

import com.maxwell.nlpcpod.data.remote.dto.AuthResponse
import com.maxwell.nlpcpod.domain.repository.LoginResponse
import com.maxwell.nlpcpod.utils.Resource

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailErrorMessage: String? = null,
    val passwordErrorMessage: String? = null,
    val success: Boolean = false,
    val loginResponse: Resource<AuthResponse> = Resource.Loading()
)