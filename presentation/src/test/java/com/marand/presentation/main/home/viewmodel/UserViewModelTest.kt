package com.marand.presentation.main.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.marand.domain.UseCase
import com.marand.domain.UseCaseResult
import com.marand.domain.user.entity.UserEntity
import com.marand.domain.user.interactor.GetUserListUseCase
import com.marand.presentation.factory.user.UsersFactory
import com.marand.presentation.main.home.model.UserItemView
import com.marand.presentation.main.home.model.UserPresentationMapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class UserViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val stateObserver = mockk<Observer<UserState>>(relaxed = true)

    private val getUserListUseCase = mockk<GetUserListUseCase>(relaxed = true)

    private lateinit var userPresentationMapper: UserPresentationMapper

    private lateinit var userViewModel: UserViewModel

    @Before
    fun setUp() {

        userPresentationMapper = UserPresentationMapper()

        userViewModel = UserViewModel(getUserListUseCase, userPresentationMapper)

        userViewModel.stateObservable.observeForever(stateObserver)
    }

    @After
    fun tearDown() {

        userViewModel.stateObservable.removeObserver(stateObserver)
    }

    @Test
    fun `fetch user list, returns data`() {
        //Arrange
        val listOfUsers = UsersFactory.generateListOfUserEntity(5)
        val listOfViews = mutableListOf<UserItemView>()
        listOfUsers.forEach {
            listOfViews.add(userPresentationMapper.toPresentation(it))
        }
        stubFetchUsers(UseCaseResult(listOfUsers))

        //Act
        userViewModel.fetchUserList()

        //Assert
//        coVerify { stateObserver.onChanged(UserState.Init) }
//        coVerify { stateObserver.onChanged(UserState.Loading) }
        coVerify { stateObserver.onChanged(UserState.Success(listOfViews)) }
    }

    /**
     * Stub Helpers Methods
     */
    private fun stubFetchUsers(response: UseCaseResult<List<UserEntity>>) {
        coEvery { getUserListUseCase.run(UseCase.None()) } returns response
    }
}
