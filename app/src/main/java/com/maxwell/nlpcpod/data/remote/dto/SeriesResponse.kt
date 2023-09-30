package com.maxwell.nlpcpod.data.remote.dto

import com.maxwell.nlpcpod.domain.model.Series

data class SeriesResponse(
    val count: Int,
    val series: List<Series>,
    val success: Boolean
)