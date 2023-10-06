package com.maxwell.nlpcpod.ui.screen.series_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxwell.nlpcpod.domain.model.Episode
import com.maxwell.nlpcpod.utils.extensions.formatDate

@Composable
fun EpisodeItem(onClick: () -> Unit, episode: Episode) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = "${episode.createdAt.formatDate()}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelLarge,
            color = Color.LightGray.copy(0.9f)
            , fontSize = 12.sp

        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "${episode.part}.  ${episode.title}",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge
        )
        //Spacer(modifier = Modifier.height(8.dp))


    }

}