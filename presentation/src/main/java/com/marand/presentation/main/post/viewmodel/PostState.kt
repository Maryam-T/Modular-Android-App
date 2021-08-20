package com.marand.presentation.main.post.viewmodel

import com.marand.presentation.main.post.model.PostItemView

sealed class PostState {
    object Init : PostState()
    object Loading : PostState()
    data class Error(var message : String?) : PostState()
    data class Success(var posts: List<PostItemView>) : PostState()
}
