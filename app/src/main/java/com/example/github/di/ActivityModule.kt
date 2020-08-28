package com.example.github.di

import com.example.features.repositories.ui.RepositoriesFragment
import com.example.github.di.navigation.NavigationModule
import com.example.github.di.network.ApiModule
import com.example.github.di.network.NetworkModule
import com.example.github.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(
	includes = [
		AndroidSupportInjectionModule::class,
		NetworkModule::class,
		ApiModule::class
	]
)
interface ActivityModule {

	@FragmentScope
	@ContributesAndroidInjector()
	fun contributeRepositoriesFragment(): RepositoriesFragment
}