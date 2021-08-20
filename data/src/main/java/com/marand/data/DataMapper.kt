package com.marand.data

import com.marand.domain.Entity

interface DataMapper<D : DataModel, E : Entity> {

    fun mapToEntity(data: D): E
}