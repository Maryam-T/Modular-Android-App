package com.marand.domain

import kotlinx.coroutines.*

abstract class UseCase<in Params, T>  {

    private var response: UseCaseResponse<T>? =
        UseCaseResponse()

    abstract suspend fun run(params: Params): UseCaseResult<T>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: UseCaseResponse<T>.() -> Unit = {}
    ) {
        response?.let { onResult(it) }
        response?.inProgress = true
        response?.onStart?.invoke()

        scope.launch(Dispatchers.Main) {
            try {
                val deferred = async(Dispatchers.IO) {
                    run(params)
                }
                response?.onSuccess?.invoke(deferred.await())

            } catch (e: Throwable) {
                response?.onError?.invoke(e)
            }
            response?.inProgress = false
            response?.onFinish?.invoke()
        }
    }

    class None
}