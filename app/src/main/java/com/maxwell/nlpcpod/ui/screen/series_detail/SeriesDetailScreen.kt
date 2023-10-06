package com.maxwell.nlpcpod.ui.screen.series_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.maxwell.nlpcpod.ui.screen.series_detail.components.EpisodeItem
import com.maxwell.nlpcpod.ui.screen.series_detail.components.SeriesDetail


@Composable
fun SeriesDetailScreen(
    viewModel: SeriesDetailViewModel = hiltViewModel(),
    state: SeriesDetailState = viewModel.state
) {


    Column(modifier = Modifier.fillMaxSize()) {

        SeriesDetail(state.series)

        Text(
            text = "Episodes", style = MaterialTheme.typography.headlineSmall, modifier =
            Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )


        state.episodes?.let {listOfEpisodes->

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                content = {
                    items(items =listOfEpisodes) {episode->
                        Divider(thickness = 0.5.dp)
                        EpisodeItem(onClick = { /*TODO*/ }, episode =episode)
                    }
                })
        }



    }


}