package com.maxwell.nlpcpod.ui.screen.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxwell.nlpcpod.domain.use_case.auth.Login
import com.maxwell.nlpcpod.domain.use_case.auth.ReadAccessToken
import com.maxwell.nlpcpod.domain.use_case.auth.SaveAccessToken
import com.maxwell.nlpcpod.domain.use_case.validator.LoginFormValidation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject




@HiltViewModel
class LoginViewModel @Inject constructor(
    private val login: Login,
    private val saveAccessToken: SaveAccessToken,
    private val readAccessToken: ReadAccessToken,
    private val loginFormValidation: LoginFormValidation,

    ) : ViewModel() {

    val tag = LoginViewModel::class.java.simpleName

    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(loginEvent: LoginEvent) {

        when (loginEvent) {
            is LoginEvent.OnEmailChange -> state = state.copy(email = loginEvent.email)

            is LoginEvent.OnPasswordChange -> state = state.copy(password = loginEvent.password)

            is LoginEvent.OnSubmit -> if (validateForm()) login()
        }
    }

    private fun validateForm(): Boolean {

        val emailResult = loginFormValidation.validateEmail(state.email)
        val passwordResult = loginFormValidation.validatePassword(state.password)

        state = state.copy(emailErrorMessage = emailResult.message)
        state = state.copy(passwordErrorMessage = passwordResult.message)

        return emailResult.valid && passwordResult.valid
    }

    private fun login() {

        val user = mapOf("email" to state.email, "password" to state.password)

        viewModelScope.launch {
            login(user).collectLatest { response ->
                Log.d(tag, response.toString())
                response.data?.token?.let { token -> saveAccessToken(token) }

                state = state.copy(loginResponse = response)
            }
        }
    }

}