package com.marand.remote.adapter

import com.example.log.Log
import com.marand.remote.response.ResponseWrapper
import retrofit2.Response
import java.util.concurrent.TimeoutException

class SingleCallAdapter<T>(
    private val apiCall: suspend () -> Response<T>,
    private val log: Log? = null
) :
    CallAdapter<ResponseWrapper<T>> {

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

        } catch (exception: TimeoutException) {
            return ResponseWrapper.Error(exception, exception.message)
        } catch (exception: Exception) {
            return ResponseWrapper.Error(exception, exception.message)
        }
    }
}