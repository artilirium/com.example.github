package com.example.features.repositories.data.datasource

import com.example.features.repositories.data.api.RepositoriesApi
import com.example.features.repositories.data.converter.RepositoryConverter
import com.example.features.repositories.domain.entity.Repository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoriesDataSource @Inject constructor(
	private val api: RepositoriesApi,
	private val repositoryConverter: RepositoryConverter
) {

	fun get(): Single<List<Repository>> =
		api.getRepositories()
			.subscribeOn(Schedulers.io())
			.map { it.map(repositoryConverter::convert) }
}