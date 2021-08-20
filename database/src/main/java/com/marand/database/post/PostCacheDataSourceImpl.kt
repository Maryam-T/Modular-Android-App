package com.marand.database.post

import com.marand.data.post.datasource.PostCacheDataSource
import com.marand.data.post.model.PostDataModel
import javax.inject.Inject

class PostCacheDataSourceImpl @Inject constructor(
    private val postDao: PostDao,
    private val postTableMapper: PostTableMapper
) : PostCacheDataSource {

    override suspend fun writeUserPostList(postList: List<PostDataModel>) {
        postDao.insertUserPostList(postTableMapper.mapToTableList(postList))
    }

    override suspend fun readUserPostList(userId: Int): List<PostDataModel> {
        return postDao.queryUserPostList(userId).map { postTable ->
            postTableMapper.mapToData(postTable)
        }
    }
}
