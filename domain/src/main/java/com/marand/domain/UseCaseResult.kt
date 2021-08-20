package com.marand.domain

open class UseCaseResult<D>(
    val data: D,
    open val message: String = ""
)