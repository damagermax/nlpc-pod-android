package com.maxwell.nlpcpod.ui.common

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.maxwell.nlpcpod.ui.theme.Red600

/**
 * @param onClick for performing action
 *@param content for passing a custom content
 *@param label the text of the button
 *
 *Only one these params can be use at a time
 * */
@Composable
fun ContainedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    label: String? = null, content: (@Composable RowScope.() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.extraSmall,
    contentPadding: Dp = 14.dp
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Red600
        ),
        contentPadding = PaddingValues(contentPadding)
    ) {
        label?.let { Text(text = label, style = MaterialTheme.typography.headlineSmall) }
        content?.let { content.invoke(this) }
    }
}