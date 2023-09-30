package com.maxwell.nlpcpod.ui.screen.auth.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.maxwell.nlpcpod.domain.use_case.validator.SignupFormValidation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val signupFormValidation: SignupFormValidation) :
    ViewModel() {

    var state by mutableStateOf(SignupState())
        private set

    fun onEvent(signupEvent: SignupEvent) {

        when (signupEvent) {
            is SignupEvent.OnSubmit -> if (validateForm()) signup()
            is SignupEvent.OnEmailChange -> state = state.copy(email = signupEvent.email)
            is SignupEvent.OnFullNameChange -> state = state.copy(fullName = signupEvent.fullName)
            is SignupEvent.OnPasswordChange -> state = state.copy(password = signupEvent.password)

        }
    }

    private fun validateForm(): Boolean {

        state =
            state.copy(emailErrorMessage = null, passwordErrorMessage = null, fullNameErrorMessage = null)

        val emailResult = signupFormValidation.validateEmail(state.email)
        val passwordResult = signupFormValidation.validatePassword(state.password)
        val fullNameResult = signupFormValidation.validateFullname(state.fullName, "Full name")

        if (!emailResult.valid) state = state.copy(emailErrorMessage = emailResult.message)
        if (!passwordResult.valid) state = state.copy(passwordErrorMessage = passwordResult.message)
        if (!fullNameResult.valid) state = state.copy(fullNameErrorMessage = fullNameResult.message)

        return emailResult.valid && passwordResult.valid && fullNameResult.valid
    }

    private fun signup() {
        TODO("Not yet implemented")
    }

}