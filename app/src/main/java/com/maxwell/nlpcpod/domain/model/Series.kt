package com.maxwell.nlpcpod.domain.model

data class Series(

    val _id: String="",
    val categoryId: String="",
    val createdAt: String="",
    val speaker: String="",
    val status: String="",
    val thumbnail: String="",
    val title: String="",
    val episodeCount:Int=0,
    val updatedAt: String=""
)