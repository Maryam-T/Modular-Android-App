package com.marand.myapplication.di.layer.presentation.main.post

import androidx.lifecycle.ViewModel
import com.marand.data.post.PostRepositoryImpl
import com.marand.data.post.datasource.PostCacheDataSource
import com.marand.data.post.datasource.PostRemoteDataSource
import com.marand.database.AppDatabase
import com.marand.database.post.PostCacheDataSourceImpl
import com.marand.database.post.PostDao
import com.marand.domain.post.repository.PostRepository
import com.marand.myapplication.di.layer.presentation.key.ViewModelKey
import com.marand.myapplication.di.layer.presentation.scope.main.MainScope
import com.marand.presentation.main.post.viewmodel.PostViewModel
import com.marand.remote.post.api.PostApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class PostModule {

    @Binds
    @MainScope
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun providePostViewModel(viewModel: PostViewModel): ViewModel

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
