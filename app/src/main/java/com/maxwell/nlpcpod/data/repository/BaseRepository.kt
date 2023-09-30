package com.maxwell.nlpcpod.data.repository

import com.google.gson.Gson
import com.maxwell.nlpcpod.data.remote.dto.ApiError
import com.maxwell.nlpcpod.utils.Resource
import retrofit2.Response

abstract class BaseRepository {

    fun <T> handleResponse(response: Response<T>): Resource<T> {
        return try {
            if (response.isSuccessful) {
                return Resource.Success(response.body())
            } else {
                if (response.code() in 400..499) {
                    response.errorBody().let {
                        val errorResponse = Gson().fromJson(
                            response.errorBody()?.string(), ApiError::class.java
                        )
                        return Resource.Error(errorResponse.message ?: "Something went wrong!")
                    }
                } else {
                    return Resource.Error(response.message())
                }
            }
        } catch (e: Error) {
            Resource.Error(e.message ?: "Something went wrong!")
        }
    }
}