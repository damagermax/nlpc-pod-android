package com.maxwell.nlpcpod.ui.screen.auth.signup

sealed class SignupEvent {
    data class OnEmailChange(val email: String) : SignupEvent()
    data class OnPasswordChange(val password: String) : SignupEvent()
    data class OnFullNameChange(val fullName: String) : SignupEvent()
    object OnSubmit : SignupEvent()
}