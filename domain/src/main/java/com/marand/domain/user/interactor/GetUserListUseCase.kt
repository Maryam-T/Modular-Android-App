package com.marand.domain.user.interactor

import com.marand.domain.UseCase
import com.marand.domain.UseCase.None
import com.marand.domain.UseCaseResult
import com.marand.domain.user.entity.UserEntity
import com.marand.domain.user.repository.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<None, List<UserEntity>>() {

    override suspend fun run(params: None): UseCaseResult<List<UserEntity>> =
        UseCaseResult(userRepository.getUsers())
}