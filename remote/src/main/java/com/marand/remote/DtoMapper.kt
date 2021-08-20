package com.marand.remote

interface DtoMapper<in T, out D> {

    fun mapToData(dto: T?): D
}