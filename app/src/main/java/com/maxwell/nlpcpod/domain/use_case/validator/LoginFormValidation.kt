package com.maxwell.nlpcpod.domain.use_case.validator

data class LoginFormValidation(
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword
)
