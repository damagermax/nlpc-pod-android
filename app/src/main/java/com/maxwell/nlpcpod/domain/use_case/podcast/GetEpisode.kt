package com.maxwell.nlpcpod.domain.use_case.podcast

import com.maxwell.nlpcpod.domain.repository.GetEpisodesResponse
import com.maxwell.nlpcpod.domain.repository.PodcastRepository

class GetEpisode (private val podcastRepository: PodcastRepository) {

    suspend operator fun invoke(seriesId:String):GetEpisodesResponse=podcastRepository.getEpisodes(seriesId)

}