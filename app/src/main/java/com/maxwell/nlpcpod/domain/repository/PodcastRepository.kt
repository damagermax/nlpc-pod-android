package com.maxwell.nlpcpod.domain.repository

import com.maxwell.nlpcpod.data.remote.dto.CategoryResponse
import com.maxwell.nlpcpod.data.remote.dto.SeriesResponse
import com.maxwell.nlpcpod.utils.Resource
import kotlinx.coroutines.flow.Flow

typealias GetCategoriesResponse = Flow<Resource<CategoryResponse>>
typealias GetEpisodesResponse = Flow<Resource<CategoryResponse>>
typealias GetSeriesResponse = Flow<Resource<SeriesResponse>>

interface PodcastRepository {

    suspend fun getCategories():GetCategoriesResponse
    suspend fun getAllSeries():GetSeriesResponse
    suspend fun getSeries(categoryId: String):GetSeriesResponse
    suspend fun getEpisodes(seriesId: String):GetEpisodesResponse
}