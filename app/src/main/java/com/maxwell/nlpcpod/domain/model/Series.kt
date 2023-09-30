package com.maxwell.nlpcpod.domain.model

data class Series(
    val __v: Int,
    val _id: String,
    val categoryId: String,
    val createdAt: String,
    val createdBy: CreatedBy,
    val speaker: String,
    val status: String,
    val thumbnail: String,
    val title: String,
    val updatedAt: String
)