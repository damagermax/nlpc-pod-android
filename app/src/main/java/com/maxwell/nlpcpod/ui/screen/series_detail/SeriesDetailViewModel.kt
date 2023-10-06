package com.maxwell.nlpcpod.ui.screen.series_detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxwell.nlpcpod.domain.model.Series
import com.maxwell.nlpcpod.domain.use_case.podcast.GetEpisode
import com.maxwell.nlpcpod.utils.Resource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SeriesDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getEpisode: GetEpisode
) : ViewModel() {

    private val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val jsonAdapter = moshi.adapter(Series::class.java)

    var state by mutableStateOf(SeriesDetailState())
        private set

    init {
        savedStateHandle.get<String>("series")?.let { seriesJson ->
            jsonAdapter.fromJson(seriesJson)?.let { series ->
                state = state.copy(series = series)

                getSeriesEpisodes()
            } }
    }


    private  fun  getSeriesEpisodes(){
        viewModelScope.launch {
            getEpisode(state.series._id).collectLatest {response->

                Log.d(SeriesDetailViewModel::class.java.simpleName,response.data?.episodes
                    .toString())
                state = when(response){
                    is Resource.Loading-> state.copy(episodeLoading = true)
                    is Resource.Success-> { state.copy(episodes = response.data?.episodes)}
                    is Resource.Error-> state.copy(episodeErrorMessage = response.message)
                }

            }
        }
    }
}