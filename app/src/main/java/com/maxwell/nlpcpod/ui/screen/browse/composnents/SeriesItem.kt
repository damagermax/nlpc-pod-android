package com.maxwell.nlpcpod.ui.screen.browse.composnents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.maxwell.nlpcpod.domain.model.Series
import com.maxwell.nlpcpod.ui.common.ImageView
import com.maxwell.nlpcpod.utils.extensions.formatDate

@Composable
fun SeriesItem(onClick: () -> Unit, series: Series) {

    Column(modifier = Modifier.fillMaxWidth().height(100.dp).clickable { onClick() },
        verticalArrangement = Arrangement.Center) {

        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
            ImageView(imageUrl = series.thumbnail, description = series.title, modifier = Modifier.size(70.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.fillMaxWidth().height(70.dp)) {
                Text(
                    text = series.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )
                //Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${series.createdAt.formatDate()} - ${series.episodeCount} Episodes",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.LightGray.copy(0.9f)
                )

            }
        }

    }

}

