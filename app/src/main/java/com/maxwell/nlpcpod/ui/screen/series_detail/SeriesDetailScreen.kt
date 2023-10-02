package com.maxwell.nlpcpod.ui.screen.series_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.maxwell.nlpcpod.ui.common.ContainedButton
import com.maxwell.nlpcpod.ui.common.ImageView
import com.maxwell.nlpcpod.ui.theme.Red300
import com.maxwell.nlpcpod.utils.extensions.formatDate

val img =
    "http://res.cloudinary.com/dh5pvzxlw/image/upload/v1696245938/podcast/thumbnail/651aa8b1d40372a5a56e745a.jpg"


@Composable
fun SeriesDetail() {

    val width = Modifier.fillMaxWidth(0.5f)

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Red300.copy(alpha = 0.2f)),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 64.dp, bottom = 32.dp),
                horizontalAlignment = Alignment
                    .CenterHorizontally
            ) {
                ImageView(
                    imageUrl = img,
                    description = "",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "The Internet's First Main Character? | The " +
                            "Redemption of Jar Jar Binks",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center

                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${"Sunday Service"}  - 15 Episodes",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.LightGray.copy(0.9f)
                )

                Spacer(modifier = Modifier.height(32.dp))

                ContainedButton(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    onClick = { /*TODO*/ },
                    content = {
                        
                        Icon(imageVector = Icons.Filled.PlayCircle, contentDescription = "play")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Play all", style = MaterialTheme.typography.titleLarge)
                    },
                    contentPadding = 10.dp,
                    shape = MaterialTheme.shapes.medium
                )
            }

        }

    }


}