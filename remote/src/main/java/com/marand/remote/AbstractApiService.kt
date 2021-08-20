package com.marand.remote

import com.marand.remote.adapter.SingleCallAdapter
import com.marand.remote.response.ResponseWrapper
import com.marand.remote.response.Result
import retrofit2.Retrofit
import javax.inject.Inject
import retrofit2.Response

abstract class AbstractApiService<S> constructor(
    private val serviceClass: Class<S>
) : API<S> {

    @Inject
    lateinit var retrofit: Retrofit

    override val apiService: S by lazy {
        create()
    }

    private fun create(): S {
        return retrofit.create(serviceClass)
    }

    protected suspend fun <T> execution(apiCall: suspend () -> Response<T>): Result<T> {
        return when (val adapter = SingleCallAdapter(apiCall).execute()) {
            is ResponseWrapper.Success -> Result(adapter.data)
            is ResponseWrapper.Error -> throw  adapter.exception!!
            is ResponseWrapper.Complete -> Result()
            else -> throw IllegalStateException()
        }
    }
}
