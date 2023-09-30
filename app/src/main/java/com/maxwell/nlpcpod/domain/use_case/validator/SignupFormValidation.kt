package com.maxwell.nlpcpod.domain.use_case.validator

data class SignupFormValidation(
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword,
    val validateFullname: ValidateInput,
    val validatePhoneNumber: ValidatePhoneNumber
)
