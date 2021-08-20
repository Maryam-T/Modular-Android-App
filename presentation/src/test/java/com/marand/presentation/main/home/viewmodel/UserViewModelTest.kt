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
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.mockk.coVerify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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

    private val stateObserver = mock<Observer<UserState>>()

    private val getUserListUseCase = mock<GetUserListUseCase>()

    private lateinit var userPresentationMapper: UserPresentationMapper

    private lateinit var userViewModel: UserViewModel

//    private val receivedUserStates = mutableListOf<UserState>()


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

//        observeViewModel(userViewModel)

//        assertTrue(receivedUserStates.isEmpty())

        //Act
        userViewModel.fetchUserList()


        /*assertEquals(
            listOf(
                UserState.Loading,
                UserState.Success(listOfViews)
            ),
            receivedUserStates
        )*/

        //Assert
        coVerify { stateObserver.onChanged(UserState.Loading) }
//        verify(stateObserver).onChanged(UserState.Loading)
        coVerify { stateObserver.onChanged(UserState.Success(listOfViews)) }
//        verify(stateObserver).onChanged(UserState.Success(listOfViews))
    }

    /**
     * Stub Helpers Methods
     */
    private fun stubFetchUsers(response: UseCaseResult<List<UserEntity>>) = runBlockingTest {
        whenever(getUserListUseCase.run(UseCase.None()))
            .thenReturn(response)
    }

    /*private fun observeViewModel(viewModel: UserViewModel) {
        viewModel.stateObservable.observeForever { userState ->
            if (userState != null) {
                receivedUserStates.add(userState)
            }
        }
    }*/
}
