package com.example.github.di.network

import com.example.components.extensions.create
import com.example.features.repositories.data.api.RepositoriesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

	@Provides
	@Singleton
	fun provideRepositoriesApi(retrofit: Retrofit): RepositoriesApi =
		retrofit.create()
}