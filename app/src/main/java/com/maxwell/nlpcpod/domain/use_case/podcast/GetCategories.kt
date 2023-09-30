package com.maxwell.nlpcpod.domain.use_case.podcast

import com.maxwell.nlpcpod.domain.repository.GetCategoriesResponse
import com.maxwell.nlpcpod.domain.repository.PodcastRepository

class GetCategories(private val podcastRepository: PodcastRepository) {

    suspend operator fun invoke():GetCategoriesResponse=podcastRepository.getCategories()
}