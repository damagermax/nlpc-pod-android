package com.maxwell.nlpcpod.ui.screen.browse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavHostController
import com.maxwell.nlpcpod.ui.navigation.Screens
import com.maxwell.nlpcpod.ui.screen.browse.composnents.SeriesItem


@Composable
fun BrowseScreen(
    navigation: NavHostController,
    browseViewModel: BrowseViewModel = hiltViewModel()
) {


//    LaunchedEffect(key1 = browseViewModel.state, block =
//    when(browseViewModel.state.data.s)
//    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Browse", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(content = {
            browseViewModel.state.data?.series?.let { seriesList ->
                items(items = seriesList, itemContent = { series ->
                    SeriesItem(onClick = {
                        navigation.navigate(Screens.SeriesDetail.route) {
                            popUpTo(Screens.SeriesDetail.route)
                        }
                    }, series = series)

                    if (seriesList.indexOf(series) != seriesList.lastIndex) Divider()

                })
            }
        })

    }


}