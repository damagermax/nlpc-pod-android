package com.maxwell.nlpcpod.domain.model

data class Episode(
    val _id: String,
    val createdAt: String,
    val createdBy: String,
    val duration: String,
    val note: String,
    val part: Int,
    val seriesId: String,
    val status: String,
    val title: String,
    val updatedAt: String
)