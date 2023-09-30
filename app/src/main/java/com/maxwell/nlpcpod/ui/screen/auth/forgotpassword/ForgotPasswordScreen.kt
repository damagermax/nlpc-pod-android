package com.maxwell.nlpcpod.ui.screen.auth.forgotpassword

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.maxwell.nlpcpod.ui.screen.auth.login.LoginEvent

@Composable
fun ForgotPassword(
    navController: NavHostController,
    forgotPasswordViewModel: ForgotPasswordViewModel = hiltViewModel(),
    event: (ForgotPasswordEvent)->Unit=forgotPasswordViewModel::onEvent,
    state: ForgotPasswordState=forgotPasswordViewModel.state
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {

        var value by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.fillMaxHeight(0.1F))

        Text(
            text = "Forgot Password?",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Enter you email address to receive \nintructions",
            fontWeight = FontWeight.Normal,
            color = Color.LightGray.copy(0.9f)
        )

        Spacer(modifier = Modifier.height(48.dp))


        TextInput(
            leadingIcon = Icons.Outlined.Email,
            placeholder = "Email",
            onChange = {event(ForgotPasswordEvent.OnEmailChange(it))},
            value = state.email
            , errorMessage = state.emailErrorMessage
        )


        Spacer(modifier = Modifier.height(48.dp))

        ContainedButton(label = "Send", onClick = {event(ForgotPasswordEvent.OnSubmit)})

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Already have an account? ", color = Color.LightGray.copy(0.9f))
            Text(
                text = "Login here",
                modifier = Modifier.clickable { navController.navigate(Screens.Login.route) })
        }
    }


}