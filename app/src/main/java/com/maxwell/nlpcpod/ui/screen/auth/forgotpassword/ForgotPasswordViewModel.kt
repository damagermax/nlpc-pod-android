package com.maxwell.nlpcpod.ui.screen.auth.forgotpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.maxwell.nlpcpod.domain.use_case.validator.ValidateEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val validateEmail: ValidateEmail
) : ViewModel() {

    var state by mutableStateOf(ForgotPasswordState())
        private set

    fun onEvent(forgotPasswordEvent: ForgotPasswordEvent) {
        when (forgotPasswordEvent) {

            is ForgotPasswordEvent.OnEmailChange -> state =
                state.copy(email = forgotPasswordEvent.email)

            is ForgotPasswordEvent.OnSubmit -> if (validateForm()) sendResetPasswordRequest()
        }
    }


    private fun validateForm(): Boolean {
        state = state.copy(emailErrorMessage = null)

        val emailResult = validateEmail(state.email)

        if (!emailResult.valid) state = state.copy(emailErrorMessage = emailResult.message)

        return emailResult.valid
    }

    private fun sendResetPasswordRequest() {
        TODO("Not yet implemented")
    }
}