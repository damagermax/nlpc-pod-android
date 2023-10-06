package com.maxwell.nlpcpod.ui.screen.series_detail

import com.maxwell.nlpcpod.domain.model.Episode
import com.maxwell.nlpcpod.domain.model.Series


data class SeriesDetailState(
    val series: Series = Series(),
    val episodeLoading: Boolean = false,
    val episodes: List<Episode>? =null,
    val episodeErrorMessage: String? = null
)

