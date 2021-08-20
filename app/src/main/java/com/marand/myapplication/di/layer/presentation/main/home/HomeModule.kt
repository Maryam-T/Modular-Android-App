package com.marand.myapplication.di.layer.presentation.main.home

import androidx.lifecycle.ViewModel
import com.marand.data.user.UserRepositoryImpl
import com.marand.data.user.datasource.UserRemoteDataSource
import com.marand.domain.user.repository.UserRepository
import com.marand.myapplication.di.layer.presentation.key.ViewModelKey
import com.marand.myapplication.di.layer.presentation.scope.main.MainScope
import com.marand.presentation.main.home.viewmodel.UserViewModel
import com.marand.remote.user.api.UserApiService
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @MainScope
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun provideUserViewModel(viewModel: UserViewModel): ViewModel

    @Binds
    @MainScope
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @MainScope
    abstract fun bindUserRemoteDataSource(userApiService: UserApiService): UserRemoteDataSource
}