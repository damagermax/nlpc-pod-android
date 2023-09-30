package com.maxwell.nlpcpod.ui.screen.auth.forgotpassword

sealed class ForgotPasswordEvent {
    data class OnEmailChange(val email:String):ForgotPasswordEvent()
    object OnSubmit:ForgotPasswordEvent()
}