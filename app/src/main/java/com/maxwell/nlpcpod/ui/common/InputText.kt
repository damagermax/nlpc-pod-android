package com.maxwell.nlpcpod.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.VpnKey
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.maxwell.nlpcpod.ui.theme.Gray500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    leadingIcon: ImageVector,
    placeholder: String,
    onChange: (String) -> Unit,
    value: String,
    modifier: Modifier=Modifier,
    errorMessage:String?=null
) {


    OutlinedTextField(
        value = value,
        placeholder = { Text(text = placeholder) },
        onValueChange = { onChange(it) },
        modifier =modifier.fillMaxWidth(),
        isError = !errorMessage.isNullOrBlank(),
        singleLine = true,
        supportingText = {errorMessage?.let { Text(text =it) } },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Gray500, cursorColor = Color.LightGray,
            focusedBorderColor = Color.White
        ),
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = null) }

    )




}