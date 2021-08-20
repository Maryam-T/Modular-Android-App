package com.marand.database.post

import com.marand.data.post.model.PostDataModel
import com.marand.database.TableMapper
import javax.inject.Inject

class PostTableMapper @Inject constructor(

) : TableMapper<PostTable, PostDataModel> {

    override fun mapToData(table: PostTable): PostDataModel =
        PostDataModel(
            table.id,
            table.userId,
            table.title,
            table.body
        )

    override fun mapToTable(data: PostDataModel): PostTable =
        PostTable(
            data.id,
            data.userId,
            data.title,
            data.body
        )

    fun mapToTableList(listPostDataModel: List<PostDataModel>): List<PostTable> {
        return listPostDataModel.map { item -> mapToTable(item) }
    }
}