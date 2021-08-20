package com.marand.remote.request

import com.marand.domain.Request

interface RequestDtoMapper<in Q: Request, R> {

    fun mapToDto(request: Q): R
}