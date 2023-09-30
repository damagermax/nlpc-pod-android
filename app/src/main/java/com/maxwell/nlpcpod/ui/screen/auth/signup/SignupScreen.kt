package com.maxwell.nlpcpod.ui.screen.auth.signup

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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.maxwell.nlpcpod.ui.common.ContainedButton
import com.maxwell.nlpcpod.ui.common.TextInput
import com.maxwell.nlpcpod.ui.navigation.Screens
import com.maxwell.nlpcpod.ui.theme.Red600

@Composable
fun SignupScreen(
    navController: NavHostController,
    signupViewModel: SignupViewModel = hiltViewModel(),
    event: (SignupEvent)->Unit = signupViewModel::onEvent,
    state:SignupState=signupViewModel.state
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.fillMaxHeight(0.1F))

        Text(
            text = "Create Account",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        TextInput(
            leadingIcon = Icons.Outlined.Person,
            placeholder = "Full name",
            onChange = { event(SignupEvent.OnFullNameChange(it)) },
            value = state.fullName,
            errorMessage = state.fullNameErrorMessage
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextInput(
            leadingIcon = Icons.Outlined.Email,
            placeholder = "Email",
            onChange = { event(SignupEvent.OnEmailChange(it.trim())) },
            value = state.email,
            errorMessage = state.emailErrorMessage
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextInput(
            leadingIcon = Icons.Outlined.Password,
            placeholder = "Password",
            onChange = { event(SignupEvent.OnPasswordChange(it.trim())) },
            value = state.password,
            errorMessage = state.passwordErrorMessage
        )

        Spacer(modifier = Modifier.height(48.dp))

        ContainedButton(label = "Signup", onClick = {event(SignupEvent.OnSubmit)})

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Already have an account? ", color = Color.LightGray.copy(0.9f))
            Text(
                text = "Login!",
                modifier = Modifier.clickable { navController.navigate(Screens.Login.route) })
        }
    }


}