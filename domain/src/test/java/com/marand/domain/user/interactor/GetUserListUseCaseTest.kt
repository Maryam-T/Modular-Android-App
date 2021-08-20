package com.marand.domain.user.interactor

import com.marand.domain.MainCoroutineRule
import com.marand.domain.UseCase
import com.marand.domain.factory.user.UsersFactory
import com.marand.domain.user.entity.UserEntity
import com.marand.domain.user.repository.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class GetUserListUseCaseTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val userRepository = mockk<UserRepository>()

    private lateinit var getUserListUseCase: GetUserListUseCase

    @Before
    fun setUp() {

        getUserListUseCase = GetUserListUseCase(userRepository)
    }

    @Test
    fun `getUserListUseCase, calls repository`() = mainCoroutineRule.runBlockingTest {
        // Arrange
        //coEvery is mandatory because you need to provide a response to the Mock object
        stubUserRepositoryGetUsers(listOf())

        //Act
        getUserListUseCase.run(UseCase.None())

        //Assert
        //Use coVerify to verify if a method is called
        coVerify { userRepository.getUsers() }
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
    private fun CoroutineScope.stubUserRepositoryGetUsers(data: List<UserEntity>) {
        //Use coEvery to mock a response of a method
        coEvery { userRepository.getUsers() } returns data
    }
}
