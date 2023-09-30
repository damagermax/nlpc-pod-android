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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxwell.nlpcpod.domain.model.Series
import com.maxwell.nlpcpod.ui.common.ImageView

@Composable
fun SeriesItem(onClick:()->Unit,series: Series) {



    Column(modifier = Modifier.fillMaxWidth().height(112.dp).clickable { onClick() }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                ImageView(imageUrl =series.thumbnail , description = series.title, modifier = Modifier.size(80.dp))

                Column(modifier = Modifier.fillMaxWidth().height(70.dp), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = series.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "${series.createdAt} - ${series.episodeCount} Episodes",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.LightGray.copy(0.9f)
                    )

                }
            }
        }


    }

}

