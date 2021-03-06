package com.marand.remote.adapter

import com.marand.log.Logger
import com.marand.remote.response.ResponseWrapper
import retrofit2.Response

class SingleCallAdapter<T>(
    private val apiCall: suspend () -> Response<T>,
    private val logger: Logger? = null
) : CallAdapter<ResponseWrapper<T>> {
    override suspend fun execute(): ResponseWrapper<T> {
        try {
            val execute = apiCall.invoke()
            return if (execute.isSuccessful) {
                val response = execute.body()
                if (response == null) {
                    ResponseWrapper.Complete()
                } else {
                    ResponseWrapper.Success(response)
                }
            } else {
                ResponseWrapper.Error(
                    errorMessage = execute.errorBody()?.toString() ?: execute.message()
                )
            }

        } catch (exception: Exception) {
            logger?.error("SingleCallAdapter", exception.message.toString())
            return ResponseWrapper.Error(exception, exception.message)
        }
    }
}