package com.maxwell.nlpcpod.data.remote

import com.maxwell.nlpcpod.data.remote.dto.CategoryResponse
import com.maxwell.nlpcpod.data.remote.dto.EpisodeResponse
import com.maxwell.nlpcpod.data.remote.dto.SeriesResponse
import com.maxwell.nlpcpod.utils.Constant.ALL_SERIES
import com.maxwell.nlpcpod.utils.Constant.CATEGORIES
import com.maxwell.nlpcpod.utils.Constant.CATEGORIES_SERIES
import com.maxwell.nlpcpod.utils.Constant.CATEGORY_ID
import com.maxwell.nlpcpod.utils.Constant.SERIES_EPISODES
import com.maxwell.nlpcpod.utils.Constant.SERIES_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PodcastApi {

    @GET(CATEGORIES)
    suspend fun getCategories():Response<CategoryResponse>

    @GET(ALL_SERIES)
    suspend fun getAllSeries():Response<SeriesResponse>

    @GET(CATEGORIES_SERIES)
    suspend fun getCategorySeries(@Path(CATEGORY_ID) categoryId:String):Response<SeriesResponse>

    @GET(SERIES_EPISODES)
    suspend fun getEpisodes(@Path(SERIES_ID) seriesId:String):Response<EpisodeResponse>
}