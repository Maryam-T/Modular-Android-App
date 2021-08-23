package com.marand.myapplication.di.layer.presentation.main

import com.marand.data.post.PostRepositoryImpl
import com.marand.data.post.datasource.PostCacheDataSource
import com.marand.data.post.datasource.PostRemoteDataSource
import com.marand.data.user.UserRepositoryImpl
import com.marand.data.user.datasource.UserRemoteDataSource
import com.marand.database.AppDatabase
import com.marand.database.post.PostCacheDataSourceImpl
import com.marand.database.post.PostDao
import com.marand.domain.post.repository.PostRepository
import com.marand.domain.user.repository.UserRepository
import com.marand.remote.post.api.PostApiService
import com.marand.remote.user.api.UserApiService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule {

    @Binds
    @MainScope
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @MainScope
    abstract fun bindUserRemoteDataSource(userApiService: UserApiService): UserRemoteDataSource

    @Binds
    @MainScope
    abstract fun bindPostRepository(userRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    @MainScope
    abstract fun bindPostRemoteDataSource(postApiService: PostApiService): PostRemoteDataSource

    @Binds
    @MainScope
    abstract fun bindPostCacheDataSource(postCacheDataSourceImpl: PostCacheDataSourceImpl): PostCacheDataSource

    companion object {

        @Provides
        @MainScope
        fun providePostDao(appDatabase: AppDatabase): PostDao {
            return appDatabase.postDao()
        }
    }
}