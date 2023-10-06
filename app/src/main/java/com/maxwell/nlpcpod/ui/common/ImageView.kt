package com.maxwell.nlpcpod.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImageView(
    imageUrl:String?,
    description:String,
    scale:ContentScale=ContentScale.Crop,
    modifier:Modifier=Modifier
) {
    AsyncImage(
        model =imageUrl?:"" ,
        contentDescription = description,
        contentScale = scale,
        modifier = modifier.clip(MaterialTheme.shapes.small),
    )

}