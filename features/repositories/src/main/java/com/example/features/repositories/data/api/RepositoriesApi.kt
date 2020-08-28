package com.example.features.repositories.data.api

import com.example.features.repositories.data.model.RepositoryModel
import io.reactivex.Single
import retrofit2.http.GET

interface RepositoriesApi {

	@GET("repositories")
	fun getRepositories(): Single<List<RepositoryModel>>
}