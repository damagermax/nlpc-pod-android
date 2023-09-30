package com.maxwell.nlpcpod.ui.screen.auth.forgotpassword

data class ForgotPasswordState(
    val email: String = "",
    val emailErrorMessage: String ?= null,
    val success: Boolean = false
)