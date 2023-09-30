package com.maxwell.nlpcpod.data.remote.dto

import com.maxwell.nlpcpod.domain.model.Category

data class CategoryResponse(
    val categories: List<Category>,
    val count: Int,
    val success: Boolean
)