package com.example.features.repositories.data.repository

import com.example.features.repositories.data.datasource.RepositoriesDataSource
import com.example.features.repositories.domain.entity.Repository
import io.reactivex.Single
import javax.inject.Inject

class RepositoriesRepository @Inject constructor(private val dataSource: RepositoriesDataSource) {

	fun get(): Single<List<Repository>> =
		dataSource.get()
}