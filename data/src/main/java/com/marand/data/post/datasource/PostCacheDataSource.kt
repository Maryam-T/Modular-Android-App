package com.marand.data.post.datasource

import com.marand.data.post.model.PostDataModel

interface PostCacheDataSource {

    suspend fun writeUserPostList(postList: List<PostDataModel>)

    suspend fun readUserPostList(userId: Int): List<PostDataModel>
}