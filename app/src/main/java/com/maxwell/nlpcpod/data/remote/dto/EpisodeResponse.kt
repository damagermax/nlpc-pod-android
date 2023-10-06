package com.maxwell.nlpcpod.data.remote.dto

import com.maxwell.nlpcpod.domain.model.Episode

data class EpisodeResponse(
    val success: Boolean,
    val episodes: List<Episode>
)
