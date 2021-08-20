package com.marand.presentation.main.post.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.marand.domain.post.interactor.GetUserPostListUseCase
import com.marand.domain.post.request.GetUserPostsRequest
import com.marand.presentation.AbstractViewModel
import com.marand.presentation.main.post.model.PostItemView
import com.marand.presentation.main.post.model.PostPresentationMapper
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val getUserPostListUseCase: GetUserPostListUseCase,
    private val postPresentationMapper: PostPresentationMapper
) : AbstractViewModel<PostState>() {

    private var state: PostState = PostState.Init
        set(value) {
            field = value
            publishState(value)
        }

    var userPostList = MutableLiveData<List<PostItemView>>()

    fun getUserPostList(userId: Int) {
        getUserPostListUseCase.invoke(GetUserPostsRequest(userId), viewModelScope) {
            onStart = {
                state = PostState.Loading
            }
            onSuccess = { useCaseResult ->
                state = PostState.Success(
                    useCaseResult.data.map {
                        postPresentationMapper.toPresentation(it)
                    }
                )
            }
            onError = {
                state = PostState.Error(it.message)
            }
        }
    }

    override val stateObservable: MutableLiveData<PostState> by lazy {
        MutableLiveData<PostState>()
    }
}
