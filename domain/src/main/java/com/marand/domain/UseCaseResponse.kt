package com.marand.domain

data class UseCaseResponse<T>(
    var inProgress: Boolean = false,
    var onSuccess: ((result: UseCaseResult<T>) -> Unit)? = null,
    var onError: ((exception: Throwable) -> Unit)? = null,
    var onFinish: (() -> Unit)? = null,
    var onStart:(() -> Unit)? = null
)
