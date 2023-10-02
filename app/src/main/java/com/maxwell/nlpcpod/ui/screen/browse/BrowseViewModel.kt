package com.maxwell.nlpcpod.ui.screen.browse

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxwell.nlpcpod.data.remote.dto.SeriesResponse
import com.maxwell.nlpcpod.domain.use_case.podcast.GetAllSeries
import com.maxwell.nlpcpod.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class BrowseViewModel @Inject constructor(private val getAllSeries: GetAllSeries):ViewModel(){

    var state by mutableStateOf<Resource<SeriesResponse>>(Resource.Loading())
        private  set

    init {

        viewModelScope.launch {
            getAllSeries().collectLatest {response-> state=response  }
        }
    }
}