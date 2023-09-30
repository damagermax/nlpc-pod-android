package com.maxwell.nlpcpod.ui.screen.auth.signup

data class SignupState(
    val fullName:String="",
    val email:String="",
    val password:String="",
    val confirmPassword:String="",
    val fullNameErrorMessage:String?=null,
    val emailErrorMessage:String?=null,
    val passwordErrorMessage:String?=null,
    val confirmPasswordErrorMessage:String="",
)
