package com.maxwell.nlpcpod.domain.use_case.podcast

import com.maxwell.nlpcpod.domain.repository.GetSeriesResponse
import com.maxwell.nlpcpod.domain.repository.PodcastRepository

class GetAllSeries(private val podcastRepository: PodcastRepository) {

    suspend operator fun invoke():GetSeriesResponse=podcastRepository.getAllSeries()
}