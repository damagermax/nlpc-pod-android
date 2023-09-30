package com.maxwell.nlpcpod.ui.screen.auth.login

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.maxwell.nlpcpod.ui.common.ContainedButton
import com.maxwell.nlpcpod.ui.common.TextInput
import com.maxwell.nlpcpod.ui.navigation.Screens
import com.maxwell.nlpcpod.ui.theme.Red600
import com.maxwell.nlpcpod.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    event: (LoginEvent) -> Unit = loginViewModel::onEvent,
    state: LoginState = loginViewModel.state
) {

    LaunchedEffect(
        key1 = state.loginResponse,
        block = {
            when (state.loginResponse) {
                is Resource.Loading -> {}

                is Resource.Success -> {
                    navController.popBackStack();
                    navController.navigate(Screens.HomeNavigation.route)
                }

                is Resource.Error -> {
                    //state.loginResponse.message
                }
            }
        })

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {

        Spacer(modifier = Modifier.fillMaxHeight(0.1F))

        Text(
            text = "Welcome Back!",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Login to continue",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            color = Color.LightGray.copy(0.9f)
        )

        Spacer(modifier = Modifier.height(48.dp))

        TextInput(
            leadingIcon = Icons.Outlined.Email,
            placeholder = "Email",
            onChange = { event(LoginEvent.OnEmailChange(it.trim())) },
            value = state.email,
            errorMessage = state.emailErrorMessage
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextInput(
            leadingIcon = Icons.Outlined.Password,
            placeholder = "Password",
            onChange = { event(LoginEvent.OnPasswordChange(it.trim())) },
            value = state.password, errorMessage = state.passwordErrorMessage
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Forgot password?",
            modifier = Modifier.fillMaxWidth().clickable { navController.navigate(Screens.ForgotPassword.route) })

        Spacer(modifier = Modifier.height(48.dp))

        ContainedButton(label = "Login", onClick = { event(LoginEvent.OnSubmit) })

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), content = {
            Text(text = "Don't have an account? ", color = Color.LightGray.copy(0.9f))
            Text(
                text = "Create one!",
                modifier = Modifier.clickable { navController.navigate(Screens.Register.route) })
        })

    }
}