package com.marand.database.factory.post

import com.marand.data.post.model.PostDataModel

object PostsFactory {

    fun generateDummyPostList(size: Int): List<PostDataModel> {
        val postList = mutableListOf<PostDataModel>()
        repeat(size) {
            postList.add(generatePost(it))
        }
        return postList
    }

    private fun generatePost(index: Int): PostDataModel {
        return PostDataModel(index, index, "title", "body")
    }
}