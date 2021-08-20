package com.marand.database.post

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.marand.database.AppDatabase
import com.marand.database.factory.post.PostsFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class PostDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var postDao: PostDao
    private lateinit var postTableMapper: PostTableMapper

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        postDao = database.postDao()

        postTableMapper = PostTableMapper()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertUsersPost() = runBlockingTest {
        val usersPostList = PostsFactory.generateDummyPostList(2)
        postDao.insertUserPostList(postTableMapper.mapToTableList(usersPostList))

        val userPostList = postDao.queryUserPostList(1).map {
            postTableMapper.mapToData(it)
        }

        assertThat(usersPostList).containsAnyIn(userPostList)
    }
}