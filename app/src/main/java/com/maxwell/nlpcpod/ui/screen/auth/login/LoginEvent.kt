package com.maxwell.nlpcpod.ui.screen.auth.login

sealed class LoginEvent {
    data class OnEmailChange(val email:String):LoginEvent()
    data class OnPasswordChange(val password:String):LoginEvent()

    object OnSubmit:LoginEvent()
}