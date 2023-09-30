package com.maxwell.nlpcpod.ui.common

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maxwell.nlpcpod.ui.theme.Red600

@Composable
fun ContainedButton(onClick:()->Unit,label:String,) {
    Button(
        onClick = {onClick() },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraSmall,
        colors = ButtonDefaults.buttonColors(
            containerColor = Red600
        ),
        contentPadding = PaddingValues(14.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.headlineSmall)
    }
}