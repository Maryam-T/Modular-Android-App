package com.marand.remote.response
/**
 * A generic class for data state management
 */
sealed class ResponseWrapper<out T> {

    data class Success<out T>(val data: T?) : ResponseWrapper<T>()
    data class Error(val exception: Exception? = null, val errorMessage: String?) :
        ResponseWrapper<Nothing>()
    class Complete : ResponseWrapper<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Complete -> "Complete"
        }
    }
}