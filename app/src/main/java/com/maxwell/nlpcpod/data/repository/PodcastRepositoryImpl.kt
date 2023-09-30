package com.maxwell.nlpcpod.data.repository

import com.maxwell.nlpcpod.data.remote.PodcastApi
import com.maxwell.nlpcpod.domain.repository.GetCategoriesResponse
import com.maxwell.nlpcpod.domain.repository.GetEpisodesResponse
import com.maxwell.nlpcpod.domain.repository.GetSeriesResponse
import com.maxwell.nlpcpod.domain.repository.PodcastRepository
import com.maxwell.nlpcpod.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PodcastRepositoryImpl(private val podcastApi: PodcastApi) : PodcastRepository, BaseRepository() {
    override suspend fun getCategories(): GetCategoriesResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(podcastApi.getCategories())
        emit(response)
    }

    override suspend fun getAllSeries(): GetSeriesResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(podcastApi.getAllSeries())
        emit(response)
    }

    override suspend fun getSeries(categoryId: String): GetSeriesResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(podcastApi.getSeries(categoryId))
        emit(response)
    }

    override suspend fun getEpisodes(seriesId: String): GetEpisodesResponse = flow {
        emit(Resource.Loading())
        val response = handleResponse(podcastApi.getEpisodes(seriesId))
        emit(response)
    }


}