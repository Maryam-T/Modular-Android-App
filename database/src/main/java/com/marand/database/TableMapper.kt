package com.marand.database

import com.marand.data.DataModel

interface TableMapper<T: Table, D: DataModel> {

    fun mapToData(table: T): D

    fun mapToTable(data: D): T
}