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
import com.maxwell.nlpcpod.domain.model.Series
import com.maxwell.nlpcpod.ui.navigation.Screens
import com.maxwell.nlpcpod.ui.screen.browse.composnents.SeriesItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject


@Composable
fun BrowseScreen(
    navigation: NavHostController,
    browseViewModel: BrowseViewModel = hiltViewModel()
) {



//    LaunchedEffect(key1 = browseViewModel.state, block =
//    when(browseViewModel.state.data.s)
//    )
    val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val jsonAdapter=moshi.adapter(Series::class.java)

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Browse",
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(content = {

            browseViewModel.state.data?.series?.let { seriesList ->

                items(items = seriesList, itemContent = { series ->

                    val seriesJson=jsonAdapter.toJson(series)
                    val encode = URLEncoder.encode(seriesJson, StandardCharsets.UTF_8.toString())

                    SeriesItem(onClick = {
                        navigation.navigate(Screens.SeriesDetail.data(encode)) {
                          //  popUpTo(Screens.SeriesDetail.route)
                        }
                    }, series = series)

                    if (seriesList.indexOf(series) != seriesList.lastIndex) Divider(thickness =.5.dp)

                })
            }
        })

    }


}