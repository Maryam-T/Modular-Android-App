package com.marand.presentation.main.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.marand.domain.UseCase.None
import com.marand.domain.user.interactor.GetUserListUseCase
import com.marand.presentation.AbstractViewModel
import com.marand.presentation.main.home.model.UserPresentationMapper
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val userPresentationMapper: UserPresentationMapper
) : AbstractViewModel<UserState>() {

    private var state: UserState = UserState.Init
        set(value) {
            field = value
            publishState(value)
        }

    fun fetchUserList() {
        getUserListUseCase.invoke(None(), viewModelScope) {
            onStart = {
                state = UserState.Loading
            }
            onSuccess = { useCaseResult ->
                state = UserState.Success(
                    useCaseResult.data.map {
                        userPresentationMapper.toPresentation(it)
                    }
                )
            }
            onError = {
                state = UserState.Error(it.message)
            }
        }
    }

    override val stateObservable: MutableLiveData<UserState> by lazy {
        MutableLiveData<UserState>()
    }
}
