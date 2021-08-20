package com.marand.domain.user.interactor

import com.google.common.truth.Truth.assertThat
import com.marand.domain.MainCoroutineRule
import com.marand.domain.UseCase
import com.marand.domain.factory.user.UsersFactory
import com.marand.domain.user.entity.UserEntity
import com.marand.domain.user.repository.UserRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.mockk.coEvery
import io.mockk.coVerify
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetUserListUseCaseTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val userRepository = mock<UserRepository>()

    private lateinit var getUserListUseCase: GetUserListUseCase

    @Before
    fun setUp() {

        getUserListUseCase = GetUserListUseCase(userRepository)
    }

    @Test
    fun `getUserListUseCase calls repository`() = mainCoroutineRule.runBlockingTest {
        // Arrange
        // No arrangement for this test case

        //Act
        getUserListUseCase.run(UseCase.None())

        //Assert
        verify(userRepository).getUsers()
    }

    @Test
    fun `getUserListUseCase, returns data`() = mainCoroutineRule.runBlockingTest {
        //Arrange
        val userList = UsersFactory.generateDummyUserList(1)
        stubUserRepositoryGetUsers(userList)

        //Act
        val result = getUserListUseCase.run(UseCase.None())

        //Assert
        assertNotNull(result)

        assertEquals("username", result.data[0].username)
        assertEquals("name", result.data[0].name)
        assertEquals("email", result.data[0].email)
    }

    /**
     * Stub Helpers Methods
     */
    private fun stubUserRepositoryGetUsers(data: List<UserEntity>) = mainCoroutineRule.runBlockingTest {
        whenever(userRepository.getUsers())
            .thenReturn(data)
    }
}
