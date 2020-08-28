package com.example.features.repositories.domain.usecase

import com.example.features.repositories.data.repository.RepositoriesRepository
import com.example.features.repositories.domain.entity.Repository
import io.reactivex.Single
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(private val repository: RepositoriesRepository) {

	operator fun invoke(): Single<List<Repository>> =
		repository.get()
}