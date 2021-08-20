package com.marand.remote.adapter

interface CallAdapter<R> {

    suspend fun execute(): R
}